/**
 *com.neuallstar.core.entity
 * UserPosition.java
 */
package com.neuallstar.core.entity;

import java.io.Serializable;

/**
 * 用户和职位关联
 * @author 陈秀能
 * 2011-6-21 下午07:29:36 
 */
public class UserPosition implements Serializable {
	/**用户和职位关系的唯一编码，主键**/
	private long userPositionId;
	/**用户**/
	private User user;
	/**职位**/
	private Position position;
	public long getUserPositionId() {
		return userPositionId;
	}
	public void setUserPositionId(long userPositionId) {
		this.userPositionId = userPositionId;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Position getPosition() {
		return position;
	}
	public void setPosition(Position position) {
		this.position = position;
	}

}
