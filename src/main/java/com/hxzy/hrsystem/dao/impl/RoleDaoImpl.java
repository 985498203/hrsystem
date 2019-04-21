package com.hxzy.hrsystem.dao.impl;

import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.hxzy.hrsystem.dao.RoleDao;
import com.hxzy.hrsystem.entity.Role;

@Component("roleDaoImpl")
public class RoleDaoImpl implements RoleDao {
	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<Role> finAll() {
		return sessionFactory.getCurrentSession().createQuery("from Role").list();
	}

	@Override
	public Role getBy(Role role) {
		return null;
	}

	@Override
	public Role getById(int id) {
		Query query = sessionFactory.getCurrentSession().createQuery("from Role r where r.id =:id");// 得到Query对象
		query.setParameter("id", id);
		Role role2 = (Role) query.uniqueResult();
		return role2;
	}

	@Override
	public void add(Role role) {
		sessionFactory.getCurrentSession().save(role);// 增加职位
	}

	@Override
	public void update(Role role) {
		sessionFactory.getCurrentSession().update(role);// 更新职位
	}

	@Override
	public void delete(Role role) {
		sessionFactory.getCurrentSession().delete(role);// 删除职位
	}

	@Override
	public List<Role> findAllRoleByUserId(int userId) {
		String sql = "select r.* from tb_user_role ur,tb_role r where ur.user_id =? and ur.role_id = r.role_id";
		Session session = sessionFactory.getCurrentSession();
		SQLQuery query = session.createSQLQuery(sql).addEntity(Role.class);
		query.setInteger(0, userId);
		List<Role> resultList = query.list();
		return resultList;
	}

}
