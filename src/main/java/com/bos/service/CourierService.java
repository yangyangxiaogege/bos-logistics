package com.bos.service;

import java.util.List;

import com.bos.entity.Courier;

public interface CourierService {
	/**
	 * 查询出所有的取派员和创建人
	 * @return
	 */
	List<Courier> findAllCourierAndUser() throws Exception;
}
