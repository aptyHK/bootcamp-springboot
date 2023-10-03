package com.hkjava.bootcamp.exercise.infra;

import lombok.Getter;

@Getter
public enum Code {
    OK(20000, "OK"), // set as 20000 in purpose, to show people the code is under control as 20000 is not in range of any default code
    // 40000 - 49999
    NOTFOUND(40000, "Resource NOT FOUND"), //
    FH_NOTFOUND(40001, "finnhub NOT FOUND"), // 
    // Server
    SERVER_TIMEOUT(50000, "Server Timeout") // can reach to server but long time no response
    ;

    int code;
    String desc;

    private Code(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
