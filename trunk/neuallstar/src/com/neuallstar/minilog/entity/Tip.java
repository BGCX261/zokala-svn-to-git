/**
 *com.neuallstar.minilog.entity
 * News.java
 */
package com.neuallstar.minilog.entity;

import java.io.Serializable;

/**
 * 与自己相关的新鲜事提示
 * @author 陈秀能
 * 2011-7-3 上午09:32:36 
 */
public class Tip implements Serializable {
	/**提示编号，主键**/
	private int tipId;
	/**提示的内容**/
	private String content;
	/**提示的链接**/
	private String link;
	/**提示的类型**/
	private String type;
	/**来源**/
	private MinilogUser from;
	/**目标**/
	private MinilogUser to;
	/**是否已读**/
	private int read;
	public int getTipId() {
		return tipId;
	}
	public void setTipId(int tipId) {
		this.tipId = tipId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public MinilogUser getFrom() {
		return from;
	}
	public void setFrom(MinilogUser from) {
		this.from = from;
	}
	public MinilogUser getTo() {
		return to;
	}
	public void setTo(MinilogUser to) {
		this.to = to;
	}
	public int getRead() {
		return read;
	}
	public void setRead(int read) {
		this.read = read;
	}

}
