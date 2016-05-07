package com.soft.model;

/**
 * ReportRepair entity. @author MyEclipse Persistence Tools
 */

public class ReportRepair implements java.io.Serializable {

	// Fields

	private String reportRepairId;
	private String customId;
	private String empKefuId;
	private String customSentTime;
	private String customProperties;
	private String forecastPrice;
	private String forecastCompleteTime;
	private String reportState;
	private String productType;
	private String machineBrand;
	private String machineVersion;
	private String machineBugPhenomenon;
	private String machineStartPassword;
	private String machineRam;
	private String other;
	private String customName;
	private String diaoduManName;
	private String kefuName;
	private String diaoduManId;

	// Constructors

	/** default constructor */
	public ReportRepair() {
	}

	/** full constructor */
	public ReportRepair(String customId, String empKefuId,
			String customSentTime, String customProperties,
			String forecastPrice, String forecastCompleteTime,
			String reportState, String productType, String machineBrand,
			String machineVersion, String machineBugPhenomenon,
			String machineStartPassword, String machineRam, String other,
			String customName, String diaoduManName, String kefuName,
			String diaoduManId) {
		this.customId = customId;
		this.empKefuId = empKefuId;
		this.customSentTime = customSentTime;
		this.customProperties = customProperties;
		this.forecastPrice = forecastPrice;
		this.forecastCompleteTime = forecastCompleteTime;
		this.reportState = reportState;
		this.productType = productType;
		this.machineBrand = machineBrand;
		this.machineVersion = machineVersion;
		this.machineBugPhenomenon = machineBugPhenomenon;
		this.machineStartPassword = machineStartPassword;
		this.machineRam = machineRam;
		this.other = other;
		this.customName = customName;
		this.diaoduManName = diaoduManName;
		this.kefuName = kefuName;
		this.diaoduManId = diaoduManId;
	}

	// Property accessors

	public String getReportRepairId() {
		return this.reportRepairId;
	}

	public void setReportRepairId(String reportRepairId) {
		this.reportRepairId = reportRepairId;
	}

	public String getCustomId() {
		return this.customId;
	}

	public void setCustomId(String customId) {
		this.customId = customId;
	}

	public String getEmpKefuId() {
		return this.empKefuId;
	}

	public void setEmpKefuId(String empKefuId) {
		this.empKefuId = empKefuId;
	}

	public String getCustomSentTime() {
		return this.customSentTime;
	}

	public void setCustomSentTime(String customSentTime) {
		this.customSentTime = customSentTime;
	}

	public String getCustomProperties() {
		return this.customProperties;
	}

	public void setCustomProperties(String customProperties) {
		this.customProperties = customProperties;
	}

	public String getForecastPrice() {
		return this.forecastPrice;
	}

	public void setForecastPrice(String forecastPrice) {
		this.forecastPrice = forecastPrice;
	}

	public String getForecastCompleteTime() {
		return this.forecastCompleteTime;
	}

	public void setForecastCompleteTime(String forecastCompleteTime) {
		this.forecastCompleteTime = forecastCompleteTime;
	}

	public String getReportState() {
		return this.reportState;
	}

	public void setReportState(String reportState) {
		this.reportState = reportState;
	}

	public String getProductType() {
		return this.productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public String getMachineBrand() {
		return this.machineBrand;
	}

	public void setMachineBrand(String machineBrand) {
		this.machineBrand = machineBrand;
	}

	public String getMachineVersion() {
		return this.machineVersion;
	}

	public void setMachineVersion(String machineVersion) {
		this.machineVersion = machineVersion;
	}

	public String getMachineBugPhenomenon() {
		return this.machineBugPhenomenon;
	}

	public void setMachineBugPhenomenon(String machineBugPhenomenon) {
		this.machineBugPhenomenon = machineBugPhenomenon;
	}

	public String getMachineStartPassword() {
		return this.machineStartPassword;
	}

	public void setMachineStartPassword(String machineStartPassword) {
		this.machineStartPassword = machineStartPassword;
	}

	public String getMachineRam() {
		return this.machineRam;
	}

	public void setMachineRam(String machineRam) {
		this.machineRam = machineRam;
	}

	public String getOther() {
		return this.other;
	}

	public void setOther(String other) {
		this.other = other;
	}

	public String getCustomName() {
		return this.customName;
	}

	public void setCustomName(String customName) {
		this.customName = customName;
	}

	public String getDiaoduManName() {
		return this.diaoduManName;
	}

	public void setDiaoduManName(String diaoduManName) {
		this.diaoduManName = diaoduManName;
	}

	public String getKefuName() {
		return this.kefuName;
	}

	public void setKefuName(String kefuName) {
		this.kefuName = kefuName;
	}

	public String getDiaoduManId() {
		return this.diaoduManId;
	}

	public void setDiaoduManId(String diaoduManId) {
		this.diaoduManId = diaoduManId;
	}

}