package com.hxzy.hrsystem.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.hxzy.hrsystem.dao.WorderDao;
import com.hxzy.hrsystem.entity.Worder;
import com.hxzy.hrsystem.service.WorderService;

@Component("worderService")
public class WorderServiceimpl implements WorderService {
	private WorderDao wd;

	@Resource(name = "worderDao")
	public void setWd(WorderDao wd) {
		this.wd = wd;
	}

	/** 查询工单 **/
	public List<Worder> findAll(int start, int end) {
		return wd.findAll(start, end);
	}

	/** 修改工单 **/
	public void updateAll(Worder worder) {
		wd.updateAll(worder);
	}

	/** 删除工单 **/
	public void deleteAll(List<Integer> list) {
		wd.deleteAll(list);
	}

	/** 添加工单 **/
	public void addAll(Worder worder) {
		wd.addAll(worder);
	}

	/** 页数 **/
	public int pageNo(int end) {
		int page = 0;
		if (wd.getPageCount() / end == 0) {
			page = wd.getPageCount() / end;
		} else {
			page = (wd.getPageCount() / end) + 1;
		}
		return page;
	}
}
