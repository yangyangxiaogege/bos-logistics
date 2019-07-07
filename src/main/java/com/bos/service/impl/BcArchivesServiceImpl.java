package com.bos.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bos.dao.BcArchivesMapper;
import com.bos.entity.BcArchives;
import com.bos.service.BcArchivesService;

@Service
public class BcArchivesServiceImpl implements BcArchivesService {

	@Resource
	private BcArchivesMapper bcMapper;
	
	@Override
	public List<BcArchives> findArchivesList() throws Exception {
		// TODO Auto-generated method stub
		return bcMapper.findArchivesList();
	}

	@Override
	public List<BcArchives> findAll(Integer id, String archivesName) throws Exception {
		// TODO Auto-generated method stub
		return bcMapper.findAll(id, archivesName);
	}

	@Override
	public BcArchives findByArchivesName(String name) throws Exception {
		// TODO Auto-generated method stub
		return bcMapper.findByArchivesName(name);
	}
}
