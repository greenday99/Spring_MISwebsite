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
</head>
<body>
	<%@include file="jspf/adminNavbar.jspf"%>
	<div class="container">
		<div class="holder"></div>
		<a class="btn btn-default" href="newsInsert">新增公告</a>
		<table class="table table-bordered table-hover table-striped">
			<thead>
				<tr>
					<th bgcolor=#DDDDDD width=150><font color="black">時間</font></th>
					<th bgcolor=#DDDDDD><font color="black">公告標題</font></th>
					<th bgcolor=#DDDDDD><font color="black">類別</font></th>
					<th bgcolor=#DDDDDD><font color="black">編輯</font></th>
					<th bgcolor=#DDDDDD><font color="black"></font></th>
				</tr>
			</thead>
			<tbody id="itemContainer">
				<c:forEach items="${getNewsList}" var="getNewsList">
					<tr>
						<td><font color="black">${getNewsList.publishTime}</font></td>
						<td><font color="black">${getNewsList.buTitle}</font></td>
						<td><font color="black">${getNewsList.sName}</font></td>
						<td><a class="btn btn-default" href="newsUpdate?buCode=${getNewsList.buCode}">修改</a></td>
						<td><a class="btn btn-default" href="newsDelete?buCode=${getNewsList.buCode}">刪除</a></td>											
					</tr>
				</c:forEach>
			</tbody>	
		</table>
	</div>
<script src="js/jquery.min.js"></script>
<script src="js/jPages.js"></script>
<script src="js/bootstrap.min.js"></script>
<script>
	$(function(){
		$("div.holder").jPages({
			containerID: "itemContainer",
			perPage: 10,
			previous: "*前一頁",
	        next: "下一頁*",
		});
	});
</script>

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