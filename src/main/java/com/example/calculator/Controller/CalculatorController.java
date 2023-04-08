package com.example.calculator.Controller;

import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
public class CalculatorController{


    @GetMapping("/sum")
    public int sum(@RequestParam List<Integer> numbers) {
        Integer sum = 0;
        for(Integer number : numbers){
            sum += number;
        }
        return sum;
    }
}