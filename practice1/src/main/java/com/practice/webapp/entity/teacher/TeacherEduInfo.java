package com.practice.webapp.entity.teacher;

public class TeacherEduInfo {
	private String name;// 詳細資料類別名稱
	private boolean flag;// 用於判定資料庫中是否有資料
	private String teaSch;// 學校
	private String teaDep;// 系所
	private String teaDeg;// 學位
	private String teaEduCode;// 在資料庫中的編號

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

	public String getTeaSch() {
		return teaSch;
	}

	public void setTeaSch(String teaSch) {
		this.teaSch = teaSch;
	}

	public String getTeaDep() {
		return teaDep;
	}

	public void setTeaDep(String teaDep) {
		this.teaDep = teaDep;
	}

	public String getTeaDeg() {
		return teaDeg;
	}

	public void setTeaDeg(String teaDeg) {
		this.teaDeg = teaDeg;
	}

	public String getTeaEduCode() {
		return teaEduCode;
	}

	public void setTeaEduCode(String teaEduCode) {
		this.teaEduCode = teaEduCode;
	}

}
