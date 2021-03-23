package co.com.aaandrades.RestApiDemo.Controller;

import co.com.aaandrades.RestApiDemo.Interface.IProductDao;
import co.com.aaandrades.RestApiDemo.Service.ProductService;
import co.com.aaandrades.RestApiDemo.model.Product;
import lombok.extern.slf4j.Slf4j;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// @Controller ----> Just used this when use Thymeleaf to present web results.

@RestController
@Slf4j
public class ControllerMain {

    private @Autowired ProductService productService;
    private @Autowired IProductDao productDao;

    // Enable when use Thymeleaf to use MVC template.
    /*@GetMapping("/hello")
    public String getHelloWorld(Model model){

        var product = productService.listProducts();

        *//* Just for learning. You can see how inject values and present in view (index.html)
        String message = "Hello world with Thymeleaf";

        Person persona = new Person();
        persona.setName("Andres");
        persona.setId("10324826110");
        persona.setMail("aaandrades@outlook.com");
        persona.setPhone("+573175289278");

        Person persona2 = new Person();
        persona2.setName("Alexander");
        persona2.setId("123456798");
        persona2.setMail("andradesanchezandres@gmail.com");
        persona2.setPhone("+573175289278");

        var people = Arrays.asList(persona,persona2);*//*
        model.addAttribute("product", product);
        return "index";
    }*/

    @GetMapping("/list")
    public List<Product> listProducts(){
        log.info("EXECUTE ROUTE List");
        return productService.listProducts();
    }

    @PostMapping("/add")
    Product newProduct(@RequestBody Product newProduct) {
        return productService.save(newProduct);
    }
}
