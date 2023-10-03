package com.hkjava.demo.demofinnhub.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.hkjava.demo.demofinnhub.entity.Stock;
import com.hkjava.demo.demofinnhub.entity.StockPrice;

public interface DataOperation {

    @PostMapping(value = "/data/stock")
    @ResponseStatus(value = HttpStatus.OK)
    Stock save(@RequestBody Stock stock);

    @GetMapping(value = "/data/allstock")
    @ResponseStatus(value = HttpStatus.OK)
    List<Stock> findAll();

    @PutMapping(value = "data/stock/{id}/country/{country}")
    @ResponseStatus(value = HttpStatus.OK)
    void updateCountryById(@PathVariable Long id, @PathVariable String country);

    @DeleteMapping(value = "/data/stock/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    void deleteById(@PathVariable Long id);

    @GetMapping(value = "/data/findAllById2")
    @ResponseStatus(value = HttpStatus.OK)
    List<Stock> findAllById2();

    @PutMapping(value = "/data/stock/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    void updateById(@PathVariable Long id, @RequestBody Stock stock);

    @PatchMapping(value = "/data/stock/id/{id}/companyname/{companyName}")
    @ResponseStatus(value = HttpStatus.OK)
    void updateCompanyNameById(@PathVariable Long id,
            @PathVariable String companyName);

    //
    @PostMapping("/data/stock/{id}/price")
    @ResponseStatus(value = HttpStatus.OK)
    StockPrice save(@PathVariable Long id, @RequestBody StockPrice stockPrice);
}
