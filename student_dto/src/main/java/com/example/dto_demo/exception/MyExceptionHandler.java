package com.example.dto_demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class MyExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> customExceptionHandeler(Exception ex){
        return new ResponseEntity<>(ex.toString() , HttpStatus.BAD_REQUEST);
    }
}
