package com.soft.service;

import java.util.List;

import com.soft.entity.Weixiushi;
import com.soft.model.BeijianApply;
import com.soft.model.Repair;
import com.soft.model.ReportRepair;




public interface WeiXiuGuanLiService {

	/*
	 * 查询维修记录表，列出我的任务
	 * 
	 */
	 public List<Repair> queryAllWeixiu(Repair re,int page,int pageSize);


	/*
	 * 开始任务，修改维修记录表的，状态，时间等
	 * 
	 */
	public abstract void startWeixiu(Repair repair);

	/*
	 * 填写维修报告，修改维修表，添加信息
	 */
	public abstract void fillWriteReport(Repair repair);

	/*
	 * 添加备件申请，填写申请单，在申请表写入记录
	 */
	public abstract void addBeijianApply(BeijianApply beijianApply);

	/*
	 * 编辑备件申请，修改申请单
	 */
	public abstract void editBeiJianApply(BeijianApply beijianApply);

	/*
	 * 撤销申请，备件申请，修改状态为撤销
	 */
	public abstract void DeleteBeiJianApply(BeijianApply beijianApply);

	/*
	 * 确认，申请成功。一旦确认，此申请完成，
	 */
	public abstract void sureBeijianApply(BeijianApply beijianApply);

	/*
	 * 根据申请单的状态等，列出未完成的申请单
	 */
	public List<BeijianApply> queryBeijianApply(BeijianApply beijianApply,int page,int pageSize);

    /*
     *分页
     */
	public int countAllweixiu(Repair re);
	public int countBeijianApply(BeijianApply beijianApply);


	public List seeReportRepair(ReportRepair reportRepair);
	
	public List<Weixiushi> tongjiWeixiushiGongzuo(int page,int pageSize);
	public int countAllWeixiushi();
}