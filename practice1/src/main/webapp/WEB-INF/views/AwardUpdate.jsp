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
<title>教學成果管理- 修改 教師教學成果獎</title>
</head>

<body>
	<%@include file="jspf/adminNavbar.jspf"%>
	<div id="content" class="container">
		<div class="row margin-top-10"></div>
		<!-- 用于控制与navbar间距 -->


		<div class="row">
			<br>
			<div class="col-md-3"></div>
			<div class="col-md-6">


				<form method="post" action="updateAward">

					<div class="form-group">
						<label>文章編號</label>
						<textarea type="text" rows="3" cols="40" name="articleid">${awardList.articleid}</textarea>
					</div>

					<div class="form-group">
						<label>中文內容</label>
						<textarea type="text" rows="3" cols="40" name="articlecontent">${awardList.articlecontent}</textarea>
					</div>

					<div class="form-group">
						<label>英文內容</label>
						<textarea type="text" rows="3" cols="40"
							name="articleenglishcontent">${awardList.articleenglishcontent}</textarea>
					</div>

					<button type="submit" class="btn btn-primary">確認</button>
				</form>


			</div>
			<div class="col-md-3"></div>
		</div>
	</div>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/jquery.validate.js"></script>
	<script src="js/additional-methods.js"></script>
	<script src="js/messages_zh_TW.js"></script>
	<script>
		$("#updateForm").validate({
			rules : {
				sym_code : "required",
				sym_name : "required",
				sym_url : "required"
			}
		});
	</script>
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