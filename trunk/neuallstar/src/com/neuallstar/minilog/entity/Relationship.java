/**
 *com.neuallstar.minilog.entity
 * Relationship.java
 */
package com.neuallstar.minilog.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import com.neuallstar.core.entity.User;

/**
 * 用户之间的关系
 * @author 陈秀能
 * 2011-7-2 上午08:18:37 
 */
public class Relationship implements Serializable {
	/**用户关系编号**/
	private int relationshipId;
	/**关注我的人**/
	private MinilogUser following;
	/**被我关注者**/
	private MinilogUser followed;
	/**关注的时间**/
	private Timestamp time;
	/**对于关注者的显示名称**/
	private String displayName;
	/**备注**/
	private String note;
	public int getRelationshipId() {
		return relationshipId;
	}
	public void setRelationshipId(int relationshipId) {
		this.relationshipId = relationshipId;
	}
	public MinilogUser getFollowing() {
		return following;
	}
	public void setFollowing(MinilogUser following) {
		this.following = following;
	}
	public MinilogUser getFollowed() {
		return followed;
	}
	public void setFollowed(MinilogUser followed) {
		this.followed = followed;
	}
	public Timestamp getTime() {
		return time;
	}
	public void setTime(Timestamp time) {
		this.time = time;
	}
	public String getDisplayName() {
		return displayName;
	}
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	
	
}
