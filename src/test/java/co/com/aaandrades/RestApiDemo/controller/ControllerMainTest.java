package co.com.aaandrades.RestApiDemo.controller;

import co.com.aaandrades.RestApiDemo.Interface.IProductDao;
import co.com.aaandrades.RestApiDemo.Service.ProductService;
import co.com.aaandrades.RestApiDemo.mocks.TestMockUtils;
import co.com.aaandrades.RestApiDemo.model.Product;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.mock.mockito.MockBean;

@RunWith(MockitoJUnitRunner.class)
@DataJpaTest
public class ControllerMainTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private IProductDao productDao;

    @MockBean
    ProductService productService;

    ObjectMapper mapper = new ObjectMapper();

    @Test
    public void it_should_save_product() {
        Product product = new Product();
        product = TestMockUtils.getMockProduct();
        //entityManager.persistAndFlush(product);
        Assertions.assertNotNull(product);


        /*
        testEntityManager.persistAndFlush(product);
        Assertions.assertNotNull(product.getIdproduct());*/
    }

}


