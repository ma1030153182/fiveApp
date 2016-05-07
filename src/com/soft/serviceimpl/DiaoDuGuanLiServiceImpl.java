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
	 * 分页查询所有
	 * 列出所有待分配任务
	 * 查询报修记录表
	 * 
	 */

public List<ReportRepair> queryAllReportRepair(int page,int pageSize){
	StringBuffer hql = new StringBuffer("select m from ReportRepair m  where m.reportState ='未分配'");
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
	 * 选中某条待分配任务，为其分配工程师，修改
	 * 报修 表，并且在维修记录表添加一条数据
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
 * 统计维修师傅的工作情况，便于分配任务
 * 查询维修记录表，列出各工程师目前正在进行的任务数量
 * 方便参考，偏于分配任务
 */


@Override
public int countAllTask() {
	StringBuffer hql = new StringBuffer("select count(*) from ReportRepair m where m.reportState ='未分配'");
	
	
	
	return ReportRepairDAO.countAllHql(hql.toString());
}

}
