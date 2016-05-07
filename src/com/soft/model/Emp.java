package com.soft.model;

/**
 * Emp entity. @author MyEclipse Persistence Tools
 */

public class Emp implements java.io.Serializable {

	// Fields

	private String recordId;
	private String empId;
	private String roleId;
	private String empName;
	private String empPassword;
	private String empAccount;

	// Constructors

	/** default constructor */
	public Emp() {
	}

	/** full constructor */
	public Emp(String empId, String roleId, String empName, String empPassword,
			String empAccount) {
		this.empId = empId;
		this.roleId = roleId;
		this.empName = empName;
		this.empPassword = empPassword;
		this.empAccount = empAccount;
	}

	// Property accessors

	public String getRecordId() {
		return this.recordId;
	}

	public void setRecordId(String recordId) {
		this.recordId = recordId;
	}

	public String getEmpId() {
		return this.empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getRoleId() {
		return this.roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getEmpName() {
		return this.empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpPassword() {
		return this.empPassword;
	}

	public void setEmpPassword(String empPassword) {
		this.empPassword = empPassword;
	}

	public String getEmpAccount() {
		return this.empAccount;
	}

	public void setEmpAccount(String empAccount) {
		this.empAccount = empAccount;
	}

}