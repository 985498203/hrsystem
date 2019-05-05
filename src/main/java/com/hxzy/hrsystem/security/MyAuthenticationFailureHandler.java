package com.hxzy.hrsystem.security;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 处理登录失败后的逻辑
 *
 */
public class MyAuthenticationFailureHandler implements AuthenticationFailureHandler {
	private ObjectMapper objectMapper = new ObjectMapper();

	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {
		// 返回json数据
		Map result = new HashMap<String, Boolean>();
		result.put("success", false);
		String json = objectMapper.writeValueAsString(result);// 字符串转化为json数据
		response.setContentType("text/json;charset=utf-8");
		response.getWriter().write(json);//

	}

}
