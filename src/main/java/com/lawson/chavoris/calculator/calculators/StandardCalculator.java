package com.lawson.chavoris.calculator.calculators;

import java.util.Scanner;

import com.lawson.chavoris.calculator.interfaces.BaseMathCalculator;

public class StandardCalculator implements BaseMathCalculator {

    double total;
    String sTotal="0";
    protected static final String ENTER_MESSAGE = "Enter a number: ";
    Scanner s = new Scanner(System.in);
    int a = 0;
    int b = 0;

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
        String helpMessage = "Enter: + to add.\n\t - to subtract \n\t * to multiply \n\t \\ to divide \n\t ^ to raise square 'sqrt' to take the square root -h to repeat these options \n\t -e to exit \n\t -c to clear";
        System.out.println(helpMessage);
    }

    public void total() {
        System.out.println(total);
    }

    public void add(int a, int b) {
        total = a + b;
        //1 + 1 = 2
        //1.2 + 1.3 = 2.5
        //1.2 + 1.32 = 2.52
    }

    public void add(int a) {
        total += a;
    }

    private void add() {
        if (!sTotal.equals("0")) {
            System.out.println("Enter a number to add: ");
            //if(s.nextLine().length()>1){
                double x = Double.parseDouble(s.nextLine());
                double y = Double.parseDouble(sTotal);
                sTotal = Double.toString(x+y);//String.format("%-10.9f",x+y);
                sTotal = isWholeNum(sTotal);
                System.out.println(sTotal);
            //}
            //a = Integer.parseInt(s.nextLine());
            //add(a);
            //total();

        } else {
            System.out.println(ENTER_MESSAGE);
            double x = Double.parseDouble(s.nextLine());
            System.out.println(x);
            System.out.println("Enter a number to add: ");
            double y = Double.parseDouble(s.nextLine());
            System.out.println(y);
            double temp = x+y;
            sTotal = Double.toString(temp);//String.format(""+temp);
            sTotal = isWholeNum(sTotal);
            System.out.println(sTotal);
            //add(a, b);
            //total();
        
        }
    }

    public void subtract(int a, int b) {
        total = a - b;
    }

    public void subtract(int a) {
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

    public void multiply(int a, int b) {
        total = a * b;
    }

    public void multiply(int a) {
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

    public void divide(int a, int b) {
        total = a / b;
    }

    public void divide(int a) {
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

    public void powOf2(int a) {
        total = a * a;
    }

    public void sqrt(int a) {
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

    public double getTotal() {
        return total;
    }

    public String isWholeNum(String sTotal){
        if(sTotal.substring(sTotal.length()-2,sTotal.length()).equals(".0")){
            sTotal = sTotal.substring(0, sTotal.length()-2);
        }
        return sTotal;
    }
}