package com.practice.webapp.dao;

import java.util.List;


import com.practice.webapp.entity.teacher.TeacherAwardInfo;
import com.practice.webapp.entity.teacher.TeacherBasicInfo;
import com.practice.webapp.entity.teacher.TeacherEduInfo;
import com.practice.webapp.entity.teacher.TeacherExpInfo;
import com.practice.webapp.entity.teacher.TeacherOtherInfo;
import com.practice.webapp.entity.teacher.TeacherPlanInfo;
import com.practice.webapp.entity.teacher.TeacherSpeInfo;
import com.practice.webapp.entity.teacher.TeacherStuPaper;
import com.practice.webapp.entity.teacher.TeacherStuTopic;

public interface TeacherInfoDAO {
	public List<TeacherBasicInfo> getProTeacherInfoList();//獲取專任教師基本資料
	public List<TeacherBasicInfo> getPartTeacherInfoList();//獲取兼任教師基本資料
	public TeacherBasicInfo get(TeacherBasicInfo info);//獲取特定教師的基本資料
	public List<TeacherEduInfo> getTeacherEduInfo(TeacherBasicInfo info);//獲取特定教師的學歷資料
	public List<TeacherExpInfo> getTeacherExpInfo(TeacherBasicInfo info);//獲取特定教師的經歷資料
	public List<TeacherAwardInfo> getTeacherAwardInfo(TeacherBasicInfo info);//獲取特定教師的研究獎勵
	public List<TeacherSpeInfo> getTeacherSpeInfo(TeacherBasicInfo info);//獲取特定教師的專長
	public List<TeacherPlanInfo> getTeacherPlanInfo(TeacherBasicInfo info);//獲取特定教師的研究計劃
	public List<TeacherStuPaper> getTeacherStuPaper(TeacherBasicInfo info);//獲取特定教師的研究生論文
	public List<TeacherStuTopic> getTeacherStuTopic(TeacherBasicInfo info);//獲取特定教師的大學部專題
	public List<TeacherOtherInfo> getIssuePaper(TeacherBasicInfo info);//獲取特定教師的期刊論文
	public List<TeacherOtherInfo> getMeetingPaper(TeacherBasicInfo info);//獲取特定教師的研究會論文
	public List<TeacherOtherInfo> getBooks(TeacherBasicInfo info);//獲取特定教師的書籍
	public List<TeacherOtherInfo> getTechReport(TeacherBasicInfo info);//獲取特定教師技術報告
	public List<TeacherOtherInfo> getTecherPaper(TeacherBasicInfo info);//獲取特定教師的畢業論文
	public List<TeacherOtherInfo> getMagazinePaper(TeacherBasicInfo info);//獲取特定教師在資訊相關雜誌上近幾年發表的文章
	public List<TeacherOtherInfo> getWaitingPaper(TeacherBasicInfo info);//獲取特定教師期刊審查中論文
	public List<TeacherOtherInfo> getScholarPaper(TeacherBasicInfo info);//獲取特定教師的學術著作
	public List<TeacherOtherInfo> getPracticeReach(TeacherBasicInfo info);//獲取特定教師的實物研究內容
	public List<TeacherOtherInfo> getOtherExp(TeacherBasicInfo info);//獲取特定教師的其他教學經驗
	public List<TeacherOtherInfo> getInSchService(TeacherBasicInfo info);//獲取特定教師校內服務內容
	public List<TeacherOtherInfo> getOutSchService(TeacherBasicInfo info);//獲取特定教師校外服務內容
	public List<TeacherOtherInfo> getAsCommitMem(TeacherBasicInfo info);//獲取特定教師擔任委員內容
	public List<TeacherOtherInfo> getScholarExp(TeacherBasicInfo info);//獲取特定教師學術經驗內容
	
	
}
