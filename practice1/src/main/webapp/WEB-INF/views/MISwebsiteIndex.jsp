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
<link rel="stylesheet" href="css/default.css" rel="stylesheet">
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
		<div class="row margin-top-10"></div>
		<!-- 用于控制与navbar间距 -->
		<div id="carousel-example" class="carousel slide" data-ride="carousel">
			<!-- Carousel Indicators -->
			<ol class="carousel-indicators">
				<li data-target="#carousel-example" data-slide-to="0" class="active"></li>
				<li data-target="#carousel-example" data-slide-to="1"></li>
				<li data-target="#carousel-example" data-slide-to="2"></li>
			</ol>
			<!-- End Carousel Indicators -->
			<!-- Carousel Images -->
			<div class="carousel-inner">
				<div class="item active">
					<img src="img/homepage01.jpg">
				</div>
				<div class="item">
					<img src="img/homepage02.jpg">
				</div>
				<div class="item">
					<img src="img/homepage03.jpg">
				</div>
			</div>
			<!-- End Carousel Images -->
			<!-- Carousel Controls -->
			<a class="left carousel-control" href="#carousel-example"
				data-slide="prev"> <span
				class="glyphicon glyphicon-chevron-left"></span>
			</a> <a class="right carousel-control" href="#carousel-example"
				data-slide="next"> <span
				class="glyphicon glyphicon-chevron-right"></span>
			</a>
			<!-- End Carousel Controls -->
		</div>
		<!-- End Carousel Slideshow -->

		<div class="row margin-top-10"></div>

		<div id="portfolio-wrapper">
			<br>
			<div id="content" class="container">
				<div class="row margin-top-10"></div>
				<div id="carousel-example" class="carousel slide"
					data-ride="carousel">
					<!-- Carousel Indicators -->
					<ol class="carousel-indicators">
						<li data-target="#carousel-example" data-slide-to="0"
							class="active"></li>
						<li data-target="#carousel-example" data-slide-to="1"></li>
						<li data-target="#carousel-example" data-slide-to="2"></li>
					</ol>
					<!-- End Carousel Indicators -->
					<!-- Carousel Images -->

					<!-- End Carousel Images -->

					<!-- End Carousel Controls -->
				</div>
				<!-- End Carousel Slideshow -->


				<!-- Page Content -->

				<div class="container">

					<div class="row">

						<div class="col-md-3">

							<div>

								<table style="border: 3px #FFFFFF solid; padding: 5px;"
									rules="all" cellpadding='15';>

									<tr>
										<td><a href="scheduleplan"><img src="img/pic/btn_1.png" alt="" /></a></td>
									</tr>
									<tr>
										<td><a href="scheduleplan"><img src="img/pic/btn_2.png" alt="" /></a></td>
									</tr>
									<tr>
										<td><a href="scheduleplan"><img src="img/pic/btn_3.png" alt="" /></a></td>
									</tr>
									<tr>
										<td><a href="scheduleplan"><img src="img/pic/btn_4.png" alt="" /></a></td>
									</tr>
									<tr>
										<td><a href="http://www.management.fju.edu.tw/subweb/phdba/06_class.php?CID=11" target="_blank"><img src="img/pic/btn_5.png" alt="" /></a></td>
									</tr>

								</table>
								<br>
							</div>
						</div>

						<div class="col-md-9">
							<div class="row carousel-holder">

								<div class="row">
									<div class="col-lg-12">
										<div class="panel panel-info">
											<div class="panel-heading">
												<h3 class="panel-title">最新消息</h3>
											</div>

											<div class="panel-body">
												<table
													class="table table-bordered table-hover table-striped">
													<tr>
														<th bgcolor=#DDDDDD width=150><font color="black">時間</font></th>
														<th bgcolor=#DDDDDD><font color="black">公告內容</font></th>
													</tr>
													<c:forEach items="${homeNews}" var="homeNews">
														<tr>
																<td><font color="black">${homeNews.publishTime}</font></td>
																<td><a href="newsDetail?buCode=${homeNews.buCode}" style="text-decoration: none;"><font
																		color="black">${homeNews.buTitle}</font></a></td>															
														</tr>
													</c:forEach>
												</table>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>



					</div>
				</div>
			</div>

			<div id="portfolio-wrapper">
				<div class="col-md-12">
					<div id="portfolio" class="container">

						<div class="col-md-3">
							<div class="box">
								<a class="fa fa-group fa-3x" href="#"></a>
								<h3>
									<b>專業師資</b>
								</h3>
								<p>
									<b>專業的教師<br> 各領域資源
									</b>
								</p>
								<a href="teacherInfo" class="button">m o r e</a>
							</div>
						</div>
						<div class="col-md-3">
							<div class="box">
								<a class="fa fa-trophy fa-3x" href="#"></a>
								<h3>
									<b>學生成果展</b>
								</h3>
								<p>
									<b>畢業製作成果展<br> 學生競賽作品
									</b>
								</p>
								<a href="Sym" class="button">m o r e</a>
							</div>
						</div>
						<div class="col-md-3">
							<div class="box">
								<a class="fa fa-globe fa-3x" href="#"></a>
								<h3>
									<b>招生訊息</b>
								</h3>
								<p>
									<b>豐富的學習資源<br> 良好的學習環境
									</b>
								</p>
								<a href="newsBranch?sCode=DG" class="button">m o r e</a>
							</div>
						</div>
						
						<div class="col-md-3">
							<div class="box">
								<a class="fa fa-bullhorn fa-3x" href="#"></a>
								<h3>
									<b>活動消息</b>
								</h3>
								<p>
									<b>系辦活動 系學會活動<br> 系友活動
									</b>
								</p>
								<a href="#" class="button">m o r e</a>
							</div>
						</div>
						
					</div>
				</div>
			</div>
		</div>
		<h5>
			相關連結
			<h5>
				<div id="portfolio-wrapper">
					<div class="col-md-12">
						<div id="portfolio" class="container">

							<div class="col-md-2">
								<div class="box">
									<a href="http://imnt.im.fju.edu.tw/"><img
										src="img/pic/seminar.jpg" width="250" height="50" alt="" /></a>
									<h6>
										<b>研討會</b>
									</h6>
								</div>
							</div>
							<div class="col-md-2">
								<div class="box">
									<a href="http://www.elearn.fju.edu.tw/"><img
										src="img/pic/ican.jpg" width="250" height="50" alt="" /></a>
									<h6>
										<b>輔大Ican平台</b>
									</h6>
								</div>
							</div>
							<div class="col-md-2">
								<div class="box">
									<a href="http://140.136.251.210/student/"><img
										src="img/pic/information.PNG" width="250" height="50" alt="" /></a>
									<h6>
										<b>學生資訊入口網</b>
									</h6>
								</div>
							</div>
							<div class="col-md-2">
								<div class="box">
									<a href="#"><img src="img/pic/fb.png" width="250"
										height="50" alt="" /></a>
									<h6>
										<b>輔大資管系FB</b>
									</h6>
								</div>
							</div>
							<div class="col-md-2">
								<div class="box">
									<a href="http://alumni.fju.edu.tw/"><img
										src="img/pic/adb.gif" width="250" height="50" alt="" /></a>
									<h6>
										<b>校友資料庫</b>
									</h6>
								</div>
							</div>
							<div class="col-md-2">
								<div class="box">
									<a
										href="http://kms.management.fju.edu.tw/kms/index.jsp?v=management&dirId=11811557"><img
										src="img/pic/aacsb.jpg" width="250" height="50" alt="" /></a>
									<h6>
										<b>管院AACSB戰報</b>
									</h6>
								</div>
							</div>

						</div>
					</div>
				</div>
	</div>
	<div class="row margin-top-10"></div>
	<!-- 用于控制与footer间距 -->
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


