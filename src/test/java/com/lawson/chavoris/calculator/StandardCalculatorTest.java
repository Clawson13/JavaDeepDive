package com.lawson.chavoris.calculator;

import static org.junit.Assert.assertEquals;

import com.lawson.chavoris.calculator.calculators.StandardCalculator;

import org.junit.Test;

public class StandardCalculatorTest {
    
    StandardCalculator calc = new StandardCalculator();

    @Test
    public void addTest(){
        calc.add(1,1);
        int val = calc.getTotal();
        assertEquals(2, val);
    }
}