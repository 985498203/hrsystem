package com.hxzy.hrsystem.entity;

import java.util.List;

public class PageInfo<T> {
	public static final Integer PAGESIZE = 5;// 一页显示多少条数据
	private Integer count;// 总记录数
	private List<T> pageList;// 当前页的记录集合
	private Integer currentPage;// 当前页数
	private Integer totalPages;// 总页数

	public Integer getCount() {
		return count;
	}

	public static Integer getPagesize() {
		return PAGESIZE;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public List<T> getPageList() {
		return pageList;
	}

	public void setPageList(List<T> pageList) {
		this.pageList = pageList;
	}

	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public Integer getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(Integer totalPages) {
		this.totalPages = totalPages;
	}
}
