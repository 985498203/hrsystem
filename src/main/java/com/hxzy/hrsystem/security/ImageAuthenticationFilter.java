package com.hxzy.hrsystem.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.web.filter.OncePerRequestFilter;

/**
 * 图片验证码验证过滤器
 *
 */
public class ImageAuthenticationFilter extends OncePerRequestFilter {
	private MyAuthenticationFailureHandler myAuthenticationFailureHandler;

	public void setMyAuthenticationFailureHandler(MyAuthenticationFailureHandler myAuthenticationFailureHandler) {
		this.myAuthenticationFailureHandler = myAuthenticationFailureHandler;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		if (request.getRequestURI().contains("/login.html")) {// 判断当前的请求是否为登录请求

			try {
				String userCode = request.getParameter("imgCode").trim().toLowerCase();// 获取用户输入的验证码
				String sysCode = ((String) request.getSession().getAttribute("imgKey")).trim().toLowerCase();// 获取系统生成的验证码
				System.out.println("用户输入的："+userCode);
				System.out.println("系统生成的："+sysCode);
				
				if (null == userCode) {
					throw new MyAuthenticationException("请输入验证码");
				}
				if (!sysCode.equals(userCode)) {
					throw new MyAuthenticationException("验证码不一致");
				}
				System.out.println("验证码正确");
			} catch (AuthenticationException e) {
				myAuthenticationFailureHandler.onAuthenticationFailure(request, response, e);// 交给FailureHandler处理异常
				return;
			}
		}
		filterChain.doFilter(request, response);// 放行
	}

}
