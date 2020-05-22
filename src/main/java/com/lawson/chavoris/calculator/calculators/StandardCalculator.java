package com.lawson.chavoris.calculator.calculators;

import java.util.Scanner;

import com.lawson.chavoris.calculator.interfaces.BaseMathCalculator;

public class StandardCalculator implements BaseMathCalculator {

    private int total;
    protected static final String ENTER_MESSAGE = "Enter a number: ";
    private Scanner s = new Scanner(System.in);
    // make this more modular like adding being able to read multiple arguments like
    // the command line and reading symbols.
    public void play() {
        
        help();
        String op = "";
        int a=0;
        int b=0;

        while (!op.equalsIgnoreCase("exit")) {
            op = s.nextLine();
            selectOperation(op);
        }
    }
    private void selectOperation(String op){
        if (op.equals("+")) {
            add();
        }
        } else if (input.equals("-")) {
            if(total!=0){
                
                System.out.println("Enter a number to subtract: ");
                a = Integer.parseInt(s.nextLine());
                subtract(a);
                total();
             
        }else{
            System.out.println(ENTER_MESSAGE);
            a = Integer.parseInt(s.nextLine());
            System.out.println("Enter a number to subtract: ");
            b = Integer.parseInt(s.nextLine());
            subtract(a, b);
            System.out.println(this.total);
    }
        } else if (input.equals("*")) {
            if(total!=0){
                
                System.out.println("Enter a number to multiply: ");
                a = Integer.parseInt(s.nextLine());
                multiply(a);
                total();
             
        }else{
            System.out.println(ENTER_MESSAGE);
            a = Integer.parseInt(s.nextLine());
            System.out.println("Enter a number to multiply: ");
            b = Integer.parseInt(s.nextLine());
            multiply(a, b);
            System.out.println(this.total);
        }
        } else if (input.equals("/")) {
            if(total!=0){
                
                System.out.println("Enter a number to divide: ");
                a = Integer.parseInt(s.nextLine());
                divide(a);
                total();
             
        }else{
            System.out.println(ENTER_MESSAGE);
            a = Integer.parseInt(s.nextLine());
            System.out.println("Enter a number to divide: ");
            b = Integer.parseInt(s.nextLine());
            divide(a, b);
            System.out.println(this.total);
        }
        }else if (input.equalsIgnoreCase("-h")) {

            help();
        } else if (input.equalsIgnoreCase("-e")) {
            input = "exit";
            s.close();
            System.exit(0);
        } else if(input.equalsIgnoreCase("-c")){
            clear();
        } else {
            System.out.println("That's not a valid command.");
        }
    }

    public void help() {
        System.out.println(
                "Enter: + to add.\n\t - to subtract \n\t * to multiply \n\t \\ to divide \n\t -h to repeat these options \n\t -e to exit \n\t -c to clear");
    }

    public void total() {
        System.out.println(total);
    }

    public void add(int a, int b) {
        this.total = a + b;
    }

    public void add(int a) {
        total += a;
    }
    private void add(){
        int a=0;
        int b=0;
        if(total!=0){
                
            System.out.println("Enter a number to add: ");
            a = Integer.parseInt(s.nextLine());
            add(a);
            total();
         
    }else{
    System.out.println(ENTER_MESSAGE);
    a = Integer.parseInt(s.nextLine());
    System.out.println("Enter a number to add: ");
    b = Integer.parseInt(s.nextLine());
    add(a, b);
    total();
    }
}

    public void subtract(int a, int b) {
        total = a - b;
    }

    public void subtract(int a) {
        total -= a;
    }

    public void multiply(int a, int b) {
        total = a * b;
    }

    public void multiply(int a) {
        total *= a;
    }

    public void divide(int a, int b) {
        total = a / b;
    }

    public void divide(int a) {
        total /= a;
    }

    public void powOf2() {
        total ^= 2;
    }

    public void powOf2(int a) {
        total = a^2;
    }

    public void clear() {
        total = 0;
    }

    public void turnOn() {
        System.out.println("Calculator powering on...");
    }

    public void turnOff() {
        System.out.println("Calculator powering off..."); //I probably won't need these, invest in looking at a logger
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}