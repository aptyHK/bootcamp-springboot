package com.hkjava.bootcamp.exercise.mapper;

import com.hkjava.bootcamp.exercise.model.Company2;
import com.hkjava.bootcamp.exercise.model.ProfileQuoteDTO;
import com.hkjava.bootcamp.exercise.model.Quote;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
// import static com.hkjava.bootcamp.exercise.model.ProfileQuoteDTO.*;

public class ProfileAndQuoteMapper {
    public static ProfileQuoteDTO map(Company2 company2, Quote quote) {
        
        return ProfileQuoteDTO.builder()
            .companyProfile(ProfileQuoteDTO.CompanyProfile.builder()
                .country(company2.getCountry())
                .name(company2.getName())
                .ipo(company2.getIpo())
                .logo(company2.getLogo())
                .marketCapitalization(company2.getMarketCapitalization())
                .currency(company2.getCurrency())
                .build()
            )
            .c(quote.getC())
            .h(quote.getH())
            .l(quote.getL())
            .o(quote.getO())
            .pc(quote.getPc())
            .build();
    }
}
