package com.hkjava.bootcamp.demo.demoresttemplate.controller.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.hkjava.bootcamp.demo.demoresttemplate.config.AppConfig;
import com.hkjava.bootcamp.demo.demoresttemplate.controller.UserOperation;
import com.hkjava.bootcamp.demo.demoresttemplate.infra.ApiResponse;
import com.hkjava.bootcamp.demo.demoresttemplate.infra.Code;
import com.hkjava.bootcamp.demo.demoresttemplate.mapper.UserMapper;
import com.hkjava.bootcamp.demo.demoresttemplate.model.User;
import com.hkjava.bootcamp.demo.demoresttemplate.model.UserDTO;
import com.hkjava.bootcamp.demo.demoresttemplate.service.UserService;

@RestController // Controller + Responsebody
@RequestMapping(value = "/api/v1")
public class UserController implements UserOperation {

    @Autowired
    UserService userService;

    // @Autowired
    // RestTemplate restTemplate;

    // @Autowired
    // @Qualifier(value = "user")
    // String

    @Override
    public ResponseEntity<ApiResponse<List<UserDTO>>> findAll() throws Exception {
        // AppConfig appConfig = new AppConfig();
        // when decompile the code, can see in the builder
        // ApiResponse = own rule
        // ResponseEntity = rule provide by org.springframework.http.ResponseEntity;
        List<User> users = userService.findAll();

        // no need to handle unhappy flow here
        // because springboot already tickle the throw new BusinessException at UserServiceImpl and handled in the GlobalExceptionHandler
        // if (users == null) {
        //     ApiResponse<List<UserDTO>> response = ApiResponse.<List<UserDTO>>builder() //
        //             .status(Code.JPH_NOTFOUND) //
        //             .data(null) //
        //             .build();
        //     return ResponseEntity.badRequest().body(response);
        // }

        // Coversion
        List<UserDTO> userDTOs = users.stream() //
                .map(user -> UserMapper.map(user)) //
                .collect(Collectors.toList());

        ApiResponse<List<UserDTO>> response = ApiResponse.<List<UserDTO>>builder() //
                .ok() //
                .data(userDTOs) //
                .build();
        return ResponseEntity.ok().body(response);
    }
}
