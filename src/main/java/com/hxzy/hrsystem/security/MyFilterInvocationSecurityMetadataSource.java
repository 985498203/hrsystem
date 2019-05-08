package com.hxzy.hrsystem.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import com.hxzy.hrsystem.entity.Permission;
import com.hxzy.hrsystem.entity.Role;
import com.hxzy.hrsystem.service.RoleService;

/**
 * 认证数据源,动态定义应用程序中的安全URL
 */
public class MyFilterInvocationSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {
	// 资源权限集合,Key(url) value(角色集合(以ROLE_为前缀的角色名))
	private static Map<String, Collection<ConfigAttribute>> resourceMap = null;

	private RoleService roleService;

	@Resource(name = "roleServiceImpl")
	public void setUserService(RoleService roleService) {
		this.roleService = roleService;
	}

	/**
	 * 被@PostConstruct修饰的方法会在服务器加载Servlet的时候运行，并且只会被服务器调用一次，类似于Servlet的inti()方法。
	 * 会在构造函数之后，init()方法之前运行
	 */
	@PostConstruct
	public void Myinit() {
		System.out.println("开始加载资源与权限列表");
		loadResource();// 加载资源与权限列表
	}

	/**
	 * 加载资源与权限列表
	 */
	private void loadResource() {

		List<Role> roleList = roleService.findAllRole();// 得到所有的角色集合

		resourceMap = new HashMap<String, Collection<ConfigAttribute>>();// 初始化资源权限集合,Key(url) value(以ROLE_开头的角色名)
		System.out.println("开始加载角色集合");
		for (Role role : roleList) {// 遍历角色集合

			System.out.println("角色ID:" + role.getRoleId() + "----角色名" + role.getRoleName());
			ConfigAttribute rolelist = new SecurityConfig(role.getRoleName());// 添加角色名（ROLE_xxx）到 ConfigAttribute中

			System.out.println("添加角色名（ROLE_xxx）到 ConfigAttribute中");

			List<Permission> permissionList = roleService.findAllPermissionByRoleId(role.getRoleId());// 取得所有的权限集合
			System.out.println("遍历加载角色的权限集合");
			for (Permission permission : permissionList) {// 遍历权限集合

				System.out.println("权限ID：" + permission.getPermId() + "----权限名：" + permission.getPermName()
						+ "-----URL:" + permission.getUrl());

				String url = permission.getUrl();// 得到权限对应的url
				/**
				 * 判断该集合中是否包含该url,包含则取出以url为Key的权限集合，添加到权限集合当中 以URL为key 角色名集合为value 如：index.jsp
				 * ---> ROLE_ADMIN,ROLE_USER,ROLE_SYS(这些角色都可以访问index.jsp页面)
				 */
				if (resourceMap.containsKey(url)) {
					Collection<ConfigAttribute> rolesConllection = resourceMap.get(url);// 取得原来的角色名集合

					if (rolesConllection.contains(rolelist)) {// 原来的角色名集合包含此角色，不添加
					} else {// 原来的角色名集合不包含此角色
						rolesConllection.add(rolelist);// 角色名集合中在添加其他的角色名
					}
				} else {// 首次创建，
					Collection<ConfigAttribute> rolesConllection = new ArrayList<ConfigAttribute>();// 创建角色名集合
					rolesConllection.add(rolelist);// 添加key（url）
					resourceMap.put(url, rolesConllection);// 添key（url）和 value（角色名集合）
				}
			}
		}
		System.out.println("———————————————————————开始———————————————————");

		for (String key : resourceMap.keySet()) {
			System.out.println("key:" + key);
		}
		for (Collection<ConfigAttribute> list : resourceMap.values()) {
			System.out.println("value:" + list);
		}
		System.out.println("———————————————————————结束———————————————————");

	}

	/**
	 * 根据用户所访问的URL，加载该URL所需的角色列表 Object object：url
	 */
	@Override
	public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
		String url = ((FilterInvocation) object).getRequestUrl().trim();// 得到url

		Iterator<String> iterator = resourceMap.keySet().iterator();
		while (iterator.hasNext()) {
			String resUrl = iterator.next().trim();// 取出所有的url
			if (url.equals(resUrl)) {// 取出的url与用户的url作比较，
				return resourceMap.get(resUrl);// 获得该url所需的角色列表
			}
		}
		// 数据库中没有该url的信息，放行
		return null;
	}

	@Override
	public Collection<ConfigAttribute> getAllConfigAttributes() {
		return null;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return true;
	}

}
