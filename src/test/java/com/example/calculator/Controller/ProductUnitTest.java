package com.example.calculator.Controller;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductUnitTest {

    @Test
    public void testProductCorrect() {
        ProductController productController = new ProductController();
        assertEquals(20, productController.product(List.of(4, 5)));
    }

    @Test
    public void testProductException_whenCalledWithNegativeParameter() {
        ProductController productController = new ProductController();
        assertThrows(IllegalArgumentException.class, ()->productController.product(List.of(-4, 5)));
    }

}