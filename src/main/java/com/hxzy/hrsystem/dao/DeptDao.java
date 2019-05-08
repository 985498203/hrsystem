package com.hxzy.hrsystem.dao;

import java.util.List;

import com.hxzy.hrsystem.entity.Dept;

public interface DeptDao extends BaseDao<Dept> {
	/**
	 * 根据部门名查询部门信息
	 * 
	 * @return
	 */
	public Dept findByName(String name);
	
	/**
	 * 部门信息分页查询
	 * 
	 * @param start 开始索引
	 * @param max   一页显示的条数
	 * @return
	 */
	public List<Dept> findAllByIndex(int start, int max);
	
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
	public void deleteAll(int[] idList);
	
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
	public void addAll(List<Dept> depts);
}
