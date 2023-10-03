package com.hkjava.bootcamp.exercise.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.hkjava.bootcamp.exercise.infra.ApiResponse;
import com.hkjava.bootcamp.exercise.infra.Code;

@RestControllerAdvice
public class GlobalExceptionHandler {
    
    @ExceptionHandler(value = FHException.class)
    public ResponseEntity<ApiResponse<Void>> getUserExceptionHandler() {
        ApiResponse<Void> response = ApiResponse.<Void>builder()
        .status(Code.FH_NOTFOUND)
        .data(null)
        .build();
    
        return ResponseEntity.badRequest().body(response); 
    }   
}
