package com.hkjava.bootcamp.demo.demoresttemplate.exception;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.hkjava.bootcamp.demo.demoresttemplate.infra.ApiResponse;
import com.hkjava.bootcamp.demo.demoresttemplate.infra.BusinessException;
import com.hkjava.bootcamp.demo.demoresttemplate.infra.Code;
import com.hkjava.bootcamp.demo.demoresttemplate.model.UserDTO;

@RestControllerAdvice // @ResponseBody + @ ControllerAdvice
public class GlobalExceptionHandler {
    
    // Can use Void to replace UserDTO
    // Void can be a class, Void is nothing, put in <> is like a generic version of null
    // as we expect null here, no need to check by UserDTO, can just put the simplest classs
    // cannot put small void, Void is like a wrapper class
    @ExceptionHandler(value = JPHException.class) // when spring boot detected anywhere throw the BusinessException, call this method.  
    // public ResponseEntity<ApiResponse<List<UserDTO>>> getUserExceptionHandler() {
    //     ApiResponse<List<UserDTO>> response = ApiResponse.<List<UserDTO>>builder() //
    public ResponseEntity<ApiResponse<List<Void>>> getUserExceptionHandler() {
            ApiResponse<List<Void>> response = ApiResponse.<List<Void>>builder() //
                    .status(Code.JPH_NOTFOUND) //
                    .data(null) //
                    .build();
            return ResponseEntity.badRequest().body(response);
    }
}
