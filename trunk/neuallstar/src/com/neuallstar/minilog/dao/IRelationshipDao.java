/**
 *com.neuallstar.minilog.dao
 * IRelationshipDao.java
 */
package com.neuallstar.minilog.dao;

import java.util.List;

import com.neuallstar.minilog.entity.MinilogUser;
import com.neuallstar.minilog.entity.Relationship;

/**
 * 用户关系数据对象访问接口
 * @author 陈秀能
 * 2011-7-6 下午09:26:13 
 */
public interface IRelationshipDao extends IBaseDao<Relationship> {
	/**
	 * 根据用户查找用户关注的人
	 * @return List<Relationship> 用户关注的人列表
	 * @param user 用户
	 * @param page 页数
	 * @param pageSize 页大小
	 * **/
	public List<Relationship> queryFollowings(MinilogUser user,int page,int pageSize);
	/**
	 * 根据用户查找关注用户的人，即粉丝
	 * @return List<Relationship> 粉丝列表
	 * @param user 用户
	 * @param page 页数
	 * @param pageSize 页大小
	 * **/
	public List<Relationship> queryFolloweds(MinilogUser user,int page,int pageSize);
	/**
	 *@param following
	 *@param followed
	 *@return 
	 */
	public Relationship getRelationsipByFollowingAndFollowed(MinilogUser following,
			MinilogUser followed);
}
