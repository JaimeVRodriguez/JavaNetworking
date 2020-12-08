/*
 *
 * Jaime Rodriguez
 * Assignment 7.1
 * December 7, 2020
 *
 * Purpose: Create a web application
 * that writes data from a form to a
 * database and retrieves the info
 * from that database using a Java Bean.
 *
 */

package beans;

import static java.lang.System.out;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 *
 * @author jaime
 */
public class FirstBean {
    
    private Connection con = null;
    private Statement stmt = null;
    private ResultSet rset = null;
    private PreparedStatement ps = null;
    private String fName;
    private String lName;
    private String userAge;
    
    public String getfName() {
        return fName;
    }
    public void setfName(String fName) {
        this.fName = fName;
    }
    
    public String getlName() {
        return fName;
    }
    public void setlName(String lName) {
        this.lName = lName;
    }
    
    public String getuserAge() {
        return userAge;
    }
    public void setuserAge(String userAge) {
        this.userAge = userAge;
    }
    
    
    public void create() {
        try{
            DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "student1", "pass");
            
            stmt = con.createStatement();
            
            stmt.executeUpdate("CREATE TABLE USERTABLE(FNAME VARCHAR(20), LNAME VARCHAR(25), USERAGE VARCHAR(5))");
            
            con.close();

        }
        catch(Exception e) {
            
        }          
    }
    
    public void insert(){
        
        try{
            DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "student1", "pass");
            
            if(fName != null && lName != null && userAge != null) {
                stmt = con.createStatement();
                stmt.executeUpdate("INSERT INTO USERTABLE(FNAME, LNAME, USERAGE) VALUES('" + fName + "', '" + lName + "', '" + userAge + "')");
                stmt.close();
            }
        }
        catch(Exception e) {
            
        }
    }
       
}
