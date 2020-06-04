package com.lawson.chavoris.calculator.database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

public class JDBCTest{

    private static Scanner s = new Scanner(System.in);

    public static String getQuery(){
        System.out.println("Enter a query: ");
        String query = s.nextLine();
        return query;
    }
    public static List<String> processQuery(String query){
        String[] stmts = query.split(" ");
        ArrayList<String> cols = new ArrayList<>();
        if("SELECT".equalsIgnoreCase(stmts[0])){
            for(String s: stmts){
                if("FROM".equalsIgnoreCase(s)){
                    break;
                }
                cols.add(s);
            }
        }
        return cols;
    }
    public static void connectDb() throws SQLException{
        String url = "jdbc:postgresql:postgres";
        Properties props = new Properties();
        props.setProperty("user","postgres");
        props.setProperty("password", "secret");
        //props.setProperty("ssl", "true");
        try{
            Connection conn = DriverManager.getConnection(url, props);
            Statement st = conn.createStatement();
            String query = getQuery();
            List<String> cols = processQuery(query);
            
            ResultSet rs = st.executeQuery(query);
            String type = "";
            String color = "";
            String location = "";
            String installDate ="";
            StringBuilder resString = new StringBuilder();
            while(rs.next()){
                if(cols.contains("type")||cols.contains("*")){
                    type = rs.getString("type")+" ";
                    resString.append("type= "+type);
                }
                if(cols.contains("color")||cols.contains("*")){
                    color = rs.getString("color")+" ";
                    resString.append("color= "+color);
                }
                if(cols.contains("location")||cols.contains("*")){
                    location = rs.getString("location")+" ";
                    resString.append("location= "+location);
                }
                if(cols.contains("install_date")||cols.contains("*")){
                    installDate= rs.getString("install_date")+" ";
                    resString.append("install_date= "+installDate);    
                }
                System.out.println(resString.toString());
            }
            conn.close();
            st.close();
            rs.close();
            
        } catch(SQLException sql){
            System.err.println(sql.getMessage());
        } 
    }
}