package com.bos.service;

import java.util.List;

import com.bos.entity.Region;
import com.bos.utils.Page;

public interface RegionService {
	/**
	 * 批量插入区域数据
	 * @param regions
	 * @return
	 */
	Integer addRegions(List<Region> regions) throws Exception;
	
	/**
	 * 获取区域总记录数
	 * @return
	 */
	Integer findCount() throws Exception;
	
	/**
	 * 分页查询
	 * @param page
	 * @return
	 * @throws Exception
	 */
	Page<Region> findAllByPage(Page<Region> page) throws Exception;

	
	/**
	 * 根据条件进行区域查询
	 * @param query
	 * @return
	 */
	List<Region> findAllByQuery(String query) throws Exception;
}
