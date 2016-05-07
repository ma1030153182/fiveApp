package com.soft.daoimpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.soft.dao.BeijianApplyDAO;
import com.soft.entity.CheckApply;
import com.soft.model.BeijianApply;
import com.soft.util.BaseDAOImpl;

public class BeijianApplyDAOImpl extends BaseDAOImpl<BeijianApply> implements BeijianApplyDAO{

	public  List findSQLPageList(final String sql,int page, int pageSize) {
		Session session=this.getSession();

		Query query = session.createSQLQuery(sql);
		int firstResult = (page - 1) * pageSize;
		query.setFirstResult(firstResult);
		query.setMaxResults(pageSize);
		query.list();
		
		session.close();

		return null;
	}
}
