package ua.com;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import ua.com.dao.ProductDao;
import ua.com.dao.ProductMrDao;
import ua.com.dao.ProductTypeDao;
import ua.com.dao.ProductViewDao;
import ua.com.dao.impl.ProductDaoImpl;
import ua.com.dao.impl.ProductMrDaoImpl;
import ua.com.dao.impl.ProductTypeDaoImpl;
import ua.com.dao.impl.ProductViewDaoImpl;
import ua.com.model.ProductMr;
import ua.com.model.ProductType;
import ua.com.service.ProductMrService;
import ua.com.service.ProductService;
import ua.com.service.ProductTypeService;
import ua.com.service.ProductViewService;
import ua.com.service.impl.ProductMrServiceImpl;
import ua.com.service.impl.ProductServiceImpl;
import ua.com.service.impl.ProductTypeServiceImpl;
import ua.com.service.impl.ProductViewServiceImpl;

import java.sql.*;

/**
 * Created by User on 18.05.2017.
 */
public class MainApp {
    public static void main(String[] args) throws SQLException {
        Connection connection = null;


        String url = "jdbc:mysql://localhost:3306/Shop";
        String name = "root";
        String pass = "290731";


        SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
        dataSource.setDriver(new com.mysql.jdbc.Driver());
        dataSource.setUrl(url);
        dataSource.setUsername(name);
        dataSource.setPassword(pass);

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);


        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(url, name, pass);
            ProductDao productDao = new ProductDaoImpl(connection, jdbcTemplate);
            ProductMrDao mrDao = new ProductMrDaoImpl(jdbcTemplate);

            ProductMr mr = new ProductMr(4, "Sonia");

            ProductService productService = new ProductServiceImpl(productDao);

            ProductMrService productMrService = new ProductMrServiceImpl(mrDao, productService);

//            System.out.println(productMrService.getAllMr());

            ProductTypeDao productTypeDao = new ProductTypeDaoImpl(jdbcTemplate);
            ProductTypeService typeService = new ProductTypeServiceImpl(productTypeDao,productDao);

            ProductType productType = new ProductType();
            productType.setTypeName("PC");
            productType.setIdView(3);
            typeService.addProductTypeService(productType);


            ProductViewDao productViewDao = new ProductViewDaoImpl(jdbcTemplate);
            ProductViewService productViewService = new ProductViewServiceImpl(productViewDao,typeService);


            productViewService.deleteProductTypeService(3);

//            ProductTypeDao typeDao = new ProductTypeDaoImpl(jdbcTemplate);
//            System.out.println(typeDao.getAllTypes());


            //            productMrService.deleteProductMrService(3);


            //            System.out.println(mrDao.getAllName());

//            System.out.println(productDao.getAllProducts());


            //            productDao.deleteProduct(3);
//            System.out.println(productDao.getAllProducts());

//            productDao.updateProduct(new Product(2, "Samsung XP 3", 15000.00, "TV", "Y", 1, 1));


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
