package com.hxzy.hrsystem.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.hxzy.hrsystem.dao.PermissionDao;
import com.hxzy.hrsystem.dao.UserDao;
import com.hxzy.hrsystem.entity.NodeTree;
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
	
	@SuppressWarnings("all")
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
			nums[i] = i + 1;
		}
		info.setNavigatepageNums(nums);// 设置所有导航页号
		return info;
	}

	@Override
	public List<Permission> getAllRootPermission() {
		return permissionDao.findAllSuperPermission();
	}

	@Override
	public boolean checkPermName(String name) {
		return permissionDao.checkPermName(name);
	}

	@Override
	public boolean checkPermUrl(String url) {
		return permissionDao.checkPermUrl(url);
	}

	@Override
	public void addAll(List<Permission> permissions) {
		permissionDao.addAll(permissions);
	}

	@Override
	public List<NodeTree> getNodeTree() {
		
		List<NodeTree> rootTrees = new ArrayList<NodeTree>();//顶级节点集合
		List<Permission> rootPermissions= permissionDao.findAllSuperPermission();//获取顶级权限集合
		
		
		for (Permission permission : rootPermissions) {
			System.out.println();
			NodeTree rootNodeTree = new NodeTree(permission.getPermId(),0, permission.getPermName(), true, true) ; //转换为NodeTree
			List<Permission> childrenList  = permissionDao.getAllPermissionByPid(permission.getPermId());//根据pid查询子权限集合
			List<NodeTree> childrenTrees = new ArrayList<NodeTree>();//子节点集合
			
			for (Permission permission2 : childrenList) {
				NodeTree nodeTree2 = new NodeTree(permission2.getPermId(),permission.getPermId(), permission2.getPermName(), true, true) ; //转换为NodeTree
				childrenTrees.add(nodeTree2);	//添加至子节点集合	
			}
			rootNodeTree.setChildren(childrenTrees);//设置子节点
			rootTrees.add(rootNodeTree);//添加
		}
		return rootTrees;
	}

	@Override
	public List<Permission> getAllPermissionByPid(Integer permId) {
		
		return permissionDao.getAllPermissionByPid( permId);
	}
}
