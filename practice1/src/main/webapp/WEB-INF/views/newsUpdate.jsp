<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>NewsPage</title>
<link rel="stylesheet" href="css/animate.css" rel="stylesheet">
<link rel="stylesheet" href="css/jPages.css" rel="stylesheet">
<link rel="stylesheet" href="css/bootstrap.css" rel="stylesheet">


<!-- Meta -->
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<meta name="description" content="">
<meta name="author" content="">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1" />
<!-- Template CSS -->
<link rel="stylesheet" href="css/font-awesome.css" rel="stylesheet">
<link rel="stylesheet" href="css/nexus.css" rel="stylesheet">
<link rel="stylesheet" href="css/responsive.css" rel="stylesheet">
<link rel="stylesheet" href="css/custom.css" rel="stylesheet">
<!-- Google Fonts -->
<link href="http://fonts.googleapis.com/css?family=Lato:400,300"
	rel="stylesheet" type="text/css">
<link href="http://fonts.googleapis.com/css?family=Open+Sans:400,300"
	rel="stylesheet" type="text/css">
<script src="js/jquery.min.js"></script>
<script src="js/jPages.js"></script>
<script src="js/bootstrap.min.js"></script>
	<script src="ckeditor/ckeditor.js"></script>
</head>
<body>
<%@include file="jspf/adminNavbar.jspf"%>
<div class="container">
	<div class="row margin-vert-30">
	<form method="post" action="newsUpdate">
		<input type="hidden" name="buCode" value="${getNewsDetail.buCode}">
		<label>公告標題</label>
		<div><textarea name="buTitle" rows="1" cols="40">${getNewsDetail.buTitle}</textarea></div><br>
		<label>公告類別</label>
		<div>
			<select name="sCode">
				<option value="DB" ${getNewsDetail.sName=="研討會"?'selected':''}>研討會</option>
				<option value="DC" ${getNewsDetail.sName=="跨系活動"?'selected':''}>跨系活動</option>
				<option value="DE" ${getNewsDetail.sName=="產業實習"?'selected':''}>產業實習</option>
				<option value="DZ" ${getNewsDetail.sName=="其他"?'selected':''}>其他</option>
				<option value="DK" ${getNewsDetail.sName=="一般公告"?'selected':''}>一般公告</option>
				<option value="DF" ${getNewsDetail.sName=="學術活動與專題演講"?'selected':''}>學術活動與專題演講</option>
				<option value="DG" ${getNewsDetail.sName=="招生訊息"?'selected':''}>招生訊息</option>
				<option value="DH" ${getNewsDetail.sName=="獎助學金"?'selected':''}>獎助學金</option>
				<option value="DI" ${getNewsDetail.sName=="榮譽榜"?'selected':''}>榮譽榜</option>
				<option value="DJ" ${getNewsDetail.sName=="企業徵才"?'selected':''}>企業徵才</option>
				<option value="DL" ${getNewsDetail.sName=="系辦行政公告"?'selected':''}>系辦行政公告</option>
			</select>
		</div><br>
		<label>公告內容</label>
		<div><textarea name="buCont" rows="5" cols="60">${getNewsDetail.buCont}</textarea></div><br>
		<script>         
     		CKEDITOR.replace( 'buCont' );
		</script>
		<br/><button type="submit" class="btn btn-primary">修改</button>
	</form>
</div>

<script src="js/jquery.validate.js"></script>
<script src="js/additional-methods.js"></script>
<script src="js/messages_zh_TW.js"></script>
<!-- JS -->
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

</body>
</html>