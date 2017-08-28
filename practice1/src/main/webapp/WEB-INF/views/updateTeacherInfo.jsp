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
<title>輔仁大學資訊管理學系管理后台</title>

</head>
<body>
	<%@include file="jspf/adminNavbar.jspf"%>

	<div id="content" class="container">
		<div class="row margin-vert-30"></div>
		<div class="col-md-6 col-md-offset-3 col-sm-offset-3">
			<form method="post" action="updateTeacherBasicInfoForm"
				id="updateForm" class="signup-page" enctype="multipart/form-data">
				<input type="hidden" name="teaCode" value=${updateInfo.teaCode }>
				<input type="hidden" name="teaLDAP" value=${updateInfo.teaLDAP }>

				<div class="form-group">
					<label>顯示圖片<span class="color-red">*</span></label> <br> <img
						src="img/teacherIMG/${updateInfo.teaPic}" width="100" height="100">
					<input type="file" name="file" accept="image/*" /> <span
						class="color-red margin-buttom-20">請上傳英文名的圖片</span>
				</div>

				<div class="form-group">
					<label>姓名<span class="color-red">*</span></label> <input
						type="text" name="teaName" value="${updateInfo.teaName}"
						class="form-control margin-buttom-20" required>
				</div>

				<div class="form-group">
					<label>姓名英文<span class="color-red">*</span></label> <input
						type="text" name="teaENName" value="${updateInfo.teaENName}"
						class="form-control margin-buttom-20" required>
				</div>

				<div class="form-group">
					<label for="category">教師類型<span class="color-red">*</span></label>
					<select class="form-control" name="teaType">
						<option value="T" ${updateInfo.teaType=="T"?'selected':''}>專職教師</option>
						<option value="B" ${updateInfo.teaType=="B"?'selected':''}>兼任教師</option>
					</select>
				</div>

				<div class="form-group">
					<label for="category">職稱<span class="color-red">*</span></label> <select
						class="form-control" name="teaPos">
						<option value="DA" ${updateInfo.teaPos=="教授兼系主任"?'selected':''}>教授兼系主任</option>
						<option value="DD" ${updateInfo.teaPos=="副教授兼系主任"?'selected':''}>副教授兼系主任</option>
						<option value="DT" ${updateInfo.teaPos=="教授"?'selected':''}>教授</option>
						<option value="DQ" ${updateInfo.teaPos=="副教授"?'selected':''}>副教授</option>
						<option value="DR" ${updateInfo.teaPos=="助理教授"?'selected':''}>助理教授</option>
						<option value="DS" ${updateInfo.teaPos=="講師"?'selected':''}>講師</option>
						<option value="DZ" ${updateInfo.teaPos=="離校"?'selected':''}>離校</option>
					</select>
				</div>

				<div class="form-group">
					<label>聯繫電話<span class="color-red">*</span></label> <input
						type="text" name="teaTel" value="${updateInfo.teaTel}"
						class="form-control margin-buttom-20" required>
				</div>

				<div class="form-group">
					<label>E-mail<span class="color-red">*</span></label> <input
						type="text" name="teaEmail" value="${updateInfo.teaEmail}"
						class="form-control margin-buttom-20" required>
				</div>

				<div class="form-group">
					<label>办公地址<span class="color-red">*</span></label> <input
						type="text" name="teaLoc" value="${updateInfo.teaLoc}"
						class="form-control margin-buttom-20" required>
				</div>

				<button type="submit" class="btn btn-primary">修改</button>
				<a type="button" class="btn btn-default" href="teacherManage">返回</a>
			</form>
		</div>
		<div class="clearfix"></div>
	</div>

	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>

	<script>
		$("#updateForm").validate();
	</script>
</body>

<!-- JS -->
<script type="text/javascript" src="js/jquery.min.js"
	type="text/javascript"></script>
<script type="text/javascript" src="js/bootstrap.min.js"
	type="text/javascript"></script>
<script src="js/jquery.validate.js"></script>
<script src="js/additional-methods.js"></script>
<script src="js/messages_zh_TW.js"></script>
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


