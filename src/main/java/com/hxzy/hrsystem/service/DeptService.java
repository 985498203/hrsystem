package com.hxzy.hrsystem.service;

import java.util.List;

import org.springframework.stereotype.Component;
import com.hxzy.hrsystem.entity.Dept;
import com.hxzy.hrsystem.entity.PageInfo;
public interface DeptService {
	/**
	 * 根据部门名查询部门信息
	 * 
	 * @return Dept
	 */
	public Dept findDeptByName(String name);

	/**
	 * 查询全部
	 */
	public List<Dept> findDeptAll();
	/**
	 * 部门信息分页查询
	 * 
	 * @param start 开始索引
	 * @param max   一页显示的条数
	 * @return
	 */
	public List<Dept> findAllDeptByIndex(int start, int max);
	
	/**
	 * 得到总页数
	 * 
	 * @return
	 */
	public int getPageCount();
	/**
	 * 设置总页数
	 * 
	 * @param pageCount
	 */
	public void setPageCount(int pageCount);
	
	/**
	 * 获取总记录数
	 * 
	 * @return
	 */
	public int getConut();
	
	/**
	 * 批量删除部门信息
	 */
	public void deleteDeptAll(int[] idList);
	
	/**
	 * 检查部门名是否重复
	 * 
	 * @param name
	 * @return
	 */
	public boolean checkDeptName(String name);
	
	/**
	 * 批量增加
	 */
	public void addDeptAll(List<Dept> depts);
	
	/**
	 * 通过id查询
	 * 
	 * @param id
	 * @return
	 */
	public Dept getDeptById(int id);

	/**
	 * 保存
	 * 
	 * @param entity
	 */
	public void addDept(Dept dept);

	/**
	 * 更新
	 * 
	 * @param entity
	 */
	public void updateDept(Dept dept);

	/**
	 * 删除
	 * 
	 * @param entity
	 */
	public void deleteDept(Dept dept);
	
	/**
	 * 根据id删除
	 * 
	 * @param entity
	 */
	public void deleteDeptById(int id);
	/**
	 * 得到总页数
	 * 
	 * @return
	 */
	public int getTotalPages(int pagesize);
	/**
	 * 封装分页信息
	 * 
	 * @return PageInfo分页信息
	 */
	PageInfo getPageInfo(int currentPage);
}
