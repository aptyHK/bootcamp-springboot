package com.hkjava.demo.demofinnhub;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.web.client.RestTemplate;

import com.hkjava.demo.demofinnhub.entity.Stock;
import com.hkjava.demo.demofinnhub.exception.FinnhubException;
import com.hkjava.demo.demofinnhub.model.CompanyProfile;
import com.hkjava.demo.demofinnhub.repository.StockRepository;
import com.hkjava.demo.demofinnhub.service.CompanyService;
import com.hkjava.demo.demofinnhub.service.StockPriceService;

@SpringBootTest
public class CompanyServiceTest {

    // Hamcrest, hasItem() -> test Array
    @MockBean // service autowired repository
    private StockRepository stockRepository;
    // I cannot when something real
    // so I need to mock the Repository for testing with when and call method in StockRepository
    // instead of using real method to give me real result

    @Autowired // I really want to call the acutal method thats why no need InjectMock
    private CompanyService companyService;

    @Autowired // I really want to use the below token that I set to form expectedUrl so no need mock and use autowired
    private String token = "ck46ck1r01qus81pqgegck46ck1r01qus81pqgf0";

    @MockBean
    private RestTemplate restTemplate;
    // must mock restTemplate instead of Autowired because need to use inside when()
    // it set to autowired, will report compile error directly

    @Test
    void testFindAll() {
        Stock stock1 = Stock.builder().id(1L).country("US").build();
        Stock stock2 = Stock.builder().id(2L).country("CN").build();
        // Stock stock3 = Stock.builder().id(4L).country("US").build();
        // Stock stock4 = Stock.builder().id(7L).country("US").build();
        // Stock stock5 = Stock.builder().id(5L).country("AU").build();

        Mockito.when(stockRepository.findAll()).thenReturn(List.of(stock1, stock2));
        // Mockito.when(stockRepository.findAllById2("US")).thenReturn(List.of(stock3, stock4));

        List<Stock> stocks = companyService.findAll();
        assertThat(stocks, hasItem(hasProperty("country", equalTo("CN"))));
        assertThat(stocks, not(hasItem(hasProperty("country", equalTo("HK")))));

        // List<Stock> stocks2 = companyService.findAllById2();
        // assertThat(stocks2, hasItem(hasProperty("id", equalTo(4L))));
        // assertThat(stocks2, hasItem(hasProperty("id", equalTo(7L))));
        // assertThat(stocks2, not(hasItem(hasProperty("id", equalTo(5L)))));
    }

    @Test
    void testUrl() throws FinnhubException {
        // ...I am testing the magic of how the real method form the url
        // if i really able to form the correct url
        // i would get the mockProfile as I triggered the condition set in when()
        // if not able to form the correct url with the real method
        // would get null
        // then fail the test case because null do not has the checking Property
        String expectedUrl = "https://finnhub.io/api/v1/stock/profile2?symbol=AAPL&token="
                .concat(token);

        CompanyProfile mockedCompanyProfile = CompanyProfile.builder() //
                .country("US") //
                .ipoDate(LocalDate.of(1988, 12, 31)) //
                .build();

        Mockito.when(restTemplate.getForObject(expectedUrl, CompanyProfile.class))
                .thenReturn(mockedCompanyProfile);
        CompanyProfile profile = companyService.getCompanyProfile("AAPL"); // return null if the real method is not written properly
        assertThat(profile, hasProperty("country", equalTo("US")));
    }

    // test case is meaningful even the company is not apply TDD
    // because you don't really need to ask different people to test on the program to confirm it is right
    // if cannot pass the case, cannot form a jar
    // if you really have the concept, you can directly understand is the test case is well tested necessary things by reading the test case code 
    // also, it can prevent any change would ruin the correct logic
    // as the test case always follow the project
    // if test case run fail next time, mean that the new logic ruined the correct logic, so know that need to fix it
    // more like, TDD not necessary
    // but is very great to write test at any time
    // also test case is very good and easy to work with audit

}
