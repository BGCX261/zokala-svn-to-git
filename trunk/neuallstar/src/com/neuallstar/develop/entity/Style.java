/**
 *com.neuallstar.core.entity
 * StyleConfig.java
 */
package com.neuallstar.develop.entity;

import java.io.Serializable;

import com.neuallstar.core.entity.Module;
import com.neuallstar.core.entity.User;

/**
 * 用户界面配置信息
 * @author 陈秀能
 * 2011-6-11 12:04:10 
 */
public class Style implements Serializable{
	/**用户界面配置的唯一编号**/
	private int condifId;
	/**用户**/
	private User user;
	/**所属模块**/
	private Module module;
	/**配置文件的相对路径**/
	private String url;
	public int getCondifId() {
		return condifId;
	}
	public void setCondifId(int condifId) {
		this.condifId = condifId;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Module getModule() {
		return module;
	}
	public void setModule(Module module) {
		this.module = module;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
}
