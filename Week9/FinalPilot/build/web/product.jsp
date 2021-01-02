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

<%-- The product information was brought to you by: https://www.target.com/p/star-wars-the-child-7-2-34-animatronic-edition/-/A-79632143?ref=tgt_adv_XS000000&AFID=google_pla_df&fndsrc=tgtao&DFA=71700000012732796&CPNG=PLA_Toys_Priority%2BShopping_Local&adgroup=Toys_Priority+TCINs&LID=700000001170770pgs&LNM=PRODUCT_GROUP&network=g&device=c&location=9031579&targetid=aud-985052325085:pla-627451266716&ds_rl=1246978&ds_rl=1248099&gclid=CjwKCAiArbv_BRA8EiwAYGs23BGiDG69OqbygOYgXgYvtLRWIqfhhIJdsMS6YdDLMWClS74qjz6IVBoCblMQAvD_BwE&gclsrc=aw.ds --%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
        <title>All Aboard Toys - The Child</title>
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
            	<h1>All of your hobby train needs <small>Product</small></h1>
            </div>
			<div class="row-fluid">
				<div class="span12">
					<ul class="breadcrumb">
						<li><a href="index.jsp">Home</a> <span class="divider">/</span></li>
						<li class="active">The Child</li>
					</ul>
					<div class="row-fluid">
						<div class="span6">
							<h3>The Child</h3>
							<img src="${pageContext.request.contextPath}/img/baby-yoda.jpg">
							<div class="row-fluid">
								<div class="span6">
									<h5>Details</h5>
									<ul>
										<li>SERIES-INSPIRED SOUNDS: Touch the top of The Child Animatronic Edition's head to activate sound effects inspired by The Mandalorian, including happy and excited, giggles and babbles, tired and sleeping, and Force effects sounds</li>
										<li>ANIMATED TOY: Features motorized movements, including a head that moves up and down, ears that move back and forth, eyes that open and close, and more</li>
										<li>FORCE ACTIVATION: Boys and girls ages 4 and up will love patting The Child Animatronic Edition's head 3 times for Force activation, in which the animatronic toy will raise its arm, close its eyes, and sigh, as if using the Force</li>
										<li>FORCE NAP: Pretending to channel the Force takes a whole lot of energy and requires a lot of rest. Lay The Child toy down and it will close its eyes and take a "Force nap"</li>
										<li>STYLED AFTER THE DISNEY PLUS SERIES: Inspired by the fan-favorite character from The Mandalorian, this 7.2-inch-tall Star Wars toy by Hasbro includes a removable Mandalorian pendant necklace and premium soft goods robe</li>
									</ul>
								</div>
								<div class="span6">
									<h5>Description</h5>
									<p>From Hasbro's Star Wars Collection: The Child Animatronic Edition with sounds and motorized sequences!</p>
									<p>Now you can become the protector of The Child, also affectionately known to fans as "Baby Yoda," with this 7.2-inch-tall animatronic toy by Hasbro. Touching the top of The Child Animatronic Edition's head activates over 25 sound and motion combinations, including happy and excited sounds, giggles, babbles, and more, all while the figure's head moves up and down, ears move back and forth, and eyes open and close. Boys and girls ages 4 and up can pretend to harness the power of the Force as The Child toy closes its eyes, raises its arm, and sighs as if exerting a great amount of energy.</p>
									<p>Star Wars products are produced by Hasbro under license from Lucasfilm Ltd. <i>trademarks of Hasbro.</i></p>
								</div>
							</div>
						</div>
						<div class="span6">
							<h3>Other Details</h3>
							<div class="tabbable">
								<ul class="nav nav-tabs">
									<li class="active"><a href="#tab1" data-toggle="tab">Shipping/Returns</a></li>
									<li><a href="#tab2" data-toggle="tab">Q&A</a>
								</ul>
								<div class="tab-content">
									<div class="tab-pane active" id="tab1">
										<h5>Shipping details</h5>
										<p>Estimated ship dimensions: 4.02 inches length x 10 inches width x 10 inches height</p>
										<p>Estimated ship weight: 1.35 pounds</p>
										
										<h5>Return details</h5>
										<p>This item can be returned</p>
										<p>This item must be returned within 90 days of the in-store purchase, ship date or online order pickup.</p>
									</div>
									<div class="tab-pane" id="tab2">
										<h5>Q: Is the body of this toy soft or hard?</h5>
										<p><b>A: </b>It is a hard rubber material. Its NOT plush, nor is it rock hard. It is like as an example a hard plastic baby doll covered in thin rubber skin. Hope that helps. Either way its a really great figure as the eyelids blink and close, his ears move, and lots of sounds! Very cool.</p>
										<p><b>A: </b>Thank you for your inquiry. The Star Wars The Child Animatronic Edition has a hard body.</p>
										<hr>
										<h5>Q: Do they all come with a very low quality speaker? Or is mine a bad toy?</h5>
										<p><b>A: </b>I think that you might have gotten a defective toy. The sound quality on my little Grogu is pretty realistic and sounds fine especially being a toy. I'd suggest that you exchange it. You can test a new one out in the store to compare.</p>
										<p><b>A: </b>Mine is crisp clear and very loud. I had to tape fabric over the speaker.</p>
									</div>
								</div>
							</div>
						</div>
						<div class="row-fluid">
							<div class="span11">
								<p>
									<button class="btn btn-primary" type="button">Add to cart</button>
								</p>
							</div>
						</div>
					</div>
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