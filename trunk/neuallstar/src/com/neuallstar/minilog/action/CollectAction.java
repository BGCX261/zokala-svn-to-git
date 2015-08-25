/**
 *com.neuallstar.minilog.action
 * CollectAction.java
 */
package com.neuallstar.minilog.action;

import java.sql.Timestamp;
import java.util.Map;

import com.neuallstar.minilog.entity.Collect;
import com.neuallstar.minilog.entity.Minilog;
import com.neuallstar.minilog.entity.MinilogConstant;
import com.neuallstar.minilog.entity.MinilogUser;
import com.neuallstar.minilog.service.ICollectService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author 陈秀能 2011-8-12 上午10:46:20
 */
public class CollectAction extends ActionSupport {
	private int minilogId;
	private String act;

	public int getMinilogId() {
		return minilogId;
	}

	public void setMinilogId(int minilogId) {
		this.minilogId = minilogId;
	}

	public String getAct() {
		return act;
	}

	public void setAct(String act) {
		this.act = act;
	}

	private ICollectService collectService;

	public ICollectService getCollectService() {
		return collectService;
	}

	public void setCollectService(ICollectService collectService) {
		this.collectService = collectService;
	}

	public String execute() { 
		Map<String,MinilogUser> minilogSession=ActionContext.getContext().getSession();
		Collect collect=new Collect();
		Minilog minilog=new Minilog();
		minilog.setMinilogId(minilogId);
		collect.setUser(minilogSession.get(MinilogConstant.MINILOG_SESSION));
		collect.setMinilog(minilog);
		collect.setTime(new Timestamp(System.currentTimeMillis()));
		collectService.saveCollect(collect);
		return this.SUCCESS;
	}
}
