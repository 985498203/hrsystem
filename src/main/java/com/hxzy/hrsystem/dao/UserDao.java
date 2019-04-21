package com.hxzy.hrsystem.dao;

import java.util.List;

import org.hibernate.Query;

import com.hxzy.hrsystem.entity.User;

public interface UserDao extends BaseDao<User> {
	/**
	 * 执行sql查询语句
	 * 
	 * @param sql
	 * @return
	 */
	public List queryBySql(String sql);

	/**
	 * 执行sql语句
	 * 
	 * @param sql
	 * @return
	 */
	public int excuteBySql(String sql);

	/**
	 * 执行hql查询语句
	 * 
	 * @param hql
	 * @return
	 */
	public List queryByHql(String hql);

	/**
	 * 执行hql语句
	 * 
	 * @param hql
	 * @return
	 */
	public int excuteByHql(String hql);

}
