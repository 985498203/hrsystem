package com.hxzy.hrsystem.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.hxzy.hrsystem.dao.DeptDao;
import com.hxzy.hrsystem.entity.Dept;

@Component("deptDaoImpl")
public class DeptDaoImpl implements DeptDao {
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

	private int pageCount;// 总页数

	@Override
	public int getPageCount() {// 得到总页数
		return pageCount;
	}

	@Override
	public void setPageCount(int pageCount) {// 设置总页数
		this.pageCount = pageCount;
	}

	@Override
	public Dept getBy(Dept t) {

		return null;
	}

	@Override
	public Dept getById(int id) {
		Session session = this.getSession();
		Query query = session.createQuery("FROM Dept d WHERE d.deptId =:id");
		query.setParameter("id", id);
		Dept dept = (Dept) query.uniqueResult();
		return dept;
	}

	@Override
	public void add(Dept dept) {
		sessionFactory.getCurrentSession().save(dept);// 增加部门
	}

	@Override
	public void update(Dept dept) {
		sessionFactory.getCurrentSession().update(dept);// 更新部门
	}

	@Override
	public void delete(Dept dept) {
		sessionFactory.getCurrentSession().delete(dept);// 删除部门
	}

	@Override
	public void deleteById(int id) {// 根据id删除

		Session session = this.getSession();
		Query query = session.createQuery("DELETE FROM Dept d WHERE d.deptId =:id");
		query.setParameter("id", id);
		query.executeUpdate();
	}

	@Override
	public Dept findByName(String name) {// 根据id查询
		Session session = this.getSession();
		Query query = session.createQuery("DELETE FROM Dept d WHERE d.deptName =:name");
		query.setParameter("name", name);
		Dept dept = (Dept) query.uniqueResult();
		return dept;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Dept> findAll() {// 查询全部
		Session session = this.getSession();
		Query query = session.createQuery("FROM Dept");
		List<Dept> depts = query.list();
		return depts;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Dept> findAllByIndex(int start, int max) {
		Session session = this.getSession();
		String hql = "from Dept";
		Query query = session.createQuery(hql);
		List<Dept> dept = query.list();
		setPageCount(dept.size());// 保存总条数
		query.setFirstResult(start);// 开始
		query.setMaxResults(max);// 每页显示条数
		List<Dept> list = query.list();
		return list;
	}

	@Override
	public int getConut() {
		Session session = this.getSession();
		String hql = "select count(*)  from Dept";
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
		Query q = session.createQuery("delete from Dept where " + hql);
		q.executeUpdate();

	}

	@Override
	public boolean checkDeptName(String name) {
		Query query = this.getSession().createQuery("from Dept p where p.deptName =:name");// 得到Query对象
		query.setParameter("name", name);
		Dept dept = (Dept) query.uniqueResult();
		if (null == dept) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void addAll(List<Dept> depts) {
		Session session = getSession();
		for (int i = 0; i < depts.size(); i++) {
			Dept dept = depts.get(i);
			session.save(dept); // 保存对象
			// 批插入的对象立即写入数据库并释放内存
			if (i % 10 == 0) {
				session.flush();
				session.clear();
			}
		}

	}

}
