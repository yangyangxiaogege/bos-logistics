package com.bos.dao;

import java.util.List;

import com.bos.entity.Courier;

public interface CourierMapper {
	/**
	 * 查询出所有的取派员和创建人
	 * @return
	 */
	List<Courier> findAllCourierAndUser() throws Exception;
}
