package com.soft.util;

import java.util.List;

public interface BaseDAO<T> {

	public abstract boolean save(T entity);

	public abstract void saveOrUpdate(T entity);

	// É¾³ý=================================================================

	public abstract void delete(T entity);

	public abstract void update(T entity);

	public abstract Object findById(Class<?> entity, java.lang.String id);

	public abstract List<T> findAll(Class<?> classEntity);

	public abstract List<T> findByProperty(Class<?> classEntity,
			String propertyName, Object value);
	
	public abstract List<T> findPage(String hql, int page, int pageSize);

	public abstract List<T> find(String hql);

	public abstract List<T> findSQL(final String sql);

	public abstract List<T> findSQLPage(final String sql, int page, int pageSize);


	public abstract int countAll(Class<?> classEntity);

	public abstract int countAllSql(String queryString);

	public abstract int countAllHql(String queryString);

	public abstract	List<T> findByPropertyLikePage(Class<?> classEntity,
			String[] propertyNames, Object[] values, int page, int pageSize);

	public abstract List<T> findByPropertysPage(Class<?> classEntity, String[] propertyNames,
			Object[] values, int page, int pageSize);

	public abstract int countByPropertys(Class<?> classEntity, String[] propertyNames,
			Object[] values);

	public abstract int countByPropertysLike(Class<?> classEntity, String[] propertyNames,
			Object[] values);

}