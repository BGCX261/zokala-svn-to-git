/**
 *com.neuallstar.minilog.dao
 * ICommentDao.java
 */
package com.neuallstar.minilog.dao;

import java.util.List;

import com.neuallstar.minilog.entity.Comment;
import com.neuallstar.minilog.entity.Minilog;
import com.neuallstar.minilog.entity.MinilogUser;

/**
 * 评论访问接口
 * 
 * @author 陈秀能 2011-7-6 下午08:33:13
 */
public interface ICommentDao extends IBaseDao<Comment> {
	/**
	 * 根据发表评论的用户查找评论
	 * 
	 * @return List<Comment> 评论列表
	 * @param user
	 *            评论者
	 * @param page
	 *            页数
	 * @param pageSize
	 *            页大小
	 * **/
	public List<Comment> queryCommentsByCommenting(MinilogUser user, int page,
			int pageSize);

	/**
	 * 根据被评论的用户查找评论
	 * 
	 * @return List<Comment> 评论列表
	 * @param user
	 *            评论者
	 * @param page
	 *            页数
	 * @param pageSize
	 *            页大小
	 * **/
	public List<Comment> queryCommentsByCommented(MinilogUser user, int page,
			int pageSize);

	/**
	 * 根据微博查找评论
	 * 
	 * @return List<Comment> 评论列表
	 * @param minilog
	 *            微博
	 * @param page
	 *            页数
	 * @param pageSize
	 *            页大小
	 * **/
	public List<Comment> queryCommentsByMinilog(Minilog minilog, int page,
			int pageSize);
}
