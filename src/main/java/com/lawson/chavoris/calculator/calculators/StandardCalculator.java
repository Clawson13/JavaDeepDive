package com.lawson.chavoris.calculator.calculators;

import java.util.Scanner;

import com.lawson.chavoris.calculator.interfaces.BaseMathCalculator;

public class StandardCalculator implements BaseMathCalculator {

    private int total;

    // make this more modular like adding being able to read multiple arguments like
    // the command line and reading symbols.
    public void play() {
        Scanner s = new Scanner(System.in);
        help();
        String input = "";

        while (!input.equalsIgnoreCase("exit")) {
            input = s.nextLine();

            if (input.equals("+")) {
                if(total!=0){
                    
                        System.out.println("Enter a number to add: ");
                        int a = Integer.parseInt(s.nextLine());
                        add(a);
                        total();
                     
                }else{
                System.out.println("Enter a number: ");
                int a = Integer.parseInt(s.nextLine());
                System.out.println("Enter the next number to add: ");
                int b = Integer.parseInt(s.nextLine());
                add(a, b);
                System.out.println(this.total);
            }
            } else if (input.equals("-")) {
                if(total!=0){
                    
                    System.out.println("Enter a number to subtract: ");
                    int a = Integer.parseInt(s.nextLine());
                    subtract(a);
                    total();
                 
            }else{
                System.out.println("Enter a number: ");
                int a = Integer.parseInt(s.nextLine());
                System.out.println("Enter the next number to subtract: ");
                int b = Integer.parseInt(s.nextLine());
                subtract(a, b);
                System.out.println(this.total);
        }
            } else if (input.equals("*")) {
                if(total!=0){
                    
                    System.out.println("Enter a number to multiply: ");
                    int a = Integer.parseInt(s.nextLine());
                    multiply(a);
                    total();
                 
            }else{
                System.out.println("Enter a number: ");
                int a = Integer.parseInt(s.nextLine());
                System.out.println("Enter the next number to multiply: ");
                int b = Integer.parseInt(s.nextLine());
                multiply(a, b);
                System.out.println(this.total);
            }
            } else if (input.equals("/")) {
                if(total!=0){
                    
                    System.out.println("Enter a number to divide: ");
                    int a = Integer.parseInt(s.nextLine());
                    divide(a);
                    total();
                 
            }else{
                System.out.println("Enter a number: ");
                int a = Integer.parseInt(s.nextLine());
                System.out.println("Enter the next number to divide: ");
                int b = Integer.parseInt(s.nextLine());
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

    }

    public void turnOff() {

    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}