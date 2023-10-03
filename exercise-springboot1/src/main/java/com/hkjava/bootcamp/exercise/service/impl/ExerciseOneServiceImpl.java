package com.hkjava.bootcamp.exercise.service.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.hkjava.bootcamp.exercise.exception.FHException;
import com.hkjava.bootcamp.exercise.infra.BusinessException;
import com.hkjava.bootcamp.exercise.infra.Code;
import com.hkjava.bootcamp.exercise.infra.Protocol;
import com.hkjava.bootcamp.exercise.model.Company2;
import com.hkjava.bootcamp.exercise.model.Quote;
import com.hkjava.bootcamp.exercise.service.ExerciseOneService;

@Service
public class ExerciseOneServiceImpl implements ExerciseOneService {

    @Autowired
    private RestTemplate restTemplate;

    @Value(value = "${api.finnhub.domain}")
    private String fhDomain;

    @Value(value = "${api.finnhub.basepath}")
    private String basePath;

    @Value(value = "${api.finnhub.endpoints.stock.profile2}")
    private String comapny2Endpoint;

    @Value(value = "${api.finnhub.endpoints.quote}")
    private String stockEndPoint;

    @Value(value = "${api.finnhub.token}")
    private String fhMyToken;

    public Company2 findCompany2(String companySymbol) throws BusinessException {
        String url = UriComponentsBuilder.newInstance()
                .scheme(Protocol.HTTPS.name())
                .host(fhDomain)
                .path(basePath)
                .path(comapny2Endpoint)
                .queryParam("symbol", companySymbol)
                .queryParam("token", fhMyToken)
                .toUriString();

        System.out.println("url=" + url);

        try {
            Company2 company2 = restTemplate.getForObject(url, Company2.class);
            return company2;
        } catch (RestClientException e) {
            throw new FHException(Code.FH_NOTFOUND); // if can't call server, throw BusinessException
        }
    }

    public Quote findQuote(String companySymbol) throws BusinessException {
        String url = UriComponentsBuilder.newInstance()
                .scheme(Protocol.HTTPS.name())
                .host(fhDomain)
                .path(basePath)
                .path(stockEndPoint)
                .queryParam("symbol", companySymbol)
                .queryParam("token", fhMyToken)
                .toUriString();

        System.out.println("url=" + url);

        try {
            Quote quote = restTemplate.getForObject(url, Quote.class);
            return quote;
        } catch (RestClientException e) {
            throw new FHException(Code.FH_NOTFOUND); // if can't call server, throw BusinessException
        }
    }

    // public static void main(String[] args) {
    // String url = UriComponentsBuilder.newInstance()
    // .scheme(Protocol.HTTPS.name())
    // .host("finnhub.io")
    // .path("/api/v1")
    // .path("/stock/profile2")
    // .queryParam("symbol", "AAPL")
    // .queryParam("token", "ck4fiehr01qus81pv330ck4fiehr01qus81pv33g")
    // .toUriString();

    // System.out.println("url=" + url);
    // }
}
