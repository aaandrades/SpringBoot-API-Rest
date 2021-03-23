package co.com.aaandrades.RestApiDemo.Interface;

import co.com.aaandrades.RestApiDemo.model.Product;
import org.springframework.data.repository.CrudRepository;

public interface IProductDao extends CrudRepository<Product, Long> {

    // By default implement the CRUD operations, but if we need so specific task in DB,
    // Declare it here.

}
