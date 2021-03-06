package com.hxzy.hrsystem.service;

import java.util.List;

import com.hxzy.hrsystem.entity.RecruitInfo;

public interface RecruitInfoService {
	public List<RecruitInfo> findRecruitInfoAll();//查询工单
	
	public void addRecruitInfo(RecruitInfo recruitInfo);//增
	
	public void updataRecruitInfo(RecruitInfo recruitInfo);//改
	
	public void deleteRecruitInfo(int id);//删
	
	public void findRecruitInfoById(int id);//根据ID查询
}
