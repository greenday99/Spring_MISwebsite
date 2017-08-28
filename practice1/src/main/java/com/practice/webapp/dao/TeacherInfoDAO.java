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
	public List<TeacherBasicInfo> getProTeacherInfoList();//����M���Юv�򥻸��
	public List<TeacherBasicInfo> getPartTeacherInfoList();//����ݥ��Юv�򥻸��
	public TeacherBasicInfo get(TeacherBasicInfo info);//����S�w�Юv���򥻸��
	public List<TeacherEduInfo> getTeacherEduInfo(TeacherBasicInfo info);//����S�w�Юv���Ǿ����
	public List<TeacherExpInfo> getTeacherExpInfo(TeacherBasicInfo info);//����S�w�Юv���g�����
	public List<TeacherAwardInfo> getTeacherAwardInfo(TeacherBasicInfo info);//����S�w�Юv����s���y
	public List<TeacherSpeInfo> getTeacherSpeInfo(TeacherBasicInfo info);//����S�w�Юv���M��
	public List<TeacherPlanInfo> getTeacherPlanInfo(TeacherBasicInfo info);//����S�w�Юv����s�p��
	public List<TeacherStuPaper> getTeacherStuPaper(TeacherBasicInfo info);//����S�w�Юv����s�ͽפ�
	public List<TeacherStuTopic> getTeacherStuTopic(TeacherBasicInfo info);//����S�w�Юv���j�ǳ��M�D
	public List<TeacherOtherInfo> getIssuePaper(TeacherBasicInfo info);//����S�w�Юv�����Z�פ�
	public List<TeacherOtherInfo> getMeetingPaper(TeacherBasicInfo info);//����S�w�Юv����s�|�פ�
	public List<TeacherOtherInfo> getBooks(TeacherBasicInfo info);//����S�w�Юv�����y
	public List<TeacherOtherInfo> getTechReport(TeacherBasicInfo info);//����S�w�Юv�޳N���i
	public List<TeacherOtherInfo> getTecherPaper(TeacherBasicInfo info);//����S�w�Юv�����~�פ�
	public List<TeacherOtherInfo> getMagazinePaper(TeacherBasicInfo info);//����S�w�Юv�b��T�������x�W��X�~�o���峹
	public List<TeacherOtherInfo> getWaitingPaper(TeacherBasicInfo info);//����S�w�Юv���Z�f�d���פ�
	public List<TeacherOtherInfo> getScholarPaper(TeacherBasicInfo info);//����S�w�Юv���ǳN�ۧ@
	public List<TeacherOtherInfo> getPracticeReach(TeacherBasicInfo info);//����S�w�Юv���ꪫ��s���e
	public List<TeacherOtherInfo> getOtherExp(TeacherBasicInfo info);//����S�w�Юv����L�оǸg��
	public List<TeacherOtherInfo> getInSchService(TeacherBasicInfo info);//����S�w�Юv�դ��A�Ȥ��e
	public List<TeacherOtherInfo> getOutSchService(TeacherBasicInfo info);//����S�w�Юv�ե~�A�Ȥ��e
	public List<TeacherOtherInfo> getAsCommitMem(TeacherBasicInfo info);//����S�w�Юv����e�����e
	public List<TeacherOtherInfo> getScholarExp(TeacherBasicInfo info);//����S�w�Юv�ǳN�g�示�e
	
	
}
