package com.soft.model;

/**
 * ModuleRole entity. @author MyEclipse Persistence Tools
 */

public class ModuleRole implements java.io.Serializable {

	// Fields

	private String roleId;
	private String moudleId;
	private String roleName;

	// Constructors

	/** default constructor */
	public ModuleRole() {
	}

	/** full constructor */
	public ModuleRole(String moudleId, String roleName) {
		this.moudleId = moudleId;
		this.roleName = roleName;
	}

	// Property accessors

	public String getRoleId() {
		return this.roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getMoudleId() {
		return this.moudleId;
	}

	public void setMoudleId(String moudleId) {
		this.moudleId = moudleId;
	}

	public String getRoleName() {
		return this.roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

}