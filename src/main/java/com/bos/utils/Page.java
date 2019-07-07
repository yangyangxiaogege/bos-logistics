package com.bos.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * 分页
 * @author ASUS
 *
 */
public class Page<T> {
	private Integer pageNo = 1; // 当前页
	private Integer pageSize = 8; // 页面大小
	private Integer pageStart = 0; // 起始下标
	private Integer totalCount = 0; // 总记录数
	private Integer totalPage = 1; // 总页数
	private List<T> data = new ArrayList<T>(); // 当前页数据
	
	public Integer getPageNo() {
		return pageNo;
	}
	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Integer getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}
	public Integer getTotalPage() {
		if (totalCount % pageSize == 0) {
			return totalCount/pageSize; 
		}else {
			return totalCount/pageSize+1; 			
		}
	}
	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}
	public Integer getPageStart() {
		return (pageNo-1)*pageSize;
	}
	public void setPageStart(Integer pageStart) {
		this.pageStart = pageStart;
	}
	public List<T> getData() {
		return data;
	}
	public void setData(List<T> data) {
		this.data = data;
	}
}
