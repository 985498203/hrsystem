package com.hxzy.hrsystem.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hxzy.hrsystem.dao.UserDao;
import com.hxzy.hrsystem.entity.Role;
import com.hxzy.hrsystem.entity.User;
import com.hxzy.hrsystem.entity.UserRole;

@Component("userDaoImpl")
public class UserDaoImpl implements UserDao {
	@Autowired
	private SessionFactory sessionFactory;

	private int pageCount;// 总页数

	/**
	 * 得到一个Session
	 * 
	 * @return
	 */
	public Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}

	@Override
	public int getPageCount() {
		return pageCount;
	}

	@Override
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> findAll() {
		return this.getSession().createQuery("from User").list();
	}

	@Override
	public User getBy(User user) {
		Query query = this.getSession()
				.createQuery("from User u where u.username = :username and u.password = :password");// 得到Query对象
		query.setString("username", user.getUsername());
		query.setString("password", user.getPassword());
		User user2 = (User) query.uniqueResult();
		return user2;
	}

	@Override
	public User getById(int id) {
		Query query = this.getSession().createQuery("from User u where u.id =:id");// 得到Query对象
		query.setParameter("id", id);
		User user2 = (User) query.uniqueResult();
		return user2;
	}

	@Override
	public void add(User user) {
		this.getSession().save(user);// 增加用户
	}

	@Override
	public void update(User user) {
		this.getSession().update(user);// 更新用户

	}

	@Override
	public void delete(User user) {
		this.getSession().delete(user);// 删除用户
	}

	@Override
	public void addRole(User user, Role role) {
		UserRole userRole = new UserRole();
		userRole.setRole(role);
		userRole.setUser(user);
		this.getSession().save(userRole);
	}

	@Override
	public void addRole(User user, List<Role> roleList) {
		Session session = this.getSession();
		for (int i = 0; i < roleList.size(); i++) {
			UserRole userRole = new UserRole();
			userRole.setUser(user);
			Role role = roleList.get(i);
			userRole.setRole(role);
			session.save(userRole);
			if (i % 10 == 0) {
				session.flush();
				session.clear();
			}

		}

	}

	@Override
	public User getUserByName(String userName) {
		Session session = this.getSession();
		String hql = "from User u where u.username=:username";
		Query query = session.createQuery(hql);
		query.setParameter("username", userName);
		User user2 = (User) query.uniqueResult();
		return user2;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Role> findAllRoleByUserId(int id) {
		String sql = "select r.* from tb_user_role ur,tb_role r where ur.user_id =? and ur.role_id = r.role_id";
		Session session = sessionFactory.getCurrentSession();
		SQLQuery query = session.createSQLQuery(sql).addEntity(Role.class);
		query.setInteger(1, id);
		List<Role> resultList = query.list();
		return resultList;
	}

	@Override
	public void deleteById(int id) {
		Session session = this.getSession();
		Query query = session.createQuery("delete from User u where u.userId=?");
		query.setInteger(1, id);
		query.executeUpdate();
	}

	/**
	 * 查询员工信息
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<User> findAllByIndex(int start, int end) {
		Session session = this.getSession();
		String hql = "from User";
		Query query = session.createQuery(hql);
		List<User> user = query.list();
		setPageCount(user.size());// 保存总条数
		query.setFirstResult(start);// 开始
		query.setMaxResults(end);// 每页显示条数
		List<User> list = query.list();
		return list;
	}

	/**
	 * 批量删除员工信息
	 */
	@Override
	public void deleteAll(List<Integer> list) {
		Session session = this.getSession();
		for (int i = 0; i < list.size(); i++) {
			User us = (User) session.load(User.class, list.get(i));
			if (us != null) {
				session.delete(us);
			}
		}
	}

	@Override
	public boolean addRoleById(Integer userId, Integer roleId) {
		Session session = this.getSession();
		// 查询用户
		String hql = "from User u where u.userId=?";
		Query query = session.createQuery(hql);
		query.setParameter(0, userId);
		User user = (User) query.uniqueResult();
		// 查询角色
		String hql2 = "from Role r where r.roleId=?";
		Query query2 = session.createQuery(hql2);
		query2.setParameter(0, roleId);
		Role role = (Role) query2.uniqueResult();
		if(null==user || null==role) {
			return false;
		}else {
			UserRole userRole = new UserRole();
			userRole.setUser(user);
			userRole.setRole(role);
			session.save(userRole);
		}
		return true;
	}

}
