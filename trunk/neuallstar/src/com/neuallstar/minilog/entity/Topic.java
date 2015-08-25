/**
 *com.neuallstar.minilog.entity
 * Topic.java
 */
package com.neuallstar.minilog.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Set;

/**
 * 话题
 * @author 陈秀能
 * 2011-7-2 上午10:39:16 
 */
public class Topic implements Serializable {
	/**话题编号，主键**/
	private int topicId;
	/**话题内容**/
	private String content;
	/**话题创建者**/
	private MinilogUser creator;
	/**创建时间**/
	private Timestamp time;
	/**话题相关的微博**/
	private Set<Minilog> minilogs; 
	private int countMinilogs;
	
	public int getTopicId() {
		return topicId;
	}
	public void setTopicId(int topicId) {
		this.topicId = topicId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}

	public MinilogUser getCreator() {
		return creator;
	}
	public void setCreator(MinilogUser creator) {
		this.creator = creator;
	}
	public Timestamp getTime() {
		return time;
	}
	public void setTime(Timestamp time) {
		this.time = time;
	}
	public Set<Minilog> getMinilogs() {
		return minilogs;
	}
	public void setMinilogs(Set<Minilog> minilogs) {
		this.minilogs = minilogs;
	}
	public int getCountMinilogs() { 
		return countMinilogs;
	}
	public void setCountMinilogs(int countMinilogs) { 
		this.countMinilogs = countMinilogs;
	}

}
