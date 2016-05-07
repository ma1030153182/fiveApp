package com.soft.dao;


import java.util.List;

import com.soft.entity.CheckApply;
import com.soft.model.BeijianApply;
import com.soft.util.BaseDAO;

public interface BeijianApplyDAO extends BaseDAO<BeijianApply>{

	public  List findSQLPageList(final String sql,int page, int pageSize);
}
