package com.soft.service;

import java.util.List;

import com.soft.model.Emp;
import com.soft.model.Module;

public interface LoginService {

	/*
	 * 根据账号信息，与模块表，角色表连接查询所对应的模块信息
	 * 跳到main.jsp展现所对应的模块
	 */
	public List<Emp> login(Emp emp);
		
		
		
	
/*
 * 检查登陆用户的角色，列出所能登陆的模块
 */
	public List<Module> checkRole(Emp emp);
		
	

}