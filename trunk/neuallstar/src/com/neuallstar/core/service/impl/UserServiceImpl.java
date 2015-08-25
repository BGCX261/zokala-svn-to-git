/**
 *com.neuallstar.core.service.impl
 * UserServiceImpl.java
 */
package com.neuallstar.core.service.impl;

import java.util.Date;

import com.neuallstar.core.dao.IInviteDao;
import com.neuallstar.core.dao.IUserDao;
import com.neuallstar.core.entity.Invite;
import com.neuallstar.core.entity.User;
import com.neuallstar.core.service.IUserService;
import com.neuallstar.utils.Encrypt;

/**
 * @author 陈秀能 2011-6-11 11:38:42
 */
public class UserServiceImpl implements IUserService {
	private IUserDao userDao;
	private IInviteDao inviteDao;

	public IUserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}

	public IInviteDao getInviteDao() {
		return inviteDao;
	}

	public void setInviteDao(IInviteDao inviteDao) {
		this.inviteDao = inviteDao;
	}

	/*
	 * @see
	 * com.neuallstar.core.service.IUserService#findUser(com.neuallstar.core
	 * .entity.User)
	 */
	public User findUser(User user) {
		user.setPassword(Encrypt
				.encrypt(user.getUsername(), user.getPassword()));
		return userDao.findUser(user);
	}

	public User findUser(String username, String necryptedPassword) {
		User user = new User();
		user.setUsername(username);
		user.setPassword(necryptedPassword);
		return userDao.findUser(user);
	}

	/*
	 * @see
	 * com.neuallstar.core.service.IUserService#saveUser(com.neuallstar.core
	 * .entity.User) if save successful,return true
	 */
	public boolean saveUser(User user) {
		if (!this.validateUserByUsername(user.getUsername())) {
			user.setPassword(Encrypt.encrypt(user.getUsername(), user
					.getPassword()));
			userDao.save(user);
			return true;
		}
		return false;
	}

	public boolean saveUser(User user, String inviteId) {
		if (inviteDao.findById(inviteId)!=null&&!this.validateUserByUsername(user.getUsername())) {
			user.setPassword(Encrypt.encrypt(user.getUsername(), user
					.getPassword()));
			userDao.save(user);
			inviteDao.findById(inviteId).setInvited(user);
			generateInvite(user);
			return true;
		}
		return false;
	}

	private void generateInvite(User user) {
		Invite invite=new Invite();
		invite.setInviting(user);
		invite.setTime(new Date(System.currentTimeMillis()));
		invite.setInviteId(Encrypt.encrypt(user.getUsername(),String.valueOf(System.currentTimeMillis())));
		Invite invite1=new Invite();
		invite1.setInviting(user);
		invite1.setTime(new Date(System.currentTimeMillis()));
		invite1.setInviteId(Encrypt.encrypt(String.valueOf(System.currentTimeMillis()),user.getUsername()));		
		inviteDao.save(invite);
		inviteDao.save(invite1);
	}

	/*
	 * @see
	 * com.neuallstar.core.service.IUserService#updateUser(com.neuallstar.core
	 * .entity.User)
	 */
	public boolean updateUser(User user) {

		return false;
	}

	/*
	 * @see
	 * com.neuallstar.core.service.IUserService#validateUserByUsername(java.
	 * lang.String) if username exist,return true;
	 */
	public boolean validateUserByUsername(String username) {
		if (userDao.listUsersByUsername(username).size() > 0)
			return true;
		return false;
	}

}
