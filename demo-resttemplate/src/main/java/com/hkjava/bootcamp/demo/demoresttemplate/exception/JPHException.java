package com.hkjava.bootcamp.demo.demoresttemplate.exception;

import com.hkjava.bootcamp.demo.demoresttemplate.infra.BusinessException;
import com.hkjava.bootcamp.demo.demoresttemplate.infra.Code;

public class JPHException extends BusinessException {
    
    public JPHException(Code code) {
        super(code);
    }
}
