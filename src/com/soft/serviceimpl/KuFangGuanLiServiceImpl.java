package com.soft.serviceimpl;


import java.util.List;



import com.soft.dao.BeijianApplyDAO;
import com.soft.dao.BeijianDAO;
import com.soft.entity.CheckApply;
import com.soft.entity.CompleteApply;
import com.soft.model.BeiJian;
import com.soft.model.BeijianApply;
import com.soft.model.Repair;



import com.soft.service.KuFangGuanLiService;

public class KuFangGuanLiServiceImpl implements KuFangGuanLiService{
	   
	private static final int I = 0;
	private BeijianDAO beijianDAO;  
	private BeijianApplyDAO beijianApplyDAO;
	
	public BeijianApplyDAO getBeijianApplyDAO() {
		return beijianApplyDAO;
	}

	public void setBeijianApplyDAO(BeijianApplyDAO beijianApplyDAO) {
		this.beijianApplyDAO = beijianApplyDAO;
	}

	public BeijianDAO getBeijianDAO() {
		return beijianDAO;
	}

	public void setBeijianDAO(BeijianDAO beijianDAO) {
		this.beijianDAO = beijianDAO;
	}

	/*
	 * ��ӱ���
	 */
	
	public boolean addBeijian(BeiJian beijian) {
		
		boolean flag=false;	
		flag=beijianDAO.save(beijian);
		return flag;
	
	}
	/*
	 * 
	 * ɾ��������Ϣ
	 */
	public void deleteBeijian(BeiJian beijian) {
		
		beijianDAO.delete(beijian);	
	}
	/*
	 * �޸ı�����Ϣ
	 */
	
    public void editBeijian(BeiJian beijian){
		
    	beijianDAO.update(beijian);
	}
    /*
     * ��ѯ���б�������ҳ
     */
    public List<BeiJian> queryBeijianAll(int page, int pageSize){
    	StringBuffer hql = new StringBuffer("select m from  BeiJian m");
    	
    	List<BeiJian> list = beijianDAO.findPage(hql.toString(),page,pageSize);
    	return list;
	}
    /*
     * ��������ѯ���в���ҳ
     */
    public List<BeiJian> queryBeijianBy(BeiJian beiJian,int page, int pageSize){
    	
    	StringBuffer hql ;
    	String name=beiJian.getBeijianName();
    	
    	hql= new StringBuffer("select m from BeiJian m where m.beijianName like '%");
    	hql.append(name);
    	hql.append("%'");
    	
     
    	
    	List<BeiJian> list =(List<BeiJian>) beijianDAO.findPage(hql.toString(),page,pageSize);
    	return list;
    	
	}
    /*
     * ��ѯ�������벢��ҳ
     */
    public List<BeijianApply> queryApplyAll(int page, int pageSize){
//       StringBuffer sql = new StringBuffer("select m.apply_id as applyId," +
//       		"m.beijian_name as beijianName ," +
//       		"m.beijian_number as beijianNumber , " +
//       		"t.beijian_price as beijianPrice ," +
//       		"m.apply_time as applyTime ," +
//       		"p.emp_name as applyManName ," +
//       		"m.beijian_id as beijianId ," +
//       		"m.beijian_version as beijianVersion , " +
//       		"t.beijian_number as kucun " +
//       		"from beijian_apply as m,emp as p,bei_jian as t " +
//       		"where m.beijian_id=t.beijian_id and m.apply_man_id=p.emp_id and m.apply_State='δ���'");
//    	 StringBuffer sql = new StringBuffer(" SELECT  p.apply_id as applyId, k.beijian_name as beijianName , p.beijian_number as applyNumber, k.beijian_price as beijianPrice, p.apply_time as applyTime,p.apply_man_name as applyManName, k.beijian_version as beijianVersion, k.beijian_id as beijianId, k.beijian_number as beijianNumber from beijian_apply p, bei_jian k WHERE p.apply_state='�����' AND p.beijian_id=k.beijian_id" );
    	  
      StringBuffer sql = new StringBuffer(" select m from BeijianApply as m where m.applyState='�����'" );
       List<BeijianApply> list = beijianApplyDAO.findPage( sql.toString(), page, pageSize);
    	return list;
    		
	}
    /*
     * ��������
     * �޸��豸�����
     * ������
     */
    public boolean passApply(BeijianApply beijianApply,BeiJian beijian){
    	
    	
    	String state=beijianApply.getApplyState();
    	if(state.equals("��ͨ��")){
    		BeiJian  beij=(BeiJian) beijianDAO.findById(BeiJian.class, beijian.getBeijianId());
    		String applynimber=beijian.getBeijianNumber();
    		String  beijianNumber=beij.getBeijianNumber();
    		int a=Integer.parseInt(applynimber);
    		int b=Integer.parseInt(beijianNumber);
    		if(b-a>0){
    			beij.setBeijianNumber(Integer.toString(b-a));
    			beijianDAO.update(beij);
    			BeijianApply  beiApply =(BeijianApply) beijianApplyDAO.findById(BeijianApply.class, beijianApply.getApplyId());
    	    	beiApply.setApplyPassManId(beijianApply.getApplyPassManId());
    	    	beiApply.setApplyPassManName(beijianApply.getApplyPassManName());
    	    	beiApply.setApplyPassTime(beijianApply.getApplyPassTime());
    	    	beiApply.setApplyState(beijianApply.getApplyState());
    	    	beijianApplyDAO.update(beiApply);
    			return true;
    		}else{
    			return false;
    		}
    		
    	}else{
    		BeijianApply  beiApply =(BeijianApply) beijianApplyDAO.findById(BeijianApply.class, beijianApply.getApplyId());
	    	beiApply.setApplyPassManId(beijianApply.getApplyPassManId());
	    	beiApply.setApplyPassManName(beijianApply.getApplyPassManName());
	    	beiApply.setApplyPassTime(beijianApply.getApplyPassTime());
	    	beiApply.setApplyState(beijianApply.getApplyState());
	    	beijianApplyDAO.update(beiApply);
	    	return true;
    	}
		
    	
	}

    /*
     *�������׼�����ǣ����Բ鿴��Ҫ����ı��������������ݱ���id�鱸����
     */
    public List<BeijianApply> queryApplyBy(BeijianApply beijianApply,int page, int pageSize){
       StringBuffer hql = new StringBuffer("      ");
    	
    	List<BeijianApply> list = beijianApplyDAO.findPage(hql.toString(),page,pageSize);
    	return list;
    }
    /*
     * �鿴�豸��ˮ���г���������������ӱ���������ѯ
     */
    public List<BeijianApply> queryApplyComplete(int page, int pageSize){
    	
       
//    		   "select beijian_name as beijianName," +
//       		" beijian_number as beijianNumber ," +
//       		" beijian_price as beijianPrice, " +
//       		" apply_pass_time as applyPassTime, " +
//       		" beijian_version as beijianVersion, " +
//       		" p.emp_name as applyManName " +
//       		
//       		" from beijian_apply as m ,emp as p " +
//       		" where m.apply_man_id=p.emp_id " +
//       		" and m.apply_state='���ջ�'");
    	StringBuffer sql = new StringBuffer(" select m from BeijianApply as m where m.applyState='���ջ�'" );
    	
    	List<BeijianApply> list = beijianApplyDAO.findPage(sql.toString(), page, pageSize);
    			
    	return list;
    }

	@Override
	public int countAllBeiJian() {
		StringBuffer hql = new StringBuffer("select count(*) from BeiJian");
		return beijianDAO.countAllHql(hql.toString());
	
	}
	public int countAllBeiJianBy(BeiJian beijian) {
		StringBuffer hql ;
    	String name=beijian.getBeijianName();
    	
    	hql= new StringBuffer("select count(*) from BeiJian m where m.beijianName like '%");
    	hql.append(name);
    	hql.append("%'");
    	
		
		return beijianDAO.countAllHql(hql.toString());
	
	}
	public int countAllApply() {
		StringBuffer sql = new StringBuffer("select count(*) from BeijianApply as m where m.applyState='�����' ");
		return beijianApplyDAO.countAllHql(sql.toString());
	
	}
	public int countAllApplyBy(BeijianApply beijianApply) {
		StringBuffer hql = new StringBuffer("select count(*) from Custom  ");
		return beijianApplyDAO.countAllHql(hql.toString());
	
	}

	public int countAllComplete(){
		
		StringBuffer sql = new StringBuffer("select count(*) from BeijianApply as m where m.applyState='���ջ�' ");
		return beijianApplyDAO.countAllHql(sql.toString());
	}


}
