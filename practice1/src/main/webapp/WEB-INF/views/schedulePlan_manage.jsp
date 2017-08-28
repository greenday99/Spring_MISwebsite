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
<link rel="stylesheet" href="css/scheduleplan.css" rel="stylesheet">
<!-- Google Fonts -->
<link href="http://fonts.googleapis.com/css?family=Lato:400,300"
	rel="stylesheet" type="text/css">
<link href="http://fonts.googleapis.com/css?family=Open+Sans:400,300"
	rel="stylesheet" type="text/css">

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
</head>
<body>
	<%@include file="jspf/adminNavbar.jspf"%>
	<!-- === BEGIN CONTENT === -->
	<div id="content" class="container">
		<div class="row margin-vert-30">
			<!-- End Sidebar Menu -->
			<div class="col-md-12">
				<h2>課程規劃</h2>
				<div class="row margin-top-20">
					<!-- Tab v2 -->
					<div class="tabs alternative">
						<ul class="nav nav-tabs">
							<li class="active"><a href="#sample-2a" data-toggle="tab">大學部</a></li>
							<li><a href="#sample-2b" data-toggle="tab">碩士班</a></li>
							<li><a href="#sample-2c" data-toggle="tab">在職專班</a></li>
							<li><a href="#sample-2d" data-toggle="tab">雙主修</a></li>
							<li><a href="#sample-2e" data-toggle="tab">輔系</a></li>
						</ul>
						<div class="tab-content">
							<div class="tab-pane fade in active" id="sample-2a">
								<div class="sceduleplan_manage">
									<!-- class table -->
									<table>
										<thead>
											<tr>
												<th>ID</th>
												<th>學年度</th>
												<th>學期</th>
												<th>檔案類型</th>
												<th>下載</th>
												<th>修改</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach items="${scheduleplanListU}" var="scheduleplan">
												<tr class="scheduleplan_${scheduleplan.year%10}">
													<form method="post" action="updateScheduleplan"
														id="updateForm">
														<c:if test="${scheduleplan.year == '0'}">
															<td data-column="ID"><input type="text"
																name="scheduleplanid"
																value="${scheduleplan.scheduleplanid}" size="2" readonly>
															</td>

															<td data-column="學年度"><input type="text" name="year"
																value="${scheduleplan.year}" size="2"></td>

															<td data-column="學期"><select name="semester">
																	<c:choose>
																		<c:when test="${scheduleplan.semester == '1'}">
																			<option value="0">--</option>
																			<option value="1" SELECTED>上</option>
																			<option value="2">下</option>
																		</c:when>
																		<c:when test="${scheduleplan.semester == '2'}">
																			<option value="0">--</option>
																			<option value="1">上</option>
																			<option value="2" SELECTED>下</option>
																		</c:when>
																		<c:otherwise>
																			<option value="0" SELECTED>--</option>
																			<option value="1">上</option>
																			<option value="2">下</option>
																		</c:otherwise>
																	</c:choose>
															</select></td>

															<td data-column="檔案類型" style="text-align: center;">
																<select name="plan_code">
																	<c:forEach items="${planList}" var="plan">
																		<c:choose>
																			<c:when
																				test="${plan.plan_code == scheduleplan.plan_code}">
																				<option value="${plan.plan_code}" SELECTED>${plan.plan_name}</option>
																			</c:when>
																			<c:otherwise>
																				<option value="${plan.plan_code}">${plan.plan_name}</option>
																			</c:otherwise>
																		</c:choose>
																	</c:forEach>
															</select>
															</td>

															<td data-column="下載"><input type="text"
																name="sche_cont" value="${scheduleplan.sche_cont}"
																size="36"></td>
															<td data-column="修改"><input type="submit" value="送出">
															</td>
														</c:if>
													</form>
												</tr>
											</c:forEach>

											<c:forEach items="${scheduleplanListU}" var="scheduleplan">
												<tr class="scheduleplan_${scheduleplan.year%10}">
													<form method="post" action="updateScheduleplan"
														id="updateForm">
														<c:if test="${scheduleplan.year != '0'}">
															<td data-column="ID"><input type="text"
																name="scheduleplanid"
																value="${scheduleplan.scheduleplanid}" size="2" readonly>
															</td>

															<td data-column="學年度"><input type="text" name="year"
																value="${scheduleplan.year}" size="2">
															<td data-column="學期"><select name="semester">
																	<c:choose>
																		<c:when test="${scheduleplan.semester == '1'}">
																			<option value="0">--</option>
																			<option value="1" SELECTED>上</option>
																			<option value="2">下</option>
																		</c:when>
																		<c:when test="${scheduleplan.semester == '2'}">
																			<option value="0">--</option>
																			<option value="1">上</option>
																			<option value="2" SELECTED>下</option>
																		</c:when>
																		<c:otherwise>
																			<option value="0" SELECTED>--</option>
																			<option value="1">上</option>
																			<option value="2">下</option>
																		</c:otherwise>
																	</c:choose>
															</select></td>

															<td data-column="檔案類型" style="text-align: center;">
																<select name="plan_code">
																	<c:forEach items="${planList}" var="plan">
																		<c:choose>
																			<c:when
																				test="${plan.plan_code == scheduleplan.plan_code}">
																				<option value="${plan.plan_code}" SELECTED>${plan.plan_name}</option>
																			</c:when>
																			<c:otherwise>
																				<option value="${plan.plan_code}">${plan.plan_name}</option>
																			</c:otherwise>
																		</c:choose>
																	</c:forEach>
															</select>
															</td>

															<td data-column="下載"><input type="text"
																name="sche_cont" value="${scheduleplan.sche_cont}"
																size="36"></td>

															<td data-column="修改"><input type="submit" value="送出">
															</td>
														</c:if>
													</form>
												</tr>
											</c:forEach>
										</tbody>
									</table>
									<!-- END class table -->
								</div>
							</div>
							<div class="tab-pane fade in" id="sample-2b">
								<div class="sceduleplan_manage">
									<!-- class table -->
									<table>
										<thead>
											<tr>
												<th>ID</th>
												<th>學年度</th>
												<th>學期</th>
												<th>檔案類型</th>
												<th>下載</th>
												<th>修改</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach items="${scheduleplanListM}" var="scheduleplan">
												<tr class="scheduleplan_${scheduleplan.year%10}">
													<form method="post" action="updateScheduleplan"
														id="updateForm">
														<c:if test="${scheduleplan.year == '0'}">
															<td data-column="ID"><input type="text"
																name="scheduleplanid"
																value="${scheduleplan.scheduleplanid}" size="2" readonly>
															</td>

															<td data-column="學年度"><input type="text" name="year"
																value="${scheduleplan.year}" size="2"></td>

															<td data-column="學期"><select name="semester">
																	<c:choose>
																		<c:when test="${scheduleplan.semester == '1'}">
																			<option value="0">--</option>
																			<option value="1" SELECTED>上</option>
																			<option value="2">下</option>
																		</c:when>
																		<c:when test="${scheduleplan.semester == '2'}">
																			<option value="0">--</option>
																			<option value="1">上</option>
																			<option value="2" SELECTED>下</option>
																		</c:when>
																		<c:otherwise>
																			<option value="0" SELECTED>--</option>
																			<option value="1">上</option>
																			<option value="2">下</option>
																		</c:otherwise>
																	</c:choose>
															</select></td>

															<td data-column="檔案類型" style="text-align: center;">
																<select name="plan_code">
																	<c:forEach items="${planList}" var="plan">
																		<c:choose>
																			<c:when
																				test="${plan.plan_code == scheduleplan.plan_code}">
																				<option value="${plan.plan_code}" SELECTED>${plan.plan_name}</option>
																			</c:when>
																			<c:otherwise>
																				<option value="${plan.plan_code}">${plan.plan_name}</option>
																			</c:otherwise>
																		</c:choose>
																	</c:forEach>
															</select>
															</td>

															<td data-column="下載"><input type="text"
																name="sche_cont" value="${scheduleplan.sche_cont}"
																size="36"></td>
															<td data-column="修改"><input type="submit" value="送出">
															</td>
														</c:if>
													</form>
												</tr>
											</c:forEach>

											<c:forEach items="${scheduleplanListM}" var="scheduleplan">
												<tr class="scheduleplan_${scheduleplan.year%10}">
													<form method="post" action="updateScheduleplan"
														id="updateForm">
														<c:if test="${scheduleplan.year != '0'}">
															<td data-column="ID"><input type="text"
																name="scheduleplanid"
																value="${scheduleplan.scheduleplanid}" size="2" readonly>
															</td>

															<td data-column="學年度"><input type="text" name="year"
																value="${scheduleplan.year}" size="2">
															<td data-column="學期"><select name="semester">
																	<c:choose>
																		<c:when test="${scheduleplan.semester == '1'}">
																			<option value="0">--</option>
																			<option value="1" SELECTED>上</option>
																			<option value="2">下</option>
																		</c:when>
																		<c:when test="${scheduleplan.semester == '2'}">
																			<option value="0">--</option>
																			<option value="1">上</option>
																			<option value="2" SELECTED>下</option>
																		</c:when>
																		<c:otherwise>
																			<option value="0" SELECTED>--</option>
																			<option value="1">上</option>
																			<option value="2">下</option>
																		</c:otherwise>
																	</c:choose>
															</select></td>

															<td data-column="檔案類型" style="text-align: center;">
																<select name="plan_code">
																	<c:forEach items="${planList}" var="plan">
																		<c:choose>
																			<c:when
																				test="${plan.plan_code == scheduleplan.plan_code}">
																				<option value="${plan.plan_code}" SELECTED>${plan.plan_name}</option>
																			</c:when>
																			<c:otherwise>
																				<option value="${plan.plan_code}">${plan.plan_name}</option>
																			</c:otherwise>
																		</c:choose>
																	</c:forEach>
															</select>
															</td>

															<td data-column="下載"><input type="text"
																name="sche_cont" value="${scheduleplan.sche_cont}"
																size="36"></td>

															<td data-column="修改"><input type="submit" value="送出">
															</td>
														</c:if>
													</form>
												</tr>
											</c:forEach>
										</tbody>
									</table>
									<!-- END class table -->
								</div>
							</div>
							<div class="tab-pane fade in" id="sample-2c">
								<div class="sceduleplan_manage">
									<!-- class table -->
									<table>
										<thead>
											<tr>
												<th>ID</th>
												<th>學年度</th>
												<th>學期</th>
												<th>檔案類型</th>
												<th>下載</th>
												<th>修改</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach items="${scheduleplanListE}" var="scheduleplan">
												<tr class="scheduleplan_${scheduleplan.year%10}">
													<form method="post" action="updateScheduleplan"
														id="updateForm">
														<c:if test="${scheduleplan.year == '0'}">
															<td data-column="ID"><input type="text"
																name="scheduleplanid"
																value="${scheduleplan.scheduleplanid}" size="2" readonly>
															</td>

															<td data-column="學年度"><input type="text" name="year"
																value="${scheduleplan.year}" size="2"></td>

															<td data-column="學期"><select name="semester">
																	<c:choose>
																		<c:when test="${scheduleplan.semester == '1'}">
																			<option value="0">--</option>
																			<option value="1" SELECTED>上</option>
																			<option value="2">下</option>
																		</c:when>
																		<c:when test="${scheduleplan.semester == '2'}">
																			<option value="0">--</option>
																			<option value="1">上</option>
																			<option value="2" SELECTED>下</option>
																		</c:when>
																		<c:otherwise>
																			<option value="0" SELECTED>--</option>
																			<option value="1">上</option>
																			<option value="2">下</option>
																		</c:otherwise>
																	</c:choose>
															</select></td>

															<td data-column="檔案類型" style="text-align: center;">
																<select name="plan_code">
																	<c:forEach items="${planList}" var="plan">
																		<c:choose>
																			<c:when
																				test="${plan.plan_code == scheduleplan.plan_code}">
																				<option value="${plan.plan_code}" SELECTED>${plan.plan_name}</option>
																			</c:when>
																			<c:otherwise>
																				<option value="${plan.plan_code}">${plan.plan_name}</option>
																			</c:otherwise>
																		</c:choose>
																	</c:forEach>
															</select>
															</td>

															<td data-column="下載"><input type="text"
																name="sche_cont" value="${scheduleplan.sche_cont}"
																size="36"></td>
															<td data-column="修改"><input type="submit" value="送出">
															</td>
														</c:if>
													</form>
												</tr>
											</c:forEach>

											<c:forEach items="${scheduleplanListE}" var="scheduleplan">
												<tr class="scheduleplan_${scheduleplan.year%10}">
													<form method="post" action="updateScheduleplan"
														id="updateForm">
														<c:if test="${scheduleplan.year != '0'}">
															<td data-column="ID"><input type="text"
																name="scheduleplanid"
																value="${scheduleplan.scheduleplanid}" size="2" readonly>
															</td>

															<td data-column="學年度"><input type="text" name="year"
																value="${scheduleplan.year}" size="2">
															<td data-column="學期"><select name="semester">
																	<c:choose>
																		<c:when test="${scheduleplan.semester == '1'}">
																			<option value="0">--</option>
																			<option value="1" SELECTED>上</option>
																			<option value="2">下</option>
																		</c:when>
																		<c:when test="${scheduleplan.semester == '2'}">
																			<option value="0">--</option>
																			<option value="1">上</option>
																			<option value="2" SELECTED>下</option>
																		</c:when>
																		<c:otherwise>
																			<option value="0" SELECTED>--</option>
																			<option value="1">上</option>
																			<option value="2">下</option>
																		</c:otherwise>
																	</c:choose>
															</select></td>

															<td data-column="檔案類型" style="text-align: center;">
																<select name="plan_code">
																	<c:forEach items="${planList}" var="plan">
																		<c:choose>
																			<c:when
																				test="${plan.plan_code == scheduleplan.plan_code}">
																				<option value="${plan.plan_code}" SELECTED>${plan.plan_name}</option>
																			</c:when>
																			<c:otherwise>
																				<option value="${plan.plan_code}">${plan.plan_name}</option>
																			</c:otherwise>
																		</c:choose>
																	</c:forEach>
															</select>
															</td>

															<td data-column="下載"><input type="text"
																name="sche_cont" value="${scheduleplan.sche_cont}"
																size="36"></td>

															<td data-column="修改"><input type="submit" value="送出">
															</td>
														</c:if>
													</form>
												</tr>
											</c:forEach>
										</tbody>
									</table>
									<!-- END class table -->
								</div>
							</div>
							<div class="tab-pane fade in" id="sample-2d">
								<div class="sceduleplan_manage">
									<!-- class table -->
									<table>
										<thead>
											<tr>
												<th>ID</th>
												<th>學年度</th>
												<th>學期</th>
												<th>檔案類型</th>
												<th>下載</th>
												<th>修改</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach items="${scheduleplanListD}" var="scheduleplan">
												<tr class="scheduleplan_${scheduleplan.year%10}">
													<form method="post" action="updateScheduleplan"
														id="updateForm">
														<c:if test="${scheduleplan.year == '0'}">
															<td data-column="ID"><input type="text"
																name="scheduleplanid"
																value="${scheduleplan.scheduleplanid}" size="2" readonly>
															</td>

															<td data-column="學年度"><input type="text" name="year"
																value="${scheduleplan.year}" size="2"></td>

															<td data-column="學期"><select name="semester">
																	<c:choose>
																		<c:when test="${scheduleplan.semester == '1'}">
																			<option value="0">--</option>
																			<option value="1" SELECTED>上</option>
																			<option value="2">下</option>
																		</c:when>
																		<c:when test="${scheduleplan.semester == '2'}">
																			<option value="0">--</option>
																			<option value="1">上</option>
																			<option value="2" SELECTED>下</option>
																		</c:when>
																		<c:otherwise>
																			<option value="0" SELECTED>--</option>
																			<option value="1">上</option>
																			<option value="2">下</option>
																		</c:otherwise>
																	</c:choose>
															</select></td>

															<td data-column="檔案類型" style="text-align: center;">
																<select name="plan_code">
																	<c:forEach items="${planList}" var="plan">
																		<c:choose>
																			<c:when
																				test="${plan.plan_code == scheduleplan.plan_code}">
																				<option value="${plan.plan_code}" SELECTED>${plan.plan_name}</option>
																			</c:when>
																			<c:otherwise>
																				<option value="${plan.plan_code}">${plan.plan_name}</option>
																			</c:otherwise>
																		</c:choose>
																	</c:forEach>
															</select>
															</td>

															<td data-column="下載"><input type="text"
																name="sche_cont" value="${scheduleplan.sche_cont}"
																size="36"></td>
															<td data-column="修改"><input type="submit" value="送出">
															</td>
														</c:if>
													</form>
												</tr>
											</c:forEach>

											<c:forEach items="${scheduleplanListD}" var="scheduleplan">
												<tr class="scheduleplan_${scheduleplan.year%10}">
													<form method="post" action="updateScheduleplan"
														id="updateForm">
														<c:if test="${scheduleplan.year != '0'}">
															<td data-column="ID"><input type="text"
																name="scheduleplanid"
																value="${scheduleplan.scheduleplanid}" size="2" readonly>
															</td>

															<td data-column="學年度"><input type="text" name="year"
																value="${scheduleplan.year}" size="2">
															<td data-column="學期"><select name="semester">
																	<c:choose>
																		<c:when test="${scheduleplan.semester == '1'}">
																			<option value="0">--</option>
																			<option value="1" SELECTED>上</option>
																			<option value="2">下</option>
																		</c:when>
																		<c:when test="${scheduleplan.semester == '2'}">
																			<option value="0">--</option>
																			<option value="1">上</option>
																			<option value="2" SELECTED>下</option>
																		</c:when>
																		<c:otherwise>
																			<option value="0" SELECTED>--</option>
																			<option value="1">上</option>
																			<option value="2">下</option>
																		</c:otherwise>
																	</c:choose>
															</select></td>

															<td data-column="檔案類型" style="text-align: center;">
																<select name="plan_code">
																	<c:forEach items="${planList}" var="plan">
																		<c:choose>
																			<c:when
																				test="${plan.plan_code == scheduleplan.plan_code}">
																				<option value="${plan.plan_code}" SELECTED>${plan.plan_name}</option>
																			</c:when>
																			<c:otherwise>
																				<option value="${plan.plan_code}">${plan.plan_name}</option>
																			</c:otherwise>
																		</c:choose>
																	</c:forEach>
															</select>
															</td>

															<td data-column="下載"><input type="text"
																name="sche_cont" value="${scheduleplan.sche_cont}"
																size="36"></td>

															<td data-column="修改"><input type="submit" value="送出">
															</td>
														</c:if>
													</form>
												</tr>
											</c:forEach>
										</tbody>
									</table>
									<!-- END class table -->
								</div>
							</div>
							<div class="tab-pane fade in" id="sample-2e">
								<div class="sceduleplan_manage">
									<!-- class table -->
									<table>
										<thead>
											<tr>
												<th>ID</th>
												<th>學年度</th>
												<th>學期</th>
												<th>檔案類型</th>
												<th>下載</th>
												<th>修改</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach items="${scheduleplanListF}" var="scheduleplan">
												<tr class="scheduleplan_${scheduleplan.year%10}">
													<form method="post" action="updateScheduleplan"
														id="updateForm">
														<c:if test="${scheduleplan.year == '0'}">
															<td data-column="ID"><input type="text"
																name="scheduleplanid"
																value="${scheduleplan.scheduleplanid}" size="2" readonly>
															</td>

															<td data-column="學年度"><input type="text" name="year"
																value="${scheduleplan.year}" size="2"></td>

															<td data-column="學期"><select name="semester">
																	<c:choose>
																		<c:when test="${scheduleplan.semester == '1'}">
																			<option value="0">--</option>
																			<option value="1" SELECTED>上</option>
																			<option value="2">下</option>
																		</c:when>
																		<c:when test="${scheduleplan.semester == '2'}">
																			<option value="0">--</option>
																			<option value="1">上</option>
																			<option value="2" SELECTED>下</option>
																		</c:when>
																		<c:otherwise>
																			<option value="0" SELECTED>--</option>
																			<option value="1">上</option>
																			<option value="2">下</option>
																		</c:otherwise>
																	</c:choose>
															</select></td>

															<td data-column="檔案類型" style="text-align: center;">
																<select name="plan_code">
																	<c:forEach items="${planList}" var="plan">
																		<c:choose>
																			<c:when
																				test="${plan.plan_code == scheduleplan.plan_code}">
																				<option value="${plan.plan_code}" SELECTED>${plan.plan_name}</option>
																			</c:when>
																			<c:otherwise>
																				<option value="${plan.plan_code}">${plan.plan_name}</option>
																			</c:otherwise>
																		</c:choose>
																	</c:forEach>
															</select>
															</td>

															<td data-column="下載"><input type="text"
																name="sche_cont" value="${scheduleplan.sche_cont}"
																size="36"></td>
															<td data-column="修改"><input type="submit" value="送出">
															</td>
														</c:if>
													</form>
												</tr>
											</c:forEach>

											<c:forEach items="${scheduleplanListF}" var="scheduleplan">
												<tr class="scheduleplan_${scheduleplan.year%10}">
													<form method="post" action="updateScheduleplan"
														id="updateForm">
														<c:if test="${scheduleplan.year != '0'}">
															<td data-column="ID"><input type="text"
																name="scheduleplanid"
																value="${scheduleplan.scheduleplanid}" size="2" readonly>
															</td>

															<td data-column="學年度"><input type="text" name="year"
																value="${scheduleplan.year}" size="2">
															<td data-column="學期"><select name="semester">
																	<c:choose>
																		<c:when test="${scheduleplan.semester == '1'}">
																			<option value="0">--</option>
																			<option value="1" SELECTED>上</option>
																			<option value="2">下</option>
																		</c:when>
																		<c:when test="${scheduleplan.semester == '2'}">
																			<option value="0">--</option>
																			<option value="1">上</option>
																			<option value="2" SELECTED>下</option>
																		</c:when>
																		<c:otherwise>
																			<option value="0" SELECTED>--</option>
																			<option value="1">上</option>
																			<option value="2">下</option>
																		</c:otherwise>
																	</c:choose>
															</select></td>

															<td data-column="檔案類型" style="text-align: center;">
																<select name="plan_code">
																	<c:forEach items="${planList}" var="plan">
																		<c:choose>
																			<c:when
																				test="${plan.plan_code == scheduleplan.plan_code}">
																				<option value="${plan.plan_code}" SELECTED>${plan.plan_name}</option>
																			</c:when>
																			<c:otherwise>
																				<option value="${plan.plan_code}">${plan.plan_name}</option>
																			</c:otherwise>
																		</c:choose>
																	</c:forEach>
															</select>
															</td>

															<td data-column="下載"><input type="text"
																name="sche_cont" value="${scheduleplan.sche_cont}"
																size="36"></td>

															<td data-column="修改"><input type="submit" value="送出">
															</td>
														</c:if>
													</form>
												</tr>
											</c:forEach>
										</tbody>
									</table>
									<!-- END class table -->
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
