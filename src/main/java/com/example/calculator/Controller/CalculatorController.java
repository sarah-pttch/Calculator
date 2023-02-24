package com.example.calculator.Controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class CalculatorController{

//    @GetMapping("/sum")
//    public int sum(@RequestParam String numbers) {
//        String sub1 = numbers.substring(0, numbers.indexOf(","));
//        int number1 = Integer.parseInt(sub1);
//        String sub2 = numbers.substring(numbers.indexOf(",")+1);
//        int number2 = Integer.parseInt(sub2);
//        return number1 + number2;
//    }

    @GetMapping("/sum")
    public int sum(@RequestParam String numbers) {
        String[] sub = numbers.split(",");
        return Integer.parseInt(sub[0]) + Integer.parseInt(sub[1]);
    }
}