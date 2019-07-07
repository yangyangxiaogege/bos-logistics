package com.bos.dao;

import java.util.List;

import com.bos.entity.FixedRegion;

public interface FixedRegionMapper {
	
	/**
	 * 查询所有的顶区信息
	 * @return
	 */
	List<FixedRegion> findAll() throws Exception;
}
