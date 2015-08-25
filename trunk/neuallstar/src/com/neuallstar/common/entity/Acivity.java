/**
 *com.neuallstar.common.entity
 * Acivity.java
 */
package com.neuallstar.common.entity;

import java.util.Date;

/**
 * 活动
 * 
 * @author 陈秀能 2011-8-23 上午09:46:51
 */
public class Acivity {
	private int aid;
	/** 标题 **/
	private String title;
	/** 简介 **/
	private String content;
	/** 地点 **/
	private String address;
	/** 开始时间 **/
	private Date start;
	/** 结束时间 **/
	private Date end;
	/** 主要人员 **/
	private String actor;
	/**发布时间**/
	private Date time;

	public int getAid() {
		return aid;
	}

	public void setAid(int aid) {
		this.aid = aid;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getStart() {
		return start;
	}

	public void setStart(Date start) {
		this.start = start;
	}

	public Date getEnd() {
		return end;
	}

	public void setEnd(Date end) {
		this.end = end;
	}

	public String getActor() {
		return actor;
	}

	public void setActor(String actor) {
		this.actor = actor;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

}
