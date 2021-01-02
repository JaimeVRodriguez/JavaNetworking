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
<!--
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
 -->
 
<html>
    <head>
        <title>All Aboard Toys</title>
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
							<li class="active"><a href="index.jsp">Home</a></li>
							<li><a href="about.jsp">About</a></li>
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
            	<h1>All of your hobby train needs <small>Home</small></h1>
            </div>
            
            <div id="myCarousel" class="carousel slide">
            	<ol class="carousel-indicators">
            		<li data-target="#myCarousel" sata-slide-to="0" class="active"></li>
            		<li data-target="#myCarousel" sata-slide-to="1"></li>
            		<li data-target="#myCarousel" sata-slide-to="2"></li>
            	</ol>
            	<div class="carousel-inner">
            		<div class="active item">
						<img src="${pageContext.request.contextPath}/img/baby-yoda.jpg" width="400" height="400">
						<div class="carousel-caption">
							<h4>The Child</h4>
							<p>This is the child from the hit show, The Mandalorian.</p>
						</div>
					</div>
            		<div class="item"><img src="${pageContext.request.contextPath}/img/robot-dog.jpg" width="400" height="400">
						<div class="carousel-caption">
							<h4>Robot</h4>
							<p>This is a toy robot for your child's future needs.</p>
						</div>
					</div>
            		<div class="item"><img src="${pageContext.request.contextPath}/img/car.jpg" width="400" height="400">
						<div class="carousel-caption">
							<h4>Car</h4>
							<p>This is a drivable car to get your kid ready for driving when the time comes!</p>
						</div>
					</div>
            	</div>
            	<a class="carousel-control left" href="#myCarousel" data-slide="prev">&lsaquo;</a>
            	<a class="carousel-control right" href="#myCarousel" data-slide="next">&rsaquo;</a>
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
            	<div class="span4">
            		<div class="page-header"><h3>Featured Items</h3></div>
            		<a href="product.jsp"><img src="${pageContext.request.contextPath}/img/baby-yoda.jpg" width="200" height="200"></a>
            		<img src="${pageContext.request.contextPath}/img/robot-dog.jpg" width="200" height="200">
            		<img src="${pageContext.request.contextPath}/img/car.jpg" width="200" height="200">
            	</div>
            	<div class="span4">
            		<h1 style="color:red;">FREE SHIPPING</h1><p>on orders over $59.00 * PLUS register to win</p><h1 style="color:red;">$225 of FREE PRIZES!</h1>
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
