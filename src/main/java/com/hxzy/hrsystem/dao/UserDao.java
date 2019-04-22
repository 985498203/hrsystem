package com.hxzy.hrsystem.dao;

import java.util.List;

import org.hibernate.Query;

import com.hxzy.hrsystem.entity.Role;
import com.hxzy.hrsystem.entity.User;

public interface UserDao extends BaseDao<User> {
	/**
	 * 添加一个职位
	 */
	public void addRole(User user, Role role);

	/**
	 * 通过Name查询用户
	 */
	public User getUserByName(String userName);

	/**
	 * 添加多个职位
	 */
	public void addRole(User user, List<Role> roleList);
}
