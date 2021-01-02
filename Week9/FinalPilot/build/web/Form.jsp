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

<%@page import="java.sql.*"%>
<%@page import="oracle.jdbc.OracleResultSetMetaData"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Customer Registration</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="${pageContext.request.contextPath}/css/bootstrap.css" rel="stylesheet" media="screen">
        <link href="${pageContext.request.contextPath}/css/bootstrap-responsive.css" rel="stylesheet" media="screen">
        <style>
        	.footer{
        		text-align: center;
        		padding: 30px 0;
        		margin-top: 70px;
        		border-top: 1px solid #e5e5e5;
        		background-color: #f5f5f5;
        	}
        	
        	.footer .footer-links{
        		list-style-type: none;
        		font-size: 10px;
        	}
        </style>
    </head>
    <body>
    
		<div class="navbar navbar-inverse navbar-static-top">
			<div class="navbar-inner">
				<div class="container">
					<button type="button" class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
					</button>
					<a class="brand" href="index.jsp">All Aboard Toys</a>
					<div class="nav-collapse collapse">
						<ul class="nav">
							<li><a href="index.jsp">Home</a></li>
							<li><a href="about.jsp">About</a></li>
							<li><a href="#contact">Contact</a></li>
						</ul>
						<ul class="nav pull-right">
							<li class="active"><a href="Form.jsp">Register</a></li>
							<li class="divider-vertical"></li>
							<li><a href="#login">Login</a></li>
						</ul>
					</div><!--/.nav-collapse -->
				</div>
			</div>
		</div>
    
        <div class="container">
            <div class="page-header">
            	<h1>All of your hobby train needs <small>Register</small></h1>
            </div>
            	<div class="row-fluid">
            		<div class="span4">
            			<div class="page-header"><h3>AllAboardToys</h3></div>
	            		<p>Welcome to All Aboard Toys where you will find quality, name brand, wooden toy trains, plus:</p>
	            		<ul>
	            			<li>Orders ship in 1 buisness day</li>
	            			<li>All items are in stocks</li>
	            			<li>Online order tracking</li>
	            			<li>Competitive prices</li>
	            			<li>Personal Service</li>
	            		</ul>
	            		<p>Thank you for shopping with All Aboard Toys</p>
	            	</div>
	            	<div class="span8">
		            	<div class="page-header"><h3>Register here:</h3></div>
	        
				        <%
				            Connection con = null;
				            Statement stmt = null;
				            ResultSet rset = null;
				            PreparedStatement ps = null;
				            
				            if(request.getMethod().equals("GET")) {                             
				        %>
				        <div class="row-fluid">
				        	<div class="span4">
						        <form action='Form.jsp' method='post'>
						        	<fieldset>
							            <label>Name:</label>
							            <input type='text' name='NAME' required/>
							            <br>
							            <label>Email:</label>
							            <input type='email' name='EMAIL' required/>
							            <br>
							            <label>Address:</label>
							            <input type='text' name='ADDRESS' required/>
							            <br>
							            <button type='reset' class="btn">Reset</button>
							            <button type='submit' class="btn btn-primary">Submit</button>
						        	</fieldset>
						        </form>
				        	</div>
				        	<div class="span4">
				        		<img src="${pageContext.request.contextPath}/img/toyset.jpg" width="600" height="600">
				        	</div>
				        </div>
        
        
        <%
            }
            if(request.getMethod().equals("POST")) {
                String name = request.getParameter("NAME");
                String email = request.getParameter("EMAIL");
                String address = request.getParameter("ADDRESS");
                int min = 1001;
                int max = 5001;
                int random = (int)(Math.random() * (max - min + 1) + min);

                try {
                    DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
                    
                    con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "student1", "pass");
            
                
                    ps = con.prepareStatement("INSERT INTO TOY_CUSTOMER VALUES(?,?,?,?)");
                    
                    ps.setInt(1, random);
                    ps.setString(2, name);
                    ps.setString(3, email);
                    ps.setString(4, address);

                    ps.executeUpdate();
        %>
        <a href="index.jsp">Homepage</a>
        <%
               }
                catch(Exception e) {

                }
                %>
                <div class="row-fluid">
                	<div class="span4">
		                <%@ taglib uri="/WEB-INF/tlds/taglib" prefix="thanks" %>
						<p><thanks:thankYouTag /></p>
					</div>
					<div class="span4">
						<img src="${pageContext.request.contextPath}/img/toyset.jpg" width="600" height="600">
					</div>
				</div>
				<%
            }
        %>
        		</div>
        	</div>
        </div>
        
		<footer class="footer">
        	<div class="container">
        		<p>Developed by: Carina Cardona, Erik Leath, Jaime Rodriguez</p>
        		<ul class="footer-links">
        			<li><a href="CreateInsert.jsp">Create Tables</a></li>
            		<li><a href="Drop.jsp">Delete Tables</a></li>
            		<li><a href="View">View Tables</a></li>
        		</ul>
        	</div>
        </footer>
    <script src="https://code.jquery.com/jquery.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
    </body>
</html>
