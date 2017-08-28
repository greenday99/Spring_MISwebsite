<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

<head>
	<!-- Meta -->
	<meta http-equiv="content-type" content="text/html; charset=utf-8" />
	<meta name="description" content="">
	<meta name="author" content="">
	<meta name="viewport"
		content="width=device-width, initial-scale=1, maximum-scale=1" />

	<!-- Bootstrap core CSS -->
	<link rel="stylesheet" href="css/bootstrap.css" rel="stylesheet">

	<!-- Template CSS -->
	<link rel="stylesheet" href="css/animate.css" rel="stylesheet">
	<link rel="stylesheet" href="css/font-awesome.css" rel="stylesheet">
	<link rel="stylesheet" href="css/nexus.css" rel="stylesheet">
	<link rel="stylesheet" href="css/responsive.css" rel="stylesheet">
	<link rel="stylesheet" href="css/custom.css" rel="stylesheet">
	
	<!-- Google Fonts -->
	<link href="http://fonts.googleapis.com/css?family=Lato:400,300"
		rel="stylesheet" type="text/css">
	<link href="http://fonts.googleapis.com/css?family=Open+Sans:400,300"
		rel="stylesheet" type="text/css">

	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<title>教學成果管理- 教師成果獎管理</title>
</head>

<body>
	<%@include file="jspf/adminNavbar.jspf"%>
	<div id="content" class="container">
		<div class="row margin-top-10"></div><!-- 用于控制与navbar间距 -->
	
	<div class="container">
		
	
		<div class="row">
			<br>
				<%@include file="jspf/adminSidebar.jsp"%>
			<div class="col-md-9">
		  		<a class="btn btn-primary" href="insertAward">新增文章</a>	
				<table class="table">
				  	<tr>
				  		<th>編號</th>
				  		<th>中文內容</th>
				  		<th>英文內容</th>
				  	</tr>
				  	  	
				  	<c:forEach items="${awardList}" var="award">
					  	<tr>
					  		<td>${award.articleid}</td>
					  		<td>${award.articlecontent}</td>
					  		<td>${award.articleenglishcontent}</td>
					  		<td>
					  			<a class="btn btn-default" href="updateAward?articleid=${award.articleid}">修改</a>
					  			<a class="btn btn-sm btn-danger deleteBtn" href="deleteAward?articleid=${award.articleid}">刪除</a>
					  		</td>
					  	</tr>
				  	</c:forEach>
				 </table>
			</div>
		</div>
	</div>
	
	
	
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>    
    
    
    <div id="content" class="container">
		<div class="row margin-top-10"></div><!-- 用于控制与navbar间距 -->
	</div>
	
	<div class="row margin-top-10"></div><!-- 用于控制与footer间距 -->
	</div>
	
	<%@include file="jspf/MISwebsiteFooter.jspf"%>
	
</body>

<!-- JS -->
<script type="text/javascript" src="js/jquery.min.js"
	type="text/javascript"></script>
<script type="text/javascript" src="js/bootstrap.min.js"
	type="text/javascript"></script>
<script type="text/javascript" src="js/scripts.js"></script>
<!-- Isotope - Portfolio Sorting -->
<script type="text/javascript" src="js/jquery.isotope.js"
	type="text/javascript"></script>
<!-- Mobile Menu - Slicknav -->
<script type="text/javascript" src="js/jquery.slicknav.js"
	type="text/javascript"></script>
<!-- Animate on Scroll-->
<script type="text/javascript" src="js/jquery.visible.js"
	charset="utf-8"></script>
<!-- Slimbox2-->
<script type="text/javascript" src="js/slimbox2.js" charset="utf-8"></script>
<!-- Modernizr -->
<script src="js/modernizr.custom.js" type="text/javascript"></script>
<!-- End JS -->

</html>