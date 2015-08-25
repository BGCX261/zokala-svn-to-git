/**
 *com.neuallstar.minilog.action
 * ForwardAction.java
 */
package com.neuallstar.minilog.action;

import java.sql.Timestamp;
import java.util.Map;

import com.neuallstar.minilog.entity.Comment;
import com.neuallstar.minilog.entity.Minilog;
import com.neuallstar.minilog.entity.MinilogConstant;
import com.neuallstar.minilog.entity.MinilogUser;
import com.neuallstar.minilog.service.ICommentService;
import com.neuallstar.minilog.service.IMinilogService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author 陈秀能 2011-8-11 下午09:22:08
 */
public class ForwardAction extends ActionSupport {
	private int minilogId;
	private String content;
	/** 有both和forward两个值 **/
	private String topictype;
	private String forward_tid;

	public int getMinilogId() {
		return minilogId;
	}

	public void setMinilogId(int minilogId) {
		this.minilogId = minilogId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getTopictype() {
		return topictype;
	}

	public void setTopictype(String topictype) {
		this.topictype = topictype;
	}

	public String getForward_tid() {
		return forward_tid;
	}

	public void setForward_tid(String forwardTid) {
		forward_tid = forwardTid;
	}

	public IMinilogService minilogService;
	private ICommentService commentService;

	public IMinilogService getMinilogService() {
		return minilogService;
	}

	public void setMinilogService(IMinilogService minilogService) {
		this.minilogService = minilogService;
	}

	public ICommentService getCommentService() {
		return commentService;
	}

	public void setCommentService(ICommentService commentService) {
		this.commentService = commentService;
	}

	public String execute() {
		/*System.out.println(this.getClass() + " content=" + content);
		System.out.println(this.getClass() + " minilogId=" + minilogId);
		System.out.println(this.getClass() + " forward_tid=" + forward_tid);
		System.out.println(this.getClass() + " topictype=" + topictype);*/
		Minilog minilog=new Minilog();
		Minilog from=new Minilog();
		from.setMinilogId(minilogId);
		minilog.setContent(content);
		minilog.setFrom(from); 
		Map<String,MinilogUser> userSession=ActionContext.getContext().getSession();
		minilog.setPublisher(userSession.get(MinilogConstant.MINILOG_SESSION));
		minilog.setTime(new Timestamp(System.currentTimeMillis()));
		minilogService.saveMinilog(minilog);
		if (topictype.equals("both")) {
			Comment comment=new Comment();
			comment.setMinilog(from);
			comment.setTime(new Timestamp(System.currentTimeMillis()));
			comment.setContent(content);
			//comment.setCommented(minilogService.getMinilogById(minilogId).getPublisher());
			comment.setCommenting(userSession.get(MinilogConstant.MINILOG_SESSION));
			commentService.saveComment(comment);
		}
		return this.SUCCESS;
	}
}
