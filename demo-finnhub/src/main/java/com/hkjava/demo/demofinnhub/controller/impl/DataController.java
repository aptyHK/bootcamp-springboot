package com.hkjava.demo.demofinnhub.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hkjava.demo.demofinnhub.controller.DataOperation;
import com.hkjava.demo.demofinnhub.entity.Stock;
import com.hkjava.demo.demofinnhub.entity.StockPrice;
import com.hkjava.demo.demofinnhub.service.CompanyService;
import com.hkjava.demo.demofinnhub.service.StockPriceService;

@RestController
@RequestMapping(value = "/api/v1")
public class DataController implements DataOperation {

    @Autowired
    private CompanyService companyService;

    @Autowired
    private StockPriceService stockPriceService;

    @Override
    public Stock save(Stock stock) {
        return companyService.save(stock);
    }

    @Override
    public List<Stock> findAll() {
        return companyService.findAll();
    }

    @Override
    public void updateCountryById(Long id, String country) {
        companyService.updateCountryById(id, country);
    }

    @Override
    public void deleteById(Long id) {
        companyService.deleteById(id);
    }

    public List<Stock> findAllById2() {
        return companyService.findAllById2();
    }

    @Override
    public void updateById(Long id, Stock stock) {
        companyService.updateById(id, stock);
    }

    @Override
    public void updateCompanyNameById(Long id, String companyName) {
        companyService.updateCompanyNameById(id, companyName);
    }

    @Override
    public StockPrice save(Long id, StockPrice stockPrice) {
        return stockPriceService.save(id, stockPrice);
    }
}
