package com.asis.blog.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class MyExceptionHandler {
    @ExceptionHandler(CustomException.class)
    public ResponseEntity<?> handleCustomException(CustomException  ex){
        return new ResponseEntity<>(ex.getMessage() , HttpStatus.BAD_REQUEST);
    }
//    @ExceptionHandler(Exception.class)
//    public ResponseEntity<?> handleAllException(Exception ex){
//        return new ResponseEntity<>(ex.getMessage() , HttpStatus.BAD_REQUEST);
//    }
}
