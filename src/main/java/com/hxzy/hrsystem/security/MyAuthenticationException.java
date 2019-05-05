package com.hxzy.hrsystem.security;

import org.springframework.security.core.AuthenticationException;

/**
 * 
 * 自定义验证码异常类
 */
public class MyAuthenticationException extends AuthenticationException {

	private static final long serialVersionUID = 9191836044930038264L;
	
	public MyAuthenticationException(String msg) {
		super(msg);
	}

	public MyAuthenticationException(String msg, Throwable t) {
		super(msg, t);
	}
	

}
