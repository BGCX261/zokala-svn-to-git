/**
 *com.neuallstar.minilog.dao
 * ITopicDao.java
 */
package com.neuallstar.minilog.dao;

import java.util.List;

import com.neuallstar.minilog.entity.Topic;

/**
 * 话题数据对象访问接口
 * @author 陈秀能
 * 2011-7-6 下午09:34:35 
 */
public interface ITopicDao extends IBaseDao<Topic> {
	/**
	 * 根据内容搜索话题
	 * @return List<Topic> 话题列表
	 * @param page 页码
	 * @param pageSize 页大小
	 * **/
	public List<Topic> searchTopicsByContent(String content,int page,int pageSize);

	/**列出指定数量最新话题
	 *@param size
	 *@return
	 *return List<Topic>
	 */
	public List<Topic> listTopics(int size);
	/**
	 * 根据话题内容搜索话题
	 * @return 话题
	 * @param content 话题内容
	 * **/
	public Topic getTopicByContent(String content);

	/**
	 *@param popularTopicsSize
	 *@param string
	 *@return
	 *return List<Topic>
	 */
	public List<Topic> listTopics(int size, String string);
}
