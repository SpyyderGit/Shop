package ua.com.service.impl;

import ua.com.dao.ProductViewDao;
import ua.com.model.ProductType;
import ua.com.model.ProductView;
import ua.com.service.ProductTypeService;
import ua.com.service.ProductViewService;

import java.util.List;

/**
 * Created by oleg on 22.05.17.
 */
public class ProductViewServiceImpl implements ProductViewService {

    ProductViewDao productViewDao;
    ProductTypeService productTypeService;

    public ProductViewServiceImpl(ProductViewDao productViewDao, ProductTypeService productTypeService) {
        this.productViewDao = productViewDao;
        this.productTypeService = productTypeService;
    }

    @Override
    public void addProductViewService(ProductView productView) {
        productViewDao.addProductView(productView);
    }

    @Override
    public void deleteProductTypeService(int id) {
        for (ProductType p : productTypeService.getAllProductsTypeService()) {
            if (p.getIdView() == id) {
                productTypeService.deleteProductTypeService(p.getTypeId());
            }
        }
        productViewDao.deleteProductView(productViewDao.getById(id));
    }

    @Override
    public void updateProductViewService(ProductView productView) {
        productViewDao.updateProductView(productView);
    }

    @Override
    public ProductView getByIdViewService(int id) {
        return productViewDao.getById(id);
    }

    @Override
    public List<ProductView> getByNameViewService(String name) {
        return productViewDao.getByName(name);
    }

    @Override
    public List<ProductView> getAllProductsViewService() {
        return productViewDao.getAll();
    }
}