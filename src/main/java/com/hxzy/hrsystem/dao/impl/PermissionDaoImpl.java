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

	private int pageCount;// 总页数

	@Override
	public int getPageCount() {// 得到总页数
		return pageCount;
	}

	@Override
	public void setPageCount(int pageCount) {// 设置总页数
		this.pageCount = pageCount;
	}

	/**
	 * 得到一个Session
	 * 
	 * @return
	 */
	public Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Permission> findAll() {

		List<Permission> list = this.getSession().createQuery("from Permission").list();
		return list;
	}

	@Override
	public Permission getBy(Permission permission) {
		return null;
	}

	@Override
	public Permission getById(int id) {
		Query query = this.getSession().createQuery("from Permission p where p.id =:id");// 得到Query对象
		query.setParameter("id", id);
		Permission permission2 = (Permission) query.uniqueResult();
		return permission2;
	}

	@Override
	public void add(Permission permission) {
		this.getSession().save(permission);// 增加权限
	}

	@Override
	public void update(Permission permission) {
		this.getSession().update(permission);// 更新权限
	}

	@Override
	public void delete(Permission permission) {
		this.getSession().delete(permission);// 删除权限
	}

	@Override
	public List<Permission> findAllPermissionByUserId(int userId) {
		String sql = "select p.* from tb_ROLE_PERM rp,tb_role r,tb_user_role ur,tb_Permission p where ur.user_id =? and ur.role_id = r.role_id and r.role_id = rp.ROLE_ID and rp.PERM_ID= p.perm_id";
		Session session = this.getSession();
		SQLQuery query = session.createSQLQuery(sql).addEntity(Permission.class);
		query.setInteger(1, userId);
		@SuppressWarnings("unchecked")
		List<Permission> resultList = query.list();
		return resultList;
	}

	@Override
	public List<Permission> findAllPermissionByRoleId(int roleId) {
		return null;
	}

	@Override
	public void deleteById(int id) {
		Session session = this.getSession();
		Query query = this.getSession().createQuery("from Permission p where p.id =:id");// 得到Query对象
		query.setParameter("id", id);
		Permission permission2 = (Permission) query.uniqueResult();
		session.delete(permission2);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Permission> findAllByIndex(int start, int max) {
		Session session = this.getSession();
		String hql = "from Permission";
		Query query = session.createQuery(hql);
		List<Permission> permission = query.list();
		setPageCount(permission.size());// 保存总条数
		query.setFirstResult(start);// 开始
		query.setMaxResults(max);// 每页显示条数
		List<Permission> list = query.list();
		return list;
	}

	@Override
	public int getConut() {
		Session session = this.getSession();
		String hql = "select count(*)  from Permission";
		Query query = session.createQuery(hql);
		int count = ((Long) query.iterate().next()).intValue();
		return count;
	}

	@Override
	public void deleteAll(int[] idList) {
		String hql = "";
		// 数组中封装的是ID的集合;
		for (int i = 0; i < idList.length; i++) {
			if (i == 0) {
				hql = "id=" + idList[i];
			} else {
				hql = hql + " or id=" + idList[i];
			}
		}
		Session session = this.getSession();
		Query q = session.createQuery("delete from Permission where " + hql);
		q.executeUpdate();
	}

	@Override
	public List<Permission> findAllSuperPermission() {
		String sql = "select * from tb_permission where parent_id is null";
		Session session = this.getSession();
		SQLQuery query = session.createSQLQuery(sql).addEntity(Permission.class);
		@SuppressWarnings("unchecked")
		List<Permission> resultList = query.list();
		return resultList;
	}

	@Override
	public boolean checkPermName(String name) {
		Query query = this.getSession().createQuery("from Permission p where p.permName =:name");// 得到Query对象
		query.setParameter("name", name);
		Permission permission2 = (Permission) query.uniqueResult();
		if (null == permission2) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean checkPermUrl(String url) {
		Query query = this.getSession().createQuery("from Permission p where p.url =:url");// 得到Query对象
		query.setParameter("url", url);
		Permission permission2 = (Permission) query.uniqueResult();
		if (null == permission2) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void addAll(List<Permission> permissions) {
		Session session = getSession();
		for (int i = 0; i < permissions.size(); i++) {
			Permission permission = permissions.get(i);
			session.save(permission); // 保存对象
			// 批插入的对象立即写入数据库并释放内存
			if (i % 10 == 0) {
				session.flush();
				session.clear();
			}
		}
	}

}
