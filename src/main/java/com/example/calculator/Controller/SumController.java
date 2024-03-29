package com.example.calculator.Controller;

import jakarta.validation.constraints.PositiveOrZero;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.*;


@RestController
@Validated
public class SumController{

    @GetMapping("/sum")
    public Integer sum(@RequestParam List<@PositiveOrZero Integer> numbers) throws IllegalArgumentException {
        if(numbers.size() > 2){
            throw new IllegalArgumentException();
        }
        return numbers.get(0) + numbers.get(1);
    }

}