package com.bos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.util.StringUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.bos.entity.Region;
import com.bos.utils.PinYin4jUtils;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BosLogisticsApplicationTests {

	/**
	 * 测试POI
	 * Apache POI提供API给Java程式对Microsoft Office格式档案读和写的功能
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	@Test
	public void poi() throws Exception {
		// 创建一个文件对象
		String pathname = "D:\\Arnold学习视频\\bos物流\\BOS-day05\\BOS-day05\\BOS-day05\\资料\\区域导入测试数据.xls";
		File file = new File(pathname);
	
		HSSFWorkbook workbook = new HSSFWorkbook(new FileInputStream(file));
		
		HSSFSheet sheet = workbook.getSheetAt(0);
		
		for (Row row : sheet) {
			if (row.getRowNum() == 0) {
				// 说明这一行为标题行
				continue;
			}
			for (Cell cell : row) {
				System.out.print(cell.getStringCellValue());
			}
			System.out.println();
		}
	}
	
	@Test
	public void poi2() throws Exception {
		// 创建一个文件对象
		String pathname = "D:\\Arnold学习视频\\bos物流\\BOS-day05\\BOS-day05\\BOS-day05\\资料\\区域导入测试数据.xls";
		File file = new File(pathname);
	
		HSSFWorkbook workbook = new HSSFWorkbook(new FileInputStream(file));
		
		HSSFSheet sheet = workbook.getSheetAt(0);
		List<Region> regions = new ArrayList<Region>();
		// 创建一个区域对象
		Region region;
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
		for (Region r : regions) {
			System.out.println(r);
		}
	}
	/**
	 * 测试pinyin4j
	 */
	@Test
	public void pinyin4j() {
		// QY017 河北省 石家庄市 长安区 130102
		// 根据以上数据，生成区域简码和城市编码
		String province = "河北省";
		String city = "石家庄市";
		String region = "长安区";
		province= province.substring(0, province.length()-1);
		city = city.substring(0, city.length()-1);
		region = region.substring(0, region.length()-1);
		String str = province+city+region;
		String [] arr = PinYin4jUtils.getHeadByString(str);
		String pinyin = StringUtil.join(arr);
		System.out.println(pinyin);
	}
	
	/**
	 * 测试cxf
	 * @throws Exception 
	 */
	@Test
	public void cxf() throws Exception {
		JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();
        Client client = dcf.createClient("http://localhost:8001/service/customer?wsdl");
        Object [] objs = client.invoke("findNoDecidzone");
        System.out.println(objs[0]);
	}

}
