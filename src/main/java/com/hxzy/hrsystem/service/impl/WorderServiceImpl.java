package com.hxzy.hrsystem.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.hxzy.hrsystem.dao.WorderDao;
import com.hxzy.hrsystem.entity.Worder;
import com.hxzy.hrsystem.service.WorderService;

@Service
@Component("worderServiceImpl")
public class WorderServiceImpl implements WorderService {

	private WorderDao worderDao;
	@Resource(name="worderDao")
	public void setWorderDao(WorderDao worderDao) {
		this.worderDao = worderDao;
	}
	
	//查询工单
	@Override
	public List<Worder> findWorderAll() {
		// TODO Auto-generated method stub
		return this.worderDao.findWorderAll();
	}


	@Override
	public void addWorder(Worder worder) {
		// TODO Auto-generated method stub
		worderDao.addWorder(worder);
	}


	//改
	@Override
	public void updataWorder(Worder worder) {
		// TODO Auto-generated method stub
		worderDao.updataWorder(worder);
	}


	@Override
	public void deleteWorder(Worder id) {
		// TODO Auto-generated method stub
		worderDao.deleteWorder(id);
	}

	//根据ID查询
	@Override
	public void findWorderById(int id) {
		// TODO Auto-generated method stub
		worderDao.findWorderById(id);
	}

	
}