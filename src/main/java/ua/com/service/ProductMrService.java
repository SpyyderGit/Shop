package ua.com.service;

import ua.com.model.Product;
import ua.com.model.ProductMr;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by User on 22.05.2017.
 */
public interface ProductMrService {
    void addProductMrService(String productMr);

    void deleteProductMrService(int idMr);

    void updateProductMrService(ProductMr productMr);

    ProductMr getByIdMrService(int idMr) throws SQLException;

    List<ProductMr> getByNameMrService(String nameMr) throws SQLException;

    List<ProductMr> getAllMr();
}
