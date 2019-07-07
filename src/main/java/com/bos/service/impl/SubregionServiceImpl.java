package com.bos.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bos.dao.SubregionMapper;
import com.bos.entity.Subregion;
import com.bos.service.SubregionService;

@Service
public class SubregionServiceImpl implements SubregionService {

	@Resource
	private SubregionMapper subregionMapper;
	
	@Override
	public Integer add(Subregion subregion) throws Exception {
		// TODO Auto-generated method stub
		return subregionMapper.add(subregion);
	}

}
