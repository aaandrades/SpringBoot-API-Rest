package co.com.aaandrades.RestApiDemo.Service;

import co.com.aaandrades.RestApiDemo.model.Product;

import java.util.List;

// Spring will read the instance of the ProductService but will be execute the file that
// implements the service (ProductService) with the annotation @Service, that is the file
// with all the logic.

public interface ProductService {

    public List<Product> listProducts();

    public Product saveProduct(Product product);

    public String delete(Long id);

    public Product findProduct(Long id);

    public Product update(Product product, Long id);

}
