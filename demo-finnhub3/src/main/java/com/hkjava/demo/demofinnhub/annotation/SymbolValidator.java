package com.hkjava.demo.demofinnhub.annotation;

import java.util.Objects;
import com.hkjava.demo.demofinnhub.config.AppStartRunner;
import com.hkjava.demo.demofinnhub.model.dto.SymbolDTO;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class SymbolValidator
    implements ConstraintValidator<SymbolCheck, SymbolDTO> {

  @Override
  public boolean isValid(SymbolDTO symbol, ConstraintValidatorContext context) {
    return Objects.nonNull(symbol.getSymbol())
        && AppStartRunner.availableStockList.contains(symbol.getSymbol());
  }

}
