package com.hxzy.hrsystem.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hxzy.hrsystem.dao.WorderDao;
import com.hxzy.hrsystem.entity.Worder;

@SuppressWarnings("all")
@Component("worderDao")
@Repository(value = "worderDao")
@Transactional
public class WorderDaoImpl implements WorderDao {

	private SessionFactory sessionFactory;

	@Resource
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	private Session getSession() {
		return this.sessionFactory.openSession();
	}

	// 查询工单
	@Override
	public List<Worder> findWorderAll() {
		// TODO Auto-generated method stub
		String hql = "FROM Worder";
		Query query = getSession().createQuery(hql);
		List<Worder> list = query.list();
//		List<Worder> list = this.getHibernateTemplate().find(hql);
		return list;
	}

	// 增
	@Override
	public void addWorder(Worder worder) {
		// TODO Auto-generated method stub

		getSession().save(worder);
	}

	// 改
	@Override
	public void updataWorder(Worder worder) {
		// TODO Auto-generated method stub
		getSession().update(worder);
	}

	// 删
	@Override
	public void deleteWorder(Worder id) {
		// TODO Auto-generated method stub
		String hql = "DELETE FROM Worder WHERE worderId = :worderId";
		Query query = getSession().createQuery(hql);
		Worder worder = (Worder) query.uniqueResult();
		query.setParameter("worderId", id);
		query.executeUpdate();
		getSession().delete(id);
	}

	// 根据ID查询
	@Override
	public void findWorderById(int id) {
		// TODO Auto-generated method stub
		String hql = "FROM Worder WHERE worderId = :worderId";
		Query query = getSession().createQuery(hql);
		query.setParameter("worderId", id);
		Worder worder = (Worder) query.list().get(id);

	}
}