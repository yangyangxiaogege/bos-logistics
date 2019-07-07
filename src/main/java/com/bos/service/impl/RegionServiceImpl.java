package com.bos.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bos.dao.RegionMapper;
import com.bos.entity.Region;
import com.bos.utils.Page;

@Service
public class RegionServiceImpl implements com.bos.service.RegionService {

	@Resource
	private RegionMapper regionMapper;
	
	@Override
	public Integer addRegions(List<Region> regions) throws Exception{
		// TODO Auto-generated method stub
		return regionMapper.addRegions(regions);
	}
	
	@Override
	public Integer findCount() throws Exception {
		// TODO Auto-generated method stub
		return regionMapper.findCount();
	}
	
	@Override
	public Page<Region> findAllByPage(Page<Region> page) throws Exception {
		// TODO Auto-generated method stub
		List<Region> list = regionMapper.findAllByPage(page);
		if(list != null) {			
			page.setData(list);
		}
		return page;
	}

	@Override
	public List<Region> findAllByQuery(String query) throws Exception {
		// TODO Auto-generated method stub
		return regionMapper.findAllByQuery(query);
	}
}
