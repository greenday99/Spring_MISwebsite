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
<title>輔仁大學資訊管理學系管理后台</title>

</head>
<body>
	<%@include file="jspf/adminNavbar.jspf"%>

	<div id="content" class="container">
		<div class="row margin-top-30"></div>
		<div class="col-md-6 col-md-offset-3 col-sm-offset-3">
			<div class="panel panel-primary">
				<div class="panel-heading">
					<h3 class="panel-title">
						更改前端顯示順序 <a href="teacherManage" class="btn btn-warning">取消修改</a>
					</h3>

				</div>
				<div class="panel-body">
					<!--  method="post" action="changeTeacherRank" id="changeTeacherRankForm" -->
					<form>
						<table class="table table-hover" width="100%">
							<c:forEach items="${info}" var="info">
								<tr>
									<td><input type="hidden" name="teaSort" id="teaSort"
										value="${info.teaSort }"> <input type="hidden"
										name="teaCode" id="teaCode" value="${info.teaCode }">
										${info.teaName }</td>
									<td>${info.teaPos }</td>
									<td><button type="button" class="btn btn-default"
											value="up">上移</button></td>
									<td><button type="button" class="btn btn-default"
											value="down">下移</button></td>
								</tr>
							</c:forEach>
						</table>
						<button type="button" class="btn btn-info">確認修改</button>
					</form>
				</div>
			</div>

		</div>

	</div>

	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
	<script>
		$(".btn-info").click(
				function() {
					var size = $("tr").length;
					var j = 0;
					var data = [];
					//var data = '[ ';
					$.each($("input:hidden[name='teaSort']"),
							function(i, val) {
								var data_row = {};
								data_row.teaSort = val.value;
								data_row.teaCode = $("input:hidden[name='teaCode']").eq(i).val();
								data.push(data_row);
								/* j = j + 1;
								var teaSort = val.value;
								var teaCode = $("input:hidden[name='teaCode']")
										.eq(i).val();
								data = data + '{"teaSort": "' + teaSort
										+ '", "teaCode": "' + teaCode + '"} ';
								if (j < size) {
									data = data + ",";
								}
								if (j == size) {
									data = data + "]";
								} */
							});
					
					var rank = JSON.stringify(data);
					//alert(rank);
					$.ajax({
						URL : "/rankTeacherList",
						//大小寫url有差
						type : "POST",
						contentType : "application/json",
						data : rank,

						success : function(result) {
							alert("修改成功！")
							$("body").html(result);
						}
					});
				});
	</script>
	<script>
		$(function() {
			$(".btn-default").click(function() {
				var $tr = $(this).parents("tr");
				var $move = $(this).val();
				if ($move == "up") {
					if ($tr.index() != 0) {
						$tr.fadeOut().fadeIn();
						$tr.prev().before($tr).fadeOut().fadeIn();
						var i = $tr.find("#teaSort").val();
						var j = $tr.next().find("#teaSort").val();
						$tr.find("#teaSort").val(j);
						$tr.next().find("#teaSort").val(i);
					}
				}
				if ($move == "down") {
					if ($tr.index() != $("#down").length - 1) {
						$tr.fadeOut().fadeIn();
						$tr.next().after($tr).fadeOut().fadeIn();
						var i = $tr.find("#teaSort").val();
						var j = $tr.prev().find("#teaSort").val();
						$tr.find("#teaSort").val(j);
						$tr.prev().find("#teaSort").val(i);
					}
				}
			});
		});
	</script>

</body>
<!-- JS -->
<script type="text/javascript" src="js/jquery.min.js">
	
</script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/scripts.js"></script>
<script type="text/javascript" src="js/jquery.validate.js"></script>
<script type="text/javascript" src="js/additional-methods.js"></script>
<script type="text/javascript" src="js/messages_zh_TW.js"></script>
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


