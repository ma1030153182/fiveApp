package com.soft.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.soft.entity.Weixiushi;
import com.soft.model.BeiJian;
import com.soft.model.BeijianApply;
import com.soft.model.Emp;
import com.soft.model.Repair;
import com.soft.model.ReportRepair;
import com.soft.service.KuFangGuanLiService;
import com.soft.service.WeiXiuGuanLiService;

public class WeiXiuAction extends ActionSupport implements ServletRequestAware,ServletResponseAware {
	
	private Repair repair;
	private ReportRepair reportRepair;
	private BeijianApply beijianApply;
	private WeiXiuGuanLiService weiXiuGuanLiService;
	private HttpServletRequest request;
	private HttpServletResponse response;

	public Repair getRepair() {
		return repair;
	}
	public void setRepair(Repair repair) {
		this.repair = repair;
	}
	public BeijianApply getBeijianApply() {
		return beijianApply;
	}
	public void setBeijianApply(BeijianApply beijianApply) {
		this.beijianApply = beijianApply;
	}
	public ReportRepair getReportRepair() {
		return reportRepair;
	}
	public void setReportRepair(ReportRepair reportRepair) {
		this.reportRepair = reportRepair;
	}
	public WeiXiuGuanLiService getWeiXiuGuanLiService() {
		return weiXiuGuanLiService;
	}
	public void setWeiXiuGuanLiService(WeiXiuGuanLiService weiXiuGuanLiService) {
		this.weiXiuGuanLiService = weiXiuGuanLiService;
	}
	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}
	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/*
	 * ��ѯά�޼�¼���г��ҵ�����
	 * 
	 */
	public String queryAllWeixiu(){
		ActionContext ctx =ActionContext.getContext();
		Emp emp=(Emp) ctx.getSession().get("emp");
		Repair re=new Repair();
		String id=emp.getEmpId();
		re.setEmpRepairmanId(emp.getEmpId());
		
		int page = Integer.valueOf(request.getParameter("page")==null?"1":request.getParameter("page"));
    	int pageSize = Integer.valueOf(request.getParameter("rows")==null?"5":request.getParameter("rows"));
    	
    	List<Repair> weixiuList = weiXiuGuanLiService.queryAllWeixiu(re,page,pageSize);
    	
    	
    	Iterator iterator = weixiuList.iterator();
    	JSONArray jsonArray = new JSONArray();
    	JSONObject finalObj = new JSONObject();
    	// ͳ������������ ��ҳ
    	finalObj.put("total", weiXiuGuanLiService.countAllweixiu(re));

    	while(iterator.hasNext())
    	{
    		JSONObject obj = new JSONObject();
    		
    		Repair repair = (Repair)iterator.next();
    		obj.put("repairId", repair.getRepairId());
    		obj.put("empRepairmanId", repair.getEmpRepairmanId());
    		obj.put("reportRepairId", repair.getReportRepairId());
    		obj.put("repairSchdulTime", repair.getRepairSchdulTime());
    		obj.put("repairState", repair.getRepairState());
    		obj.put("schduleManName", repair.getScheduleManName());
    		
    		
    		obj.put("empSchedulingManId", repair.getEmpSchedulingManId());
    		
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
    		
    		e.printStackTrace();
    	}   
    	   
    	   out.println(finalObj.toString());   
    	   out.flush();   
    	   out.close();  
		return null;
		
	}
	/*
	 * ��ʼ�����޸�ά�޼�¼��ģ�״̬��ʱ���
	 * 
	 */
	public void startWeixiu(){
		
		weiXiuGuanLiService.startWeixiu(repair);
		JSONObject finalObj = new JSONObject();
		finalObj.put("info", "���޸�״̬Ϊά���У������");
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
	 * ��дά�ޱ��棬�޸�ά�ޱ������Ϣ
	 */
	public void  fillWriteReport(){
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		this.repair.setEndTime(df.format(new Date()));
		weiXiuGuanLiService.fillWriteReport(repair);
		JSONObject finalObj = new JSONObject();
		finalObj.put("info", "�ύ�ɹ��������");
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
	 * ��ӱ������룬��д���뵥���������д���¼
	 */
	public void addBeijianApply(){
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		ActionContext ctx =ActionContext.getContext();
		Emp emp=(Emp) ctx.getSession().get("emp");
		this.beijianApply.setApplyManId(emp.getEmpId());
		this.beijianApply.setApplyManName(emp.getEmpName());
		this.beijianApply.setApplyState("�����");
		this.beijianApply.setApplyTime(df.format(new Date()));
		weiXiuGuanLiService.addBeijianApply(beijianApply);
		JSONObject finalObj = new JSONObject();
		finalObj.put("info", "�������ɹ����ȴ����������У��뵽�˵���������ҵ�����鿴");
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
	 * �༭�������룬�޸����뵥
	 */
	public void editBeiJianApply(){
		weiXiuGuanLiService.editBeiJianApply(beijianApply);
		JSONObject finalObj = new JSONObject();
		finalObj.put("info", "�޸ĳɹ�");
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
	 * �������룬�������룬�޸�״̬Ϊ����
	 */
	public void DeleteBeiJianApply(){
		weiXiuGuanLiService.DeleteBeiJianApply(beijianApply);
		JSONObject finalObj = new JSONObject();
		finalObj.put("info", "ɾ���ɹ�");
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
	 * ȷ�ϣ�����ɹ���һ��ȷ�ϣ���������ɣ�
	 */
	public void sureBeijianApply(){
		weiXiuGuanLiService.sureBeijianApply(beijianApply);
		JSONObject finalObj = new JSONObject();
		finalObj.put("info", "������ɣ������");
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
	 * �������뵥��״̬�ȣ��г�δ��ɵ����뵥
	 */
	public String queryBeijianApply(){
		ActionContext ctx =ActionContext.getContext();
		Emp emp=(Emp) ctx.getSession().get("emp");
		BeijianApply be=new BeijianApply();
		String id=emp.getEmpId();
		be.setApplyManId(id);
		int page = Integer.valueOf(request.getParameter("page")==null?"1":request.getParameter("page"));
    	int pageSize = Integer.valueOf(request.getParameter("rows")==null?"5":request.getParameter("rows"));
    	
    	List<BeijianApply> beijianApplyList = weiXiuGuanLiService.queryBeijianApply(be,page,pageSize);
    	
    	
    	Iterator iterator = beijianApplyList.iterator();
    	JSONArray jsonArray = new JSONArray();
    	JSONObject finalObj = new JSONObject();
    	// ͳ������������ ��ҳ
    	finalObj.put("total", weiXiuGuanLiService.countBeijianApply(be));

    	while(iterator.hasNext())
    	{
    		JSONObject obj = new JSONObject();
    		BeijianApply beijianApply = (BeijianApply)iterator.next();
    		obj.put("applyId", beijianApply.getApplyId());
    		obj.put("beijianName", beijianApply.getBeijianName());
    		obj.put("beijianNumber", beijianApply.getBeijianNumber());
    		obj.put("beijianPrice", beijianApply.getBeijianPrice());
    		obj.put("applyTime", beijianApply.getApplyTime());
    		obj.put("applyPassTime", beijianApply.getApplyPassTime());
    		obj.put("applyManId", beijianApply.getApplyManId());
    		obj.put("applyPassManId", beijianApply.getApplyPassManId());
    		obj.put("beijianId", beijianApply.getBeijianId());
    		obj.put("beijianVersion", beijianApply.getBeijianVersion());
    		obj.put("applyState", beijianApply.getApplyState());
    		
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
    		
    		e.printStackTrace();
    	}   
    	   
    	   out.println(finalObj.toString());   
    	   out.flush();   
    	   out.close();  
		return null;
	}

	public String seeReportRepair(){
		System.out.println(reportRepair.getReportRepairId());
    	List list =null;
    	list=weiXiuGuanLiService.seeReportRepair(reportRepair);
    	Object[]a=(Object[]) list.get(0);
    	
    	
    	
    	
    	
    	
    	// ͳ������������ ��ҳ
//    	StringBuffer hql = new StringBuffer("select m.custom_name, m.custom_company, " +
//				" m.custom_tel, m.custom_mabil, m.custom_addrass, m.custom_email " +
//				" m.custom_post, m.custom_sent_time, t.custom_properties, t.forecast_price," +
//				" t.forecast_complete_time, t.product_type, t.machine_brand,t.machine_version," +
//				" t.machine_bug_phenomenon,t.machine_start_password,t.machine_RAM , t.other" +
//				
//				" from custom as m, report_repair as t where t.report_repair_id='");

    	
    	
    		JSONObject obj = new JSONObject();
    		obj.put("customName", a[0]);
    		obj.put("customCompany", a[1]);
    		obj.put("customTel", a[2]);
    		obj.put("customMabile", a[3]);
    		
    		obj.put("customAddrass", a[4]);
    		obj.put("customEmail", a[5]);
    		obj.put("customPost", a[6]);
    		obj.put("sendtime", a[7]);
    		
    		obj.put("customProperties", a[8]);
    		obj.put("forecastPrice", a[9]);
    		obj.put("forecastCompleteTime", a[10]);
    		obj.put("productType", a[11]);
    		obj.put("machineBrand", a[12]);
    		obj.put("machineVersion", a[13]);
    		obj.put("machineBugPhenomenon", a[14]);
    		obj.put("machineStartPassword", a[15]);
    		obj.put("machineRam", a[16]);
    		obj.put("other", a[17]);
    		
    		
    		
    	
    	//System.out.println("-----"+finalObj.toString()+"-----");
    	  response.setContentType("text/html;charset=UTF-8");
    	  PrintWriter out = null;
    	try {
    		out = response.getWriter();
    	} catch (IOException e) {
    		
    		e.printStackTrace();
    	}   
    	   
    	   out.println(obj.toString());   
    	   out.flush();   
    	   out.close();  
		return null;
	}
	@Override
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
		
	}
	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
		
	}
	public void tongjiWeixiushiGongzuo(){

		int page = Integer.valueOf(request.getParameter("page")==null?"1":request.getParameter("page"));
		int pageSize = Integer.valueOf(request.getParameter("rows")==null?"5":request.getParameter("rows"));
		
		List customList = weiXiuGuanLiService.tongjiWeixiushiGongzuo(page,pageSize);


		Iterator iterator = customList.iterator();
		JSONArray jsonArray = new JSONArray();
		JSONObject finalObj = new JSONObject();
		// ͳ������������ ��ҳ
		finalObj.put("total", weiXiuGuanLiService.countAllWeixiushi());

		while(iterator.hasNext())
		{
			JSONObject obj = new JSONObject();
			
			Object[] a =  (Object[]) iterator.next();
			obj.put("empId", a[0]);
    		obj.put("workNumber", a[1]);
    		obj.put("empMobile", a[2]);
    		obj.put("empName", a[3]);
    		
    		obj.put("empAddrass", a[4]);
    		obj.put("empEmail", a[5]);
    		obj.put("goodAt", a[6]);
    		
			
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
		
		
	}


}
