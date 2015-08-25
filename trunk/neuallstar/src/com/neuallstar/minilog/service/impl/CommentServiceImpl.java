/**
 *com.neuallstar.minilog.service.impl
 * CommentServiceImpl.java
 */
package com.neuallstar.minilog.service.impl;

import java.util.List;

import com.neuallstar.minilog.dao.ICommentDao;
import com.neuallstar.minilog.entity.Comment;
import com.neuallstar.minilog.entity.Minilog;
import com.neuallstar.minilog.entity.MinilogUser;
import com.neuallstar.minilog.service.ICommentService;

/**
 * @author 陈秀能 2011-8-11 下午09:46:04
 */
public class CommentServiceImpl implements ICommentService {
	private ICommentDao commentDao;

	public ICommentDao getCommentDao() {
		return commentDao;
	}

	public void setCommentDao(ICommentDao commentDao) {
		this.commentDao = commentDao;
	}

	public void saveComment(Comment comment) {
		commentDao.save(comment);
	}

	public List<Comment> listCommentsByMinilog(Minilog minilog, int page,
			int commentSize) {
		return commentDao.queryCommentsByMinilog(minilog, page, commentSize);
	}

	public List<Comment> listCommentsByUser(MinilogUser user, int page,
			int commentSize) {
		
		return commentDao.queryByUser(user, page, commentSize);
	}

}
