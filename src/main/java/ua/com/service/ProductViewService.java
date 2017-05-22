package ua.com.service;

import ua.com.model.Product;
import ua.com.model.ProductType;
import ua.com.model.ProductView;

import java.util.List;

/**
 * Created by oleg on 22.05.17.
 */
public interface ProductViewService {
    void addProductViewService(ProductView productName);

    void deleteProductTypeService(int id);

    void updateProductViewService(ProductView productView);

    ProductView getByIdViewService(int id);

    List<ProductView> getByNameViewService(String name);

    List<ProductView> getAllProductsViewService();
}
