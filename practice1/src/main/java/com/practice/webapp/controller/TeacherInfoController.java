package com.practice.webapp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.practice.webapp.dao.TeacherInfoDAO;
import com.practice.webapp.entity.teacher.TeacherAwardInfo;
import com.practice.webapp.entity.teacher.TeacherBasicInfo;
import com.practice.webapp.entity.teacher.TeacherEduInfo;
import com.practice.webapp.entity.teacher.TeacherExpInfo;
import com.practice.webapp.entity.teacher.TeacherOtherInfo;
import com.practice.webapp.entity.teacher.TeacherPlanInfo;
import com.practice.webapp.entity.teacher.TeacherSpeInfo;
import com.practice.webapp.entity.teacher.TeacherStuPaper;
import com.practice.webapp.entity.teacher.TeacherStuTopic;

@Controller
public class TeacherInfoController {
	ApplicationContext context = new ClassPathXmlApplicationContext("spring-module.xml");

	@RequestMapping(value = "/teacherInfo", method = RequestMethod.GET)
	public ModelAndView getTeacherInfo() {
		ModelAndView model = new ModelAndView("teacherInfo");
		TeacherInfoDAO teacherInfoDAO = (TeacherInfoDAO) context.getBean("teacherInfoDAO");
		// 專任教師
		List<TeacherBasicInfo> proTeacherList = new ArrayList<TeacherBasicInfo>();
		proTeacherList = teacherInfoDAO.getProTeacherInfoList();
		model.addObject("proTeacherList", proTeacherList);
		// 兼任教師
		List<TeacherBasicInfo> partTeacherList = new ArrayList<TeacherBasicInfo>();
		partTeacherList = teacherInfoDAO.getPartTeacherInfoList();
		model.addObject("partTeacherList", partTeacherList);
		return model;
	}

	@RequestMapping(value = "/teacherDetailInfo", method = RequestMethod.GET)
	// 教師詳細信息
	public ModelAndView teacherDetailInfoPage(@ModelAttribute TeacherBasicInfo teacherBasicInfo) {
		List<TeacherEduInfo> teacherEduInfo = new ArrayList<TeacherEduInfo>();
		List<TeacherExpInfo> teacherExpInfo = new ArrayList<TeacherExpInfo>();
		List<TeacherSpeInfo> teacherSpeInfo = new ArrayList<TeacherSpeInfo>();
		List<TeacherAwardInfo> teacherAwardInfo = new ArrayList<TeacherAwardInfo>();
		List<TeacherPlanInfo> teacherPlanInfo = new ArrayList<TeacherPlanInfo>();
		List<TeacherStuPaper> teacherStuPaper = new ArrayList<TeacherStuPaper>();
		List<TeacherStuTopic> teacherStuTopic = new ArrayList<TeacherStuTopic>();
		List<TeacherOtherInfo> teacherOtherInfo = new ArrayList<TeacherOtherInfo>();

		ModelAndView model = new ModelAndView("teacherDetailInfo");
		TeacherInfoDAO teacherInfoDAO = (TeacherInfoDAO) context.getBean("teacherInfoDAO");
		teacherBasicInfo = teacherInfoDAO.get(teacherBasicInfo);
		model.addObject("teacherBasicInfo", teacherBasicInfo);
		teacherEduInfo = teacherInfoDAO.getTeacherEduInfo(teacherBasicInfo);
		model.addObject("teacherEduInfo", teacherEduInfo);
		teacherExpInfo = teacherInfoDAO.getTeacherExpInfo(teacherBasicInfo);
		model.addObject("teacherExpInfo", teacherExpInfo);
		teacherSpeInfo = teacherInfoDAO.getTeacherSpeInfo(teacherBasicInfo);
		model.addObject("teacherSpeInfo", teacherSpeInfo);
		teacherAwardInfo = teacherInfoDAO.getTeacherAwardInfo(teacherBasicInfo);
		model.addObject("teacherAwardInfo", teacherAwardInfo);
		teacherPlanInfo = teacherInfoDAO.getTeacherPlanInfo(teacherBasicInfo);
		model.addObject("teacherPlanInfo", teacherPlanInfo);
		teacherStuPaper = teacherInfoDAO.getTeacherStuPaper(teacherBasicInfo);
		model.addObject("teacherStuPaper", teacherStuPaper);
		teacherStuTopic = teacherInfoDAO.getTeacherStuTopic(teacherBasicInfo);
		model.addObject("teacherStuTopic", teacherStuTopic);
		teacherOtherInfo = teacherInfoDAO.getIssuePaper(teacherBasicInfo);
		model.addObject("teacherIssuePaper", teacherOtherInfo);
		teacherOtherInfo = teacherInfoDAO.getMeetingPaper(teacherBasicInfo);
		model.addObject("teacherMeetingPaper", teacherOtherInfo);
		teacherOtherInfo = teacherInfoDAO.getBooks(teacherBasicInfo);
		model.addObject("teacherBooks", teacherOtherInfo);
		teacherOtherInfo = teacherInfoDAO.getTechReport(teacherBasicInfo);
		model.addObject("teacherTechReport", teacherOtherInfo);
		teacherOtherInfo = teacherInfoDAO.getTecherPaper(teacherBasicInfo);
		model.addObject("teacherPaper", teacherOtherInfo);
		teacherOtherInfo = teacherInfoDAO.getMagazinePaper(teacherBasicInfo);
		model.addObject("teacherMagazinePaper", teacherOtherInfo);
		teacherOtherInfo = teacherInfoDAO.getWaitingPaper(teacherBasicInfo);
		model.addObject("teacherWaitingPaper", teacherOtherInfo);
		teacherOtherInfo = teacherInfoDAO.getScholarPaper(teacherBasicInfo);
		model.addObject("teacherScholarPaper", teacherOtherInfo);
		teacherOtherInfo = teacherInfoDAO.getPracticeReach(teacherBasicInfo);
		model.addObject("teacherPracticeReach", teacherOtherInfo);
		teacherOtherInfo = teacherInfoDAO.getOtherExp(teacherBasicInfo);
		model.addObject("teacherOtherExp", teacherOtherInfo);
		teacherOtherInfo = teacherInfoDAO.getInSchService(teacherBasicInfo);
		model.addObject("teacherInSchService", teacherOtherInfo);
		teacherOtherInfo = teacherInfoDAO.getOutSchService(teacherBasicInfo);
		model.addObject("teacherOutSchService", teacherOtherInfo);
		teacherOtherInfo = teacherInfoDAO.getAsCommitMem(teacherBasicInfo);
		model.addObject("teacherAsCommitMem", teacherOtherInfo);
		teacherOtherInfo = teacherInfoDAO.getScholarExp(teacherBasicInfo);
		model.addObject("teacherScholarExp", teacherOtherInfo);

		return model;
	}
}
