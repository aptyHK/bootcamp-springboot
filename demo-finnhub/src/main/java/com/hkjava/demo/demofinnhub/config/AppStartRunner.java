package com.hkjava.demo.demofinnhub.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class AppStartRunner implements CommandLineRunner {
  
  @Override
  public void run(String ... args) {
    // Before Server Start:
    // 0. Get all symbols (US) from the below API.
    //    https://finnhub.io/api/v1/stock/symbol?exchange=US
    // 1. Get Compnay Profile 2 and insert into database
    // 2. Get Stock price and insert into database
    System.out.println("runner start ....");
  }

}