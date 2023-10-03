package com.hkjava.demo.demofinnhub.service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.hkjava.demo.demofinnhub.entity.StockSymbol;
import com.hkjava.demo.demofinnhub.exception.FinnhubException;
import com.hkjava.demo.demofinnhub.infra.BusinessException;
import com.hkjava.demo.demofinnhub.infra.Code;
import com.hkjava.demo.demofinnhub.infra.Protocol;
import com.hkjava.demo.demofinnhub.model.Exchange;
import com.hkjava.demo.demofinnhub.service.ExchangeService;

import jakarta.persistence.Column;

@Service
public class ExchangeServiceImpl implements ExchangeService {

    @Autowired
    @Qualifier(value = "finnhubToken")
    private String token;

    @Autowired
    RestTemplate restTemplate;

    @Value(value = "${api.finnhub.domain}")
    private String domain;

    @Value(value = "${api.finnhub.base-url}")
    private String baseUrl;

    @Value(value = "${api.finnhub.endpoints.exchange}")
    private String exchangeEndpoint;

    @Override
    public void saveAll(String symbol) throws BusinessException{
        try {
            List<Exchange> exchanges = this.findAll(symbol);
            List<StockSymbol> stockSymbols = exchanges.stream()
                .map(before -> StockSymbol.builder()
                    .currency(before.getCurrency())
                    .desciption(before.getDescription())
                    .displaySymbol(before.getDesplaySymbol())
                    .figiIdentifier(before.getFigiIdentifier())
                    .isin(before.getIsin())
                    .primaryExchangeMIC(before.getPrimaryExchangeMIC())
                    .shareClassFIGI(before.getShareClassFIGI())
                    .symbol(before.getSymbol())
                    .alternativeTicker(before.getAlternativeTicker())
                    .securityType(before.getSecurityType())
                    .build();
                    )
                .collector(Collectors.toList());

                
        } catch (FinnhubException e) {
            
        }
    }
    

    @Override
    public List<Exchange> findAll(String symbol) throws FinnhubException {
        String url = UriComponentsBuilder.newInstance()
            .scheme(Protocol.HTTPS.name().toLowerCase())
            .host(domain)
            .path(baseUrl)
            .path(exchangeEndpoint)
            .queryParam("exchange", symbol)
            .queryParam("token", token)
            .build()
            .toUriString();

        System.out.println("url="+url);
        try {
            Exchange[] exchanges = restTemplate.getForObject(url, Exchange[].class);
            return Arrays.asList(exchanges);
        } catch (RestClientException e) {
            throw new FinnhubException(Code.FINNHUB_EXCHANGE_NOTFOUND);
        }
    }
}
