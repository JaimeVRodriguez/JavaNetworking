<%-- 
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
--%>

<%@page import="java.sql.DriverManager"%>
<%@page import="java.util.Vector"%>
<%@page import="java.util.List"%>
<%@page import="java.util.List"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registration</title>
    </head>
    <body>
        <jsp:useBean id="formPost" class="beans.FormBean">
            <jsp:setProperty name="formPost" property="fName" param="FNAME" />
            <jsp:setProperty name="formPost" property="eMail" param="EMAIL" />
            <jsp:setProperty name="formPost" property="userAge" param="USERAGE" />
            <jsp:setProperty name="formPost" property="userState" param="USERSTATE" />
        </jsp:useBean>
        <h1>Registration Form</h1>
        
        <%
            Connection con = null;
            PreparedStatement ps = null;
            ResultSet rset = null;
            
            formPost.create();
            
            if(request.getMethod().equals("GET")) {
                
        %>
        
        <form action='Form.jsp' method='post'>
            Full Name:
            <input type='text' name='FNAME' required/>
            <br>
            Email:
            <input type='email' name='EMAIL' required/>
            <br>
            Age:
            <input type='text' name='USERAGE' required/>
            <br>
            Birth State:
            <input type='text' name='USERSTATE' required/>
            <br>
            <input type='reset' value='Reset' />
            <input type='submit' value='Submit' />
        </form>
        
        <% 
            }
            if(request.getMethod().equals("POST")) {
                formPost.insert();

                DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
                con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "student1", "pass");
                
                ps = con.prepareStatement("SELECT * FROM REGISTRATION");
                rset = ps.executeQuery();
                
        %>
        <h3> Results </h3>
        <table style=width"100%">
            <tr>
                <th>Full Name</th>
                <th>Email</th>
                <th>Age</th>
                <th>Birth State</th>
            </tr>
        <%
                int count = 1;
                while(rset.next()) {
        %>
        <tr>
            <td><%=rset.getString("fName")%></td>
            <td><%=rset.getString("eMail")%></td>
            <td><%=rset.getString("userAge")%></td>
            <td><%=rset.getString("userState")%></td>
        </tr>
        <br>
        <%
                count++;
                }
        %>

        </table>
        <%               
            }       
        %>
        
        <%@ taglib prefix="date" uri="/WEB-INF/tlds/Date" %>
        <p>The current date is <date:currentDate />.</p>
               
    </body>
</html>
