package com.hxzy.hrsystem.dao.impl;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.hxzy.hrsystem.dao.RoleDao;
import com.hxzy.hrsystem.entity.Permission;
import com.hxzy.hrsystem.entity.Role;

@Component("roleDaoImpl")
public class RoleDaoImpl implements RoleDao {
	@Autowired
	private SessionFactory sessionFactory;

	/**
	 * 得到一个Session
	 * 
	 * @return
	 */
	public Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}

	@Override
	public List<Role> findAll() {
		return this.getSession().createQuery("from Role").list();
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

	@Override
	public List<Permission> findAllPermissionByRoleId(int roleId) {
		String sql = "select p.* from tb_ROLE_PERM rp,tb_Permission p where rp.role_id =? and rp.PERM_ID= p.perm_id";
		Session session = sessionFactory.getCurrentSession();
		SQLQuery query = session.createSQLQuery(sql).addEntity(Permission.class);
		query.setInteger(0, roleId);
		List<Permission> resultList = query.list();
		return resultList;
	}

}
