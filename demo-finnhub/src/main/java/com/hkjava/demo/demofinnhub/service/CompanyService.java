package com.hkjava.demo.demofinnhub.service;

import java.util.List;

import com.hkjava.demo.demofinnhub.entity.Stock;
import com.hkjava.demo.demofinnhub.exception.FinnhubException;
import com.hkjava.demo.demofinnhub.model.CompanyProfile;

public interface CompanyService {
  
  CompanyProfile getCompanyProfile(String symbol) throws FinnhubException;
  
  Stock save(Stock stock);

  List<Stock> findAll();

  void updateCountryById(Long id, String country);

  void deleteById(Long id);

  List<Stock> findAllById2();

  void updateById(Long id, Stock stock);

  void updateCompanyNameById(Long id, String companyName);
}
