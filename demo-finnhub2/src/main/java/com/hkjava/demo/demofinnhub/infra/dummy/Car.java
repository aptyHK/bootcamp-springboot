package com.hkjava.demo.demofinnhub.infra.dummy;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Component
@AllArgsConstructor
public class Car {
    int speed = 0;

    public Car() {

    }
}
