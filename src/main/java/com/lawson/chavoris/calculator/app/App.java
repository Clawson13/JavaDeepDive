package com.lawson.chavoris.calculator.app;

import com.lawson.chavoris.calculator.calculators.StandardCalculator;

/**
 * Hello world!
 *
 */
public class App {

    // static StandardCalculator calc;
    public static void main(String[] args) {
        StandardCalculator calc = new StandardCalculator();
        calc.play();
        // calc.raise(5, 6);
    }
}