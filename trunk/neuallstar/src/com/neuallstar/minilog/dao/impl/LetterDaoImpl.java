/**
 *com.neuallstar.minilog.dao.impl
 * LetterDaoImpl.java
 */
package com.neuallstar.minilog.dao.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.neuallstar.core.dao.impl.BaseDaoImpl;
import com.neuallstar.minilog.dao.ILetterDao;
import com.neuallstar.minilog.entity.Letter;
import com.neuallstar.minilog.entity.MinilogUser;

/**
 * @author 陈秀能 2011-7-8 下午06:54:14
 */
public class LetterDaoImpl extends BaseDaoImpl<Letter> implements ILetterDao {
	/**
	 * @param log
	 * @param cls
	 */
	public LetterDaoImpl() {
		super(log, Letter.class);
		// TODO Auto-generated constructor stub
	}

	private static final Log log = LogFactory.getLog(LetterDaoImpl.class);

	/*
	 * @see
	 * com.neuallstar.minilog.dao.ILetterDao#queryLettersBySender(com.neuallstar
	 * .core.entity.User, int, int)
	 */
	public List<Letter> queryLettersBySender(MinilogUser user, int page,
			int pageSize) {
		log.debug("query " + Letter.class + " instance by Sender=" + user);
		try {
			return this
					.createQuery(
							"from com.neuallstar.minilog.entity.Letter where sender=:sender  order by time desc")
					.setEntity("sender", user).setFirstResult(page * pageSize)
					.setMaxResults(pageSize).list();
		} catch (RuntimeException re) {
			log.error("queryLettersBySender failed", re);
		}
		return null;
	}

	/*
	 * @see
	 * com.neuallstar.minilog.dao.ILetterDao#queryLettersByreciever(com.neuallstar
	 * .core.entity.MinilogUser, int, int)
	 */
	public List<Letter> queryLettersByreciever(MinilogUser user, int page,
			int pageSize) {
		log.debug("query " + Letter.class + " instance by reciever=" + user);
		try {
			return this
					.createQuery(
							"from com.neuallstar.minilog.entity.Letter where reciever=:reciever  order by time desc")
					.setEntity("reciever", user)
					.setFirstResult(page * pageSize).setMaxResults(pageSize)
					.list();
		} catch (RuntimeException re) {
			log.error("queryLettersByreciever failed", re);
		}
		return null;
	}

	/*
	 * @see
	 * com.neuallstar.minilog.dao.IBaseDao#queryByUser(com.neuallstar.core.entity
	 * .MinilogUser, int, int)
	 */
	public List<Letter> queryByUser(MinilogUser user, int page, int pageSize) {
		log.debug("query " + Letter.class + " instance by user=" + user);
		try {
			return this
					.createQuery(
							"from com.neuallstar.minilog.entity.Letter where sender=:sender or reviever=:reciever  order by time desc")
					.setEntity("sender", user).setEntity("reciever", user)
					.setFirstResult(page * pageSize).setMaxResults(pageSize)
					.list();
		} catch (RuntimeException re) {
			log.error("queryByUser failed", re);
		}
		return null;
	}

}
