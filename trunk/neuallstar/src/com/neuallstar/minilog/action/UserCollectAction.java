/**
 *com.neuallstar.minilog.action
 * UserCommentAction.java
 */
package com.neuallstar.minilog.action;

import java.util.List;
import java.util.Map;

import com.neuallstar.minilog.entity.Collect;
import com.neuallstar.minilog.entity.MinilogConstant;
import com.neuallstar.minilog.entity.MinilogUser;
import com.neuallstar.minilog.service.ICollectService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author 陈秀能 2011-8-20 下午03:14:53
 */
public class UserCollectAction extends ActionSupport {
	private List<Collect> collects;
	private ICollectService collectService;
	private int page = 0;

	public List<Collect> getCollects() {
		return collects;
	}

	public void setCollects(List<Collect> collects) {
		this.collects = collects;
	}

	public ICollectService getCollectService() {
		return collectService;
	}

	public void setCollectService(ICollectService collectService) {
		this.collectService = collectService;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public String execute() {
		Map<String, MinilogUser> session = ActionContext.getContext()
				.getSession();
		MinilogUser user = session.get(MinilogConstant.MINILOG_SESSION);
		collects = collectService.listCollectsByUser(user, page, user
				.getCollectSize());
		return this.SUCCESS;
	}
}
