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

		<div class="row margin-vert-30">
			<div class="col-md-12">
				<h2>教師管理</h2>
				<div class="row margin-top-20">
					<div class="tabs">
						<ul class="nav nav-tabs">
							<li class="active"><a href="#proTeacherManage"
								data-toggle="tab">專任教師管理</a></li>
							<li class=""><a href="#partTeacherManage" data-toggle="tab">兼任教師管理</a></li>
							<li class=""><a href="#newTeacher" data-toggle="tab">新增教師</a></li>
						</ul>
						<div class="tab-content">
							<div class="tab-pane fade active in" id="proTeacherManage">
								<div class="col-md-12">
									<a class="btn btn-default" href="rankTeacherList?type=T">更改前端顯示順序</a>

									<div class="row margin-top-20"></div>

									<form id="searchProForm" action="searchPro" method="post">
										<table width="60%">
											<tr>
												<td><select class="form-control" name="key"
													id="ProSelection"
													onChange="checkSelection(this.selectedIndex)">
														<option value="teacher.TEA_LDAP">按照LDAP查找</option>
														<option value="teacher.TEA_CODE">按照教師編號查找</option>
														<option value="members.M_NAME">按照教師姓名查找</option>
														<option value="teacher.TEA_EN_NAME">按照英文姓名查找</option>
														<option value="class_post.POST_CODE">按照職稱查找</option>
														<option value="members.M_PHONE">按照聯絡電話查找</option>
														<option value="members.M_EMAIL">按照Email查找</option>
														<option value="teacher.Location">按照辦公地址查找</option>
												</select></td>
												<td><input type="text" name="value"
													class="form-control" id="proTextArea"> <select
													class="form-control" name="disabled" id="proPosSelection"
													style="display: none;">
														<option value="DA">教授兼系主任</option>
														<option value="DD">副教授兼系主任</option>
														<option value="DT">教授</option>
														<option value="DQ">副教授</option>
														<option value="DR">助理教授</option>
														<option value="DS">講師</option>
														<option value="DZ">離校</option>
												</select></td>
												<td><button type="submit" class="btn btn-default">搜索</button>
												</td>
											</tr>
										</table>
									</form>

									<div class="row margin-top-20"></div>

									<table class="table table-hover" width="100%">
										<tr>
											<th>教師編號</th>
											<th>姓名</th>
											<th>姓名英文</th>
											<th>職稱</th>
											<th>聯絡電話</th>
											<th>郵箱</th>
											<th>辦公地址</th>
											<th>是否顯示</th>
											<th>查看詳情</th>
											<th>編輯</th>
										</tr>
										<c:forEach items="${proTeacherList}" var="proTeacherList">
											<tr>
												<td>${proTeacherList.teaCode}</td>
												<td>${proTeacherList.teaName}</td>
												<td>${proTeacherList.teaENName}</td>
												<td>${proTeacherList.teaPos}</td>
												<td>${proTeacherList.teaTel}</td>
												<td>${proTeacherList.teaEmail}</td>
												<td>${proTeacherList.teaLoc}</td>
												<td><form id="changeViewForm" action="changeView"
														method="post">
														<div class="form-group">
															<select class="form-control" name="teaAble">
																<option value="1"
																	${proTieacherList.teaAble=="1"?'selected':''}>顯示</option>
																<option value="0"
																	${proTeacherList.teaAble=="0"?'selected':''}>不顯示</option>
															</select> <input type="hidden" name="teaLDAP" id="teaLDAP"
																value="${proTeacherList.teaLDAP }">
															<button type="submit" class="btn btn-primary">確定</button>
														</div>
													</form></td>
												<td><a class="btn btn-default"
													href="updateTeacherDetail?teaCode=${proTeacherList.teaCode}">查看詳情</a></td>
												<td><a class="btn btn-default"
													href="updateTeacherInfo?teaCode=${proTeacherList.teaCode}">修改</a>
													<a class="btn btn-danger deleteBtn" href="#"
													data-toggle="modal" data-target="#deleteTeacherInfo"
													data-code="${proTeacherList.teaCode}">離校</a></td>
											</tr>
										</c:forEach>
									</table>
								</div>
								<div class="clearfix"></div>
							</div>

							<div class="tab-pane fade" id="partTeacherManage">
								<div class="col-md-12">
									<a class="btn btn-default" href="rankTeacherList?type=B">更改前端顯示順序</a>

									<div class="row margin-top-20"></div>

									<form id="searchPartForm" action="searchPart" method="post">
										<table width="60%">
											<tr>
												<td><select class="form-control" name="key"
													id="PartSelection"
													onChange="checkSelection2(this.selectedIndex)">
														<option value="teacher.TEA_LDAP">按照LDAP查找</option>
														<option value="teacher.TEA_CODE">按照教師編號查找</option>
														<option value="members.M_NAME">按照教師姓名查找</option>
														<option value="teacher.TEA_EN_NAME">按照英文姓名查找</option>
														<option value="class_post.POST_CODE">按照職稱查找</option>
														<option value="members.M_PHONE">按照聯絡電話查找</option>
														<option value="members.M_EMAIL">按照Email查找</option>
														<option value="teacher.Location">按照辦公地址查找</option>
												</select></td>
												<td><input type="text" name="value"
													class="form-control" id="partTextArea"> <select
													class="form-control" name="disabled" id="partPosSelection"
													style="display: none;">
														<option value="DT">教授</option>
														<option value="DQ">副教授</option>
														<option value="DR">助理教授</option>
														<option value="DS">講師</option>
														<option value="DZ">離校</option>
												</select></td>
												<td><button type="submit" class="btn btn-default">搜索</button>
												</td>
											</tr>
										</table>
									</form>

									<div class="row margin-top-20"></div>

									<table class="table table-hover" width="100%">
										<tr>
											<th>教師編號</th>
											<th>姓名</th>
											<th>姓名英文</th>
											<th>職稱</th>
											<th>聯絡電話</th>
											<th>郵箱</th>
											<th>辦公地址</th>
											<th>是否顯示</th>
											<th>查看詳情</th>
											<th>編輯</th>
										</tr>
										<c:forEach items="${partTeacherList}" var="partTeacherList">
											<tr>
												<td>${partTeacherList.teaCode}</td>
												<td>${partTeacherList.teaName}</td>
												<td>${partTeacherList.teaENName}</td>
												<td>${partTeacherList.teaPos}</td>
												<td>${partTeacherList.teaTel}</td>
												<td>${partTeacherList.teaEmail}</td>
												<td>${partTeacherList.teaLoc}</td>
												<td><form id="changeViewForm" action="changeView"
														method="post">
														<div class="form-group">
															<select class="form-control" name="teaAble">
																<option value="0"
																	${partTeacherList.teaAble=="0"?'selected':''}>不顯示</option>
																<option value="1"
																	${partTeacherList.teaAble=="1"?'selected':''}>顯示</option>
															</select> <input type="hidden" name="teaLDAP" id="teaLDAP"
																value="${partTeacherList.teaLDAP }">
															<button class="btn btn-primary">確定</button>
														</div>
													</form></td>
												<td><a class="btn btn-default"
													href="updateTeacherDetail?teaCode=${partTeacherList.teaCode}">查看詳情</a></td>
												<td><a class="btn btn-default"
													href="updateTeacherInfo?teaCode=${partTeacherList.teaCode}">修改</a>
													<a class="btn btn-danger deleteBtn" href="#"
													data-toggle="modal" data-target="#deleteTeacherInfo"
													data-code="${partTeacherList.teaCode}">離校</a></td>
											</tr>
										</c:forEach>
									</table>
								</div>
								<div class="clearfix"></div>
							</div>

							<div class="tab-pane fade" id="newTeacher">
								<div class="col-md-6 col-md-offset-3 col-sm-offset-3">
									<form method="post" action="newTeacherBasicInfo"
										id="newTeacherForm" class="signup-page"
										enctype="multipart/form-data">
										<input type="hidden" name="teaCode" value=""><input
											type="hidden" name="teaSort" value="">

										<div class="form-group">
											<label>教師圖片<span class="color-red">*</span></label> <input
												type="file" name="file" accept="image/*" required /> <span
												class="color-red margin-buttom-20">請上傳英文名的圖片</span>
										</div>

										<div class="form-group">
											<label>LDAP<span class="color-red">*</span></label> <input
												type="text" name="teaLDAP" value=""
												class="form-control margin-buttom-20" required>
										</div>

										<div class="form-group">
											<label>姓名<span class="color-red">*</span></label> <input
												type="text" name="teaName" value=""
												class="form-control margin-buttom-20" required>
										</div>

										<div class="form-group">
											<label>姓名英文<span class="color-red">*</span></label> <input
												type="text" name="teaENName" value=""
												class="form-control margin-buttom-20" required>
										</div>

										<div class="form-group">
											<label for="category">教師類型<span class="color-red">*</span></label>
											<select class="form-control" name="teaType">
												<option value="T">專職教師</option>
												<option value="B">兼任教師</option>
											</select>
										</div>

										<div class="form-group">
											<label for="category">職稱<span class="color-red">*</span></label>
											<select class="form-control" name="teaPos">
												<option value="DA">教授兼系主任</option>
												<option value="DD">副教授兼系主任</option>
												<option value="DT">教授</option>
												<option value="DQ">副教授</option>
												<option value="DR">助理教授</option>
												<option value="DS">講師</option>
												<option value="DZ">離校</option>
											</select>
										</div>

										<div class="form-group">
											<label>联系电话<span class="color-red">*</span></label> <input
												type="text" name="teaTel" value=""
												class="form-control margin-buttom-20" required>
										</div>

										<div class="form-group">
											<label>E-mail<span class="color-red">*</span></label> <input
												type="text" name="teaEmail" value=""
												class="form-control margin-buttom-20" required>
										</div>

										<div class="form-group">
											<label>办公地址<span class="color-red">*</span></label> <input
												type="text" name="teaLoc" value=""
												class="form-control margin-buttom-20" required>
										</div>

										<div class="form-group">
											<label for="category">是否顯示</label> <select
												class="form-control" name="teaAble">
												<option value="0">不顯示</option>
												<option value="1">顯示</option>
											</select>
										</div>

										<button type="submit" class="btn btn-primary">新增</button>
									</form>
								</div>
								<div class="clearfix"></div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

		<div class="modal fade bs-example-modal-sm" id="deleteTeacherInfo"
			tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
			aria-hidden="true">
			<div class="modal-dialog modal-sm">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title" id="myModalLabel">教師離校</h4>
					</div>
					<div class="modal-body">
						<p>確認離職後，本教師的信息將不再顯示在前端</p>
					</div>
					<div class="modal-footer">
						<form id="deleteForm" action="deleteTeacherInfo" method="post">
							<input type="hidden" name="teaCode" id="teaCode">
							<button type="button" class="btn btn-default"
								data-dismiss="modal">取消</button>
							<button type="submit" class="btn btn-danger">確認</button>
						</form>
					</div>
				</div>
			</div>
		</div>

	</div>

	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
	<script>
		$(function() {
			var message = "${message}";
			if (message != "") {
				alert(message);
			}
		})
	</script>
	<script>
		$(function() {
			$(".deleteBtn").click(function() {
				//alert($(this).attr("data-id"));
				$("#teaCode").val($(this).attr("data-code"));
			});
		});
	</script>
	<script>
		$("#changeViewForm").validate();
	</script>
	<script>
		$("#newTeacherForm").validate();
	</script>
	<script>
		$("#searchProForm").validate();
	</script>
	<script>
		$("#searchPartForm").validate();
	</script>
	<script>
		function checkSelection(x) {
			if (x == 4) {
				$("#proTextArea").hide();
				$("#proPosSelection").show();
				$("#proPosSelection").attr("name", "value");
				$("#proTextArea").attr("name", "disabled");
			} else {
				$("#proTextArea").show();
				$("#proPosSelection").hide();
				$("#proPosSelection").attr("name", "disabled");
				$("#proTextArea").attr("name", "value");
			}
		}
	</script>
	<script>
		function checkSelection2(x) {
			if (x == 4) {
				$("#partTextArea").hide();
				$("#partPosSelection").show();
				$("#partPosSelection").attr("name", "value");
				$("#partTextArea").attr("name", "disabled");
			} else {
				$("#partTextArea").show();
				$("#partPosSelection").hide();
				$("#partPosSelection").attr("name", "disabled");
				$("#partTextArea").attr("name", "value");
			}
		}
	</script>
</body>

<!-- JS -->
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/scripts.js"></script>
<script type="text/javascript" src="js/jquery.validate.js"></script>
<script type="text/javascript" src="js/additional-methods.js"></script>
<script type="text/javascript" src="js/messages_zh_TW.js"></script>
<!-- Isotope - Portfolio Sorting -->
<script type="text/javascript" src="js/jquery.isotope.js"></script>
<!-- Mobile Menu - Slicknav -->
<script type="text/javascript" src="js/jquery.slicknav.js"></script>
<!-- Animate on Scroll-->
<script type="text/javascript" src="js/jquery.visible.js"
	charset="utf-8"></script>
<!-- Slimbox2-->
<script type="text/javascript" src="js/slimbox2.js" charset="utf-8"></script>
<!-- Modernizr -->
<script src="js/modernizr.custom.js" type="text/javascript"></script>
<!-- End JS -->

</html>


