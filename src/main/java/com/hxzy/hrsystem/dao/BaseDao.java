package com.hxzy.hrsystem.dao;

import java.util.List;


public interface BaseDao<T> {
	/**
	 * 查询所有
	 * 
	 * @return
	 */
	public List<T> findAll();

	/**
	 * 通过条件查询
	 * 
	 * @param entity
	 * @return
	 */
	public T getBy(T t);

	/**
	 * 通过id查询
	 * 
	 * @param id
	 * @return
	 */
	public T getById(int id);

	/**
	 * 保存
	 * 
	 * @param entity
	 */
	public void add(T t);

	/**
	 * 更新
	 * 
	 * @param entity
	 */
	public void update(T t);

	/**
	 * 删除
	 * 
	 * @param entity
	 */
	public void delete(T t);
	
	/**
	 * 删除
	 * 
	 * @param entity
	 */
	public void deleteById(int id);

}
