package com.hxzy.hrsystem.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.hxzy.hrsystem.dao.PermissionDao;
import com.hxzy.hrsystem.dao.UserDao;
import com.hxzy.hrsystem.entity.PageInfo;
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
	public int getTotalPages(int pagesize) {
		int totalPage = permissionDao.getConut() / pagesize;
		if (permissionDao.getConut() % pagesize == 0) {
			return totalPage;
		} else {
			return totalPage + 1;
		}

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

	@Override
	public PageInfo getPageInfo(int currentPage) {
		PageInfo info = new PageInfo<Permission>();
		info.setCount(permissionDao.getConut()); // 设置总记录数
		info.setTotalPages(this.getTotalPages(info.getPagesize()));// 设置总页数
		info.setCurrentPage(currentPage);// 当前页数
		List<Permission> permissions = permissionDao.findAllByIndex((currentPage - 1) * info.getPagesize(),
				info.getPagesize());
		info.setPageList(permissions);// 设置分页的数据
		int[] nums = new int[this.getTotalPages(info.getPagesize())];
		for (int i = 0; i < nums.length; i++) {
			nums[i] = i+1;
		}
		info.setNavigatepageNums(nums);// 设置所有导航页号
		return info;
	}

}
