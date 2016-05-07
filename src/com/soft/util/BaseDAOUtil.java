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
		 * ���ԣ���̬ƴ��SQL��ѯ��� ����ĳ��ʵ������е������Ƿ���ֵ��ƴ��һ����where��and(or)�Ĳ�ѯ��� User������
		 */
		String sql = "select * from " + tableName;

		try {
			Class className = Class.forName(classFullName.getCanonicalName());
			// ��ȡ�������Եĸ���className.getFields().lengt���ֱ�ִ����Щ���Ե�get����
			sql = sql + " where 1=1 ";
			for (int i = 0; i < className.getDeclaredFields().length; i++) {
				// ��ȡ������
				Field field = className.getDeclaredFields()[i];
				String name = field.getName();
				// ����get��������ĸ���Ǵ�д
				String methodName = "get" + name.substring(0, 1).toUpperCase()
						+ name.substring(1, name.length());
				Method declaredMethod = className.getDeclaredMethod(methodName,
						null);
				// �ڸ��ݷ�������ִ�з���ʱ����һ������Ϊ�����ʵ��������
				Object invoke = declaredMethod.invoke(object, null);
				// ����ֵ�����ԣ�ƴ��SQL��䣬���Ҽ�����������ȫ��ͬ�����ݿ��е�����
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
