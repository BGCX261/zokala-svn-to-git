/**
 *com.neuallstar.minilog.service
 * IRelationshipService.java
 */
package com.neuallstar.minilog.service;

import java.util.List;

import com.neuallstar.minilog.entity.MinilogUser;
import com.neuallstar.minilog.entity.Relationship;

/**
 * @author 陈秀能
 * 2011-8-12 下午08:37:42 
 */
public interface IRelationshipService {

	/**
	 *@param user
	 *@param userFollowingsSize
	 *@return
	 *return List<MinilogUser>
	 */
	public List<MinilogUser> listUserFollowings(MinilogUser user,
			int userFollowingsSize);

	/**
	 *@param user
	 *@param userFollowedsSize
	 *@return
	 *return List<MinilogUser>
	 */
	public List<MinilogUser> listUserFolloweds(MinilogUser user,
			int userFollowedsSize);
	public String saveRelationship(Relationship relationship);
}
