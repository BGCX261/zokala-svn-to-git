/**
 *com.zokala.framework.ioc.util
 * Context.java
 */
package com.zokala.framework.ioc.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

import com.zokala.framework.ioc.bean.Bean;
import com.zokala.framework.ioc.bean.Prop;
import com.zokala.framework.ioc.reader.ResourceReader;
import com.zokala.framework.ioc.reader.XMLResourceReader;

/**
 * get all instances of config
 * @author ³ÂÐãÄÜ
 * 2011-8-5 ÏÂÎç08:04:50 
 */
public class Context {
	private static Map<String,Bean> beans;
	private ResourceReader reader=new XMLResourceReader();

	public Context() {
		super();
		beans=reader.read(null);
	}
	public Context(String path){
		super();
		if(path!=null) beans=reader.read(path); 
	}
	/**
	 * get instance by bean id
	 * @param beanid id of bean in config.xml
	 * @return Object instance of specified bean id
	 * @exception InstantiationException
	 * @exception IllegalAccessException
	 * @exception ClassNotFoundException
	 * @exception SecurityException
	 * @exception NoSuchMethodException
	 * @exception IllegalArgumentException
	 * @exception InvocationTargetException
	 * **/
	@SuppressWarnings("unchecked")
	public Object get(String beanid){ 
		try {
			Bean bean= beans.get(beanid);
			Class cls=Class.forName(bean.getCls());
			List<Prop> properties=bean.getProps(); 
			Object obj=cls.newInstance(); 
			for(Prop prop:properties){ 
				Object ref=get(prop.getRef()); 
				Class[] clazz= ref.getClass().getInterfaces();
        		if(clazz==null||clazz.length==0){
        			clazz=new Class[1];
        			clazz[0]=ref.getClass(); 
        		} 
				Method method=cls.getMethod(getSetter(prop.getName()),clazz);
				method.invoke(obj,ref);
			}
			return obj;
		} catch (InstantiationException e) { 
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return null;

	}
	private String getSetter(String s){
		if(s.length()>1)return "set"+s.substring(0, 1).toUpperCase()+s.substring(1);
		else if(s.length()==1)return "set"+s.substring(0, 1).toUpperCase();
		return null;
	}
}
