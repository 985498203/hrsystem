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
	public List<Permission> findAllPermission();

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
	 * 根据角色id查询所有权限
	 * 
	 * @param id
	 * @return
	 */
	List<Permission> findAllPermissionByRoleId(int roleId);

	/**
	 * 通过id删除
	 * 
	 * @param id
	 */
	public void deletePermissionById(int id);

	/**
	 * 员工信息分页查询
	 * 
	 * @param start 开始索引
	 * @param max   一页显示的条数
	 * @return
	 */
	public List<Permission> findAllPermissionByIndex(int start, int max);

	/** 总页数 **/
	public int pageNo(int end);

	/**
	 * 获取总记录数
	 * 
	 * @return
	 */
	public int getConut();
	
	/**
	 * 批量删除
	 * @param idList PermissionID数组
	 */
	public void deletePermissionAll(int[] idArray);
}
