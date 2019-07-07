package com.bos.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * 基础档案明细
 * @author ASUS
 *
 */
public class BcArchivesDetail {

	private Integer id; // 档案明细id
	private String archivesDetailName; //档案明细名称，针对于基础档案下的档案名
	private Integer archivesId; // 所属基础档案
	private Integer userId; // 创建人
	private String remark; // 备注
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date operationTime; // 操作时间
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getArchivesDetailName() {
		return archivesDetailName;
	}
	public void setArchivesDetailName(String archivesDetailName) {
		this.archivesDetailName = archivesDetailName;
	}
	public Integer getArchivesId() {
		return archivesId;
	}
	public void setArchivesId(Integer archivesId) {
		this.archivesId = archivesId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Date getOperationTime() {
		return operationTime;
	}
	public void setOperationTime(Date operationTime) {
		this.operationTime = operationTime;
	}

}
