package com.hxzy.hrsystem.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

import com.hxzy.hrsystem.dao.WorderDao;
import com.hxzy.hrsystem.entity.Worder;

@Component("worderDao")
public class WorderDaoimpl implements WorderDao {
	private SessionFactory factory;
	private int pageCount;

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public int getPageCount() {
		return pageCount;
	}

	@Resource
	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}

	/** 查询工单信息 **/
	@SuppressWarnings("unchecked")
	public List<Worder> findAll(int start, int end) {
		Session session = factory.openSession();
		String hql = "from Worder";
		Query query = session.createQuery(hql);
		List<Worder> list = query.list();
		setPageCount(list.size());// 总条数
		query.setFirstResult(start);// 开始条数
		query.setMaxResults(end);// 每页显示条数
		List<Worder> worder = query.list();
		session.close();
		return worder;
	}

	/** 修改工单 **/
	public void updateAll(Worder worder) {
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		Worder wd = (Worder) session.get(Worder.class, worder.getWorderId());
		wd.setWorderId(worder.getWorderId());
		wd.setTitle(worder.getTitle());
		wd.setDetail(worder.getDetail());
		wd.setState(worder.getState());
		session.update(wd);
		tx.commit();
		session.close();
	}

	/** 删除工单 **/
	public void deleteAll(List<Integer> list) {
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		for (int i = 0; i < list.size(); i++) {
			Worder wd = (Worder) session.load(Worder.class, list.get(i));
			if (wd != null) {
				session.delete(wd);
			}
		}
		tx.commit();
		session.close();
	}

	/** 添加工单 **/
	public void addAll(Worder worder) {

	}

}
