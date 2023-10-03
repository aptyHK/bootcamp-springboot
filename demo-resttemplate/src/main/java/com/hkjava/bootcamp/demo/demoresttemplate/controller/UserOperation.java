package com.hkjava.bootcamp.demo.demoresttemplate.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.hkjava.bootcamp.demo.demoresttemplate.infra.ApiResponse;
import com.hkjava.bootcamp.demo.demoresttemplate.model.User;
import com.hkjava.bootcamp.demo.demoresttemplate.model.UserDTO;

public interface UserOperation {
    
    // @GetMapping(value = "/user")
    // User findUser(
    //     @PathVariable String id);
    
    @GetMapping(value = "/users")
    ResponseEntity<ApiResponse<List<UserDTO>>> findAll() throws Exception;

    // @GetMapping(value = "/user")
    // User findUser();
}
