/**
 *com.neuallstar.minilog.service
 * ICommentService.java
 */
package com.neuallstar.minilog.service;

import java.util.List;

import com.neuallstar.minilog.entity.Comment;
import com.neuallstar.minilog.entity.Minilog;
import com.neuallstar.minilog.entity.MinilogUser;

/**
 * @author 陈秀能
 * 2011-8-11 下午09:38:27 
 */
public interface ICommentService {

	/**
	 *@param comment
	 *return void
	 */
	public void saveComment(Comment comment);

	/**
	 *@param minilog
	 *@param page
	 *@param commentSize
	 *@return
	 *return List<Comment>
	 */
	public List<Comment> listCommentsByMinilog(Minilog minilog, int page,
			int commentSize);

	/**
	 *@param user
	 *@param page
	 *@param commentSize
	 *@return
	 *return List<Comment>
	 */
	public List<Comment> listCommentsByUser(MinilogUser user, int page,
			int commentSize);

}
