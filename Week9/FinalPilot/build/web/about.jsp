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

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
        <title>All Aboard Toys - About</title>
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
							<li class="active"><a href="about.jsp">About</a></li>
							<li><a href="#contact">Contact</a></li>
						</ul>
						<ul class="nav pull-right">
							<li><a href="Form.jsp">Register</a></li>
							<li class="divider-vertical"></li>
							<li><a href="#login">Login</a></li>
						</ul>
					</div><!--/.nav-collapse -->
				</div>
			</div>
		</div>
		
		<div class="container">
            <div class="page-header">
            	<h1>All of your hobby train needs <small>About Us</small></h1>
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
	            	<h2>Welcome!</h2>
	            	<p>Welcome to 'All Aboard Toys' - your #1 hotspot for quality name brand toy trains and accessories for ages 2 to 102.</p>
	            	<p>Established in 2020, the world's most incredible year, by 3 college students so that the toy train fanatics of the world may continue to access their favorite products despite physical locations being closed.</p>
	            	<p>Our central goal is to give best quality toys at the most minimal costs with incredible internet shopping experience! We're sure that you'll make the most of our items as much as we appreciate offering them to you.</p>
	            	<p>We don't just simply offer toy trains, we're energetic about them!</p>
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