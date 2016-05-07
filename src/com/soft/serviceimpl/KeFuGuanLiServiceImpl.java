package com.soft.serviceimpl;

import java.util.List;

import com.soft.dao.CustomDAO;
import com.soft.dao.ReportRepairDAO;
import com.soft.model.Custom;
import com.soft.model.ReportRepair;
import com.soft.service.KeFuGuanLiService;


public class KeFuGuanLiServiceImpl implements KeFuGuanLiService {
	private CustomDAO  customDAO ;
	private ReportRepairDAO reportRepairDAO;
	
	public ReportRepairDAO getReportRepairDAO() {
		return reportRepairDAO;
	}
	public void setReportRepairDAO(ReportRepairDAO reportRepairDAO) {
		this.reportRepairDAO = reportRepairDAO;
	}
	public CustomDAO getCustomDAO() {
		return customDAO;
	}
	public void setCustomDAO(CustomDAO customDAO) {
		this.customDAO = customDAO;
	}
 /*
  * 
  * 增加客户信息
  * @see com.soft.service.KeFuGuanLiService#addCustom(com.soft.model.Custom)
  */
	@Override
	public boolean addCustom(Custom custom){
		boolean flag=false;
		
		flag=customDAO.save(custom);
		return flag;
		
	}
  /* 删除客户信息
 * @see com.soft.serviceimpl.KeFuGuanLiService#deleteCustom(com.soft.model.Custom)
 */
@Override
public void deleteCustom(Custom custom){
	customDAO.delete(custom);
	
	}
/* 更新客户信息
 * @see com.soft.serviceimpl.KeFuGuanLiService#updateCustom(com.soft.model.Custom)
 */
@Override
public void updateCustom(Custom custom){

	Custom cus=(Custom) customDAO.findById(Custom.class, custom.getCustomId());
	cus.setCustomAddrass(custom.getCustomAddrass());
	cus.setCustomCompany(custom.getCustomCompany());
	cus.setCustomEmail(custom.getCustomEmail());
	cus.setCustomIdCard(custom.getCustomIdCard());
	cus.setCustomMabile(custom.getCustomMabile());
	cus.setCustomName(custom.getCustomName());
	cus.setCustomPost(custom.getCustomPost());
	cus.setCustomTel(custom.getCustomTel());
	
	customDAO.update(cus);
}
/* 根据条件查找
 * @see com.soft.serviceimpl.KeFuGuanLiService#queryCustom(com.soft.model.Custom)
 */
@Override
public List<Custom> queryAllBy(Custom custom,int page, int pageSize){
	StringBuffer hql ;
	String a=custom.getCustomName();
	if(a!=""){
	hql= new StringBuffer("select m from Custom m where m.customName like '%");
	hql.append(custom.getCustomName());
	hql.append("%'");
	}else{
		 hql = new StringBuffer("select m from Custom m ");
	}
	List<Custom> list=customDAO.findPage(hql.toString(), page, pageSize);

	return list;
	
	
}
/*
 * 查询所有分页
 * @see com.soft.service.KeFuGuanLiService#queryAll(int, int)
 */
public List<Custom> queryAll(int page, int pageSize){

	
	StringBuffer hql = new StringBuffer("select m from Custom m ");
	List<Custom> list=customDAO.findPage(hql.toString(), page, pageSize);

	return list;
}
/*
 * 查询数量
 * @see com.soft.service.KeFuGuanLiService#countAll()
 */
public int countAll(){
	
		StringBuffer hql = new StringBuffer("select count(*) from Custom m ");
		return customDAO.countAllHql(hql.toString());
	
	
}
/*
 * 
 * 根据条件查询数量
 * @see com.soft.service.KeFuGuanLiService#countALLBy(java.lang.String)
 */
public int countAllBy(Custom custom){
	String a=custom.getCustomName();
	StringBuffer hql;
	if(a!=""){
	 hql = new StringBuffer("select count(*) from Custom m where m.customName like '%");
	
	hql.append(custom.getCustomName());
	hql.append("%'");
	}else{
	 hql = new StringBuffer("select count(*) from Custom ");
	}
	return customDAO.countAllHql(hql.toString());
}


public List<Custom> queryCustomByIdCard(Custom custom){
	StringBuffer hql = new StringBuffer("select m from Custom m where m.customIdCard='");
	hql.append(custom.getCustomIdCard());
	hql.append("'");
	String hq=hql.toString();
	
	
	List<Custom>  list=customDAO.find(hq);
	return list;
	
}
/*
 * 
 * 增加报修单
 * @see com.soft.service.KeFuGuanLiService#addCustom(com.soft.model.Custom)
 */
	@Override
	public boolean addReportRepair(ReportRepair reportRepair){
    	
		return reportRepairDAO.save(reportRepair);
		
	}
public void editReportRepair(ReportRepair reportRepair){
	
	ReportRepair report=(ReportRepair) reportRepairDAO.findById(ReportRepair.class, reportRepair.getReportRepairId());
	report.setCustomProperties(reportRepair.getCustomProperties());
	report.setForecastCompleteTime(reportRepair.getForecastCompleteTime());
	report.setForecastPrice(reportRepair.getForecastPrice());
	report.setMachineBrand(reportRepair.getMachineBrand());
	report.setMachineBugPhenomenon(reportRepair.getMachineBugPhenomenon());
	report.setMachineRam(reportRepair.getMachineRam());
	report.setMachineStartPassword(reportRepair.getMachineStartPassword());
	report.setMachineVersion(reportRepair.getMachineVersion());
	report.setProductType(reportRepair.getProductType());
	report.setOther(reportRepair.getOther());
		 reportRepairDAO.update(report);
		
	}
	/*
	 * (non-Javadoc)
	 * 在填写保修单时，唯一条件搜索出要办人的信息
	 */
	@Override
	public List<Custom> queryCustomById(Custom custom) {
		StringBuffer hql=new StringBuffer("select m from Custom m  where m.customIdCard='");
		hql.append(custom.getCustomIdCard());
		hql.append("'");
		List<Custom>  list=customDAO.find(hql.toString());
		return list;
		 
	}
	

}
