/**
 *com.neuallstar.minilog.service.impl
 * TopicServiceImpl.java
 */
package com.neuallstar.minilog.service.impl;

import java.util.List;

import com.neuallstar.minilog.dao.ITopicDao;
import com.neuallstar.minilog.entity.MinilogUser;
import com.neuallstar.minilog.entity.Topic;
import com.neuallstar.minilog.service.ITopicService;

/**
 * 话题服务实现
 * @author 陈秀能
 * 2011-7-10 上午10:17:04 
 */
public class TopicServiceImpl implements ITopicService {
	private ITopicDao topicDao;

	public ITopicDao getTopicDao() {
		return topicDao;
	}

	public void setTopicDao(ITopicDao topicDao) {
		this.topicDao = topicDao;
	}

	/* 
	 * @see com.neuallstar.minilog.service.ITopicService#listLatestTopics(int)
	 */
	public List<Topic> listLatestTopics(int size) {
		return topicDao.listTopics(size);
	}

	public List<Topic> listTopicsCreatedByUser(MinilogUser user, int topicSize) {
		return topicDao.queryByUser(user, 0, topicSize);
	}

	public List<Topic> listPopularTopics(int popularTopicsSize) {
		
		return topicDao.listTopics(popularTopicsSize,"countMinilogs");
	}

}
