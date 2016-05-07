package com.soft.model;

/**
 * Manager entity. @author MyEclipse Persistence Tools
 */

public class Manager implements java.io.Serializable {

	// Fields

	private String managerAccount;
	private String managerId;
	private String managerPassword;
	private String managerRoleName;

	// Constructors

	/** default constructor */
	public Manager() {
	}

	/** full constructor */
	public Manager(String managerId, String managerPassword,
			String managerRoleName) {
		this.managerId = managerId;
		this.managerPassword = managerPassword;
		this.managerRoleName = managerRoleName;
	}

	// Property accessors

	public String getManagerAccount() {
		return this.managerAccount;
	}

	public void setManagerAccount(String managerAccount) {
		this.managerAccount = managerAccount;
	}

	public String getManagerId() {
		return this.managerId;
	}

	public void setManagerId(String managerId) {
		this.managerId = managerId;
	}

	public String getManagerPassword() {
		return this.managerPassword;
	}

	public void setManagerPassword(String managerPassword) {
		this.managerPassword = managerPassword;
	}

	public String getManagerRoleName() {
		return this.managerRoleName;
	}

	public void setManagerRoleName(String managerRoleName) {
		this.managerRoleName = managerRoleName;
	}

}