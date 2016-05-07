package com.soft.util;



import java.util.List;


import org.hibernate.Query;
import org.hibernate.Session;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;


public class BaseDAOImpl<T> extends HibernateDaoSupport implements BaseDAO<T>   {
	
	private static final Logger log = LoggerFactory.getLogger(BaseDAOImpl.class);
	private SessionFactory  sessionFactory;
	private BaseDAOUtil baseDAOUtil =new BaseDAOUtil();
	
	protected void initDao() {
		// do nothing
	}
	// ����=================================================================

	
	/* (non-Javadoc)
	 * ���ʵ�屣��
	 */
	@Override
	public boolean save(T entity) {
		
		try {
			this.getHibernateTemplate().save(entity);
			return true;
		} catch (DataAccessException e) {
		    return false;
		}
			
			
		
	}


	/* (non-Javadoc)
	 * @��������
	 */
	@Override
	public void saveOrUpdate(T entity) {
		
		try {
			getHibernateTemplate().saveOrUpdate(entity);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
	// ɾ��=================================================================

	
	/* (non-Javadoc)
	 * ɾ��
	 */
	@Override
	public void delete(T entity) {
		
		try {
			getHibernateTemplate().delete(entity);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}


	// ���=================================================================

	
	

	/* (non-Javadoc)
	 * ����
	 */
	@Override
	public void update(T entity) {
		this.getHibernateTemplate().update(entity);
	}



	// ��ƴ�Ӳ�ѯ=================================================================

	
	
	/* (non-Javadoc)
	 * ���id��ѯ
	 */
	@Override
	public Object findById(Class<?> entity ,java.lang.String id) {
//		log.debug("getting "+entity.getName()+" instance with id: " + id);
		try {
			Object instance = getHibernateTemplate().get(entity, id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

		
	/* (non-Javadoc)
	 * ������ѯ����
	 */
	@Override
	public List<T> findAll(Class<?> classEntity) {
		log.debug("finding all "+classEntity.getName()+" instances");
		try {
			String queryString = "from "+classEntity.getName();
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}


	
	/* (non-Javadoc)
	 * ��ݲ����ѯ
	 */
	@Override
	public List<T> findByProperty(Class<?>classEntity, String propertyName, Object value) {
		log.debug("finding "+classEntity.getName()+" instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from "+classEntity.getName()+" as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}
	/* (non-Javadoc)
	 * ��ݷ����������like��ѯ
	 */
	@Override
	public List<T>findByPropertyLikePage(Class<?> classEntity,
			String[] propertyNames, Object[] values, int page, int pageSize){
String queryString=baseDAOUtil.buildQueryHQLLike(classEntity, propertyNames);
		

		int firstResult = (page - 1) * pageSize;
        Session session=this.getSession();
		Query query = session.createQuery(queryString);
		query.setFirstResult(firstResult);
		query.setMaxResults(pageSize);
		for (int i = 0; i < values.length; i++) {
			query.setParameter(i, values[i]);
		}
		List<T> list=query.list();
		session.close();

		return list;
	}
	/* (non-Javadoc)
	 * ��ݷ����������ѯ
	 */
	@Override
	public List<T> findByPropertysPage(Class<?> classEntity,
			String[] propertyNames, Object[] values, int page, int pageSize) {
		String queryString=baseDAOUtil.buildQueryHQL(classEntity, propertyNames);
		
		Session session=this.getSession();
		int firstResult = (page - 1) * pageSize;

		Query query = session.createQuery(queryString);
		query.setFirstResult(firstResult);
		query.setMaxResults(pageSize);
		for (int i = 0; i < values.length; i++) {
			query.setParameter(i, values[i]);
		}

		List<T> list=query.list();
		session.close();

		return list;
	}
	
	// �⴫HQL/SQL��ѯ=================================================================


	
	/* (non-Javadoc)
	 * @see ���hql��ѯ����ҳ
	 */
	
	@SuppressWarnings("unchecked")
	public List<T> findPage(final String hql,final int page,final int pageSize)
	{int firstResult = (page - 1) * pageSize;
	Session session=this.getSession();
				   Query query = session.createQuery(hql).setFirstResult(firstResult).setMaxResults(pageSize);
				 
				   List<T> list=query.list();
					session.close();

					
					if(list.size()>0)
					{
						
						return list;
					}
					else{
						return null;
					}
		
	}

	@Override
	public List<T> find(String hql) {
		Session session=this.getSession();

		Query query = session.createQuery(hql);

		List<T> list=query.list();
		session.close();

		return list;
	}
	

	
	/* (non-Javadoc)
	 * ���SQL��ѯ
	 */
	@Override
	public List<T> findSQL(final String sql) {
		Session session=this.getSession();

		Query query = session.createSQLQuery(sql);

		List<T> list=query.list();
		session.close();

		return list;
	}
	
	

	
	/* (non-Javadoc)
	 * ���sql��ѯ����ҳ
	 */
	@Override
	public List<T> findSQLPage(final String sql,int page, int pageSize) {
		Session session=this.getSession();

		Query query = session.createSQLQuery(sql);
		int firstResult = (page - 1) * pageSize;
		query.setFirstResult(firstResult);
		query.setMaxResults(pageSize);
		List<T> list=query.list();
		session.close();

		return list;
	}
	
	


	/* (non-Javadoc)
	 * ���뷴�����ѯ����
	 */
	@Override
	public int countAll(Class<?> classEntity) {
		String queryString = "select count(*) from " + classEntity.getName();
		Session session=this.getSession();
		Query query = session.createQuery(queryString);
		List list = query.list();
		Long result = (Long) list.get(0);
		session.close();
		return result.intValue();
		
	}

	/* (non-Javadoc)
	 * �⴫sql��ѯ����
	 */
	@Override
	public int countAllSql(String queryString) {
		Session session=this.getSession();
		
		Query query = session.createSQLQuery(queryString);
		List list = query.list();
		Long result = (Long) list.get(0);
		session.close();
		return result.intValue();
		
	}
	/* (non-Javadoc)
	 * �⴫hql��ѯ����
	 */
	@Override
	public int countAllHql(String queryString) {
		Session session=this.getSession();
		
		Query query = session.createQuery(queryString);
		List list = query.list();
		Long result = (Long) list.get(0);
		session.close();
		return result.intValue();
	}
	/* (non-Javadoc)
	 * @see com.soft.daoutil.BaseDAO1#countByPropertys(java.lang.Class, java.lang.String[], java.lang.Object[])
	 */
	@Override
	public int countByPropertys(Class<?> classEntity, String[] propertyNames,
			Object[] values) {
		String queryString=baseDAOUtil.buildQueryHQL(classEntity, propertyNames);
		Session session=this.getSession();
		
		Query query = session.createQuery(queryString);
		for (int i = 0; i < values.length; i++) {
			query.setParameter(i, values[i]);
		}

		List list = query.list();
		Long result = (Long) list.get(0);
		session.close();
		return result.intValue();
	}
    
	/* (non-Javadoc)
	 * @see com.soft.daoutil.BaseDAO1#countByPropertysLike(java.lang.Class, java.lang.String[], java.lang.Object[])
	 */
	@Override
	public int countByPropertysLike(Class<?> classEntity, String[] propertyNames,
		Object[] values) {
		String queryString=baseDAOUtil.buildQueryHQLLike(classEntity, propertyNames);
		Session session=this.getSession();
		
		Query query = session.createQuery(queryString);
		for (int i = 0; i < values.length; i++) {
			query.setParameter(i, values[i]);
		}

		List list = query.list();
		Long result = (Long) list.get(0);
		session.close();
		return result.intValue();
	}
}
