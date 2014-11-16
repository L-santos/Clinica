/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author LucasPc
 */
public class Connect {

    private static String user = "root";
    private static String pass = "";
    
    public static void setPass(String _user, String _pass)
    { 
        user = _user;
        pass = _pass;
    }
    
    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.err.print(e);
             return null;
        }
    
        try {
            return DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/clinica?zeroDateTimeBehavior=convertToNull", user, pass);
        } catch (SQLException e) {
            System.err.print(e);
            return null;
        }
   }
    
}
