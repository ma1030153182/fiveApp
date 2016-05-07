package com.soft.service;



import java.util.List;

import com.soft.entity.CompleteApply;
import com.soft.model.BeiJian;
import com.soft.model.BeijianApply;
import com.soft.model.Repair;

public interface KuFangGuanLiService {
	
	/*
	 * 添加备件，备件入库
	 */
	
	public boolean addBeijian(BeiJian beijian) ;
	/*
	 * 
	 * 删除备件信息
	 */
	public void deleteBeijian(BeiJian beijian) ;
	/*
	 * 修改备件信息
	 */
	
    public void editBeijian(BeiJian beijian) ;
    /*
     * 查询所有并分页，列出
     */
    public List<BeiJian> queryBeijianAll(int page, int pageSize);
    /*
     * 按条件查询所有并分页
     */
    public List<BeiJian> queryBeijianBy(BeiJian BeiJian,int page, int pageSize);
    /*
     * 查询所有申请并分页
     */
    public  List<BeijianApply> queryApplyAll(int page, int pageSize);
    /*
     * 审批申请
     * 修改设备申请表
     * 申请结果
     */
    public boolean passApply(BeijianApply beijianApply,BeiJian beijian);
    
    /*
     *当库管批准申请是，可以查看所要分配的备件库存情况，根据备件id查备件表
     */
    public List<BeijianApply> queryApplyBy(BeijianApply BeijianApply ,int page, int pageSize);
    	
   
    /*
     * 查看设备流水，列出备件出库情况，从备件申请表查询
     */
    public List<BeijianApply> queryApplyComplete(int page, int pageSize);
    
    
    public int countAllBeiJian();
    public int countAllBeiJianBy(BeiJian beijian);
    public int countAllApply();
    public int countAllApplyBy(BeijianApply BeijianApply);
 
    public int countAllComplete();

}
