/**
 *com.neuallstar.minilog.dao.impl
 * TipDaoImpl.java
 */
package com.neuallstar.minilog.dao.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.neuallstar.core.dao.impl.BaseDaoImpl;
import com.neuallstar.minilog.dao.ITipDao;
import com.neuallstar.minilog.entity.MinilogUser;
import com.neuallstar.minilog.entity.Tip;

/**
 * @author 陈秀能 2011-7-8 下午07:10:26
 */
public class TipDaoImpl extends BaseDaoImpl<Tip> implements ITipDao {
	/**
	 * @param log
	 * @param cls
	 */
	public TipDaoImpl() {
		super(log, Tip.class);
	}

	private static final Log log = LogFactory.getLog(TipDaoImpl.class);

	/*
	 * @see
	 * com.neuallstar.minilog.dao.IBaseDao#queryByUser(com.neuallstar.core.entity
	 * .User, int, int)
	 */
	public List<Tip> queryByUser(MinilogUser user, int page, int pageSize) {
		log.debug("query " + Tip.class + " instance by user=" + user);
		try {
			return this.createQuery(
					"from com.neuallstar.minilog.entity.Tip where to=:user")
					.setEntity("user", user).setFirstResult(page * pageSize)
					.setMaxResults(pageSize).list();
		} catch (RuntimeException re) {
			log.error("queryByUser failed", re);
		}
		return null;
	}
}
