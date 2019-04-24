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

import com.hxzy.hrsystem.dao.RecruitInfoDao;
import com.hxzy.hrsystem.entity.RecruitInfo;

@SuppressWarnings("all")
@Component("recruitInfoDao")
@Repository(value="recruitInfoDao")
@Transactional
public class RecruitInfoDaoImpl implements RecruitInfoDao {

	private SessionFactory sessionFactory;
	@Resource
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory=sessionFactory;
	}
	
	private Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}
	
	//查询工单
	@Override	
	public List<RecruitInfo> findRecruitInfoAll() {
		// TODO Auto-generated method stub
		String hql = "FROM RecruitInfo";
//		List<Worder> list = this.getHibernateTemplate().find(hql);
		return this.getSession().createQuery(hql).list();
	}

	//增
	@Override
	public void addRecruitInfo(RecruitInfo recruitInfo) {
		// TODO Auto-generated method stub
		
		getSession().save(recruitInfo);
	}

	//改
	@Override
	public void updataRecruitInfo(RecruitInfo recruitInfo) {
		// TODO Auto-generated method stub
		getSession().update(recruitInfo);
	}

	//删
	@Override
	public void deleteRecruitInfo(RecruitInfo id) {
		// TODO Auto-generated method stub
		String hql = "DELETE FROM Worder WHERE worderId = :worderId";
		Query query = getSession().createQuery(hql);
		RecruitInfo recruitInfo = (RecruitInfo) query.uniqueResult();
		query.setParameter("worderId", id);
		query.executeUpdate();
		getSession().delete(id);
	}

	//根据ID查询
	@Override
	public void findRecruitInfoById(int id) {
		// TODO Auto-generated method stub
		String hql = "FROM Worder WHERE worderId = :worderId";
		Query query = getSession().createQuery(hql);
		query.setParameter("worderId", id);
		RecruitInfo recruitInfo = (RecruitInfo) query.list().get(id);
		
	}
}