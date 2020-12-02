<%-- 
    Document   : FirstJSP
    Created on : Dec 2, 2020, 6:23:53 PM
    Author     : jaime
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            double num = Math.random();
            if (num > 0.95) {
                
        %>
        
        <!-- Removed h2 from inside Java code section -->
        <h2>You'll have a luck day!</h2><p>(<%= num %>)</p>
        
        <%
            } 
            else {
        %>
      
        <h2>Well, life goes on ... </h2>
        <p> "<%= num %> " </p>
        
        <%
            }
        %>
        <!-- Removed unneeded "/" before closing Java carat -->
        <!-- Added missing "<" for closing "a" tag --> 
        <a href="<%= request.getRequestURI() %>"><h3>Try Again<h3></a>
</body>
</html>
