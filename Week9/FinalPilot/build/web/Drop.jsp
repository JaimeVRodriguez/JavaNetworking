<%-- 
 *
 * Carina Cardona, Erik Leath, Jaime Rodriguez
 * Pilot Program
 * Assignment 9.3 - Milesstone 4 
 * December 2020
 *
 * Purpose: Create a pilot program
 * for All Aboard Toys. Utilizing 
 * servlets, JSP, and Java Beans program
 * create, inserts, and display data to/from
 * associated tables. Program also allows
 * for data to be written to an aspect
 * of the the database through a form.
 *
--%>

<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Drop Tables</title>
    </head>
    <body>
        <jsp:useBean id="deleteTables" class="pilot.Drop">
        </jsp:useBean>
        <h1>Drop Tables</h1>
        
        <%
            Connection con = null;
            PreparedStatement ps = null;
            
            if(request.getMethod().equals("GET")) {               
        %>
        
        <form action='Drop.jsp' method='post'>
            Drop
            <input type='submit' value='Drop'/>
        </form>
        
        <%
            }
            if(request.getMethod().equals("POST")) {
                deleteTables.delete();
        %>
        <a href="index.jsp">Homepage</a>
        
        <%
            }
        %>
    </body>
</html>
