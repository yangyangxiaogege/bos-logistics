package com.bos.entity;

/**
 * 分区
 * @author ASUS
 *
 */
public class Subregion {

	private Integer id; // 分区id
	private String addressKey; // 地址关键字
	private Integer startNum; // 起始号，楼、街、号
	private Integer endNum; // 终止号
	private Integer single; // 单双号
	private String assistKey; // 辅助关键字
	private FixedRegion fixedRegion; // 所属定区
	private String regionId;
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	public String getAddressKey() {
		return addressKey;
	}

	public void setAddressKey(String addressKey) {
		this.addressKey = addressKey;
	}


	public Integer getStartNum() {
		return startNum;
	}

	public void setStartNum(Integer startNum) {
		this.startNum = startNum;
	}


	public Integer getEndNum() {
		return endNum;
	}

	public void setEndNum(Integer endNum) {
		this.endNum = endNum;
	}


	public Integer getSingle() {
		return single;
	}
	
	public void setSingle(Integer single) {
		this.single = single;
	}


	public String getAssistKey() {
		return assistKey;
	}

	public void setAssistKey(String assistKey) {
		this.assistKey = assistKey;
	}

	public FixedRegion getFixedRegion() {
		return fixedRegion;
	}

	public void setFixedRegion(FixedRegion fixedRegion) {
		this.fixedRegion = fixedRegion;
	}

	public String getRegionId() {
		return regionId;
	}

	public void setRegionId(String regionId) {
		this.regionId = regionId;
	}
}
