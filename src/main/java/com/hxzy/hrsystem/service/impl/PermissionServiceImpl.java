package com.hxzy.hrsystem.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.hxzy.hrsystem.dao.PermissionDao;
import com.hxzy.hrsystem.dao.UserDao;
import com.hxzy.hrsystem.entity.Permission;
import com.hxzy.hrsystem.entity.Role;
import com.hxzy.hrsystem.service.PermissionService;

@Component("permissionServiceImpl")
public class PermissionServiceImpl implements PermissionService {
	private UserDao userDao;
	private PermissionDao permissionDao;

	@Resource(name = "userDaoImpl")
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Resource(name = "permissionDaoImpl")
	public void setPermissionDao(PermissionDao permissionDao) {
		this.permissionDao = permissionDao;
	}

	@Override
	public List<Permission> findAllPermission() {
		return permissionDao.findAll();
	}

	@Override
	public Permission getPermissionById(int id) {
		return permissionDao.getById(id);
	}

	@Override
	public void addPermission(Permission permission) {
		permissionDao.add(permission);
	}

	@Override
	public void updatePermission(Permission permission) {
		permissionDao.update(permission);

	}

	@Override
	public void deletePermission(Permission permission) {
		permissionDao.delete(permission);

	}

	@Override
	public List<Permission> findAllPermissionByUserId(int userId) {
		return permissionDao.findAllPermissionByUserId(userId);
	}

	@Override
	public List<Permission> findAllPermissionByRoleId(int roleId) {

		return permissionDao.findAllPermissionByRoleId(roleId);
	}

	@Override
	public void deletePermissionById(int id) {
		permissionDao.deleteById(id);
	}

	@Override
	public List<Permission> findAllPermissionByIndex(int start, int max) {
		return permissionDao.findAllByIndex(start, max);
	}

	@Override
	public int pageNo(int max) {
		int page = 0;
		if (permissionDao.getPageCount() / max == 0) {
			page = permissionDao.getPageCount() / max;
		} else {
			page = (permissionDao.getPageCount() / max) + 1;
		}
		return page;
	}

	/**
	 * 获取总记录数
	 * 
	 * @return
	 */
	@Override
	public int getConut() {
		return permissionDao.getConut();

	}

	@Override
	public void deletePermissionAll(int[] idArray) {
		permissionDao.deleteAll(idArray);
	}

}
