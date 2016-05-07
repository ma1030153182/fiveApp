package com.soft.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.soft.model.Emp;
import com.soft.model.Repair;
import com.soft.model.ReportRepair;
import com.soft.service.DiaoDuGuanLiService;

public class DiaoDuAction extends ActionSupport implements ServletRequestAware,ServletResponseAware{
	private HttpServletRequest request;
	private HttpServletResponse response;
	private DiaoDuGuanLiService diaoDuGuanLiService;
	private ReportRepair reportRepair;
	private Repair repair;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/*
	 * 分页查询所有
	 * 列出所有待分配任务
	 * 查询报修记录表
	 * 
	 */
public void queryAllReportRepair(){
	

	int page = Integer.valueOf(request.getParameter("page")==null?"1":request.getParameter("page"));
	int pageSize = Integer.valueOf(request.getParameter("rows")==null?"5":request.getParameter("rows"));
	
	List<ReportRepair> customList = diaoDuGuanLiService.queryAllReportRepair(page,pageSize);


	Iterator<ReportRepair> iterator = customList.iterator();
	JSONArray jsonArray = new JSONArray();
	JSONObject finalObj = new JSONObject();
	// 统计数据总行数 分页
	finalObj.put("total", diaoDuGuanLiService.countAllTask());

	while(iterator.hasNext())
	{
		JSONObject obj = new JSONObject();
		
		ReportRepair rere =  iterator.next();
		obj.put("customName", rere.getCustomName());
		obj.put("customId", rere.getCustomId());
		obj.put("empKefuId", rere.getEmpKefuId());
		obj.put("productType", rere.getProductType());
		obj.put("customSentTime", rere.getCustomSentTime());
		obj.put("customProperties", rere.getCustomProperties());
		obj.put("machineBrand", rere.getMachineBrand());
		obj.put("machineVersion", rere.getMachineVersion());
		obj.put("machineBugPhenomenon", rere.getMachineBugPhenomenon());
		obj.put("kefuName", rere.getKefuName());
		obj.put("reportRepairId", rere.getReportRepairId());
		
		
		
		
		jsonArray.add(obj);
	}
	System.out.println(jsonArray.toString());
	finalObj.put("rows", jsonArray);
	System.out.println("-----"+finalObj.toString()+"-----");
	  response.setContentType("text/html;charset=UTF-8");
	  PrintWriter out = null;
	try {
		out = response.getWriter();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}   
	   
	   out.println(finalObj.toString());   
	   out.flush();   
	   out.close();   
	
}
	/*
	 * 选中某条待分配任务，为其分配工程师，修改
	 * 报修 表，并且在维修记录表添加一条数据
	 */
public void fenpeiWeixiushi(){
	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	ActionContext ctx =ActionContext.getContext();
	Emp emp=(Emp) ctx.getSession().get("emp");
	String empId=emp.getEmpId();
	String empName=emp.getEmpName();
	this.reportRepair.setDiaoduManId(empId);
	this.reportRepair.setDiaoduManName(empName);
	this.reportRepair.setReportState("已分配");
	this.repair.setEmpSchedulingManId(empId);
	this.repair.setRepairSchdulTime(df.format(new Date()));
	this.repair.setScheduleManName(empName);
	this.repair.setRepairState("待维修");
	System.out.println("");
	this.repair.setReportRepairId(this.reportRepair.getReportRepairId());
	diaoDuGuanLiService.fenpeiWeixiushi(repair,reportRepair);
	JSONObject finalObj = new JSONObject();
	System.out.println("536455");
	

		
		finalObj.put("info", "分配成功");
		
		  response.setContentType("text/html;charset=UTF-8");
		  PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}   
		   
		   out.println(finalObj.toString());   
		   out.flush();   
		   out.close();   
	
	
}
/*
 * 
 * 统计维修师傅的工作情况，便于分配任务
 * 查询维修记录表，列出各工程师目前正在进行的任务数量
 * 方便参考，偏于分配任务
 */

public DiaoDuGuanLiService getDiaoDuGuanLiService() {
	return diaoDuGuanLiService;
}
public void setDiaoDuGuanLiService(DiaoDuGuanLiService diaoDuGuanLiService) {
	this.diaoDuGuanLiService = diaoDuGuanLiService;
}
public ReportRepair getReportRepair() {
	return reportRepair;
}
public void setReportRepair(ReportRepair reportRepair) {
	this.reportRepair = reportRepair;
}

public Repair getRepair() {
	return repair;
}
public void setRepair(Repair repair) {
	this.repair = repair;
}
@Override
public void setServletResponse(HttpServletResponse response) {
	this.response = response;
	
}
@Override
public void setServletRequest(HttpServletRequest request) {
	this.request = request;
	
}
}
