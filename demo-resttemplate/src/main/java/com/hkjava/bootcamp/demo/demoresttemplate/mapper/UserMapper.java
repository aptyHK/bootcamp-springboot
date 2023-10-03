package com.hkjava.bootcamp.demo.demoresttemplate.mapper;

import com.hkjava.bootcamp.demo.demoresttemplate.model.User;
import com.hkjava.bootcamp.demo.demoresttemplate.model.UserDTO;

public class UserMapper {
    public static UserDTO map(User user) {
        return UserDTO.builder() //
            .id(user.getId()) //
            .name(user.getName()) //
            .username(user.getUsername()) //
            .build();
      }
}
