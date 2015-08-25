/**
 *com.neuallstar.minilog.dao.impl
 * RelationshipDaoImpl.java
 */
package com.neuallstar.minilog.dao.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.neuallstar.core.dao.impl.BaseDaoImpl;
import com.neuallstar.minilog.dao.IRelationshipDao;
import com.neuallstar.minilog.entity.MinilogUser;
import com.neuallstar.minilog.entity.Relationship;

/**
 * @author 陈秀能 2011-7-8 下午07:00:59
 */
public class RelationshipDaoImpl extends BaseDaoImpl<Relationship> implements
IRelationshipDao {
	/**
	 * @param log
	 * @param cls
	 */
	public RelationshipDaoImpl() {
		super(log, Relationship.class);
		// TODO Auto-generated constructor stub
	}

	private static final Log log = LogFactory.getLog(RelationshipDaoImpl.class);

	/*
	 * @see
	 * com.neuallstar.minilog.dao.IRelationshipDao#queryFolloweds(com.neuallstar
	 * .core.entity.MinilogUser, int, int)
	 */
	public List<Relationship> queryFolloweds(MinilogUser user, int page,
			int pageSize) {
		log.debug("query " + Relationship.class + " instance by user=" + user);
		try {
			return this.getSession()
			.createQuery(
					"from com.neuallstar.minilog.entity.Relationship where followed=:user  order by time desc")
					.setEntity("user", user).setFirstResult(page * pageSize)
					.setMaxResults(pageSize).list();
		} catch (RuntimeException re) {
			log.error("queryFolloweds failed", re);
		}
		return null;
	}

	/*
	 * @see
	 * com.neuallstar.minilog.dao.IRelationshipDao#queryFollowings(com.neuallstar
	 * .core.entity.MinilogUser, int, int)
	 */
	public List<Relationship> queryFollowings(MinilogUser user, int page,
			int pageSize) {
		log.debug("query " + Relationship.class + " instance by user=" + user);
		try {
			return this.getSession()
			.createQuery(
					"from com.neuallstar.minilog.entity.Relationship where following=:user  order by time desc")
					.setEntity("user", user).setFirstResult(page * pageSize)
					.setMaxResults(pageSize).list();
		} catch (RuntimeException re) {
			log.error("queryFollowings failed", re);
		}
		return null;
	}

	/*
	 * @see
	 * com.neuallstar.minilog.dao.IBaseDao#queryByUser(com.neuallstar.core.entity
	 * .MinilogUser, int, int)
	 */
	public List<Relationship> queryByUser(MinilogUser user, int page,
			int pageSize) {
		log.debug("query " + Relationship.class + " instance by user=" + user);
		try {
			return this.getSession()
			.createQuery(
					"from com.neuallstar.minilog.entity.Relationship where following=:following or followed=:followed  order by time desc")
					.setEntity("following", user).setEntity("followed", user)
					.setFirstResult(page * pageSize).setMaxResults(pageSize)
					.list();
		} catch (RuntimeException re) {
			log.error("queryByUser failed", re);
		}
		return null;
	}

	public Relationship getRelationsipByFollowingAndFollowed(
			MinilogUser following, MinilogUser followed) {
		log.debug("getRelationsipByFollowingAndFollowed " + Relationship.class + " instance " );
		try {
			List<Relationship> rs= this.getSession()
			.createQuery(
					"from com.neuallstar.minilog.entity.Relationship where following=:following and followed=:followed ")
					.setEntity("following", following).setEntity("followed", followed) 
					.list();
			return (rs!=null&&rs.size()>0)?rs.get(0):null;
		} catch (RuntimeException re) {
			log.error("getRelationsipByFollowingAndFollowed failed", re);
		}
		return null;
	}
}
