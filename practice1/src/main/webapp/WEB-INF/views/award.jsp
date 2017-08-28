<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en">
<head>
	<!-- Title -->
	<title>deptintro</title>
	<!-- Meta -->
	<meta http-equiv="content-type" content="text/html; charset=UTF-8" />
	<meta name="description" content="">
	<meta name="author" content="">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1"/>
	<!-- Favicon -->
	<link href="favicon.html" rel="shortcut icon">
	<!-- Bootstrap Core CSS -->
	<link rel="stylesheet" href="css/bootstrap.css" rel="stylesheet">
	<!-- Template CSS -->
	<link rel="stylesheet" href="css/animate.css" rel="stylesheet">
	<link rel="stylesheet" href="css/font-awesome.css" rel="stylesheet">
	<link rel="stylesheet" href="css/nexus.css" rel="stylesheet">
	<link rel="stylesheet" href="css/responsive.css" rel="stylesheet">
	<link rel="stylesheet" href="css/custom.css" rel="stylesheet">
	<!-- Google Fonts-->
	<link href="http://fonts.googleapis.com/css?family=Lato:400,300" rel="stylesheet" type="text/css">
	<link href="http://fonts.googleapis.com/css?family=Open+Sans:400,300" rel="stylesheet" type="text/css">
</head>

<body>
	<%@include file="jspf/MISwebsiteNavbar.jspf"%>

<!-- 
	<input type="hidden" name="di_code" value="${imintro1.di_code}">
	<input type="hidden" name="di_code" value="${imintro2.di_code}">
	<input type="hidden" name="di_code" value="${imintro3.di_code}"> 
	
	<input type="hidden" name="di_code" value="${imintroList.di_code}">-->
	
		<!-- === BEGIN CONTENT === -->
		<div id="content" class="container">
			<div class="row margin-vert-30">
				<%@ include file="jspf/Sidebar.jsp" %>
						
				<div class="col-md-9">

				<div class="row margin-top-20">

			 			<ul class="nav nav-tabs">
						    <li class="active"><a data-toggle="tab" href="#home">得獎記錄</a></li>					    
					  	</ul>
					  	
				  	<c:forEach items="${awardList}" var="award">
					  	<div class="tab-content">
				  		<br />
					    <div id="home" class="tab-pane fade in active">
				      		<div class="col-md-12">
								<div class="panel panel-default">					
									<div class="panel-heading">
										<h3 class="panel-title">${award.ar_title}</h3>
									</div>											
									<div class="panel-body">
										${award.award_cont}
									</div>						
								</div>
							</div>
			   		 	</div>	    	
						</div>
					</c:forEach>
					
				</div>
			</div>
		</div>
	</div>
	
	<!-- === END CONTENT === -->

    	
	<%@include file="jspf/MISwebsiteFooter.jspf"%>
<!-- JS -->
<script type="text/javascript" src="js/jquery.min.js" type="text/javascript"></script>
<script type="text/javascript" src="js/bootstrap.min.js" type="text/javascript"></script>
<script type="text/javascript" src="js/scripts.js"></script>
<!-- Isotope - Portfolio Sorting -->
<script type="text/javascript" src="js/jquery.isotope.js" type="text/javascript"></script>
<!-- Mobile Menu - Slicknav -->
<script type="text/javascript" src="js/jquery.slicknav.js" type="text/javascript"></script>
<!-- Animate on Scroll-->
<script type="text/javascript" src="js/jquery.visible.js" charset="utf-8"></script>
<!-- Slimbox2-->
<script type="text/javascript" src="js/slimbox2.js" charset="utf-8"></script>
<!-- Modernizr -->
<script src="js/modernizr.custom.js" type="text/javascript"></script>
<!-- End JS -->


</body>
</html>