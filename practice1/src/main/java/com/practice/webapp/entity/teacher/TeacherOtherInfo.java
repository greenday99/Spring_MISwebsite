package com.practice.webapp.entity.teacher;

public class TeacherOtherInfo {
	private String name;//詳細資料類別名稱
	private boolean flag;//用於判定資料庫中是否有資料
	private String teaDataPer;//發生時間
	private String teaDataCont;//資料明細
	private String teaDataContCode;
	
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
	public String getTeaDataPer() {
		return teaDataPer;
	}
	public void setTeaDataPer(String teaDataPer) {
		this.teaDataPer = teaDataPer;
	}
	public String getTeaDataCont() {
		return teaDataCont;
	}
	public void setTeaDataCont(String teaDataCont) {
		this.teaDataCont = teaDataCont;
	}
	public String getTeaDataContCode() {
		return teaDataContCode;
	}
	public void setTeaDataContCode(String teaDataContCode) {
		this.teaDataContCode = teaDataContCode;
	}
}
