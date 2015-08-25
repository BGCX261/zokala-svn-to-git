/**
 *com.neuallstar.minilog.entity
 * Letter.java
 */
package com.neuallstar.minilog.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import com.neuallstar.core.entity.User;

/**
 * 私信
 * @author 陈秀能
 * 2011-7-2 上午08:35:28 
 */
public class Letter implements Serializable {
	/**私信编号，主键**/
	private int letterId;
	/**发送者**/
	private MinilogUser sender;
	/**接收者**/
	private MinilogUser reciever;
	/**内容**/
	private String content;
	/**时间**/
	private Timestamp time;
	public int getLetterId() {
		return letterId;
	}
	public void setLetterId(int letterId) {
		this.letterId = letterId;
	}

	public MinilogUser getSender() {
		return sender;
	}
	public void setSender(MinilogUser sender) {
		this.sender = sender;
	}
	public MinilogUser getReciever() {
		return reciever;
	}
	public void setReciever(MinilogUser reciever) {
		this.reciever = reciever;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Timestamp getTime() {
		return time;
	}
	public void setTime(Timestamp time) {
		this.time = time;
	}
	
}
