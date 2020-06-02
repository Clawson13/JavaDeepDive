package com.lawson.chavoris.calculator.calculators;

import java.util.Scanner;

import com.lawson.chavoris.calculator.abstractions.BaseMathCalculator;

public class StandardCalculator extends BaseMathCalculator {

    private double total;
    private String sTotal="0";
    protected static final String ENTER_MESSAGE = "Enter a number: ";
    Scanner s = new Scanner(System.in);
    double a = 0;
    double b = 0;

    // make this more modular like adding being able to read multiple arguments like
    // the command line and reading symbols.
    public void play() {
        help();
        String op = "";
        while (!op.equalsIgnoreCase("exit")) {
            op = s.nextLine();
            selectOperation(op);
        }
    }

    private void selectOperation(String op) {
        if (op.equals("+")) {
            add();
        } else if (op.equals("-")) {
            subtract();
        } else if (op.equals("*")) {
            multiply();
        } else if (op.equals("/")) {
            divide();
        } else if (op.equals("^")) {
            powOf2();
        } else if (op.equalsIgnoreCase("-h")) {
            help();
        } else if (op.equalsIgnoreCase("-e")) {
            System.out.println("Goodbye!");
            s.close();
            System.exit(0);
        } else if (op.equalsIgnoreCase("-c")) {
            clear();
            total();
        } else {
            System.out.println("That's not a valid command.");
        }
    }

    public void help() {
        String helpMessage = 
        "Enter: \n"+
        "+ to add \n"+
        "- to subtract \n"+
        "* to multiply \n"+
        "\\ to divide \n"+
        "^ to raise square \n"+
        "\"sqrt\" to take the square root \n"+
        "-h to repeat these options \n"+
        "-e to exit \n"+
        "-c to clear";
        System.out.println(helpMessage);
    }

    public void total() {
        System.out.println(sTotal);
    }

    public void add(double a, double b) {
        sTotal = Double.toString(a+b);//String.format(""+temp);
        sTotal = isWholeNum(sTotal);
        total();
    }

    public void add(double a) {
        double b = Double.parseDouble(sTotal);
        sTotal = Double.toString(a+b);
        sTotal = isWholeNum(sTotal);
        total();
    }

    private void add() {
        //StringBuilder .append() would work for the doubles and all I have to do is return .toString();
        //might be good for doing command line arguments and doing ops on multiple numbers
        //.valueOf()
        if (!sTotal.equals("0")) {
            System.out.println("Enter a number to add: ");
            double a = Double.parseDouble(s.nextLine());
            add(a);

        } else {
            System.out.println(ENTER_MESSAGE);
            double a = Double.parseDouble(s.nextLine());
            System.out.println("Enter a number to add: ");
            double b = Double.parseDouble(s.nextLine());
            add(a,b);
        }
    }

    public void subtract(double a, double b) {
        total = a - b;
    }

    public void subtract(double a) {
        total -= a;
    }

    public void subtract() {
        if (total != 0) {
            System.out.println("Enter a number to subtract: ");
            a = Integer.parseInt(s.nextLine());
            subtract(a);
            total();
        } else {
            System.out.println(ENTER_MESSAGE);
            a = Integer.parseInt(s.nextLine());
            System.out.println("Enter a number to subtract: ");
            b = Integer.parseInt(s.nextLine());
            subtract(a, b);
            total();
        }
    }

    public void multiply(double a, double b) {
        total = a * b;
    }

    public void multiply(double a) {
        total *= a;
    }

    public void multiply() {
        if (total != 0) {
            System.out.println("Enter a number to multiply: ");
            a = Integer.parseInt(s.nextLine());
            multiply(a);
            total();

        } else {
            System.out.println(ENTER_MESSAGE);
            a = Integer.parseInt(s.nextLine());
            System.out.println("Enter a number to multiply: ");
            b = Integer.parseInt(s.nextLine());
            multiply(a, b);
            total();
        }
    }

    public void divide(double a, double b) {
        total = a / b;
    }

    public void divide(double a) {
        total /= a;
    }

    public void divide() {
        if (total != 0) {
            System.out.println("Enter a number to divide: ");
            a = Integer.parseInt(s.nextLine());
            divide(a);
            total();

        } else {
            System.out.println(ENTER_MESSAGE);
            a = Integer.parseInt(s.nextLine());
            System.out.println("Enter a number to divide: ");
            b = Integer.parseInt(s.nextLine());
            divide(a, b);
            total();
        }
    }

    public void powOf2() {
        if (total != 0) {
            total *= total;
        } else {
            System.out.println(ENTER_MESSAGE);
            a = Integer.parseInt(s.nextLine());
            powOf2(a);
        }
        total();
    }

    public void powOf2(double a) {
        total = a * a;
    }

    public void sqrt(double a) {
        total = Math.sqrt(a);
    }

    public void sqrt() {
        if (total != 0) {
            Math.sqrt(total);
        } else {
            sqrt();
        }
    }

    public void clear() {
        total = 0;
    }

    public void turnOn() {
        System.out.println("Calculator powering on...");
    }

    public void turnOff() {
        System.out.println("Calculator powering off..."); // I probably won't need these, invest in looking at a logger
    }

    public String getTotal() {
        return sTotal;
    }

    public String isWholeNum(String sTotal){
        //use .indexOf(".0") and/or .contains(".0") or .endsWith(".0");
        //use .replace(".0","") once confirmed it's there.
        if(sTotal.substring(sTotal.length()-2,sTotal.length()).equals(".0")){
            sTotal = sTotal.substring(0, sTotal.length()-2);
        }
        return sTotal;
    }
}