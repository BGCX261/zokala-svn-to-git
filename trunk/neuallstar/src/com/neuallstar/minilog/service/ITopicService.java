/**
 *com.neuallstar.minilog.service
 * ITopicService.java
 */
package com.neuallstar.minilog.service;

import java.util.List;

import com.neuallstar.minilog.entity.MinilogUser;
import com.neuallstar.minilog.entity.Topic;

/**
 * 话题服务接口
 * @author 陈秀能
 * 2011-7-10 上午10:15:29 
 */
public interface ITopicService {
	/**
	 * 获得最近size条话题
	 * @return 话题列表
	 * @param size 需要显示的话题数量
	 * **/
	public List<Topic> listLatestTopics(int size);

	/**
	 *@param user
	 *@param topicSize
	 *@return
	 *return List<Topic>
	 */
	public List<Topic> listTopicsCreatedByUser(MinilogUser user, int topicSize);

	/**
	 *@param popularTopicsSize
	 *@return
	 *return List<Topic>
	 */
	public List<Topic> listPopularTopics(int popularTopicsSize);
}
