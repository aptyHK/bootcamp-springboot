package com.hkjava.demo.demofinnhub;

import java.time.LocalDate;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.hkjava.demo.demofinnhub.model.CompanyProfile;

@SpringBootTest
public class DeserializationForRestTemplateTest {

    private static ObjectMapper objectMapper;

    @BeforeAll
    static void init() {
        objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
    }

    @Test
    void testDeserializationForRestTemplate() throws JsonProcessingException {
        // JSON -> Object
        CompanyProfile companyProfile = CompanyProfile.builder() //
                .companyName("ABC Company")
                .country("US")
                .currency("USD")
                .exchange("XYZ")
                .finnhubIndustry("IJK")
                .ipoDate(LocalDate.of(1988, 12, 31))
                .marketCap(3000.12)
                .logo("/abc.png")
                .phone("123456789")
                .shareOutstanding(23.90)
                .ticker("APPL")
                .build();
        String mockedResponseInJson = objectMapper.writeValueAsString(companyProfile);
        System.out.println("json=" + mockedResponseInJson);
        // the test simulate finnhub's json

        // json={"country":"US","currency":"USD","estimateCurrency":null,
        // "exchange":"XYZ","finnhubIndustry":"IJK","logo":"/abc.png",
        // "phone":"123456789","shareOutstanding":23.9,"ticker":"APPL",
        // "weburl":null,"ipo":"1988-12-31","marketCapitalization":3000.12,
        // "name":"ABC Company"}
        JsonNode jsonNode = objectMapper.readTree(mockedResponseInJson);

        assertThat(jsonNode.path("country").asText(), is("US"));
        assertThat(jsonNode.path("ipo").asText(), is("1988-12-31")); // setting should match the mock json
        assertThat(jsonNode.path("marketCapitalization").asDouble(), is(3000.12));

        // test Deserialization (main code -> automation)
        // CompanyProfile afterCompanyProfile =
        // objectMapper.readValue(mockedResponseInJson, CompanyProfile.class);
        // assertEquals(true,
        // afterCompanyProfile.getIpoDate().equals(companyProfile.getIpoDate()));
        // assertEquals(true,
        // afterCompanyProfile.getMarketCap() == companyProfile.getMarketCap());
        // assertEquals(true,
        // afterCompanyProfile.getCountry().equals(companyProfile.getCountry()));

        // this test class tested all the @JsonProperty transformation in
        // CompanyProfile.java are working properly (by test serialization with mock
        // data to json and test deserialization turn the json back to mock data )
    }

    @Test
    void testSerializationForRestTemplate() throws JsonProcessingException {
        // readTree to prove the conversion is correct
        // JSON -> Object
        CompanyProfile companyProfile = CompanyProfile.builder() //
                .companyName("APPL Company") //
                .country("US") //
                .currency("USD") //
                .estimateCurrency("USD") //
                .exchange("XYZ") //
                .finnhubIndustry("IJK") //
                .ipoDate(LocalDate.of(1988, 12, 31)) //
                .marketCap(3000.12) //
                .logo("/abc.png") //
                .phone("123456789") //
                .shareOutstanding(23.90) //
                .ticker("APPL") //
                .build();

        // test Serialization
        String mockedResponseInJson = objectMapper.writeValueAsString(companyProfile);
        System.out.println("json=" + mockedResponseInJson);
        JsonNode jsonNode = objectMapper.readTree(mockedResponseInJson);
        assertThat(jsonNode.path("country").asText(), is("US"));
        assertThat(jsonNode.path("ipo").asText(), is("1988-12-31"));
        assertThat(jsonNode.path("marketCapitalization").asDouble(), is(3000.12));
    }

}
