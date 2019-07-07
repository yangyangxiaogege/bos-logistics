package com.bos.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bos.entity.Subregion;
import com.bos.service.SubregionService;
import com.bos.utils.Conts;

/**
 * 分区控制器
 * @author ASUS
 *
 */
@RestController
@RequestMapping("/sys/subregion")	
public class SubregionController {

	@Resource	
	private SubregionService subregionService;
	/**
	 * 添加分区
	 * @return
	 */
	@RequestMapping("/add")
	public Object add(Subregion subregion) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		try {
			int count = subregionService.add(subregion);
			if (count > 0) {
				map.put(Conts.STATE, true);
			}else {
				map.put(Conts.STATE, false);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return map;
	}
	
	@RequestMapping("/download")
	public Object download() {
		System.out.println("文件下载");
		return null;
	}
}
