package com.practice.webapp.entity.news;

import java.sql.Date;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class Bulletin {
	private String buTitle;//���i����D
	private Date publishTime;//�o�G�ɶ�
	private String buCont;//�������e
	private String buSCode;//scode
	private String sCode;//scode
	private String sName;//��������
	private String buCode;//����key
	private String fileCode;//����s��
	private String upload;//����
	
	//����
	private List<MultipartFile> files;
	 
    public List<MultipartFile> getFiles() {
        return files;
    }
 
    public void setFiles(List<MultipartFile> files) {
        this.files = files;
    }  
	
	public String getFileCode() {
		return fileCode;
	}
	public void setFileCode(String fileCode) {
		this.fileCode = fileCode;
	}
	public String getUpload() {
		return upload;
	}
	public void setUpload(String upload) {
		this.upload = upload;
	}
	public String getBuCode() {
		return buCode;
	}
	public void setBuCode(String buCode) {
		this.buCode = buCode;
	}
	public String getBuTitle() {
		return buTitle;
	}
	public void setBuTitle(String buTitle) {
		this.buTitle = buTitle;
	}
	public Date getPublishTime() {
		return publishTime;
	}
	public void setPublishTime(Date publishTime) {
		this.publishTime = publishTime;
	}
	public String getBuCont() {
		return buCont;
	}
	public void setBuCont(String buCont) {
		this.buCont = buCont;
	}
	public String getBuSCode() {
		return buSCode;
	}
	public void setBuSCode(String buSCode) {
		this.buSCode = buSCode;
	}
	public String getsCode() {
		return sCode;
	}
	public void setsCode(String sCode) {
		this.sCode = sCode;
	}
	public String getsName() {
		return sName;
	}
	public void setsName(String sName) {
		this.sName = sName;
	}
}
