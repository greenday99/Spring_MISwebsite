package com.practice.webapp.entity.teacher;

public class TeacherStuTopic {
	private String name;//詳細資料類別名稱
	private boolean flag;//用於判定資料庫中是否有資料
	private String teaStuYear;//年份
	private String teaStuName;//學生專題名稱
	private String topicID;//不重複值
	
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
	public String getTopicID() {
		return topicID;
	}
	public void setTopicID(String topicID) {
		this.topicID = topicID;
	}
}
