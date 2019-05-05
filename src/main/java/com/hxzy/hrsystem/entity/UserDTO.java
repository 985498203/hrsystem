package com.hxzy.hrsystem.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * 返回用户数据的DTO
 *
 */
public class UserDTO implements Serializable, UserDetails {

	private String username;// 用户名
	private String password;// 用户密码
	private Integer state;// 用户状态,-1表示被禁用
	Collection<? extends GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
		this.authorities = authorities;
	}

	private static final long serialVersionUID = 8908842659948555010L;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {// 账户是否过期,过期无法验证
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {// 指定用户是否被锁定或者解锁,锁定的用户无法进行身份验证
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {// 指示是否已过期的用户的凭据(密码),过期的凭据防止认证
		return true;
	}

	@Override
	public boolean isEnabled() {// 是否被禁用,禁用的用户不能身份验证
		if (1 == state) {// -1表示被禁用,1表示可用
			return true;
		} else {
			return false;
		}

	}

}
