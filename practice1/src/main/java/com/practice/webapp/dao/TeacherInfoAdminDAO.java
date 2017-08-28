package com.practice.webapp.dao;

import java.util.List;

import com.practice.webapp.entity.teacher.RankInfo;
import com.practice.webapp.entity.teacher.ResearchTeacher;
import com.practice.webapp.entity.teacher.TeacherAwardInfo;
import com.practice.webapp.entity.teacher.TeacherBasicInfo;
import com.practice.webapp.entity.teacher.TeacherBasicInfoAdmin;
import com.practice.webapp.entity.teacher.TeacherEduInfo;
import com.practice.webapp.entity.teacher.TeacherExpInfo;
import com.practice.webapp.entity.teacher.TeacherOtherInfo;
import com.practice.webapp.entity.teacher.TeacherPlanInfo;
import com.practice.webapp.entity.teacher.TeacherSpeInfo;
import com.practice.webapp.entity.teacher.TeacherStuPaper;
import com.practice.webapp.entity.teacher.TeacherStuTopic;

public interface TeacherInfoAdminDAO {
	public List<TeacherBasicInfoAdmin> getProTeacherInfoList();// 獲取專任教師基本資料
	public List<TeacherBasicInfoAdmin> getPartTeacherInfoList();// 獲取兼任教師基本資料
	public List<TeacherBasicInfoAdmin> getSearchProTeacherInfoList(ResearchTeacher researchInfo);// 在搜索條件下獲取專任教師基本資料
	public List<TeacherBasicInfoAdmin> getSearchPartTeacherInfoList(ResearchTeacher researchInfo);// 在搜索條件下獲取兼任教師基本資料
	public void update(TeacherBasicInfoAdmin updateInfo);// 更新教師基本資料
	public void updateTeaPic(TeacherBasicInfoAdmin updateInfo, String picName);// 修改資料庫中教師照片名稱
	public void delete(TeacherBasicInfoAdmin deleteInfo);// 刪除教師（判定爲離校）
	public TeacherBasicInfoAdmin get(String teaCode);// 獲取特定教師的基本資料
	public void changeView(TeacherBasicInfoAdmin changeInfo);// 更改教師信息是否顯示在前端
	
	public boolean checkLDAP(TeacherBasicInfoAdmin newInfo);// 在新增教師基本信息之前需要驗證LDAP是否重複
	public TeacherBasicInfoAdmin newTeacherBasicInfo(TeacherBasicInfoAdmin newInfo);// 新增教師基本信息
	public List<TeacherBasicInfoAdmin> teacherShowList(String teaType);// 顯示目前教師在前端的顯示順序
	public void changeTeacherRank(List<RankInfo> rankInfo);// 修改教師的前端順序
	
	public List<TeacherEduInfo> getTeacherEduInfo(String teaCode);// 獲取特定教師的學歷資料
	public void deleteTeaEdu(TeacherBasicInfoAdmin teaInfo, TeacherEduInfo eduInfo);// 刪除指定學歷資料
	public void updateTeaEdu(TeacherBasicInfoAdmin teaInfo, TeacherEduInfo eduInfo);// 更新指定學歷資料
	public void newTeaEdu(TeacherBasicInfoAdmin teaInfo, TeacherEduInfo eduInfo);// 建立新的學歷資料

	public List<TeacherExpInfo> getTeacherExpInfo(String teaCode);// 獲取特定教師的經歷資料
	public void deleteTeaExp(TeacherBasicInfoAdmin teaInfo, TeacherExpInfo expInfo);// 刪除指定經歷資料
	public void updateTeaExp(TeacherBasicInfoAdmin teaInfo, TeacherExpInfo expInfo);// 更新指定經歷資料
	public void newTeaExp(TeacherBasicInfoAdmin teaInfo, TeacherExpInfo expInfo);// 建立新的經歷資料

	public List<TeacherAwardInfo> getTeacherAwardInfo(String teaCode);// 獲取特定教師的研究獎勵
	public void deleteTeaAwa(TeacherBasicInfoAdmin teaInfo, TeacherAwardInfo awaInfo);// 刪除指定研究獎勵
	public void updateTeaAwa(TeacherBasicInfoAdmin teaInfo, TeacherAwardInfo awaInfo);// 更新指定研究獎勵
	public void newTeaAwa(TeacherBasicInfoAdmin teaInfo, TeacherAwardInfo awaInfo);// 建立新的研究獎勵

	public List<TeacherSpeInfo> getTeacherSpeInfo(String teaCode);// 獲取特定教師的專長
	public void deleteTeaSpe(TeacherBasicInfoAdmin teaInfo, TeacherSpeInfo speInfo);// 刪除指定教師專長
	public void updateTeaSpe(TeacherBasicInfoAdmin teaInfo, TeacherSpeInfo speInfo);// 更新指定教師專長
	public void newTeaSpe(TeacherBasicInfoAdmin teaInfo, TeacherSpeInfo speInfo);// 新建教師專長

	public List<TeacherPlanInfo> getTeacherPlanInfo(String teaCode);// 獲取特定教師的研究計劃
	public void deleteTeaPlan(TeacherBasicInfoAdmin teaInfo, TeacherPlanInfo planInfo);// 刪除指定研究計劃
	public void updateTeaPlan(TeacherBasicInfoAdmin teaInfo, TeacherPlanInfo planInfo);// 更新指定研究計劃
	public void newTeaPlan(TeacherBasicInfoAdmin teaInfo, TeacherPlanInfo planInfo);// 新增研究計劃

	public List<TeacherStuPaper> getTeacherStuPaper(String teaCode);// 獲取特定教師的研究生論文
	public void deleteTeaStuPaper(TeacherBasicInfoAdmin teaInfo, TeacherStuPaper teaStuPaper);// 刪除指定教師的研究生論文
	public void updateTeaStuPaper(TeacherBasicInfoAdmin teaInfo, TeacherStuPaper teaStuPaper);// 更新指定教師的研究生論文
	public void newTeaStuPaper(TeacherBasicInfoAdmin teaInfo, TeacherStuPaper teaStuPaper);// 新增教師的研究生論文

	public List<TeacherStuTopic> getTeacherStuTopic(String teaCode);// 獲取特定教師的大學部專題
	public void deleteTeaStuTopic(TeacherBasicInfoAdmin teaInfo, TeacherStuTopic teaStuTopic);// 刪除指定教師的大學部專題
	public void updateTeaStuTopic(TeacherBasicInfoAdmin teaInfo, TeacherStuTopic teaStuTopic);// 更新指定教師的大學部專題
	public void newTeaStuTopic(TeacherBasicInfoAdmin teaInfo, TeacherStuTopic teaStuTopic);// 新增教師的大學部專題

	public List<TeacherOtherInfo> getIssuePaper(String teaCode);// 獲取特定教師的期刊論文
	public void deleteIssuePaper(TeacherBasicInfoAdmin teaInfo, TeacherOtherInfo issuePaper);// 刪除指定教師期刊論文
	public void updateIssuePaper(TeacherBasicInfoAdmin teaInfo, TeacherOtherInfo issuePaper);// 更新指定教師期刊論文
	public void newIssuePaper(TeacherBasicInfoAdmin teaInfo, TeacherOtherInfo issuePaper);// 新增教師期刊論文
	
	public List<TeacherOtherInfo> getMeetingPaper(String teaCode);// 獲取特定教師的研究會論文
	public void deleteMeetingPaper(TeacherBasicInfoAdmin teaInfo, TeacherOtherInfo meetingPaper);// 刪除指定教師的研究會論文
	public void updateMeetingPaper(TeacherBasicInfoAdmin teaInfo, TeacherOtherInfo meetingPaper);// 更新指定教師的研究會論文
	public void newMeetingPaper(TeacherBasicInfoAdmin teaInfo, TeacherOtherInfo meetingPaper);// 新增教師的研究會論文
	
	public List<TeacherOtherInfo> getBooks(String teaCode);// 獲取特定教師的書籍
	public void deleteBooks(TeacherBasicInfoAdmin teaInfo, TeacherOtherInfo books);// 刪除指定教師的書籍
	public void updateBooks(TeacherBasicInfoAdmin teaInfo, TeacherOtherInfo books);// 更新指定教師的書籍
	public void newBooks(TeacherBasicInfoAdmin teaInfo, TeacherOtherInfo books);// 新增教師的書籍
	
	public List<TeacherOtherInfo> getTechReport(String teaCode);// 獲取特定教師技術報告
	public void deleteTechReport(TeacherBasicInfoAdmin teaInfo, TeacherOtherInfo techReport);// 刪除指定教師的技術報告
	public void updateTechReport(TeacherBasicInfoAdmin teaInfo, TeacherOtherInfo techReport);// 更新指定教師的技術報告
	public void newTechReport(TeacherBasicInfoAdmin teaInfo, TeacherOtherInfo techReport);// 新增教師的技術報告

	public List<TeacherOtherInfo> getTecherPaper(String teaCode);// 獲取特定教師的畢業論文
	public void deleteTeacherpaper(TeacherBasicInfoAdmin teaInfo, TeacherOtherInfo teacherPaper);// 刪除指定教師的畢業論文
	public void updateTeacherPaper(TeacherBasicInfoAdmin teaInfo, TeacherOtherInfo teacherPaper);// 更新指定教師的畢業論文
	public void newTeacherPaper(TeacherBasicInfoAdmin teaInfo, TeacherOtherInfo teacherPaper);// 新增教師的畢業論文

	public List<TeacherOtherInfo> getMagazinePaper(String teaCode);// 獲取特定教師在資訊相關雜誌上近幾年發表的文章
	public void deleteMagazinePaper(TeacherBasicInfoAdmin teaInfo, TeacherOtherInfo magazinePaper);// 刪除指定教師的發表文章
	public void updateMagazinePaper(TeacherBasicInfoAdmin teaInfo, TeacherOtherInfo magazinePaper);// 更新指定教師的發表文章
	public void newMagazinePaper(TeacherBasicInfoAdmin teaInfo, TeacherOtherInfo magazinePaper);// 新增教師的發表文章

	public List<TeacherOtherInfo> getWaitingPaper(String teaCode);// 獲取特定教師期刊審查中論文
	public void deleteWaitingPaper(TeacherBasicInfoAdmin teaInfo, TeacherOtherInfo waitingPaper);// 刪除指定教師的審查中論文
	public void updateWaitingPaper(TeacherBasicInfoAdmin teaInfo, TeacherOtherInfo waitingPaper);// 更新指定教師的審查中論文
	public void newWaitingPaper(TeacherBasicInfoAdmin teaInfo, TeacherOtherInfo waitingPaper);// 新增教師的審查中論文

	public List<TeacherOtherInfo> getScholarPaper(String teaCode);// 獲取特定教師的學術著作
	public void deleteScholarPaper(TeacherBasicInfoAdmin teaInfo, TeacherOtherInfo scholarPaper);// 刪除指定教師的學術著作
	public void updateScholarPaper(TeacherBasicInfoAdmin teaInfo, TeacherOtherInfo scholarPaper);// 更新指定教師的學術著作
	public void newScholarPaper(TeacherBasicInfoAdmin teaInfo, TeacherOtherInfo scholarPaper);// 新增教師的學術著作

	public List<TeacherOtherInfo> getPracticeReach(String teaCode);// 獲取特定教師的實物研究內容
	public void deletePracticeReach(TeacherBasicInfoAdmin teaInfo, TeacherOtherInfo practiceReach);// 刪除指定教師的實務研究內容
	public void updatePracticeReach(TeacherBasicInfoAdmin teaInfo, TeacherOtherInfo practiceReach);// 更新指定教師的實務研究內容
	public void newPracticeReach(TeacherBasicInfoAdmin teaInfo, TeacherOtherInfo practiceReach);// 建立新的教師實務研究內容

	public List<TeacherOtherInfo> getOtherExp(String teaCode);// 獲取特定教師的其他教學經驗
	public void deleteOtherExp(TeacherBasicInfoAdmin teaInfo, TeacherOtherInfo otherExp);// 刪除指定教師的其他教學經驗
	public void updateOtherExp(TeacherBasicInfoAdmin teaInfo, TeacherOtherInfo otherExp);// 更新指定教師的其他教學經驗
	public void newOtherExp(TeacherBasicInfoAdmin teaInfo, TeacherOtherInfo otherExp);// 建立新的教師其他教學經驗

	public List<TeacherOtherInfo> getInSchService(String teaCode);// 獲取特定教師校內服務內容
	public void deleteInSchService(TeacherBasicInfoAdmin teaInfo, TeacherOtherInfo inSchService);// 刪除指定教師的校內服務內容
	public void updateInSchService(TeacherBasicInfoAdmin teaInfo, TeacherOtherInfo inSchService);// 更新指定教師的校內服務內容
	public void newInSchService(TeacherBasicInfoAdmin teaInfo, TeacherOtherInfo inSchService);// 建立新的教師校內服務內容

	public List<TeacherOtherInfo> getOutSchService(String teaCode);// 獲取特定教師校外服務內容
	public void deleteOutSchService(TeacherBasicInfoAdmin teaInfo, TeacherOtherInfo outSchService);// 刪除指定教師的校外服務內容
	public void updateOutSchService(TeacherBasicInfoAdmin teaInfo, TeacherOtherInfo outSchService);// 更新指定教師的校外服務內容
	public void newOutSchService(TeacherBasicInfoAdmin teaInfo, TeacherOtherInfo outSchService);// 建立新的教師校外服務內容

	public List<TeacherOtherInfo> getAsCommitMem(String teaCode);// 獲取特定教師擔任委員內容
	public void deleteAsCommitMem(TeacherBasicInfoAdmin teaInfo, TeacherOtherInfo asCommitMem);// 刪除指定教師擔任委員內容
	public void updateAsCommitMem(TeacherBasicInfoAdmin teaInfo, TeacherOtherInfo asCommitMem);// 更新指定教師的擔任委員內容
	public void newAsCommitMem(TeacherBasicInfoAdmin teaInfo, TeacherOtherInfo asCommitMem);// 建立新的教師擔任委員內容

	public List<TeacherOtherInfo> getScholarExp(String teaCode);// 獲取特定教師學術經驗內容
	public void deleteScholarExp(TeacherBasicInfoAdmin teaInfo, TeacherOtherInfo scholarExp);// 刪除指定教師學術經驗內容
	public void updateScholarExp(TeacherBasicInfoAdmin teaInfo, TeacherOtherInfo scholarExp);// 更新指定教師的學術經驗內容
	public void newScholarExp(TeacherBasicInfoAdmin teaInfo, TeacherOtherInfo scholarExp);// 建立新的教師學術經驗內容

}
