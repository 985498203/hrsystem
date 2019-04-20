package com.hxzy.hrsystem.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.hxzy.hrsystem.dao.UserDao;
import com.hxzy.hrsystem.entity.User;

@Component("userDaoImpl")
public class UserDaoImpl implements UserDao {
	@Autowired
	private SessionFactory sessionFactory;
	@Override
	public List<User> finAll() {
		return sessionFactory.getCurrentSession().createQuery("from User").list();
	}

	@Override
	public User getBy(User user) {
		Query query = sessionFactory.getCurrentSession()
				.createQuery("from User u where u.username = :username and u.password = :password");// 得到Query对象
		query.setString("username", user.getUsername());
		query.setString("password", user.getPassword());
		User user2 = (User) query.uniqueResult();
		return user2;
	}

	@Override
	public User getById(int id) {
		Query query = sessionFactory.getCurrentSession().createQuery("from User u where u.id =:id");// 得到Query对象
		query.setParameter("id", id);
		User user2 = (User) query.uniqueResult();
		return user2;
	}

	@Override
	public void add(User user) {
		sessionFactory.getCurrentSession().save(user);// 增加用户
	}

	@Override
	public void update(User user) {
		sessionFactory.getCurrentSession().update(user);// 更新用户

	}

	@Override
	public void delete(User user) {
		sessionFactory.getCurrentSession().delete(user);// 删除用户

	}

}
