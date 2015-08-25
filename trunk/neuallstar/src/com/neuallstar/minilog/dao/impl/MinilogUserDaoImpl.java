/**
 *com.neuallstar.minilog.dao.impl
 * SettingDaoImpl.java
 */
package com.neuallstar.minilog.dao.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.neuallstar.core.dao.impl.BaseDaoImpl;
import com.neuallstar.core.entity.User;
import com.neuallstar.minilog.dao.IMinilogUserDao;
import com.neuallstar.minilog.entity.MinilogUser;

/**
 * @author 陈秀能 2011-7-8 下午08:35:55
 */
public class MinilogUserDaoImpl extends BaseDaoImpl<MinilogUser> implements
		IMinilogUserDao {
	/**
	 * @param log
	 * @param cls
	 */
	public MinilogUserDaoImpl() {
		super(log, MinilogUser.class);
	}

	private static final Log log = LogFactory.getLog(MinilogUserDaoImpl.class);

	/*
	 * @see
	 * com.neuallstar.minilog.dao.IBaseDao#queryByUser(com.neuallstar.core.entity
	 * .User, int, int)
	 */
	public List<MinilogUser> queryByUser(User user) {
		log.debug("query " + MinilogUser.class + " instance by user=" + user);
		try {
			return this
					.createQuery(
							"from com.neuallstar.minilog.entity.MinilogUser where user=:user")
					.setEntity("user", user).list(); 
		} catch (RuntimeException re) {
			log.error("queryByUser failed", re);
		}
		return null;
	}

	/*
	 * public List<MinilogUser> queryByMinilogUser(MinilogUser user, int page,
	 * int pageSize) { log.debug("query " + MinilogUser.class +
	 * " instance by user=" + user); try { return this .createQuery(
	 * "from com.neuallstar.minilog.entity.MinilogUser where user=:user")
	 * .setEntity("user", user.getUser()).setFirstResult( page *
	 * pageSize).setMaxResults(pageSize).list();
	 * 
	 * } catch (RuntimeException re) { log.error("queryByUser failed", re); }
	 * return null; }
	 */
	/**
	 * @see
	 * com.neuallstar.minilog.dao.IMinilogUserDao#findMinilogUserByNickname(
	 * java.lang.String)
	 */
	public MinilogUser findMinilogUserByNickname(String nickname) {
		System.out.println(this.getClass() + " nickname=" + nickname);
		log.debug("find " + MinilogUser.class + " instance by nickname="
				+ nickname);
		try {
			List<MinilogUser> users = this
					.getSession()
					.createQuery(
							"from com.neuallstar.minilog.entity.MinilogUser where nickname=:nickname")
					.setString("nickname", nickname).list();
			return (users != null && users.size() > 0) ? users.get(0) : null;
		} catch (RuntimeException re) {
			log.error("findMinilogUserByNickname failed", re);
		}
		return null;
	}

	public List<MinilogUser> listLatestUsers(int size) {
		log.debug("list latest " + MinilogUser.class + " instance ");
		try {
			return this
					.getSession()
					.createQuery(
							"from com.neuallstar.minilog.entity.MinilogUser order by time desc")
					.setFirstResult(0).setMaxResults(size).list();
		} catch (RuntimeException re) {
			log.error("listLatestUsers failed", re);
		}
		return null;
	}

	public List<MinilogUser> listLatestUsers(int size, MinilogUser user) {
		log.debug("list latest " + MinilogUser.class + " instance ");
		try {
			return this
					.getSession()
					.createQuery(
							"from com.neuallstar.minilog.entity.MinilogUser u where u not in (select followed from Relationship where following=:following) and u!=:user order by time desc")
					.setEntity("following", user).setEntity("user", user)
					.setFirstResult(0).setMaxResults(size).list();
		} catch (RuntimeException re) {
			log.error("listLatestUsers failed", re);
		}
		return null;
	}

	public List<MinilogUser> listUsers(int size, String string) {
		log .debug("list " + MinilogUser.class + " order by property= " + string);
		try {
			return this
					.getSession()
					.createQuery(
							"from com.neuallstar.minilog.entity.MinilogUser order by "+string+" desc")
					.setFirstResult(0)
					.setMaxResults(size).list();
		} catch (RuntimeException re) {
			log.error("listLatestUsers failed", re);
		}
		return null;
	}

	public List<MinilogUser> queryByUser(MinilogUser user, int page,
			int pageSize) {
		
		return null;
	}
}
