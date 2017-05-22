package ua.com.service;

import ua.com.model.Product;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by User on 22.05.2017.
 */
public interface ProductService {
    void addProductService(String productName, double productPrice, String productRemark,
                           String sklad, int mrIdFk, int typeIdFk);

    void deleteProductService(int id);

    void updateProductService(Product product);

    Product getByIdService(int id) throws SQLException;

    Product getByNameService(String name) throws SQLException;

    List<Product> getByPriceService(double price);

    List<Product> getAllProductsService();
}
