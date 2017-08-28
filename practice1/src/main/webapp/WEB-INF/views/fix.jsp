<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="en">
<head>
<!-- Title -->
<title>fix</title>
<!-- Meta -->
<meta http-equiv="content-type" content="text/html; charset=UTF-8" />
<meta name="description" content="">
<meta name="author" content="">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1" />
<!-- Favicon -->
<link href="favicon.html" rel="shortcut icon">
<!-- Bootstrap Core CSS -->
<link rel="stylesheet" href="css/bootstrap.css" rel="stylesheet">
<!-- Template CSS -->
<link rel="stylesheet" href="css/animate.css" rel="stylesheet">
<link rel="stylesheet" href="css/font-awesome.css" rel="stylesheet">
<link rel="stylesheet" href="css/nexus.css" rel="stylesheet">
<link rel="stylesheet" href="css/responsive.css" rel="stylesheet">
<link rel="stylesheet" href="css/custom.css" rel="stylesheet">
<!-- Google Fonts-->
<link href="http://fonts.googleapis.com/css?family=Lato:400,300"
	rel="stylesheet" type="text/css">
<link href="http://fonts.googleapis.com/css?family=Open+Sans:400,300"
	rel="stylesheet" type="text/css">
<!-- CKEditor -->
<script src="//cdn.ckeditor.com/4.5.7/standard/ckeditor.js"></script>
</head>

<body>
	<%@include file="jspf/adminNavbar.jspf"%>



	<div class="container">

		<!-- 選擇所選擇的 -->
		<label>選擇:</label>
		<form>
			<select name="YourCategory" class="categorySelect">
				<option value="0">請選擇</option>
				<c:forEach items="${getDeptIntro}" var="getDeptIntro">
					<option value="${getDeptIntro.di_code}">${getDeptIntro.di_name}</option>
				</c:forEach>
			</select>
		</form>

		<div class="row">
			<br /> <br />
			<br />
			<div class="col-md-12">
				<table class="table">
					<tr>
						<th>欄位編號</th>
						<th>欄位名稱</th>
						<th>頁簽編號</th>
						<th>頁簽名稱</th>
						<th>內容</th>
						<th>刪除</th>
						<th>修改</th>
						<!--  <th>新增</th>-->
					</tr>

					<!-- 顯示所選擇的 -->
					<tbody id="testt">

						<c:forEach items="${getAll}" var="getAll">
							<tr class="category_${getAll.di_code} trrr" style="display: none">
								<td>${getAll.di_code}</td>
								<td>${getAll.di_name}</td>
								<td>${getAll.dic_code}</td>
								<td>${getAll.dic_name}</td>
								<td>${getAll.dic_cont}</td>
								<td><a class="btn btn-sm btn-danger deleteBtn" href="#"
									data-toggle="modal" data-target="#deleteModal"
									data-id="${getAll.di_code}" data-idc="${getAll.dic_code}">刪除</a>
								</td>
								<td><a class="btn btn-default"
									href="updatedeptintro?di_code=${getAll.di_code}&dic_code=${getAll.dic_code}">修改</a>
								</td>

								<c:set var="di_code" value="${getAll.di_code}" />
								<c:set var="dic_code" value="${getAll.dic_code}" />
								<c:choose>
									<c:when test="${di_code == 2}">
										<td><a class="btn btn-primary"
											href="uploadfile?di_code=${getAll.di_code}&dic_code=${getAll.dic_code}">新增</a>
										</td>
									</c:when>
									<c:when test="${di_code == 5 && dic_code == 2}">
										<td><a class="btn btn-primary"
											href="uploadfile?di_code=${getAll.di_code}&dic_code=${getAll.dic_code}">新增</a>
										</td>
									</c:when>
								</c:choose>
							</tr>
						</c:forEach>
					</tbody>

				</table>
			</div>
		</div>


	</div>
	<div class="modal fade bs-example-modal-sm" id="deleteModal"
		tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
		aria-hidden="true">
		<div class="modal-dialog modal-sm">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">刪除文章</h4>
				</div>
				<div class="modal-body">
					<p>確認刪除後，相關之訊息也將刪除</p>
				</div>
				<div class="modal-footer">
					<form id="deleteForm" action="deletedeptintro" method="post">
						<input type="hidden" name="di_code" id="di_code"> <input
							type="hidden" name="dic_code" id="dic_code">
						<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
						<button type="submit" class="btn btn-danger">確認刪除</button>
					</form>
				</div>
			</div>
		</div>
	</div>




	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script>
		$(function() {
			$(".deleteBtn").click(function() {
				//alert($(this).attr("data-id"));
				$("#di_code").val($(this).attr("data-id"));
				$("#dic_code").val($(this).attr("data-idc"));
			});

			$(".categorySelect").change(function() {
				var id = $(this).val();
				$("#testt").children().hide();
				if (id != 0) {
					$(".category_" + id).show();
				} else {
					$(".trrr").show();
				}
			});
		});
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


</body>
</html>