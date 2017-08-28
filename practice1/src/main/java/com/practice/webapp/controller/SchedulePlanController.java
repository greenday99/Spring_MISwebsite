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

import com.practice.webapp.dao.SchedulePlanDAO;
import com.practice.webapp.entity.course.SchedulePlan;

@Controller
public class SchedulePlanController {
	ApplicationContext context =  new ClassPathXmlApplicationContext("spring-module.xml");
	
	@RequestMapping(value = "/scheduleplan", method = RequestMethod.GET)
	public ModelAndView getSchedulePlanList(){ 
		ModelAndView model = new ModelAndView("schedulePlan");
		SchedulePlanDAO scheduleplanDAO = (SchedulePlanDAO)context.getBean("scheduleplanDAO"); //bean用的id
		List<SchedulePlan> scheduleplanListU = new ArrayList<SchedulePlan>();
		List<SchedulePlan> scheduleplanListM = new ArrayList<SchedulePlan>();
		List<SchedulePlan> scheduleplanListF = new ArrayList<SchedulePlan>();
		List<SchedulePlan> scheduleplanListD = new ArrayList<SchedulePlan>();
		List<SchedulePlan> scheduleplanListE = new ArrayList<SchedulePlan>();
		scheduleplanListU = scheduleplanDAO.getSchedulePlanListU();
		scheduleplanListM = scheduleplanDAO.getSchedulePlanListM();
		scheduleplanListF = scheduleplanDAO.getSchedulePlanListF();
		scheduleplanListD = scheduleplanDAO.getSchedulePlanListD();
		scheduleplanListE = scheduleplanDAO.getSchedulePlanListE();
		model.addObject("scheduleplanListU", scheduleplanListU);
		model.addObject("scheduleplanListM", scheduleplanListM);
		model.addObject("scheduleplanListF", scheduleplanListF);
		model.addObject("scheduleplanListD", scheduleplanListD);
		model.addObject("scheduleplanListE", scheduleplanListE);
		return model;
	}
	
	@RequestMapping(value = "/admin/scheduleplan_manage", method = RequestMethod.GET)
	public ModelAndView getSchedulePlanList1(){ 
		ModelAndView model = new ModelAndView("schedulePlan_manage");
		SchedulePlanDAO scheduleplanDAO = (SchedulePlanDAO)context.getBean("scheduleplanDAO"); //bean用的id
		List<SchedulePlan> scheduleplanListU = new ArrayList<SchedulePlan>();
		List<SchedulePlan> scheduleplanListM = new ArrayList<SchedulePlan>();
		List<SchedulePlan> scheduleplanListF = new ArrayList<SchedulePlan>();
		List<SchedulePlan> scheduleplanListD = new ArrayList<SchedulePlan>();
		List<SchedulePlan> scheduleplanListE = new ArrayList<SchedulePlan>();
		List<SchedulePlan> planList = new ArrayList<SchedulePlan>();
		scheduleplanListU = scheduleplanDAO.getSchedulePlanListU();
		scheduleplanListM = scheduleplanDAO.getSchedulePlanListM();
		scheduleplanListF = scheduleplanDAO.getSchedulePlanListF();
		scheduleplanListD = scheduleplanDAO.getSchedulePlanListD();
		scheduleplanListE = scheduleplanDAO.getSchedulePlanListE();
		planList = scheduleplanDAO.getPlanList();
		model.addObject("scheduleplanListU", scheduleplanListU);
		model.addObject("scheduleplanListM", scheduleplanListM);
		model.addObject("scheduleplanListF", scheduleplanListF);
		model.addObject("scheduleplanListD", scheduleplanListD);
		model.addObject("scheduleplanListE", scheduleplanListE);
		model.addObject("planList", planList);
		return model;
	}
	
	@RequestMapping(value = "/admin/updateScheduleplan", method = RequestMethod.POST)
	public ModelAndView updateScheduleplan(@ModelAttribute SchedulePlan scheduleplan){
		ModelAndView model = new ModelAndView("redirect:/admin/scheduleplan_manage");
		SchedulePlanDAO scheduleplanDAO = (SchedulePlanDAO)context.getBean("scheduleplanDAO");
		scheduleplanDAO.update(scheduleplan);
		
		return model;
	}
}
