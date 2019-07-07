package com.bos.service;

import org.apache.ibatis.annotations.Param;

import com.bos.entity.BcArchivesDetail;

public interface BcArchivesDetailService {
	/**
	 * 添加档案明细
	 * @param detail
	 * @return
	 * @throws Exception
	 */
	Integer addBcArchivesDetail(BcArchivesDetail detail) throws Exception;
	
	/**
	 * 根据档案明细的名称进行查询
	 * @param name
	 * @return
	 */
	BcArchivesDetail findByArchivesDetailName(@Param("name") String name) throws Exception;
}
