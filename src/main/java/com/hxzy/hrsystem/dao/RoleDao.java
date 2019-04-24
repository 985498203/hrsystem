package com.hxzy.hrsystem.dao;

import java.util.List;
import com.hxzy.hrsystem.entity.Permission;
import com.hxzy.hrsystem.entity.Role;

public interface RoleDao extends BaseDao<Role> {
	/**
	 * 根据用户id查询职位
	 * 
	 * @param id
	 * @return
	 */
	List<Role> findAllRoleByUserId(int id);

	/**
	 * 根据职位id查询所有权限
	 * 
	 * @param id
	 * @return
	 */
	List<Permission> findAllPermissionByRoleId(int roleId);

}
