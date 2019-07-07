package com.bos.entity;

import java.util.Date;
import java.util.List;

/**
 * 基础档案
 * 主要是应用在参照录入
 * 例如取派员类别
 * @author ASUS
 *
 */
public class BcArchives {

	private Integer id; // 档案id
	private String archivesName; // 档案名称
	private Integer userId; // 创建人
	private Date operationTime; // 操作时间
	private List<BcArchivesDetail> detaiList; // 档案明细列表
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getArchivesName() {
		return archivesName;
	}
	public void setArchivesName(String archivesName) {
		this.archivesName = archivesName;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Date getOperationTime() {
		return operationTime;
	}
	public void setOperationTime(Date operationTime) {
		this.operationTime = operationTime;
	}
	public List<BcArchivesDetail> getDetaiList() {
		return detaiList;
	}
	public void setDetaiList(List<BcArchivesDetail> detaiList) {
		this.detaiList = detaiList;
	}
}
