package com.hxzy.hrsystem.service.impl;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.hxzy.hrsystem.dao.RoleDao;
import com.hxzy.hrsystem.dao.UserDao;
import com.hxzy.hrsystem.entity.Permission;
import com.hxzy.hrsystem.entity.Role;
import com.hxzy.hrsystem.entity.User;
import com.hxzy.hrsystem.entity.UserRole;
import com.hxzy.hrsystem.service.RoleService;

@Component("roleServiceImpl")
@Transactional
public class RoleServiceImpl implements RoleService {
	private UserDao userDao;
	private RoleDao roleDao;

	@Resource(name = "userDaoImpl")
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Resource(name = "roleDaoImpl")
	public void setRoleDao(RoleDao roleDao) {
		this.roleDao = roleDao;
	}

	@Override
	public List<Role> finAllRole() {
		return roleDao.finAll();
	}

	@Override
	public Role getRoleById(int id) {
		return roleDao.getById(id);
	}

	@Override
	public List<Role> findAllRoleByUserId(int userId) {
		return roleDao.findAllRoleByUserId(userId);
	}

	@Override
	public void addRole(Role role) {
		roleDao.add(role);
	}

	@Override
	public void updateRole(Role role) {
		roleDao.update(role);

	}

	@Override
	public void deleteRole(Role role) {
		roleDao.delete(role);

	}

	@Override
	public List<Permission> findAllPermissionByRoleId(int roleId) {
		return roleDao.findAllPermissionByRoleId(roleId);
	}

}
