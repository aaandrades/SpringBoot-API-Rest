package co.com.aaandrades.RestApiDemo.mocks;

import co.com.aaandrades.RestApiDemo.model.Product;

public class TestMockUtils {
    public static Product getMockProduct() {
        Product product = new Product();
        product.setName("Test name");
        product.setPrice("123456");
        Long id = 5L;
        product.setIdproduct(id);
        return product;
    }
}
