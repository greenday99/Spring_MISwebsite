<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<title>輔仁大學資訊管理學系</title>

</head>
<body>
	<%@include file="jspf/MISwebsiteNavbar.jspf"%>
	
		<!-- === BEGIN CONTENT === -->
		<div id="content" class="container">
			<div class="container">
				<div class="row margin-vert-30">
					<!-- Login Box -->
					<div class="col-md-6 col-md-offset-3 col-sm-offset-3">
						<form class="login-page" action="login" method="post" role="form">
							<div class="login-header margin-bottom-30">
								<h2>登入</h2>
								<h4>${message}</h4>
							</div>
							<div class="input-group margin-bottom-20">
								<span class="input-group-addon"><i class="fa fa-user"></i></span>
								<input placeholder="Username" class="form-control" type="text" name="userName">
							</div>
							<div class="input-group margin-bottom-20">
								<span class="input-group-addon"><i class="fa fa-lock"></i></span>
								<input placeholder="Password" class="form-control" type="password" name="password">
							</div>
							<div class="row">
								<div class="col-md-6">
								<!-- 暫無此功能 
									<label class="checkbox"><input type="checkbox"> Stay signed in</label> -->
								</div>
								<div class="col-md-6">
									<button class="btn btn-primary pull-right" type="submit">登入</button>
								</div>
							</div>
							<hr>
							<!-- 暫無此功能 
							<h4>Forget your Password ?</h4>
							<p><a href="#">Click here</a> to reset your password.</p>-->
						</form>
					</div>
					<!-- End Login Box -->
				</div>
			</div>
		</div>
		<!-- === END CONTENT === -->
		
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