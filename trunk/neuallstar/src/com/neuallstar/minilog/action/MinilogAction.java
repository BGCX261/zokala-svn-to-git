/**
 *com.neuallstar.minilog.action
 * MinilogAction.java
 */
package com.neuallstar.minilog.action;

import java.util.List;
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
 * @author 陈秀能 2011-8-14 下午07:33:53
 */
public class MinilogAction extends ActionSupport {
	private Minilog minilog;
	private List<Comment> comments;
	private int page = 0;
	private MinilogUser muser;
	private IMinilogService minilogService;
	private ICommentService commentService;

	public Minilog getMinilog() {
		return minilog;
	}

	public void setMinilog(Minilog minilog) {
		this.minilog = minilog;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

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

	public MinilogUser getMuser() {
		return muser;
	}

	public void setMuser(MinilogUser muser) {
		this.muser = muser;
	}

	public String execute() {
		System.out.print(this.getClass() + " before");
		if (minilog == null)
			return this.INPUT;
		System.out.print(this.getClass() + " after");
		minilog = minilogService.getMinilogById(minilog.getMinilogId());
		muser = minilog.getPublisher();
		Map<String, MinilogUser> minilogSession = ActionContext.getContext()
				.getSession();
		int size = MinilogConstant.DEFAULT_COMMENT_SIZE;
		if (minilogSession.get(MinilogConstant.MINILOG_SESSION) != null)
			size = minilogSession.get(MinilogConstant.MINILOG_SESSION)
					.getCommentSize();
		comments = commentService.listCommentsByMinilog(minilog, page, size);
		return this.SUCCESS;
	}
}
