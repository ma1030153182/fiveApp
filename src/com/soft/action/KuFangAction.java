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

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.soft.entity.CheckApply;
import com.soft.entity.CompleteApply;
import com.soft.model.BeiJian;
import com.soft.model.BeijianApply;
import com.soft.model.Custom;
import com.soft.model.Emp;
import com.soft.service.KuFangGuanLiService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class KuFangAction extends ActionSupport implements ServletRequestAware,ServletResponseAware{

	
	private BeiJian beijian;
	private BeijianApply beijianApply;
	private KuFangGuanLiService kuFangGuanLiService;
	private HttpServletRequest request;
	private HttpServletResponse response;
	private static final long serialVersionUID = 1L;
	
	 public BeiJian getBeijian() {
			return beijian;
		}
		public BeijianApply getBeijianApply() {
		return beijianApply;
	}
	public void setBeijianApply(BeijianApply beijianApply) {
		this.beijianApply = beijianApply;
	}
		public void setBeijian(BeiJian beijian) {
			this.beijian = beijian;
		}
		public KuFangGuanLiService getKuFangGuanLiService() {
			return kuFangGuanLiService;
		}
		public void setKuFangGuanLiService(KuFangGuanLiService kuFangGuanLiService) {
			this.kuFangGuanLiService = kuFangGuanLiService;
		}
		
		public void setServletResponse(HttpServletResponse response) {
			this.response = response;
			
		}
		public void setServletRequest(HttpServletRequest request) {
			this.request = request;
		}
		
	/*
	 * 添加备件
	 */
	
	public void addBeijian(){
		
		
		
		System.out.println();
		boolean flag=kuFangGuanLiService.addBeijian(beijian);
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
	/*
	 * 
	 * 删除备件信息
	 */
	public void deleteBeijian(){
			
		
		System.out.println();
		kuFangGuanLiService.deleteBeijian(beijian);
		JSONObject finalObj = new JSONObject();
		System.out.println("536455");
		

			
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
	 * 修改备件信息
	 */
	
    public void editBeijian(){
		
    	
    	System.out.println();
    	kuFangGuanLiService.editBeijian(beijian);
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
    /*
     * 查询所有并分页
     */
    public String queryBeijianAll() {
    
    	
    	System.out.println(request.getParameter("page"));
    	int page = Integer.valueOf(request.getParameter("page")==null?"1":request.getParameter("page"));
    	int pageSize = Integer.valueOf(request.getParameter("rows")==null?"5":request.getParameter("rows"));
    		List<BeiJian> beijianList = kuFangGuanLiService.queryBeijianAll(page,pageSize);
        

    	Iterator iterator = beijianList.iterator();
    	JSONArray jsonArray = new JSONArray();
    	JSONObject finalObj = new JSONObject();
    	// 统计数据总行数 分页
    	finalObj.put("total", kuFangGuanLiService.countAllBeiJian());

    	while(iterator.hasNext())
    	{   BeiJian beijian = (BeiJian)iterator.next();
    		JSONObject obj = new JSONObject();
    		String number=beijian.getBeijianNumber();
    		String warnNumber=beijian.getWarnNumber();
    		
    		
    		obj.put("beijianId", beijian.getBeijianId());
    		obj.put("beijianName", beijian.getBeijianName());
    		obj.put("beijianVersion", beijian.getBeijianVersion());
    		obj.put("beijianPrice", beijian.getBeijianPrice());
    		obj.put("beijianNumber", number);
    		obj.put("warnNumber", warnNumber);
    		int a=Integer.parseInt(number);
    		int b=Integer.parseInt(warnNumber);
    		
    		if(a>b)
    		{
    			obj.put("beijianState", "正常");
    			}
    		else if(a==b){
    			obj.put("beijianState", "临界");
    		}else if(a>0&&a<b){
    			obj.put("beijianState", "警示");
    		}else if(a==0){
    			obj.put("beijianState", "缺货");
    		}
   	
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
     * 按条件查询所有并分页
     */
    public String queryBeijianBy() throws UnsupportedEncodingException{
    	String clientName=request.getParameter("search");
    	String name=new String(clientName.getBytes("ISO-8859-1"),"utf-8");

        BeiJian beij=new BeiJian();
    		System.out.println(name);
    		beij.setBeijianName(name);
		
    	int page = Integer.valueOf(request.getParameter("page")==null?"1":request.getParameter("page"));
    	int pageSize = Integer.valueOf(request.getParameter("rows")==null?"5":request.getParameter("rows"));
    	List<BeiJian> beijianList = kuFangGuanLiService.queryBeijianBy(beij,page,pageSize);
        

    	Iterator iterator = beijianList.iterator();
    	JSONArray jsonArray = new JSONArray();
    	JSONObject finalObj = new JSONObject();
    	// 统计数据总行数 分页
    	finalObj.put("total", kuFangGuanLiService.countAllBeiJianBy(beij));

    	while(iterator.hasNext())
    	{
    		JSONObject obj = new JSONObject();
    		
    		BeiJian beijian = (BeiJian)iterator.next();
    		obj.put("beijianId", beijian.getBeijianId());
    		obj.put("beijianName", beijian.getBeijianName());
    		obj.put("beijianVersion", beijian.getBeijianVersion());
    		obj.put("beijianPrice", beijian.getBeijianPrice());
    		obj.put("beijianNumber", beijian.getBeijianNumber());
    		obj.put("warnNumber", beijian.getWarnNumber());
    		obj.put("beijianState", beijian.getBeijianState());
    		
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
     * 查询所有申请并分页，列出待审批的所有备件申请
     */
    public String queryApplyAll(){
    	
    	
		
		int page = Integer.valueOf(request.getParameter("page")==null?"1":request.getParameter("page"));
    	int pageSize = Integer.valueOf(request.getParameter("rows")==null?"5":request.getParameter("rows"));

    	 List<BeijianApply>beijianApplyList = kuFangGuanLiService.queryApplyAll(page,pageSize);
      


    	Iterator<BeijianApply> iterator = beijianApplyList.iterator();
    	JSONArray jsonArray = new JSONArray();
    	JSONObject finalObj = new JSONObject();
    	// 统计数据总行数 分页
    	finalObj.put("total", kuFangGuanLiService.countAllApply());

    	while(iterator.hasNext())
    	{
    		JSONObject obj = new JSONObject();
    		
    		BeijianApply beijianApply =  iterator.next();
    		obj.put("applyId", beijianApply.getApplyId());
    		obj.put("beijianName", beijianApply.getBeijianName());
    		
//    		obj.put("applyNumber", beijianApply.);
    		obj.put("beijianPrice", beijianApply.getBeijianPrice());
    		obj.put("applyTime", beijianApply.getApplyTime());
    		obj.put("applyManName", beijianApply.getApplyManName());
    		obj.put("beijianVersion", beijianApply.getBeijianVersion());
    		obj.put("beijianId", beijianApply.getBeijianId());
    	
    		obj.put("beijianNumber", beijianApply.getBeijianNumber());
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
     * 审批申请
     * 修改设备申请表
     * 申请结果
     */
    public void passApply(){
    	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	ActionContext ctx =ActionContext.getContext();
		Emp emp=(Emp) ctx.getSession().get("emp");
		this.beijianApply.setApplyPassManId(emp.getEmpId());
		this.beijianApply.setApplyPassManName(emp.getEmpName());
		
		this.beijianApply.setApplyPassTime(df.format(new Date()));
    	boolean flag=kuFangGuanLiService.passApply(beijianApply,beijian);
          if(flag){
        	  JSONObject finalObj = new JSONObject();
          	System.out.println("536455");
       	
          		finalObj.put("info", "办理成功");
          		
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
        	  JSONObject finalObj = new JSONObject();
          	System.out.println("536455");
       	
          		finalObj.put("info", "库存不够，办理失败");
          		
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
     *当库管批准申请是，可以查看所要分配的备件库存情况，根据备件id查备件表
     */
    public String queryApplyBy(){
    	
    	beijianApply.setBeijianName(request.getParameter("search"));
	
		
    	int page = Integer.valueOf(request.getParameter("page")==null?"1":request.getParameter("page"));
    	int pageSize = Integer.valueOf(request.getParameter("rows")==null?"5":request.getParameter("rows"));
    	List<BeijianApply> beijianList = kuFangGuanLiService.queryApplyBy(beijianApply, page, pageSize);
        

    	Iterator iterator = beijianList.iterator();
    	JSONArray jsonArray = new JSONArray();
    	JSONObject finalObj = new JSONObject();
    	// 统计数据总行数 分页
    	finalObj.put("total", kuFangGuanLiService.countAllApplyBy(beijianApply));

    	while(iterator.hasNext())
    	{
    		JSONObject obj = new JSONObject();
    		
    		BeiJian beijian = (BeiJian)iterator.next();
    		obj.put("beijianId", beijian.getBeijianId());
    		obj.put("beijianName", beijian.getBeijianName());
    		obj.put("beijianVersion", beijian.getBeijianVersion());
    		obj.put("beijianPrice", beijian.getBeijianPrice());
    		obj.put("beijianNumber", beijian.getBeijianNumber());
    		obj.put("warnNumber", beijian.getWarnNumber());
    		obj.put("beijianState", beijian.getBeijianState());
    		
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
     * 查看设备流水，列出备件出库情况，从备件申请表查询
     */
    public String queryApplyComplete(){
    	
    	
    	
    	int page = Integer.valueOf(request.getParameter("page")==null?"1":request.getParameter("page"));
    	int pageSize = Integer.valueOf(request.getParameter("rows")==null?"5":request.getParameter("rows"));

    	List<BeijianApply> beijianApplyList = kuFangGuanLiService.queryApplyComplete(page,pageSize);
      


    	Iterator iterator = beijianApplyList.iterator();
    	JSONArray jsonArray = new JSONArray();
    	JSONObject finalObj = new JSONObject();
    	// 统计数据总行数 分页
    	finalObj.put("total", kuFangGuanLiService.countAllComplete());

    	while(iterator.hasNext())
    	{
    		JSONObject obj = new JSONObject();
    		
    		BeijianApply beijianApply =  (BeijianApply) iterator.next();
//    		obj.put("beijianApply.applyId", beijianApply.getApplyId());
    		obj.put("beijianName", beijianApply.getBeijianName());
    		obj.put("beijianNumber", beijianApply.getBeijianNumber());
    		obj.put("beijianPrice", beijianApply.getBeijianPrice());
//    		obj.put("beijianApply.applyTime", beijianApply.getApplyTime());
    		obj.put("applyPassTime", beijianApply.getApplyPassTime());
    		obj.put("applyManName", beijianApply.getApplyManName());
    		obj.put("applyPassManName", beijianApply.getApplyPassManName());
    		
    		obj.put("beijianVersion", beijianApply.getBeijianVersion());
    		
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
}
