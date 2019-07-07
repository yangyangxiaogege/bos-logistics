package com.bos.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bos.entity.BcArchives;
import com.bos.service.BcArchivesService;

@RestController
@RequestMapping("/sys/bcarchives")
public class BcArchivesController {

	@Resource
	private BcArchivesService bcService;
	
	/**
	 * 获取所有的档案信息
	 * 包括档案下的明细
	 * @return
	 */
	@RequestMapping("/findBcArchives")
	public Object findBcArchives() {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			// 获取数据
			map.put("bcArchivesList", bcService.findArchivesList());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return map;
	}
	
	/**
	 * 获取所有基础档案
	 * @return
	 */
	@RequestMapping("/findAll")
	public Object findAll() {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			List<BcArchives> list = bcService.findAll(null,null);
			map.put("bcArchivesList",list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return map;
	}
}
