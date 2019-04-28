package com.hxzy.hrsystem.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.hxzy.hrsystem.dao.RoleDao;
import com.hxzy.hrsystem.dao.UserDao;
import com.hxzy.hrsystem.entity.Permission;
import com.hxzy.hrsystem.entity.Role;
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
	public List<Role> findAllRole() {
		return roleDao.findAll();
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

	@Override
	public void deleteRoleById(int id) {
		roleDao.deleteById(id);

	}

	@Override
	public List<Role> findRoleAllByIndex(int start, int max) {
		return roleDao.findAllByIndex(start, max);
	}

	@Override
	public int getPageCount() {
		return roleDao.getPageCount();
	}

	@Override
	public void deleteRoleAll(int[] idList) {
		roleDao.deleteAll(idList);
	}

	@Override
	public boolean checkRoleName(String name) {
		return roleDao.checkRoleName(name);
	}

	@Override
	public boolean checkRoleRemarks(String Remarks) {
		return roleDao.checkRoleRemarks(Remarks);
	}

	@Override
	public void addRoleAll(List<Role> roles) {
		roleDao.addAll(roles);
	}

	@Override
	public boolean addPermById(Integer roleId, Integer permId) {
		return roleDao.addPermById(roleId, permId);
	}

	@Override
	public boolean addPermAllById(Integer roleId, List<Integer> permIdList) {
		return roleDao.addPermAllById(roleId, permIdList);
	}

}
