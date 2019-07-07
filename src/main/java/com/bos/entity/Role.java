package com.bos.entity;

/**
 * 用户角色
 * @author ASUS
 *
 */
public class Role {

	private Integer id; // 角色id
	private String roleName; // 角色名称

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

}
