/**
 *com.neuallstar.core.entity
 * Module.java
 */
package com.neuallstar.core.entity;

import java.io.Serializable;


/**
 * 本类用来定义一个模块，当开发者部署 一个新的包的时候，开发者需要填写相应的信息，以便系统能够找到相应的包加载
 * @author 陈秀能
 * 2011-6-21 下午07:03:21 
 */
public class Module implements Serializable {
	/** 模块唯一编号，主键 **/
	private long  moduleId;
	/** 显示名字，作为链接等时显示的文字 **/
	private String displayName;
	/** 包名，例如本包为com.neuallstar.core.entity，则包名为core**/
	private String packName;
	/** 部署包的用户 **/
	private User user;
	public long getModuleId() {
		return moduleId;
	}
	public void setModuleId(long moduleId) {
		this.moduleId = moduleId;
	}
	public String getDisplayName() {
		return displayName;
	}
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	public String getPackName() {
		return packName;
	}
	public void setPackName(String packName) {
		this.packName = packName;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

}
