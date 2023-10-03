package com.hkjava.demo.demofinnhub.infra;

import lombok.Getter;

@Getter
public class Car {

  int speed = 0;

  public Car(int speed) {
    this.speed = speed;
  }

}
