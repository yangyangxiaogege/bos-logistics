package com.bos.entity;

import java.io.Serializable;

/**
 * 客户
 * @author ASUS
 *
 */

public class Customer implements Serializable{

	private Integer id;
	private String name;
	private String station;
	private String telephone;
	private String address;
	
	private Integer decidedzoneId;
	
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
	public String getStation() {
		return station;
	}
	public void setStation(String station) {
		this.station = station;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Integer getDecidedzoneId() {
		return decidedzoneId;
	}
	public void setDecidedzoneId(Integer decidedzoneId) {
		this.decidedzoneId = decidedzoneId;
	}
	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", station=" + station + ", telephone=" + telephone
				+ ", address=" + address + ", decidedzoneId=" + decidedzoneId + "]";
	}
}
