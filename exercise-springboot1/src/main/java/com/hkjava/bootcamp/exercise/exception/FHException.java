package com.hkjava.bootcamp.exercise.exception;

import com.hkjava.bootcamp.exercise.infra.BusinessException;
import com.hkjava.bootcamp.exercise.infra.Code;

public class FHException extends BusinessException {
    public FHException(Code code) {
        super(code);
    }
}
