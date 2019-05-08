package com.hxzy.hrsystem.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Dept implements Serializable {

	private static final long serialVersionUID = -119237731424491129L;
	private Integer deptId;// 部门ID
	private String deptName;// 部门名称
	private String description;// 部门描述

	private Dept parent;// 上级部门

	private Set<Dept> children = new HashSet<Dept>();// 下级部门
	
	public Set<Dept> getChildren() {
		return children;
	}

	public void setChildren(Set<Dept> children) {
		this.children = children;
	}

	public Dept getParent() {
		return parent;
	}

	public void setParent(Dept parent) {
		this.parent = parent;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	Set<User> userSet = new HashSet<User>();// 配置一对多

	public Set<User> getUserSet() {
		return userSet;
	}

	public void setUserSet(Set<User> userSet) {
		this.userSet = userSet;
	}

	public Integer getDeptId() {
		return deptId;
	}

	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

}
