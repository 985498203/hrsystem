package com.hxzy.hrsystem.service;

import java.util.List;

import com.hxzy.hrsystem.entity.Worder;

public interface WorderService {
	/** 查询工单信息 **/
	public List<Worder> findAll(int start, int end);

	/** 修改工单信息 **/
	public void updateAll(Worder worder);

	/** 删除工单信息 **/
	public void deleteAll(List<Integer> list);

	/** 添加工单信息 **/
	public void addAll(Worder worder);

	/** 总页数 **/
	public int pageNo(int end);
}
