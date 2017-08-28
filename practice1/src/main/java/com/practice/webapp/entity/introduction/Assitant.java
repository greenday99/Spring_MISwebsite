package com.practice.webapp.entity.introduction;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class Assitant {
	private String tea_en_name;
	private String m_name;
	private String post_name;
	private String m_ldap;
	private String m_phone;
	private String m_email;
	private String location;
	private String m_dep_code;
	private int tea_sort;
	private String teacherType;
	private int tea_able;
	private String tea_photo;
	private int tea_code;
	private String workContent;
	private AssitantWork assitantwork;
	private List<String> workList = new ArrayList<String>();
	private List<AssitantWork> assitantworkList = new ArrayList<AssitantWork>();
	
	//更新相片
	private List<MultipartFile> crunchifyFiles;
	 
    public List<MultipartFile> getFiles() {
        return crunchifyFiles;
    }
 
    public void setFiles(List<MultipartFile> files) {
        this.crunchifyFiles = files;
    }   
    /*
	private MultipartFile crunchifyFiles;	 
	public MultipartFile getCrunchifyFiles() {
		return crunchifyFiles;
	}
	public void setCrunchifyFiles(MultipartFile crunchifyFiles) {
		this.crunchifyFiles = crunchifyFiles;
	}
	*/
    
//    private MultipartFile picfile;
//	public MultipartFile getPicfile() {
//		return picfile;
//	}
//
//	public void setPicfile(MultipartFile picfile) {
//		this.picfile = picfile;
//	}

	
	
	public List<AssitantWork> getAssitantworkList() {
		return assitantworkList;
	}
	public void setAssitantworkList(List<AssitantWork> assitantworkList) {
		this.assitantworkList = assitantworkList;
	}
	public AssitantWork getAssitantwork() {
		return assitantwork;
	}
	public void setAssitantwork(AssitantWork assitantwork) {
		this.assitantwork = assitantwork;
	}
	public int count(){
		return workList.size();
	}
	public void add(String work){
		workList.add(work);
	}
	public List<String> getWorkList() {
		return workList;
	}
	public void setWorkList(List<String> workList) {
		this.workList = workList;
	}
	public String getWorkContent() {
		return workContent;
	}
	public void setWorkContent(String workContent) {
		this.workContent = workContent;
	}
	public int getTea_code() {
		return tea_code;
	}
	public void setTea_code(int tea_code) {
		this.tea_code = tea_code;
	}
	public String getTea_en_name() {
		return tea_en_name;
	}
	public void setTea_en_name(String tea_en_name) {
		this.tea_en_name = tea_en_name;
	}
	public String getM_name() {
		return m_name;
	}
	public void setM_name(String m_name) {
		this.m_name = m_name;
	}
	public String getPost_name() {
		return post_name;
	}
	public void setPost_name(String post_name) {
		this.post_name = post_name;
	}
	public String getM_ldap() {
		return m_ldap;
	}
	public void setM_ldap(String m_ldap) {
		this.m_ldap = m_ldap;
	}
	public String getM_phone() {
		return m_phone;
	}
	public void setM_phone(String m_phone) {
		this.m_phone = m_phone;
	}
	public String getM_email() {
		return m_email;
	}
	public void setM_email(String m_email) {
		this.m_email = m_email;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getM_dep_code() {
		return m_dep_code;
	}
	public void setM_dep_code(String m_dep_code) {
		this.m_dep_code = m_dep_code;
	}
	public int getTea_sort() {
		return tea_sort;
	}
	public void setTea_sort(int tea_sort) {
		this.tea_sort = tea_sort;
	}
	public String getTeacherType() {
		return teacherType;
	}
	public void setTeacherType(String teacherType) {
		this.teacherType = teacherType;
	}
	public int getTea_able() {
		return tea_able;
	}
	public void setTea_able(int tea_able) {
		this.tea_able = tea_able;
	}
	public String getTea_photo() {
		return tea_photo;
	}
	public void setTea_photo(String tea_photo) {
		this.tea_photo = tea_photo;
	}
	
}
