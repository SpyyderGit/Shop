package ua.com.dao.impl;


import org.apache.log4j.Logger;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import ua.com.dao.ProductMrDao;
import ua.com.model.Product;
import ua.com.model.ProductMr;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 18.05.2017.
 */
public class ProductMrDaoImpl implements ProductMrDao {

    private JdbcTemplate jdbcTemplate;
    private static final Logger log = Logger.getLogger(ProductDaoImpl.class);

    public ProductMrDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // SQL-Scripts
    private final String SQL_ADD_MR = "INSERT INTO manufacturer(mr_name) values(?)";
    private final String SQL_DELETE_MR = "DELETE FROM manufacturer where mr_id = ?";
    private final String SQL_UPDATE_MR = "UPDATE manufacturer " +
            "SET mr_name = ?" +
            " where mr_id = ?";
    private final String SQL_GET_ID = "select * from manufacturer where mr_id = ?";
    private final String SQL_GET_NAME = "select * from manufacturer where mr_name = ?";
    private final String SQL_GET_ALL = "select * from manufacturer";


    public void addProductMr(String productMr) {
        jdbcTemplate.update(SQL_ADD_MR, productMr);
        log.info("Add manufature " + productMr + " successfull");
    }

    public void deleteProductMr(int mrId) {
        try {
            jdbcTemplate.update(SQL_DELETE_MR, mrId);
            log.info("delete manufature with id: " + mrId + " successfull");
        } catch (DataIntegrityViolationException exception) {
            log.error("Cannot delete or update a parent row: a foreign key constraint fails");
        }
    }

    public void updateProductMr(ProductMr product) {
        jdbcTemplate.update(SQL_UPDATE_MR, product.getMrName(), product.getMrId());
        log.info("Update " + product + " successfull");
    }

    public ProductMr getById(int id) {
        ProductMr mr = null;
        try {
            mr = jdbcTemplate.queryForObject(SQL_GET_ID, new Object[]{id}, new ProductMrMaper());
            log.info(mr + " found");
        } catch (EmptyResultDataAccessException e) {
            log.error("ID manufatcure" + id + " not found");
        }
        return mr;
    }


    public List<ProductMr> getByName(String name) {
        List<ProductMr> mrList = jdbcTemplate.query(SQL_GET_NAME, new Object[]{name}, new ProductMrMaper());
        return mrList;
    }


    public List<ProductMr> getAllName() {
        List<ProductMr> mrList = jdbcTemplate.query(SQL_GET_ALL, new ProductMrMaper());
        return mrList;
    }
}

class ProductMrMaper implements RowMapper<ProductMr> {

    @Override
    public ProductMr mapRow(ResultSet resultSet, int i) throws SQLException {
        ProductMr mr = new ProductMr(resultSet.getInt("mr_id"), resultSet.getString("mr_name"));
        return mr;
    }
}