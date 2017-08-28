package com.practice.webapp.entity.teacher;

public class TeacherSpeInfo {
	private String name;//詳細資料類別名稱
	private boolean flag;//用於判斷資料庫內是否有資料
	private String teaSpe;//教師專長 
	private String teaSpeCode;
	
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
	public String getTeaSpe() {
		return teaSpe;
	}
	public void setTeaSpe(String teaSpe) {
		this.teaSpe = teaSpe;
	}
	public String getTeaSpeCode() {
		return teaSpeCode;
	}
	public void setTeaSpeCode(String teaSpeCode) {
		this.teaSpeCode = teaSpeCode;
	}
	
}
