package com.soft.serviceimpl;

import java.util.List;

import com.soft.dao.EmpDAO;
import com.soft.dao.ModuleDAO;
import com.soft.model.Emp;
import com.soft.model.Module;
import com.soft.service.LoginService;

public class LoginServiceImpl implements LoginService {
	private EmpDAO empDAO;
	private ModuleDAO moduleDAO;
	/*
	 * 根据账号信息，与模块表，角色表连接查询所对应的模块信息
	 * 跳到main.jsp展现所对应的模块
	 */
	public List<Emp> login(Emp emp){
		StringBuffer hql=new StringBuffer();
		hql.append("select p from Emp as p where p.empAccount='");
		hql.append(emp.getEmpAccount());
		hql.append( "' and  p.empPassword='");
		hql.append(emp.getEmpPassword());
		hql.append("'");
		System.out.println(hql.toString());
		String hq=hql.toString();
		List<Emp> list=empDAO.find(hq);
		
	return list;
		
		
		
	}
	/*
 * 检查登陆用户的角色，列出所能登陆的模块
 * select f  from  Module f  where f.moduleId in (select p.moudleId from  ModuleRole  p where p.roleName='库管' )
 */
	public List<Module> checkRole(Emp emp){
		StringBuffer hql=new StringBuffer();
		hql.append("select f  from  Module f  where f.moduleId in (select p.moudleId from  ModuleRole  p where p.roleName='");
		hql.append(emp.getRoleId());
		hql.append( "')");
		
		System.out.println(hql.toString());
		String hq=hql.toString();
		List<Module> list=moduleDAO.find(hq);
		
		return list;
		
		
	}

public ModuleDAO getModuleDAO() {
		return moduleDAO;
	}
	public void setModuleDAO(ModuleDAO moduleDAO) {
		this.moduleDAO = moduleDAO;
	}
public EmpDAO getEmpDAO() {
		return empDAO;
	}
	public void setEmpDAO(EmpDAO empDAO) {
		this.empDAO = empDAO;
	}


}
