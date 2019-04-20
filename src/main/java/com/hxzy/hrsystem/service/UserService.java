package com.hxzy.hrsystem.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.hxzy.hrsystem.entity.User;
@Component
public interface UserService {
	/**
	 * 查询所有
	 * 
	 * @return
	 */
	public List<User> finAllUser();

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
	public void addUser(User user);

	/**
	 * 更新
	 * 
	 * @param entity
	 */
	public void updateUsre(User user);

	/**
	 * 删除
	 * 
	 * @param entity
	 */
	public void deleteUser(User user);
}
