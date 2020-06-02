package com.lawson.chavoris.calculator.app;

import java.sql.SQLException;

import com.lawson.chavoris.calculator.calculators.StandardCalculator;
import com.lawson.chavoris.calculator.database.JDBCTest;

/**
 * Runs Calculator application
 * 
 * @author Chavoris Lawson
 */
public class App {
    public static void main(String[] args) {
        //StandardCalculator calc = new StandardCalculator();
        //calc.play();
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
        //JDBCTest test = new JDBCTest();
        try{
          JDBCTest.connectDb();
        } catch(SQLException sql){
          System.err.println(sql.getMessage());
        }
        
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