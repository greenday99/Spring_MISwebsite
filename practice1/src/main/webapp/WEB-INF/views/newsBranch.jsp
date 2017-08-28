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
<%@include file="jspf/MISwebsiteNavbar.jspf"%>
<div class="container">
	<div class="row margin-vert-30">
	<!-- Begin Sidebar Menu -->
	<div class="col-md-3">
		<ul class="list-group sidebar-nav" id="sidebar-nav">
			<!-- 所有公告 -->
			<li class="list-group-item"><a href="news">所有公告</a></li>
			<!-- End 所有公告 -->
			<!-- 系所公告 -->
			<li class="list-group-item list-toggle">
				<a data-toggle="collapse" href="#news">系所公告</a>
				<ul id="news" class="collapse">
					<li><a href="newsBranch?sCode=DK"><i class="fa fa-pencil"></i>行政相關</a></li>
					<li><a href="newsBranch?sCode=DJ"><i class="fa fa-pencil"></i>企業徵才</a></li>
					<li><a href="newsBranch?sCode=DH"><i class="fa fa-pencil"></i>獎助學金</a></li>
					<li><a href="newsBranch?sCode=DF"><i class="fa fa-pencil"></i>學術活動與專題演講</a></li>
					<li><a href="newsBranch?sCode=DI"><i class="fa fa-pencil"></i>榮譽榜</a></li>
				</ul>
			</li>
			<!-- End 系所公告 -->					
		</ul>
	</div>
	<!-- End Sidebar Menu -->
	<div class="col-md-9">
		<div class="holder"></div>
		<table 
			class="table table-bordered table-hover table-striped">
			<thead>
				<tr>
					<th bgcolor=#DDDDDD width=150><font color="black">時間</font></th>
					<th bgcolor=#DDDDDD><font color="black">公告標題</font></th>
					<th bgcolor=#DDDDDD><font color="black">類別</font></th>
				</tr>
			</thead>
			<tbody id="itemContainer">
				<c:forEach items="${getNewsBranchList}" var="getNewsBranchList">
					<tr>
						<td><font color="black">${getNewsBranchList.publishTime}</font></td>
						<td><a href="newsDetail?buCode=${getNewsBranchList.buCode}" style="text-decoration: none;">
							<font color="black">${getNewsBranchList.buTitle}</font></a></td>
						<td><font color="black">${getNewsBranchList.sName}</font></td>															
					</tr>
				</c:forEach>
			</tbody>	
		</table>
	</div>
</div>
<%@include file="jspf/MISwebsiteFooter.jspf"%>

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

</body>
</html>