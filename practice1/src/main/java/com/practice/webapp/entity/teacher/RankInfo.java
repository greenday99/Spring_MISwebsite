package com.practice.webapp.entity.teacher;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RankInfo {

	private String teaCode;// �Юv�s��
	private String sort;// �Юv�H�����Ƨ�

	public String getTeaCode() {
		return teaCode;
	}

	public void setTeaCode(String teaCode) {
		this.teaCode = teaCode;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

}
