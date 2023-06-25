package com.example.calculator.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
public class ProductController {



    @GetMapping("/product")
    public Integer product(@RequestParam List<Integer> numbers) throws IllegalArgumentException {
        if(numbers.get(0)<0 && numbers.get(1)<0){
            throw new IllegalArgumentException("Both numbers invalid: must be greater than or equal to zero");
        } else if(numbers.get(0)<0){
            throw new IllegalArgumentException("First number invalid: must be greater than or equal to zero");
        } else if (numbers.get(1)<0){
            throw new IllegalArgumentException("Second number invalid: must be greater than or equal to zero");
        } else return numbers.get(0) * numbers.get(1);
    }
}
