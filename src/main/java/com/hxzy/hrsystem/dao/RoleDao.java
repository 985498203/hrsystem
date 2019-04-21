package com.hxzy.hrsystem.dao;

import java.util.List;
import java.util.Set;

import com.hxzy.hrsystem.entity.Role;

public interface RoleDao extends BaseDao<Role> {
	/**
	 * 根据用户id查询职位
	 * 
	 * @param id
	 * @return
	 */
	List<Role> findAllRoleByUserId(int id);

}
