package com.hxzy.hrsystem.dao;

import java.util.List;

import com.hxzy.hrsystem.entity.Permission;

public interface PermissionDao extends BaseDao<Permission> {
	/**
	 * 通过用户id查询所有的权限
	 * 
	 * @param userId
	 * @return
	 */
	public List<Permission> findAllPermissionByUserId(int userId);

	/**
	 * 根据职位id查询所有权限
	 * 
	 * @param id
	 * @return
	 */
	List<Permission> findAllPermissionByRoleId(int roleId);
}
