/**
 *com.neuallstar.minilog.dao.impl
 * TopicDaoImpl.java
 */
package com.neuallstar.minilog.dao.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.neuallstar.core.dao.impl.BaseDaoImpl;
import com.neuallstar.minilog.dao.ITopicDao;
import com.neuallstar.minilog.entity.MinilogUser;
import com.neuallstar.minilog.entity.Topic;

/**
 * @author 陈秀能 2011-7-8 下午07:12:25
 */
public class TopicDaoImpl extends BaseDaoImpl<Topic> implements ITopicDao {
	/**
	 * @param log
	 * @param cls
	 */
	public TopicDaoImpl() {
		super(log, Topic.class);
	}

	private static final Log log = LogFactory.getLog(TopicDaoImpl.class);

	/*
	 * @see
	 * com.neuallstar.minilog.dao.ITopicDao#searchTopicsByContent(java.lang.
	 * String, int, int)
	 */
	public List<Topic> searchTopicsByContent(String content, int page,
			int pageSize) {
		log.debug("search " + Topic.class + " instance by content=" + content);
		try {
			return this
					.createQuery(
							"from com.neuallstar.minilog.entity.Topic where content like :content  order by time desc")
					.setString("content", content).setFirstResult(
							page * pageSize).setMaxResults(pageSize).list();
		} catch (RuntimeException re) {
			log.error("searchTopicsByContent failed", re);
		}
		return null;
	}

	/*
	 * @see
	 * com.neuallstar.minilog.dao.IBaseDao#queryByUser(com.neuallstar.core.entity
	 * .User, int, int)
	 */
	public List<Topic> queryByUser(MinilogUser user, int page, int pageSize) {
		log.debug("search " + Topic.class + " instance by user=" + user);
		try {
			return this
					.createQuery(
							"from com.neuallstar.minilog.entity.Topic where creator=:user  order by time desc")
					.setEntity("user", user).setFirstResult(page * pageSize)
					.setMaxResults(pageSize).list();
		} catch (RuntimeException re) {
			log.error("queryByUser failed", re);
		}
		return null;
	}

	/*
	 * @see com.neuallstar.minilog.dao.ITopicDao#listTopics(int)
	 */
	public List<Topic> listTopics(int size) {
		log.debug("list " + Topic.class + " instance by");
		try {
			return this
					.createQuery(
							"from com.neuallstar.minilog.entity.Topic order by time desc")
					.setFirstResult(0).setMaxResults(size).list();
		} catch (RuntimeException re) {
			log.error("listTopics failed", re);
		}
		return null;
	}

	/*
	 * @see
	 * com.neuallstar.minilog.dao.ITopicDao#getTopicByContent(java.lang.String)
	 */
	public Topic getTopicByContent(String content) {
		log.debug("get " + Topic.class + " instance by content=" + content);
		try {
			List<Topic> topics = this
					.createQuery(
							"from com.neuallstar.minilog.entity.Topic where content=:content")
					.setString("content", content).list();
			return (topics != null && topics.size() > 0) ? topics.get(0) : null;
		} catch (RuntimeException re) {
			log.error("getTopicByContent failed", re);
		}
		return null;
	}
//"from com.neuallstar.minilog.entity.Topic t order by (select count(m) as t.countMinilogs from com.neuallstar.minilog.entity.Minilog m where m.content like :content )"
	public List<Topic> listTopics(int size, String string) {
		log.debug("list " + Topic.class + " instance order by " + string);
		try {
			return this.getSession().createQuery(
					"from com.neuallstar.minilog.entity.Topic order by "
							+string+" desc").setFirstResult(0).setMaxResults(size)
					.list();
		} catch (RuntimeException re) {
			log.error("listTopics failed", re);
		}
		return null;
	}
}
