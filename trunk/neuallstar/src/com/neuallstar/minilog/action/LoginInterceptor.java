/**
 *com.neuallstar.minilog.action
 * LoginInterceptor.java
 */
package com.neuallstar.minilog.action;

import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.StrutsStatics;

import com.neuallstar.core.entity.CoreConstant;
import com.neuallstar.core.entity.User;
import com.neuallstar.core.service.IUserService;
import com.neuallstar.minilog.entity.MinilogConstant;
import com.neuallstar.minilog.entity.MinilogUser;
import com.neuallstar.minilog.service.IMinilogUserService;
import com.neuallstar.utils.Encrypt;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * @author 陈秀能 2011-8-18 下午03:57:25
 */
public class LoginInterceptor extends AbstractInterceptor {
	private IMinilogUserService minilogUserService;
	private IUserService userService;

	public IMinilogUserService getMinilogUserService() {
		return minilogUserService;
	}

	public void setMinilogUserService(IMinilogUserService minilogUserService) {
		this.minilogUserService = minilogUserService;
	}

	public IUserService getUserService() {
		return userService;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	/**
	 * 微博用户身份验证 首先检查Minilog模块的session是否存在，如果存在，则更新session
	 * 否则检查系统session是否存在，如果存在，
	 * 先检查用户是否已经使用了minilog模块，如果使用了就新建MinilogSession,否则初始化用户Minilog模块数据
	 * ，然后新建MinilogSession，如果以上均不满足，检查用户cookie，
	 * 如果cookie中保存的ip和登录用户的ip一致，并且用户的登录信息正确，那么新建用户的minilogSession
	 * **/
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		ActionContext actionContext = invocation.getInvocationContext();
		HttpServletRequest request = (HttpServletRequest) actionContext
				.get(StrutsStatics.HTTP_REQUEST);
		Map<String, MinilogUser> session = actionContext.getSession();
		Map<String, User> userSession = ActionContext.getContext().getSession();
		User sessionuser = userSession.get(CoreConstant.BASE_SESSION);
		Cookie[] cookies = request.getCookies();
		MinilogUser minilogUser = null;
		System.out.println(this.getClass()+" 1");
		if (session != null
				&& session.get(MinilogConstant.MINILOG_SESSION) != null) {
			System.out.println(this.getClass()+" minilogSession is not null");
			session.put(MinilogConstant.MINILOG_SESSION, minilogUserService
					.getMinilogUserByMuid(session.get(
							MinilogConstant.MINILOG_SESSION).getMuid()));
			return invocation.invoke();
		} else if (sessionuser != null) {
			System.out.println(this.getClass()+" sessionUser is not null");
			if ((minilogUser = minilogUserService
					.getMinilogUserByUser(sessionuser)) != null) {
				session.put(MinilogConstant.MINILOG_SESSION, minilogUser);
			} else {
				minilogUser = new MinilogUser(sessionuser);
				minilogUser.setMuid(sessionuser.getId());
				minilogUserService.saveMinilogUser(minilogUser);
				session.put(MinilogConstant.MINILOG_SESSION, minilogUser);
			}
			return invocation.invoke();
		} else if (cookies != null) {
			System.out.println(this.getClass()+" cookie is not null");
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals(CoreConstant.BASE_COOKIE)) {
					String value = cookie.getValue();
					if (value != null && !value.equals("")) {
						String[] s = value.split(CoreConstant.COOKIESPLIT);
						String ip = s[0];
						String username = s[1];
						String password = s[2];
						if (ip.equals(Encrypt.encrypt(request.getRemoteAddr(),
								username))) {
							User user = userService
									.findUser(username, password); 
							if (user != null) {
								if ((minilogUser = minilogUserService
										.getMinilogUserByUser(user)) != null) {
									session.put(
											MinilogConstant.MINILOG_SESSION,
											minilogUser);
								} else {
									minilogUser=new MinilogUser(user);
									minilogUser.setMuid(user.getId());
									minilogUserService.saveMinilogUser(minilogUser);
									session.put(MinilogConstant.MINILOG_SESSION, minilogUser); 
								}
								return invocation.invoke();
							}
						}
					}
				}
			}
		}
		return "login";
	}

}
