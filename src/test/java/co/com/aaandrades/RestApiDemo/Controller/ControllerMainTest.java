package co.com.aaandrades.RestApiDemo.Controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
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
    public void shouldReturnHttpCode400OnPost() throws Exception {
        mockMvc.perform(post("/add").requestAttr("name", "AnyName")).andExpect(status().isBadRequest());
    }

    @Test
    public void shouldReturnHttpCode404OnPut() throws Exception {
        mockMvc.perform(put("/update")).andExpect(status().isNotFound());
    }
    /*@Test
    public void shouldReturnHttpCode200OnGet() throws Exception {
        mockMvc.perform(get("/list")).andExpect(status().isOk());
    }*/


    /*@Test
    public void shouldReturnHttpCode200OnDelete() throws Exception {
        mockMvc.perform(delete("/delete/01")).andExpect(status().isOk());
    }*/

}


