package com.neuallstar.core.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.logging.Log;
import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class BaseDaoImpl<T> extends HibernateDaoSupport implements com.neuallstar.core.dao.IBaseDao<T> {
	private Log log;
	private Class<T> cls;
	public BaseDaoImpl(Log log,Class<T> cls){
		this.log=log;
		this.cls=cls;
	}
	public void delete(T t) {
		log.debug("deleting "+cls.getName()+" instance");
		// TODO Auto-generated method stub
		//this.getHibernateTemplate().delete(t);
		try{
			getSession().delete(t);
		}catch(RuntimeException re){
			log.error("delete failed", re);
			throw re;
		}
	}

	public T findById(Serializable id) {
		// TODO Auto-generated method stub
		//return (T) this.getHibernateTemplate().get(c, id);
		log.debug("finding "+cls.getName()+" instance by id="+id);
		// TODO Auto-generated method stubb
		try{
			return	(T) getSession().get(cls, id);
		}catch(RuntimeException re){
			log.error("find by id failed", re);
			throw re;
		} 
	}

	public Serializable save(T t) {
		// TODO Auto-generated method stub
		//return	this.getHibernateTemplate().save(t);
		log.debug("saving "+cls.getName()+" instance");
		// TODO Auto-generated method stubb
		try{
			return	getSession().save(t);
		}catch(RuntimeException re){
			log.error("save failed", re);
			throw re;
		} 
	}

	public void update(T t) {
		// TODO Auto-generated method stub
		log.debug("updating "+cls.getName()+" instance");
		//this.getHibernateTemplate().update(t);	
		try{
			getSession().saveOrUpdate(t);
		}catch(RuntimeException re){
			log.error("update failed", re);
			throw re;
		} 
	}

	public Query createQuery(String hql) {
		// TODO Auto-generated method stub
		return this.getSession().createQuery(hql);
	}
	@SuppressWarnings("unchecked")
	public List<T> listTBySQL(String sql){
		return this.getSession().createQuery(sql).list();
	}

	/* 
	 * @see com.neuallstar.core.dao.IBaseDao#listBySQLPaging(java.lang.String, int, int)
	 */
	public List<T> listBySQLPaging(String hql, int from, int pageSize) { 
		Query q = this.createQuery(hql); 
		q.setFirstResult(from);
		q.setMaxResults(pageSize);
		return q.list(); 
	}

}
