package com.hxzy.hrsystem.service;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.springframework.security.access.AccessDecisionVoter;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.access.vote.AbstractAccessDecisionManager;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

@Component
public class MyAccessDecisionManager extends AbstractAccessDecisionManager {

	protected MyAccessDecisionManager(List<AccessDecisionVoter<? extends Object>> decisionVoters) {
		super(decisionVoters);
	}

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

}
