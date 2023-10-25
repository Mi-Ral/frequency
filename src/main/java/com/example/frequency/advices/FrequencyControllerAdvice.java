package com.example.frequency.advices;

import com.example.frequency.exceptions.EmptyStringException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class FrequencyControllerAdvice {
    @ExceptionHandler(EmptyStringException.class)
    public ResponseEntity<String> exceptionEmptyStringHandler(EmptyStringException exception){
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
