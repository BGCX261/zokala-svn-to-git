/**
 *com.neuallstar.minilog.entity
 * Comment.java
 */
package com.neuallstar.minilog.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import com.neuallstar.core.entity.User;

/**
 * 微博评论
 * @author 陈秀能
 * 2011-7-2 上午08:21:39 
 */
public class Comment implements Serializable {
	/**评论编号，主键**/
	private int commentId;
	/**评论的内容**/
	private String content;
	/**评论的时间**/
	private Timestamp time;
	/**评论者**/
	private MinilogUser commenting;
	/**被评论者**/
	private MinilogUser commented;
	/**被评论的微博**/
	private Minilog minilog;
	public int getCommentId() {
		return commentId;
	}
	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Timestamp getTime() {
		return time;
	}
	public void setTime(Timestamp time) {
		this.time = time;
	}
	
	public MinilogUser getCommenting() {
		return commenting;
	}
	public void setCommenting(MinilogUser commenting) {
		this.commenting = commenting;
	}
	public MinilogUser getCommented() {
		return commented;
	}
	public void setCommented(MinilogUser commented) {
		this.commented = commented;
	}
	public Minilog getMinilog() {
		return minilog;
	}
	public void setMinilog(Minilog minilog) {
		this.minilog = minilog;
	}
	
}
