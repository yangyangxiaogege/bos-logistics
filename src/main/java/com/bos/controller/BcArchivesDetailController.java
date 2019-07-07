package com.bos.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bos.entity.BcArchivesDetail;
import com.bos.service.BcArchivesDetailService;
import com.bos.utils.Conts;

@RestController
@RequestMapping("/sys/bcarchivesdetail")
public class BcArchivesDetailController {

	// 注入档案明细业务
	@Resource
	private BcArchivesDetailService bcadService;
	
	@RequestMapping("/add")
	public Object addBcArchivesDetail(BcArchivesDetail detail) {
		Map<String, Object> map = new HashMap<String,Object>();
		// 进行添加操作
		try {
			int count = bcadService.addBcArchivesDetail(detail);
			if (count > 0) {
				// 添加成功
				map.put(Conts.STATE, true);
			}else {
				map.put(Conts.STATE, false);				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			map.put(Conts.STATE, false);				
		}
		return map;
	}
	/**
	 * 检查档案名是否已经存在
	 * @return
	 */
	@RequestMapping("/checkName")
	public Object checkName(String name) {
		Map<String, Object> map = new HashMap<String,Object>();
		try {
		    BcArchivesDetail detail = bcadService.findByArchivesDetailName(name);
		    
		    if (detail == null) {
		    	// 存在
				map.put(Conts.STATE, true);
			}else {
				// 不存在
				map.put(Conts.STATE, false);				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			map.put(Conts.STATE, false);
		}
		return map;
	}
}
