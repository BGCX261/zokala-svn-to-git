/**
 *com.neuallstar.minilog.action
 * PopularAction.java
 */
package com.neuallstar.minilog.action;

import java.util.List;

import com.neuallstar.minilog.entity.Minilog;
import com.neuallstar.minilog.entity.MinilogConstant;
import com.neuallstar.minilog.entity.MinilogUser;
import com.neuallstar.minilog.entity.Topic;
import com.neuallstar.minilog.service.IMinilogService;
import com.neuallstar.minilog.service.IMinilogUserService;
import com.neuallstar.minilog.service.ITopicService;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author 陈秀能 2011-8-11 下午08:30:23
 */
public class PopularAction extends ActionSupport {
	/**
	 * 关注用户最多的用户
	 * */
	private List<MinilogUser> followings;
	/**
	 * 粉丝最多的用户
	 * */
	private List<MinilogUser> followeds;
	/**
	 * 发表微博最多的用户
	 * */
	private List<MinilogUser> publishers;
	/**
	 * 发表评论最多的用户
	 * */
	private List<MinilogUser> commenters;
	/**
	 * 转发微博最多的用户
	 * */
	private List<MinilogUser> forwarders;
	/**
	 * 收藏微博最多的用户
	 * */
	private List<MinilogUser> collectors;
	/**
	 * AT别人最多的用户
	 * */
	private List<MinilogUser> aters;
	/**
	 * 发表话题最多的用户
	 * */
	private List<MinilogUser> topicers;

	// private List<Minilog> minilogs;
	/**
	 * 转发最多的微博
	 * */
	private List<Minilog> forwards;
	/**
	 * 被收藏最多的微博
	 * */
	private List<Minilog> collects;
	/**
	 * 被评论最多的微博
	 * */
	private List<Minilog> comments;
	/**
	 * 最热门的话题
	 * **/
	private List<Topic> topics;

	public List<Topic> getTopics() {
		return topics;
	}

	public void setTopics(List<Topic> topics) {
		this.topics = topics;
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

	public List<MinilogUser> getPublishers() {
		return publishers;
	}

	public void setPublishers(List<MinilogUser> publishers) {
		this.publishers = publishers;
	}

	public List<MinilogUser> getCommenters() {
		return commenters;
	}

	public void setCommenters(List<MinilogUser> commenters) {
		this.commenters = commenters;
	}

	public List<MinilogUser> getForwarders() {
		return forwarders;
	}

	public void setForwarders(List<MinilogUser> forwarders) {
		this.forwarders = forwarders;
	}

	public List<MinilogUser> getCollectors() {
		return collectors;
	}

	public void setCollectors(List<MinilogUser> collectors) {
		this.collectors = collectors;
	}

	public List<MinilogUser> getAters() {
		return aters;
	}

	public void setAters(List<MinilogUser> aters) {
		this.aters = aters;
	}

	public List<MinilogUser> getTopicers() {
		return topicers;
	}

	public void setTopicers(List<MinilogUser> topicers) {
		this.topicers = topicers;
	}

	public List<Minilog> getForwards() {
		return forwards;
	}

	public void setForwards(List<Minilog> forwards) {
		this.forwards = forwards;
	}

	public List<Minilog> getCollects() {
		return collects;
	}

	public void setCollects(List<Minilog> collects) {
		this.collects = collects;
	}

	public List<Minilog> getComments() {
		return comments;
	}

	public void setComments(List<Minilog> comments) {
		this.comments = comments;
	}

	private IMinilogUserService minilogUserService;
	private IMinilogService minilogService;
	private ITopicService topicService;

	public IMinilogUserService getMinilogUserService() {
		return minilogUserService;
	}

	public void setMinilogUserService(IMinilogUserService minilogUserService) {
		this.minilogUserService = minilogUserService;
	}

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

	public String execute() {
		followings = minilogUserService
				.listPopuplarFollowings(MinilogConstant.POPULAR_FOLLOWINGS_SIZE);
		followeds = minilogUserService
				.listPopuplarFolloweds(MinilogConstant.POPULAR_FOLLOWEDS_SIZE);
		publishers = minilogUserService
				.listPopularPublshers(MinilogConstant.POPULAR_PUBLISHERS_SIZE);
		commenters = minilogUserService
				.listPopularCommentings(MinilogConstant.POPULAR_COMMENTERS_SIZE);
		forwarders = minilogUserService
				.listPopularForwarders(MinilogConstant.POPULAR_FORWARDERS_SIZE);
		collectors = minilogUserService
				.listPopularCollectors(MinilogConstant.POPULAR_COLLECTORS_SIZE);
		aters = minilogUserService
				.listPopularAters(MinilogConstant.POPULAR_ATERS_SIZE);
		topicers = minilogUserService
				.listPopularTopicers(MinilogConstant.POPULAR_TOPICERS_SIZE);
		forwards = minilogService.listPopularForwards(MinilogConstant.POPULAR_FORWARDS_SIZE);
		collects = minilogService.listPopularCollects(MinilogConstant.POPULAR_COLLECTS_SIZE);
		comments = minilogService.listPopularComments(MinilogConstant.POPULAR_COMMENTS_SIZE);
		topics=topicService.listPopularTopics(MinilogConstant.POPULAR_TOPICS_SIZE);
		return this.SUCCESS;
	}
}
