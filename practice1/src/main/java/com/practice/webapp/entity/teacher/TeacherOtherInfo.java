package com.practice.webapp.entity.teacher;

public class TeacherOtherInfo {
	private String name;//�ԲӸ�����O�W��
	private boolean flag;//�Ω�P�w��Ʈw���O�_�����
	private String teaDataPer;//�o�ͮɶ�
	private String teaDataCont;//��Ʃ���
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
