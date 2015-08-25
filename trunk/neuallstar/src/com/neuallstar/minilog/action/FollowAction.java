/**
 *com.neuallstar.minilog.action
 * FollowAction.java
 */
package com.neuallstar.minilog.action;

import java.sql.Timestamp;
import java.util.Map;

import com.neuallstar.minilog.entity.MinilogConstant;
import com.neuallstar.minilog.entity.MinilogUser;
import com.neuallstar.minilog.entity.Relationship;
import com.neuallstar.minilog.service.IRelationshipService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author 陈秀能
 * 2011-8-6 下午04:16:03 
 */
public class FollowAction extends ActionSupport {
	private int followingid; 
	public int getFollowingid() {
		return followingid;
	}

	public void setFollowingid(int followingid) {
		this.followingid = followingid;
	}
	
	private IRelationshipService relationshipService;
	

	public IRelationshipService getRelationshipService() {
		return relationshipService;
	}

	public void setRelationshipService(IRelationshipService relationshipService) {
		this.relationshipService = relationshipService;
	}

	public String execute(){
		//MinilogUser minilogUser=null;
		Map<String,MinilogUser> minilogSession=ActionContext.getContext().getSession();
		//if((minilogUser=minilogSession.get(MinilogConstant.MINILOG_SESSION))==null)return this.LOGIN;
		Relationship r=new Relationship();
		MinilogUser followed=new MinilogUser();
		followed.setMuid(followingid);
		r.setFollowed(followed);
		r.setTime(new Timestamp(System.currentTimeMillis()));
		r.setFollowing(minilogSession.get(MinilogConstant.MINILOG_SESSION));
		return relationshipService.saveRelationship(r);
	}
}
