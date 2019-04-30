package com.hxzy.hrsystem.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.hxzy.hrsystem.entity.PageInfo;
import com.hxzy.hrsystem.entity.Permission;
import com.hxzy.hrsystem.entity.Role;
import com.hxzy.hrsystem.entity.User;

@Component
public interface RoleService {
	/**
	 * 查询所有
	 * 
	 * @return
	 */
	public List<Role> findAllRole();
	/**
	 * 通过id查询
	 * 
	 * @param id
	 * @return
	 */
	public Role getRoleById(int id);

	/**
	 * 封装分页信息
	 * 
	 * @return PageInfo分页信息
	 */
	public PageInfo getPageInfo(int currentPage);
	
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
	 * @param roleId     角色id
	 * @param permIdList 权限id集合
	 * @return
	 */
	public boolean addPermAllById(Integer roleId, List<Integer> permIdList);


	

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

	/**
	 * 根据职位id查询所有权限
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
	public void deleteRoleById(int id);

	/**
	 * 职位信息分页查询
	 * 
	 * @param start 开始索引
	 * @param max   一页显示的条数
	 * @return
	 */
	public List<Role> findRoleAllByIndex(int start, int max);

	/**
	 * 得到职位信息总页数
	 * 
	 * @return
	 */
	public int getPageCount();

	/**
	 * 批量删除职位信息
	 */
	public void deleteRoleAll(int[] idList);

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
	 * 批量增加
	 */
	public void addRoleAll(List<Role> roles);
	/**
	 * 得到总页数
	 * 
	 * @return
	 */
	public int getTotalPages(int i);
}
