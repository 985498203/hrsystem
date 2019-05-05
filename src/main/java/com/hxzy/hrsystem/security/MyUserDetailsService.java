package com.hxzy.hrsystem.security;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import com.hxzy.hrsystem.entity.Role;
import com.hxzy.hrsystem.entity.User;
import com.hxzy.hrsystem.entity.UserDTO;
import com.hxzy.hrsystem.service.UserService;

/**
 * 
 * 自定义登录验证
 */

public class MyUserDetailsService implements UserDetailsService {
	public UserService userService;
	public Logger logger = LoggerFactory.getLogger(MyUserDetailsService.class);
	@Resource(name = "userServiceImpl")
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	/**
	 *
	 * 根据用户名获取用户 - 用户的角色、权限等信息
	 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserDTO dto = null;System.out.println("经过了MyUserDetailsServiceImpl");
		
		logger.info("通过自定义的MyUserDetailsServiceImpl进行验证");
		
		User user = getUser(username);// 通过用户名得到当前用户信息
		if (null == user) {
			System.out.println("用户未找到!");
			throw new UsernameNotFoundException("用户未找到!");
		} else {
			logger.info("用户"+user.getName()+",在"+new Date()+",登录了系统");
			dto = new UserDTO();// 实体转化为dto传递数据
			dto.setUsername(user.getUsername());
			dto.setPassword(user.getPassword());
			dto.setState(user.getState());
			dto.setAuthorities(this.getGrantedAuthority(user));
		}
		System.out.println("user:" + user);
		return dto;
	}

	/**
	 * 得到当前用户
	 * 
	 * @param username
	 * @return
	 */
	public User getUser(String username) {
	 return userService.getUserByName(username);// 通过用户名查询用户信息
	}

	/**
	 * 得到当前用户的角色集合
	 * 
	 * @param user
	 * @return
	 */
	public List<GrantedAuthority> getGrantedAuthority(User user) {
		List<GrantedAuthority> rolesNameList = null;// 角色列表
		if (null != user) {
			List<Role> rolesList = userService.findAllRoleByUserId(user.getUserId());// 根据用户ID查询角色列表
			rolesNameList = new ArrayList<GrantedAuthority>();// GrantedAuthority角色列表
			for (Role role : rolesList) {
				
				System.out.println("============================遍历用户的角色名 ===============================");
				System.out.println("角色："+role.getRoleName());
				String roleName = role.getRoleName();// 得到角色名
				if (rolesNameList.contains(new SimpleGrantedAuthority(roleName))) {
					continue;
				}
				// 存放角色名列表
				rolesNameList.add(new SimpleGrantedAuthority(roleName));// 添加至GrantedAuthority角色列表中
			}
		}
		return rolesNameList;
	}

}
