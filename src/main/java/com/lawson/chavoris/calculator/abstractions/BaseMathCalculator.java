package com.lawson.chavoris.calculator.abstractions;

public abstract class BaseMathCalculator {
    public abstract void turnOn();

    public abstract void turnOff();

    public abstract void play();

    public abstract void clear();

    public abstract void total();

    public abstract void help();
    public abstract void add(double a,double b);
    public abstract void add(double a);

    public abstract void subtract(double a, double b);
    public abstract void subtract(double a);

    public abstract void multiply(double a, double b);
    public abstract void multiply(double a);

    public abstract void divide(double a, double b);
    public abstract void divide(double a);

    public abstract void powOf2();
    public abstract void powOf2(double a);

}