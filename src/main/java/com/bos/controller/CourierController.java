package com.bos.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bos.entity.BcArchives;
import com.bos.entity.Courier;
import com.bos.service.BcArchivesService;
import com.bos.service.CourierService;

@RestController
@RequestMapping("/sys/courier")
public class CourierController {
	// 注入courierService
	@Resource
	private CourierService courierService;
	// 注入bcArchivesService
	@Resource
	private BcArchivesService bcService;
	
	@RequestMapping("/findAll")
	public Object findAll() {
		Map<String, Object> map = new HashMap<String,Object>();
		// 查询所有的取派员
		try {
			List<Courier> list = courierService.findAllCourierAndUser();
			map.put("courierList", list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return map;
	}
	
	/**
	 * 获取取派员类型
	 * @return
	 */
	@RequestMapping("/getCourierType")
	public Object getCourierType() {
		Map<String, Object> map = new HashMap<String,Object>();
		try {
			BcArchives bcArchives = bcService.findByArchivesName("取派员类型");
			if (bcArchives != null ) {
				map.put("courierType", bcArchives.getDetaiList());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return map;
	}
}
