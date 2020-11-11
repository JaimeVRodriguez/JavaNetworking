/*
 * Jaime Rodriguez
 * Assignment 2.2
 * November 6, 2020
 *
 * Purpose: Correct bug error in classmates
 * program to function properly
 *
 * To compile the program:
 * javac DebugTwo.java
 *
 * To execute the program:
 * java DebugTwo
 *
 */

import java.net.URL;
import java.sql.*;

public class DebugTwo {
    Connection con;
    Statement stmt;
    
    public DebugTwo(){
        try {
            DriverManager.registerDriver (new oracle.jdbc.OracleDriver());
            
            // Wrong utilization of "+". Should be ","
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE" + "student1" +"pass");
            
            // Missing "()" after createStatement
            stmt = con.createStatement;
        }
        catch(Exception e){
            System.out.println("Error connecting to database");
            System.exit(0);
        }
        
        try {
            System.out.println(stmt.executeUpdate("INSERT INTO address VALUES(4,'Doe','Jane','111 Java Lane','Seattle','WA','92020')") + "row updated");
            System.out.println(stmt.executeUpdate("INSERT INTO address VALUES(5,'Nublar','Isa','129 Python Rd.','Austin','TX','56363')") + "row updated");
            System.out.println(stmt.executeUpdate("INSERT INTO address VALUES(6,'Duke','Doug','912 Kotlin Drive','Raleigh','NC','85258')") + "row updated");
            
            // Missing closing semicolon
            stmt.executeUpdate("COM")
            
            System.out.println("Data inserted");
        }
        catch (SQLException e){
            System.out.println("Failed to update");
        }
    }
    
    public static void main(String[] args) {
        // Wrong class used.
        // DebugTwo should replace InsertData
        InsertData insertData = new InsertData();
    }
}