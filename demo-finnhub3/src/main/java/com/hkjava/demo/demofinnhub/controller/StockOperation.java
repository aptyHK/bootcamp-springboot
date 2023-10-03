package com.hkjava.demo.demofinnhub.controller;

import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.hkjava.demo.demofinnhub.annotation.SymbolCheck;
import com.hkjava.demo.demofinnhub.exception.FinnhubException;
import com.hkjava.demo.demofinnhub.infra.ApiResponse;
import com.hkjava.demo.demofinnhub.model.dto.StockDTO;
import com.hkjava.demo.demofinnhub.model.dto.SymbolDTO;

@Validated
public interface StockOperation {

  @GetMapping(value = "/stock")
  @ResponseStatus(value = HttpStatus.OK)
  ApiResponse<StockDTO> stockInfo(@SymbolCheck @RequestParam("symbol") SymbolDTO symbol)
      throws FinnhubException;

  // @GetMapping(value = "/stockfromdb")
  // @ResponseStatus(value = HttpStatus.OK)
  // ApiResponse<StockDTO> stockInfoFromDb(@RequestParam("symbol") String symbol)
  //     throws FinnhubException;

}
