/**
 *com.neuallstar.minilog.action
 * UserCommentAction.java
 */
package com.neuallstar.minilog.action;

import java.util.List;
import java.util.Map;

import com.neuallstar.minilog.entity.Minilog;
import com.neuallstar.minilog.entity.MinilogConstant;
import com.neuallstar.minilog.entity.MinilogUser;
import com.neuallstar.minilog.service.IMinilogService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author 陈秀能 2011-8-20 下午03:14:53
 */
public class AtMeAction extends ActionSupport {
	private List<Minilog> minilogs;
	private int page=0;
	private IMinilogService minilogService;

	public List<Minilog> getMinilogs() {
		return minilogs;
	}

	public void setMinilogs(List<Minilog> minilogs) {
		this.minilogs = minilogs;
	}

	public IMinilogService getMinilogService() {
		return minilogService;
	}

	public void setMinilogService(IMinilogService minilogService) {
		this.minilogService = minilogService;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public String execute() {
		Map<String, MinilogUser> session = ActionContext.getContext().getSession();
		MinilogUser user=session.get(MinilogConstant.MINILOG_SESSION);
		minilogs=minilogService.listAtme(user,page,user.getAts());
		return this.SUCCESS;
	}
}
