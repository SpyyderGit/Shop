package ua.com.dao.impl;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import ua.com.dao.ProductViewDao;
import ua.com.model.ProductType;
import ua.com.model.ProductView;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 18.05.2017.
 */
public class ProductViewDaoImpl implements ProductViewDao {
    JdbcTemplate jdbcTemplate;


    //    SQL
    private final String SQL_ADD_VIEW = "INSERT INTO product_view(type_name) VALUES(?)";
    private final String SQL_DELETE_VIEW = "DELETE FROM product_view WHERE view_id = ?";
    private final String SQL_UPDATE_VIEW = "UPDATE product_view SET view_name = ? WHERE view_id = ?";
    private final String SQL_GET_BY_ID = "SELECT * FROM product_view WHERE view_id = ?";
    private final String SQL_GET_BY_NAME = "SELECT * FROM product_view WHERE name = ?";
    private final String SQL_GET_ALL = "select * from product_view";

    public ProductViewDaoImpl(JdbcTemplate jdbcTemplate) {

        this.jdbcTemplate = jdbcTemplate;
    }

    public void addProductView(ProductView product) {
        jdbcTemplate.update(SQL_ADD_VIEW, product.getProductName());
    }

    public void deleteProductView(ProductView product) {
        jdbcTemplate.update(SQL_DELETE_VIEW, product.getProductId());
    }

    public void updateProductView(ProductView productView) {
        jdbcTemplate.update(SQL_UPDATE_VIEW, productView.getProductId());
    }

    public ProductView getById(int id) {
        ProductView productView = jdbcTemplate.queryForObject(SQL_GET_BY_ID, new Object[]{id}, new RowMapView());
        return productView;
    }

    public List<ProductView> getByName(String name) {
        List<ProductView> views = jdbcTemplate.query(SQL_GET_BY_NAME, new Object[]{name}, new RowMapView());
        return views;
    }

    public List<ProductView> getAll() {
        List<ProductView> views = jdbcTemplate.query(SQL_GET_ALL, new RowMapView());
        return views;
    }
}


class RowMapView implements RowMapper<ProductView> {

    @Override
    public ProductView mapRow(ResultSet rs, int i) throws SQLException {
        ProductView productView = new ProductView();
        productView.setProductId(rs.getInt("view_id"));
        productView.setProductName(rs.getString("view_name"));
        return productView;
    }
}
