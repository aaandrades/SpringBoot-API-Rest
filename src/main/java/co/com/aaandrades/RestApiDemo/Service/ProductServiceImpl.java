package co.com.aaandrades.RestApiDemo.Service;

import co.com.aaandrades.RestApiDemo.Interface.IProductDao;
import co.com.aaandrades.RestApiDemo.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/* This is a service layer, here we declared the actions that going to do with the API */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private IProductDao productDao;

    @Override
    @Transactional(readOnly = true)
    public List<Product> listProducts() {
        // Just will read the DB, don't create a commit (Success) or Rollback (Fail)
        // FindAll() return an object, so it need the cast.
        return (List<Product>) productDao.findAll();
    }

    @Override
    @Transactional
    public Product saveProduct(Product product) {
        // If operation is Success, create a commit and continue, otherwise, do Rollback and end.
        // Save a product
        productDao.save(product);
        return product;
    }

    @Override
    @Transactional
    public String delete(Long id) {
        // Delete a service
        productDao.deleteById(id);
        return "Delete Successful";
    }

    @Override
    @Transactional(readOnly = true)
    public Product findProduct(Long id) {
        // If product doesn't exist, return null, otherwise return the product.
        return productDao.findById(id)
                .orElse(null);
    }

    @Override
    public Product update(Product newProduct, Long id) {
        return productDao.findById(id)
                // If the id exist, will be updated, otherwise will create a new one.
                .map(product -> {
                    product.setName(newProduct.getName());
                    product.setPrice(newProduct.getPrice());
                    return productDao.save(product);
                })
                .orElseGet(() -> {
                    newProduct.setIdproduct(id);
                    return productDao.save(newProduct);
                });
    }


}
 