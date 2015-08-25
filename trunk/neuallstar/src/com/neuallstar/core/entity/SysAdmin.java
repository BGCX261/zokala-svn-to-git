/**
 *com.neuallstar.core.entity
 * SysAdmin.java
 */
package com.neuallstar.core.entity;

/**
 * 系统管理员
 * @author 陈秀能
 * 2011-7-11 下午08:09:41 
 */
public class SysAdmin {
	/**用户**/
	private User user;
	/**管理员密码**/
	private String password;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
