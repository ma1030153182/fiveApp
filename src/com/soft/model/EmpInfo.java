package com.soft.model;

/**
 * EmpInfo entity. @author MyEclipse Persistence Tools
 */

public class EmpInfo implements java.io.Serializable {

	// Fields

	private String empId;
	private String empMobile;
	private String empName;
	private String empDep;
	private String empAddrass;
	private String empEmail;
	private String partCompany;

	// Constructors

	/** default constructor */
	public EmpInfo() {
	}

	/** full constructor */
	public EmpInfo(String empMobile, String empName, String empDep,
			String empAddrass, String empEmail, String partCompany) {
		this.empMobile = empMobile;
		this.empName = empName;
		this.empDep = empDep;
		this.empAddrass = empAddrass;
		this.empEmail = empEmail;
		this.partCompany = partCompany;
	}

	// Property accessors

	public String getEmpId() {
		return this.empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getEmpMobile() {
		return this.empMobile;
	}

	public void setEmpMobile(String empMobile) {
		this.empMobile = empMobile;
	}

	public String getEmpName() {
		return this.empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpDep() {
		return this.empDep;
	}

	public void setEmpDep(String empDep) {
		this.empDep = empDep;
	}

	public String getEmpAddrass() {
		return this.empAddrass;
	}

	public void setEmpAddrass(String empAddrass) {
		this.empAddrass = empAddrass;
	}

	public String getEmpEmail() {
		return this.empEmail;
	}

	public void setEmpEmail(String empEmail) {
		this.empEmail = empEmail;
	}

	public String getPartCompany() {
		return this.partCompany;
	}

	public void setPartCompany(String partCompany) {
		this.partCompany = partCompany;
	}

}