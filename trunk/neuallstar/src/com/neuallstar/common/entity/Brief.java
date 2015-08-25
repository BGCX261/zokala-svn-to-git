/**
 *com.neuallstar.common.entity
 * Brief.java
 */
package com.neuallstar.common.entity;

/**
 * 首页展示
 * @author 陈秀能 2011-8-23 上午09:51:13
 */
public class Brief {
	private int bid;
	private String title;
	private String content;
	private String link;
	private String type;
	private String ext;//扩展
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
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
	public String getExt() {
		return ext;
	}
	public void setExt(String ext) {
		this.ext = ext;
	} 
}
