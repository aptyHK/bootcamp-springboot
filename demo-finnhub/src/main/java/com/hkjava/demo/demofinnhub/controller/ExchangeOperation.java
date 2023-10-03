package com.hkjava.demo.demofinnhub.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.hkjava.demo.demofinnhub.model.Exchange;

public interface ExchangeOperation {

    @GetMapping(value = "/exchanges/{symbol}")
    @ResponseStatus(value = HttpStatus.OK)
    List<Exchange> findAll(@PathVariable String symbol) throws Exception;   
    
    @PostMapping(value = "/exchanges/{symbol}/saveall")
    @ResponseStatus(value = HttpStatus.OK)
    void saveAll(@PathVariable String symbol);
}
