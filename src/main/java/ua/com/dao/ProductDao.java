package ua.com.dao;

import ua.com.model.Product;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by User on 18.05.2017.
 */
public interface ProductDao {
    void addProduct(String productName, double productPrice, String productRemark,
                    String sklad, int mrIdFk, int typeIdFk) throws SQLException;

    void deleteProduct(int id);

    void updateProduct(Product product);

    Product getById(int id) throws SQLException;

    Product getByName(String name) throws SQLException;

    List<Product> getByPrice(double price);

    List<Product> getAllProducts();
}
