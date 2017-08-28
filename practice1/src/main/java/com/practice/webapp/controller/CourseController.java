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

import com.practice.webapp.dao.CourseDAO;
import com.practice.webapp.entity.course.Course;

@Controller
public class CourseController {
	ApplicationContext context = new ClassPathXmlApplicationContext("spring-module.xml");

	@RequestMapping(value = "/course", method = RequestMethod.GET)
	public ModelAndView getCourseList() {
		ModelAndView model = new ModelAndView("course");
		CourseDAO courseDAO = (CourseDAO) context.getBean("courseDAO"); // bean用的id
		List<Course> courseListU11 = new ArrayList<Course>();
		List<Course> courseListU12 = new ArrayList<Course>();
		List<Course> courseListU21 = new ArrayList<Course>();
		List<Course> courseListU22 = new ArrayList<Course>();
		List<Course> courseListU31 = new ArrayList<Course>();
		List<Course> courseListU32 = new ArrayList<Course>();
		List<Course> courseListU41 = new ArrayList<Course>();
		List<Course> courseListM1 = new ArrayList<Course>();
		List<Course> courseListE1 = new ArrayList<Course>();
		courseListU11 = courseDAO.getCourseListU11();
		courseListU12 = courseDAO.getCourseListU12();
		courseListU21 = courseDAO.getCourseListU21();
		courseListU22 = courseDAO.getCourseListU22();
		courseListU31 = courseDAO.getCourseListU31();
		courseListU32 = courseDAO.getCourseListU32();
		courseListU41 = courseDAO.getCourseListU41();
		courseListM1 = courseDAO.getCourseListM1();
		courseListE1 = courseDAO.getCourseListE1();
		model.addObject("courseListU11", courseListU11);
		model.addObject("courseListU12", courseListU12);
		model.addObject("courseListU21", courseListU21);
		model.addObject("courseListU22", courseListU22);
		model.addObject("courseListU31", courseListU31);
		model.addObject("courseListU32", courseListU32);
		model.addObject("courseListU41", courseListU41);
		model.addObject("courseListM1", courseListM1);
		model.addObject("courseListE1", courseListE1);
		return model;
	}

	@RequestMapping(value = "/admin/course_manage", method = RequestMethod.GET)
	public ModelAndView getCourseList1() {
		ModelAndView model = new ModelAndView("course_manage");
		CourseDAO courseDAO = (CourseDAO) context.getBean("courseDAO"); // bean用的id
		List<Course> courseListU11 = new ArrayList<Course>();
		List<Course> courseListU12 = new ArrayList<Course>();
		List<Course> courseListU21 = new ArrayList<Course>();
		List<Course> courseListU22 = new ArrayList<Course>();
		List<Course> courseListU31 = new ArrayList<Course>();
		List<Course> courseListU32 = new ArrayList<Course>();
		List<Course> courseListU41 = new ArrayList<Course>();
		List<Course> courseListM1 = new ArrayList<Course>();
		List<Course> courseListE1 = new ArrayList<Course>();
		courseListU11 = courseDAO.getCourseListU11();
		courseListU12 = courseDAO.getCourseListU12();
		courseListU21 = courseDAO.getCourseListU21();
		courseListU22 = courseDAO.getCourseListU22();
		courseListU31 = courseDAO.getCourseListU31();
		courseListU32 = courseDAO.getCourseListU32();
		courseListU41 = courseDAO.getCourseListU41();
		courseListM1 = courseDAO.getCourseListM1();
		courseListE1 = courseDAO.getCourseListE1();
		model.addObject("courseListU11", courseListU11);
		model.addObject("courseListU12", courseListU12);
		model.addObject("courseListU21", courseListU21);
		model.addObject("courseListU22", courseListU22);
		model.addObject("courseListU31", courseListU31);
		model.addObject("courseListU32", courseListU32);
		model.addObject("courseListU41", courseListU41);
		model.addObject("courseListM1", courseListM1);
		model.addObject("courseListE1", courseListE1);
		return model;
	}

	@RequestMapping(value = "/admin/updateCourse", method = RequestMethod.POST)
	public ModelAndView updateCourse(@ModelAttribute Course course) {
		ModelAndView model = new ModelAndView("redirect:/course");
		CourseDAO courseDAO = (CourseDAO) context.getBean("courseDAO");
		courseDAO.update(course);

		return model;
	}
}
