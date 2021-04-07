package co.com.aaandrades.RestApiDemo.Controller;

import co.com.aaandrades.RestApiDemo.Interface.IProductDao;
import co.com.aaandrades.RestApiDemo.Service.ProductService;
import co.com.aaandrades.RestApiDemo.model.Product;
import co.com.aaandrades.RestApiDemo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.*;

import lombok.extern.slf4j.Slf4j;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

// @Controller ----> Just used this when use Thymeleaf to present web results.

@RestController
@Slf4j
public class ControllerMain {

    private @Autowired
    ProductService productService;

    private @Autowired
    IProductDao productDao;

    // Enable when use Thymeleaf to use MVC template.
    /*@GetMapping("/hello")
    public String getHelloWorld(Model model){
        var people = Arrays.asList(persona,persona2);*//*
        model.addAttribute("product", product);
        return "index";
    }*/

    // AUTH
    @PostMapping("/user")
    public User login(@RequestBody User userRq) {

        // For learning purpose, we don't go to validate the user and password,
        // in a real project, go to Database, validate data and then, return de JWT.
        String token = getJWTToken(userRq.getUser());
        User user = new User();
        user.setUser(userRq.getUser());
        user.setToken(token);
        return user;
    }

    // This method will be build the token, it delegate to a JWTS utility that include
    // information about expiration and GrantedAuthority (That will be protect the routes)
    private String getJWTToken(String username) {
        String secretKey = "andrade";
        List<GrantedAuthority> grantedAuthorities = AuthorityUtils
                .commaSeparatedStringToAuthorityList("ROLE_USER");

        String token = Jwts
                .builder()
                .setId("softtekJWT")
                .setSubject(username)
                .claim("authorities",
                        grantedAuthorities.stream()
                                .map(GrantedAuthority::getAuthority)
                                .collect(Collectors.toList()))
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 600000))
                .signWith(SignatureAlgorithm.HS512,
                        secretKey.getBytes()).compact();

        return "Bearer " + token;
    }

    // CREATE
    @PostMapping("/add")
    public Product newProduct(@RequestBody Product newProduct) {
        return productService.saveProduct(newProduct);
    }

    // READ
    @GetMapping("/list")
    public List<Product> listProducts() {
        return productService.listProducts();
    }

    // UPDATE
    @PutMapping("/update/{id}")
    public Product updateProduct(@RequestBody Product newProduct, @PathVariable Long id) {
        return productService.update(newProduct, id);
    }

    // DELETE
    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        return productService.delete(id);
    }

    // SEARCH
    @GetMapping("/search/{id}")
    public Product findProduct(@PathVariable Long id) {
        return productService.findProduct(id);
    }

    // HandleError
    @ResponseStatus(value = HttpStatus.CONFLICT)
    public static class NoSuchElementFoundException extends RuntimeException {
    }
}
