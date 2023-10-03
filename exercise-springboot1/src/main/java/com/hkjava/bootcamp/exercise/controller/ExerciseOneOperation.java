package com.hkjava.bootcamp.exercise.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hkjava.bootcamp.exercise.infra.ApiResponse;
import com.hkjava.bootcamp.exercise.model.Company2;
import com.hkjava.bootcamp.exercise.model.ProfileQuoteDTO;
import com.hkjava.bootcamp.exercise.model.Quote;

public interface ExerciseOneOperation {
    @GetMapping(value = "/stock")
    ResponseEntity<ApiResponse<ProfileQuoteDTO>> findCompanyStockInfo(
        @RequestParam(name = "symbol") String companySymbol) throws Exception;
}
