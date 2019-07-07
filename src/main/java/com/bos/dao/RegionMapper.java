package com.bos.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bos.entity.Region;
import com.bos.utils.Page;

public interface RegionMapper {

	/**
	 * 批量插入区域数据
	 * @param regions
	 * @return
	 */
	Integer addRegions(@Param("regions")List<Region> regions) throws Exception;
	
	/**
	 * 获取区域总记录数
	 * @return
	 */
	Integer findCount() throws Exception;
	
	/**
	 * 进行分页查询
	 * @param page
	 * @return
	 * @throws Exception
	 */
	List<Region> findAllByPage(Page<Region> page) throws Exception;

	/**
	 * 根据查询条件进行区域信息查询
	 * @param query
	 * @return
	 */
	List<Region> findAllByQuery(@Param("query")String query) throws Exception;
}
