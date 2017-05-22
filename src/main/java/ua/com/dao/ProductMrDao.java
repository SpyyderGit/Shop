package ua.com.dao;

import ua.com.model.Product;
import ua.com.model.ProductMr;

import java.util.List;

/**
 * Created by User on 18.05.2017.
 */
public interface ProductMrDao {
    void addProductMr(String product);

    void deleteProductMr(int mrId);

    void updateProductMr(ProductMr product);

    ProductMr getById(int id);

    List<ProductMr> getByName(String name);

    List<ProductMr> getAllName();

}
