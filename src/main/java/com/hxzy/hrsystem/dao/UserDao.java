
package com.hxzy.hrsystem.dao;

import com.hxzy.hrsystem.entity.User;


import java.util.List;

import org.hibernate.Query;

import com.hxzy.hrsystem.entity.Role;
import com.hxzy.hrsystem.entity.User;

public interface UserDao extends BaseDao<User> {
	/**
	 * 添加一个角色
	 */
	public void addRole(User user, Role role);

	/**
	 * 通过Name查询用户
	 */
	public User getUserByName(String userName);

	/**
	 * 添加多个角色
	 */
	public void addRole(User user, List<Role> roleList);

	/**
	 * 根据用户id查询角色
	 * 
	 * @param id
	 * @return
	 */
	public List<Role> findAllRoleByUserId(int id);

	/**
	 * 查询根据索引查员工信息
	 */
	public List<User> findAllByIndex(int start, int end);

	/**
	 * 批量删除员工信息
	 */
	public void deleteAll(List<Integer> list);
	
	/** 总页数setter方法 **/
	public void setPageCount(int pageCount);
	
	/** 总页数getter方法 **/
	public int getPageCount();
}
