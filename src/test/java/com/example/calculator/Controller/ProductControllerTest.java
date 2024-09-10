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
@WebMvcTest(controllers = ProductController.class)
public class ProductControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void getProduct_whenCalledWithValidParams_thenVerifyControllerReturnsOk() throws Exception {
        mvc.perform(
                MockMvcRequestBuilders.get("/product?numbers=3,4")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void getProduct_whenCalledWithInvalidParams_thenVerifyControllerReturnsClientError() throws Exception {
        mvc.perform(
                MockMvcRequestBuilders.get("/product?numbers=-3,4")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void getProduct_whenCalledWithMoreThanTwoParams_thenVerifyControllerReturnsOk() throws Exception {
        mvc.perform(
                MockMvcRequestBuilders.get("/product?numbers=2,3,4")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

}