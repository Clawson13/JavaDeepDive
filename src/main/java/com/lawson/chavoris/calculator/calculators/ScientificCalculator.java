package com.lawson.chavoris.calculator.calculators;

public class ScientificCalculator extends StandardCalculator {
    
    private int total;

    public void raise(int a, int b) {
        total = a ^ b;
    }

    public void raise(int a) {
        total ^= a;
    }
}