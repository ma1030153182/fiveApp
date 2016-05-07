package com.soft.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
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
import com.soft.model.Custom;
import com.soft.model.Emp;
import com.soft.model.ReportRepair;
import com.soft.service.KeFuGuanLiService;


public class KeFuAction extends ActionSupport implements ServletRequestAware,ServletResponseAware {
	private HttpServletRequest request;
	private HttpServletResponse response;
	private  KeFuGuanLiService keFuGuanLiService;
	private ReportRepair reportRepair;
	public ReportRepair getReportRepair() {
		return reportRepair;
	}
	public void setReportRepair(ReportRepair reportRepair) {
		this.reportRepair = reportRepair;
	}
	public KeFuGuanLiService getKeFuGuanLiService() {
		return keFuGuanLiService;
	}
	public void setKeFuGuanLiService(KeFuGuanLiService keFuGuanLiService) {
		this.keFuGuanLiService = keFuGuanLiService;
	}
	private Custom custom;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public Custom getCustom() {
		return custom;
	}
	public void setCustom(Custom custom) {
		this.custom = custom;
	}
	
	/*
	 * 
	 * 增加客户信息
	 */
	public void addOneCustom(){
		System.out.println("custom"+custom.getCustomAddrass());
		ActionContext ctx =ActionContext.getContext();
		Emp emp=(Emp) ctx.getSession().get("emp");
		this.custom.setAddKefuId(emp.getEmpId());
		this.custom.setAddKefuName(emp.getEmpName());
		
		boolean flag=keFuGuanLiService.addCustom(custom);
		JSONObject finalObj = new JSONObject();
		System.out.println("536455"+custom.getCustomName());
		if(flag){

			
			finalObj.put("info", "添加成功");
			
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
		}else{
			
			finalObj.put("info", "添加失败，请重新添加");
			
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
	
		
		
	}
	/*
	 * 
	 * 删除客户信息
	 */
public void deleteCustom(){
	
		
	System.out.println("custom"+custom.getCustomAddrass());
	keFuGuanLiService.deleteCustom(custom);
	JSONObject finalObj = new JSONObject();
	System.out.println("536455"+custom.getCustomName());
	

		
		finalObj.put("info", "删除成功，请继续！");
		
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
 * 编辑客户信息
 */
public void editCustom(){
	

	System.out.println("custom"+custom.getCustomAddrass());
	keFuGuanLiService.updateCustom(custom);
	JSONObject finalObj = new JSONObject();
	System.out.println("536455"+custom.getCustomName());
	

		
		finalObj.put("info", "修改成功");
		
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
 * 查询客户信息
 */
public void queryCustomByIdCard(){
	System.out.println(custom.getCustomIdCard());
	List<Custom> customList= keFuGuanLiService.queryCustomByIdCard(custom);
	System.out.println(customList.size());
	
	
	
	JSONObject obj = new JSONObject();
	
	if(customList.size()>0){
		Custom cus=customList.get(0);
		
		obj.put("customId", cus.getCustomId());
		obj.put("customName", cus.getCustomName());
		obj.put("customIdCard", cus.getCustomIdCard());
		obj.put("customCompany", cus.getCustomCompany());
		obj.put("customAddrass", cus.getCustomAddrass());
		obj.put("customEmail", cus.getCustomEmail());
		obj.put("customMabile", cus.getCustomMabile());
		obj.put("customPost", cus.getCustomPost());
		obj.put("customTel", cus.getCustomTel());
		
	}else{
		obj.put("info", "查无此人，请去新建此人信息");
		
		
	}
	
	
	
	System.out.println(obj.toString());
	
	//System.out.println("-----"+finalObj.toString()+"-----");
	  response.setContentType("text/html;charset=UTF-8");
	  PrintWriter out = null;
	try {
		out = response.getWriter();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}   
	   
	   out.println(obj.toString());   
	   out.flush();   
	   out.close();   
	
}
/*
 * 
 * 根据条件查询客户信息并分页
 */
public String queryAllCustom(){
	String name=request.getParameter("customName");
	System.out.println(name);

	int page = Integer.valueOf(request.getParameter("page")==null?"1":request.getParameter("page"));
	int pageSize = Integer.valueOf(request.getParameter("rows")==null?"5":request.getParameter("rows"));
	
	List<Custom> customList = keFuGuanLiService.queryAll(page,pageSize);


	Iterator<Custom> iterator = customList.iterator();
	JSONArray jsonArray = new JSONArray();
	JSONObject finalObj = new JSONObject();
	// 统计数据总行数 分页
	finalObj.put("total", keFuGuanLiService.countAll());

	while(iterator.hasNext())
	{
		JSONObject obj = new JSONObject();
		
		Custom custom =  iterator.next();
		obj.put("customId", custom.getCustomId());
		obj.put("customName", custom.getCustomName());
		obj.put("customIdCard", custom.getCustomIdCard());
		obj.put("customCompany", custom.getCustomCompany());
		obj.put("customAddrass", custom.getCustomAddrass());
		obj.put("customEmail", custom.getCustomEmail());
		obj.put("customMabile", custom.getCustomMabile());
		obj.put("customPost", custom.getCustomPost());
		obj.put("customTel", custom.getCustomTel());
		jsonArray.add(obj);
	}
	System.out.println(jsonArray.toString());
	finalObj.put("rows", jsonArray);
	//System.out.println("-----"+finalObj.toString()+"-----");
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
	
	return null;
	
	
}
public String queryAllCustomBy() throws UnsupportedEncodingException{
	String clientName=request.getParameter("search");
String name=new String(clientName.getBytes("ISO-8859-1"),"utf-8");


	System.out.println(name);
	Custom cus=new Custom ();
	
	cus.setCustomName(name);
	int page = Integer.valueOf(request.getParameter("page")==null?"1":request.getParameter("page"));
	int pageSize = Integer.valueOf(request.getParameter("rows")==null?"5":request.getParameter("rows"));
	
	List<Custom> customList = keFuGuanLiService.queryAllBy( cus,page,pageSize);


	Iterator<Custom> iterator = customList.iterator();
	JSONArray jsonArray = new JSONArray();
	JSONObject finalObj = new JSONObject();
	// 统计数据总行数 分页
	finalObj.put("total", keFuGuanLiService.countAllBy(cus));

	while(iterator.hasNext())
	{
		JSONObject obj = new JSONObject();
		
		Custom custom =  iterator.next();
		obj.put("customId", custom.getCustomId());
		obj.put("customName", custom.getCustomName());
		obj.put("customIdCard", custom.getCustomIdCard());
		obj.put("customCompany", custom.getCustomCompany());
		obj.put("customAddrass", custom.getCustomAddrass());
		obj.put("customEmail", custom.getCustomEmail());
		obj.put("customMabile", custom.getCustomMabile());
		obj.put("customPost", custom.getCustomPost());
		obj.put("customTel", custom.getCustomTel());
		jsonArray.add(obj);
	}
	System.out.println(jsonArray.toString());
	finalObj.put("rows", jsonArray);
	//System.out.println("-----"+finalObj.toString()+"-----");
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
	
	return null;
	
	
}
/*
 * 增加报修订单
 * 在报修表添加数据
 * 
 */
public void addReportRepair(){
	ActionContext ctx =ActionContext.getContext();
	Emp emp=(Emp) ctx.getSession().get("emp");
	this.reportRepair.setEmpKefuId(emp.getEmpId());
	this.reportRepair.setKefuName(emp.getEmpName());
	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	this.reportRepair.setCustomSentTime(df.format(new Date()));
	
	
	boolean flag=keFuGuanLiService.addReportRepair(reportRepair);
	JSONObject finalObj = new JSONObject();
	System.out.println("536455");
	if(flag){

		
		finalObj.put("info", "添加成功");
		
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
	}else{
		
		finalObj.put("info", "添加失败，请重新添加");
		
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
	
}
public void editReportRepair(){
	
	keFuGuanLiService.editReportRepair(reportRepair);
	JSONObject finalObj = new JSONObject();
	System.out.println("536455");
	

		
		finalObj.put("info", "修改成功");
		
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
@Override
public void setServletResponse(HttpServletResponse response) {
	this.response = response;
	
}
@Override
public void setServletRequest(HttpServletRequest request) {
	this.request = request;
	
}

}
