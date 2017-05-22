package ua.com.service.impl;

import org.apache.log4j.Logger;
import ua.com.dao.ProductDao;
import ua.com.dao.ProductMrDao;
import ua.com.dao.impl.ProductMrDaoImpl;
import ua.com.model.Product;
import ua.com.model.ProductMr;
import ua.com.service.ProductMrService;
import ua.com.service.ProductService;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by User on 22.05.2017.
 */
public class ProductMrServiceImpl implements ProductMrService {


    private static final Logger log = Logger.getLogger(ProductMrServiceImpl.class);
    private ProductMrDao productMrDao;
    private ProductService productService;


    public ProductMrServiceImpl(ProductMrDao productMrDao, ProductService productService) {
        this.productMrDao = productMrDao;
        this.productService = productService;
    }

    @Override
    public void addProductMrService(String productMr) {
        productMrDao.addProductMr(productMr);
    }


    @Override
    public void deleteProductMrService(int idMr) {
        for (Product p : productService.getAllProductsService()) {
            if (p.getMrIdFk() == idMr) {
                productService.deleteProductService(p.getProductId());
            }
        }
        productMrDao.deleteProductMr(idMr);
    }

    @Override
    public void updateProductMrService(ProductMr productMr) {
        productMrDao.updateProductMr(productMr);
    }

    @Override
    public ProductMr getByIdMrService(int idMr) {
        return productMrDao.getById(idMr);
    }

    @Override
    public List<ProductMr> getByNameMrService(String nameMr) throws SQLException {
        return productMrDao.getByName(nameMr);
    }

    @Override
    public List<ProductMr> getAllMr() {
        return productMrDao.getAllName();
    }
}
