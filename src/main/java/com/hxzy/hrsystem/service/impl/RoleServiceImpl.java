package com.hxzy.hrsystem.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.hxzy.hrsystem.dao.RoleDao;
import com.hxzy.hrsystem.dao.UserDao;
import com.hxzy.hrsystem.entity.PageInfo;
import com.hxzy.hrsystem.entity.Permission;
import com.hxzy.hrsystem.entity.Role;
import com.hxzy.hrsystem.service.RoleService;

@Component("roleServiceImpl")
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

	@Override
	public int getTotalPages(int pagesize) {
		int totalPage = roleDao.getConut() / pagesize;
		if (roleDao.getConut() % pagesize == 0) {
			return totalPage;
		} else {
			return totalPage + 1;
		}
	}

	@Override
	public PageInfo getPageInfo(int currentPage) {
		PageInfo info = new PageInfo<Permission>();
		info.setCount(roleDao.getConut()); // 设置总记录数
		info.setTotalPages(this.getTotalPages(info.getPagesize()));// 设置总页数
		info.setCurrentPage(currentPage);// 当前页数
		List<Role> roles = roleDao.findAllByIndex((currentPage - 1) * info.getPagesize(),
				info.getPagesize());
		info.setPageList(roles);// 设置分页的数据
		int[] nums = new int[this.getTotalPages(info.getPagesize())];
		for (int i = 0; i < nums.length; i++) {
			nums[i] = i+1;
		}
		info.setNavigatepageNums(nums);// 设置所有导航页号
		return info;
	}

}
