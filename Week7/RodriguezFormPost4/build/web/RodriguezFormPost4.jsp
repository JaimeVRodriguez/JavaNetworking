<%-- 
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
        <jsp:useBean id="formPost" class="beans.FirstBean">
            <jsp:setProperty name="formPost" property="fName" param="FNAME" />
            <jsp:setProperty name="formPost" property="lName" param="LNAME" />
            <jsp:setProperty name="formPost" property="userAge" param="USERAGE" />
        </jsp:useBean>
        <h1>Registration Form</h1>
        
        <%
            Connection con = null;
            PreparedStatement ps = null;
            ResultSet rset = null;
            
            formPost.create();
            
            if(request.getMethod().equals("GET")) {
                
        %>
        
        <form action='RodriguezFormPost4.jsp' method='post'>
            First Name:
            <input type='text' name='FNAME' required/>
            <br>
            Last Name
            <input type='text' name='LNAME' required/>
            <br>
            Age:
            <input type='text' name='USERAGE' required/>
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
                
                ps = con.prepareStatement("SELECT * FROM USERTABLE");
                rset = ps.executeQuery();
                
        %>
        <h3> Results </h3>
        <table>
        <%
                int count = 1;
                while(rset.next()) {
        %>
        <tr>
            <td><%=rset.getString("fName")%></td>
            <td><%=rset.getString("lName")%></td>
            <td><%=rset.getString("userAge")%></td>
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
    </body>
</html>
