package com.bos.entity;

/**
 * 取派员
 * @author ASUS
 *
 */
public class Courier {

	private Integer id; // 取派员id
	private String name; // 姓名
	private Integer hasPda = 0; // 是否使用PDA
	private Integer delFlag = 1; // 是否被删除，0：删除，1：未删除，默认值
	private String station; // 所属单位
	private String standard; // 收费标准
	private Integer bcarchivesDetailId; // 取派员类型id
	private User user; // 创建人

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


	public Integer getHasPda() {
		return hasPda;
	}

	public void setHasPda(Integer hasPda) {
		this.hasPda = hasPda;
	}


	public Integer getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(Integer delFlag) {
		this.delFlag = delFlag;
	}


	public String getStation() {
		return station;
	}

	public void setStation(String station) {
		this.station = station;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getStandard() {
		return standard;
	}

	public void setStandard(String standard) {
		this.standard = standard;
	}

	public Integer getBcarchivesDetailId() {
		return bcarchivesDetailId;
	}

	public void setBcarchivesDetailId(Integer bcarchivesDetailId) {
		this.bcarchivesDetailId = bcarchivesDetailId;
	}
}
