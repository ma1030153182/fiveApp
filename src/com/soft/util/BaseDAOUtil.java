package com.soft.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class BaseDAOUtil {
	public String buildQueryHQL(Class<?> entityClass,String[] propertyNames){
		StringBuffer strBuffer = new StringBuffer();
		strBuffer.append("from " + entityClass.getName());
		strBuffer.append(" as model where ");
		for (int i = 0; i < propertyNames.length; i++) {
			if (i != 0)
				strBuffer.append(" and");
			strBuffer.append(" model.");
			strBuffer.append(propertyNames[i]);
			strBuffer.append("=");
			strBuffer.append("? ");
		}
		String queryString = strBuffer.toString();
        return queryString;
	}
	
	public String buildQueryHQLLike(Class<?> entityClass,String[] propertyNames){
		StringBuffer strBuffer = new StringBuffer();
		strBuffer.append("from " + entityClass.getName());
		strBuffer.append(" as model where ");
		for (int i = 0; i < propertyNames.length; i++) {
			if (i != 0)
				strBuffer.append(" and");
			strBuffer.append(" model.");
			strBuffer.append(propertyNames[i]);
			strBuffer.append(" like ");
			strBuffer.append("%?% ");
		}
		String queryString = strBuffer.toString();
        return queryString;
	}
	public String buildCountHQL(Class<?> entityClass,String[] propertyNames){
		StringBuffer strBuffer = new StringBuffer();
		strBuffer.append("select count(*) from " + entityClass.getName());
		strBuffer.append(" as model where ");
		for (int i = 0; i < propertyNames.length; i++) {
			if (i != 0)
				strBuffer.append(" and");
			strBuffer.append(" model.");
			strBuffer.append(propertyNames[i]);
			strBuffer.append("=");
			strBuffer.append("? ");
		}
		String queryString = strBuffer.toString();
        return queryString;
	}
	public String buildCountHQLLike(Class<?> entityClass,String[] propertyNames){
		StringBuffer strBuffer = new StringBuffer();
		strBuffer.append("select count(*) from " + entityClass.getName());
		strBuffer.append(" as model where ");
		for (int i = 0; i < propertyNames.length; i++) {
			if (i != 0)
				strBuffer.append(" and");
			strBuffer.append(" model.");
			strBuffer.append(propertyNames[i]);
			strBuffer.append(" like ");
			strBuffer.append("%?% ");
		}
		String queryString = strBuffer.toString();
        return queryString;
	}
    
	public String bulidSqlWithCondition(String tableName, Class classFullName,
			Object object, String mark) {

		/**
		 * 测试，动态拼接SQL查询语句 根据某个实体对象中的属性是否有值，拼接一条带where与and(or)的查询语句 User做例子
		 */
		String sql = "select * from " + tableName;

		try {
			Class className = Class.forName(classFullName.getCanonicalName());
			// 获取类下属性的个数className.getFields().lengt，分别执行这些属性的get方法
			sql = sql + " where 1=1 ";
			for (int i = 0; i < className.getDeclaredFields().length; i++) {
				// 获取属性名
				Field field = className.getDeclaredFields()[i];
				String name = field.getName();
				// 所有get方法首字母都是大写
				String methodName = "get" + name.substring(0, 1).toUpperCase()
						+ name.substring(1, name.length());
				Method declaredMethod = className.getDeclaredMethod(methodName,
						null);
				// 在根据方法对象，执行方法时，第一个参数为该类的实例化对象
				Object invoke = declaredMethod.invoke(object, null);
				// 将有值的属性，拼成SQL语句，并且假设属性名完全等同与数据库中的列名
				if (invoke != null && !"".equals(invoke)) {
					if (mark.equals("equals"))
						sql = sql + " and " + name + " = '" + invoke + "'";
					if (mark.equals("like")) {
						sql = sql + " and " + name + " like '%" + invoke + "%'";
					}
				}
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sql;
	}

}
