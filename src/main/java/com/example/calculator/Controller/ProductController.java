package com.example.calculator.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@RestController
public class ProductController {



    @GetMapping("/product")
    public Integer product(@RequestParam List<Integer> numbers) throws IllegalArgumentException {
//        if(numbers.get(0)<0 && numbers.get(1)<0){
//            throw new IllegalArgumentException("Both numbers invalid: must be greater than or equal to zero");
//        } else if(numbers.get(0)<0){
//            throw new IllegalArgumentException("First number invalid: must be greater than or equal to zero");
//        } else if (numbers.get(1)<0){
//            throw new IllegalArgumentException("Second number invalid: must be greater than or equal to zero");
//        } else return numbers.get(0) * numbers.get(1);

//        Optional<Integer> optionalInteger = numbers.stream().filter(x -> x < 0).findFirst();
//        if(optionalInteger.isPresent()){
//            throw new IllegalArgumentException(String.valueOf(optionalInteger.get()));
//        }

        if(numbers.size() > 2){
            throw new IllegalArgumentException();
        }

        List<Integer> negativeNumbers = numbers.stream().filter(i -> i < 0).toList();
        if(!negativeNumbers.isEmpty()){
            throw new IllegalArgumentException(negativeNumbers.toString());
        }

        else return numbers.get(0) * numbers.get(1);
    }
}
