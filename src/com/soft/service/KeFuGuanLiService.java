package com.soft.service;

import java.util.List;

import com.soft.model.Custom;
import com.soft.model.ReportRepair;

public interface KeFuGuanLiService {

	public abstract boolean addCustom(Custom custom);

	public abstract void deleteCustom(Custom custom);

	public abstract void updateCustom(Custom custom);

	public abstract List<Custom> queryAllBy(Custom custom,int page,int pageSize);
	
	public List<Custom> queryAll(int page, int pageSize);
	
	public int countAll();
	
	public int countAllBy(Custom custom);
	
	public boolean addReportRepair(ReportRepair ReportRepair);
	
	public abstract List<Custom> queryCustomById(Custom custom);
	public List<Custom> queryCustomByIdCard(Custom custom);
	public void editReportRepair(ReportRepair reportRepair);

}