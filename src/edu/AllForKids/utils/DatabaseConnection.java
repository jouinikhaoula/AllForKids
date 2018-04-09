/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.AllForKids.utils;

import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.SQLException;


/**
 *
 * @author khaoula
 */
public class DatabaseConnection {
    private static DatabaseConnection instance;
    //allforkidsdb
  String url="jdbc:mysql://localhost:3306/allforkidsdb";
            String login="root";
            String pwd="";
            Connection conn;
    private DatabaseConnection() {
      
            
        try {
            
             conn= DriverManager.getConnection(url, login, pwd);
            System.out.println("Connexion etablie");
        } catch (SQLException ex) {
           System.err.println(ex.getMessage());
        }
    
    }
    
    public Connection getConnection()
    {
        return conn;
    }
       
    public static DatabaseConnection getInstance()
     {
         if(instance==null)
         {
             instance=new DatabaseConnection();
         }
         return instance;
     }
   
}
