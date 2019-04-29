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
import com.hxzy.hrsystem.entity.RolePerm;
import com.hxzy.hrsystem.entity.User;
import com.hxzy.hrsystem.entity.UserRole;

@Component("roleDaoImpl")
public class RoleDaoImpl implements RoleDao {
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

	@Override
	public void deleteById(int id) {
		Session session = this.getSession();
		Query query = session.createQuery("delete form Role r where r.roleId=?");
		query.setInteger(0, id);
		query.executeUpdate();
	}

	@Override
	public List<Role> findAllByIndex(int start, int max) {
		Session session = this.getSession();
		String hql = "from Role";
		Query query = session.createQuery(hql);
		List<Role> roles = query.list();
		setPageCount(roles.size());// 保存总条数
		query.setFirstResult(start);// 开始
		query.setMaxResults(max);// 每页显示条数
		List<Role> list = query.list();
		return list;
	}

	@Override
	public int getPageCount() {
		return pageCount;
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
		Query q = session.createQuery("delete from Role where " + hql);
		q.executeUpdate();
	}

	@Override
	public boolean checkRoleName(String roleName) {
		Query query = this.getSession().createQuery("from Role r where r.roleName =:roleName");// 得到Query对象
		query.setParameter("roleName", roleName);
		Role role2 = (Role) query.uniqueResult();
		if (null == role2) {// 数据库没有这数据,可用
			return true;
		} else {// 数据库有这数据,不可用
			return false;
		}
	}

	@Override
	public boolean checkRoleRemarks(String remarks) {
		Query query = this.getSession().createQuery("from Role r where r.remarks =:remarks");// 得到Query对象
		query.setParameter("remarks", remarks);
		Role role2 = (Role) query.uniqueResult();
		if (null == role2) {// 数据库没有这数据,可用
			return true;
		} else {// 数据库有这数据,不可用
			return false;
		}
	}

	@Override
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	@Override
	public void addAll(List<Role> roles) {
		Session session = getSession();
		for (int i = 0; i < roles.size(); i++) {
			Role role = roles.get(i);
			session.save(role); // 保存对象
			// 批插入的对象立即写入数据库并释放内存
			if (i % 10 == 0) {
				session.flush();
				session.clear();
			}
		}
	}

	@Override
	public boolean addPermById(Integer roleId, Integer permId) {
		Session session = this.getSession();
		// 查询角色
		String hql2 = "from Role r where r.roleId=?";
		Query query2 = session.createQuery(hql2);
		query2.setParameter(0, roleId);
		Role role = (Role) query2.uniqueResult();
		// 查询权限
		String hql = "from Permission p where p.permId=?";
		Query query = session.createQuery(hql);
		query.setParameter(0, permId);
		Permission permission = (Permission) query.uniqueResult();
		// 查询是否有关联数据
		String sql = "select * from tb_role_perm r where r.role_id=? and perm_id=?";
		SQLQuery sqlQuery = session.createSQLQuery(sql).addEntity(RolePerm.class);
		sqlQuery.setParameter(0, roleId);
		sqlQuery.setParameter(1, permId);
		RolePerm rolePerm = (RolePerm) sqlQuery.uniqueResult();

		if (null == permission || null == role || null != rolePerm) {
			return false;
		} else {
			RolePerm rolePerm2 = new RolePerm();
			rolePerm2.setPermission(permission);
			rolePerm2.setRole(role);
			session.save(rolePerm2);
		}
		return true;
	}

	@Override
	public boolean addPermAllById(Integer roleId, List<Integer> permIdList) {
		Session session = this.getSession();
		// 查询角色
		String hql2 = "from Role r where r.roleId=?";
		Query query2 = session.createQuery(hql2);
		query2.setParameter(0, roleId);
		Role role = (Role) query2.uniqueResult();
		if (null == role) {// id错误
			System.out.println("roleID ERROR");
			
			return false;
		} else {
			for (int i = 0; i < permIdList.size(); i++) {
				int permId = permIdList.get(i);

				// 查询权限
				String hql = "from Permission p where p.permId=?";
				Query query = session.createQuery(hql);
				query.setParameter(0, permId);
				Permission permission = (Permission) query.uniqueResult();
				// 查询是否有关联数据
				String sql = "select * from tb_role_perm r where r.role_id=? and r.perm_id=?";

				SQLQuery sqlQuery = session.createSQLQuery(sql).addEntity(RolePerm.class);
				sqlQuery.setParameter(0, roleId);
				sqlQuery.setParameter(1, permId);

				RolePerm rolePerm = (RolePerm) sqlQuery.uniqueResult();

				if (null == permission || null == role || null != rolePerm) {
					System.out.println("permission，rolePerm ERROR");
					return false;
					
				} else {
					RolePerm rolePerm2 = new RolePerm();
					rolePerm2.setPermission(permission);
					rolePerm2.setRole(role);
					session.save(rolePerm2);

					// 批插入的对象立即写入数据库并释放内存
					if (i % 10 == 0) {
						session.flush();
						session.clear();
					}
				}
			}
		}
		return true;
	}

	@Override
	public int getConut() {
		Session session = this.getSession();
		String hql = "select count(*) from Role";
		Query query = session.createQuery(hql);
		int count = ((Long) query.iterate().next()).intValue();
		return count;
	}

}
