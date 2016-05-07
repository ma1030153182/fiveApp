package com.soft.model;

/**
 * BeiJian entity. @author MyEclipse Persistence Tools
 */

public class BeiJian implements java.io.Serializable {

	// Fields

	private String beijianId;
	private String beijianName;
	private String beijianVersion;
	private String beijianPrice;
	private String beijianNumber;
	private String warnNumber;
	private String beijianState;

	// Constructors

	/** default constructor */
	public BeiJian() {
	}

	/** full constructor */
	public BeiJian(String beijianName, String beijianVersion,
			String beijianPrice, String beijianNumber, String warnNumber,
			String beijianState) {
		this.beijianName = beijianName;
		this.beijianVersion = beijianVersion;
		this.beijianPrice = beijianPrice;
		this.beijianNumber = beijianNumber;
		this.warnNumber = warnNumber;
		this.beijianState = beijianState;
	}

	// Property accessors

	public String getBeijianId() {
		return this.beijianId;
	}

	public void setBeijianId(String beijianId) {
		this.beijianId = beijianId;
	}

	public String getBeijianName() {
		return this.beijianName;
	}

	public void setBeijianName(String beijianName) {
		this.beijianName = beijianName;
	}

	public String getBeijianVersion() {
		return this.beijianVersion;
	}

	public void setBeijianVersion(String beijianVersion) {
		this.beijianVersion = beijianVersion;
	}

	public String getBeijianPrice() {
		return this.beijianPrice;
	}

	public void setBeijianPrice(String beijianPrice) {
		this.beijianPrice = beijianPrice;
	}

	public String getBeijianNumber() {
		return this.beijianNumber;
	}

	public void setBeijianNumber(String beijianNumber) {
		this.beijianNumber = beijianNumber;
	}

	public String getWarnNumber() {
		return this.warnNumber;
	}

	public void setWarnNumber(String warnNumber) {
		this.warnNumber = warnNumber;
	}

	public String getBeijianState() {
		return this.beijianState;
	}

	public void setBeijianState(String beijianState) {
		this.beijianState = beijianState;
	}

}