package com.soft.service;

import java.util.List;

import com.soft.entity.Weixiushi;
import com.soft.model.BeijianApply;
import com.soft.model.Repair;
import com.soft.model.ReportRepair;




public interface WeiXiuGuanLiService {

	/*
	 * ��ѯά�޼�¼���г��ҵ�����
	 * 
	 */
	 public List<Repair> queryAllWeixiu(Repair re,int page,int pageSize);


	/*
	 * ��ʼ�����޸�ά�޼�¼��ģ�״̬��ʱ���
	 * 
	 */
	public abstract void startWeixiu(Repair repair);

	/*
	 * ��дά�ޱ��棬�޸�ά�ޱ������Ϣ
	 */
	public abstract void fillWriteReport(Repair repair);

	/*
	 * ��ӱ������룬��д���뵥���������д���¼
	 */
	public abstract void addBeijianApply(BeijianApply beijianApply);

	/*
	 * �༭�������룬�޸����뵥
	 */
	public abstract void editBeiJianApply(BeijianApply beijianApply);

	/*
	 * �������룬�������룬�޸�״̬Ϊ����
	 */
	public abstract void DeleteBeiJianApply(BeijianApply beijianApply);

	/*
	 * ȷ�ϣ�����ɹ���һ��ȷ�ϣ���������ɣ�
	 */
	public abstract void sureBeijianApply(BeijianApply beijianApply);

	/*
	 * �������뵥��״̬�ȣ��г�δ��ɵ����뵥
	 */
	public List<BeijianApply> queryBeijianApply(BeijianApply beijianApply,int page,int pageSize);

    /*
     *��ҳ
     */
	public int countAllweixiu(Repair re);
	public int countBeijianApply(BeijianApply beijianApply);


	public List seeReportRepair(ReportRepair reportRepair);
	
	public List<Weixiushi> tongjiWeixiushiGongzuo(int page,int pageSize);
	public int countAllWeixiushi();
}