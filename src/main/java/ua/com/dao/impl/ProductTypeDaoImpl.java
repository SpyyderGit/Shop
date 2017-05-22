package ua.com.dao.impl;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import ua.com.dao.ProductTypeDao;
import ua.com.model.ProductType;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by User on 18.05.2017.
 */
public class ProductTypeDaoImpl implements ProductTypeDao {
    private static final Logger log = Logger.getLogger(ProductTypeDaoImpl.class);
    private JdbcTemplate jdbcTemplate;

    //    SQL
    private final String SQL_ADD_TYPE = "INSERT INTO product_type(type_name,fk_id) VALUES(?,?)";
    private final String SQL_DELETE_TYPE = "DELETE FROM product_type WHERE type_id = ?";
    private final String SQL_UPDATE_TYPE = "UPDATE product_type SET type_name = ?, fk_id = ?";
    private final String SQL_GET_BY_NAME = "SELECT * FROM product_type WHERE type_name = ?";
    private final String SQL_GET_BY_ID = "SELECT * FROM product_type WHERE type_id = ?";
    private final String SQL_GET_ALL = "SELECT * FROM product_type";

    public ProductTypeDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void addProductType(ProductType productType) {
        try {
            jdbcTemplate.update(SQL_ADD_TYPE, productType.getTypeName(), productType.getIdView());
        } catch (Exception e) {
            log.error(productType + " isn't add");
        }
    }

    public void deleteProductType(ProductType productType) {
        jdbcTemplate.update(SQL_DELETE_TYPE, productType.getTypeId());
    }

    public void updateProductType(ProductType productType) {
        jdbcTemplate.update(SQL_UPDATE_TYPE, productType.getTypeName(), productType.getIdView());
    }

    public ProductType getById(int id) {
        ProductType productType = null;
        productType = jdbcTemplate.queryForObject(SQL_GET_BY_ID, new Object[]{id}, new TypeRowMap());
        return productType;
    }

    public List<ProductType> getByName(String name) {
        List<ProductType> types = jdbcTemplate.query(SQL_GET_BY_NAME, new Object[]{name}, new TypeRowMap());
        return types;
    }

    public List<ProductType> getAllTypes() {

        List<ProductType> query = jdbcTemplate.query(SQL_GET_ALL, new TypeRowMap());
        return query;
    }
}


class TypeRowMap implements RowMapper<ProductType> {
    @Override
    public ProductType mapRow(ResultSet resultSet, int i) throws SQLException {
        ProductType productType = new ProductType();
        productType.setTypeId(resultSet.getInt("type_id"));
        productType.setTypeName(resultSet.getString("type_name"));
        productType.setIdView(resultSet.getInt("fk_id"));

        return productType;
    }
}