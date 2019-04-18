package com.hxzy.hrsystem.entity;

import java.io.Serializable;

public class User implements Serializable{
	
	private static final long serialVersionUID = -6284168751186821312L;
	private Integer user_id;// 员工ID
	private String username;// 员工账号
	private String password;// 员工密码
	private String name;// 员工姓名
	private Integer age;// 员工年龄
	private String phone;// 员工电话
	private String email;// 员工邮箱
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

}
