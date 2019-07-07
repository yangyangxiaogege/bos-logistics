package com.bos.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bos.dao.BcArchivesDetailMapper;
import com.bos.entity.BcArchivesDetail;
import com.bos.service.BcArchivesDetailService;

@Service
public class BcArchivesDetailServiceImpl implements BcArchivesDetailService{

	// 注入bcArchivesDetailMapper
	@Resource
	private BcArchivesDetailMapper bcadMapper;
	
	@Override
	public Integer addBcArchivesDetail(BcArchivesDetail detail) throws Exception {
		// TODO Auto-generated method stub
		return bcadMapper.addBcArchivesDetail(detail);
	}

	@Override
	public BcArchivesDetail findByArchivesDetailName(String name) throws Exception {
		// TODO Auto-generated method stub
		return bcadMapper.findByArchivesDetailName(name);
	}
}
