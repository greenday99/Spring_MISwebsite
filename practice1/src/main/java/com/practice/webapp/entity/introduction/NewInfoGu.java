package com.practice.webapp.entity.introduction;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class NewInfoGu {
	private String teaPic;//�Юv�Ϥ�
	private String teaCode;//�Юv�s��
	private String teaName;//�Юv�m�W
	private String teaENName;//�Юv�^��m�W
	private String teaPos;//�Юv¾��
	private String teaTel;//�Юv�p���q��
	private String teaEmail;//�Юv�p���l�c
	private String teaLoc;//�Юv�줽�a�}
	private String teaLDAP;//�Юv��LDAP
	private String teaAble;//�Юv�H���O�_�b�e�����
	private String teaSort;//�Юv�H�����Ƨ�
	private String teaType;//�Юv����
	
	//��s�ɮ�
		private List<MultipartFile> crunchifyFiles;
		 
	    public List<MultipartFile> getFiles() {
	        return crunchifyFiles;
	    }
	 
	    public void setFiles(List<MultipartFile> files) {
	        this.crunchifyFiles = files;
	    } 
	
	public String getTeaPic() {
		return teaPic;
	}
	public void setTeaPic(String teaPic) {
		this.teaPic = teaPic;
	}
	public String getTeaCode() {
		return teaCode;
	}
	public void setTeaCode(String teaCode) {
		this.teaCode = teaCode;
	}
	public String getTeaName() {
		return teaName;
	}
	public void setTeaName(String teaName) {
		this.teaName = teaName;
	}
	public String getTeaENName() {
		return teaENName;
	}
	public void setTeaENName(String teaENName) {
		this.teaENName = teaENName;
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
	public String getTeaAble() {
		return teaAble;
	}
	public void setTeaAble(String teaAble) {
		this.teaAble = teaAble;
	}
	public String getTeaSort() {
		return teaSort;
	}
	public void setTeaSort(String teaSort) {
		this.teaSort = teaSort;
	}
	public String getTeaType() {
		return teaType;
	}
	public void setTeaType(String teaType) {
		this.teaType = teaType;
	}

}
