package com.soft.serviceimpl;


import java.util.List;

import com.soft.dao.BeijianApplyDAO;
import com.soft.dao.CustomDAO;
import com.soft.dao.RepairDAO;
import com.soft.dao.ReportRepairDAO;
import com.soft.model.BeijianApply;
import com.soft.model.Repair;
import com.soft.model.ReportRepair;
import com.soft.service.WeiXiuGuanLiService;

public class WeiXiuGuanLiServiceImpl implements WeiXiuGuanLiService {
	
	private RepairDAO repairDAO;
	private BeijianApplyDAO beijianApplyDAO;
	private ReportRepairDAO reportRepairDAO;
	private CustomDAO customDAO;
	
	
	
	/*
	 * ��ʼ�����޸�ά�޼�¼��ģ�״̬��ʱ���
	 * 
	 */
	
	public CustomDAO getCustomDAO() {
		return customDAO;
	}

	public void setCustomDAO(CustomDAO customDAO) {
		this.customDAO = customDAO;
	}

	public ReportRepairDAO getReportRepairDAO() {
		return reportRepairDAO;
	}

	public void setReportRepairDAO(ReportRepairDAO reportRepairDAO) {
		this.reportRepairDAO = reportRepairDAO;
	}

	public RepairDAO getRepairDAO() {
		return repairDAO;
	}

	public void setRepairDAO(RepairDAO repairDAO) {
		this.repairDAO = repairDAO;
	}

	public BeijianApplyDAO getBeijianApplyDAO() {
		return beijianApplyDAO;
	}

	public void setBeijianApplyDAO(BeijianApplyDAO beijianApplyDAO) {
		this.beijianApplyDAO = beijianApplyDAO;
	}

	@Override
	public void startWeixiu(Repair repair){
		Repair re=(Repair) repairDAO.findById(Repair.class, repair.getRepairId());
		re.setRepairState(repair.getRepairState());
		repairDAO.update(re);
		
	}
	/*
	 * ��дά�ޱ��棬�޸�ά�ޱ������Ϣ
	 */
	
	@Override
	public void  fillWriteReport(Repair repair){
		Repair re=(Repair) repairDAO.findById(Repair.class, repair.getRepairId());
		re.setAttentionMatter(repair.getAttentionMatter());
		re.setEndTime(repair.getEndTime());
		re.setMachineCheckRecord(repair.getMachineCheckRecord());
		re.setMachineCheckTime(repair.getMachineCheckTime());
		re.setMaterialPrice(repair.getMaterialPrice());
		re.setRepairLabourPrice(repair.getRepairLabourPrice());
		re.setRepairPromise(repair.getRepairPromise());
		re.setRepairRecord(repair.getRepairRecord());
		re.setRepairState(repair.getRepairState());
		re.setRepairWorkTime(repair.getRepairWorkTime());
		repairDAO.update(re);
	}
	/*
	 * ��ӱ������룬��д���뵥���������д���¼
	 */
	
	@Override
	public void addBeijianApply(BeijianApply beijianApply){
		
		beijianApplyDAO.save(beijianApply);
	}
	/*
	 * �༭�������룬�޸����뵥
	 */
	
	@Override
	public void editBeiJianApply(BeijianApply beijianApply){
		BeijianApply bApply=(BeijianApply) beijianApplyDAO.findById(BeijianApply.class, beijianApply.getApplyId());
		bApply.setBeijianNumber(beijianApply.getBeijianNumber());
		beijianApplyDAO.update(bApply);
	}
	/*
	 * �������룬�������룬�޸�״̬Ϊ����
	 */
	
	@Override
	public void DeleteBeiJianApply(BeijianApply beijianApply){
		
		beijianApplyDAO.update(beijianApply);
	}
	/*
	 * ȷ�ϣ�����ɹ���һ��ȷ�ϣ���������ɣ�
	 */
	
	@Override
	public void sureBeijianApply(BeijianApply beijianApply){
		System.out.println(beijianApply.getApplyState());
		BeijianApply bApply=(BeijianApply) beijianApplyDAO.findById(BeijianApply.class, beijianApply.getApplyId());
		bApply.setApplyState(beijianApply.getApplyState());
		beijianApplyDAO.update(bApply);
		
	}
	/*
	 * �������뵥��״̬�ȣ��г�δ��ɵ����뵥
	 */
	
	@Override
    public List<BeijianApply> queryBeijianApply(BeijianApply beijianApply,int page,int pageSize){
		
		StringBuffer hql = new StringBuffer(" select m from BeijianApply  m where m.applyManId='");
		hql.append(beijianApply.getApplyManId());
		hql.append("'");
		hql.append(" and m.applyState='�����' or m.applyState='��ͨ��'");
		
		List<BeijianApply> list =(List<BeijianApply>) beijianApplyDAO.findPage(hql.toString(), page, pageSize);
		return list;
		
	}
	/*
	 * ��ѯά�޼�¼���г��ҵ�����
	 * 
	 */
	
	@Override
	public List<Repair> queryAllWeixiu(Repair re,int page,int pageSize){
		
		StringBuffer hql = new StringBuffer(" select m from Repair  m where m.empRepairmanId='");
		hql.append(re.getEmpRepairmanId());
		hql.append("'");
		hql.append(" and (m.repairState='��ά��' or m.repairState='ά����')");
	
		List<Repair> list = repairDAO.findPage(hql.toString(),page,pageSize);
		return list;
		
	}

	@Override
	public int countAllweixiu(Repair re) {
		
		StringBuffer hql = new StringBuffer(" select count(*) from Repair  m where m.empRepairmanId='");
		hql.append(re.getEmpRepairmanId());
		hql.append("'");
		hql.append(" and (m.repairState='��ά��' or m.repairState='ά����')");
	
		return repairDAO.countAllHql(hql.toString());
		
	}

	@Override
	public int countBeijianApply(BeijianApply beijianApply) {
		StringBuffer hql = new StringBuffer("select count(*) from BeijianApply m where m.applyManId='");
		hql.append(beijianApply.getApplyManId());
		hql.append("'");
		return beijianApplyDAO.countAllHql(hql.toString());
		
	}

	@Override
	public List seeReportRepair(ReportRepair reportRepair) {
		String reportRepairid=reportRepair.getReportRepairId();
		ReportRepair cus=(ReportRepair) reportRepairDAO.findById(ReportRepair.class, reportRepairid);
		String customid=cus.getCustomId();
		
		StringBuffer hql = new StringBuffer("select m.custom_name, m.custom_company, " +
				" m.custom_tel, m.custom_mabile, m.custom_addrass, m.custom_email, " +
				" m.custom_post, t.custom_sent_time, t.custom_properties, t.forecast_price," +
				" t.forecast_complete_time, t.product_type, t.machine_brand,t.machine_version," +
				" t.machine_bug_phenomenon,t.machine_start_password,t.machine_RAM , t.other" +
				
				" from custom as m, report_repair as t where t.report_repair_id='");
		hql.append(reportRepairid);
		hql.append("' and m.custom_id=t.custom_id");
	List list =reportRepairDAO.findSQLlist(hql.toString());
		
		return list;
	}
	public List tongjiWeixiushiGongzuo(int page,int pageSize){

		StringBuffer sql = new StringBuffer(" SELECT emp_id as empId,COUNT(*) as workNumber ," +
				" emp_mobile as empMobile ,emp_name as empName , emp_addrass as empAddrass , emp_email as empEmail , good_at as goodAt " +
				"from emp_info p ,repair  m " +
				"where  m.emp_repairman_id=p.emp_id and repair_state='ά����'  GROUP BY emp_id  " +
				" UNION " +
                 " SELECT emp_id ,0,emp_mobile ,emp_name, emp_addrass, emp_email, good_at" +
                 " from  emp_info where emp_id  not in ( " +
                                                     
                       "  SELECT emp_id  from emp_info p , repair  m where  m.emp_repairman_id=p.emp_id GROUP BY emp_id   ) and emp_dep='ά��Ա'");
	List list=	repairDAO.findSQLPagelist(sql.toString(),page, pageSize);
		
		return list;
		
	}
	public int countAllWeixiushi() {
		StringBuffer hql = new StringBuffer("select count(*) from EmpInfo where emp_dep='ά��Ա' ");
		

	
		return repairDAO.countAllHql(hql.toString());
	}

}
