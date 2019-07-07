package com.bos.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bos.dao.CourierMapper;
import com.bos.entity.Courier;
import com.bos.service.CourierService;

@Service
public class CourierServiceImpl implements CourierService{

	// 注入courierMapper
	@Resource
	private CourierMapper courierMapper;
	
	@Override
	public List<Courier> findAllCourierAndUser() throws Exception {
		// TODO Auto-generated method stub
		return courierMapper.findAllCourierAndUser();
	}
}
