package com.hxzy.hrsystem.dao;

import com.hxzy.hrsystem.entity.User;

public interface UserDao {
	public User findUser(User user_name);	//查
	public User addUser(User user);			//增
	public User updataUser();				//改
	public User deleteUser(User id);		//删
	
	
	public User findAll();
}