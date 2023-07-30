package com.example.calculator.Controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = SumController.class)
public class SumControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void getSum_whenCalledWithValidParams_thenVerifyControllerReturnsOk() throws Exception { //arrange, action, assertion
        mvc.perform(
                        MockMvcRequestBuilders.get(
                                        "/sum?numbers=2,3")
                                .contentType(MediaType.APPLICATION_JSON)
                                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void getSum_whenCalledWithInvalidParams_thenVerifyControllerReturnsClientError() throws Exception {
        mvc.perform(
                        MockMvcRequestBuilders.get(
                                        "/sum?numbers=2,-3")
                                .contentType(MediaType.APPLICATION_JSON)
                                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void getSum_whenCalledWithMoreThanTwoParams_thenVerifyControllerReturnsClientError() throws Exception {
        mvc.perform(
                        MockMvcRequestBuilders.get("/sum?numbers=2,3,4")
                                .contentType(MediaType.APPLICATION_JSON)
                                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }
}