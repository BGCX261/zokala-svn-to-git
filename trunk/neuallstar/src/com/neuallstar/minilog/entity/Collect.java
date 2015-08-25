/**
 *com.neuallstar.minilog.entity
 * Collect.java
 */
package com.neuallstar.minilog.entity;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 收藏
 * @author 陈秀能
 * 2011-7-2 上午08:31:43 
 */
public class Collect implements Serializable {
	private int collectId;
	/**收藏的微博**/
	private Minilog minilog;
	/**收藏者**/
	private MinilogUser user;
	/**收藏的时间**/
	private Timestamp time;
	public int getCollectId() {
		return collectId;
	}
	public void setCollectId(int collectId) {
		this.collectId = collectId;
	}
	public Minilog getMinilog() {
		return minilog;
	}
	public void setMinilog(Minilog minilog) {
		this.minilog = minilog;
	}

	public MinilogUser getUser() {
		return user;
	}
	public void setUser(MinilogUser user) {
		this.user = user;
	}
	public Timestamp getTime() {
		return time;
	}
	public void setTime(Timestamp time) {
		this.time = time;
	}

}
