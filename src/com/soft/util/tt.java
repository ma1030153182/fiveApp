package com.soft.util;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class tt <T> extends HibernateDaoSupport  {
	
	 private Class<T> persistentClass;  
	 
	  
//	    @SuppressWarnings("unchecked")  
//	    public BaseDAOImpl()  
//	    {  
//	        // ��ȡ�־û����������  
//        this.persistentClass = (Class<T>) ((ParameterizedType)(getClass().getGenericSuperclass()).getActualTypeArguments()[0];  
//	    }  
//	  
	    
	    public tt(Class<T> persistentClass){
	        this.persistentClass=persistentClass;
	    }
	    
	    public Class<T> getPersistentClass(){
	        return persistentClass;
	    }
	    //����=================================================================
	    
	    /**
	     *��������
	     */
	    public boolean save(T entity)  
	    {  
	       if( (Boolean) this.getHibernateTemplate().save(entity))
	    	   return true;
		return false;
			
		  
	    }  
	    
	    /** ���ӻ��޸�����
	     * saveOrUpdate 
	     */  
	    public void saveOrUpdate(T entity)  
	    {  
	        this.getHibernateTemplate().saveOrUpdate(entity);  
	    }  
	    
	    //ɾ��=================================================================
	    

	    /** 
	     * ɾ�� 
	     */  
	    public void delete(T entity)  
	    {  
	        this.getHibernateTemplate().delete(entity);
			 
	    }  
	    
	    public boolean deleteByProperty(String hql)  
	    {  
	   
	        Query query = this.getSession().createQuery(hql);  
	         
	        if(query.executeUpdate()>0)
	        	return true;
			return false;
	     
	    }  
	    
	    
	  
	    /** 
	     * ͨ������ɾ�� 
	     * ����ͨ��ID��ɾ��
	     * @return 
	     */  
	    public boolean deleteByProperty(String tablename ,String propertyName, Object value)  
	    {  
	        String queryString = "delete from " + tablename
	                + " as model where model." + propertyName + "= ?";  
	        Query query = this.getSession().createQuery(queryString);  
	        query.setParameter(0, value); 
	        if(query.executeUpdate()>0)
	        	return true;
			return false;
	     
	    }  
	    
	    
	    
	    
	    
	    //����=================================================================
	    
	    
	    /** 
	     * ���� 
	     */  
	    public void update(T entity)  
	    {  
	        this.getHibernateTemplate().update(entity);  
	    }  
	  
	 /**
	  * ������������
	  */
	    
	    public boolean updateByProperty(final String hql, final Object...values) {
	       this.getHibernateTemplate().execute(new HibernateCallback(){
	            public Object doInHibernate(Session session)
	            throws HibernateException, SQLException{
	                Query query=session.createQuery(hql);
	                for(int i=0;i<values.length;i++){
	                    query.setParameter( i, values[i]);
	                }
	               if(query.executeUpdate()>0)
	                return true;
				return query;    
	            }
	        });
			return false;
	    }
	    
	    
	    
	    
	    //��ѯ=================================================================
	    

//	    /** 
//	     * ͨ��id���� 
//	     *  
//	     * @param id 
//	     * @return 
//	     */  
//	    @SuppressWarnings("unchecked")  
//	    public T findById(PK id)  
//	    {  
//	        return (T) this.getHibernateTemplate().get(getPersistentClass(), id);  
//	    }  
//	  
//	    /**
//	     * ��������ѯ��ҳ
//	     * @param page
//	     * @param pageSize
//	     * @return
//	     */
//	   
//	    public List<T> findAll(int page, int pageSize)  
//	    {  
//	        String queryString = "from " + getPersistentClass().getName();  
//	        Query query = this.getSession().createQuery(queryString);  
//	        int firstResult = (page - 1) * pageSize;  
//	        query.setFirstResult(firstResult);  
//	        query.setMaxResults(pageSize);  
//	        return query.list();  
//	    }  
	  
	  
//	  
//	    /** 
//	     * ����ʵ����ѯ 
//	     *  
//	     * @param entity 
//	     * @return 
//	     */  
//	    @SuppressWarnings("unchecked")  
//	    public List<T> findByExample(T entity)  
//	    {  
//	        return this.getHibernateTemplate().findByExample(entity);  
//	    }  
	  
	  
	  
	    /** 
	     * ͨ������������ 
	     *  
	     * @param propertyName 
	     *            �������� 
	     * @param value 
	     *            ���Ե�ֵ 
	     * @return 
	     */  
	    @SuppressWarnings("unchecked")  
	    public List<T> findByProperty( String tablename ,String propertyName, Object value)  
	    {  
	        String queryString = "from " + getPersistentClass().getName()  
	                + " as model where model." + propertyName + "= ?";  
	        return this.getHibernateTemplate().find(queryString, value);  
	  
	    }  
	  
	    /** 
	     * ͨ�����������ϲ�ѯ 
	     *  
	     * @param propertyNames 
	     *            ������������ 
	     * @param values 
	     *            ��Ӧ��propertyNames��ֵ return ƥ��Ľ�� 
	     */  
	    public List<T> findByPropertys( String tablename, String[] propertyNames, Object[] values)  
	    {  
	        StringBuffer strBuffer = new StringBuffer();  
	        strBuffer.append("from " + getPersistentClass().getName());  
	        strBuffer.append(" as model where ");  
	        for (int i = 0; i < propertyNames.length; i++)  
	        {  
	            if (i != 0)  
	                strBuffer.append(" and");  
	            strBuffer.append(" model.");  
	            strBuffer.append(propertyNames[i]);  
	            strBuffer.append("=");  
	            strBuffer.append("? ");  
	        }  
	        String queryString = strBuffer.toString();  
	        return this.getHibernateTemplate().find(queryString, values);  
	    }  
	  
	    /** 
	     * ͨ�����������Ҳ���ҳ 
	     *  
	     * @param propertyName 
	     *            �������� 
	     * @param value 
	     *            ����ֵ 
	     * @param page 
	     *            ҳ�� 
	     * @param pageSize 
	     *            ÿҳ��ʾ���� 
	     */  
	    public List<T> findByProperty( String propertyName, Object value, int page,   int pageSize)  
	    {  
	        return this.findByPropertys(new String[]  
	        {  
	            propertyName  
	        }, new Object[]  
	        {  
	            value  
	        }, page, pageSize);  
	    }  
	  
	    /** 
	     * ͨ�����������ϲ�ѯ ����ҳ
	     *  
	     * @param propertyNames 
	     *            ������������ 
	     * @param values 
	     *            ��Ӧ��propertyNames��ֵ 
	     * @param page 
	     *            ҳ�� 
	     * @param pageSize 
	     *            ÿҳ��ʾ�� return ƥ��Ľ�� return ƥ��Ľ�� 
	     */  
	    public List<T> findByPropertys(String[] propertyNames, Object[] values,  
	            int page, int pageSize)  
	    {  
	  
	        StringBuffer strBuffer = new StringBuffer();  
	        strBuffer.append("from " + getPersistentClass().getName());  
	        strBuffer.append(" as model where ");  
	        for (int i = 0; i < propertyNames.length; i++)  
	        {  
	            if (i != 0)  
	                strBuffer.append(" and");  
	            strBuffer.append(" model.");  
	            strBuffer.append(propertyNames[i]);  
	            strBuffer.append("=");  
	            strBuffer.append("? ");  
	        }  
	        String queryString = strBuffer.toString();  
	  
	        int firstResult = (page - 1) * pageSize;  
	  
	        Query query = this.getSession().createQuery(queryString);  
	        query.setFirstResult(firstResult);  
	        query.setMaxResults(pageSize);  
	        for (int i = 0; i < values.length; i++)  
	        {  
	            query.setParameter(i, values[i]);  
	        }  
	  
	        return query.list();  
	    }  
	    
	    /** 
	     * ������ͳ�����м�¼������ 
	     *  
	     * @return ���� 
	     */  
	    public int countAll()  
	    {  
	        String queryString = "select count(*) from "  
	                + getPersistentClass().getName();  
	        Query query = this.getSession().createQuery(queryString);  
	        List list = query.list();  
	        Long result = (Long) list.get(0);  
	        return result.intValue();  
	    }  
	  
	    /** 
	     * ͨ����������ͳ������ 
	     *  
	     * @param propertyName 
	     *            �������� 
	     * @param value 
	     *            ����ֵ 
	     */  
	    public int countByProperty(String propertyName, Object value)  
	    {  
	        String[] propertyNames = new String[]  
	        {  
	            propertyName  
	        };  
	        Object[] values = new Object[]  
	        {  
	            value  
	        };  
	        return this.countByPropertys(propertyNames, values);  
	    }  
	  
	    /** 
	     * ͨ���������ͳ������ 
	     *  
	     * @param propertyNames 
	     *            ������������ 
	     * @param values 
	     *            ��Ӧ������ֵ���� return 
	     */  
	    public int countByPropertys(String[] propertyNames, Object[] values)  
	    {  
	        StringBuffer strBuffer = new StringBuffer();  
	        strBuffer.append("select count(*) from "  
	                + getPersistentClass().getName());  
	        strBuffer.append(" as model where ");  
	        for (int i = 0; i < propertyNames.length; i++)  
	        {  
	            if (i != 0)  
	                strBuffer.append(" and");  
	            strBuffer.append(" model.");  
	            strBuffer.append(propertyNames[i]);  
	            strBuffer.append("=");  
	            strBuffer.append("? ");  
	        }  
	  
	        String queryString = strBuffer.toString();  
	        Query query = this.getSession().createQuery(queryString);  
	        for (int i = 0; i < values.length; i++)  
	        {  
	            query.setParameter(i, values[i]);  
	        }  
	  
	        List list = query.list();  
	        Long result = (Long) list.get(0);  
	        return result.intValue();  
	    }  
	  
	    /** 
	     * ����T��ͨ��ĳһ�������� 
	     *  
	     * @param property 
	     *            �������ݵ�˳�� 
	     * @param isSequence 
	     *            �Ƿ�˳������,falseΪ���� 
	     */  
	    public List<T> findAndOrderByProperty(int firstResult, int fetchSize,  
	            String propertyName, boolean isSequence)  
	    {  
	        String queryString = "from " + getPersistentClass().getName()  
	                + " as model order by model." + propertyName;  
	        if (isSequence == false)  
	        {  
	            queryString = queryString + " DESC";  
	        }  
	  
	        Query queryObject = getSession().createQuery(queryString);  
	        queryObject.setFirstResult(firstResult);  
	        queryObject.setMaxResults(fetchSize);  
	        return queryObject.list();  
	  
	    }  
	  
	    /** 
	     * �������в�ͨ��ĳ���������� 
	     *  
	     * @param propertyName 
	     *            �������ݵ��������� 
	     * @param isSequence 
	     *            �Ƿ�˳������ 
	     */  
	    public List<T> findAllAndOrderByProperty(String propertyName,  
	            boolean isSequence)  
	    {  
	        String queryString = "from " + getPersistentClass().getName()  
	                + " as model order by model." + propertyName;  
	        if (isSequence == false)  
	        {  
	            queryString = queryString + " DESC";  
	        }  
	  
	        Query queryObject = getSession().createQuery(queryString);  
	        return queryObject.list();  
	    }  
	    
	 
	    
	    
	    
	    @SuppressWarnings("unchecked")
	    public T findById(int id) {
	        return (T)getHibernateTemplate().get(getPersistentClass(), id);
	    }

	    @SuppressWarnings("unchecked")
	    public List<T> findByPage(final String hql, 
	         final int offset, final int pageSize){
	        List<T> list= getHibernateTemplate().executeFind(new HibernateCallback(){
	                public Object doInHibernate(final Session session)
	                    throws HibernateException, SQLException{
	                    Query query=session.createQuery(hql);
	                    if(!(offset==0 && pageSize==0)){
	                        query.setFirstResult(offset).setMaxResults(pageSize);
	                    }
	                    List<T> result = query.list();
	                    return result;
	                }
	            });
	        return list;
	    }
	    
	    @SuppressWarnings("unchecked")
	    public List findByPageSQL(final String sql, 
	         final int offset, final int pageSize){
	        List list= getHibernateTemplate().executeFind(new HibernateCallback(){
	                public Object doInHibernate(final Session session)
	                    throws HibernateException, SQLException{
	                    Query query=session.createSQLQuery(sql);
	                    if(!(offset==0 && pageSize==0)){
	                        query.setFirstResult(offset).setMaxResults(pageSize);
	                    }
	                    List result = query.list();
	                    return result;
	                }
	            });
	        return list;
	    }
	    

	    @SuppressWarnings("unchecked")
	    public List<T> findByPage(final String hql, final Object value, 
	            final int offset, final int pageSize) {
	        List<T> list = getHibernateTemplate().executeFind(new HibernateCallback()
	        {
	            public Object doInHibernate(Session session)
	                throws HibernateException, SQLException
	            {
	                Query query=session.createQuery(hql).setParameter(0, value);
	                if(!(offset==0 && pageSize==0)){
	                    query.setFirstResult(offset).setMaxResults(pageSize);
	                }
	                List<T> result = query.list();
	                return result;
	            }
	        });
	        return list;
	    }

	    @SuppressWarnings("unchecked")
	    public List<T> findByPage(final String hql, final Object[] values, final int offset,
	            final int pageSize) {
	        List<T> list = getHibernateTemplate().executeFind(new HibernateCallback(){
	            public Object doInHibernate(Session session)
	                throws HibernateException, SQLException{
	                Query query=session.createQuery(hql);
	                for (int i = 0 ; i < values.length ; i++){
	                    query.setParameter( i, values[i]);
	                }
	                if(!(offset==0 && pageSize==0)){
	                    query.setFirstResult(offset).setMaxResults(pageSize);
	                }
	                List<T> result = query.list();
	                return result;
	            }
	        });
	    return list;
	    }
	    

	   

	    public Integer getCount(String hql) {
	        Integer count;
	        //iterate������list������������listȡ��ȫ����iteratorȡ��������������ʱ���ȡ������
	        count = ((Long)getHibernateTemplate().iterate(hql).next()).intValue();
	        return count;
	    }

	    public T makePersitent(T entity) {
	        getHibernateTemplate().saveOrUpdate(entity);
	        return entity;
	    }

	    public void makeTransient(T entity) {
	        getHibernateTemplate().delete(entity);
	    }

	    public void makeTransientByIds(final String sql) {
	        getHibernateTemplate().execute(new HibernateCallback(){
	            public Object doInHibernate(Session session)
	            throws HibernateException, SQLException{
	                Query query=session.createQuery(sql);
	                query.executeUpdate();
	                return null;
	            }
	        });
	    }

	
		

}
