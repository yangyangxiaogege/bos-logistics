package com.bos.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bos.entity.Customer;
import com.bos.entity.FixedRegion;
import com.bos.service.FixedRegionService;
import com.bos.utils.CXFUtil;

@RestController
@RequestMapping("/sys/fixed")
public class FixedRegionController {

	@Resource
	private FixedRegionService fixedRegionService; 
	
	/**
	 * 查询所有的定区信息
	 * @return
	 */
	@RequestMapping("/findAll")
	public Object findAll() {
		Map<String, Object> map = new HashMap<String, Object>();
		// 获取所有的定区信息
		try {
			List<FixedRegion> list = fixedRegionService.findAll();
			map.put("fixedRegionList", list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return map;
	}
	
	/**
	 * 根据定区id，查询已经进行定区管理的客户信息,
	 * 和未进行定区管理的客户信息
	 * 资源通过远程加载
	 * @param id
	 * @return
	 */
	@RequestMapping("/getCustomer")
	public Object getCustomer(Integer id) {
		Map<String, Object> map = new HashMap<String, Object>();
		// 请求地址
		String url = "http://localhost:8001/service/customer?wsdl";
		try {
			// 调用服务，获取资源
			// 已经进行关联的客户
			List<Customer> list = (List<Customer>) CXFUtil.invokeWS(url, "findHasDecidzoneByDecidzoneId",id);
			map.put("hasDZ", list);
//			// 还未进行关联的客户
//			List<Customer> list2 = (List<Customer>) CXFUtil.invokeWS(url, "findNoDecidzone");
			List<Customer> list2 = (List<Customer>) CXFUtil.invokeWS(url, "findAll");
			map.put("customerList", list2);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return map;
	}
	
	
}
