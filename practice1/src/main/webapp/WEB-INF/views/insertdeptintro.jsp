<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en">
<head>
	<!-- Title -->
	<title>fix</title>
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
	<script src="ckeditor/ckeditor.js"></script>
</head>

<body>
	<%@include file="jspf/adminNavbar.jspf"%>
    	

	<div class="container">
		<br/>
		<form method="post" action="insertdeptintro" id="insertdeptintro">
			<input type="hidden" name="di_code" value="${insertdeptintro.di_code}">
			<div class="form-group">
				<label>欄位編號:</label>
				<textarea type="text" name="dic_code" rows="3" cols="40"></textarea>
			</div>
			<div class="form-group">
				<label>欄位名稱:</label>
				<textarea type="text" name="dic_name" rows="3" cols="40"></textarea>
			</div>
			<div class="form-group">
				<label>內容:</label>
				<textarea type="text" name="dic_cont" rows="3" cols="40"></textarea>
			</div>
			<div class="form-group">
				<label>英文內容:</label> 
				<textarea type="text" name="dic_cont_en" rows="3" cols="40"></textarea>
			</div>
	
		<br/><button type="submit" class="btn btn-primary">新增</button>
        </form>	
        
	</div>


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