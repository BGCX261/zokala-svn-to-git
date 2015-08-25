/**
 *com.neuallstar.minilog.entity
 * Minilog.java
 */
package com.neuallstar.minilog.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Set;

/**
 * 微博
 * @author 陈秀能
 * 2011-7-2 上午08:11:11 
 */
public class Minilog implements Serializable {
	/**微博主键**/
	private int minilogId;
	/**微博内容**/
	private String content;
	/**附加内容**/
	private Set<Addition> additions;
	/**发布作者**/
	private MinilogUser publisher;
	/**发布时间**/
	private Timestamp time;
	/**评论**/
	private Set<Comment> comments;
	/**转发的微博**/
	private Minilog from;
	/**转发数量**/
	private int forwards;
	/**收藏数量**/
	private int collects;
	/**评论的数量**/
	private int countComments;
	
	public int getMinilogId() {
		return minilogId;
	}
	public void setMinilogId(int minilogId) {
		this.minilogId = minilogId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Set<Addition> getAdditions() {
		return additions;
	}
	public void setAdditions(Set<Addition> additions) {
		this.additions = additions;
	}
	public MinilogUser getPublisher() {
		return publisher;
	}
	public void setPublisher(MinilogUser publisher) {
		this.publisher = publisher;
	}
	public Timestamp getTime() {
		return time;
	}
	public void setTime(Timestamp time) {
		this.time = time;
	}
	public Set<Comment> getComments() {
		return comments;
	}
	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}
	public int getForwards() {
		return forwards;
	}
	public void setForwards(int forwards) {
		this.forwards = forwards;
	}
	public int getCollects() {
		return collects;
	}
	public void setCollects(int collects) {
		this.collects = collects;
	}
	public Minilog getFrom() {
		return from;
	}
	public void setFrom(Minilog from) {
		this.from = from;
	}
	public int getCountComments() {
		return countComments;
	}
	public void setCountComments(int countComments) {
		this.countComments = countComments;
	}
 
	 
	
}
