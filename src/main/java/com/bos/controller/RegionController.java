package com.bos.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.util.StringUtil;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.bos.entity.Region;
import com.bos.service.RegionService;
import com.bos.utils.Conts;
import com.bos.utils.Page;
import com.bos.utils.PinYin4jUtils;

@RestController
@RequestMapping("/sys/region")
public class RegionController {

	@Resource
	private RegionService regionService;
	/**
	 * 接受上传的数据。并将其解析后保存到数据库中
	 * @param file 上传文件
	 * @return
	 */
	@RequestMapping("/regionImport")
	public Object regionImport(MultipartFile file) {
		Map<String, Object> map = new HashMap<String,Object>();
		List<Region> regions = new ArrayList<Region>();
		try {
			// 创建一个电子表格工作对象，用于解析xls类型文件
			HSSFWorkbook workbook = new HSSFWorkbook(file.getInputStream());
			// 表格对象
			HSSFSheet sheet = workbook.getSheetAt(0);
			// 创建一个区域对象
			Region region;
			// 遍历表格对象
			for (Row row : sheet) {
				region = new Region();
				if (row.getRowNum() == 0) {
					// 说明这一行为标题行
					continue;
				}
				// 获取表格中的数据
				String id = row.getCell(0).getStringCellValue();
				String province = row.getCell(1).getStringCellValue();
				String city = row.getCell(2).getStringCellValue();
				String county = row.getCell(3).getStringCellValue();
				String postalCode = row.getCell(4).getStringCellValue();
				// 给区域对象赋值
				region.setId(id);
				region.setProvince(province);
				region.setCity(city);
				region.setCounty(county);
				region.setPostalCode(postalCode);
				// 使用pinyin4j生成区域简码和城市编码
				province= province.substring(0, province.length()-1);
				city = city.substring(0, city.length()-1);
				county = county.substring(0, county.length()-1);
				String str = province+city+county;
				String [] arr = PinYin4jUtils.getHeadByString(str);
				String shortCode = StringUtil.join(arr);
				
				String cityCode = PinYin4jUtils.hanziToPinyin(city);
				
				region.setShortCode(shortCode);
				region.setCityCode(cityCode);
				
				// 将区域对象存进集合中
				regions.add(region);
			}
			
			// 调用业务接口，进行持久化操作
			try {
				for (Region r : regions) {
					System.out.println(r);
				}
				int count = regionService.addRegions(regions);
				if(count > 0) {
					map.put(Conts.STATE,true);
				}else {
					map.put(Conts.STATE,false);					
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				map.put(Conts.STATE,false);			
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return map;
	}

	/**
	 * 分页查询
	 * @param page
	 * @return
	 */
	@RequestMapping("/findAllByPage")
	public Object findAllByPage(Page<Region> page) {
//		System.out.println(page.getPageNo()+"---"+page.getPageSize());
		Map<String, Object> map = new HashMap<String, Object>();
		// 开始进行分页查询
		try {
			// 获取总记录数
			int totalCount = regionService.findCount();
			page.setTotalCount(totalCount);
			// 判断该页是否存在
			if (page.getPageNo()>page.getTotalPage()) {
				map.put(Conts.MSG, "该页不存在");
				return map;
			}
			page = regionService.findAllByPage(page);
			if(page.getData().size()>0) {
				// 查询成功
				map.put(Conts.STATE, true);
				map.put("page", page);
			}else {
				// 查询失败
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
	 * 查询所有的区域列表
	 * @param query 查询条件
	 * @return
	 */
	@RequestMapping("/findAllByQuery")
	public Object findAll(String query) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			List<Region> list = regionService.findAllByQuery(query);
			map.put("regions", list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return map;
	}
}
