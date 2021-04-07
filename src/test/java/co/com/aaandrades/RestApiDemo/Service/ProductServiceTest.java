package co.com.aaandrades.RestApiDemo.Service;

import co.com.aaandrades.RestApiDemo.Interface.IProductDao;
import co.com.aaandrades.RestApiDemo.model.Product;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.skyscreamer.jsonassert.JSONAssert;

import java.util.Collections;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class ProductServiceTest {

    @Mock
    private IProductDao productDao;

    @InjectMocks
    private ProductServiceImpl productService;

    @Test
    public void whenUserRequestAllProducts_thenReturnAllProducts() throws JSONException {
        // Create a Mock with the correct response
        List<Product> newProduct = Collections.singletonList(new Product());
        newProduct.get(0).setName("Mock");
        newProduct.get(0).setPrice("123");
        newProduct.get(0).setIdproduct(1L);

        // Set 'listen' the mock to activate when productDao.findAll() call
        Mockito.when(productDao.findAll()).thenReturn(newProduct);

        // Call the function to test
        List<Product> product = productService.listProducts();

        // Validate that the mock and the response of the service its the same
        JSONAssert.assertEquals(product.get(0).getName(), newProduct.get(0).getName(), false);
    }

    @Test
    public void whenSaveAProduct_thenReturnTheProductSave() throws JSONException {
        Product newProduct = new Product();
        newProduct.setIdproduct(2L);
        newProduct.setName("mockValueAdded");
        newProduct.setPrice("123");

        Mockito.when(productDao.save(ArgumentMatchers.any(Product.class))).thenReturn(newProduct);
        Product product = productService.saveProduct(newProduct);
        JSONAssert.assertEquals(product.getName(), newProduct.getName(), false);
    }

    @Test
    public void whenProvideIdToDeleteProduct_thenDeleteTheProduct() throws JSONException {
        Long id = 23L;
        String response = productService.delete(id);
        JSONAssert.assertEquals(response, "Delete Successful", false);
    }

    @Test
    public void whenProvideIdToSearchProduct_thenReturnTheProduct() throws JSONException {
        Product newProduct = new Product();
        newProduct.setIdproduct(3L);
        newProduct.setName("MockValueSearch");

        Mockito.when(productDao.findById(newProduct.getIdproduct())).thenReturn(java.util.Optional.of(newProduct));
        Product product = productService.findProduct(newProduct.getIdproduct());
        JSONAssert.assertEquals(product.getName(), newProduct.getName(), false);
    }

    @Test
    public void whenProvideIdToUpdateProduct_thenReturnTheUpdatedProduct() throws JSONException {
        Product newProduct = new Product();
        newProduct.setIdproduct(4L);
        newProduct.setName("MockValueUpdated");
        newProduct.setPrice("528");

        Mockito.when(productDao.findById(5L)).thenReturn(java.util.Optional.of(newProduct));
        Mockito.when(productDao.save(ArgumentMatchers.any(Product.class))).thenReturn(newProduct);
        Product product = productService.update(newProduct,5L);
        JSONAssert.assertEquals(product.getName(), newProduct.getName(), false);
    }
}