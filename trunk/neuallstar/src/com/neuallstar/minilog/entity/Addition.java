/**
 *com.neuallstar.minilog.entity
 * Addition.java
 */
package com.neuallstar.minilog.entity;

import java.io.Serializable;

/**
 * 微博附加的，例如图片，视屏，转发等
 * @author 陈秀能
 * 2011-7-21 下午08:31:14 
 */
public class Addition implements Serializable {
	/**主键**/
	private int addtionId;
	/**类型，图片，视频，投票，等等**/
	private String type;
	/**内容**/
	private String content;
	/**对应的微博**/
	private Minilog minilog;
	public int getAddtionId() {
		return addtionId;
	}
	public void setAddtionId(int addtionId) {
		this.addtionId = addtionId;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Minilog getMinilog() {
		return minilog;
	}
	public void setMinilog(Minilog minilog) {
		this.minilog = minilog;
	}
	
}
