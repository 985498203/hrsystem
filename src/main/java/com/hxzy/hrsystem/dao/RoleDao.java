package com.hxzy.hrsystem.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.hxzy.hrsystem.entity.Permission;
import com.hxzy.hrsystem.entity.Role;

@Component
public interface RoleDao extends BaseDao<Role> {
	/**
	 * 获取总记录数
	 * 
	 * @return
	 */
	public int getConut();
	
	/**
	 * 根据用户id查询职位
	 * 
	 * @param id
	 * @return
	 */
	public List<Role> findAllRoleByUserId(int id);

	/**
	 * 通过id添加权限
	 * 
	 * @param roleId 角色id
	 * @param permId 权限id
	 * @return
	 */
	public boolean addPermById(Integer roleId, Integer permId);

	/**
	 * 通过id批量添加权限
	 * 
	 * @param roleId 角色id
	 * @param permIdList 权限id集合
	 * @return
	 */
	public boolean addPermAllById(Integer roleId, Integer[] permIds);

	/**
	 * 根据职位id查询所有权限
	 * 
	 * @param id
	 * @return
	 */
	public List<Permission> findAllPermissionByRoleId(int roleId);

	/**
	 * 职位信息分页查询
	 * 
	 * @param start 开始索引
	 * @param max   一页显示的条数
	 * @return
	 */
	public List<Role> findAllByIndex(int start, int max);

	/**
	 * 得到职位信息总页数
	 * 
	 * @return
	 */
	public int getPageCount();

	/**
	 * 批量删除职位信息
	 * 
	 */
	public void deleteAll(int[] idList);

	/**
	 * 检查职位名是否重复
	 * 
	 * @param name
	 * @return
	 */
	public boolean checkRoleName(String name);

	/**
	 * 检查职位描述名是否重复
	 * 
	 * @param name
	 * @return
	 */
	public boolean checkRoleRemarks(String Remarks);

	/**
	 * 设置总页数
	 * 
	 * @param pageCount
	 */
	public void setPageCount(int pageCount);

	/**
	 * 批量增加
	 * 
	 */
	public void addAll(List<Role> roles);
	/**
	 * 删除全部角色下的权限
	 */
	public void deletePermAll(Integer roleId);

}
