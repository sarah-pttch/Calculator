package com.example.calculator.Controller;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.ArrayList;
import java.util.List;


@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    ResponseEntity<String>
    handleConstraintViolationException(ConstraintViolationException e){

        List<Object> negativeNumbers = new ArrayList<>();
        for(ConstraintViolation cv : e.getConstraintViolations()){
            negativeNumbers.add(cv.getInvalidValue());
        }
        return new ResponseEntity<>("Invalid input: " + negativeNumbers + ". Must be greater than or equal to zero.", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    ResponseEntity<String>
    handleMethodArgumentTypeMismatchException(){
        return new ResponseEntity<>("Invalid input: numbers must be of type Integer", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    ResponseEntity<String>
    handleIllegalArgumentException(IllegalArgumentException e){
        if(e.getMessage() == null){
            return new ResponseEntity<>("You may only input 2 numbers", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Invalid input: " + e.getMessage() + " Numbers must be greater than or equal to zero", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    ResponseEntity<String>
    handleMissingServletRequestParameterException(){
        return new ResponseEntity<>("You need to input two numbers", HttpStatus.BAD_REQUEST);
    }

}
