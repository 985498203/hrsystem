package com.hxzy.hrsystem.service.impl;


import com.hxzy.hrsystem.entity.User;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.hxzy.hrsystem.dao.RoleDao;
import com.hxzy.hrsystem.dao.UserDao;
import com.hxzy.hrsystem.entity.Role;
import com.hxzy.hrsystem.entity.User;
import com.hxzy.hrsystem.service.UserService;

@Component
public class UserServiceImpl implements UserService {

	public UserDao userDao;
	public RoleDao roleDao;

	@Resource(name = "roleDaoImpl")
	public void setRoleDao(RoleDao roleDao) {
		this.roleDao = roleDao;
	}

	@Resource(name = "userDaoImpl")
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public List<User> findAllUser() {

		return userDao.findAll();
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
	public boolean addUser(User user) {
		User user2 = userDao.getUserByName(user.getUsername());
		if (null != user2) {
			return false;
		} else {
			userDao.add(user);
			return true;
		}
	}

	@Override
	public boolean updateUsre(User user) {
		try {
			userDao.update(user);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	@Override
	public boolean deleteUser(User user) {
		try {
			userDao.delete(user);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean addRole(User user, Role role) {
		try {
			User user2 = userDao.getById(user.getUserId());// 查询用户是否存在
			if (null == user2) {
				return false;
			} else {
				Role role2 = roleDao.getById(role.getRoleId());// 查询角色是否存在
				if (null == role2) {
					return false;
				} else {
					userDao.addRole(user2, role);
					return true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	@Override
	public boolean addRole(User user, List<Role> roleList) {
		try {
			User user2 = userDao.getById(user.getUserId());// 查询用户是否存在
			if (null == user2) {
				return false;
			} else {
				for (Role role2 : roleList) {
					Role role3 = roleDao.getById(role2.getRoleId());// 查询角色是否存在
					if (null == role3) {
						return false;//有一个不存在则返回false;
					}
				}
				userDao.addRole(user2, roleList);
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	@Override
	public User getUserByName(String username) {
		return userDao.getUserByName(username);
	}

	@Override
	public List<Role> findAllRoleByUserId(int id) {
		return userDao.findAllRoleByUserId(id);
	}

	@Override
	public void deleteUserById(int id) {
		userDao.deleteById(id);
	}

	@Override
	public List<User> findUserAllByIndex(int start, int end) {
		return userDao.findAllByIndex(start, end);
	}

	@Override
	public void deleteUserAll(List<Integer> userIdList) {
		userDao.deleteAll(userIdList);
	}

	@Override
	public int pageNo(int end) {
		int page = 0;
		if (userDao.getPageCount() / end == 0) {
			page = userDao.getPageCount() / end;
		} else {
			page = (userDao.getPageCount() / end) + 1;
		}
		return page;
	}

}
