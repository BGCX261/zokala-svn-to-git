package com.neuallstar.core.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
/**
 * 基础DAO接口
 * @author 陈秀能
 * T为泛型
 * **/
public interface IBaseDao<T> {
	/**
	 * 保存对象
	 * @return 对象主键
	 * @param t 要保存的对象
	 * **/
	public Serializable save(T t);
    /**
     * 删除对象
     * @param t 要删除的对象
     * **/
	public void delete(T t);
	/**
	 * 更新对象
	 * @param t 要更新的对象
	 * **/
	public void update(T t); 
	/**
	 * 根据主键查找对象
	 * @return 对象 
	 * @param c 对象的类型
	 * @param id 对象的主键
	 * **/
	public T findById(Serializable id);
	/**
	 * 根据SQL语句来查找对象
	 * @return 对象列表
	 * @param hql HQL语句
	 * **/
	public List<T> listTBySQL(String hql);
	/**
	 * 创建Query对象供查询时使用
	 * @return Query
	 * @param hql HQL语句
	 * **/
	public Query createQuery(String hql); 
	/**
	 * 根据SQL语句查找对象并分页
	 * @return 对象列表
	 * @param hql HQL语句
	 * @param from 起始位置
	 * @param maxResults 结果集数量
	 * **/
	public List<T> listBySQLPaging(String hql,int from,int maxResults);
}
