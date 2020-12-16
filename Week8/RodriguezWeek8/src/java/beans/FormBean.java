/*
 *
 * Jaime Rodriguez
 * Assignment 8.1
 * December 16, 2020
 *
 * Purpose: Create a web application
 * that writes data from a form to a
 * database and retrieves the info
 * from that database using a Java Bean
 * and a custom tag.
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

public class FormBean {
    
    private Connection con = null;
    private Statement stmt = null;
    private ResultSet rset = null;
    private PreparedStatement ps = null;
    private String fName;
    private String eMail;
    private String userAge;
    private String userState;
    
    public String getfName() {
        return fName;
    }
    public void setfName(String fName) {
        this.fName = fName;
    }
    
    public String geteMail() {
        return eMail;
    }
    public void seteMail(String eMail) {
        this.eMail = eMail;
    }
    
    public String getuserAge() {
        return userAge;
    }
    public void setuserAge(String userAge) {
        this.userAge = userAge;
    }
    
    public String getuserState() {
        return userState;
    }
    public void setuserState(String userState) {
        this.userState = userState;
    }
       
    public void create() {
        try{
            DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "student1", "pass");
            
            stmt = con.createStatement();
            
            stmt.executeUpdate("CREATE TABLE REGISTRATION (FNAME VARCHAR(20), EMAIL VARCHAR(25), USERAGE VARCHAR(5), USERSTATE VARCHAR(20))");
            
            con.close();

        }
        catch(Exception e) {
            
        }          
    }
    
    public void insert(){
        
        try{
            DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "student1", "pass");
            
            if(fName != null && eMail != null && userAge != null && userState != null) {
                stmt = con.createStatement();
                stmt.executeUpdate("INSERT INTO REGISTRATION(FNAME, EMAIL, USERAGE, USERSTATE) VALUES('" + fName + "', '" + eMail + "', '" + userAge + "', '" + userState + "')");
                stmt.close();
            }
        }
        catch(Exception e) {
            
        }
    }      
}
