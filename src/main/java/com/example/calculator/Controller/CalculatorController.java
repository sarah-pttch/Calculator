package com.example.calculator.Controller;

import jakarta.validation.ConstraintViolationException;
import jakarta.validation.constraints.Min;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.*;


@RestController
@Validated
public class CalculatorController{

    @GetMapping("/sum")
    public int sum(@RequestParam List<@Min(0) Integer> numbers) {
        int sum = 0;
        for(int number : numbers){
            sum += number;
        }
        return sum;
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    ResponseEntity<String>
    handleConstraintViolationException(){
        return new ResponseEntity<>("invalid input: numbers must be greater than or equal to zero!", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    ResponseEntity<String>
    handleMethodArgumentTypeMismatchException(){
        return new ResponseEntity<>("Invalid input: numbers need to be of type Integer!", HttpStatus.BAD_REQUEST);
    }
}