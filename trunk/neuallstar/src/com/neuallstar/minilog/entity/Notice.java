/**
 *com.neuallstar.minilog.entity
 * Notice.java
 */
package com.neuallstar.minilog.entity;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 通知
 * @author 陈秀能
 * 2011-7-11 下午08:36:40 
 */
public class Notice implements Serializable {
	/**通知编号**/
	private int noticeId;
	/**通知内容**/
	private String content;
	/**发布通知的微博用户**/
	private MinilogUser user;
	/**发布通知的时间**/
	private Timestamp time;
	
	public int getNoticeId() {
		return noticeId;
	}
	public void setNoticeId(int noticeId) {
		this.noticeId = noticeId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
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
