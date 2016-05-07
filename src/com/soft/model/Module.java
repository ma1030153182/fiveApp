package com.soft.model;

/**
 * Module entity. @author MyEclipse Persistence Tools
 */

public class Module implements java.io.Serializable {

	// Fields

	private String moduleId;
	private String moduleName;
	private String parentId;
	private String moduleUrl;

	// Constructors

	/** default constructor */
	public Module() {
	}

	/** full constructor */
	public Module(String moduleName, String parentId, String moduleUrl) {
		this.moduleName = moduleName;
		this.parentId = parentId;
		this.moduleUrl = moduleUrl;
	}

	// Property accessors

	public String getModuleId() {
		return this.moduleId;
	}

	public void setModuleId(String moduleId) {
		this.moduleId = moduleId;
	}

	public String getModuleName() {
		return this.moduleName;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}

	public String getParentId() {
		return this.parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public String getModuleUrl() {
		return this.moduleUrl;
	}

	public void setModuleUrl(String moduleUrl) {
		this.moduleUrl = moduleUrl;
	}

}