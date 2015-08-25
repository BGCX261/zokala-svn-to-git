/**
 *com.neuallstar.minilog.action
 * HomeAction.java
 */
package com.neuallstar.minilog.action;

import java.util.List;
import java.util.Map;

import com.neuallstar.minilog.entity.Minilog;
import com.neuallstar.minilog.entity.MinilogConstant;
import com.neuallstar.minilog.entity.MinilogUser;
import com.neuallstar.minilog.entity.Tip;
import com.neuallstar.minilog.entity.Topic;
import com.neuallstar.minilog.service.IMinilogService;
import com.neuallstar.minilog.service.IMinilogUserService;
import com.neuallstar.minilog.service.ITipService;
import com.neuallstar.minilog.service.ITopicService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 用户首页
 * 
 * @author 陈秀能 2011-7-22 下午08:10:48
 */
public class HomeAction extends ActionSupport {
	/** 用户的以及用户关注的用户的微博 **/
	private List<Minilog> minilogs;
	/** 新人推荐 **/
	private List<MinilogUser> musers;
	/** 新鲜话题 **/
	private List<Topic> topics;
	/** 用户新鲜事提示 **/
	private List<Tip> tips;

	int page = 0;

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public List<Minilog> getMinilogs() {
		return minilogs;
	}

	public void setMinilogs(List<Minilog> minilogs) {
		this.minilogs = minilogs;
	}

	public List<MinilogUser> getMusers() {
		return musers;
	}

	public void setMusers(List<MinilogUser> musers) {
		this.musers = musers;
	}

	public List<Topic> getTopics() {
		return topics;
	}

	public void setTopics(List<Topic> topics) {
		this.topics = topics;
	}

	public List<Tip> getTips() {
		return tips;
	}

	public void setTips(List<Tip> tips) {
		this.tips = tips;
	}

	private IMinilogService minilogService;
	private ITopicService topicService;
	private IMinilogUserService minilogUserService;
	private ITipService tipService;

	public IMinilogService getMinilogService() {
		return minilogService;
	}

	public void setMinilogService(IMinilogService minilogService) {
		this.minilogService = minilogService;
	}

	public ITopicService getTopicService() {
		return topicService;
	}

	public void setTopicService(ITopicService topicService) {
		this.topicService = topicService;
	}

	public ITipService getTipService() {
		return tipService;
	}

	public void setTipService(ITipService tipService) {
		this.tipService = tipService;
	}

	public IMinilogUserService getMinilogUserService() {
		return minilogUserService;
	}

	public void setMinilogUserService(IMinilogUserService minilogUserService) {
		this.minilogUserService = minilogUserService;
	}

	public String execute() {
		MinilogUser minilogUser = null;
		Map<String, MinilogUser> settingSession = ActionContext.getContext()
				.getSession();
		if ((minilogUser = settingSession.get(MinilogConstant.MINILOG_SESSION)) == null)
			return this.LOGIN;
		minilogs = minilogService
				.listUserAndFollowedMinilogs(minilogUser, page);
		topics = topicService.listLatestTopics(minilogUser.getTopicSize());
		musers = minilogUserService.listLatestMinilogUsers(minilogUser
				.getRecomendUserSize(), minilogUser);
		// System.out.println(this.getClass()+" users.size="+users.size());
		/*
		 * for(Minilog m:minilogs){ if(m.getFrom()!=null){
		 * System.out.print(this.
		 * getClass()+" from="+m.getFrom().getMinilogId()); }else{
		 * System.out.print(this.getClass()+" minilog="+m.getMinilogId()); } }
		 */
		tips = tipService.listUserTips(minilogUser);
		return this.SUCCESS;
	}
}
