package com.practice.webapp.entity.introduction;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class Imintro {
	private String di_code;
	private String di_name;
	private String dic_code;
	private String dic_name;
	private String dic_cont;
	private String dic_cont_en;
	private int file_code;
	private String file_url;
	
	
	//§ó·sÀÉ®×
	private List<MultipartFile> crunchifyFiles;
	 
    public List<MultipartFile> getFiles() {
        return crunchifyFiles;
    }
 
    public void setFiles(List<MultipartFile> files) {
        this.crunchifyFiles = files;
    } 
	//
	
	
	public int getFile_code() {
		return file_code;
	}
	public void setFile_code(int file_code) {
		this.file_code = file_code;
	}
	public String getFile_url() {
		return file_url;
	}
	public void setFile_url(String file_url) {
		this.file_url = file_url;
	}
	public String getDi_code() {
		return di_code;
	}
	public void setDi_code(String di_code) {
		this.di_code = di_code;
	}
	public String getDi_name() {
		return di_name;
	}
	public void setDi_name(String di_name) {
		this.di_name = di_name;
	}
	public String getDic_code() {
		return dic_code;
	}
	public void setDic_code(String dic_code) {
		this.dic_code = dic_code;
	}
	public String getDic_name() {
		return dic_name;
	}
	public void setDic_name(String dic_name) {
		this.dic_name = dic_name;
	}
	public String getDic_cont() {
		return dic_cont;
	}
	public void setDic_cont(String dic_cont) {
		this.dic_cont = dic_cont;
	}
	public String getDic_cont_en() {
		return dic_cont_en;
	}
	public void setDic_cont_en(String dic_cont_en) {
		this.dic_cont_en = dic_cont_en;
	}
	
	

}
