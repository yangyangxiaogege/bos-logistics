package com.bos.entity;

/**
 * 定区，内部包含一组分区
 * @author ASUS
 *
 */
public class FixedRegion {

	private Integer id; // 定区id
	private String name; // 定区名称
	private Courier courier; // 定区负责人


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Courier getCourier() {
		return courier;
	}

	public void setCourier(Courier courier) {
		this.courier = courier;
	}


}
