/**
 *com.neuallstar.minilog.service
 * ISettingService.java
 */
package com.neuallstar.minilog.service;

import java.io.Serializable;
import java.util.List;

import com.neuallstar.core.entity.User;
import com.neuallstar.minilog.entity.MinilogUser;

/**
 * 微博中用户设置服务接口
 * @author 陈秀能
 * 2011-7-9 上午09:47:38 
 */
public interface IMinilogUserService {
	/**
	 * 根据用户获得用户的设置
	 * @return MinilogUser 微博用户
	 * @param user 用户
	 * **/
	public MinilogUser getMinilogUserByUser(User user);
	/**
	 * 保存用户设置
	 * @return Serializable 序列
	 * @param setting 用户设置
	 * **/
	public Serializable saveMinilogUser(MinilogUser setting);
	/**
	 * 列出最近的设置，以获得最近加入微博的用户信息
	 * @return List<MinilogUser> 设置列表
	 * @param size 返回的设置条数
	 * **/
	public List<MinilogUser> listLatestMinilogUsers(int size);
	/**
	 * 列出最近的并且用户没有关注的用户的设置，以获得最近加入微博的用户信息，推荐给当前用户
	 * @return List<MinilogUser> 设置列表
	 * @param size 返回的设置条数
	 * @param user 当前用户
	 * **/	
	public List<MinilogUser> listLatestMinilogUsers(int size,MinilogUser user);
	/**
	 *@param muid
	 *@return
	 *return MinilogUser
	 */
	public MinilogUser getMinilogUserByMuid(int muid);
	/**
	 *@param popularFollowingsSize
	 *@return
	 *return List<MinilogUser>
	 */
	public List<MinilogUser> listPopuplarFollowings(int popularFollowingsSize);
	/**
	 *@param popularFollowedsSize
	 *@return
	 *return List<MinilogUser>
	 */
	public List<MinilogUser> listPopuplarFolloweds(int popularFollowedsSize);
	/**
	 *@param popularPublishersSize
	 *@return
	 *return List<MinilogUser>
	 */
	public List<MinilogUser> listPopularPublshers(int popularPublishersSize);
	/**
	 *@param popularCommentersSize
	 *@return
	 *return List<MinilogUser>
	 */
	public List<MinilogUser> listPopularCommentings(int popularCommentersSize);
	/**
	 *@param popularForwardersSize
	 *@return
	 *return List<MinilogUser>
	 */
	public List<MinilogUser> listPopularForwarders(int popularForwardersSize);
	/**
	 *@param popularCollectorsSize
	 *@return
	 *return List<MinilogUser>
	 */
	public List<MinilogUser> listPopularCollectors(int popularCollectorsSize);
	/**
	 *@param popularAtersSize
	 *@return
	 *return List<MinilogUser>
	 */
	public List<MinilogUser> listPopularAters(int popularAtersSize);
	/**
	 *@param popularTopicersSize
	 *@return
	 *return List<MinilogUser>
	 */
	public List<MinilogUser> listPopularTopicers(int popularTopicersSize); 
}
