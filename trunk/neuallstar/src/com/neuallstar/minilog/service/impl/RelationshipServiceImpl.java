/**
 *com.neuallstar.minilog.service.impl
 * RelationshipServiceImpl.java
 */
package com.neuallstar.minilog.service.impl;

import java.util.List;

import com.neuallstar.minilog.dao.IRelationshipDao;
import com.neuallstar.minilog.entity.MinilogUser;
import com.neuallstar.minilog.entity.Relationship;
import com.neuallstar.minilog.service.IRelationshipService;

/**
 * @author 陈秀能
 * 2011-8-6 下午04:28:58 
 */
public class RelationshipServiceImpl implements IRelationshipService {
	private IRelationshipDao relationshipDao;

	public IRelationshipDao getRelationshipDao() {
		return relationshipDao;
	}

	public void setRelationshipDao(IRelationshipDao relationshipDao) {
		this.relationshipDao = relationshipDao;
	}

	public String saveRelationship(Relationship relationship) {
		if(relationshipDao.getRelationsipByFollowingAndFollowed(relationship.getFollowing(),relationship.getFollowing())==null){
			relationshipDao.save(relationship);
			return "success";
		}
		return "fail";
	}

	public List<MinilogUser> listUserFolloweds(MinilogUser user,
			int userFollowedsSize) {
		
		return null;
	}

	public List<MinilogUser> listUserFollowings(MinilogUser user,
			int userFollowingsSize) {
		
		return null;
	}

}
