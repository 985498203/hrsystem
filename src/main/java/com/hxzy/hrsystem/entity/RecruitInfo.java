package com.hxzy.hrsystem.entity;

public class RecruitInfo {
	private Integer recruitId;
	private Integer recruitNumber;// 招聘人数
	private String recruitDept;// 招聘职位
	private String describe;// 职位描述
	public Integer getRecruitId() {
		return recruitId;
	}

	public void setRecruitId(Integer recruitId) {
		this.recruitId = recruitId;
	}

	public Integer getRecruitNumber() {
		return recruitNumber;
	}

	public void setRecruitNumber(Integer recruitNumber) {
		this.recruitNumber = recruitNumber;
	}

	public String getRecruitDept() {
		return recruitDept;
	}

	public void setRecruitDept(String recruitDept) {
		this.recruitDept = recruitDept;
	}

	public String getDescribe() {
		return describe;
	}

	public void setDescribe(String describe) {
		this.describe = describe;
	}

}
