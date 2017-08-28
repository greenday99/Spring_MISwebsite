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
		<!-- 左側顯示可編輯欄目 -->
		<!-- 此處欄位先寫死，應該是可以從資料庫抓取 -->
		<div class="col-sm-3">
			<ul class="nav nav-pills nav-stacked">
				<li class=""><a href="teacherManage"><i
						class="fa fa-home fa-fw"></i> 返回主界面</a></li>
				<li class="active"><a href="#career" data-toggle="tab"><i
						class="fa fa-briefcase fa-fw"></i> 現職相關資料</a></li>
				<li class=""><a href="#researchResult" data-toggle="tab"><i
						class="fa fa-pencil fa-fw"></i> 研究成果</a></li>
				<li class=""><a href="#teaching" data-toggle="tab"><i
						class="fa fa-comments fa-fw"></i> 教學</a></li>
				<li class=""><a href="#service" data-toggle="tab"><i
						class="fa fa-user fa-fw"></i> 服務</a></li>
			</ul>
			<div class="clearfix"></div>
		</div>
		<!-- 右側顯示詳情部分 -->
		<div class="col-md-9">
			<div class="tab-content">
				<!-- 現職相關資料 -->
				<div class="tab-pane fade active in" id="career">
					<div class="tabs">
						<ul class="nav nav-tabs">
							<li class="active"><a href="#teaEdu" data-toggle="tab">學歷</a></li>
							<li class=""><a href="#teaExp" data-toggle="tab">經歷</a></li>
							<li class=""><a href="#teaSpe" data-toggle="tab">專長</a></li>
						</ul>
						<!-- 學歷 -->
						<div class="tab-content">
							<div class="tab-pane fade active in" id="teaEdu">

								<a class="btn btn-default" href="#" data-toggle="modal"
									id="newEduInfo" data-target="#newTeaEdu"
									data-newEduTeaCode="${teacher.teaCode}">新增</a>

								<div class="row margin-top-20"></div>

								<table class="table table-hover" width="100%">
									<tr>
										<th>學校</th>
										<th>系所</th>
										<th>學位</th>
										<th>編輯</th>
										<th>
											<!-- 更改顯示位置 -->
										</th>
									</tr>
									<c:forEach items="${teacherEduInfo}" var="teacherEduInfo">
										<tr>
											<td><input type="hidden" name="teaEduCode"
												id="teaEduCode" value="${teacherEduInfo.teaEduCode }">
												<input type="hidden" name="teaCode" id="teaCode"
												value="${teacher.teaCode }">
												${teacherEduInfo.teaSch}</td>
											<td>${teacherEduInfo.teaDep}</td>
											<td>${teacherEduInfo.teaDeg}</td>
											<td><a class="btn btn-sm btn-default updateTeaEduInfo"
												href="#" data-toggle="modal" data-target="#updateTeaEdu"
												data-updateEduTeaCode="${teacher.teaCode}"
												data-UpdateEduCode="${teacherEduInfo.teaEduCode}"
												data-eduSch="${teacherEduInfo.teaSch}"
												data-eduDep="${teacherEduInfo.teaDep}"
												data-eduDeg="${teacherEduInfo.teaDeg}">修改</a> <a
												class="btn btn-sm btn-danger deleteBtn deleteTeaEduInfo"
												href="#" data-toggle="modal" data-target="#deleteTeaEdu"
												data-deleteEduTeaCode="${teacher.teaCode}"
												data-deleteEduCode="${teacherEduInfo.teaEduCode}">刪除</a></td>
											<td>
												<!-- 暫未開發 -->
											</td>
										</tr>
									</c:forEach>
								</table>
								<div class="clearfix"></div>
							</div>

							<!-- 經歷 -->
							<div class="tab-pane fade" id="teaExp">

								<a class="btn btn-default" href="#" data-toggle="modal"
									id="newTeaExpInfo" data-target="#newTeaExp"
									data-newExpTeaCode="${teacher.teaCode}">新增</a>

								<div class="row margin-top-20"></div>

								<table class="table table-hover" width="100%">
									<tr>
										<th>期间</th>
										<th>单位</th>
										<th>部门</th>
										<th>职称</th>
										<th>編輯</th>
										<th>
											<!-- 更改顯示位置 -->
										</th>
									</tr>
									<c:forEach items="${teacherExpInfo}" var="teacherExpInfo">
										<tr>
											<td>${teacherExpInfo.teaExpPer}</td>
											<td>${teacherExpInfo.teaExpUnit}</td>
											<td>${teacherExpInfo.teaExpDep}</td>
											<td>${teacherExpInfo.teaExpTitle}</td>
											<td><a class="btn btn-sm btn-default updateTeaExpInfo"
												href="#" data-toggle="modal" data-target="#updateTeaExp"
												data-updateExpTeaCode="${teacher.teaCode}"
												data-UpdateTeaExpCode="${teacherExpInfo.teaExpCode}"
												data-per="${teacherExpInfo.teaExpPer}"
												data-unit="${teacherExpInfo.teaExpUnit}"
												data-dep="${teacherExpInfo.teaExpDep}"
												data-title="${teacherExpInfo.teaExpTitle }">修改</a> <a
												class="btn btn-sm btn-danger deleteBtn deleteTeaExpInfo"
												href="#" data-toggle="modal" data-target="#deleteTeaExp"
												data-deleteExpTeaCode="${teacher.teaCode}"
												data-deleteTeaExpCode="${teacherExpInfo.teaExpCode}">刪除</a></td>
											<td>
												<!-- 暫未開發 -->
											</td>
										</tr>
									</c:forEach>
								</table>

								<div class="clearfix"></div>
							</div>

							<!-- 教師專長 -->
							<div class="tab-pane fade" id="teaSpe">

								<a class="btn btn-default" href="#" data-toggle="modal"
									id="newSpeInfo" data-target="#newSpeExp"
									data-newSpeTeaCode="${teacher.teaCode}">新增</a>

								<div class="row margin-top-20"></div>

								<table class="table" width="100%">
									<tr>
										<th>專長</th>
										<th>編輯</th>
										<th>
											<!-- 更改顯示位置 -->
										</th>
									</tr>
									<c:forEach items="${teacherSpeInfo}" var="teacherSpeInfo">
										<tr>
											<td>${teacherSpeInfo.teaSpe}</td>
											<td><a class="btn btn-sm btn-default updateTeaSpeInfo"
												href="#" data-toggle="modal" data-target="#updateTeaSpe"
												data-updateSpeTeaCode="${teacher.teaCode}"
												data-updateTeaSpeCode="${teacherSpeInfo.teaSpeCode}"
												data-updateTeaSpe="${teacherSpeInfo.teaSpe}">修改</a> <a
												class="btn btn-sm btn-danger deleteBtn deleteTeaSpeInfo"
												href="#" data-toggle="modal" data-target="#deleteTeaSpe"
												data-deleteSpeTeaCode="${teacher.teaCode}"
												data-deleteSpeExpCode="${teacherSpeInfo.teaSpeCode}">刪除</a></td>
											<td>
												<!-- 暫未開發 -->
											</td>
										</tr>
									</c:forEach>
								</table>

								<div class="clearfix"></div>
							</div>
						</div>
					</div>
				</div>

				<!-- 研究成果 -->
				<div class="tab-pane fade" id="researchResult">
					<div class="tabs">
						<ul class="nav nav-tabs">
							<li class="active"><a href="#scholarWriting"
								data-toggle="tab">學術著作</a></li>
							<li class=""><a href="#teaAwa" data-toggle="tab">研究獎勵</a></li>
							<li class=""><a href="#teaPlan" data-toggle="tab">研究計劃</a></li>
							<li class=""><a href="#practical" data-toggle="tab">實務研究</a></li>
						</ul>
						<div class="tab-content">
							<div class="tab-pane fade active in" id="scholarWriting">
								<div class="row margin-top-20"></div>
								<div class="tabs alternative">
									<ul class="nav nav-tabs">
										<li class="active"><a href="#IssuePaper"
											data-toggle="tab">期刊論文</a></li>
										<li class=""><a href="#MeetingPaper" data-toggle="tab">研討會論文</a></li>
										<li class=""><a href="#Books" data-toggle="tab">書籍</a></li>
										<li class=""><a href="#TechReport" data-toggle="tab">技術報告</a></li>
										<li class=""><a href="#TecherPaper" data-toggle="tab">畢業論文</a></li>
										<li class=""><a href="#MagazinePaper" data-toggle="tab">在資訊相關雜誌上近幾年發表之文章</a></li>
										<li class=""><a href="#WaitingPaper" data-toggle="tab">期刊審查中論文</a></li>
										<li class=""><a href="#ScholarPaper" data-toggle="tab">學術著作</a></li>
									</ul>
									<div class="tab-content">

										<!-- 期刊論文 -->
										<div class="tab-pane fade active in" id="IssuePaper">

											<a class="btn btn-default" href="#" data-toggle="modal"
												id="newIssuePaperInfo" data-target="#newIssuePaper"
												data-newIssuePaperTeaCode="${teacher.teaCode}">新增</a>

											<div class="row margin-top-20"></div>

											<table class="table" width="100%">
												<thead>
													<tr>
														<th>期間</th>
														<th>內容</th>
														<th>編輯</th>
														<th>
															<!-- 更改顯示位置 -->
														</th>
													</tr>
												</thead>
												<c:forEach items="${teacherIssuePaper}"
													var="teacherIssuePaper">
													<tr>
														<td>${teacherIssuePaper.teaDataPer}</td>
														<td>${teacherIssuePaper.teaDataCont}</td>
														<td><a
															class="btn btn-sm btn-default updateIssuePaperInfo"
															href="#" data-toggle="modal"
															data-target="#updateIssuePaper"
															data-updateIssuePaperTeaCode="${teacher.teaCode}"
															data-updateIssuePaperCode="${teacherIssuePaper.teaDataContCode}"
															data-IssuePaperDataPer="${teacherIssuePaper.teaDataPer}"
															data-IssuePaperDataCont="${teacherIssuePaper.teaDataCont}">修改</a>
															<a
															class="btn btn-sm btn-danger deleteBtn deleteIssuePaperInfo"
															href="#" data-toggle="modal"
															data-target="#deleteIssuePaper"
															data-deleteIssuePaperTeaCode="${teacher.teaCode}"
															data-deleteIssuePaperCode="${teacherIssuePaper.teaDataContCode}">刪除</a></td>
														<td><!-- 暫未開發 --></td>
													</tr>
												</c:forEach>
											</table>

											<div class="clearfix"></div>
										</div>

										<!-- 研討會論文 -->
										<div class="tab-pane fade" id="MeetingPaper">

											<a class="btn btn-default" href="#" data-toggle="modal"
												id="newMeetingPaperInfo" data-target="#newMeetingPaper"
												data-newMeetingPaperTeaCode="${teacher.teaCode}">新增</a>

											<div class="row margin-top-20"></div>

											<table class="table" width="100%">
												<thead>
													<tr>
														<th>期間</th>
														<th>內容</th>
														<th>編輯</th>
														<th>
															<!-- 更改顯示位置 -->
														</th>
													</tr>
												</thead>
												<c:forEach items="${teacherMeetingPaper}"
													var="teacherMeetingPaper">
													<tr>
														<td>${teacherMeetingPaper.teaDataPer}</td>
														<td>${teacherMeetingPaper.teaDataCont}</td>
														<td><a
															class="btn btn-sm btn-default updateMeetingPaperInfo"
															href="#" data-toggle="modal"
															data-target="#updateMeetingPaper"
															data-updateMeetingPaperTeaCode="${teacher.teaCode}"
															data-updateMeetingPaperCode="${teacherMeetingPaper.teaDataContCode}"
															data-MeetingPaperDataPer="${teacherMeetingPaper.teaDataPer}"
															data-MeetingPaperDataCont="${teacherMeetingPaper.teaDataCont}">修改</a>
															<a
															class="btn btn-sm btn-danger deleteBtn deleteMeetingPaperInfo"
															href="#" data-toggle="modal"
															data-target="#deleteMeetingPaper"
															data-deleteMeetingPaperTeaCode="${teacher.teaCode}"
															data-deleteMeetingPaperCode="${teacherMeetingPaper.teaDataContCode}">刪除</a></td>
														<td>
															<!-- 暫未開發 -->
														</td>
													</tr>
												</c:forEach>
											</table>

											<div class="clearfix"></div>
										</div>

										<!-- 書籍 -->
										<div class="tab-pane fade" id="Books">

											<a class="btn btn-default" href="#" data-toggle="modal"
												id="newBooksInfo" data-target="#newBooks"
												data-newBooksTeaCode="${teacher.teaCode}">新增</a>

											<div class="row margin-top-20"></div>

											<table class="table" width="100%">
												<thead>
													<tr>
														<th>期間</th>
														<th>內容</th>
														<th>編輯</th>
														<th>
															<!-- 更改顯示位置 -->
														</th>
													</tr>
												</thead>
												<c:forEach items="${teacherBooks}" var="teacherBooks">
													<tr>
														<td>${teacherBooks.teaDataPer}</td>
														<td>${teacherBooks.teaDataCont}</td>
														<td><a class="btn btn-sm btn-default updateBooksInfo"
															href="#" data-toggle="modal" data-target="#updateBooks"
															data-updateBooksTeaCode="${teacher.teaCode}"
															data-updateBooksCode="${teacherBooks.teaDataContCode}"
															data-BooksDataPer="${teacherBooks.teaDataPer}"
															data-BooksDataCont="${teacherBooks.teaDataCont}">修改</a> <a
															class="btn btn-sm btn-danger deleteBtn deleteBooksInfo"
															href="#" data-toggle="modal" data-target="#deleteBooks"
															data-deleteBooksTeaCode="${teacher.teaCode}"
															data-deleteBooksCode="${teacherBooks.teaDataContCode}">刪除</a></td>
														<td>
															<!-- 暫未開發 -->
														</td>
													</tr>
												</c:forEach>
											</table>

											<div class="clearfix"></div>
										</div>

										<!-- 技術報告 -->
										<div class="tab-pane fade" id="TechReport">

											<a class="btn btn-default" href="#" data-toggle="modal"
												id="newTechReportInfo" data-target="#newTechReport"
												data-newTechReportTeaCode="${teacher.teaCode}">新增</a>

											<div class="row margin-top-20"></div>

											<table class="table" width="100%">
												<thead>
													<tr>
														<th>期間</th>
														<th>內容</th>
														<th>編輯</th>
														<th>
															<!-- 更改顯示位置 -->
														</th>
													</tr>
												</thead>
												<c:forEach items="${teacherTechReport}"
													var="teacherTechReport">
													<tr>
														<td>${teacherTechReport.teaDataPer}</td>
														<td>${teacherTechReport.teaDataCont}</td>
														<td><a
															class="btn btn-sm btn-default updateTechReportInfo"
															href="#" data-toggle="modal"
															data-target="#updateTechReport"
															data-updateTechReportTeaCode="${teacher.teaCode}"
															data-updateTechReportCode="${teacherTechReport.teaDataContCode}"
															data-TechReportDataPer="${teacherTechReport.teaDataPer}"
															data-TechReportDataCont="${teacherTechReport.teaDataCont}">修改</a>
															<a
															class="btn btn-sm btn-danger deleteBtn deleteTechReportInfo"
															href="#" data-toggle="modal"
															data-target="#deleteTechReport"
															data-deleteTechReportTeaCode="${teacher.teaCode}"
															data-deleteTechReportCode="${teacherTechReport.teaDataContCode}">刪除</a></td>
														<td>
															<!-- 暫未開發 -->
														</td>
													</tr>
												</c:forEach>
											</table>

											<div class="clearfix"></div>
										</div>

										<!-- 畢業論文 -->
										<div class="tab-pane fade" id="TecherPaper">

											<a class="btn btn-default" href="#" data-toggle="modal"
												id="newTeacherPaperInfo" data-target="#newTeacherPaper"
												data-newTeacherPaperTeaCode="${teacher.teaCode}">新增</a>

											<div class="row margin-top-20"></div>

											<table class="table" width="100%">
												<thead>
													<tr>
														<th>期間</th>
														<th>內容</th>
														<th>編輯</th>
														<th>
															<!-- 更改顯示位置 -->
														</th>
													</tr>
												</thead>
												<c:forEach items="${teacherPaper}" var="teacherPaper">
													<tr>
														<td>${teacherPaper.teaDataPer}</td>
														<td>${teacherPaper.teaDataCont}</td>
														<td><a
															class="btn btn-sm btn-default updateTeacherPaperInfo"
															href="#" data-toggle="modal"
															data-target="#updateTeacherPaper"
															data-updateTeacherPaperTeaCode="${teacher.teaCode}"
															data-updateTeacherPaperCode="${teacherPaper.teaDataContCode}"
															data-TeacherPaperDataPer="${teacherPaper.teaDataPer}"
															data-TeacherPaperDataCont="${teacherPaper.teaDataCont}">修改</a>
															<a
															class="btn btn-sm btn-danger deleteBtn deleteTeacherPaperInfo"
															href="#" data-toggle="modal"
															data-target="#deleteTeacherPaper"
															data-deleteTeacherPaperTeaCode="${teacher.teaCode}"
															data-deleteTeacherPaperCode="${teacherPaper.teaDataContCode}">刪除</a></td>
														<td>
															<!-- 暫未開發 -->
														</td>
													</tr>
												</c:forEach>
											</table>

											<div class="clearfix"></div>
										</div>

										<!-- 在資訊相關雜誌上近幾年發表之文章 -->
										<div class="tab-pane fade" id="MagazinePaper">

											<a class="btn btn-default" href="#" data-toggle="modal"
												id="newMagazinePaperInfo" data-target="#newMagazinePaper"
												data-newMagazinePaperTeaCode="${teacher.teaCode}">新增</a>

											<div class="row margin-top-20"></div>

											<table class="table" width="100%">
												<thead>
													<tr>
														<th>期間</th>
														<th>內容</th>
														<th>編輯</th>
														<th>
															<!-- 更改顯示位置 -->
														</th>
													</tr>
												</thead>
												<c:forEach items="${teacherMagazinePaper}"
													var="teacherMagazinePaper">
													<tr>
														<td>${teacherMagazinePaper.teaDataPer}</td>
														<td>${teacherMagazinePaper.teaDataCont}</td>
														<td><a
															class="btn btn-sm btn-default updateMagazinePaperInfo"
															href="#" data-toggle="modal"
															data-target="#updateMagazinePaper"
															data-updateMagazinePaperTeaCode="${teacher.teaCode}"
															data-updateMagazinePaperCode="${teacherMagazinePaper.teaDataContCode}"
															data-MagazinePaperDataPer="${teacherMagazinePaper.teaDataPer}"
															data-MagazinePaperDataCont="${teacherMagazinePaper.teaDataCont}">修改</a>
															<a
															class="btn btn-sm btn-danger deleteBtn deleteMagazinePaperInfo"
															href="#" data-toggle="modal"
															data-target="#deleteMagazinePaper"
															data-deleteMagazinePaperTeaCode="${teacher.teaCode}"
															data-deleteMagazinePaperCode="${teacherMagazinePaper.teaDataContCode}">刪除</a></td>
														<td>
															<!-- 暫未開發 -->
														</td>
													</tr>
												</c:forEach>
											</table>

											<div class="clearfix"></div>
										</div>

										<!-- 期刊審查中論文 -->
										<div class="tab-pane fade" id="WaitingPaper">

											<a class="btn btn-default" href="#" data-toggle="modal"
												id="newWaitingPaperInfo" data-target="#newWaitingPaper"
												data-newWaitingPaperTeaCode="${teacher.teaCode}">新增</a>

											<div class="row margin-top-20"></div>

											<table class="table" width="100%">
												<thead>
													<tr>
														<th>期間</th>
														<th>內容</th>
														<th>編輯</th>
														<th>
															<!-- 更改顯示位置 -->
														</th>
													</tr>
												</thead>
												<c:forEach items="${teacherWaitingPaper}"
													var="teacherWaitingPaper">
													<tr>
														<td>${teacherWaitingPaper.teaDataPer}</td>
														<td>${teacherWaitingPaper.teaDataCont}</td>
														<td><a
															class="btn btn-sm btn-default updateWaitingPaperInfo"
															href="#" data-toggle="modal"
															data-target="#updateWaitingPaper"
															data-updateWaitingPaperTeaCode="${teacher.teaCode}"
															data-updateWaitingPaperCode="${teacherWaitingPaper.teaDataContCode}"
															data-WaitingPaperDataPer="${teacherWaitingPaper.teaDataPer}"
															data-WaitingPaperDataCont="${teacherWaitingPaper.teaDataCont}">修改</a>
															<a
															class="btn btn-sm btn-danger deleteBtn deleteWaitingPaperInfo"
															href="#" data-toggle="modal"
															data-target="#deleteWaitingPaper"
															data-deleteWaitingPaperTeaCode="${teacher.teaCode}"
															data-deleteWaitingPaperCode="${teacherWaitingPaper.teaDataContCode}">刪除</a></td>
														<td>
															<!-- 暫未開發 -->
														</td>
													</tr>
												</c:forEach>
											</table>

											<div class="clearfix"></div>
										</div>

										<!-- 學術著作 -->
										<div class="tab-pane fade" id="ScholarPaper">

											<a class="btn btn-default" href="#" data-toggle="modal"
												id="newScholarPaperInfo" data-target="#newScholarPaper"
												data-newScholarPaperTeaCode="${teacher.teaCode}">新增</a>

											<div class="row margin-top-20"></div>

											<table class="table" width="100%">
												<thead>
													<tr>
														<th>期間</th>
														<th>內容</th>
														<th>編輯</th>
														<th>
															<!-- 更改顯示位置 -->
														</th>
													</tr>
												</thead>
												<c:forEach items="${teacherScholarPaper}"
													var="teacherScholarPaper">
													<tr>
														<td>${teacherScholarPaper.teaDataPer}</td>
														<td>${teacherScholarPaper.teaDataCont}</td>
														<td><a
															class="btn btn-sm btn-default updateScholarPaperInfo"
															href="#" data-toggle="modal"
															data-target="#updateScholarPaper"
															data-updateScholarPaperTeaCode="${teacher.teaCode}"
															data-updateScholarPaperCode="${teacherScholarPaper.teaDataContCode}"
															data-ScholarPaperDataPer="${teacherScholarPaper.teaDataPer}"
															data-ScholarPaperDataCont="${teacherScholarPaper.teaDataCont}">修改</a>
															<a
															class="btn btn-sm btn-danger deleteBtn deleteScholarPaperInfo"
															href="#" data-toggle="modal"
															data-target="#deleteScholarPaper"
															data-deleteScholarPaperTeaCode="${teacher.teaCode}"
															data-deleteScholarPaperCode="${teacherScholarPaper.teaDataContCode}">刪除</a></td>
														<td>
															<!-- 暫未開發 -->
														</td>
													</tr>
												</c:forEach>
											</table>

											<div class="clearfix"></div>
										</div>
									</div>
								</div>
								<div class="clearfix"></div>
							</div>

							<!-- 研究獎勵 -->
							<div class="tab-pane fade" id="teaAwa">

								<a class="btn btn-default" href="#" data-toggle="modal"
									id="newTeaAwaInfo" data-target="#newTeaAwa"
									data-newTeaAwaTeaCode="${teacher.teaCode}">新增</a>

								<div class="row margin-top-20"></div>

								<table class="table" width="100%">
									<thead class="thead-default">
										<tr>
											<th>年度</th>
											<th>單位</th>
											<th>獎項</th>
											<th>編輯</th>
											<th>
												<!-- 更改顯示位置 -->
											</th>
										</tr>
									</thead>
									<c:forEach items="${teacherAwardInfo}" var="teacherAwardInfo">
										<tbody>
											<tr>
												<td>${teacherAwardInfo.teaAwaYear}</td>
												<td>${teacherAwardInfo.teaAwaDep}</td>
												<td>${teacherAwardInfo.teaAwa}</td>
												<td><a class="btn btn-sm btn-default updateTeaAwaInfo"
													href="#" data-toggle="modal" data-target="#updateTeaAwa"
													data-updateTeaAwaTeaCode="${teacher.teaCode}"
													data-updateTeaAwaCode="${teacherAwardInfo.teaAwaCode}"
													data-teaAwaYear="${teacherAwardInfo.teaAwaYear}"
													data-teaAwaDep="${teacherAwardInfo.teaAwaDep}"
													data-teaAwaInfo="${teacherAwardInfo.teaAwa}">修改</a> <a
													class="btn btn-sm btn-danger deleteBtn deleteTeaAwaInfo"
													href="#" data-toggle="modal" data-target="#deleteTeaAwa"
													data-deleteTeaAwaTeaCode="${teacher.teaCode}"
													data-deleteTeaAwaCode="${teacherAwardInfo.teaAwaCode}">刪除</a></td>
												<td>
													<!-- 暫未開發 -->
												</td>
											</tr>
										</tbody>
									</c:forEach>
								</table>

								<div class="clearfix"></div>
							</div>

							<!-- 研究計劃 -->
							<div class="tab-pane fade" id="teaPlan">

								<a class="btn btn-default" href="#" data-toggle="modal"
									id="newTeaPlanInfo" data-target="#newTeaPlan"
									data-newTeaPlanTeaCode="${teacher.teaCode}">新增</a>

								<div class="row margin-top-20"></div>

								<table class="table" width="100%">
									<thead class="thead-default">
										<tr>
											<th>期間</th>
											<th>主持人</th>
											<th>計劃名稱</th>
											<th>贊助單位</th>
											<th>贊助金額</th>
											<th>職稱</th>
											<th>編輯</th>
											<th>
												<!-- 更改顯示位置 -->
											</th>
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
												<td><a class="btn btn-sm btn-default updateTeaPlanInfo"
													href="#" data-toggle="modal" data-target="#updateTeaPlan"
													data-updateTeaPlanTeaCode="${teacher.teaCode}"
													data-updateTeaPlanCode="${teacherPlanInfo.teaPlanCode}"
													data-teaPlanPer="${teacherPlanInfo.teaPlanPer}"
													data-teaPlanLeader="${teacherPlanInfo.teaPlanLeader}"
													data-teaPlanName="${teacherPlanInfo.teaPlanName}"
													data-teaPlanSpon="${teacherPlanInfo.teaPlanSpon}"
													data-teaPlanMon="${teacherPlanInfo.teaPlanMon}"
													data-teaPlanPos="${teacherPlanInfo.teaPlanPos}">修改</a> <a
													class="btn btn-sm btn-danger deleteBtn deleteTeaPlanInfo"
													href="#" data-toggle="modal" data-target="#deleteTeaPlan"
													data-deleteTeaPlanTeaCode="${teacher.teaCode}"
													data-deleteTeaPlanCode="${teacherPlanInfo.teaPlanCode}">刪除</a></td>
												<td>
													<!-- 暫未開發 -->
												</td>
											</tr>
										</tbody>
									</c:forEach>
								</table>

								<div class="clearfix"></div>
							</div>

							<!-- 實務研究 -->
							<div class="tab-pane fade" id="practical">

								<a class="btn btn-default" href="#" data-toggle="modal"
									id="newPracticalInfo" data-target="#newPractical"
									data-newPracticalTeaCode="${teacher.teaCode}">新增</a>

								<div class="row margin-top-20"></div>

								<table class="table" width="100%">
									<thead class="thead-default">
										<tr>
											<th>期間</th>
											<th>內容</th>
											<th>編輯</th>
											<th>
												<!-- 更改顯示位置 -->
											</th>
										</tr>
									</thead>
									<c:forEach items="${teacherPracticeReach}"
										var="teacherPracticeReach">
										<tbody>
											<tr>
												<td>${teacherPracticeReach.teaDataPer}</td>
												<td>${teacherPracticeReach.teaDataCont}</td>
												<td><a
													class="btn btn-sm btn-default updatePracticalInfo" href="#"
													data-toggle="modal" data-target="#updatePractical"
													data-updatePracticalTeaCode="${teacher.teaCode}"
													data-UpdatePracticalCode="${teacherPracticeReach.teaDataContCode}"
													data-PracticalDataPer="${teacherPracticeReach.teaDataPer}"
													data-PracticalDataCont="${teacherPracticeReach.teaDataCont}">修改</a>
													<a
													class="btn btn-sm btn-danger deleteBtn deletePracticalInfo"
													href="#" data-toggle="modal" data-target="#deletePractical"
													data-deletePracticalTeaCode="${teacher.teaCode}"
													data-deletePracticalCode="${teacherPracticeReach.teaDataContCode}">刪除</a></td>
												<td>
													<!-- 暫未開發 -->
												</td>
											</tr>
										</tbody>
									</c:forEach>
								</table>

								<div class="clearfix"></div>
							</div>
						</div>
					</div>
				</div>

				<!-- 教學 -->
				<div class="tab-pane fade" id="teaching">
					<div class="tabs">
						<ul class="nav nav-tabs">
							<li class="active"><a href="#teaStuTopic" data-toggle="tab">指導學生專題</a></li>
							<li class=""><a href="#teaStuPaper" data-toggle="tab">指導研究生論文</a></li>
							<li class=""><a href="#otherTeaExp" data-toggle="tab">其他教學經驗</a></li>
						</ul>
						<div class="tab-content">

							<!-- 指導學生專題 -->
							<div class="tab-pane fade active in" id="teaStuTopic">

								<a class="btn btn-default" href="#" data-toggle="modal"
									id="newTeaStuTopicInfo" data-target="#newTeaStuTopic"
									data-newTeaStuTopicTeaCode="${teacher.teaCode}">新增</a>

								<div class="row margin-top-20"></div>

								<table class="table table-hover" width="100%">
									<thead class="thead-default">
										<tr>
											<th>年度</th>
											<th>專題名稱</th>
											<th>編輯</th>
											<th>
												<!-- 更改顯示位置 -->
											</th>
										</tr>
									</thead>
									<c:forEach items="${teacherStuTopic}" var="teacherStuTopic">
										<tbody>
											<tr>
												<td>${teacherStuTopic.teaStuYear}</td>
												<td>${teacherStuTopic.teaStuName}</td>
												<td><a
													class="btn btn-sm btn-default updateTeaStuTopicInfo"
													data-toggle="modal" data-target="#updateTeaStuTopic"
													data-updateTeaStuTopicTeaCode="${teacher.teaCode}"
													data-UpdateTeaStuTopicCode="${teacherStuTopic.topicID}"
													data-teaStuYear="${teacherStuTopic.teaStuYear}"
													data-teaStuName="${teacherStuTopic.teaStuName}">修改</a> <a
													class="btn btn-sm btn-danger deleteBtn deleteTeaStuTopicInfo"
													href="#" data-toggle="modal"
													data-target="#deleteTeaStuTopic"
													data-deleteTeaStuTopicTeaCode="${teacher.teaCode}"
													data-deleteTeaStuTopicCode="${teacherStuTopic.topicID}">刪除</a></td>
												<td>
													<!-- 暫未開發 -->
												</td>
											</tr>
										</tbody>
									</c:forEach>
								</table>

								<div class="clearfix"></div>
							</div>

							<!-- 指導研究生論文 -->
							<div class="tab-pane fade" id="teaStuPaper">

								<a class="btn btn-default" href="#" data-toggle="modal"
									id="newTeaStuPaperInfo" data-target="#newTeaStuPaper"
									data-newTeaStuPaperTeaCode="${teacher.teaCode}">新增</a>

								<div class="row margin-top-20"></div>

								<table class="table table-hover" width="100%">
									<thead class="thead-default">
										<tr>
											<th>年度</th>
											<th>研究生名稱</th>
											<th>論文題目</th>
											<th>編輯</th>
											<th>
												<!-- 更改顯示位置 -->
											</th>
										</tr>
									</thead>
									<c:forEach items="${teacherStuPaper}" var="teacherStuPaper">
										<tbody>
											<tr>
												<td>${teacherStuPaper.teaStuYear}</td>
												<td>${teacherStuPaper.teaStuName}</td>
												<td>${teacherStuPaper.teaStuPaperName}</td>
												<td><a
													class="btn btn-sm btn-default updateTeaStuPaperInfo"
													href="#" data-toggle="modal"
													data-target="#updateTeaStuPaper"
													data-updateTeaStuPaperTeaCode="${teacher.teaCode}"
													data-UpdateTeaStuPaperCode="${teacherStuPaper.paperID}"
													data-teaGraduateStuYear="${teacherStuPaper.teaStuYear}"
													data-teaGraduateStuName="${teacherStuPaper.teaStuName}"
													data-teaStuPaperName="${teacherStuPaper.teaStuPaperName}">修改</a>
													<a
													class="btn btn-sm btn-danger deleteBtn deleteTeaStuPaperInfo"
													href="#" data-toggle="modal"
													data-target="#deleteTeaStuPaper"
													data-deleteTeaStuPaperTeaCode="${teacher.teaCode}"
													data-deleteTeaStuPaperCode="${teacherStuPaper.paperID}">刪除</a></td>
												<td>
													<!-- 暫未開發 -->
												</td>
											</tr>
										</tbody>
									</c:forEach>
								</table>

								<div class="clearfix"></div>
							</div>

							<!-- 其他教學經驗 -->
							<div class="tab-pane fade" id="otherTeaExp">

								<a class="btn btn-default" href="#" data-toggle="modal"
									id="newOtherTeaExpInfo" data-target="#newOtherTeaExp"
									data-newOtherTeaExpTeaCode="${teacher.teaCode}">新增</a>

								<div class="row margin-top-20"></div>

								<table class="table" width="100%">
									<thead class="thead-default">
										<tr>
											<th>期間</th>
											<th>內容</th>
											<th>編輯</th>
											<th>
												<!-- 更改顯示位置 -->
											</th>
										</tr>
									</thead>
									<c:forEach items="${teacherOtherExp}" var="teacherOtherExp">
										<tbody>
											<tr>
												<td>${teacherOtherExp.teaDataPer}</td>
												<td>${teacherOtherExp.teaDataCont}</td>
												<td><a
													class="btn btn-sm btn-default updateOtherTeaExpInfo"
													href="#" data-toggle="modal"
													data-target="#updateOtherTeaExp"
													data-updateOtherTeaExpTeaCode="${teacher.teaCode}"
													data-UpdateOtherTeaExpCode="${teacherOtherExp.teaDataContCode}"
													data-OtherTeaExpDataPer="${teacherOtherExp.teaDataPer}"
													data-OtherTeaExpDataCont="${teacherOtherExp.teaDataCont}">修改</a>
													<a
													class="btn btn-sm btn-danger deleteBtn deleteOtherTeaExpInfo"
													href="#" data-toggle="modal"
													data-target="#deleteOtherTeaExp"
													data-deleteOtherTeaExpTeaCode="${teacher.teaCode}"
													data-deleteOtherTeaExpCode="${teacherOtherExp.teaDataContCode}">刪除</a></td>
												<td>
													<!-- 暫未開發 -->
												</td>
											</tr>
										</tbody>
									</c:forEach>
								</table>

								<div class="clearfix"></div>
							</div>
						</div>
					</div>
				</div>
				<!-- 服務 -->
				<div class="tab-pane fade" id="service">
					<div class="tabs">
						<ul class="nav nav-tabs">
							<li class="active"><a href="#inSchService" data-toggle="tab">校內服務</a></li>
							<li class=""><a href="#outSchService" data-toggle="tab">校外服務</a></li>
							<li class=""><a href="#asCommitMem" data-toggle="tab">擔任委員</a></li>
							<li class=""><a href="#scholarExp" data-toggle="tab">學術經驗</a></li>
						</ul>
						<div class="tab-content">

							<!-- 校內服務 -->
							<div class="tab-pane fade active in" id="inSchService">

								<a class="btn btn-default" href="#" data-toggle="modal"
									id="newInSchServiceInfo" data-target="#newInSchService"
									data-newInSchServiceTeaCode="${teacher.teaCode}">新增</a>

								<div class="row margin-top-20"></div>

								<table class="table" width="100%">
									<thead class="thead-default">
										<tr>
											<th>期間</th>
											<th>內容</th>
											<th>編輯</th>
											<th>
												<!-- 更改顯示位置 -->
											</th>
										</tr>
									</thead>
									<c:forEach items="${teacherInSchService}"
										var="teacherInSchService">
										<tbody>
											<tr>
												<td>${teacherInSchService.teaDataPer}</td>
												<td>${teacherInSchService.teaDataCont}</td>
												<td><a
													class="btn btn-sm btn-default updateInSchServiceInfo"
													href="#" data-toggle="modal"
													data-target="#updateInSchService"
													data-updateInSchServiceTeaCode="${teacher.teaCode}"
													data-UpdateInSchServiceCode="${teacherInSchService.teaDataContCode}"
													data-InSchServiceDataPer="${teacherInSchService.teaDataPer}"
													data-InSchServiceDataCont="${teacherInSchService.teaDataCont}">修改</a>
													<a
													class="btn btn-sm btn-danger deleteBtn deleteInSchServiceInfo"
													href="#" data-toggle="modal"
													data-target="#deleteInSchService"
													data-deleteInSchServiceTeaCode="${teacher.teaCode}"
													data-deleteInSchServiceCode="${teacherInSchService.teaDataContCode}">刪除</a></td>
												<td>
													<!-- 暫未開發 -->
												</td>
											</tr>
										</tbody>
									</c:forEach>
								</table>

								<div class="clearfix"></div>
							</div>

							<!-- 校外服務 -->
							<div class="tab-pane fade" id="outSchService">

								<a class="btn btn-default" href="#" data-toggle="modal"
									id="newOutSchServiceInfo" data-target="#newOutSchService"
									data-newOutSchServiceTeaCode="${teacher.teaCode}">新增</a>

								<div class="row margin-top-20"></div>

								<table class="table" width="100%">
									<thead class="thead-default">
										<tr>
											<th>期間</th>
											<th>內容</th>
											<th>編輯</th>
											<th>
												<!-- 更改顯示位置 -->
											</th>
										</tr>
									</thead>
									<c:forEach items="${teacherOutSchService}"
										var="teacherOutSchService">
										<tbody>
											<tr>
												<td>${teacherOutSchService.teaDataPer}</td>
												<td>${teacherOutSchService.teaDataCont}</td>
												<td><a
													class="btn btn-sm btn-default updateOutSchServiceInfo"
													href="#" data-toggle="modal"
													data-target="#updateOutSchService"
													data-updateOutSchServiceTeaCode="${teacher.teaCode}"
													data-UpdateOutSchServiceCode="${teacherOutSchService.teaDataContCode}"
													data-OutSchServiceDataPer="${teacherOutSchService.teaDataPer}"
													data-OutSchServiceDataCont="${teacherOutSchService.teaDataCont}">修改</a>
													<a
													class="btn btn-sm btn-danger deleteBtn deleteOutSchServiceInfo"
													href="#" data-toggle="modal"
													data-target="#deleteOutSchService"
													data-deleteOutSchServiceTeaCode="${teacher.teaCode}"
													data-deleteOutSchServiceCode="${teacherOutSchService.teaDataContCode}">刪除</a></td>
												<td>
													<!-- 暫未開發 -->
												</td>
											</tr>
										</tbody>
									</c:forEach>
								</table>

								<div class="clearfix"></div>
							</div>

							<!-- 擔任委員 -->
							<div class="tab-pane fade" id="asCommitMem">

								<a class="btn btn-default" href="#" data-toggle="modal"
									id="newAsCommitMemInfo" data-target="#newAsCommitMem"
									data-newAsCommitMemTeaCode="${teacher.teaCode}">新增</a>

								<div class="row margin-top-20"></div>

								<table class="table" width="100%">
									<thead class="thead-default">
										<tr>
											<th>期間</th>
											<th>內容</th>
											<th>編輯</th>
											<th>
												<!-- 更改顯示位置 -->
											</th>
										</tr>
									</thead>
									<c:forEach items="${teacherAsCommitMem}"
										var="teacherAsCommitMem">
										<tbody>
											<tr>
												<td>${teacherAsCommitMem.teaDataPer}</td>
												<td>${teacherAsCommitMem.teaDataCont}</td>
												<td><a
													class="btn btn-sm btn-default updateAsCommitMemInfo"
													href="#" data-toggle="modal"
													data-target="#updateAsCommitMem"
													data-updateAsCommitMemTeaCode="${teacher.teaCode}"
													data-UpdateAsCommitMemCode="${teacherAsCommitMem.teaDataContCode}"
													data-AsCommitMemDataPer="${teacherAsCommitMem.teaDataPer}"
													data-AsCommitMemDataCont="${teacherAsCommitMem.teaDataCont}">修改</a>
													<a
													class="btn btn-sm btn-danger deleteBtn deleteAsCommitMemInfo"
													href="#" data-toggle="modal"
													data-target="#deleteAsCommitMem"
													data-deleteAsCommitMemTeaCode="${teacher.teaCode}"
													data-deleteAsCommitMemCode="${teacherAsCommitMem.teaDataContCode}">刪除</a></td>
												<td>
													<!-- 暫未開發 -->
												</td>
											</tr>
										</tbody>
									</c:forEach>
								</table>

								<div class="clearfix"></div>
							</div>

							<!-- 學術經驗 -->
							<div class="tab-pane fade" id="scholarExp">

								<a class="btn btn-default" href="#" data-toggle="modal"
									id="newScholarExpInfo" data-target="#newScholarExp"
									data-newScholarExpTeaCode="${teacher.teaCode}">新增</a>

								<div class="row margin-top-20"></div>

								<table class="table" width="100%">
									<thead class="thead-default">
										<tr>
											<th>期間</th>
											<th>內容</th>
											<th>編輯</th>
											<th>
												<!-- 更改顯示位置 -->
											</th>
										</tr>
									</thead>
									<c:forEach items="${teacherScholarExp}" var="teacherScholarExp">
										<tbody>
											<tr>
												<td>${teacherScholarExp.teaDataPer}</td>
												<td>${teacherScholarExp.teaDataCont}</td>
												<td><a
													class="btn btn-sm btn-default updateScholarExpInfo"
													href="#" data-toggle="modal"
													data-target="#updateScholarExp"
													data-updateScholarExpTeaCode="${teacher.teaCode}"
													data-UpdateScholarExpCode="${teacherScholarExp.teaDataContCode}"
													data-ScholarExpDataPer="${teacherScholarExp.teaDataPer}"
													data-ScholarExpDataCont="${teacherScholarExp.teaDataCont}">修改</a>
													<a
													class="btn btn-sm btn-danger deleteBtn deleteScholarExpInfo"
													href="#" data-toggle="modal"
													data-target="#deleteScholarExp"
													data-deleteScholarExpTeaCode="${teacher.teaCode}"
													data-deleteScholarExpCode="${teacherScholarExp.teaDataContCode}">刪除</a></td>
												<td>
													<!-- 暫未開發 -->
												</td>
											</tr>
										</tbody>
									</c:forEach>
								</table>

								<div class="clearfix"></div>
							</div>
						</div>
					</div>
				</div>

			</div>
		</div>

		<%@include file="jspf/deleteTeacherDetailInfo.jspf"%>
		<%@include file="jspf/updateTeacherDetailInfo.jspf"%>
		<%@include file="jspf/newTeacherDetailInfo.jspf"%>

	</div>

</body>

<!-- JS -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script type="text/javascript" src="js/editTeacherDetailInfo.js"></script>
<script type="text/javascript" src="js/teacherDetailRank.js"></script>

<script type="text/javascript" src="js/jquery.min.js"
	type="text/javascript"></script>
<script type="text/javascript" src="js/bootstrap.min.js"
	type="text/javascript"></script>
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


