package com.hxzy.hrsystem.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import com.hxzy.hrsystem.dao.UserDao;
import com.hxzy.hrsystem.entity.User;

@Component
public class UserDaoImpl implements UserDao {

	private SessionFactory sessionFactory;

	@Resource
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> finAll() {
		Session session = null;
		List<User> userList = null;
		try {
			userList = new ArrayList<User>();
			session = sessionFactory.openSession();// 打开session
			userList = session.createQuery("from User").list();// 得到所有用户集合
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (null != session) {
				session.close();// 关闭session
			}
		}
		return userList;
	}

	@Override
	public User getBy(User user) {
		Session session = null;
		User user2 = null;
		try {
			session = sessionFactory.openSession();// 打开session
			Query query = session.createQuery("from User u where u.username = :username and u.password = :password");// 得到Query对象
			query.setString("username", user.getUsername());
			query.setString("password", user.getPassword());
			user2 = (User) query.uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (null != session) {
				session.close();// 关闭session
			}
		}
		return user2;
	}

	@Override
	public User getById(int id) {
		Session session = null;
		User user2 = null;
		try {
			session = sessionFactory.openSession();// 打开session
			Query query = session.createQuery("from User u where u.id =:id");// 得到Query对象
			query.setParameter("id", id);
			user2 = (User) query.uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (null != session) {
				session.close();// 关闭session
			}
		}
		return user2;
	}

	@Override
	public void save(User user) {
		Session session = null;
		try {
			session = sessionFactory.openSession();// 打开session
			session.save(user);// 增加用户
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (null != session) {
				session.close();// 关闭session
			}
		}

	}

	@Override
	public void update(User user) {
		Session session = null;
		try {
			session = sessionFactory.openSession();// 打开session
			session.update(user);// 更新用户
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (null != session) {
				session.close();// 关闭session
			}
		}

	}

	@Override
	public void delete(User user) {
		Session session = null;
		try {
			session = sessionFactory.openSession();// 打开session
			session.delete(user);// 删除用户
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (null != session) {
				session.close();// 关闭session
			}
		}

	}

}
