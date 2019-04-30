package com.hxzy.hrsystem.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.hxzy.hrsystem.entity.Role;
import com.hxzy.hrsystem.entity.User;

@Component
public interface UserService {
	/**
	 * 查询所有
	 * 
	 * @return
	 */
	public List<User> findAllUser();

	/**
	 * 通过条件查询
	 * 
	 * @param entity
	 * @return
	 */
	public User getByUser(User user);

	/**
	 * 通过id查询
	 * 
	 * @param id
	 * @return
	 */
	public User getUserById(int id);

	/**
	 * 保存
	 * 
	 * @param entity
	 */
	public boolean addUser(User user);

	/**
	 * 通过id添加角色
	 * 
	 * @param userId 用户id
	 * @param roleId 角色id
	 * @return
	 */
	public boolean addRoleById(Integer userId, Integer roleId);

	/**
	 * 更新
	 * 
	 * @param entity
	 */
	public boolean updateUsre(User user);

	/**
	 * 删除
	 * 
	 * @param entity
	 */
	public boolean deleteUser(User user);

	/**
	 * 添加一个职位
	 */
	public boolean addRole(User user, Role role);

	/**
	 * 添加多个职位
	 */
	public boolean addRole(User user, List<Role> roleList);

	/**
	 * 通过Name查询用户
	 */
	public User getUserByName(String username);

	/**
	 * 根据用户id查询职位
	 * 
	 * @param id
	 * @return
	 */
	public List<Role> findAllRoleByUserId(int id);

	/**
	 * 通过id删除
	 * 
	 * @param id
	 */
	public void deleteUserById(int id);

	/** 根据范围查询员工信息 **/
	public List<User> findUserAllByIndex(int start, int end);

	/** 批量删除员工信息 **/
	public void deleteUserAll(List<Integer> userIdList);

	/** 总页数 **/
	public int pageNo(int end);

	

}
