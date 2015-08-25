/**
 *com.neuallstar.minilog.action
 * UserCommentAction.java
 */
package com.neuallstar.minilog.action;

import java.util.List;
import java.util.Map;

import com.neuallstar.minilog.entity.Comment;
import com.neuallstar.minilog.entity.MinilogConstant;
import com.neuallstar.minilog.entity.MinilogUser;
import com.neuallstar.minilog.service.ICommentService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author 陈秀能
 * 2011-8-20 下午03:14:53 
 */
public class UserCommentAction extends ActionSupport {
private List<Comment> comments;
private ICommentService commentService;
private int page=0;
public String execute(){ 
	Map<String, MinilogUser> session = ActionContext.getContext()
			.getSession();
	MinilogUser user = session.get(MinilogConstant.MINILOG_SESSION);
	comments=commentService.listCommentsByUser(user, page, user.getCommentSize());
	return this.SUCCESS;
}
}
