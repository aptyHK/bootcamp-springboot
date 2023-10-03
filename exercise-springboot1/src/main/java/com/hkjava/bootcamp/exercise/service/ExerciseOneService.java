package com.hkjava.bootcamp.exercise.service;

import java.util.List;

import com.hkjava.bootcamp.exercise.infra.BusinessException;
import com.hkjava.bootcamp.exercise.model.Company2;
import com.hkjava.bootcamp.exercise.model.Quote;

public interface ExerciseOneService {
    Company2 findCompany2(String companySymbol) throws BusinessException;
    Quote findQuote(String companySymbol) throws BusinessException;
}


