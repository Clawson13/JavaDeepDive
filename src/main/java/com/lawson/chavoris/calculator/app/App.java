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
        // if(args.length>2){
        //     double sum=0;
        //     for(int i=0;i<args.length;i++){
        //         if(!isNumeric(args[0])){
        //             System.out.println("Can't add strings");
        //         }else{
        //             sum+=Double.parseDouble(args[0]);
        //         }
        //     }
        // }
    }
    public static boolean isNumeric(String str) { 
        try {  
          Double.parseDouble(str);  
          return true;
        } catch(NumberFormatException e){  
          return false;  
        }  
      }
}