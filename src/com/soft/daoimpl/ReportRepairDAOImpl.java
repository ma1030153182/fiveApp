package com.soft.daoimpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.soft.dao.ReportRepairDAO;

import com.soft.model.ReportRepair;
import com.soft.util.BaseDAOImpl;

public class ReportRepairDAOImpl extends BaseDAOImpl<ReportRepair> implements ReportRepairDAO{

	/* (non-Javadoc)
	 * ¸ù¾ÝSQL²éÑ¯
	 */
	@Override
	public List findSQLlist(final String sql) {
		Session session=this.getSession();

		Query query = session.createSQLQuery(sql);

		List list=query.list();
		session.close();

		return list;
	}
}
