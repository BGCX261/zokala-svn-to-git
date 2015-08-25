/**
 *com.neuallstar.minilog.dao
 * ISettingDao.java
 */
package com.neuallstar.minilog.dao;

import java.util.List;

import com.neuallstar.core.entity.User;
import com.neuallstar.minilog.entity.MinilogUser;


/**
 * 微博用户数据访问对象接口
 * @author 陈秀能
 * 2011-7-8 下午08:35:15 
 */
public interface IMinilogUserDao extends IBaseDao<MinilogUser> {
	/**
	 * 根据昵称查找用户
	 * **/
	public MinilogUser findMinilogUserByNickname(String nickname);

	/**
	 * 查找最近注册的szie个用户
	 *@param size
	 *@return
	 *return List<MinilogUser>
	 */
	public List<MinilogUser> listLatestUsers(int size);

	/**
	 * 查找最近注册的,用户未关注的szie个用户
	 *@param size
	 *@param user
	 *@return
	 *return List<MinilogUser>
	 */
	public List<MinilogUser> listLatestUsers(int size, MinilogUser user);

	/**
	 *@param popularAtersSize
	 *@param string
	 *@return
	 *return List<MinilogUser>
	 */
	public List<MinilogUser> listUsers(int popularAtersSize, String string);
	public List<MinilogUser> queryByUser(User user);
}
