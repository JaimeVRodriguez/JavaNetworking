<%-- 
    
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Do Math</h1>
        
        <%
            if(request.getMethod().equals("GET")) {       
        %>
        
        <form action="Math.jsp" method='post'>
            Number 1:
            <input type='text' name='NUMBER_ONE' required/>
            <br>
            
            Number 2:
            <input type='text' name='NUMBER_TWO' required/>
            <br>
            
   
            <input type='radio' name='MATH' value='MULTIPLY' />Multiply
            <input type='radio' name='MATH' value='ADD' />Add
            <br>
            
            <input type='reset' value="Reset" />
            <input type='submit' value='Submit'/>
        </form>
        
        <%
            }
            if(request.getMethod().equals("POST")) {

                int total == 0;
                
                int numberOne = Integer.parseInt(request.getParameter("NUMBER_ONE"));
                int numberTwo = Integer.parseInt(request.getParameter("NUMBER_TWO"));

                String math = request.getParameter("MATH");

                if("multiply".equals(math)) {
                    total = numberOne * numberTwo;
                    
                    out.println("Product of " + numberOne + " and " + numberTwo + " is " + total);
                }
                else if("add".equals(math)) {
                    total = numberOne + numberTwo;
                    
                    out.println("Sum of " + numberOne + " and " + numberTwo + " is " + total);
                }                    
            }          
        %>
            
    </body>
</html>
