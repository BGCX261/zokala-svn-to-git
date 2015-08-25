/**
 * 
 */
package com.neuallstar.core.action;

import java.util.Map;

import com.neuallstar.core.entity.User;
import com.neuallstar.core.service.IUserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 登录
 * @author show
 * 2011-6-11 下午10:43:12 
 */
public class LoginAction extends ActionSupport {
	private User user;
	private IUserService userService;
	private String next;
	private String savelogin;
	

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}


	public IUserService getUserService() {
		return userService;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	public String getNext() {
		return next;
	}

	public void setNext(String next) {
		this.next = next;
	}

	public String getSavelogin() {
		return savelogin;
	}

	public void setSavelogin(String savelogin) {
		this.savelogin = savelogin;
	}

	@SuppressWarnings("unchecked")
	public String execute(){ 
		User sessionUser=null;
		if(user==null)return this.INPUT; 
		if((sessionUser=userService.findUser(user))!=null){
			Map<String,User> session=ActionContext.getContext().getSession();
			session.put("sessionUser", sessionUser);
			/*if(savelogin.equals("on")){
				//cookie=Encrypt.encrypt(ip,usernmae)+"=="+username+"=="+password+"==";
			} */
			if(next!=null)return this.SUCCESS; 
			return this.LOGIN;
		}
		return this.INPUT;
	}
}
