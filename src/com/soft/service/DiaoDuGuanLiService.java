package com.soft.service;

import java.util.List;


import com.soft.model.Repair;
import com.soft.model.ReportRepair;


public interface DiaoDuGuanLiService {

	/*
	 * ��ҳ��ѯ����
	 * �г����д���������
	 * ��ѯ���޼�¼��
	 * 
	 */
	public List<ReportRepair> queryAllReportRepair(int page,int pageSize);
	/*
	 * ѡ��ĳ������������Ϊ����乤��ʦ���޸�
	 * ���� ��������ά�޼�¼�����һ������
	 */
	public void fenpeiWeixiushi(Repair repair,ReportRepair reportRepair);
/*
 * 
 * ͳ��ά��ʦ���Ĺ�����������ڷ�������
 * ��ѯά�޼�¼���г�������ʦĿǰ���ڽ��е���������
 * ����ο���ƫ�ڷ�������
 */


public int countAllTask();

}