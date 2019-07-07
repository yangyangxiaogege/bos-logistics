package com.bos.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bos.entity.BcArchives;

/**
 * 档案信息mapper接口
 * @author ASUS
 *
 */
public interface BcArchivesMapper {
	
	/**
	 * 获取所有的档案信息
	 * 包括档案下的明细
	 * @return
	 */
	List<BcArchives> findArchivesList() throws Exception;
	
	/**
	 * 根据id或名称获取所有匹配的基础档案
	 * @param id 档案id
	 * @param archivesName 档案名称
	 * @return
	 */
	List<BcArchives> findAll(@Param("id") Integer id,@Param("archivesName") String archivesName) throws Exception;
	
	/**
	 * 根据档案名称进行查询
	 * @param name
	 * @return
	 * @throws Exception
	 */
	BcArchives findByArchivesName(@Param("name")String name) throws Exception;
}
