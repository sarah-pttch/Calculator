package com.example.calculator.Controller;

import jakarta.validation.constraints.PositiveOrZero;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
@Validated
public class ProductController {



    @GetMapping("/product")
    public Integer product(@RequestParam List<@PositiveOrZero Integer> numbers) {
        return numbers.get(0) * numbers.get(1);
    }
}
