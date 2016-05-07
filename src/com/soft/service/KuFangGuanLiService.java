package com.soft.service;



import java.util.List;

import com.soft.entity.CompleteApply;
import com.soft.model.BeiJian;
import com.soft.model.BeijianApply;
import com.soft.model.Repair;

public interface KuFangGuanLiService {
	
	/*
	 * ��ӱ������������
	 */
	
	public boolean addBeijian(BeiJian beijian) ;
	/*
	 * 
	 * ɾ��������Ϣ
	 */
	public void deleteBeijian(BeiJian beijian) ;
	/*
	 * �޸ı�����Ϣ
	 */
	
    public void editBeijian(BeiJian beijian) ;
    /*
     * ��ѯ���в���ҳ���г�
     */
    public List<BeiJian> queryBeijianAll(int page, int pageSize);
    /*
     * ��������ѯ���в���ҳ
     */
    public List<BeiJian> queryBeijianBy(BeiJian BeiJian,int page, int pageSize);
    /*
     * ��ѯ�������벢��ҳ
     */
    public  List<BeijianApply> queryApplyAll(int page, int pageSize);
    /*
     * ��������
     * �޸��豸�����
     * ������
     */
    public boolean passApply(BeijianApply beijianApply,BeiJian beijian);
    
    /*
     *�������׼�����ǣ����Բ鿴��Ҫ����ı��������������ݱ���id�鱸����
     */
    public List<BeijianApply> queryApplyBy(BeijianApply BeijianApply ,int page, int pageSize);
    	
   
    /*
     * �鿴�豸��ˮ���г���������������ӱ���������ѯ
     */
    public List<BeijianApply> queryApplyComplete(int page, int pageSize);
    
    
    public int countAllBeiJian();
    public int countAllBeiJianBy(BeiJian beijian);
    public int countAllApply();
    public int countAllApplyBy(BeijianApply BeijianApply);
 
    public int countAllComplete();

}
