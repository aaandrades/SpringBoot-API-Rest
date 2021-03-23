package co.com.aaandrades.RestApiDemo.Service;

import co.com.aaandrades.RestApiDemo.Interface.IProductDao;
import co.com.aaandrades.RestApiDemo.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/* This is a service layer, here we declared the actions that going to do with the API */
@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private IProductDao productDao;

    @Override
    // Just will read the DB, don't create a commit (Success) or Rollback (Fail)
    @Transactional(readOnly = true)
    public List<Product> listProducts() {
        // FindAll() return an object, so it need the cast.
        return (List<Product>) productDao.findAll();
    }

    @Override
    // If operation is Success, create a commit and continue, otherwise, do Rollback and end.
    @Transactional
    public void save(Product product) {
        // Save a product
        productDao.save(product);
    }

    @Override
    @Transactional
    public void delete(Product product) {
        // Delete a service
        productDao.delete(product);
    }

    @Override
    @Transactional(readOnly = true)
    public Product findProduct(Product product) {
        // If product doesn't exist, return null, otherwise return the product.
        return productDao.findById(product.getIdproduct()).orElse(null);
    }
}
