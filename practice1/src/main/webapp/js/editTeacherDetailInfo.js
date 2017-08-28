//學歷
$(function() {
	$("#newEduInfo").click(function() {
		$("#newEduTeaCode").val($(this).attr("data-newEduTeaCode"));
	});
});

$(function() {
	$(".updateTeaEduInfo").click(function() {
		$("#updateEduTeaCode").val($(this).attr("data-updateEduTeaCode"));
		$("#updateEduCode").val($(this).attr("data-updateEduCode"));
		$("#updateEduTeaSch").val($(this).attr("data-eduSch"));
		$("#updateEduTeaDep").val($(this).attr("data-eduDep"));
		$("#updateEduTeaDeg").val($(this).attr("data-eduDeg"));
	});
});

$(function() {
	$(".deleteTeaEduInfo").click(function() {
		$("#deleteEduTeaCode").val($(this).attr("data-deleteEduTeaCode"));
		$("#deleteEduCode").val($(this).attr("data-deleteEduCode"));
	});
});

// 經歷
$(function() {
	$("#newTeaExpInfo").click(function() {
		$("#newExpTeaCode").val($(this).attr("data-newExpTeaCode"));
	});
});

$(function() {
	$(".updateTeaExpInfo").click(function() {
		$("#updateExpTeaCode").val($(this).attr("data-updateExpTeaCode"));
		$("#updateTeaExpCode").val($(this).attr("data-UpdateTeaExpCode"));
		$("#updateTeaExpPer").val($(this).attr("data-per"));
		$("#updateTeaExpUnit").val($(this).attr("data-unit"));
		$("#updateTeaExpDep").val($(this).attr("data-dep"));
		$("#updateTeaExpTitle").val($(this).attr("data-title"));
	});
});

$(function() {
	$(".deleteTeaExpInfo").click(function() {
		$("#deleteExpTeaCode").val($(this).attr("data-deleteExpTeaCode"));
		$("#deleteTeaExpCode").val($(this).attr("data-deleteTeaExpCode"));
	});
});

// 專長
$(function() {
	$("#newSpeInfo").click(function() {
		$("#newSpeTeaCode").val($(this).attr("data-newSpeTeaCode"));
	});
});

$(function() {
	$(".updateTeaSpeInfo").click(function() {
		$("#updateSpeTeaCode").val($(this).attr("data-updateSpeTeaCode"));
		$("#updateTeaSpeCode").val($(this).attr("data-updateTeaSpeCode"));
		$("#updateTeaSpeContent").val($(this).attr("data-updateTeaSpe"));
	});
});

$(function() {
	$(".deleteTeaSpeInfo").click(function() {
		$("#deleteSpeTeaCode").val($(this).attr("data-deleteSpeTeaCode"));
		$("#deleteTeaSpeCode").val($(this).attr("data-deleteSpeExpCode"));
	});
});

// 期刊論文
$(function() {
	$("#newIssuePaperInfo").click(
			function() {
				$("#newIssuePaperTeaCode").val(
						$(this).attr("data-newIssuePaperTeaCode"));
			});
});

$(function() {
	$(".updateIssuePaperInfo").click(
			function() {
				$("#updateIssuePaperTeaCode").val(
						$(this).attr("data-updateIssuePaperTeaCode"));
				$("#updateIssuePaperCode").val(
						$(this).attr("data-updateIssuePaperCode"));
				$("#IssuePaperDataPer").val(
						$(this).attr("data-IssuePaperDataPer"));
				$("#IssuePaperDataCont").val(
						$(this).attr("data-IssuePaperDataCont"));
			});
});

$(function() {
	$(".deleteIssuePaperInfo").click(
			function() {
				$("#deleteIssuePaperTeaCode").val(
						$(this).attr("data-deleteIssuePaperTeaCode"));
				$("#deleteIssuePaperCode").val(
						$(this).attr("data-deleteIssuePaperCode"));
			});
});

// 研討會論文
$(function() {
	$("#newMeetingPaperInfo").click(
			function() {
				$("#newMeetingPaperTeaCode").val(
						$(this).attr("data-newMeetingPaperTeaCode"));
			});
});

$(function() {
	$(".updateMeetingPaperInfo").click(
			function() {
				$("#updateMeetingPaperTeaCode").val(
						$(this).attr("data-updateMeetingPaperTeaCode"));
				$("#updateMeetingPaperCode").val(
						$(this).attr("data-updateMeetingPaperCode"));
				$("#MeetingPaperDataPer").val(
						$(this).attr("data-MeetingPaperDataPer"));
				$("#MeetingPaperDataCont").val(
						$(this).attr("data-MeetingPaperDataCont"));
			});
});

$(function() {
	$(".deleteMeetingPaperInfo").click(
			function() {
				$("#deleteMeetingPaperTeaCode").val(
						$(this).attr("data-deleteMeetingPaperTeaCode"));
				$("#deleteMeetingPaperCode").val(
						$(this).attr("data-deleteMeetingPaperCode"));
			});
});

// 書籍
$(function() {
	$("#newBooksInfo").click(function() {
		$("#newBooksTeaCode").val($(this).attr("data-newBooksTeaCode"));
	});
});

$(function() {
	$(".updateBooksInfo").click(function() {
		$("#updateBooksTeaCode").val($(this).attr("data-updateBooksTeaCode"));
		$("#updateBooksCode").val($(this).attr("data-updateBooksCode"));
		$("#BooksDataPer").val($(this).attr("data-BooksDataPer"));
		$("#BooksDataCont").val($(this).attr("data-BooksDataCont"));
	});
});

$(function() {
	$(".deleteBooksInfo").click(function() {
		$("#deleteBooksTeaCode").val($(this).attr("data-deleteBooksTeaCode"));
		$("#deleteBooksCode").val($(this).attr("data-deleteBooksCode"));
	});
});

// 技術報告
$(function() {
	$("#newTechReportInfo").click(
			function() {
				$("#newTechReportTeaCode").val(
						$(this).attr("data-newTechReportTeaCode"));
			});
});

$(function() {
	$(".updateTechReportInfo").click(
			function() {
				$("#updateTechReportTeaCode").val(
						$(this).attr("data-updateTechReportTeaCode"));
				$("#updateTechReportCode").val(
						$(this).attr("data-updateTechReportCode"));
				$("#TechReportDataPer").val(
						$(this).attr("data-TechReportDataPer"));
				$("#TechReportDataCont").val(
						$(this).attr("data-TechReportDataCont"));
			});
});

$(function() {
	$(".deleteTechReportInfo").click(
			function() {
				$("#deleteTechReportTeaCode").val(
						$(this).attr("data-deleteTechReportTeaCode"));
				$("#deleteTechReportCode").val(
						$(this).attr("data-deleteTechReportCode"));
			});
});

// 畢業論文
$(function() {
	$("#newTeacherPaperInfo").click(
			function() {
				$("#newTeacherPaperTeaCode").val(
						$(this).attr("data-newTeacherPaperTeaCode"));
			});
});

$(function() {
	$(".updateTeacherPaperInfo").click(
			function() {
				$("#updateTeacherPaperTeaCode").val(
						$(this).attr("data-updateTeacherPaperTeaCode"));
				$("#updateTeacherPaperCode").val(
						$(this).attr("data-updateTeacherPaperCode"));
				$("#TeacherPaperDataPer").val(
						$(this).attr("data-TeacherPaperDataPer"));
				$("#TeacherPaperDataCont").val(
						$(this).attr("data-TeacherPaperDataCont"));
			});
});

$(function() {
	$(".deleteTeacherPaperInfo").click(
			function() {
				$("#deleteTeacherPaperTeaCode").val(
						$(this).attr("data-deleteTeacherPaperTeaCode"));
				$("#deleteTeacherPaperCode").val(
						$(this).attr("data-deleteTeacherPaperCode"));
			});
});

// 在資訊相關雜誌上近幾年發表之文章
$(function() {
	$("#newMagazinePaperInfo").click(
			function() {
				$("#newMagazinePaperTeaCode").val(
						$(this).attr("data-newMagazinePaperTeaCode"));
			});
});

$(function() {
	$(".updateMagazinePaperInfo").click(
			function() {
				$("#updateMagazinePaperTeaCode").val(
						$(this).attr("data-updateMagazinePaperTeaCode"));
				$("#updateMagazinePaperCode").val(
						$(this).attr("data-updateMagazinePaperCode"));
				$("#MagazinePaperDataPer").val(
						$(this).attr("data-MagazinePaperDataPer"));
				$("#MagazinePaperDataCont").val(
						$(this).attr("data-MagazinePaperDataCont"));
			});
});

$(function() {
	$(".deleteMagazinePaperInfo").click(
			function() {
				$("#deleteMagazinePaperTeaCode").val(
						$(this).attr("data-deleteMagazinePaperTeaCode"));
				$("#deleteMagazinePaperCode").val(
						$(this).attr("data-deleteMagazinePaperCode"));
			});
});

// 期刊審查中論文
$(function() {
	$("#newWaitingPaperInfo").click(
			function() {
				$("#newWaitingPaperTeaCode").val(
						$(this).attr("data-newWaitingPaperTeaCode"));
			});
});

$(function() {
	$(".updateWaitingPaperInfo").click(
			function() {
				$("#updateWaitingPaperTeaCode").val(
						$(this).attr("data-updateWaitingPaperTeaCode"));
				$("#updateWaitingPaperCode").val(
						$(this).attr("data-updateWaitingPaperCode"));
				$("#WaitingPaperDataPer").val(
						$(this).attr("data-WaitingPaperDataPer"));
				$("#WaitingPaperDataCont").val(
						$(this).attr("data-WaitingPaperDataCont"));
			});
});

$(function() {
	$(".deleteWaitingPaperInfo").click(
			function() {
				$("#deleteWaitingPaperTeaCode").val(
						$(this).attr("data-deleteWaitingPaperTeaCode"));
				$("#deleteWaitingPaperCode").val(
						$(this).attr("data-deleteWaitingPaperCode"));
			});
});

// 學術著作
$(function() {
	$("#newScholarPaperInfo").click(
			function() {
				$("#newScholarPaperTeaCode").val(
						$(this).attr("data-newScholarPaperTeaCode"));
			});
});

$(function() {
	$(".updateScholarPaperInfo").click(
			function() {
				$("#updateScholarPaperTeaCode").val(
						$(this).attr("data-updateScholarPaperTeaCode"));
				$("#updateScholarPaperCode").val(
						$(this).attr("data-updateScholarPaperCode"));
				$("#ScholarPaperDataPer").val(
						$(this).attr("data-ScholarPaperDataPer"));
				$("#ScholarPaperDataCont").val(
						$(this).attr("data-ScholarPaperDataCont"));
			});
});

$(function() {
	$(".deleteScholarPaperInfo").click(
			function() {
				$("#deleteScholarPaperTeaCode").val(
						$(this).attr("data-deleteScholarPaperTeaCode"));
				$("#deleteScholarPaperCode").val(
						$(this).attr("data-deleteScholarPaperCode"));
			});
});

// 研究獎勵
$(function() {
	$("#newTeaAwaInfo").click(function() {
		$("#newTeaAwaTeaCode").val($(this).attr("data-newTeaAwaTeaCode"));
	});
});

$(function() {
	$(".updateTeaAwaInfo").click(
			function() {
				$("#updateTeaAwaTeaCode").val(
						$(this).attr("data-updateTeaAwaTeaCode"));
				$("#updateTeaAwaCode").val(
						$(this).attr("data-updateTeaAwaCode"));
				$("#teaAwaYear").val($(this).attr("data-teaAwaYear"));
				$("#teaAwaDep").val($(this).attr("data-teaAwaDep"));
				$("#teaAwaInfo").val($(this).attr("data-teaAwaInfo"));
			});
});

$(function() {
	$(".deleteTeaAwaInfo").click(
			function() {
				$("#deleteTeaAwaTeaCode").val(
						$(this).attr("data-deleteTeaAwaTeaCode"));
				$("#deleteTeaAwaCode").val(
						$(this).attr("data-deleteTeaAwaCode"));
			});
});

// 研究計劃
$(function() {
	$("#newTeaPlanInfo").click(function() {
		$("#newTeaPlanTeaCode").val($(this).attr("data-newTeaPlanTeaCode"));
	});
});

$(function() {
	$(".updateTeaPlanInfo").click(
			function() {
				$("#updateTeaPlanTeaCode").val(
						$(this).attr("data-updateTeaPlanTeaCode"));
				$("#updateTeaPlanCode").val(
						$(this).attr("data-updateTeaPlanCode"));
				$("#teaPlanPer").val($(this).attr("data-teaPlanPer"));
				$("#teaPlanLeader").val($(this).attr("data-teaPlanLeader"));
				$("#teaPlanName").val($(this).attr("data-teaPlanName"));
				$("#teaPlanSpon").val($(this).attr("data-teaPlanSpon"));
				$("#teaPlanMon").val($(this).attr("data-teaPlanMon"));
				$("#teaPlanPos").val($(this).attr("data-teaPlanPos"));
			});
});

$(function() {
	$(".deleteTeaPlanInfo").click(
			function() {
				$("#deleteTeaPlanTeaCode").val(
						$(this).attr("data-deleteTeaPlanTeaCode"));
				$("#deleteTeaPlanCode").val(
						$(this).attr("data-deleteTeaPlanCode"));
			});
});

// 實務研究
$(function() {
	$("#newPracticalInfo").click(
			function() {
				$("#newPracticalTeaCode").val(
						$(this).attr("data-newPracticalTeaCode"));
			});
});

$(function() {
	$(".updatePracticalInfo").click(
			function() {
				$("#updatePracticalTeaCode").val(
						$(this).attr("data-updatePracticalTeaCode"));
				$("#UpdatePracticalCode").val(
						$(this).attr("data-UpdatePracticalCode"));
				$("#PracticalDataPer").val(
						$(this).attr("data-PracticalDataPer"));
				$("#PracticalDataCont").val(
						$(this).attr("data-PracticalDataCont"));
			});
});

$(function() {
	$(".deletePracticalInfo").click(
			function() {
				$("#deletePracticalTeaCode").val(
						$(this).attr("data-deletePracticalTeaCode"));
				$("#deletePracticalCode").val(
						$(this).attr("data-deletePracticalCode"));
			});
});

// 指導學生專題
$(function() {
	$("#newTeaStuTopicInfo").click(
			function() {
				$("#newTeaStuTopicTeaCode").val(
						$(this).attr("data-newTeaStuTopicTeaCode"));
			});
});

$(function() {
	$(".updateTeaStuTopicInfo").click(
			function() {
				$("#updateTeaStuTopicTeaCode").val(
						$(this).attr("data-updateTeaStuTopicTeaCode"));
				$("#UpdateTeaStuTopicCode").val(
						$(this).attr("data-UpdateTeaStuTopicCode"));
				$("#teaStuYear").val($(this).attr("data-teaStuYear"));
				$("#teaStuName").val($(this).attr("data-teaStuName"));
			});
});

$(function() {
	$(".deleteTeaStuTopicInfo").click(
			function() {
				$("#deleteTeaStuTopicTeaCode").val(
						$(this).attr("data-deleteTeaStuTopicTeaCode"));
				$("#deleteTeaStuTopicCode").val(
						$(this).attr("data-deleteTeaStuTopicCode"));
			});
});

// 指導研究生論文
$(function() {
	$("#newTeaStuPaperInfo").click(
			function() {
				$("#newTeaStuPaperTeaCode").val(
						$(this).attr("data-newTeaStuPaperTeaCode"));
			});
});

$(function() {
	$(".updateTeaStuPaperInfo")
			.click(
					function() {
						$("#updateTeaStuPaperTeaCode").val(
								$(this).attr("data-updateTeaStuPaperTeaCode"));
						$("#UpdateTeaStuPaperCode").val(
								$(this).attr("data-UpdateTeaStuPaperCode"));
						$("#teaGraduateStuYear").val(
								$(this).attr("data-teaGraduateStuYear"));
						$("#teaGraduateStuName").val(
								$(this).attr("data-teaGraduateStuName"));
						$("#teaStuPaperName").val(
								$(this).attr("data-teaStuPaperName"));
					});
});

$(function() {
	$(".deleteTeaStuPaperInfo").click(
			function() {
				$("#deleteTeaStuPaperTeaCode").val(
						$(this).attr("data-deleteTeaStuPaperTeaCode"));
				$("#deleteTeaStuPaperCode").val(
						$(this).attr("data-deleteTeaStuPaperCode"));
			});
});

// 其他教學經驗
$(function() {
	$("#newOtherTeaExpInfo").click(
			function() {
				$("#newOtherTeaExpTeaCode").val(
						$(this).attr("data-newOtherTeaExpTeaCode"));
			});
});

$(function() {
	$(".updateOtherTeaExpInfo").click(
			function() {
				$("#updateOtherTeaExpTeaCode").val(
						$(this).attr("data-updateOtherTeaExpTeaCode"));
				$("#UpdateOtherTeaExpCode").val(
						$(this).attr("data-UpdateOtherTeaExpCode"));
				$("#OtherTeaExpDataPer").val(
						$(this).attr("data-OtherTeaExpDataPer"));
				$("#OtherTeaExpDataCont").val(
						$(this).attr("data-OtherTeaExpDataCont"));
			});
});

$(function() {
	$(".deleteOtherTeaExpInfo").click(
			function() {
				$("#deleteOtherTeaExpTeaCode").val(
						$(this).attr("data-deleteOtherTeaExpTeaCode"));
				$("#deleteOtherTeaExpCode").val(
						$(this).attr("data-deleteOtherTeaExpCode"));
			});
});

// 校內服務內容
$(function() {
	$("#newInSchServiceInfo").click(
			function() {
				$("#newInSchServiceTeaCode").val(
						$(this).attr("data-newInSchServiceTeaCode"));
			});
});

$(function() {
	$(".updateInSchServiceInfo").click(
			function() {
				$("#updateInSchServiceTeaCode").val(
						$(this).attr("data-updateInSchServiceTeaCode"));
				$("#UpdateInSchServiceCode").val(
						$(this).attr("data-UpdateInSchServiceCode"));
				$("#InSchServiceDataPer").val(
						$(this).attr("data-InSchServiceDataPer"));
				$("#InSchServiceDataCont").val(
						$(this).attr("data-InSchServiceDataCont"));
			});
});

$(function() {
	$(".deleteInSchServiceInfo").click(
			function() {
				$("#deleteInSchServiceTeaCode").val(
						$(this).attr("data-deleteInSchServiceTeaCode"));
				$("#deleteInSchServiceCode").val(
						$(this).attr("data-deleteInSchServiceCode"));
			});
});

// 校外服務信息
$(function() {
	$("#newOutSchServiceInfo").click(
			function() {
				$("#newOutSchServiceTeaCode").val(
						$(this).attr("data-newOutSchServiceTeaCode"));
			});
});

$(function() {
	$(".updateOutSchServiceInfo").click(
			function() {
				$("#updateOutSchServiceTeaCode").val(
						$(this).attr("data-updateOutSchServiceTeaCode"));
				$("#UpdateOutSchServiceCode").val(
						$(this).attr("data-UpdateOutSchServiceCode"));
				$("#OutSchServiceDataPer").val(
						$(this).attr("data-OutSchServiceDataPer"));
				$("#OutSchServiceDataCont").val(
						$(this).attr("data-OutSchServiceDataCont"));
			});
});

$(function() {
	$(".deleteOutSchServiceInfo").click(
			function() {
				$("#deleteOutSchServiceTeaCode").val(
						$(this).attr("data-deleteOutSchServiceTeaCode"));
				$("#deleteOutSchServiceCode").val(
						$(this).attr("data-deleteOutSchServiceCode"));
			});
});

// 擔任委員
$(function() {
	$("#newAsCommitMemInfo").click(
			function() {
				$("#newAsCommitMemTeaCode").val(
						$(this).attr("data-newAsCommitMemTeaCode"));
			});
});

$(function() {
	$(".updateAsCommitMemInfo").click(
			function() {
				$("#updateAsCommitMemTeaCode").val(
						$(this).attr("data-updateAsCommitMemTeaCode"));
				$("#UpdateAsCommitMemCode").val(
						$(this).attr("data-UpdateAsCommitMemCode"));
				$("#AsCommitMemDataPer").val(
						$(this).attr("data-AsCommitMemDataPer"));
				$("#AsCommitMemDataCont").val(
						$(this).attr("data-AsCommitMemDataCont"));
			});
});

$(function() {
	$(".deleteAsCommitMemInfo").click(
			function() {
				$("#deleteAsCommitMemTeaCode").val(
						$(this).attr("data-deleteAsCommitMemTeaCode"));
				$("#deleteAsCommitMemCode").val(
						$(this).attr("data-deleteAsCommitMemCode"));
			});
});

// 學術經驗
$(function() {
	$("#newScholarExpInfo").click(
			function() {
				$("#newScholarExpTeaCode").val(
						$(this).attr("data-newScholarExpTeaCode"));
			});
});

$(function() {
	$(".updateScholarExpInfo").click(
			function() {
				$("#updateScholarExpTeaCode").val(
						$(this).attr("data-updateScholarExpTeaCode"));
				$("#UpdateScholarExpCode").val(
						$(this).attr("data-UpdateScholarExpCode"));
				$("#ScholarExpDataPer").val(
						$(this).attr("data-ScholarExpDataPer"));
				$("#ScholarExpDataCont").val(
						$(this).attr("data-ScholarExpDataCont"));
			});
});

$(function() {
	$(".deleteScholarExpInfo").click(
			function() {
				$("#deleteScholarExpTeaCode").val(
						$(this).attr("data-deleteScholarExpTeaCode"));
				$("#deleteScholarExpCode").val(
						$(this).attr("data-deleteScholarExpCode"));
			});
});
