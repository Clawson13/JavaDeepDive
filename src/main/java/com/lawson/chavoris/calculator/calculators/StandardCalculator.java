package com.lawson.chavoris.calculator.calculators;

import java.util.Scanner;

import com.lawson.chavoris.calculator.abstractions.BaseMathCalculator;

public class StandardCalculator extends BaseMathCalculator {

    private String total="0";
    protected static final String ENTER_MESSAGE = "Enter a number: ";
    private Scanner s = new Scanner(System.in);
    private double a = 0;
    private double b = 0;

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
        System.out.println(total);
    }

    public void add(double a, double b) {
        total = Double.toString(a+b);//String.format(""+temp);
        total = isWholeNum(total);
    }

    public void add(double b) {
        a = Double.parseDouble(total);
        total = Double.toString(a+b);
        total = isWholeNum(total);
    }

    private void add() {
        //StringBuilder .append() would work for the doubles and all I have to do is return .toString();
        //might be good for doing command line arguments and doing ops on multiple numbers
        //.valueOf()
        if (!total.equals("0")) {
            System.out.println("Enter a number to add: ");
            b = Double.parseDouble(s.nextLine());
            add(b);

        } else {
            System.out.println(ENTER_MESSAGE);
            a = Double.parseDouble(s.nextLine());
            System.out.println("Enter a number to add: ");
            b = Double.parseDouble(s.nextLine());
            add(a,b);
        }
        total();
    }

    public void subtract(double a, double b) {
        total = Double.toString(a-b);
        total = isWholeNum(total);
    }

    public void subtract(double b) {
        a = Double.parseDouble(total);
        total = Double.toString(a-b);
        total = isWholeNum(total);
    }

    public void subtract() {
        if (!total.equals("0")) {
            System.out.println("Enter a number to subtract: ");
            b = Double.parseDouble(s.nextLine());
            subtract(b);
        } else {
            System.out.println(ENTER_MESSAGE);
            a = Double.parseDouble(s.nextLine());
            System.out.println("Enter a number to subtract: ");
            b = Double.parseDouble(s.nextLine());
            subtract(a, b);
        }
        total();
    }

    public void multiply(double a, double b) {
        total = Double.toString(a*b);
        total = isWholeNum(total);
    }

    public void multiply(double b) {
        a = Double.parseDouble(total);
        total = Double.toString(a*b);
        total = isWholeNum(total);
    }

    public void multiply() {
        if (!total.equals("0")) {
            System.out.println("Enter a number to multiply: ");
            b = Double.parseDouble(s.nextLine());
            multiply(b);

        } else {
            System.out.println(ENTER_MESSAGE);
            a = Double.parseDouble(s.nextLine());
            System.out.println("Enter a number to multiply: ");
            b = Double.parseDouble(s.nextLine());
            multiply(a, b);
        }
        total();
    }

    public void divide(double a, double b) {
        total = Double.toString(a/b);
        total = isWholeNum(total);
    }

    public void divide(double b) {
        a = Double.parseDouble(total);
        total = Double.toString(a/b);
        total = isWholeNum(total);
    }

    public void divide() {//Fix division by zero
        if (!total.equals("0")) {
            System.out.println("Enter a number to divide: ");
            b = Double.parseDouble(s.nextLine());
            divide(b);

        } else {
            System.out.println(ENTER_MESSAGE);
            a = Double.parseDouble(s.nextLine());
            System.out.println("Enter a number to divide: ");
            b = Double.parseDouble(s.nextLine());
            divide(a, b);
        }
        total();
    }

    public void powOf2() {
        if (!total.equals("0")) {
            a = Double.parseDouble(total);
            total = Double.toString(a*a);
            total = isWholeNum(total);
        } else {
            System.out.println(ENTER_MESSAGE);
            b = Double.parseDouble(s.nextLine());
            powOf2(b);
        }
        total();
    }

    public void powOf2(double b) {
        total = Double.toString(b*b);
        total = isWholeNum(total);
    }

    public void sqrt(double b) {
        total = Double.toString(Math.sqrt(b));
        total = isWholeNum(total);
    }

    public void sqrt() {
        if (!total.equals("0")) {
            a = Double.parseDouble(total);
            Math.sqrt(a);
        } else {
            System.out.println(ENTER_MESSAGE);
            b = Double.parseDouble(s.nextLine());
            sqrt(b);
        }
        total();
    }

    public void clear() {
        total = "0";
    }

    public void turnOn() {
        System.out.println("Calculator powering on...");
    }

    public void turnOff() {
        System.out.println("Calculator powering off..."); // I probably won't need these, invest in looking at a logger
    }

    public String getTotal() {
        return total;
    }

    public String isWholeNum(String total){
        //use .indexOf(".0") and/or .contains(".0") or .endsWith(".0");
        //use .replace(".0","") once confirmed it's there.
        if(total.substring(total.length()-2,total.length()).equals(".0")){
            total = total.substring(0, total.length()-2);
        }
        return total;
    }
}