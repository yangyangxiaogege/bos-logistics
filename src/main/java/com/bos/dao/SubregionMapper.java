package com.bos.dao;

import com.bos.entity.Subregion;

public interface SubregionMapper {

	/**
	 * 添加分区
	 * @param subregion
	 * @return
	 */
	Integer add(Subregion subregion) throws Exception;
}
