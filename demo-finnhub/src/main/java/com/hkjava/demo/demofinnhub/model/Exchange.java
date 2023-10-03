package com.hkjava.demo.demofinnhub.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Exchange {
    //@JsonProperty(value = "currency")
    private String currency;
    private String description;
    private String displaySymbol;
    @JsonProperty(value = "figi")
    private String figiIdentifier;
    private String isin;
    @JsonProperty(value = "mic")
    private String primaryExchangeMIC;
    private String shareClassFIGI;
    private String symbol;
    @JsonProperty(value = "symbol2")
    private String alternativeTicker;
    @JsonProperty(value = "type")
    private String securityType;
}
