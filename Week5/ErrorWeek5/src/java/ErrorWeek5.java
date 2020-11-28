/*
 * Jaime Rodriguez
 * Assignment 5.2
 * November 26, 2020
 *
 * Purpose: Correct bug error in classmates
 * program to function properly
 *
 */

import java.io.*;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.net.URL;
import java.sql.*;
import oracle.jdbc.OracleResultSetMetaData;

@WebServlet("/ErrorWeek5")
public class ErrorWeek5 extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ErrorWeek5() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
    	
		PrintWriter out = response.getWriter();
		
		Connection con = null;
		
		Statement stmt = null;
		
		printHeader(out);
		
		try {
			java.sql.DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
			
			con = java.sql.DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "student1","pass");
			
			stmt = con.createStatement();
		}
		catch(Exception e) {
			out.println("<h1>Error connection to database.</h1>");
			printFooter(out);
			return;
		}
		
		try {
			stmt.close();
			con.close();
			//out.println("Database connections closed.");
		}
		catch(SQLException e) {
			out.println("<b>Connection close failed.");
		}
		
		printForm(out);
		printFooter(out);
		
		out.close();
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		
		Connection con = null;
		
		Statement stmt = null;
		
		printHeader(out);
		
		printForm(out);
		
		try {
			java.sql.DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
			
			con = java.sql.DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "student1","pass");
			
			stmt = con.createStatement();
		}
		catch(Exception e) {
			out.println("<h1>Error connection to database.</h1>");
			printFooter(out);
			return;
		}
		
		try {
                        // Missing a variable
                        // Added a ?
			PreparedStatement st = con.prepareStatement("INSERT INTO address VALUES(?, ?, ?, ?, ?, ?, ?)");
			
			st.setInt(1, Integer.valueOf(request.getParameter("ID")));
			st.setString(2, request.getParameter("LASTNAME"));
			st.setString(3, request.getParameter("FIRSTNAME"));
			st.setString(4, request.getParameter("STREET"));
			st.setString(5, request.getParameter("CITY"));
			st.setString(6, request.getParameter("STATE"));
			st.setString(7, request.getParameter("ZIP"));
			
			st.executeUpdate();
			
			st.close();
		}
		catch(SQLException e) {
			out.println(e);
			out.println("Insert data failed.");
		}
		
		try {
			stmt.close();
			con.close();
		}
		catch(SQLException e) {
			out.println("<b>Connection close failed.</b><br/>");
		}
		
		printFooter(out);
		
	}
	
	public void printHeader(PrintWriter out) {
		out.println("<html>");
		out.println("<head>");
		out.println("<title>");
		out.println("Form Post and Get");
		out.println("</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<div>");
	}
	
	public void printFooter(PrintWriter out) {
		out.println("</div>");
		out.println("</body>");
		out.println("<html>");
	}
	
	public void printForm(PrintWriter out) {
		out.println("<form method='post' action='ErrorWeek5'");
		out.println("<label>ID</label>");
		out.println("<input type='text' name='ID' size='40' maxlength='40'/>");
		out.println("<br/>");
		out.println("<label>Enter Last Name</label>");
		out.println("<input type='text' name='LASTNAME' size='40' maxlength='40'/>");
		out.println("<br/>");
		out.println("<label>Enter First Name</label>");
		out.println("<input type='text' name='FIRSTNAME' size='40' maxlength='40'/>");
		out.println("<br/>");
		out.println("<label>Enter Street</label>");
		out.println("<input type='text' name='STREET' size='40' maxlength='40'/>");
		out.println("<br/>");
		out.println("<label>Enter City</label>");
		out.println("<input type='text' name='CITY' size='40' maxlength='40'/>");
		out.println("<br/>");
		out.println("<label>Enter State</label>");
		out.println("<input type='text' name='STATE' size='40' maxlength='40'/>");
		out.println("<br/>");
		out.println("<label>Enter ZIP</label>");
		out.println("<input type='text' name='ZIP' size='40' maxlength='40'/>");
		out.println("<br/>");
		out.println("<input type='submit' />");
	}
}