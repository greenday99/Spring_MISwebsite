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
<title>教學成果管理- 畢業論文</title>
</head>

<body>
	<%@include file="jspf/adminNavbar.jspf"%>
	<div id="content" class="container">
		<div class="row margin-top-10"></div>
		<!-- 用于控制与navbar间距 -->

		<div class="container">


			<div class="row">
				<br>
				<%@include file="jspf/adminSidebar.jsp"%>
				<div class="col-md-9">
					<a class="btn btn-primary" href="insertTea_stu_paper">新增文章</a>
					<div class="row margin-top-10"></div>

					<table class="table" width="60%">
						<tr>
							<td width="20%"><select class="form-control"
								name="masterSelect" id="masterSelection"
								onChange="selectMasterCategory()">
									<option value="0">請選擇部別</option>
									<c:forEach items="${masterCategory}" var="masterCategory">
										<option value="${masterCategory.dcCode}">${masterCategory.dcClass}</option>
									</c:forEach>
							</select></td>
							<td width="30%"><select class="form-control"
								name="EmasterYearSelect" id="EmasterYearSelection"
								onChange="EmasterSelectyear()" style="display: none;">
									<option value="0">請選擇年度</option>
									<c:forEach items="${eMasterYear}" var="eMasterYear">
										<option value="${eMasterYear}">${eMasterYear}</option>
									</c:forEach>
							</select> <select class="form-control" name="masterYearSelect"
								id="masterYearSelection" onChange="masterSelectyear()"
								style="display: none;">
									<option value="0">請選擇年度</option>
									<c:forEach items="${masterYear}" var="masterYear">
										<option value="${masterYear}">${masterYear}</option>
									</c:forEach>
							</select></td>
						</tr>
					</table>

					<table class="table">
						<tr>
							<th>編號</th>
							<th>題目</th>
							<th>指導老師</th>
							<th>學生</th>
						</tr>

						<tbody id="masterPaperDetail">
							<c:forEach items="${masterPaperList}" var="masterPaperList">
								<tr class="category_year${masterPaperList.gra_year}"
									style="display: none;">
									<td>${masterPaperList.gra_code}</td>
									<td>${masterPaperList.gra_title}</td>
									<td>${masterPaperList.gra_teacher}</td>
									<td>${masterPaperList.gra_student}</td>
									<td><a class="btn btn-default"
										href="updateTea_stu_paper?paperid=${masterPaperList.gra_code}">修改</a>
										<a class="btn btn-sm btn-danger deleteBtn"
										href="deleteTea_stu_paper?paperid=${masterPaperList.gra_code}">刪除</a>
									</td>
								</tr>
							</c:forEach>
						</tbody>

						<tbody id="eMasterPaperDetail">
							<c:forEach items="${eMasterPaperList}" var="eMasterPaperList">
								<tr class="category_year${eMasterPaperList.gra_year}"
									style="display: none;">
									<td>${eMasterPaperList.gra_code}</td>
									<td>${eMasterPaperList.gra_title}</td>
									<td>${eMasterPaperList.gra_teacher}</td>
									<td>${eMasterPaperList.gra_student}</td>
									<td><a class="btn btn-default"
										href="updateTea_stu_paper?paperid=${eMasterPaperList.gra_code}">修改</a>
										<a class="btn btn-sm btn-danger deleteBtn"
										href="deleteTea_stu_paper?paperid=${eMasterPaperList.gra_code}">刪除</a>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>

				</div>
			</div>
		</div>
</body>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script>
	function selectMasterCategory() {
		var id = $("#masterSelection").val();
		//alert(id);
		if (id == "0") {
			$("#EmasterYearSelection").hide();
			$("#masterYearSelection").hide();
			$("#masterPaperDetail").children().hide();
			$("#eMasterPaperDetail").children().hide();
		}
		if (id == "E1") {
			$("#masterYearSelection").hide();
			$("#EmasterYearSelection").show();
		}
		if (id == "M1") {
			$("#EmasterYearSelection").hide();
			$("#masterYearSelection").show();
		}
	}
	function EmasterSelectyear() {
		var year = $("#EmasterYearSelection").val();
		$("#masterPaperDetail").children().hide();
		$("#eMasterPaperDetail").children().hide();
		if (year != 0) {
			$("#eMasterPaperDetail .category_year" + year).show();
		}
	}
	function masterSelectyear() {
		var year = $("#masterYearSelection").val();
		$("#masterPaperDetail").children().hide();
		$("#eMasterPaperDetail").children().hide();
		if (year != 0) {
			$("#masterPaperDetail .category_year" + year).show();
		}
	}
</script>
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