package com.soft.model;

/**
 * BeijianApply entity. @author MyEclipse Persistence Tools
 */

public class BeijianApply implements java.io.Serializable {

	// Fields

	private String applyId;
	private String beijianName;
	private String beijianNumber;
	private String beijianPrice;
	private String applyTime;
	private String applyPassTime;
	private String applyManId;
	private String applyPassManId;
	private String beijianId;
	private String applyState;
	private String beijianVersion;
	private String applyManName;
	private String applyPassManName;

	// Constructors

	/** default constructor */
	public BeijianApply() {
	}

	/** full constructor */
	public BeijianApply(String beijianName, String beijianNumber,
			String beijianPrice, String applyTime, String applyPassTime,
			String applyManId, String applyPassManId, String beijianId,
			String applyState, String beijianVersion, String applyManName,
			String applyPassManName) {
		this.beijianName = beijianName;
		this.beijianNumber = beijianNumber;
		this.beijianPrice = beijianPrice;
		this.applyTime = applyTime;
		this.applyPassTime = applyPassTime;
		this.applyManId = applyManId;
		this.applyPassManId = applyPassManId;
		this.beijianId = beijianId;
		this.applyState = applyState;
		this.beijianVersion = beijianVersion;
		this.applyManName = applyManName;
		this.applyPassManName = applyPassManName;
	}

	// Property accessors

	public String getApplyId() {
		return this.applyId;
	}

	public void setApplyId(String applyId) {
		this.applyId = applyId;
	}

	public String getBeijianName() {
		return this.beijianName;
	}

	public void setBeijianName(String beijianName) {
		this.beijianName = beijianName;
	}

	public String getBeijianNumber() {
		return this.beijianNumber;
	}

	public void setBeijianNumber(String beijianNumber) {
		this.beijianNumber = beijianNumber;
	}

	public String getBeijianPrice() {
		return this.beijianPrice;
	}

	public void setBeijianPrice(String beijianPrice) {
		this.beijianPrice = beijianPrice;
	}

	public String getApplyTime() {
		return this.applyTime;
	}

	public void setApplyTime(String applyTime) {
		this.applyTime = applyTime;
	}

	public String getApplyPassTime() {
		return this.applyPassTime;
	}

	public void setApplyPassTime(String applyPassTime) {
		this.applyPassTime = applyPassTime;
	}

	public String getApplyManId() {
		return this.applyManId;
	}

	public void setApplyManId(String applyManId) {
		this.applyManId = applyManId;
	}

	public String getApplyPassManId() {
		return this.applyPassManId;
	}

	public void setApplyPassManId(String applyPassManId) {
		this.applyPassManId = applyPassManId;
	}

	public String getBeijianId() {
		return this.beijianId;
	}

	public void setBeijianId(String beijianId) {
		this.beijianId = beijianId;
	}

	public String getApplyState() {
		return this.applyState;
	}

	public void setApplyState(String applyState) {
		this.applyState = applyState;
	}

	public String getBeijianVersion() {
		return this.beijianVersion;
	}

	public void setBeijianVersion(String beijianVersion) {
		this.beijianVersion = beijianVersion;
	}

	public String getApplyManName() {
		return this.applyManName;
	}

	public void setApplyManName(String applyManName) {
		this.applyManName = applyManName;
	}

	public String getApplyPassManName() {
		return this.applyPassManName;
	}

	public void setApplyPassManName(String applyPassManName) {
		this.applyPassManName = applyPassManName;
	}

}