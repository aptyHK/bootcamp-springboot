package com.hkjava.calculator.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.hkjava.calculator.democalculate.controller.CalculatorOperation;
import com.hkjava.calculator.democalculate.service.impl.CalculatorServiceImpl;

@Configuration // Member of @Component
public class BeanCreator {

    @Bean(name = "arraylist")
    public List<String> createArrayList() {
        List<String> strings = new ArrayList<>();
        strings.add("Bean name = arraylist");
        return strings;
    }

    @Bean(name = "linkedlist")
    public List<String> createLinkedList() {
        List<String> strings = new ArrayList<>();
        strings.add("Bean name = linkedlist");
        return strings;
    }

    @Bean
    public CalculatorServiceImpl createCalculatorServiceImpl() {
        return new CalculatorServiceImpl();
    }
}
