package com.practice.webapp.entity.course;

import com.mysql.jdbc.Blob;

public class Courserule {
	private int articleid;
	private String articlecontent;
	private Blob filepath;
	
	
	public Blob getFilepath() {
		return filepath;
	}
	public void setFilepath(Blob filepath) {
		this.filepath = filepath;
	}
	
	public int getArticleid() {
		return articleid;
	}
	public void setArticleid(int articleid) {
		this.articleid = articleid;
	}
	public String getArticlecontent() {
		return articlecontent;
	}
	public void setArticlecontent(String articlecontent) {
		this.articlecontent = articlecontent;
	}
}
