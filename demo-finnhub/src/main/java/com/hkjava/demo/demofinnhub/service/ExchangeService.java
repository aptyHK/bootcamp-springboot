package com.hkjava.demo.demofinnhub.service;

import java.util.List;

import com.hkjava.demo.demofinnhub.exception.FinnhubException;
import com.hkjava.demo.demofinnhub.model.Exchange;

public interface ExchangeService {
    List<Exchange> findAll(String symbol) throws FinnhubException;

    void saveAll(String symbol);
}
