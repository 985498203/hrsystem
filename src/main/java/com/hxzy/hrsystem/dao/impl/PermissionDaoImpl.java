package com.hxzy.hrsystem.dao.impl;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hxzy.hrsystem.dao.PermissionDao;
import com.hxzy.hrsystem.entity.Permission;

@Component("permissionDaoImpl")
public class PermissionDaoImpl implements PermissionDao {
	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<Permission> finAll() {
		return sessionFactory.getCurrentSession().createQuery("from Permission").list();
	}

	@Override
	public Permission getBy(Permission permission) {
		return null;
	}

	@Override
	public Permission getById(int id) {
		Query query = sessionFactory.getCurrentSession().createQuery("from Permission p where p.id =:id");// 得到Query对象
		query.setParameter("id", id);
		Permission permission2 = (Permission) query.uniqueResult();
		return permission2;
	}

	@Override
	public void add(Permission permission) {
		sessionFactory.getCurrentSession().save(permission);// 增加权限
	}

	@Override
	public void update(Permission permission) {
		sessionFactory.getCurrentSession().update(permission);// 更新权限
	}

	@Override
	public void delete(Permission permission) {
		sessionFactory.getCurrentSession().delete(permission);// 删除权限
	}

	@Override
	public List<Permission> findAllPermissionByUserId(int userId) {
		String sql = "select p.* from tb_ROLE_PERM rp,tb_role r,tb_user_role ur,tb_Permission p where ur.user_id =? and ur.role_id = r.role_id and r.role_id = rp.ROLE_ID and rp.PERM_ID= p.perm_id";
		Session session = sessionFactory.getCurrentSession();
		SQLQuery query = session.createSQLQuery(sql).addEntity(Permission.class);
		query.setInteger(0, userId);
		@SuppressWarnings("unchecked")
		List<Permission> resultList = query.list();
		return resultList;
	}

	@Override
	public List<Permission> findAllPermissionByRoleId(int roleId) {
		
		return null;
	}

}
