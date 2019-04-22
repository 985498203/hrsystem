package com.hxzy.hrsystem.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.hxzy.hrsystem.entity.Permission;

@Component
public interface PermissionService {
	/**
	 * 查询所有
	 * 
	 * @return
	 */
	public List<Permission> finAllPermission();

	/**
	 * 通过id查询
	 * 
	 * @param id
	 * @return
	 */
	public Permission getPermissionById(int id);

	/**
	 * 通过Userid查询
	 * 
	 * @param userId
	 * @return
	 */
	public List<Permission> findAllPermissionByUserId(int userId);

	/**
	 * 保存
	 * 
	 * @param entity
	 */
	public void addPermission(Permission permission);

	/**
	 * 更新
	 * 
	 * @param entity
	 */
	public void updatePermission(Permission permission);

	/**
	 * 删除
	 * 
	 * @param entity
	 */
	public void deletePermission(Permission permission);
	
	/**
	 * 根据职位id查询所有权限
	 * 
	 * @param id
	 * @return
	 */
	List<Permission> findAllPermissionByRoleId(int roleId);


	
}
