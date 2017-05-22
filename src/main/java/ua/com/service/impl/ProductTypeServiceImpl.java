package ua.com.service.impl;

import org.apache.log4j.Logger;
import ua.com.dao.ProductDao;
import ua.com.dao.ProductTypeDao;
import ua.com.model.Product;
import ua.com.model.ProductType;
import ua.com.service.ProductTypeService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by oleg on 22.05.17.
 */
public class ProductTypeServiceImpl implements ProductTypeService {
    private ProductTypeDao productTypeDao;
    private ProductDao productDao;

    private static final Logger log = Logger.getLogger(ProductTypeServiceImpl.class);

    public ProductTypeServiceImpl(ProductTypeDao productTypeDao, ProductDao productDao) {
        this.productTypeDao = productTypeDao;
        this.productDao = productDao;
    }

    @Override
    public void addProductTypeService(ProductType productName) {
        productTypeDao.addProductType(productName);
        log.info("add " + productName + " successfull");
    }

    @Override
    public void deleteProductTypeService(int id) {
        for (Product p : productDao.getAllProducts()) {
            if (p.getTypeIdFk() == id) {
                productDao.deleteProduct(p.getProductId());
            }
        }
        productTypeDao.deleteProductType(productTypeDao.getById(id));
    }

    @Override
    public void updateProductTypeService(ProductType productType) {
        productTypeDao.updateProductType(productType);
    }

    @Override
    public ProductType getByIdTypeService(int id) {
        return productTypeDao.getById(id);
    }

    @Override
    public List<ProductType> getByNameTypeService(String name) {
        return productTypeDao.getByName(name);
    }

    @Override
    public List<ProductType> getAllProductsTypeService() {
        return productTypeDao.getAllTypes();
    }
}
