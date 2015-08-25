/**
 *com.neuallstar.minilog.action
 * UserAction.java
 */
package com.neuallstar.minilog.action;

import java.util.List;
import java.util.Map;

import com.neuallstar.minilog.entity.Minilog;
import com.neuallstar.minilog.entity.MinilogConstant;
import com.neuallstar.minilog.entity.MinilogUser;
import com.neuallstar.minilog.entity.Topic;
import com.neuallstar.minilog.service.IMinilogService;
import com.neuallstar.minilog.service.IMinilogUserService;
import com.neuallstar.minilog.service.IRelationshipService;
import com.neuallstar.minilog.service.ITopicService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author 陈秀能 2011-8-12 下午08:33:02
 */
public class UserAction extends ActionSupport {
	private List<Minilog> minilogs;
	private List<MinilogUser> followings;
	private List<MinilogUser> followeds;
	private List<Topic> topics;
	private boolean isFollowing = false;

	private MinilogUser muser;
	private int page = 0;

	private IMinilogService minilogService;
	private IRelationshipService relationshipService;
	private IMinilogUserService userService;
	private ITopicService topicService;

	public List<Minilog> getMinilogs() {
		return minilogs;
	}

	public void setMinilogs(List<Minilog> minilogs) {
		this.minilogs = minilogs;
	}

	public List<MinilogUser> getFollowings() {
		return followings;
	}

	public void setFollowings(List<MinilogUser> followings) {
		this.followings = followings;
	}

	public List<MinilogUser> getFolloweds() {
		return followeds;
	}

	public void setFolloweds(List<MinilogUser> followeds) {
		this.followeds = followeds;
	}

	public List<Topic> getTopics() {
		return topics;
	}

	public void setTopics(List<Topic> topics) {
		this.topics = topics;
	}

	public boolean isFollowing() {
		return isFollowing;
	}

	public void setFollowing(boolean isFollowing) {
		this.isFollowing = isFollowing;
	}

	public MinilogUser getMuser() {
		return muser;
	}

	public void setMuser(MinilogUser muser) {
		this.muser = muser;
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

	public IRelationshipService getRelationshipService() {
		return relationshipService;
	}

	public void setRelationshipService(IRelationshipService relationshipService) {
		this.relationshipService = relationshipService;
	}

	public IMinilogUserService getUserService() {
		return userService;
	}

	public void setUserService(IMinilogUserService userService) {
		this.userService = userService;
	}

	public ITopicService getTopicService() {
		return topicService;
	}

	public void setTopicService(ITopicService topicService) {
		this.topicService = topicService;
	}

	public String execute() {
		Map<String, MinilogUser> minilogSession = ActionContext
		.getContext().getSession();
		if (muser == null) {
			if ((muser = minilogSession.get(MinilogConstant.MINILOG_SESSION)) == null)
				return this.LOGIN;
			System.out.println(this.getClass()+" user!=null");
		} else {
		//	System.out.println(this.getClass()+" muid="+muser.getMuid());
			muser = userService.getMinilogUserByMuid(muser.getMuid());
		/*	System.out.println(this.getClass()+" muid="+muser.getMuid());
			System.out.println(this.getClass()+" nickname="+muser.getNickname());*/
		}
		minilogs = minilogService.listUserMinilog(muser, page, muser
				.getMinilogSize());
		followings = relationshipService.listUserFollowings(muser,
				MinilogConstant.USER_FOLLOWINGS_SIZE);
		followeds = relationshipService.listUserFolloweds(muser,
				MinilogConstant.USER_FOLLOWEDS_SIZE);
		topics=topicService.listTopicsCreatedByUser(muser,muser.getTopicSize());
		return this.SUCCESS;
	}
}
