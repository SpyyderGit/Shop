package ua.com.dao;

import ua.com.model.ProductType;
import ua.com.model.ProductView;

import java.util.List;

/**
 * Created by User on 18.05.2017.
 */
public interface ProductViewDao {

    void addProductView(ProductView productView);

    void deleteProductView(ProductView productView);

    void updateProductView(ProductView productView);

    ProductView getById(int id);

    List<ProductView> getByName(String name);

    List<ProductView> getAll();

}
