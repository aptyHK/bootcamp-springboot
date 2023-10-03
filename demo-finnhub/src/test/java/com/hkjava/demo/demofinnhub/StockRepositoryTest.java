package com.hkjava.demo.demofinnhub;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;


import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.hkjava.demo.demofinnhub.entity.Stock;
import com.hkjava.demo.demofinnhub.repository.StockRepository;

@DataJpaTest // Inject Repositiry to related Beans
// this annotation will point all the jpatest to the embedded in-memory database
// and the embedded in-memory database would roll back after each test  
public class StockRepositoryTest {

    @Autowired
    private StockRepository stockRepository;

    @Autowired
    private TestEntityManager entityManager;

    // if I am testing stockRepository work or not, 
    // should use another unit to perform test and compare result
    // so not use .save() and use entity to set the testing record
    // so if the real method stockRepository is working properly
    // then if should able to trigger entityManger and know ok or not
    // but entityManager is also a part of the magic
    // suppose need to test entityManager
    // but in norm, would not further test
    // entityManager is already on the another bottom layer
    // so it actually using a lower layer to test the upper layer
    // to complete the test
    // so don't use things on the same layer to test
    // stockRepository (.save()) to test stockRepository, no meaning    

    @Test
    void testFindById() {
        Stock entity = new Stock();
        // entity.setId(1L);
        entity.setCountry("CN");
        entity.setCompanyName("Orange Company");
        entity.setMarketCap(98761234.23);
        entityManager.persist(entity); // JPA <-> cache memory <-> database harddisk
        // about the cache memory layer: ..... (await I understand xD)
        entityManager.flush(); // Datavase commit -> harddisk

        // I am testing the "select * from table where id = 15;"
        Stock stock = stockRepository.findById(1L).orElse(null);
        //assertThat(stock, isNotNull());
        assertThat(stock, hasProperty("country", equalTo("CN")));

        entityManager.persist(entity); 
        entityManager.flush();
        Stock stock2 = stockRepository.findById(2L).orElse(null);
    }

    // Now, I want to test about Jpa
    // e.g. when I do @Postmapping, do I really only insert 1 record and not 2
    // records?
    // I cannot see the code behind, how do I confirm Jpa is doing the correct
    // things?
    // do deleteById actually do as truncate by Jpa?

    @Test
    void testDeleteById() {
        Stock stock = new Stock();
        stock.setCountry("CN");
        
    }

}
