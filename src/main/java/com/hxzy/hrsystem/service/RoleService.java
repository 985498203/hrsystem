package com.hxzy.hrsystem.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.hxzy.hrsystem.entity.Role;
import com.hxzy.hrsystem.entity.User;
@Component
public interface RoleService {
	/**
	 * 查询所有
	 * 
	 * @return
	 */
	public List<Role> finAllRole();

	/**
	 * 通过id查询
	 * 
	 * @param id
	 * @return
	 */
	public Role getRoleById(int id);
	
	
	/**
	 * 通过Userid查询
	 * 
	 * @param userId
	 * @return
	 */
	public List<Role> findAllRoleByUserId(int userId);

	/**
	 * 保存
	 * 
	 * @param entity
	 */
	public void addRole(Role role);

	/**
	 * 更新
	 * 
	 * @param entity
	 */
	public void updateRole(Role role);

	/**
	 * 删除
	 * 
	 * @param entity
	 */
	public void deleteRole(Role role);
}
