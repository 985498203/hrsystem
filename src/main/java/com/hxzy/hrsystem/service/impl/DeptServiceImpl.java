package com.hxzy.hrsystem.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.hxzy.hrsystem.dao.DeptDao;
import com.hxzy.hrsystem.entity.Dept;
import com.hxzy.hrsystem.entity.PageInfo;
import com.hxzy.hrsystem.entity.Permission;
import com.hxzy.hrsystem.service.DeptService;
@Component("deptServiceImpl")
public class DeptServiceImpl implements DeptService {

	private DeptDao deptDao;
	private int pageCount;// 总页数

	@Resource(name = "deptDaoImpl")
	public void setDeptDao(DeptDao deptDao) {
		this.deptDao = deptDao;
	}

	@Override
	public Dept findDeptByName(String name) {
		return deptDao.findByName(name);
	}

	@Override
	public List<Dept> findDeptAll() {
		return deptDao.findAll();
	}

	@Override
	public Dept getDeptById(int id) {
		return deptDao.getById(id);
	}

	@Override
	public void addDept(Dept dept) {
		deptDao.add(dept);
	}

	@Override
	public void updateDept(Dept dept) {
		deptDao.update(dept);
	}

	@Override
	public void deleteDept(Dept dept) {
		deptDao.delete(dept);
	}
	@Override
	public void deleteDeptById(int id) {
		deptDao.deleteById(id);

	}

	@Override
	public List<Dept> findAllDeptByIndex(int start, int max) {
		
		return deptDao.findAllByIndex(start, max);
	}

	@Override
	public int getPageCount() {
		return pageCount;
	}

	@Override
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	@Override
	public int getConut() {
		return deptDao.getConut();
	}

	@Override
	public void deleteDeptAll(int[] idList) {
		deptDao.deleteAll(idList);	
	}

	@Override
	public boolean checkDeptName(String name) {
		return deptDao.checkDeptName(name);
	}

	@Override
	public void addDeptAll(List<Dept> depts) {
		deptDao.addAll(depts);
	}

	@Override
	public int getTotalPages(int pagesize) {
		int totalPage = deptDao.getConut() / pagesize;
		if (deptDao.getConut() % pagesize == 0) {
			return totalPage;
		} else {
			return totalPage + 1;
		}
	}
	
	@SuppressWarnings("all")
	@Override
	public PageInfo getPageInfo(int currentPage) {
		PageInfo info = new PageInfo<Permission>();
		info.setCount(deptDao.getConut()); // 设置总记录数
		info.setTotalPages(this.getTotalPages(info.getPagesize()));// 设置总页数
		info.setCurrentPage(currentPage);// 当前页数
		List<Dept> depts = deptDao.findAllByIndex((currentPage - 1) * info.getPagesize(),
				info.getPagesize());
		info.setPageList(depts);// 设置分页的数据
		int[] nums = new int[this.getTotalPages(info.getPagesize())];
		for (int i = 0; i < nums.length; i++) {
			nums[i] = i + 1;
		}
		info.setNavigatepageNums(nums);// 设置所有导航页号
		return info;
	}

}
