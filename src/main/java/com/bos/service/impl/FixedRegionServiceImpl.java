package com.bos.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bos.dao.FixedRegionMapper;
import com.bos.entity.FixedRegion;
import com.bos.service.FixedRegionService;

@Service
public class FixedRegionServiceImpl implements FixedRegionService{
	
	@Resource
	private FixedRegionMapper fixedRegionMapper;
	
	@Override
	public List<FixedRegion> findAll() throws Exception{
		// TODO Auto-generated method stub
		
		return fixedRegionMapper.findAll();
	}
	
	

}
