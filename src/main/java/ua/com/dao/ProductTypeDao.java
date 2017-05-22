package ua.com.dao;

import ua.com.model.Product;
import ua.com.model.ProductType;

import java.util.List;

/**
 * Created by User on 18.05.2017.
 */
public interface ProductTypeDao {

    void addProductType(ProductType productType);

    void deleteProductType(ProductType productType);

    void updateProductType(ProductType productType);

    ProductType getById(int id);

    List<ProductType> getByName(String name);

    List<ProductType> getAllTypes();
}
