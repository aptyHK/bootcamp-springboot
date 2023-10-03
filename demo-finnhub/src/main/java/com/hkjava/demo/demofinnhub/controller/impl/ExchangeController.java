package com.hkjava.demo.demofinnhub.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hkjava.demo.demofinnhub.controller.ExchangeOperation;
import com.hkjava.demo.demofinnhub.entity.Stock;
import com.hkjava.demo.demofinnhub.model.Exchange;
import com.hkjava.demo.demofinnhub.service.ExchangeService;

@RestController
@RequestMapping(value = "/api/v1")
public class ExchangeController implements ExchangeOperation {

    @Autowired
    ExchangeService exchangeService;

    @Override
    public List<Exchange> findAll(String symbol) throws Exception {
        return exchangeService.findAll(symbol);
    }

    @Override
    public void saveAll(String symbol) {
        exchangeService.saveAll(symbol);
    }
}
