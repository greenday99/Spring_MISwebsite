package com.practice.webapp.entity.course;

public class SchedulePlan {
	private int scheduleplanid;
	private int year;
	private String semester;
	private String sche_cont;
	private String div_code;
	private int plan_code;
	private String plan_name;
	private int count;
	
	
	public String getSche_cont() {
		return sche_cont;
	}
	public void setSche_cont(String sche_cont) {
		this.sche_cont = sche_cont;
	}
	public String getDiv_code() {
		return div_code;
	}
	public void setDiv_code(String div_code) {
		this.div_code = div_code;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getPlan_name() {
		return plan_name;
	}
	public void setPlan_name(String plan_name) {
		this.plan_name = plan_name;
	}
	public int getScheduleplanid() {
		return scheduleplanid;
	}
	public void setScheduleplanid(int scheduleplanid) {
		this.scheduleplanid = scheduleplanid;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getSemester() {
		return semester;
	}
	public void setSemester(String semester) {
		this.semester = semester;
	}
	
	public int getPlan_code() {
		return plan_code;
	}
	public void setPlan_code(int plan_code) {
		this.plan_code = plan_code;
	}
}
