package com.lawson.chavoris.calculator.abstractions;

public abstract class BaseMathCalculator {
    public abstract void turnOn();

    public abstract void turnOff();

    public abstract void play();

    public abstract void clear();

    public abstract void total();

    public abstract void help();
    public abstract void add(int a,int b);
    public abstract void add(int a);

    public abstract void subtract(int a, int b);
    public abstract void subtract(int a);

    public abstract void multiply(int a, int b);
    public abstract void multiply(int a);

    public abstract void divide(int a, int b);
    public abstract void divide(int a);

    public abstract void powOf2();
    public abstract void powOf2(int a);

}