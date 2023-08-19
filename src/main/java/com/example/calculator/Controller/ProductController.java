package com.example.calculator.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class ProductController {

    @GetMapping("/product")
    public Integer product(@RequestParam List<Integer> numbers) throws IllegalArgumentException {

        List<Integer> negativeNumbers = numbers.stream().filter(i -> i < 0).toList();
        if(!negativeNumbers.isEmpty()){
            throw new IllegalArgumentException(negativeNumbers.toString());
        }

        Integer product = numbers.get(0);

        for(int i = 1; i < numbers.size(); i++){
            product *= numbers.get(i);
        }
        return product;

    }
}
