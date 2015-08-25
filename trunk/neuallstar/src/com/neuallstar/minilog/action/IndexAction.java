/**
 *com.neuallstar.minilog.action
 * IndexAction.java
 */
package com.neuallstar.minilog.action;

import java.util.List;
import java.util.Map;

import com.neuallstar.core.entity.CoreConstant;
import com.neuallstar.core.entity.User;
import com.neuallstar.minilog.entity.Minilog;
import com.neuallstar.minilog.entity.MinilogConstant;
import com.neuallstar.minilog.entity.MinilogUser;
import com.neuallstar.minilog.entity.Topic;
import com.neuallstar.minilog.service.IMinilogService;
import com.neuallstar.minilog.service.IMinilogUserService;
import com.neuallstar.minilog.service.ITopicService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 微博首页，或者默认页面请求处理类
 * @author 陈秀能
 * 2011-7-9 上午09:31:38 
 */
public class IndexAction extends ActionSupport {  

 
	private IMinilogUserService minilogUserService;


	public IMinilogUserService getMinilogUserService() {
		return minilogUserService;
	}


	public void setMinilogUserService(IMinilogUserService minilogUserService) {
		this.minilogUserService = minilogUserService;
	}
 

	/**
	 * 用户已经登录过微博，则返回SUCCESS，跳转到用户主页
	 * 如果用户已经登录，但未登录微博，则先载入用户的微博设置，再返回SUCCESS，跳转到用户主页
	 * 否则LOGIN，跳转到微博广场
	 * **/
	public String execute(){ 
		Map<String,MinilogUser> miniglogUserSession=ActionContext.getContext().getSession();
		MinilogUser minilogUser=null;
		if((minilogUser=miniglogUserSession.get(MinilogConstant.MINILOG_SESSION))!=null)return SUCCESS;
		Map<String,User> userSession=ActionContext.getContext().getSession();
		User user=userSession.get(CoreConstant.BASE_SESSION);
		if(user!=null){ 
			if((minilogUser=minilogUserService.getMinilogUserByUser(user))!=null){
				miniglogUserSession.put(MinilogConstant.MINILOG_SESSION, minilogUser);
				return SUCCESS;
			}else{
				MinilogUser miniglorUser=new MinilogUser(user);
				miniglorUser.setMuid(user.getId());
			    minilogUserService.saveMinilogUser(miniglorUser);
			    miniglogUserSession.put(MinilogConstant.MINILOG_SESSION, miniglorUser);
				return SUCCESS;
			}
		}else{
			miniglogUserSession.clear();
		}
		return LOGIN;
	}
}
