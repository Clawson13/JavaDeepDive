package com.lawson.chavoris.calculator.interfaces;

public interface BaseMathCalculator {
    void turnOn();

    void turnOff();

    void play();

    void clear();

    void total();

    void help();
    void add(int a,int b);
    void add(int a);

    void subtract(int a, int b);
    void subtract(int a);

    void multiply(int a, int b);
    void multiply(int a);

    void divide(int a, int b);
    void divide(int a);

    void powOf2();
    void powOf2(int a);

}