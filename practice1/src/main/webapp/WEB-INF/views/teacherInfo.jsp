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

	<div id="content" class="container">

		<div class="row margin-vert-30">
			<div class="col-md-12">
				<h2>師資介紹</h2>
				<div class="row margin-top-20"></div>
				<div class="tabs">
					<ul class="nav nav-tabs">
						<li class="active"><a href="#proTeacher" data-toggle="tab">專任教師</a></li>
						<li class=""><a href="#partTeacher" data-toggle="tab">兼任教師</a></li>
					</ul>
					<div class="tab-content">
						<div class="tab-pane fade active in" id="proTeacher">
							<c:forEach items="${proTeacherList}" var="proTeacherList">
								<div class="portfolio-item col-md-4 code"
									style="position: relative; top: 0px;">
									<div class="image-hover">
										<a href="#"> </a>
										<figure>
											<a href="teacherDetailInfo?teaCode=${proTeacherList.teaCode}">
												<img src="img/teacherIMG/${proTeacherList.teaPic}"
												width="236" height="236">
											</a>
											<div class="overlay">
												<a
													href="teacherDetailInfo?teaCode=${proTeacherList.teaCode}">
												</a><a class="expand"
													href="teacherDetailInfo?teaCode=${proTeacherList.teaCode}">${proTeacherList.teaName }</a>
											</div>
										</figure>
										<h3 class="margin-top-20">${proTeacherList.teaName}&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;${proTeacherList.teaPos}</h3>
										<p class="margin-top-10">${proTeacherList.teaTel}<br>${proTeacherList.teaEmail}</p>
									</div>
								</div>
							</c:forEach>
							<div class="clearfix"></div>
						</div>

						<div class="tab-pane fade" id="partTeacher">
							<c:forEach items="${partTeacherList}" var="partTeacherList">
								<div class="portfolio-item col-md-4 code"
									style="position: relative; top: 0px;">
									<div class="image-hover">
										<a href="#"> </a>
										<figure>
											<a
												href="teacherDetailInfo?teaCode=${partTeacherList.teaCode}">
												<img src="img/teacherIMG/${partTeacherList.teaPic}"
												width="236" height="236">
											</a>
											<div class="overlay">
												<a
													href="teacherDetailInfo?teaCode=${partTeacherList.teaCode}">
												</a><a class="expand"
													href="teacherDetailInfo?teaCode=${partTeacherList.teaCode}">${partTeacherList.teaName }</a>
											</div>
										</figure>
										<h3 class="margin-top-20">${partTeacherList.teaName}&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;${partTeacherList.teaPos}</h3>
										<p class="margin-top-10">${partTeacherList.teaTel}<br>${partTeacherList.teaEmail}</p>
									</div>
								</div>
							</c:forEach>
							<div class="clearfix"></div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	</div>
	<!-- End Filter Buttons -->

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


