package com.hkjava.bootcamp.exercise.exercisespringboot1;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.hkjava.bootcamp.exercise.mapper.ProfileAndQuoteMapper;
import com.hkjava.bootcamp.exercise.model.Company2;
import com.hkjava.bootcamp.exercise.model.ProfileQuoteDTO;
import com.hkjava.bootcamp.exercise.model.Quote;
import com.hkjava.bootcamp.exercise.model.ProfileQuoteDTO.CompanyProfile;
import com.hkjava.bootcamp.exercise.service.ExerciseOneService;

@WebMvcTest
public class ExerciseOneControllerTest {
    
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ExerciseOneService exerciseOneService;

    @Test
    void testGetProfileAndQuote() throws Exception {
        Company2 company2One = new Company2("Country A", null, null, null, null, null, null, 1.0d, null, null, 1.0d, null, null);
        // Company2 company2Two = new Company2("Country B", null, null, null, null, null, null, 2.0d, null, null, 2.0d, null, null);
        Quote quote1 = new Quote(1.0d, 1.0d, 1.0d, 1.0d, 1.0d, 1.0d, 1.0d, 1L);
        // Quote quote2 = new Quote(2.0d, 2.0d, 2.0d, 2.0d, 2.0d, 2.0d, 2.0d, 2L);
        String symbol1 = "AAPL";
        //String symbol2 = "MSFT";
        ProfileQuoteDTO stock1 = 
        new ProfileQuoteDTO(
            new CompanyProfile("Country A", null, null, null, 1.0d, null),
            1.0d,
            1.0d,
            1.0d,
            1.0d,
            1.0d
        );

        Mockito.when(ProfileAndQuoteMapper.map(company2One, quote1)).thenReturn(stock1);

        // mockMvc.perform(get("/api/v1/stock?symbol=MSFT"))
        //     .
        
        // Mockito.when(exerciseOneService.findCompany2(symbol1)).thenReturn(company2One);
    }
}
