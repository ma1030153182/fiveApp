package com.soft.model;

/**
 * Repair entity. @author MyEclipse Persistence Tools
 */

public class Repair implements java.io.Serializable {

	// Fields

	private String repairId;
	private String empRepairmanId;
	private String reportRepairId;
	private String repairSchdulTime;
	private String machineCheckRecord;
	private String machineCheckTime;
	private String repairRecord;
	private String repairWorkTime;
	private String repairLabourPrice;
	private String materialPrice;
	private String repairPromise;
	private String attentionMatter;
	private String repairState;
	private String scheduleManName;
	private String repairManName;
	private String empSchedulingManId;
	private String endTime;

	// Constructors

	/** default constructor */
	public Repair() {
	}

	/** full constructor */
	public Repair(String empRepairmanId, String reportRepairId,
			String repairSchdulTime, String machineCheckRecord,
			String machineCheckTime, String repairRecord,
			String repairWorkTime, String repairLabourPrice,
			String materialPrice, String repairPromise, String attentionMatter,
			String repairState, String scheduleManName, String repairManName,
			String empSchedulingManId, String endTime) {
		this.empRepairmanId = empRepairmanId;
		this.reportRepairId = reportRepairId;
		this.repairSchdulTime = repairSchdulTime;
		this.machineCheckRecord = machineCheckRecord;
		this.machineCheckTime = machineCheckTime;
		this.repairRecord = repairRecord;
		this.repairWorkTime = repairWorkTime;
		this.repairLabourPrice = repairLabourPrice;
		this.materialPrice = materialPrice;
		this.repairPromise = repairPromise;
		this.attentionMatter = attentionMatter;
		this.repairState = repairState;
		this.scheduleManName = scheduleManName;
		this.repairManName = repairManName;
		this.empSchedulingManId = empSchedulingManId;
		this.endTime = endTime;
	}

	// Property accessors

	public String getRepairId() {
		return this.repairId;
	}

	public void setRepairId(String repairId) {
		this.repairId = repairId;
	}

	public String getEmpRepairmanId() {
		return this.empRepairmanId;
	}

	public void setEmpRepairmanId(String empRepairmanId) {
		this.empRepairmanId = empRepairmanId;
	}

	public String getReportRepairId() {
		return this.reportRepairId;
	}

	public void setReportRepairId(String reportRepairId) {
		this.reportRepairId = reportRepairId;
	}

	public String getRepairSchdulTime() {
		return this.repairSchdulTime;
	}

	public void setRepairSchdulTime(String repairSchdulTime) {
		this.repairSchdulTime = repairSchdulTime;
	}

	public String getMachineCheckRecord() {
		return this.machineCheckRecord;
	}

	public void setMachineCheckRecord(String machineCheckRecord) {
		this.machineCheckRecord = machineCheckRecord;
	}

	public String getMachineCheckTime() {
		return this.machineCheckTime;
	}

	public void setMachineCheckTime(String machineCheckTime) {
		this.machineCheckTime = machineCheckTime;
	}

	public String getRepairRecord() {
		return this.repairRecord;
	}

	public void setRepairRecord(String repairRecord) {
		this.repairRecord = repairRecord;
	}

	public String getRepairWorkTime() {
		return this.repairWorkTime;
	}

	public void setRepairWorkTime(String repairWorkTime) {
		this.repairWorkTime = repairWorkTime;
	}

	public String getRepairLabourPrice() {
		return this.repairLabourPrice;
	}

	public void setRepairLabourPrice(String repairLabourPrice) {
		this.repairLabourPrice = repairLabourPrice;
	}

	public String getMaterialPrice() {
		return this.materialPrice;
	}

	public void setMaterialPrice(String materialPrice) {
		this.materialPrice = materialPrice;
	}

	public String getRepairPromise() {
		return this.repairPromise;
	}

	public void setRepairPromise(String repairPromise) {
		this.repairPromise = repairPromise;
	}

	public String getAttentionMatter() {
		return this.attentionMatter;
	}

	public void setAttentionMatter(String attentionMatter) {
		this.attentionMatter = attentionMatter;
	}

	public String getRepairState() {
		return this.repairState;
	}

	public void setRepairState(String repairState) {
		this.repairState = repairState;
	}

	public String getScheduleManName() {
		return this.scheduleManName;
	}

	public void setScheduleManName(String scheduleManName) {
		this.scheduleManName = scheduleManName;
	}

	public String getRepairManName() {
		return this.repairManName;
	}

	public void setRepairManName(String repairManName) {
		this.repairManName = repairManName;
	}

	public String getEmpSchedulingManId() {
		return this.empSchedulingManId;
	}

	public void setEmpSchedulingManId(String empSchedulingManId) {
		this.empSchedulingManId = empSchedulingManId;
	}

	public String getEndTime() {
		return this.endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

}