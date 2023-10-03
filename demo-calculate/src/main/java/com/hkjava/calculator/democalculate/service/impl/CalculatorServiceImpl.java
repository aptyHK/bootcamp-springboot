package com.hkjava.calculator.democalculate.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.hkjava.calculator.democalculate.service.CalculatorService;

@Service
public class CalculatorServiceImpl implements CalculatorService {

    //@Autowired
    @Qualifier(value = "linkedlist")
    List<String> strings;

    @Override
    public List<String> getStrings() {

        strings.add("abc");
        strings.add("def");
        strings.add("xyz");
        return strings;
    }

    @Override
    public int add(int x, int y) {

        return x + y;
    }

    @Override
    public int subtract(int x, int y) {
        return x - y;
    }
}
