package ua.com.service;

import ua.com.model.Product;
import ua.com.model.ProductType;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by oleg on 22.05.17.
 */
public interface ProductTypeService {
    void addProductTypeService(ProductType productName);

    void deleteProductTypeService(int id);

    void updateProductTypeService(ProductType productType);

    ProductType getByIdTypeService(int id);

    List<ProductType> getByNameTypeService(String name);

    List<ProductType> getAllProductsTypeService();
}
