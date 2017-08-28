<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en">
<head>
	<!-- Title -->
	<title>updateaward</title>
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
	<!-- CKEditor -->
	<script src="//cdn.ckeditor.com/4.5.7/standard/ckeditor.js"></script>
</head>

<body>
	<%@include file="jspf/adminNavbar.jspf"%>

	
								
	<div class="container">	
		<div class="row">
			<br>
			<div class="col-md-12">	  			
				<h2>${updateaward.ar_title}</h2>				
			</div>
		</div><br/>
		
		<form method="post" action="updateaward" id="updateForm">
			<input type="hidden" name="ar_code" id="ar_code" value="${updateaward.ar_code}">

            <textarea name="award_cont" id="dic_cont" >
				${updateaward.award_cont}
            </textarea>
            <script>          
                CKEDITOR.replace( 'award_cont' );
            </script>

            <br/><button type="submit" class="btn btn-primary">修改</button>
        </form>	
        
        <div class="row">
			<br>
			<div class="col-md-12">	  			
				
			</div>
		</div>
		               			
	</div>
	
    
    	
    	
    	
	<%@include file="jspf/MISwebsiteFooter.jspf"%>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>    
 

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
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
	<script src="js/jquery.validate.js"></script>
	<script src="js/additional-methods.js"></script>
	<script src="js/messages_zh_TW.js"></script>
	<script>
	$("#updateForm").validate();
	</script>


</body>
</html>