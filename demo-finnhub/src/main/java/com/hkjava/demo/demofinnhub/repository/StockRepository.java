package com.hkjava.demo.demofinnhub.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hkjava.demo.demofinnhub.entity.Stock;

@Repository
public interface StockRepository extends JpaRepository<Stock, Long> {
    // find()
    // findAll()
    // insert()
    // ...

    List<Stock> findByCompanyName(String companyName); 
    //why this method would work as a query? Because Jpa would able to read the method name and translate to the database side as a query

    // select * from table where company_name = "";
    // List<Stock> findByCompanyName(String companyName); 


    // update stocks set field = x where field = ?
    // there is no update method on Jpa
    // so the solution is: (Put/ Patch) findById() -> set() -> save
    // remember post mapping is insert, if want to update, should use put/ patch mapping 

    @Query(value = "select s.id, s.country, s.company_name, s.ipo_date, s.logo, s.market_cap, s.currency from finnhub_stocks s where s.country = :country",
    nativeQuery = true)
    // native = native to PostgresSQL, so you are responsible to the query you wrote
    // if use @Query, method name is not use as query anymore
    List<Stock> findAllById2(@Param(value = "country") String country);

    @Query(value = "select s from Stock s where s.id = :id")
    List<Stock> findAllById3(@Param(value = "id") Long id);

    // 3 ways to write query
    // 1. method name
    // 1. @Query with nativeQuery = true, directly use the query that you wrote to communicate with the database you assigned, then method name no longer use as query
    // 2. @Query not native -> JPQL (Java Persistence query language), write the query as JPQL way, and Jpa will translate it to the databasse, also method name no longer use as query

    // should not select *
    // if one day someone added a column on database, then you can form your stock object you design
}
