package com.hkjava.calculator.democalculate.service;

import java.util.List;

public interface CalculatorService {
    
    /**
     * 
     * @return
     */
    List<String> getStrings();

    /**
     * 
     * @param x
     * @param y
     * @return
     */
    int add(int x, int y);

    /**
     * 
     * @param x
     * @param y
     * @return
     */
    int subtract(int x, int y);
}
