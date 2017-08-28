package com.practice.webapp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.practice.webapp.dao.CourseruleDAO;
import com.practice.webapp.entity.course.Courserule;

@Controller
public class CourseruleController {
ApplicationContext context =  new ClassPathXmlApplicationContext("spring-module.xml");
	
	@RequestMapping(value = "/courserule", method = RequestMethod.GET)
	public ModelAndView getCourseruleList(){ 
		ModelAndView model = new ModelAndView("courserule");
		CourseruleDAO courseruleDAO = (CourseruleDAO)context.getBean("courseruleDAO"); //bean¥Îªºid
		List<Courserule> courseruleList = new ArrayList<Courserule>();
		courseruleList = courseruleDAO.getCourseruleList();
		model.addObject("courseruleList", courseruleList);
		return model;
	}
}
