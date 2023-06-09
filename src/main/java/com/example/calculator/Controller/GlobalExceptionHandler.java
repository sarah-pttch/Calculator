package com.example.calculator.Controller;

import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;


@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    ResponseEntity<String>
    handleConstraintViolationException(ConstraintViolationException e){
        String message = e.getMessage();
        int first = message.indexOf("[");
        int second = message.lastIndexOf("[");
        if(first == second){
            int error = Integer.parseInt(message.substring(first+1, first+2)) +1;
            return new ResponseEntity<>("Number " + error + " invalid: must be greater than or equal to zero", HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>("Both numbers invalid: must be greater than or equal to zero", HttpStatus.BAD_REQUEST);
        }
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
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    ResponseEntity<String>
    handleMissingServletRequestParameterException(){
        return new ResponseEntity<>("You need to input two numbers", HttpStatus.BAD_REQUEST);
    }

}
