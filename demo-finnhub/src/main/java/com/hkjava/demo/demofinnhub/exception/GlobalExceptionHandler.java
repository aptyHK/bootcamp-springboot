package com.hkjava.demo.demofinnhub.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.hkjava.demo.demofinnhub.infra.ApiResponse;
import com.hkjava.demo.demofinnhub.infra.Code;
import com.hkjava.demo.demofinnhub.model.dto.StockDTO;

import jakarta.persistence.EntityNotFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(value = FinnhubException.class)
  @ResponseStatus(value = HttpStatus.OK)
  public ApiResponse<Void> finnhubExceptionHandler(FinnhubException e) {
    return ApiResponse.<Void>builder() //
        .status(Code.fromCode(e.getCode())) //
        .data(null) //
        .build();
  }

  @ExceptionHandler(value = RuntimeException.class)
  @ResponseStatus(value = HttpStatus.BAD_REQUEST)
  public ApiResponse<Void> iAEExceptionHandler(RuntimeException e) {
    return ApiResponse.<Void>builder() //
        .status(getRespCode(e)) //
        .concatMessageIfPresent(e.getMessage())
        .data(null) //
        .build();
  }

  private static Code getRespCode(Exception e) {
    if (e instanceof IllegalArgumentException) {
      return Code.IAE_EXCEPTION;
    } if (e instanceof EntityNotFoundException) {
      return Code.ENTITY_NOTFOUND;
    }
    return null;
  }
}
