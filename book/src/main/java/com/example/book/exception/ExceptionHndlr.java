package com.example.book.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHndlr {

    @ExceptionHandler(CustomBookException.class)
    public ResponseEntity<?> customExceptionHandler (CustomBookException ex){
        return new ResponseEntity<>(ex.getMessage() ,HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> exceptionHandler(Exception ex){
        return new ResponseEntity<>("Something went wrong : "+ex.getMessage() , HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
