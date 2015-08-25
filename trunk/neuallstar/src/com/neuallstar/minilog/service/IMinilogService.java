/**
 *com.neuallstar.minilog.service
 * IMinilogSaveService.java
 */
package com.neuallstar.minilog.service;

import java.io.Serializable;
import java.util.List;

import com.neuallstar.minilog.entity.Minilog;
import com.neuallstar.minilog.entity.MinilogUser;

/**
 * 微博服务接口
 * @author 陈秀能
 * 2011-7-3 上午09:02:05 
 */
public interface IMinilogService {
	/**
	 * 保存微博
	 * @return Serializable 保存后序列化的微博
	 * @param minilog 微博
	 * 先过滤HTML标签，然后抽取#， 生成话题，再抽取@ ,生成用户提示
	 * **/
	public Serializable saveMinilog(Minilog minilog);
	/**
	 * 列出最近的微博
	 * @return List<Minilog> 微博列表
	 * @param size 要列出的微博条数
	 * **/
	public List<Minilog> listLatestMinilogs(int size);
	/**
	 * 列出用户以及他关注的人的微博
	 * @return List<Minilog> 微博列表
	 * @param user 微博用户
	 * **/
	public List<Minilog> listUserAndFollowedMinilogs(MinilogUser user,int page);
	/**
	 *@param minilogId
	 *@return
	 *return MinilogUser
	 */
	public Minilog getMinilogById(int minilogId);
	
	public Minilog deleteMinilog(int minilogId);
	/**
	 * 列出用户的微博
	 *@param user
	 *@param page
	 *@param minilogSize
	 *@return
	 *return List<Minilog>
	 */
	public List<Minilog> listUserMinilog(MinilogUser user, int page,
			int minilogSize);
	/**
	 *@param popularForwardsSize
	 *@return
	 *return List<Minilog>
	 */
	public List<Minilog> listPopularForwards(int popularForwardsSize);
	/**
	 *@param popularCollectsSize
	 *@return
	 *return List<Minilog>
	 */
	public List<Minilog> listPopularCollects(int popularCollectsSize);
	/**
	 *@param popularCommentsSize
	 *@return
	 *return List<Minilog>
	 */
	public List<Minilog> listPopularComments(int popularCommentsSize);
	/**
	 *@param user
	 * @param i 
	 * @param page 
	 *@return
	 *return List<Minilog>
	 */
	public List<Minilog> listAtme(MinilogUser user, int page, int i);
}
