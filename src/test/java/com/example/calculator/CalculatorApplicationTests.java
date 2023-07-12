package com.example.calculator;

import com.example.calculator.Controller.ProductController;
import com.example.calculator.Controller.SumController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@WebMvcTest(controllers = SumController.class)
public class CalculatorApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Test
    public void testSumCorrect(){
        SumController calculatorController = new SumController();
        List<Integer> input = Arrays.asList(5, 7);
        assertEquals(12, calculatorController.sum(input));
    }

    @Test
    public void testProductCorrect(){
        ProductController productController = new ProductController();
        List<Integer> input = Arrays.asList(3, 4);
        assertEquals(12, productController.product(input));
    }

    @Test
    public void testProductIllegalArgument(){
        ProductController productController = new ProductController();
        List<Integer> input = Arrays.asList(3,-4);
        assertThrows(IllegalArgumentException.class, ()->productController.product(input));
    }






}
