package com.lawson.chavoris.calculator.app;

import com.lawson.chavoris.calculator.calculators.StandardCalculator;

/**
 * Runs Calculator application
 * 
 * @author Chavoris Lawson
 */
public class App {
    public static void main(String[] args) {
        StandardCalculator calc = new StandardCalculator();
        calc.play();
    }
}