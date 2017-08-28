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
<title>教學成果 - 畢業專題</title>
</head>

<body>
	<%@include file="jspf/MISwebsiteNavbar.jspf"%>
	<div id="content" class="container">
		<div class="row margin-top-10"></div>
		<!-- 用于控制与navbar间距 -->

		<div class="container">


			<div class="row">
				<br>
				<%@include file="jspf/Sidebar-teachResult.jspf"%>
				<div class="col-md-9">

					<table class="table">

						<tr>
							<th>編號</th>
							<th>題目</th>
							<th width="11%">指導老師</th>
							<th>學生</th>
						</tr>


						<tr>

							<td width="14%"><select class="form-control" name="GRA_YEAR"
								id="yearSelection" onChange="selectYear()">
									<option value="0">年份</option>
									<c:forEach items="${graYearList}" var="graYearList">
										<option value="${graYearList}">${graYearList}</option>
									</c:forEach>
							</select></td>
							<td></td>
							<td></td>
						</tr>

						<tbody id="detailBody">
							<c:forEach items="${graduationList}" var="graduationList">
								<tr class="category_${graduationList.gra_year}"
									style="display: none;">
									<td>${graduationList.gra_code}</td>
									<td>${graduationList.gra_title}</td>
									<td>${graduationList.gra_teacher}</td>
									<td>${graduationList.gra_student}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>

		<div class="row margin-top-10"></div>
		<!-- 用于控制与footer间距 -->
	</div>

	<%@include file="jspf/MISwebsiteFooter.jspf"%>

</body>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>

<script>
	function selectYear() {
		var year = $("#yearSelection").val();
		//alert(year);
		$("#detailBody").children().hide();
		if (year != 0) {
			$(".category_" + year).show();
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