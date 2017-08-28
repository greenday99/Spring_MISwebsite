package com.practice.webapp.entity.teacher;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DetailRankInfo {
	private String teaCode;
	private String previousSort;
	private String nextSort;
	
	public String getTeaCode() {
		return teaCode;
	}
	public void setTeaCode(String teaCode) {
		this.teaCode = teaCode;
	}
	public String getPreviousSort() {
		return previousSort;
	}
	public void setPreviousSort(String previousSort) {
		this.previousSort = previousSort;
	}
	public String getNextSort() {
		return nextSort;
	}
	public void setNextSort(String nextSort) {
		this.nextSort = nextSort;
	}
	
}
