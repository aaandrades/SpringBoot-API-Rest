package co.com.aaandrades.RestApiDemo.Service;

import co.com.aaandrades.RestApiDemo.model.Product;

import java.util.List;

// Spring will read the instance of the ProductService but will be execute the file that
// implements the service (ProductService) with the annotation @Service, that is the file
// that will have all the logic.

public interface ProductService {

    public List<Product> listProducts();

    public void save(Product product);

    public void delete(Product product);

    public Product findProduct(Product product);

}
