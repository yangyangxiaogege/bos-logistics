package com.bos.dao;

import org.apache.ibatis.annotations.Param;

import com.bos.entity.BcArchivesDetail;

/**
 * 档案信息mapper接口
 * @author ASUS
 *
 */
public interface BcArchivesDetailMapper {

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
