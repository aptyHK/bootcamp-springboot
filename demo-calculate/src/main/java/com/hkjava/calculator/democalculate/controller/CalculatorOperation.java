package com.hkjava.calculator.democalculate.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


public interface CalculatorOperation {

    @GetMapping(value = "/strings")
    List<String> getStrings();

    // Usually when a lot of input param, would use RequestParam
    // When use PathVariable, can even hide field name

    // http://localhost:8080/api/cal/add?x=10&y=20
    @GetMapping(value = "/add")
    Integer add(@RequestParam int salary // 
        , @RequestParam(name = "_") int bonus // if put 10 on url, it is "10", but springboot do something you can't see to put the string "10" to int 10
        // you don't necessary to concern how it do
        , @RequestParam(name = "z", required = false, defaultValue = "100") String dividend);
        //, @RequestParam int k;
    // would still show x and y on url, use to hide the actual meaning of the param
    // if mis type param, would have 400 bad request
    // required default is true, if set to false, won't have error 400 even not input this param
    // set to string so can handle any input case


    @GetMapping(value = {"/subtract/{x}/{y}/{z}", "/subtract/{x}/{y}"})
    // use {} to make it as array
    // Must need to write all possibility of paths that can call the method
    // on url, there is not type, everything get on the url, is String
    // subtract is the entrance, in here only accept 2 param or 3 param
    // the order of the param in the abstract method is not matter
    Integer subtract(@PathVariable(name = "x") int salary, //
        @PathVariable(name = "y") int bonus, //
        @PathVariable(name = "z", required = false) String dividend);

}
