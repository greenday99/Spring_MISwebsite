package com.practice.webapp.entity.teacher;

public class TeacherStuPaper {
	private String name;//詳細資料類別名稱
	private boolean flag;//用於判定資料庫中是否有資料
	private String teaStuYear;//年份
	private String teaStuName;//學生名字
	private String teaStuPaperName;//論文標題
	private String paperID;//不重複值
	
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
	public String getTeaStuYear() {
		return teaStuYear;
	}
	public void setTeaStuYear(String teaStuYear) {
		this.teaStuYear = teaStuYear;
	}
	public String getTeaStuName() {
		return teaStuName;
	}
	public void setTeaStuName(String teaStuName) {
		this.teaStuName = teaStuName;
	}
	public String getTeaStuPaperName() {
		return teaStuPaperName;
	}
	public void setTeaStuPaperName(String teaStuPaperName) {
		this.teaStuPaperName = teaStuPaperName;
	}
	public String getPaperID() {
		return paperID;
	}
	public void setPaperID(String paperID) {
		this.paperID = paperID;
	}
}
