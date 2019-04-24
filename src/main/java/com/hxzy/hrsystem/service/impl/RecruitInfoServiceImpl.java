package com.hxzy.hrsystem.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.hxzy.hrsystem.dao.RecruitInfoDao;
import com.hxzy.hrsystem.entity.RecruitInfo;
import com.hxzy.hrsystem.service.RecruitInfoService;

@Service
@Component("recruitInfoServiceImpl")
public class RecruitInfoServiceImpl implements RecruitInfoService {

	private RecruitInfoDao recruitInfoDao;
	@Resource(name="recruitInfoDao")
	public void setRecruitInfoDao(RecruitInfoDao recruitInfoDao) {
		this.recruitInfoDao = recruitInfoDao;
	}

	
	//查询工单
	@Override
	public List<RecruitInfo> findRecruitInfoAll() {
		// TODO Auto-generated method stub
		return this.recruitInfoDao.findRecruitInfoAll();
	}


	@Override
	public void addRecruitInfo(RecruitInfo recruitInfo) {
		// TODO Auto-generated method stub
		recruitInfoDao.addRecruitInfo(recruitInfo);
	}


	//改
	@Override
	public void updataRecruitInfo(RecruitInfo recruitInfo) {
		// TODO Auto-generated method stub
		recruitInfoDao.updataRecruitInfo(recruitInfo);
	}


	@Override
	public void deleteRecruitInfo(RecruitInfo id) {
		// TODO Auto-generated method stub
		recruitInfoDao.deleteRecruitInfo(id);
	}

	//根据ID查询
	@Override
	public void findRecruitInfoById(int id) {
		// TODO Auto-generated method stub
		recruitInfoDao.findRecruitInfoById(id);
	}

	
}