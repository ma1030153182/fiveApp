package com.soft.daoimpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.soft.dao.RepairDAO;

import com.soft.model.Repair;
import com.soft.util.BaseDAOImpl;

public class RepairDAOImpl  extends BaseDAOImpl<Repair> implements RepairDAO{

	public List  findSQLPagelist(final String sql,int page, int pageSize) {
		Session session=this.getSession();

		Query query = session.createSQLQuery(sql);
		int firstResult = (page - 1) * pageSize;
		query.setFirstResult(firstResult);
		query.setMaxResults(pageSize);
		List list=query.list();
		session.close();

		return list;
	}
	
}
