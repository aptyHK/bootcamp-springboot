package com.hkjava.demo.demofinnhub.model.dto;

import com.hkjava.demo.demofinnhub.annotation.SymbolCheck;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class SymbolDTO {
  
  @SymbolCheck
  String symbol;

}
