package com.hxzy.hrsystem.config;

import java.util.Collection;
import java.util.Iterator;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

/**
 * 自定义认证管理器
 * 
 * 如果该页面不需要权限访问，则直接结束
 */
public class MyAccessDecisionManager implements AccessDecisionManager {

	@Override
	public void decide(Authentication authentication, Object object, Collection<ConfigAttribute> configAttributes)
			throws AccessDeniedException, InsufficientAuthenticationException {
		if (null == configAttributes) {
			return;
		}
		// 访问该url所需的角色列表
		Iterator<ConfigAttribute> iterator = configAttributes.iterator();
		while (iterator.hasNext()) {
			ConfigAttribute ca = iterator.next();
			String needRole = ((SecurityConfig) ca).getAttribute();// 访问该资源所需的权限
			for (GrantedAuthority gra : authentication.getAuthorities()) {// gra访问该用户所需的权限
				if (needRole.trim().equals(gra.getAuthority().trim())) {
					return;// 放行
				}
			}
		}
		// 该用户没有权限访问该资源
		throw new AccessDeniedException("没有权限访问");

	}

	@Override
	public boolean supports(ConfigAttribute attribute) {
		return true;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return true;
	}

}
