package com.bos.entity;

/**
 * 区域
 * @author ASUS
 *
 */
public class Region {

	private String id; // 区域id
	private String province; // 省
	private String city; // 市
	private String county; // 县/区
	private String postalCode; // 邮编
	private String shortCode; // 简码
	private String cityCode; // 城市编码
	
	// 提供一个getName 方法，用于向外提供省市区的拼接字符串
	public String getName() {
		return this.province+" "+this.city+" "+this.county;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}


	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}


	public String getCounty() {
		return county;
	}

	public void setCounty(String county) {
		this.county = county;
	}


	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}


	public String getShortCode() {
		return shortCode;
	}

	public void setShortCode(String shortCode) {
		this.shortCode = shortCode;
	}


	public String getCityCode() {
		return cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	@Override
	public String toString() {
		return "Region [id=" + id + ", province=" + province + ", city=" + city + ", county=" + county + ", postalCode="
				+ postalCode + ", shortCode=" + shortCode + ", cityCode=" + cityCode + "]";
	}
	
	
}
