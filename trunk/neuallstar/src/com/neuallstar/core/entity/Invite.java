/**
 *com.neuallstar.core.entity
 * Invite.java
 */
package com.neuallstar.core.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 邀请
 * @author 陈秀能 2011-9-12 下午12:00:24
 */
public class Invite implements Serializable {
	private String inviteId;
	private User inviting;
	private User invited;
	private Date time;


	public String getInviteId() {
		return inviteId;
	}

	public void setInviteId(String inviteId) {
		this.inviteId = inviteId;
	}

	public User getInviting() {
		return inviting;
	}

	public void setInviting(User inviting) {
		this.inviting = inviting;
	}

	public User getInvited() {
		return invited;
	}

	public void setInvited(User invited) {
		this.invited = invited;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

}
