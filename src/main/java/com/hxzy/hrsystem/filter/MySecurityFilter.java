package com.hxzy.hrsystem.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.springframework.security.access.SecurityMetadataSource;
import org.springframework.security.access.intercept.AbstractSecurityInterceptor;
import org.springframework.security.access.intercept.InterceptorStatusToken;
import org.springframework.security.web.FilterInvocation;
import org.springframework.stereotype.Component;

/**
 * 自定义过滤拦截器
 */
@Component
public class MySecurityFilter extends AbstractSecurityInterceptor implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		FilterInvocation fi = new FilterInvocation(request, response, chain);
		getInvocation(fi);
	}

	public void getInvocation(FilterInvocation fi) {
		InterceptorStatusToken token = super.beforeInvocation(fi);// 过滤器拦截请求先交给springsecurity进行校验
		try {
			fi.getChain().doFilter(fi.getHttpRequest(), fi.getHttpResponse());
		} catch (IOException | ServletException e) {
			e.printStackTrace();
		} finally {
			super.afterInvocation(token, null);
		}

	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public Class<?> getSecureObjectClass() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SecurityMetadataSource obtainSecurityMetadataSource() {
		// TODO Auto-generated method stub
		return null;
	}

}
