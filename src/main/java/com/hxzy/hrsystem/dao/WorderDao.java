package com.hxzy.hrsystem.dao;

import java.util.List;

import com.hxzy.hrsystem.entity.Worder;

public interface WorderDao {
	public List<Worder> findWorderAll();//查询工单
	
	public void addWorder(Worder worder);//增
	
	public void updataWorder(Worder worder);//改
	
	public void deleteWorder(Worder id);//删
	
	public void findWorderById(int id);//根据ID查询
}
