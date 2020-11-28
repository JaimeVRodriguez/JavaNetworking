/*
 * Jaime Rodriguez
 * Assignment 5.1
 * November 27, 2020
 *
 * Purpose: Create a web application
 * that writes data from a form to a
 * database and retrieves the info
 * from that database.
 *
 */

package week5;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import javax.servlet.annotation.WebServlet;
import oracle.jdbc.OracleResultSetMetaData;

@WebServlet(name = "RodriguezFormPost2", urlPatterns = {"/RodriguezFormPost2"})
public class RodriguezFormPost2 extends HttpServlet {

    Connection con = null; 
    Statement stmt = null;
    ResultSet rset = null;
    PreparedStatement ps = null;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet RodriguezFormPost2</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet RodriguezFormPost2 at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html");
        
        PrintWriter out = response.getWriter();
        
        try {
            printHeader(out);
            
            DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
            
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "student1", "pass");
            
            stmt = con.createStatement();
            
            stmt.executeUpdate("DROP TABLE INFOTABLE");
            stmt.executeUpdate("CREATE TABLE INFOTABLE(FIRSTNAME VARCHAR(20) NOT NULL, LASTNAME VARCHAR(20) NOT NULL, PHONENUMBER VARCHAR(20) NOT NULL)");
            
            out.println("<div><h2> Personal Data Form </h2></div>");
            
            printForm(out);
            printFooter(out);
        }
        catch(Exception e) {
            
        }
        out.close();    
    }
   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        PrintWriter out = response.getWriter();
        
        String firstName = request.getParameter("FIRSTNAME");
        String lastName = request.getParameter("LASTNAME");
        String phoneNumber = request.getParameter("PHONENUMBER");
        
        response.setContentType("text/html");
             
        try {
            
            DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
            
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "student1", "pass");
            
            ps = con.prepareStatement("INSERT INTO INFOTABLE VALUES(?,?,?)");
            
            ps.setString(1, firstName);
            ps.setString(2, lastName);
            ps.setString(3, phoneNumber);
            
            int i = ps.executeUpdate();
            
            if(i>0) {
                PreparedStatement ps1 = con.prepareStatement("SELECT * FROM INFOTABLE");
                rset = ps1.executeQuery();
                
                while(rset.next()) {
                    out.println("<pre>");
                    out.println("First Name: " + rset.getString(1));
                    out.println("</pre>");
                    out.println();
                    
                    out.println("<pre>");
                    out.println("Last Name: " + rset.getString(2));
                    out.println("</pre>");
                    out.println();
                    
                    out.println("<pre>");
                    out.println("Phone Number: " + rset.getString(3));
                    out.println("</pre>");
                    out.println();
                }
            }       
        }
        catch (Exception e) {
            response.setContentType("text/html");
            
            printHeader(out);
            out.println(e.getMessage());
            printFooter(out);
            out.close();     
        }
    }
    
    public void printHeader(PrintWriter out) {
        out.println("<!DOCTYPE html>");
        out.println("<html lang='en'>");
        out.println("<html>");
        out.println("<head>");
        out.println("<link rel='stylesheet' type='text/css' href='style.css' >");
        out.println("<title>");
        out.println("Personal Data Form");
        out.println("</title>");
        out.println("<meta charset='utf-8'>");
        out.println("</head>");
        out.println("<body>");
        out.println("<div>");
    }

    public void printFooter(PrintWriter out) {
        out.println("</div>");
        out.println("</body>");
        out.println("</html>");
    }
    
    public void printForm(PrintWriter out) {
        out.println("<form action='RodriguezFormPost2' method='post'>");
        // User email has to be filled
        out.println("First Name:");
        out.println("<input type='text' name='FIRSTNAME' required/>");
        out.println("<br>");
        // User username has to be filled
        out.println("Last Name:");
        out.println("<input type='text' name='LASTNAME' required/>");
        out.println("<br>");
        // User password has to be filled
        out.println("Phone Number:");
        out.println("<input type='text' name='PHONENUMBER' required/>");
        out.println("<br>");
        // Reset and submit button options
        out.println("<input type='reset' value='Reset' />");
        out.println("<input type='submit' value='Submit' />");
        out.println("</form>");
    }
      
    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
