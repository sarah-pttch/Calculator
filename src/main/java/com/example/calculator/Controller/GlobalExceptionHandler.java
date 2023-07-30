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
//        String message = e.getMessage();
//        int first = message.indexOf("[");
//        int second = message.lastIndexOf("[");
//        if(first == second){
//            int error = Integer.parseInt(message.substring(first+1, first+2)) +1;
//            return new ResponseEntity<>("Number " + error + " invalid: must be greater than or equal to zero", HttpStatus.BAD_REQUEST);
//        } else {
//            return new ResponseEntity<>("Both numbers invalid: must be greater than or equal to zero", HttpStatus.BAD_REQUEST);
//        }

//        Object errorOne = e.getConstraintViolations().iterator().next().getInvalidValue();
//        if(e.getConstraintViolations().size() == 2) {
//            Object errorTwo = e.getConstraintViolations().iterator().next().getInvalidValue();
//            return new ResponseEntity<>("Invalid input: " + errorOne + ", " + errorTwo + ". Must be greater than or equal to zero.", HttpStatus.BAD_REQUEST);
//        }

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
