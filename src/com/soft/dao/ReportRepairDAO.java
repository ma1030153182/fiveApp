package com.soft.dao;

import java.util.List;

import com.soft.model.ReportRepair;
import com.soft.util.BaseDAO;

public interface ReportRepairDAO extends BaseDAO<ReportRepair>{

	public List findSQLlist(final String sql);
}