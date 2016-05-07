package com.soft.service;

import java.util.List;


import com.soft.model.Repair;
import com.soft.model.ReportRepair;


public interface DiaoDuGuanLiService {

	/*
	 * 分页查询所有
	 * 列出所有待分配任务
	 * 查询报修记录表
	 * 
	 */
	public List<ReportRepair> queryAllReportRepair(int page,int pageSize);
	/*
	 * 选中某条待分配任务，为其分配工程师，修改
	 * 报修 表，并且在维修记录表添加一条数据
	 */
	public void fenpeiWeixiushi(Repair repair,ReportRepair reportRepair);
/*
 * 
 * 统计维修师傅的工作情况，便于分配任务
 * 查询维修记录表，列出各工程师目前正在进行的任务数量
 * 方便参考，偏于分配任务
 */


public int countAllTask();

}