package com.hxzy.hrsystem.dao;

import java.util.List;

import com.hxzy.hrsystem.entity.Permission;
import com.hxzy.hrsystem.entity.User;

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

	/**
	 * 员工信息分页查询
	 * 
	 * @param start 开始索引
	 * @param max   一页显示的条数
	 * @return
	 */
	public List<Permission> findAllByIndex(int start, int max);

	/**
	 * 得到总页数
	 * 
	 * @return
	 */
	public int getPageCount();

	/**
	 * 设置总页数
	 * 
	 * @param pageCount
	 */
	public void setPageCount(int pageCount);

	/**
	 * 获取总记录数
	 * 
	 * @return
	 */
	public int getConut();
	
	/**
	 * 批量删除权限信息
	 */
	public void deleteAll(int[] idList);

}
