package com.soft.service;

import java.util.List;

import com.soft.model.Emp;
import com.soft.model.Module;

public interface LoginService {

	/*
	 * �����˺���Ϣ����ģ�����ɫ�����Ӳ�ѯ����Ӧ��ģ����Ϣ
	 * ����main.jspչ������Ӧ��ģ��
	 */
	public List<Emp> login(Emp emp);
		
		
		
	
/*
 * ����½�û��Ľ�ɫ���г����ܵ�½��ģ��
 */
	public List<Module> checkRole(Emp emp);
		
	

}