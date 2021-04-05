package co.com.aaandrades.RestApiDemo.controller;

import co.com.aaandrades.RestApiDemo.Controller.ControllerMain;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//@RunWith(MockitoJUnitRunner.class)
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ControllerMainTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private final ControllerMain controllerMain = new ControllerMain();

    @Before
    public void beforeTest() {
        mockMvc = MockMvcBuilders.standaloneSetup(controllerMain).build();
    }

    @Test
    public void shouldReturnHttpCode200OnGet() throws Exception {
        mockMvc.perform(get("/list")).andExpect(status().isOk());
    }

}


