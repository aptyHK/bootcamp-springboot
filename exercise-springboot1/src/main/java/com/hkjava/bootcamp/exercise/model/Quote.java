package com.hkjava.bootcamp.exercise.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Quote {
    private double c;//currentPrice;
    private double d;//change;
    private double dp;//percentChange;
    private double h;//highPriceOfTheDay;
    private double l;//lowPriceOfTheDay;
    private double o;//openPriceOfTheDay;
    private double pc;//previousClosePrice;
    private long t;//time; // second

}
