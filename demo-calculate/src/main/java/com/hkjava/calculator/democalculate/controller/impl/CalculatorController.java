package com.hkjava.calculator.democalculate.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hkjava.calculator.democalculate.controller.CalculatorOperation;
import com.hkjava.calculator.democalculate.service.CalculatorService;

//@Controller
//@ResponseBody
@RestController // @Controller + @ResponseBody
@RequestMapping(value = "/api/cal")
public class CalculatorController implements CalculatorOperation {

    // @GetMapping(value = "/calculator")
    // String start();

    // http://localhost:8080/api/cal/add?x=10&y=20
    @Autowired
    CalculatorService calculatorService;
    // if Autowired cannot find any service, destroy itself (here mean CalculatorService calculatorService)

    @Override
    public List<String> getStrings() {
        return calculatorService.getStrings();
    }

    @Override
    public Integer add(int salary, int bonus, String dividend) {
        int d = 0;
        try {
            d = Integer.valueOf(dividend); //
        } catch (NumberFormatException e) {
            d = 0;
        }
        return calculatorService.add(salary + bonus, d);
    }

    @Override
    public Integer subtract(int x, int y, String z) {
        return calculatorService.subtract(x + y, 0);
    }

}
