package co.com.aaandrades.RestApiDemo;

import co.com.aaandrades.RestApiDemo.Controller.ControllerMain;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RestApiDemoApplicationTests {

    @Autowired
    private ControllerMain controllerMain;

    @Test
    void contextLoads() {
        Assertions.assertNotNull(controllerMain);
    }

}
