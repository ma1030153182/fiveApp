package com.soft.dao;


import java.util.List;

import com.soft.model.Repair;
import com.soft.util.BaseDAO;

public interface RepairDAO extends BaseDAO<Repair>{
	public List  findSQLPagelist(final String sql,int page, int pageSize);
}