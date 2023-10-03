package com.hkjava.bootcamp.demo.demoresttemplate.infra;

public class BusinessException extends Exception {

    private int code;

    public BusinessException(Code code) {
        super(code.getDesc());
        this.code = code.getCode();
    }
}
