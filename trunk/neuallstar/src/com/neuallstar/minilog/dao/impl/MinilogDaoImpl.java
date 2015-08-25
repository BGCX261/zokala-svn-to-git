/**
 *com.neuallstar.minilog.dao.impl
 * MinilogDaoImpl.java
 */
package com.neuallstar.minilog.dao.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.neuallstar.core.dao.impl.BaseDaoImpl;
import com.neuallstar.minilog.dao.IMinilogDao;
import com.neuallstar.minilog.entity.Minilog;
import com.neuallstar.minilog.entity.MinilogUser;

/**
 * 微博数据访问对象接口实现
 * 
 * @author 陈秀能 2011-7-3 上午08:59:38
 */
public class MinilogDaoImpl extends BaseDaoImpl<Minilog> implements IMinilogDao {
	/**
	 * @param log
	 * @param cls
	 */
	public MinilogDaoImpl() {
		super(log, Minilog.class);
		// TODO Auto-generated constructor stub
	}

	private static final Log log = LogFactory.getLog(MinilogDaoImpl.class);

	/*
	 * @see com.neuallstar.minilog.dao.IMinilogDao#listLatestMinilogs(int)
	 */
	public List<Minilog> listLatestMinilogs(int size) {
		log.debug("query Latest " + Minilog.class + " instance");
		try {
			return this
					.createQuery(
							"from com.neuallstar.minilog.entity.Minilog order by time desc")
					.setFirstResult(0).setMaxResults(size).list();
		} catch (RuntimeException re) {
			log.error("listLatestMinilogs failed", re);
		}
		return null;
	}

	/*
	 * @see
	 * com.neuallstar.minilog.dao.IMinilogDao#searchMinilogsByContent(java.lang
	 * .String, int, int)
	 */
	public List<Minilog> searchMinilogsByContent(String content, int page,
			int pageSize) {
		log.debug("search " + Minilog.class + " instance by content="
						+ content);
		try {
			return this
					.createQuery(
							"from com.neuallstar.minilog.entity.Minilog where content like :content order by time desc")
					.setString("content", "%"+content+"%").setFirstResult(
							page * pageSize).setMaxResults(pageSize).list();
		} catch (RuntimeException re) {
			log.error("searchMinilogsByContent failed", re);
		}
		return null;
	}

	/*
	 * @see
	 * com.neuallstar.minilog.dao.IBaseDao#queryByUser(com.neuallstar.core.entity
	 * .User, int, int)
	 */
	public List<Minilog> queryByUser(MinilogUser user, int page, int pageSize) {
		log.debug("query " + Minilog.class + " instance by user=" + user);
		try {
			return this
					.createQuery(
							"from com.neuallstar.minilog.entity.Minilog where publisher=:publisher order by time desc")
					.setEntity("publisher", user).setFirstResult(
							page * pageSize).setMaxResults(pageSize).list();
		} catch (RuntimeException re) {
			log.error("queryByUser failed", re);
		}
		return null;
	}

	/*
	 * @see
	 * com.neuallstar.minilog.dao.IMinilogDao#listFollowingMinilogs(com.neuallstar
	 * .core.entity.User, int, int)
	 */
	public List<Minilog> listFollowingMinilogs(MinilogUser user, int page,
			int pageSize) {
		// from com.neuallstar.minilog.entity.Minilog where publisher in (select
		// following from com.neuallstar.minilog.Relationship where
		// followed=:followed) or publisher=:publsher order by time descs
		log.debug("query following`s " + Minilog.class + " instance by user="
				+ user);
		try {
			return this
					.createQuery(
							"from com.neuallstar.minilog.entity.Minilog  where publisher in (select followed from com.neuallstar.minilog.entity.Relationship where following=:following) or publisher=:publisher order by time desc")
					.setEntity("following", user).setEntity("publisher", user)
					.setFirstResult(page * pageSize).setMaxResults(pageSize)
					.list();
		} catch (RuntimeException re) {
			log.error("listFollowingMinilogs failed", re);
		}
		return null;
	}

	public List<Minilog> listMinilogs(int size, String string) {
		log.debug("list" + Minilog.class + "  minilog order by field=" + string);
		try {
			return this
					.getSession()
					.createQuery(
							"from com.neuallstar.minilog.entity.Minilog order by "+string+" desc")
					.setFirstResult(0)
					.setMaxResults(size).list();
		} catch (RuntimeException re) {
			log.error("listMinilogs failed", re);
		}
		return null;

	}
}
