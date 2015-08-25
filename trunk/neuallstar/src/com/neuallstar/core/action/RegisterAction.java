/**
 *com.neuallstar.core.action
 * RegisterAction.java
 */
package com.neuallstar.core.action;

import java.io.File;

import javax.servlet.ServletContext;

import org.apache.commons.io.FileUtils;

import com.neuallstar.core.entity.User;
import com.neuallstar.core.service.IUserService;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author 陈秀能 2011-6-11 11:49:42
 */
public class RegisterAction extends ActionSupport {
	private User user;
	private IUserService userService;
	private File avatar;
	private String avatarContentType;
	private String avatarFileName;
	private String inviteCode;
	

	public String getInviteCode() {
		return inviteCode;
	}

	public void setInviteCode(String inviteCode) {
		this.inviteCode = inviteCode;
	}

	public File getAvatar() {
		return avatar;
	}

	public void setAvatar(File avatar) {
		System.out.print(this.getClass()+" avatar="+avatar);
		this.avatar = avatar;
	}

	public String getAvatarContentType() {
		return avatarContentType;
	}

	public void setAvatarContentType(String avatarContentType) {
		this.avatarContentType = avatarContentType;
	}

	public String getAvatarFileName() {
		return avatarFileName;
	}

	public void setAvatarFileName(String avatarFileName) {
		this.avatarFileName = avatarFileName;
	}

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

	private ServletContext context;

	public ServletContext getContext() {
		return context;
	}

	public void setContext(ServletContext context) {
		this.context = context;
	}

	public String execute() {
		if (user == null)
			return this.LOGIN;
	/*	try {

			String targetDirectory = context.getRealPath("/avatars");
			String targetFileName = user.getUsername();
			File target = new File(targetDirectory, targetFileName);
			FileUtils.copyFile(avatar, target);
			setAvatarFileName(target.getPath());// 保存文件的存放路径
		} catch (Exception e) {
			addActionError(e.getMessage());
			return INPUT;
		}
		user.setAvatar(this.getAvatarFileName());
*/		if (userService.saveUser(user,inviteCode)) {
			user = null;
			return this.SUCCESS;
		}
		user = null;
		return this.INPUT;
	}
}
