package com.hkjava.bootcamp.exercise.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class ProfileQuoteDTO {
    private CompanyProfile companyProfile;
    @JsonProperty("currentPrice")
    private double c;
    @JsonProperty("dayHigh")
    private double h;
    @JsonProperty("dayLow")
    private double l;
    @JsonProperty("dayOpen")
    private double o ;
    @JsonProperty("prevDayClose")
    private double pc;

    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class CompanyProfile {
        private String country;
        @JsonProperty("companyName")
        private String name;
        @JsonProperty("ipoDate")
        private String ipo;
        private String logo;
        @JsonProperty("marketCap")
        private double marketCapitalization;
        private String currency;
    }
}
