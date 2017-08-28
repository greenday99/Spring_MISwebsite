package com.practice.webapp.entity.teacher;

public class TeacherAwardInfo {
	private String name;//詳細資料類別名稱
	private boolean flag;//用於判定資料庫中是否有資料
	private String teaAwaYear;//獎勵年份
	private String teaAwaDep;//獎勵單位
	private String teaAwa;//獎勵名稱
	private String teaAwaCode;
	
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
	public String getTeaAwaYear() {
		return teaAwaYear;
	}
	public void setTeaAwaYear(String teaAwaYear) {
		this.teaAwaYear = teaAwaYear;
	}
	public String getTeaAwaDep() {
		return teaAwaDep;
	}
	public void setTeaAwaDep(String teaAwaDep) {
		this.teaAwaDep = teaAwaDep;
	}
	public String getTeaAwa() {
		return teaAwa;
	}
	public void setTeaAwa(String teaAwa) {
		this.teaAwa = teaAwa;
	}
	public String getTeaAwaCode() {
		return teaAwaCode;
	}
	public void setTeaAwaCode(String teaAwaCode) {
		this.teaAwaCode = teaAwaCode;
	}
	
}
