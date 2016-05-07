package com.soft.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.soft.model.Custom;
import com.soft.model.Emp;
import com.soft.model.Module;
import com.soft.service.KeFuGuanLiService;
import com.soft.service.LoginService;

public class LoginAction extends ActionSupport implements ServletRequestAware,
		ServletResponseAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Emp emp;
	private LoginService loginService;
	private HttpServletRequest request;
	private HttpServletResponse response;

	public String login() {
		List<Emp> list = loginService.login(emp);
		ActionContext ctx = ActionContext.getContext();
		if (list.size() > 0) {
			Emp reemp = list.get(0);
			Emp ree = (Emp) ctx.getSession().get("reemp");
			if (ree != null) {
			} else {
				ctx.getSession().put("emp", reemp);
			}
			return SUCCESS;
		}
		return "error";

	}

	public String loginOut() {

		ActionContext ctx = ActionContext.getContext();
		ctx.getSession().clear();

		return SUCCESS;

	}

	/*
	 * ����½�û��Ľ�ɫ���г����ܵ�½��ģ��
	 */
	public void checkRole() {
		ActionContext ctx = ActionContext.getContext();
		Emp emp = (Emp) ctx.getSession().get("emp");
		System.out.println(emp.getRoleId());
		List<Module> list = loginService.checkRole(emp);

		Iterator<Module> iterator = list.iterator();
		JSONArray jsonArray = new JSONArray();
		JSONObject finalObj = new JSONObject();

		while (iterator.hasNext()) {
			JSONObject obj = new JSONObject();

			Module module = iterator.next();
			obj.put("id", module.getModuleId());
			obj.put("name", module.getModuleName());
			obj.put("parentId", module.getParentId());
			obj.put("url", module.getModuleUrl());

			jsonArray.add(obj);
		}
		System.out.println(jsonArray.toString());
		// finalObj.put("role", jsonArray);
		// System.out.println("-----"+finalObj.toString()+"-----");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		out.println(jsonArray.toString());
		out.flush();
		out.close();

	}

	public Emp getEmp() {
		return emp;
	}

	public void setEmp(Emp emp) {
		this.emp = emp;
	}

	public LoginService getLoginService() {
		return loginService;
	}

	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
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
