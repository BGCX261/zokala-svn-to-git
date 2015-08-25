/**
 *com.neuallstar.minilog.dao.impl
 * CommentDaoImpl.java
 */
package com.neuallstar.minilog.dao.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.neuallstar.core.dao.impl.BaseDaoImpl;
import com.neuallstar.minilog.dao.ICommentDao;
import com.neuallstar.minilog.entity.Comment;
import com.neuallstar.minilog.entity.Minilog;
import com.neuallstar.minilog.entity.MinilogUser;

/**
 * @author 陈秀能 2011-7-8 下午06:38:35
 */
public class CommentDaoImpl extends BaseDaoImpl<Comment> implements ICommentDao {
	private static final Log log = LogFactory.getLog(CommentDaoImpl.class);

	// log.debug("deleting "+cls.getName()+" instance");
	// log.error("delete failed", re);
	/**
	 * @param log
	 * @param cls
	 */
	public CommentDaoImpl() {
		super(log, Comment.class);
		// TODO Auto-generated constructor stub
	}

	/*
	 * @seecom.neuallstar.minilog.dao.ICommentDao#queryCommentsByCommented(com.
	 * neuallstar.core.entity.User, int, int)
	 */
	public List<Comment> queryCommentsByCommented(MinilogUser user, int page,
			int pageSize) {
		log.debug("query " + Comment.class + " instance by Commented=" + user);
		try {
			return this
					.createQuery(
							"from com.neuallstar.minilog.entity.Comment where commented=:commented order by time desc")
					.setEntity("commented", user).setFirstResult(
							page * pageSize).setMaxResults(pageSize).list();
		} catch (RuntimeException re) {
			log.error("queryCommentsByCommented failed", re);
		}
		return null;
	}

	/*
	 * @see
	 * com.neuallstar.minilog.dao.ICommentDao#queryCommentsByCommenting(com.
	 * neuallstar.core.entity.User, int, int)
	 */
	public List<Comment> queryCommentsByCommenting(MinilogUser user, int page,
			int pageSize) {
		log.debug("query " + Comment.class + " instance by Commenting=" + user);
		try {
			return this
					.createQuery(
							"from com.neuallstar.minilog.entity.Comment where commenting=:commenting order by time desc")
					.setEntity("commenting", user).setFirstResult(
							page * pageSize).setMaxResults(pageSize).list();
		} catch (RuntimeException re) {
			log.error("queryCommentsByCommenting failed", re);
		}
		return null;
	}

	/*
	 * @see
	 * com.neuallstar.minilog.dao.ICommentDao#queryCommentsByMinilog(com.neuallstar
	 * .minilog.entity.Minilog, int, int)
	 */
	public List<Comment> queryCommentsByMinilog(Minilog minilog, int page,
			int pageSize) {
		log.debug("query " + Comment.class + " instance by minilog=" + minilog);
		try {
			return this
					.createQuery(
							"from com.neuallstar.minilog.entity.Comment where minilog=:minilog  order by time desc")
					.setEntity("minilog", minilog).setFirstResult(
							page * pageSize).setMaxResults(pageSize).list();
		} catch (RuntimeException re) {
			log.error("queryCommentsByMinilog failed", re);
		}
		return null;
	}

	/*
	 * @see
	 * com.neuallstar.minilog.dao.IBaseDao#queryByUser(com.neuallstar.core.entity
	 * .User, int, int)
	 */
	public List<Comment> queryByUser(MinilogUser user, int page, int pageSize) {
		log.debug("query " + Comment.class + " instance by user=" + user);
		try {
			return this
					.createQuery(
							"from com.neuallstar.minilog.entity.Comment where commenting=:commenting or commented=:commented  order by time desc group by minilog")
					.setEntity("commenting", user).setEntity("commented", user)
					.setFirstResult(page * pageSize).setMaxResults(pageSize)
					.list();
		} catch (RuntimeException re) {
			log.error("queryCommentsByMinilog failed", re);
		}
		return null;

	}
}
