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
<link rel="stylesheet" href="css/course.css" rel="stylesheet">
<!-- Google Fonts -->
<link href="http://fonts.googleapis.com/css?family=Lato:400,300"
	rel="stylesheet" type="text/css">
<link href="http://fonts.googleapis.com/css?family=Open+Sans:400,300"
	rel="stylesheet" type="text/css">

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<title>輔仁大學資訊管理學系管理后台</title>
<!-- CKeditor -->
<script src="ckeditor/ckeditor.js"></script>
</head>
<body>
	<%@include file="jspf/adminNavbar.jspf"%>
	<!-- === BEGIN CONTENT === -->
	<div id="content" class="container">
		<div class="row margin-vert-30">

			<div class="col-md-12">
				<h2>課程時間表</h2>
				<div class="row margin-top-20">
					<!-- Tab v2 -->
					<div class="tabs alternative">
						<ul class="nav nav-tabs">
							<li class="active"><a href="#sample-2a" data-toggle="tab">資一甲</a></li>
							<li><a href="#sample-2b" data-toggle="tab">資一乙</a></li>
							<li><a href="#sample-2c" data-toggle="tab">資二甲</a></li>
							<li><a href="#sample-2d" data-toggle="tab">資二乙</a></li>
							<li><a href="#sample-2e" data-toggle="tab">資三甲</a></li>
							<li><a href="#sample-2f" data-toggle="tab">資三乙</a></li>
							<li><a href="#sample-2g" data-toggle="tab">資四甲、四乙</a></li>
							<li><a href="#sample-2h" data-toggle="tab">碩士班</a></li>
							<li><a href="#sample-2i" data-toggle="tab">在職專班</a></li>
						</ul>
						<div class="tab-content">
							<div class="tab-pane fade in active" id="sample-2a">
								<div class="course">
									<c:forEach items="${courseListU11}" var="course">
										<form method="post" action="updateCourse" id="updateForm">
											<div>
												<input type="hidden" name="dc_code"
													value="${course.dc_code}">
											</div>
											<!-- 
								<div>
									<label for="div_code">div_code</label>
									<br/>
									<input type="hidden" name="div_code" value="${course.div_code}">
								</div>
								<div>
								<label for="dc_class">dc_class</label>
									<br/>
									<input type="hidden" name="dc_class" value="${course.dc_class}">
								</div>
								-->
											<div>
												<label for="class_sche">課表內容</label> <br />
												<textarea name="class_sche" id="course_manageU11" rows="10"
													cols="80">
										${course.class_sche}
								</textarea>
												<script>
													CKEDITOR.replace(
															'course_manageU11',
															{
																width : 700,
															});
												</script>
											</div>
											<br />
											<!-- <button type="submit" class="btn btn-primary">修改</button> -->
										</form>
									</c:forEach>
								</div>
							</div>
							<div class="tab-pane fade in" id="sample-2b">
								<div class="course">
									<c:forEach items="${courseListU12}" var="course">
										<form method="post" action="updateCourse" id="updateForm">
											<div>
												<input type="hidden" name="dc_code"
													value="${course.dc_code}">
											</div>
											<!-- 
								<div>
									<label for="div_code">div_code</label>
									<br/>
									<input type="hidden" name="div_code" value="${course.div_code}">
								</div>
								<div>
								<label for="dc_class">dc_class</label>
									<br/>
									<input type="hidden" name="dc_class" value="${course.dc_class}">
								</div>
								-->
											<div>
												<label for="class_sche">課表內容</label> <br />
												<textarea name="class_sche" id="course_manageU12" rows="10"
													cols="80">
										${course.class_sche}
								</textarea>
												<script>
													CKEDITOR.replace(
															'course_manageU12',
															{
																width : 700,
															});
												</script>
											</div>
											<br />
											<!-- <button type="submit" class="btn btn-primary">修改</button> -->
										</form>
									</c:forEach>
								</div>
							</div>
							<div class="tab-pane fade in" id="sample-2c">
								<div class="course">
									<c:forEach items="${courseListU21}" var="course">
										<form method="post" action="updateCourse" id="updateForm">
											<div>
												<input type="hidden" name="dc_code"
													value="${course.dc_code}">
											</div>
											<!-- 
								<div>
									<label for="div_code">div_code</label>
									<br/>
									<input type="hidden" name="div_code" value="${course.div_code}">
								</div>
								<div>
								<label for="dc_class">dc_class</label>
									<br/>
									<input type="hidden" name="dc_class" value="${course.dc_class}">
								</div>
								-->
											<div>
												<label for="class_sche">課表內容</label> <br />
												<textarea name="class_sche" id="course_manageU21" rows="10"
													cols="80">
										${course.class_sche}
								</textarea>
												<script>
													CKEDITOR.replace(
															'course_manageU21',
															{
																width : 700,
															});
												</script>
											</div>
											<br />
											<!-- <button type="submit" class="btn btn-primary">修改</button> -->
										</form>
									</c:forEach>
								</div>
							</div>
							<div class="tab-pane fade in" id="sample-2d">
								<div class="course">
									<c:forEach items="${courseListU22}" var="course">
										<form method="post" action="updateCourse" id="updateForm">
											<div>
												<input type="hidden" name="dc_code"
													value="${course.dc_code}">
											</div>
											<!-- 
								<div>
									<label for="div_code">div_code</label>
									<br/>
									<input type="hidden" name="div_code" value="${course.div_code}">
								</div>
								<div>
								<label for="dc_class">dc_class</label>
									<br/>
									<input type="hidden" name="dc_class" value="${course.dc_class}">
								</div>
								-->
											<div>
												<label for="class_sche">課表內容</label> <br />
												<textarea name="class_sche" id="course_manageU22" rows="10"
													cols="80">
										${course.class_sche}
								</textarea>
												<script>
													CKEDITOR.replace(
															'course_manageU22',
															{
																width : 700,
															});
												</script>
											</div>
											<br />
											<!-- <button type="submit" class="btn btn-primary">修改</button> -->
										</form>
									</c:forEach>
								</div>
							</div>
							<div class="tab-pane fade in" id="sample-2e">
								<div class="course">
									<c:forEach items="${courseListU31}" var="course">
										<form method="post" action="updateCourse" id="updateForm">
											<div>
												<input type="hidden" name="dc_code"
													value="${course.dc_code}">
											</div>
											<!-- 
								<div>
									<label for="div_code">div_code</label>
									<br/>
									<input type="hidden" name="div_code" value="${course.div_code}">
								</div>
								<div>
								<label for="dc_class">dc_class</label>
									<br/>
									<input type="hidden" name="dc_class" value="${course.dc_class}">
								</div>
								-->
											<div>
												<label for="class_sche">課表內容</label> <br />
												<textarea name="class_sche" id="course_manageU31" rows="10"
													cols="80">
										${course.class_sche}
								</textarea>
												<script>
													CKEDITOR.replace(
															'course_manageU31',
															{
																width : 700,
															});
												</script>
											</div>
											<br />
											<!-- <button type="submit" class="btn btn-primary">修改</button> -->
										</form>
									</c:forEach>
								</div>
							</div>
							<div class="tab-pane fade in" id="sample-2f">
								<div class="course">
									<c:forEach items="${courseListU32}" var="course">
										<form method="post" action="updateCourse" id="updateForm">
											<div>
												<input type="hidden" name="dc_code"
													value="${course.dc_code}">
											</div>
											<!-- 
								<div>
									<label for="div_code">div_code</label>
									<br/>
									<input type="hidden" name="div_code" value="${course.div_code}">
								</div>
								<div>
								<label for="dc_class">dc_class</label>
									<br/>
									<input type="hidden" name="dc_class" value="${course.dc_class}">
								</div>
								-->
											<div>
												<label for="class_sche">課表內容</label> <br />
												<textarea name="class_sche" id="course_manageU32" rows="10"
													cols="80">
										${course.class_sche}
								</textarea>
												<script>
													CKEDITOR.replace(
															'course_manageU32',
															{
																width : 700,
															});
												</script>
											</div>
											<br />
											<!-- <button type="submit" class="btn btn-primary">修改</button> -->
										</form>
									</c:forEach>
								</div>
							</div>
							<div class="tab-pane fade in" id="sample-2g">
								<div class="course">
									<c:forEach items="${courseListU41}" var="course">
										<form method="post" action="updateCourse" id="updateForm">
											<div>
												<input type="hidden" name="dc_code"
													value="${course.dc_code}">
											</div>
											<!-- 
								<div>
									<label for="div_code">div_code</label>
									<br/>
									<input type="hidden" name="div_code" value="${course.div_code}">
								</div>
								<div>
								<label for="dc_class">dc_class</label>
									<br/>
									<input type="hidden" name="dc_class" value="${course.dc_class}">
								</div>
								-->
											<div>
												<label for="class_sche">課表內容</label> <br />
												<textarea name="class_sche" id="course_manageU41" rows="10"
													cols="80">
										${course.class_sche}
								</textarea>
												<script>
													CKEDITOR.replace(
															'course_manageU41',
															{
																width : 700,
															});
												</script>
											</div>
											<br />
											<!-- <button type="submit" class="btn btn-primary">修改</button> -->
										</form>
									</c:forEach>
								</div>
							</div>
							<div class="tab-pane fade in" id="sample-2h">
								<div class="course">
									<c:forEach items="${courseListM1}" var="course">
										<form method="post" action="updateCourse" id="updateForm">
											<div>
												<input type="hidden" name="dc_code"
													value="${course.dc_code}">
											</div>
											<!-- 
								<div>
									<label for="div_code">div_code</label>
									<br/>
									<input type="hidden" name="div_code" value="${course.div_code}">
								</div>
								<div>
								<label for="dc_class">dc_class</label>
									<br/>
									<input type="hidden" name="dc_class" value="${course.dc_class}">
								</div>
								-->
											<div>
												<label for="class_sche">課表內容</label> <br />
												<textarea name="class_sche" id="course_manageM1" rows="10"
													cols="80">
										${course.class_sche}
								</textarea>
												<script>
													CKEDITOR.replace(
															'course_manageM1',
															{
																width : 700,
															});
												</script>
											</div>
											<br />
											<!-- <button type="submit" class="btn btn-primary">修改</button> -->
										</form>
									</c:forEach>
								</div>
							</div>
							<div class="tab-pane fade in" id="sample-2i">
								<div class="course">
									<c:forEach items="${courseListE1}" var="course">
										<form method="post" action="updateCourse" id="updateForm">
											<div>
												<input type="hidden" name="dc_code"
													value="${course.dc_code}">
											</div>
											<!-- 
								<div>
									<label for="div_code">div_code</label>
									<br/>
									<input type="hidden" name="div_code" value="${course.div_code}">
								</div>
								<div>
								<label for="dc_class">dc_class</label>
									<br/>
									<input type="hidden" name="dc_class" value="${course.dc_class}">
								</div>
								-->
											<div>
												<label for="class_sche">課表內容</label> <br />
												<textarea name="class_sche" id="course_manageE1" rows="10"
													cols="80">
										${course.class_sche}
								</textarea>
												<script>
													CKEDITOR.replace(
															'course_manageE1',
															{
																width : 700,
															});
												</script>
											</div>
											<br />
											<!-- <button type="submit" class="btn btn-primary">修改</button> -->
										</form>
									</c:forEach>
								</div>
							</div>
						</div>
					</div>
				</div>
				<!-- End Tab v2 -->
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
