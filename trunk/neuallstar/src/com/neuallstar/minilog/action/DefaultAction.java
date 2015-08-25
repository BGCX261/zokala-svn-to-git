/**
 *com.neuallstar.minilog.action
 * DefaultAction.java
 */
package com.neuallstar.minilog.action;

import java.util.List;

import com.neuallstar.minilog.entity.Minilog;
import com.neuallstar.minilog.entity.MinilogConstant;
import com.neuallstar.minilog.entity.MinilogUser;
import com.neuallstar.minilog.entity.Notice;
import com.neuallstar.minilog.entity.Topic;
import com.neuallstar.minilog.service.IMinilogService;
import com.neuallstar.minilog.service.IMinilogUserService;
import com.neuallstar.minilog.service.INoticeService;
import com.neuallstar.minilog.service.ITopicService;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 微博广场处理类
 * 
 * @author 陈秀能 2011-7-31 下午04:13:01
 */
public class DefaultAction extends ActionSupport {
	private List<MinilogUser> musers;
	private List<Minilog> minilogs;
	private List<Notice> notices;
	private List<Topic> topics;

	




	public List<MinilogUser> getMusers() {
		return musers;
	}

	public void setMusers(List<MinilogUser> musers) {
		this.musers = musers;
	}

	public List<Minilog> getMinilogs() {
		return minilogs;
	}

	public void setMinilogs(List<Minilog> minilogs) {
		this.minilogs = minilogs;
	}

	public List<Notice> getNotices() {
		return notices;
	}

	public void setNotices(List<Notice> notices) {
		this.notices = notices;
	}

	public List<Topic> getTopics() {
		return topics;
	}

	public void setTopics(List<Topic> topics) {
		this.topics = topics;
	}

	private IMinilogUserService minilogUserService;
	private IMinilogService minilogService;
	private ITopicService topicService;
	private INoticeService noticeService;

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

	public INoticeService getNoticeService() {
		return noticeService;
	}

	public void setNoticeService(INoticeService noticeService) {
		this.noticeService = noticeService;
	}

	public String execute() {
		musers=minilogUserService.listLatestMinilogUsers(MinilogConstant.SQUARE_RECOMENED_USER_SIZE);
		minilogs=minilogService.listLatestMinilogs(MinilogConstant.SQUARE_MINILOG_SIZE);
		notices=noticeService.listNotice(MinilogConstant.SQUARE_NOTICE_SIZE);
		topics=topicService.listLatestTopics(MinilogConstant.SQUARE_TOPIC_SIZE);
		return this.SUCCESS;
	}
}
