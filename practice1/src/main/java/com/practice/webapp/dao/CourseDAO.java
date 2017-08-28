package com.practice.webapp.dao;

import java.util.List;

import com.practice.webapp.entity.course.Course;


public interface CourseDAO {
	public List<Course> getCourseListU11();
	public List<Course> getCourseListU12();
	public List<Course> getCourseListU21();
	public List<Course> getCourseListU22();
	public List<Course> getCourseListU31();
	public List<Course> getCourseListU32();
	public List<Course> getCourseListU41();
	public List<Course> getCourseListM1();
	public List<Course> getCourseListE1();
	public void update(Course course);
}
