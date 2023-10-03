package com.hkjava.bootcamp.exercise.controller.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hkjava.bootcamp.exercise.controller.ExerciseOneOperation;
import com.hkjava.bootcamp.exercise.infra.ApiResponse;
import com.hkjava.bootcamp.exercise.mapper.ProfileAndQuoteMapper;
import com.hkjava.bootcamp.exercise.model.Company2;
import com.hkjava.bootcamp.exercise.model.ProfileQuoteDTO;
import com.hkjava.bootcamp.exercise.model.Quote;
import com.hkjava.bootcamp.exercise.service.ExerciseOneService;

@RestController
@RequestMapping(value = "/api/v1")
public class ExerciseOneController implements ExerciseOneOperation {

    @Autowired
    ExerciseOneService exerciseOneService;

    @Override
    public ResponseEntity<ApiResponse<ProfileQuoteDTO>> findCompanyStockInfo(String companySymbol) throws Exception {
        Company2 company2 = exerciseOneService.findCompany2(companySymbol);
        Quote quote = exerciseOneService.findQuote(companySymbol);

        ProfileQuoteDTO profileQuoteDTO = ProfileAndQuoteMapper.map(company2, quote);

        ApiResponse<ProfileQuoteDTO> response = ApiResponse.<ProfileQuoteDTO>builder() //
            .ok() //
            .data(profileQuoteDTO) //
            .build();

        return ResponseEntity.ok().body(response);
    }
}
