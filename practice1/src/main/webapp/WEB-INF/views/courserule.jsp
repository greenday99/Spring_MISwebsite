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
		<div class="row margin-vert-30">
			<!-- Begin Sidebar Menu -->
			<div class="col-md-3">
				<ul class="list-group sidebar-nav" id="sidebar-nav">
					<!-- 學習目標職涯CVHS暨畢業生未來發展 -->
					<li class="list-group-item"><a
						href="http://www.cvhs.fju.edu.tw/cvhs2014/system/aboutUs">學習目標職涯CVHS暨畢業生未來發展</a></li>
					<!-- End 學習目標職涯CVHS暨畢業生未來發展 -->
					<!-- 修業規則 -->
					<li class="list-group-item"><a href="courserule">修業規則</a></li>
					<!-- End 修業規則 -->
					<!-- 大學部 -->
					<li class="list-group-item list-toggle"><a
						data-toggle="collapse" data-parent="#sidebar-nav"
						href="#collapse-university">大學部</a>
						<ul id="collapse-university" class="collapse">
							<li><a href="course"><i class="fa fa-clock-o"></i>課程時間表</a>
							</li>
							<li><a href="scheduleplan"><i class="fa fa-pencil"></i>課程規劃</a>
							</li>
						</ul></li>
					<!-- End 大學部 -->
					<!-- 碩士班 -->
					<li class="list-group-item list-toggle"><a
						class="accordion-toggle" href="#collapse-master"
						data-toggle="collapse">碩士班</a>
						<ul id="collapse-master" class="collapse">
							<li><a href="course"><i class="fa fa-clock-o"></i>課程時間表</a>
							</li>
							<li><a href="scheduleplan"><i class="fa fa-pencil"></i>課程規劃</a>
							</li>
						</ul></li>
					<!-- End 碩士班 -->
					<!-- 在職專班 -->
					<li class="list-group-item list-toggle"><a
						class="accordion-toggle" href="#collapse-executivemaster"
						data-toggle="collapse">在職專班</a>
						<ul id="collapse-executivemaster" class="collapse">
							<li><a href="course"><i class="fa fa-clock-o"></i>課程時間表</a>
							</li>
							<li><a href="scheduleplan"><i class="fa fa-pencil"></i>課程規劃</a>
							</li>
						</ul></li>
					<!-- End 在職專班 -->
					<!-- 產業實習 -->
					<li class="list-group-item"><a
						href="http://www.management.fju.edu.tw/subweb/internship/00_infomation.php">產業實習</a></li>
					<!-- End 產業實習 -->
					<!-- 選課資訊網 -->
					<li class="list-group-item"><a
						href="http://www.course.fju.edu.tw/student/Main.htm">選課資訊網</a></li>
					<!-- End 選課資訊網 -->
					<!-- 課程大綱查詢系統 -->
					<li class="list-group-item"><a
						href="http://140.136.251.64/Outlines/student/">課程大綱查詢系統</a></li>
					<!-- End 課程大綱查詢系統 -->
					<!-- 管理學院境外學習 -->
					<li class="list-group-item"><a
						href="http://www.management.fju.edu.tw/subweb/studyabroad/">管理學院境外學習</a></li>
					<!-- End 管理學院境外學習 -->
				</ul>
			</div>
			<!-- End Sidebar Menu -->
			<div class="col-md-9">
				<h2>修業規則</h2>
				<div class="row margin-top-20">
					<div class="panel panel-primary">
						<div class="panel-heading">
							<c:forEach items="${courseruleList}" var="courserule">
								<!-- <h3 class="panel-title">資訊管理學系修業規則-經103.11.26教務會議通過 (104學年入學新生適用)</h3> -->
   	${courserule.articlecontent}
  </c:forEach>
						</div>
						<div class="panel-body">
							<div class="courserule">
								<a
									href="https://imwebegroupservice.storage.googleapis.com/CourseRules(for+104).pdf"
									class="fa fa-cloud-download fa-2x "
									style="font-size: 16px; text-align: center;">CourseRules(for+104).pdf
									(檔案連結)</a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<%@include file="jspf/MISwebsiteFooter.jspf"%>
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
