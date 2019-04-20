package com.hxzy.hrsystem.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.hxzy.hrsystem.dao.UserDao;
import com.hxzy.hrsystem.entity.User;
import com.hxzy.hrsystem.service.UserService;

@Component
@Transactional
public class UserServiceImpl implements UserService {

	public UserDao userDao;

	@Resource(name = "userDaoImpl")
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public List<User> finAllUser() {

		return userDao.finAll();
	}

	@Override
	public User getByUser(User user) {
		return userDao.getBy(user);
	}

	@Override
	public User getUserById(int id) {

		return userDao.getById(id);
	}

	@Override
	public void addUser(User user) {
		userDao.add(user);
	}

	@Override
	public void updateUsre(User user) {
		userDao.update(user);
	}

	@Override
	public void deleteUser(User user) {
		userDao.delete(user);
	}

}
