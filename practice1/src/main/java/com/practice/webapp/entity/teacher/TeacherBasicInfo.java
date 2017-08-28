package com.practice.webapp.entity.teacher;

public class TeacherBasicInfo {
	private String teaPic;// 教師圖片
	private String teaCode;// 教師編號
	private String teaName;// 教師姓名
	private String teaENName;// 教師英文姓名
	private String teaPos;// 教師職稱
	private String teaTel;// 教師聯絡電話
	private String teaEmail;// 教師聯絡郵箱
	private String teaLoc;// 教師辦公地址
	private String teaLDAP;// 教師的LDAP

	public String getTeaPic() {
		return teaPic;
	}

	public void setTeaPic(String teaPic) {
		this.teaPic = teaPic;
	}

	public String getTeaName() {
		return teaName;
	}

	public void setTeaName(String teaName) {
		this.teaName = teaName;
	}

	public String getTeaPos() {
		return teaPos;
	}

	public void setTeaPos(String teaPos) {
		this.teaPos = teaPos;
	}

	public String getTeaTel() {
		return teaTel;
	}

	public void setTeaTel(String teaTel) {
		this.teaTel = teaTel;
	}

	public String getTeaEmail() {
		return teaEmail;
	}

	public void setTeaEmail(String teaEmail) {
		this.teaEmail = teaEmail;
	}

	public String getTeaCode() {
		return teaCode;
	}

	public void setTeaCode(String teaCode) {
		this.teaCode = teaCode;
	}

	public String getTeaENName() {
		return teaENName;
	}

	public void setTeaENName(String teaENName) {
		this.teaENName = teaENName;
	}

	public String getTeaLoc() {
		return teaLoc;
	}

	public void setTeaLoc(String teaLoc) {
		this.teaLoc = teaLoc;
	}

	public String getTeaLDAP() {
		return teaLDAP;
	}

	public void setTeaLDAP(String teaLDAP) {
		this.teaLDAP = teaLDAP;
	}
}
