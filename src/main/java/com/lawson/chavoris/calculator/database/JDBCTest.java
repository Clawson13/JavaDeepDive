package com.lawson.chavoris.calculator.database;

import java.sql.*;
import java.util.Properties;

public class JDBCTest{

    public static void connectDb() throws SQLException{
        String url = "jdbc:postgresql:postgres";
        Properties props = new Properties();
        props.setProperty("user","postgres");
        props.setProperty("password", "secret");
        //props.setProperty("ssl", "true");
        try{
            Connection conn = DriverManager.getConnection(url, props);
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * from playground");
            while(rs.next()){
                String type = rs.getString("type");
                String color = rs.getString("color");
                String location = rs.getString("location");
                String installDate = rs.getString("install_date");
                System.out.println("type= "+type+" color= "+color+
                " location= "+location+" install_date= "+installDate);
            }
            conn.close();
            st.close();
            rs.close();
            
        } catch(SQLException sql){
            System.err.println(sql.getMessage());
        } 
    }
}