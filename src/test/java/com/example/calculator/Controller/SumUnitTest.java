package com.example.calculator.Controller;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SumUnitTest {

    @Test
    public void testSumCorrect() {
        SumController sumController = new SumController();
        assertEquals(6, sumController.sum(List.of(2, 4)));
    }

    @Test
    public void testSumException_whenCalledWithTooManyParameters() {
        SumController sumController = new SumController();
        assertThrows(IllegalArgumentException.class, ()->sumController.sum(List.of(2, 4, 6)));
    }
}