/**
 *com.neuallstar.core.action
 * IndexAction.java
 */
package com.neuallstar.core.action;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 首页请求处理类
 * @author 陈秀能
 * 2011-7-2 上午09:10:26 
 */
public class IndexAction extends ActionSupport {
	private String next;
	
	public String getNext() {
		return next;
	}

	public void setNext(String next) {
		this.next = next;
	}

	public String execute(){
       return this.SUCCESS;
	}
	
}
