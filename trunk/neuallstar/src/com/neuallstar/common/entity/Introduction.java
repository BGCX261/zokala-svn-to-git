/**
 *com.neuallstar.common.entity
 * Introduction.java
 */
package com.neuallstar.common.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

/**
 * 简介
 * @author 陈秀能 2011-8-22 上午11:05:57
 */
public class Introduction implements Serializable {
	private int introId;
	private String title;
	private String content;
	private Timestamp time;
	private int rank;
	private Introduction parent;
	private List<Introduction> children;

	public int getIntroId() {
		return introId;
	}
	public void setIntroId(int introId) {
		this.introId = introId;
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
	public Timestamp getTime() {
		return time;
	}
	public void setTime(Timestamp time) {
		this.time = time;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	public Introduction getParent() {
		return parent;
	}
	public void setParent(Introduction parent) {
		this.parent = parent;
	}
	public List<Introduction> getChildren() {
		return children;
	}
	public void setChildren(List<Introduction> children) {
		this.children = children;
	}
	
}
