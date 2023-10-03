package com.hkjava.bootcamp.demo.demoresttemplate.service;

import java.util.List;

import com.hkjava.bootcamp.demo.demoresttemplate.infra.BusinessException;
import com.hkjava.bootcamp.demo.demoresttemplate.model.User;

public interface UserService {
    
    public List<User> findAll() throws BusinessException; 
}
