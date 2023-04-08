package com.example.calculator.Controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class CalculatorController{


    @GetMapping("/sum")
    public int sum(@RequestParam String numbers) {
        String[] sub = numbers.split(",");
        return Integer.parseInt(sub[0]) + Integer.parseInt(sub[1]);
    }
}