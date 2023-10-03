package com.hkjava.calculator.democalculate.controller.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hkjava.calculator.DemoCalculateApplication;
import com.hkjava.calculator.democalculate.controller.BeanDisplayer;

@RestController
@RequestMapping(value = "/api/be")
public class BeanDisplayController implements BeanDisplayer {
    
    @Autowired
    DemoCalculateApplication app;

    @Override  
    public List<String> getAllBeans() {
        return Arrays.asList(app.getBeans()); 
    }
}
