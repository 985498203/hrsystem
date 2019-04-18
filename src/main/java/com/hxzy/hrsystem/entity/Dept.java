package com.hxzy.hrsystem.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Dept implements Serializable {

	private static final long serialVersionUID = -6458056658636446534L;
	private Integer dept_id;// 部门ID
	private String dept_name;// 部门名称

	Set<User> userSet = new HashSet<User>();// 配置一对多

	public Set<User> getUserSet() {
		return userSet;
	}

	public void setUserSet(Set<User> userSet) {
		this.userSet = userSet;
	}

	public Integer getDept_id() {
		return dept_id;
	}

	public void setDept_id(Integer dept_id) {
		this.dept_id = dept_id;
	}

	public String getDept_name() {
		return dept_name;
	}

	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
	}

}
