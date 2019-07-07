package com.bos.service;

import java.util.List;

import com.bos.entity.FixedRegion;

public interface FixedRegionService {

	/**
	 * 查询所有的顶区信息
	 * @return
	 */
	List<FixedRegion> findAll() throws Exception;
}
