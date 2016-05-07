package com.soft.model;

/**
 * Custom entity. @author MyEclipse Persistence Tools
 */

public class Custom implements java.io.Serializable {

	// Fields

	private String customId;
	private String addKefuId;
	private String customName;
	private String customIdCard;
	private String customCompany;
	private String customTel;
	private String customMabile;
	private String customAddrass;
	private String customEmail;
	private String customPost;
	private String addKefuName;

	// Constructors

	/** default constructor */
	public Custom() {
	}

	/** full constructor */
	public Custom(String addKefuId, String customName, String customIdCard,
			String customCompany, String customTel, String customMabile,
			String customAddrass, String customEmail, String customPost,
			String addKefuName) {
		this.addKefuId = addKefuId;
		this.customName = customName;
		this.customIdCard = customIdCard;
		this.customCompany = customCompany;
		this.customTel = customTel;
		this.customMabile = customMabile;
		this.customAddrass = customAddrass;
		this.customEmail = customEmail;
		this.customPost = customPost;
		this.addKefuName = addKefuName;
	}

	// Property accessors

	public String getCustomId() {
		return this.customId;
	}

	public void setCustomId(String customId) {
		this.customId = customId;
	}

	public String getAddKefuId() {
		return this.addKefuId;
	}

	public void setAddKefuId(String addKefuId) {
		this.addKefuId = addKefuId;
	}

	public String getCustomName() {
		return this.customName;
	}

	public void setCustomName(String customName) {
		this.customName = customName;
	}

	public String getCustomIdCard() {
		return this.customIdCard;
	}

	public void setCustomIdCard(String customIdCard) {
		this.customIdCard = customIdCard;
	}

	public String getCustomCompany() {
		return this.customCompany;
	}

	public void setCustomCompany(String customCompany) {
		this.customCompany = customCompany;
	}

	public String getCustomTel() {
		return this.customTel;
	}

	public void setCustomTel(String customTel) {
		this.customTel = customTel;
	}

	public String getCustomMabile() {
		return this.customMabile;
	}

	public void setCustomMabile(String customMabile) {
		this.customMabile = customMabile;
	}

	public String getCustomAddrass() {
		return this.customAddrass;
	}

	public void setCustomAddrass(String customAddrass) {
		this.customAddrass = customAddrass;
	}

	public String getCustomEmail() {
		return this.customEmail;
	}

	public void setCustomEmail(String customEmail) {
		this.customEmail = customEmail;
	}

	public String getCustomPost() {
		return this.customPost;
	}

	public void setCustomPost(String customPost) {
		this.customPost = customPost;
	}

	public String getAddKefuName() {
		return this.addKefuName;
	}

	public void setAddKefuName(String addKefuName) {
		this.addKefuName = addKefuName;
	}

}