/*
 * Jaime Rodriguez
 * Assignment 2.2
 * November 6, 2020
 *
 * Purpose: Correct bug error in classmates
 * program to function properly
 *
 * To compile the program:
 * javac Error2.java
 *
 * To execute the program:
 * java Error2
 *
 */

import java.net.URL;
import java.sql.*;

public class Error2 {
    Connection con;
    // stmt variable was not utilized. So changed to stnt.
    Statement stnt;
    
    public Error2(){
        try {
            DriverManager.registerDriver (new oracle.jdbc.OracleDriver());
            
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "student1","pass");
            
            stnt = con.createStatement();
        }
        catch(Exception e){
            System.out.println("Error connecting to database");
            System.exit(0);
        }
        
        // Removed unneeded ";" after VALUES statement
        try {
            System.out.println(
            stnt.executeUpdate("INSERT INTO address VALUES(4,'Leath','Erik','Disneyland','Bellevue','CA','92020')") + "row updated");
            System.out.println(
            stnt.executeUpdate("INSERT INTO address VALUES(5,'Folks','David','123 Programming Rd.','Bellevue','NE','56363')") + "row updated");
            System.out.println(
            stnt.executeUpdate("INSERT INTO address VALUES(6,'Rodriguez','Jaime','564 Database Connection','Redmond','Washington','85258')") + "row updated");
            
            stnt.executeUpdate("COM");
            
            System.out.println("Data inserted");
        }
        catch (SQLException e){
            System.out.println("Failed to update");
        }
    }
    
    // Missing main statement
    public static void main(String[] args) {
        Error2 insertData = new Error2();
    }
}