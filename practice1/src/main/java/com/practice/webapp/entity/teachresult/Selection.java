package com.practice.webapp.entity.teachresult;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Selection {
	@JsonProperty("year")
	private String year;
	@JsonProperty("teacher")
	private String teacher;

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getTeacher() {
		return teacher;
	}

	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}

}
