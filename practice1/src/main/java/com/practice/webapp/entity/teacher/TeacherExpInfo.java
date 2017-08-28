package com.practice.webapp.entity.teacher;

public class TeacherExpInfo {
	private String name;//詳細資料類別名稱
	private boolean flag;//用於判定資料庫中是否有資料
	private String teaExpPer;//期間
	private String teaExpUnit;//單位
	private String teaExpDep;//部門
	private String teaExpTitle;//職稱
	private String teaExpCode;
		
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isFlag() {
		return flag;
	}
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	public String getTeaExpPer() {
		return teaExpPer;
	}
	public void setTeaExpPer(String teaExpPer) {
		this.teaExpPer = teaExpPer;
	}
	public String getTeaExpUnit() {
		return teaExpUnit;
	}
	public void setTeaExpUnit(String teaExpUnit) {
		this.teaExpUnit = teaExpUnit;
	}
	public String getTeaExpDep() {
		return teaExpDep;
	}
	public void setTeaExpDep(String teaExpDep) {
		this.teaExpDep = teaExpDep;
	}
	public String getTeaExpTitle() {
		return teaExpTitle;
	}
	public void setTeaExpTitle(String teaExpTitle) {
		this.teaExpTitle = teaExpTitle;
	}
	public String getTeaExpCode() {
		return teaExpCode;
	}
	public void setTeaExpCode(String teaExpCode) {
		this.teaExpCode = teaExpCode;
	}	
}
