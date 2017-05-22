package ua.com.dao.impl;


import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;
import ua.com.dao.ProductDao;
import ua.com.model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 18.05.2017.
 */
public class ProductDaoImpl implements ProductDao {

    private static final Logger log = Logger.getLogger(ProductMrDaoImpl.class);
    private Connection connection;
    private PreparedStatement statement = null;
    private Product product = null;

    private final String SQL_UPDATE = "update product " +
            "set name = ?,price = ?,remark = ?,sklad = ?, fk_id_mr = ?, fk_id_type = ?" +
            " WHERE product_id = ?";

    private final String SQL_DELETE = "DELETE FROM product where product_id = ?";
    private final String SQL_INSERT = "INSERT INTO product(name,price,remark," +
            "sklad,fk_id_mr," +
            "fk_id_type) " +
            "VALUES(?,?,?,?,?,?)";

    private final String SQL_GET_BY_ID = "SELECT * FROM product WHERE product_id = ?";
    private final String SQL_GET_BY_NAME = "SELECT * FROM product WHERE name = ?";
    private final String SQL_GET_BY_PRICE = "SELECT * FROM product WHERE price = ?";
    private final String SQL_GET_ALL = "SELECT * FROM product";
    private JdbcTemplate jdbcTemplate;


    public ProductDaoImpl(Connection connection, JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.connection = connection;
    }

    public ProductDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public ProductDaoImpl() {
    }

    public void addProduct(String productName, double productPrice, String productRemark,
                           String sklad, int mrIdFk, int typeIdFk) throws SQLException {
        try {
            statement = connection.prepareStatement(SQL_INSERT);
            statement.setString(1, productName);
            statement.setDouble(2, productPrice);
            statement.setString(3, productRemark);
            statement.setString(4, sklad);
            statement.setInt(5, mrIdFk);
            statement.setInt(6, typeIdFk);
            statement.executeUpdate();
            log.info("Add product " + productName + " successfull");

        } catch (SQLException e) {
            log.error("Product isn't add\n");
            e.printStackTrace();
        } finally {
            connection.close();
        }
    }


    public void deleteProduct(int id) {
        jdbcTemplate.update(SQL_DELETE, id);
        log.info("Product " + id + " deleted");
    }

    public void updateProduct(Product product) {
        jdbcTemplate.update(SQL_UPDATE, product.getProductName(), product.getProductPrice(), product.getProductRemark(),
                product.getSklad(), product.getMrIdFk(), product.getTypeIdFk(), product.getProductId());
        log.info("Product " + product + " updates");
    }

    public Product getById(int id) throws SQLException {
        try {
            statement = connection.prepareStatement(SQL_GET_BY_ID);
            statement.setInt(1, id);
            ResultSet set = statement.executeQuery();
            set.next();
            product = new Product(set.getInt("product_id"), set.getString("name"),
                    set.getDouble("price"), set.getString("remark"),
                    set.getString("sklad"), set.getInt("fk_id_mr"),
                    set.getInt("fk_id_type"));

            log.info("Product with id " + product.getProductId() + " finded");

        } catch (SQLException e) {
            log.error("Product isn't find");
        } finally {
            connection.close();
        }

        return product;
    }

    public Product getByName(String name) throws SQLException {

        try {
            statement = connection.prepareStatement(SQL_GET_BY_NAME);
            statement.setString(1, name);
            ResultSet set = statement.executeQuery();
            set.next();
            product = new Product(set.getInt("product_id"), set.getString("name"),
                    set.getDouble("price"), set.getString("remark"),
                    set.getString("sklad"), set.getInt("fk_id_mr"),
                    set.getInt("fk_id_type"));
            log.info("Product " + product + " is find");
        } catch (SQLException e) {
            log.error("Product " + name + " isn't find");
        } finally {
            connection.close();
        }

        return product;
    }

    public List<Product> getByPrice(double price) {
        List<Product> productList = new ArrayList<>();
        try {
            statement = connection.prepareStatement(SQL_GET_BY_PRICE);
            statement.setDouble(1, price);
            ResultSet set = statement.executeQuery();
            while (set.next()) {
                productList.add(new Product(set.getInt("product_id"), set.getString("name"),
                        set.getDouble("price"), set.getString("remark"),
                        set.getString("sklad"), set.getInt("fk_id_mr"),
                        set.getInt("fk_id_type")));
            }
            log.info("Price:  " + price + " finded " + productList.size() + " products");
        } catch (SQLException e) {
            log.error("Products with price:  " + price + " isn't find");
        }

        return productList;
    }

    public List<Product> getAllProducts() {
        List<Product> productList = new ArrayList<>();
        try {
            statement = connection.prepareStatement(SQL_GET_ALL);
            ResultSet set = statement.executeQuery();
            while (set.next()) {
                productList.add(new Product(set.getInt("product_id"), set.getString("name"),
                        set.getDouble("price"), set.getString("remark"),
                        set.getString("sklad"), set.getInt("fk_id_mr"),
                        set.getInt("fk_id_type")));
            }
            log.info(productList.size() + " products finded");
        } catch (SQLException e) {
            log.error("is empty");
        }

        return productList;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {

        this.jdbcTemplate = jdbcTemplate;
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }
}
