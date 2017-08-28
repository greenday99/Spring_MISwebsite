package com.practice.webapp.entity.teachresult;

//取自division_class資料表
public class Category {
	private String dcCode;// 班級類別編號
	private String dcClass;// 班級名稱

	public String getDcCode() {
		return dcCode;
	}

	public void setDcCode(String dcCode) {
		this.dcCode = dcCode;
	}

	public String getDcClass() {
		return dcClass;
	}

	public void setDcClass(String dcClass) {
		this.dcClass = dcClass;
	}
}
