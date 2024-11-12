package com.user.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestConnection {
    public static void main(String[] args) {
        String jdbcURL = "jdbc:mysql://localhost:3306/userappdb";
        String jdbcUserName = "root";
        String jdbcPassword = "mggandhi";

        // Try to connect to the database
        try {
           
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(jdbcURL, jdbcUserName, jdbcPassword);
            
            if (connection != null) {
                System.out.println("Connection successful!");
            } else {
                System.out.println("Failed to make connection!");
            }
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("ClassNotFoundException: MySQL driver not found.");
            e.printStackTrace();
        }
    }
}
