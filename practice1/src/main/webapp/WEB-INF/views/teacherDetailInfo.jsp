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
		<div class="row margin-top-30"></div>

		<div class="col-md-4">
			<div class="panel panel-default">
				<div class="panel-body">
					<ul class="posts-list margin-top-10">
						<li>
							<div class="recent-post">
								<img class="img-circle"
									src="img/teacherIMG/${teacherBasicInfo.teaPic}"
									class="img-circle" alt="teacher picture" width="236"
									height="236">
								<p>
								<h3>${teacherBasicInfo.teaName}</h3>
								<br>
								${teacherBasicInfo.teaENName}&nbsp;&nbsp;${teacherBasicInfo.teaPos}
								<br> ${teacherBasicInfo.teaEmail} <br>
								${teacherBasicInfo.teaTel} <br>
								辦公室位置:${teacherBasicInfo.teaLoc}
							</div> <a class="btn btn-default" href="teacherInfo">← 查看所有老師</a>
							<div class="clearfix"></div>
						</li>
					</ul>
				</div>
			</div>
		</div>

		<div class="col-md-8">
			<div class="tabs">
				<ul class="nav nav-tabs">
					<li class="active"><a href="#career" data-toggle="tab">現職相關資料</a></li>
					<li class=""><a href="#researchResult" data-toggle="tab">研究成果</a></li>
					<li class=""><a href="#teaching" data-toggle="tab">教學</a></li>
					<li class=""><a href="#service" data-toggle="tab">服務</a></li>
				</ul>
				<div class="tab-content">
					<div class="tab-pane fade active in" id="career">
						<!-- 學歷 -->
						<c:if test="${teacherEduInfo[0].flag == true}">
							<h4 class="color-blue">${teacherEduInfo[0].name}</h4>
							<table class="table" width="100%">
								<thead class="thead-default">
									<tr>
										<th>學校</th>
										<th>系所</th>
										<th>學位</th>
									</tr>
								</thead>
								<c:forEach items="${teacherEduInfo}" var="teacherEduInfo">
									<tbody>
										<tr>
											<td>${teacherEduInfo.teaSch}</td>
											<td>${teacherEduInfo.teaDep}</td>
											<td>${teacherEduInfo.teaDeg}</td>
										</tr>
									</tbody>
								</c:forEach>
							</table>
						</c:if>


						<!-- 經歷 -->
						<c:if test="${teacherExpInfo[0].flag == true}">
							<h4 class="color-blue">${teacherExpInfo[0].name}</h4>
							<table class="table" width="100%">
								<thead class="thead-default">
									<tr>
										<th>期間</th>
										<th>單位</th>
										<th>部門</th>
										<th>職稱</th>
									</tr>
								</thead>
								<c:forEach items="${teacherExpInfo}" var="teacherExpInfo">
									<tr>
										<td>${teacherExpInfo.teaExpPer}</td>
										<td>${teacherExpInfo.teaExpUnit}</td>
										<td>${teacherExpInfo.teaExpDep}</td>
										<td>${teacherExpInfo.teaExpTitle}</td>
									</tr>
								</c:forEach>
							</table>
						</c:if>

						<!-- 專長 -->
						<c:if test="${teacherSpeInfo[0].flag == true}">
							<h4 class="color-blue">${teacherSpeInfo[0].name}</h4>
							<table class="table" width="100%">
								<c:forEach items="${teacherSpeInfo}" var="teacherSpeInfo">
									<tr>
										<td>${teacherSpeInfo.teaSpe}</td>
									</tr>
								</c:forEach>
							</table>
						</c:if>

						<div class="clearfix"></div>
					</div>

					<div class="tab-pane fade" id="researchResult">
						<h4 class="color-blue">學術著作</h4>
						<div id="accordion" class="panel-group">

							<!-- 期刊論文 -->
							<c:if test="${teacherIssuePaper[0].flag == true}">
								<div class="panel panel-default">
									<div class="panel-heading">
										<h4 class="panel-title">
											<a class="accordion-toggle" href="#issuePaper"
												data-parent="#accordion" data-toggle="collapse">${teacherIssuePaper[0].name}</a>
										</h4>
									</div>
									<div id="issuePaper" class="accordion-body collapse"
										style="height: auto;">
										<div class="panel-body">
											<div class="row">
												<div class="col-md-12">
													<table class="table" width="100%">
														<thead>
															<tr>
																<th>期間</th>
																<th>內容</th>
															</tr>
														</thead>
														<c:forEach items="${teacherIssuePaper}"
															var="teacherIssuePaper">
															<tr>
																<td>${teacherIssuePaper.teaDataPer}</td>
																<td>${teacherIssuePaper.teaDataCont}</td>
															</tr>
														</c:forEach>
													</table>
												</div>
											</div>
										</div>
									</div>
								</div>
							</c:if>

							<!-- 研討會論文 -->
							<c:if test="${teacherMeetingPaper[0].flag == true}">
								<div class="panel panel-default">
									<div class="panel-heading">
										<h4 class="panel-title">
											<a class="accordion-toggle" href="#meetingPaper"
												data-parent="#accordion" data-toggle="collapse">${teacherMeetingPaper[0].name}</a>
										</h4>
									</div>
									<div id="meetingPaper" class="accordion-body collapse"
										style="height: auto;">
										<div class="panel-body">
											<div class="row">
												<div class="col-md-12">
													<table class="table" width="100%">
														<thead>
															<tr>
																<th>期間</th>
																<th>內容</th>
															</tr>
														</thead>
														<c:forEach items="${teacherMeetingPaper}"
															var="teacherMeetingPaper">
															<tr>
																<td>${teacherMeetingPaper.teaDataPer}</td>
																<td>${teacherMeetingPaper.teaDataCont}</td>
															</tr>
														</c:forEach>
													</table>
												</div>
											</div>
										</div>
									</div>
								</div>
							</c:if>

							<!-- 書籍 -->
							<c:if test="${teacherBooks[0].flag == true}">
								<div class="panel panel-default">
									<div class="panel-heading">
										<h4 class="panel-title">
											<a class="accordion-toggle" href="#books"
												data-parent="#accordion" data-toggle="collapse">${teacherBooks[0].name}</a>
										</h4>
									</div>
									<div id="books" class="accordion-body collapse"
										style="height: auto;">
										<div class="panel-body">
											<div class="row">
												<div class="col-md-12">
													<table class="table" width="100%">
														<thead>
															<tr>
																<th>期間</th>
																<th>內容</th>
															</tr>
														</thead>
														<c:forEach items="${teacherBooks}" var="teacherBooks">
															<tr>
																<td>${teacherBooks.teaDataPer}</td>
																<td>${teacherBooks.teaDataCont}</td>
															</tr>
														</c:forEach>
													</table>
												</div>
											</div>
										</div>
									</div>
								</div>
							</c:if>

							<!-- 技術報告 -->
							<c:if test="${teacherTechReport[0].flag == true}">
								<div class="panel panel-default">
									<div class="panel-heading">
										<h4 class="panel-title">
											<a class="accordion-toggle" href="#techReport"
												data-parent="#accordion" data-toggle="collapse">${teacherTechReport[0].name}</a>
										</h4>
									</div>
									<div id="techReport" class="accordion-body collapse"
										style="height: auto;">
										<div class="panel-body">
											<div class="row">
												<div class="col-md-12">
													<table class="table" width="100%">
														<thead>
															<tr>
																<th>期間</th>
																<th>內容</th>
															</tr>
														</thead>
														<c:forEach items="${teacherTechReport}"
															var="teacherTechReport">
															<tr>
																<td>${teacherTechReport.teaDataPer}</td>
																<td>${teacherTechReport.teaDataCont}</td>
															</tr>
														</c:forEach>
													</table>
												</div>
											</div>
										</div>
									</div>
								</div>
							</c:if>

							<!-- 畢業論文 -->
							<c:if test="${teacherPaper[0].flag == true}">
								<div class="panel panel-default">
									<div class="panel-heading">
										<h4 class="panel-title">
											<a class="accordion-toggle" href="#paper"
												data-parent="#accordion" data-toggle="collapse">${teacherPaper[0].name}</a>
										</h4>
									</div>
									<div id="paper" class="accordion-body collapse"
										style="height: auto;">
										<div class="panel-body">
											<div class="row">
												<div class="col-md-12">
													<table class="table" width="100%">
														<thead>
															<tr>
																<th>期間</th>
																<th>內容</th>
															</tr>
														</thead>
														<c:forEach items="${teacherPaper}" var="teacherPaper">
															<tr>
																<td>${teacherPaper.teaDataPer}</td>
																<td>${teacherPaper.teaDataCont}</td>
															</tr>
														</c:forEach>
													</table>
												</div>
											</div>
										</div>
									</div>
								</div>
							</c:if>

							<!-- 在資訊相關雜誌上近幾年發表之文章 -->
							<c:if test="${teacherMagazinePaper[0].flag == true}">
								<div class="panel panel-default">
									<div class="panel-heading">
										<h4 class="panel-title">
											<a class="accordion-toggle" href="#magazinePaper"
												data-parent="#accordion" data-toggle="collapse">${teacherMagazinePaper[0].name}</a>
										</h4>
									</div>
									<div id="magazinePaper" class="accordion-body collapse"
										style="height: auto;">
										<div class="panel-body">
											<div class="row">
												<div class="col-md-12">
													<table class="table" width="100%">
														<thead>
															<tr>
																<th>期間</th>
																<th>內容</th>
															</tr>
														</thead>
														<c:forEach items="${teacherMagazinePaper}"
															var="teacherMagazinePaper">
															<tr>
																<td>${teacherMagazinePaper.teaDataPer}</td>
																<td>${teacherMagazinePaper.teaDataCont}</td>
															</tr>
														</c:forEach>
													</table>
												</div>
											</div>
										</div>
									</div>
								</div>
							</c:if>

							<!-- 期刊審查中論文-->
							<c:if test="${teacherWaitingPaper[0].flag == true}">
								<div class="panel panel-default">
									<div class="panel-heading">
										<h4 class="panel-title">
											<a class="accordion-toggle" href="#waitingPaper"
												data-parent="#accordion" data-toggle="collapse">${teacherWaitingPaper[0].name}</a>
										</h4>
									</div>
									<div id="waitingPaper" class="accordion-body collapse"
										style="height: auto;">
										<div class="panel-body">
											<div class="row">
												<div class="col-md-12">
													<table class="table" width="100%">
														<thead>
															<tr>
																<th>期間</th>
																<th>內容</th>
															</tr>
														</thead>
														<c:forEach items="${teacherWaitingPaper}"
															var="teacherWaitingPaper">
															<tr>
																<td>${teacherWaitingPaper.teaDataPer}</td>
																<td>${teacherWaitingPaper.teaDataCont}</td>
															</tr>
														</c:forEach>
													</table>
												</div>
											</div>
										</div>
									</div>
								</div>
							</c:if>

							<!-- 學術著作-->
							<c:if test="${teacherScholarPaper[0].flag == true}">
								<div class="panel panel-default">
									<div class="panel-heading">
										<h4 class="panel-title">
											<a class="accordion-toggle" href="#scholarPaper"
												data-parent="#accordion" data-toggle="collapse">${teacherScholarPaper[0].name}</a>
										</h4>
									</div>
									<div id="scholarPaper" class="accordion-body collapse"
										style="height: auto;">
										<div class="panel-body">
											<div class="row">
												<div class="col-md-12">
													<table class="table" width="100%">
														<thead>
															<tr>
																<th>期間</th>
																<th>內容</th>
															</tr>
														</thead>
														<c:forEach items="${teacherScholarPaper}"
															var="teacherScholarPaper">
															<tr>
																<td>${teacherScholarPaper.teaDataPer}</td>
																<td>${teacherScholarPaper.teaDataCont}</td>
															</tr>
														</c:forEach>
													</table>
												</div>
											</div>
										</div>
									</div>
								</div>
							</c:if>

							<br>
							<!-- 研究獎勵 -->
							<c:if test="${teacherAwardInfo[0].flag == true}">
								<h4 class="color-blue">${teacherAwardInfo[0].name}</h4>
								<table class="table" width="100%">
									<thead class="thead-default">
										<tr>
											<th>年度</th>
											<th>單位</th>
											<th>獎項</th>
										</tr>
									</thead>
									<c:forEach items="${teacherAwardInfo}" var="teacherAwardInfo">
										<tbody>
											<tr>
												<td>${teacherAwardInfo.teaAwaYear}</td>
												<td>${teacherAwardInfo.teaAwaDep}</td>
												<td>${teacherAwardInfo.teaAwa}</td>
											</tr>
										</tbody>
									</c:forEach>
								</table>
							</c:if>

							<!-- 研究計劃-->
							<c:if test="${teacherPlanInfo[0].flag == true}">
								<h4 class="color-blue">${teacherPlanInfo[0].name}</h4>
								<table class="table" width="100%">
									<thead class="thead-default">
										<tr>
											<th>期間</th>
											<th>主持人</th>
											<th>計劃名稱</th>
											<th>贊助單位</th>
											<th>贊助金額</th>
											<th>職稱</th>
										</tr>
									</thead>
									<c:forEach items="${teacherPlanInfo}" var="teacherPlanInfo">
										<tbody>
											<tr>
												<td>${teacherPlanInfo.teaPlanPer}</td>
												<td>${teacherPlanInfo.teaPlanLeader}</td>
												<td>${teacherPlanInfo.teaPlanName}</td>
												<td>${teacherPlanInfo.teaPlanSpon}</td>
												<td>${teacherPlanInfo.teaPlanMon}</td>
												<td>${teacherPlanInfo.teaPlanPos}</td>
											</tr>
										</tbody>
									</c:forEach>
								</table>
							</c:if>

							<!-- 實務研究內容-->
							<c:if test="${teacherPracticeReach[0].flag == true}">
								<h4 class="color-blue">${teacherPracticeReach[0].name}</h4>
								<table class="table" width="100%">
									<thead class="thead-default">
										<tr>
											<th>期間</th>
											<th>內容</th>
										</tr>
									</thead>
									<c:forEach items="${teacherPracticeReach}"
										var="teacherPracticeReach">
										<tbody>
											<tr>
												<td>${teacherPracticeReach.teaDataPer}</td>
												<td>${teacherPracticeReach.teaDataCont}</td>
											</tr>
										</tbody>
									</c:forEach>
								</table>
							</c:if>

							<div class="clearfix"></div>
						</div>
					</div>

					<div class="tab-pane fade" id="teaching">

						<!-- 指導學生專題-->
						<c:if test="${teacherStuTopic[0].flag == true}">
							<h4 class="color-blue">${teacherStuTopic[0].name}</h4>
							<table class="table table-hover" width="100%">
								<thead class="thead-default">
									<tr>
										<th>年度</th>
										<th>專題名稱</th>
									</tr>
								</thead>
								<c:forEach items="${teacherStuTopic}" var="teacherStuTopic">
									<tbody>
										<tr>
											<td>${teacherStuTopic.teaStuYear}</td>
											<td>${teacherStuTopic.teaStuName}</td>
										</tr>
									</tbody>
								</c:forEach>
							</table>
						</c:if>

						<!-- 指導研究論文-->
						<c:if test="${teacherStuPaper[0].flag == true}">
							<h4 class="color-blue">${teacherStuPaper[0].name}</h4>
							<table class="table table-hover" width="100%">
								<thead class="thead-default">
									<tr>
										<th>年度</th>
										<th>研究生名稱</th>
										<th>論文題目</th>
									</tr>
								</thead>
								<c:forEach items="${teacherStuPaper}" var="teacherStuPaper">
									<tbody>
										<tr>
											<td>${teacherStuPaper.teaStuYear}</td>
											<td>${teacherStuPaper.teaStuName}</td>
											<td>${teacherStuPaper.teaStuPaperName}</td>
										</tr>
									</tbody>
								</c:forEach>
							</table>
						</c:if>

						<!-- 其他教學經驗-->
						<c:if test="${teacherOtherExp[0].flag == true}">
							<h4 class="color-blue">${teacherOtherExp[0].name}</h4>
							<table class="table" width="100%">
								<thead class="thead-default">
									<tr>
										<th>期間</th>
										<th>內容</th>
									</tr>
								</thead>
								<c:forEach items="${teacherOtherExp}" var="teacherOtherExp">
									<tbody>
										<tr>
											<td>${teacherOtherExp.teaDataPer}</td>
											<td>${teacherOtherExp.teaDataCont}</td>
										</tr>
									</tbody>
								</c:forEach>
							</table>
						</c:if>

						<div class="clearfix"></div>
					</div>

					<div class="tab-pane fade" id="service">

						<!-- 校內服務-->
						<c:if test="${teacherInSchService[0].flag == true}">
							<h4 class="color-blue">${teacherInSchService[0].name}</h4>
							<table class="table" width="100%">
								<thead class="thead-default">
									<tr>
										<th>期間</th>
										<th>內容</th>
									</tr>
								</thead>
								<c:forEach items="${teacherInSchService}"
									var="teacherInSchService">
									<tbody>
										<tr>
											<td>${teacherInSchService.teaDataPer}</td>
											<td>${teacherInSchService.teaDataCont}</td>
										</tr>
									</tbody>
								</c:forEach>
							</table>
						</c:if>

						<!-- 校外服務-->
						<c:if test="${teacherOutSchService[0].flag == true}">
							<h4 class="color-blue">${teacherOutSchService[0].name}</h4>
							<table class="table" width="100%">
								<thead class="thead-default">
									<tr>
										<th>期間</th>
										<th>內容</th>
									</tr>
								</thead>
								<c:forEach items="${teacherOutSchService}"
									var="teacherOutSchService">
									<tbody>
										<tr>
											<td>${teacherOutSchService.teaDataPer}</td>
											<td>${teacherOutSchService.teaDataCont}</td>
										</tr>
									</tbody>
								</c:forEach>
							</table>
						</c:if>

						<!-- 擔任委員-->
						<c:if test="${teacherAsCommitMem[0].flag == true}">
							<h4 class="color-blue">${teacherAsCommitMem[0].name}</h4>
							<table class="table" width="100%">
								<thead class="thead-default">
									<tr>
										<th>期間</th>
										<th>內容</th>
									</tr>
								</thead>
								<c:forEach items="${teacherAsCommitMem}"
									var="teacherAsCommitMem">
									<tbody>
										<tr>
											<td>${teacherAsCommitMem.teaDataPer}</td>
											<td>${teacherAsCommitMem.teaDataCont}</td>
										</tr>
									</tbody>
								</c:forEach>
							</table>
						</c:if>

						<!-- 學術經驗-->
						<c:if test="${teacherScholarExp[0].flag == true}">
							<h4 class="color-blue">${teacherScholarExp[0].name}</h4>
							<table class="table" width="100%">
								<thead class="thead-default">
									<tr>
										<th>期間</th>
										<th>內容</th>
									</tr>
								</thead>
								<c:forEach items="${teacherScholarExp}" var="teacherScholarExp">
									<tbody>
										<tr>
											<td>${teacherScholarExp.teaDataPer}</td>
											<td>${teacherScholarExp.teaDataCont}</td>
										</tr>
									</tbody>
								</c:forEach>
							</table>
						</c:if>
						<div class="clearfix"></div>
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


