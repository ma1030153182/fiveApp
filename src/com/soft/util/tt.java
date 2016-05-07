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
//	        // 获取持久化对象的类型  
//        this.persistentClass = (Class<T>) ((ParameterizedType)(getClass().getGenericSuperclass()).getActualTypeArguments()[0];  
//	    }  
//	  
	    
	    public tt(Class<T> persistentClass){
	        this.persistentClass=persistentClass;
	    }
	    
	    public Class<T> getPersistentClass(){
	        return persistentClass;
	    }
	    //增加=================================================================
	    
	    /**
	     *增加数据
	     */
	    public boolean save(T entity)  
	    {  
	       if( (Boolean) this.getHibernateTemplate().save(entity))
	    	   return true;
		return false;
			
		  
	    }  
	    
	    /** 增加或修改数据
	     * saveOrUpdate 
	     */  
	    public void saveOrUpdate(T entity)  
	    {  
	        this.getHibernateTemplate().saveOrUpdate(entity);  
	    }  
	    
	    //删除=================================================================
	    

	    /** 
	     * 删除 
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
	     * 通过属性删除 
	     * 可以通过ID来删除
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
	    
	    
	    
	    
	    
	    //更改=================================================================
	    
	    
	    /** 
	     * 更新 
	     */  
	    public void update(T entity)  
	    {  
	        this.getHibernateTemplate().update(entity);  
	    }  
	  
	 /**
	  * 根据条件更新
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
	    
	    
	    
	    
	    //查询=================================================================
	    

//	    /** 
//	     * 通过id查找 
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
//	     * 无条件查询分页
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
//	     * 根据实例查询 
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
	     * 通过单条件查找 
	     *  
	     * @param propertyName 
	     *            属性名称 
	     * @param value 
	     *            属性的值 
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
	     * 通过多个条件组合查询 
	     *  
	     * @param propertyNames 
	     *            属性名称数组 
	     * @param values 
	     *            对应于propertyNames的值 return 匹配的结果 
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
	     * 通过单条件查找并分页 
	     *  
	     * @param propertyName 
	     *            属性名称 
	     * @param value 
	     *            属性值 
	     * @param page 
	     *            页数 
	     * @param pageSize 
	     *            每页显示条数 
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
	     * 通过多个条件组合查询 并分页
	     *  
	     * @param propertyNames 
	     *            属性名称数组 
	     * @param values 
	     *            对应于propertyNames的值 
	     * @param page 
	     *            页数 
	     * @param pageSize 
	     *            每页显示数 return 匹配的结果 return 匹配的结果 
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
	     * 无条件统计所有记录的总数 
	     *  
	     * @return 总数 
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
	     * 通过单个条件统计数量 
	     *  
	     * @param propertyName 
	     *            属性名称 
	     * @param value 
	     *            属性值 
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
	     * 通过多个条件统计数量 
	     *  
	     * @param propertyNames 
	     *            属性名称数组 
	     * @param values 
	     *            对应的属性值数组 return 
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
	     * 查找T并通过某一属性排序 
	     *  
	     * @param property 
	     *            排序依据的顺序 
	     * @param isSequence 
	     *            是否顺序排序,false为倒序 
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
	     * 查找所有并通过某个属性排序 
	     *  
	     * @param propertyName 
	     *            排序依据的属性名称 
	     * @param isSequence 
	     *            是否顺序排列 
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
	        //iterate方法与list方法的区别是list取出全部，iterator取出主键，迭代的时候才取出数据
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
