package com.example.calculator;

import com.example.calculator.Controller.ProductController;
import com.example.calculator.Controller.SumController;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.constraints.PositiveOrZero;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
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

//    @Test //(expected = ConstraintViolationException.class)
//    public void testSumConstraintViolation(){
//        SumController calculatorController = new SumController();
//        List<@PositiveOrZero Integer> input = Arrays.asList(5, -1);
//        assertThrows(ConstraintViolationException.class, ()->calculatorController.sum(input));
////        calculatorController.sum(new ArrayList<@PositiveOrZero Integer>(Arrays.asList(5, -1)));
//    }

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
