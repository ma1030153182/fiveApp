package com.soft.serviceimpl;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.soft.dao.RepairDAO;

import com.soft.dao.ReportRepairDAO;
import com.soft.model.Custom;
import com.soft.model.Emp;
import com.soft.model.Repair;
import com.soft.model.ReportRepair;
import com.soft.service.DiaoDuGuanLiService;

public class DiaoDuGuanLiServiceImpl implements DiaoDuGuanLiService {

    private  RepairDAO repairDAO;
    private  ReportRepairDAO ReportRepairDAO;
	/*
	 * ��ҳ��ѯ����
	 * �г����д���������
	 * ��ѯ���޼�¼��
	 * 
	 */

public List<ReportRepair> queryAllReportRepair(int page,int pageSize){
	StringBuffer hql = new StringBuffer("select m from ReportRepair m  where m.reportState ='δ����'");
	List<ReportRepair> list=ReportRepairDAO.findPage(hql.toString(), page, pageSize);

	return list;
	
}
	public RepairDAO getRepairDAO() {
	return repairDAO;
}
public void setRepairDAO(RepairDAO repairDAO) {
	this.repairDAO = repairDAO;
}
public ReportRepairDAO getReportRepairDAO() {
	return ReportRepairDAO;
}
public void setReportRepairDAO(ReportRepairDAO reportRepairDAO) {
	ReportRepairDAO = reportRepairDAO;
}
/*
	 * ѡ��ĳ������������Ϊ����乤��ʦ���޸�
	 * ���� ��������ά�޼�¼�����һ������
	 */
public void fenpeiWeixiushi(Repair repair,ReportRepair reportRepair ){
	ReportRepair reportR =(ReportRepair) ReportRepairDAO.findById(ReportRepair.class, reportRepair.getReportRepairId());
	reportR.setDiaoduManId(reportRepair.getDiaoduManId());
	reportR.setDiaoduManName(reportRepair.getDiaoduManName());
	reportR.setReportState(reportRepair.getReportState());
	repairDAO.save(repair);
	ReportRepairDAO.update(reportR);
}
/*
 * 
 * ͳ��ά��ʦ���Ĺ�����������ڷ�������
 * ��ѯά�޼�¼���г�������ʦĿǰ���ڽ��е���������
 * ����ο���ƫ�ڷ�������
 */


@Override
public int countAllTask() {
	StringBuffer hql = new StringBuffer("select count(*) from ReportRepair m where m.reportState ='δ����'");
	
	
	
	return ReportRepairDAO.countAllHql(hql.toString());
}

}
