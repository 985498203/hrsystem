package com.hxzy.hrsystem.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * 用户表 tb_user
 *
 */
public class User implements Serializable, UserDetails {

	private static final long serialVersionUID = -6284168751186821312L;
	private Integer userId;// 用户ID
	private String username;// 用户账号
	private String password;// 用户密码
	private String name;// 用户姓名
	private Integer age;// 用户年龄
	private Integer gender;// 用户性别 1：男，2：女
	private String phone;// 用户电话
	private String email;// 用户邮箱
	
	private Integer state;// 用户状态,-1表示被禁用
	private Integer accountNonExpired;// 账户未过期
	private Integer accountNonLocked;// 账户没有锁定
	private Integer credentialsNonExpired;// 账户没有过期

	public void setAccountNonExpired(Integer accountNonExpired) {
		this.accountNonExpired = accountNonExpired;
	}

	public void setAccountNonLocked(Integer accountNonLocked) {
		this.accountNonLocked = accountNonLocked;
	}

	public void setCredentialsNonExpired(Integer credentialsNonExpired) {
		this.credentialsNonExpired = credentialsNonExpired;
	}

	private Collection<? extends GrantedAuthority> authorities;// 用户所拥有的所有权限

	public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
		this.authorities = authorities;
	}

	public User(String username, String password, String name, Integer age, Integer gender, String phone, String email,
			Integer state) {
		super();
		this.username = username;
		this.password = password;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.phone = phone;
		this.email = email;
		this.state = state;
	}

	public User() {
		super();
	}

	private Worder worder;// 工单，配置一对一
	private Dept dept;// 部门，配置多对一

	private Set<WorderRecord> worderRecordSet = new HashSet<WorderRecord>();// 工单申请记录

	public Set<WorderRecord> getWorderRecordSet() {
		return worderRecordSet;
	}

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public void setWorderRecordSet(Set<WorderRecord> worderRecordSet) {
		this.worderRecordSet = worderRecordSet;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public Worder getWorder() {
		return worder;
	}

	public void setWorder(Worder worder) {
		this.worder = worder;
	}

	public Dept getDept() {
		return dept;
	}

	public void setDept(Dept dept) {
		this.dept = dept;
	}

	Set<UserRole> userRoleSet = new HashSet<UserRole>();// 配置与UserRole一对多的关系

	public Set<UserRole> getUserRoleSet() {
		return userRoleSet;
	}

	public void setUserRoleSet(Set<UserRole> userRoleSet) {
		this.userRoleSet = userRoleSet;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
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

	@Override
	public String toString() {
		return "User [userId=" + userId + ", username=" + username + ", password=" + password + ", name=" + name
				+ ", age=" + age + ", phone=" + phone + ", email=" + email + ", state=" + state + "]";
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public boolean isAccountNonExpired() {// 账户是否未过期,过期无法验证
		if (accountNonExpired == -1) {// -1表示被过期,1表示可用
			return false;
		}
		return true;

	}

	@Override
	public boolean isAccountNonLocked() {// 指定用户是否被锁定或者解锁,锁定的用户无法进行身份验证
		if (accountNonLocked == -1) {// -1表示被过期,1表示可用
			return false;
		}
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {// 指示是否已过期的用户的凭据(密码),过期的凭据防止认证
		if (credentialsNonExpired == -1) {// -1表示被过期,1表示可用
			return false;
		}
		return true;
	}

	@Override
	public boolean isEnabled() {// 是否被禁用,禁用的用户不能身份验证
		if (-1 == state) {// -1表示被禁用,1表示可用
			return false ;
		}
		return true;
	}
}
