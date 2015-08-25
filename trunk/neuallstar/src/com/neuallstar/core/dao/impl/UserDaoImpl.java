/**
 * 
 */
package com.neuallstar.core.dao.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.neuallstar.core.dao.IUserDao;
import com.neuallstar.core.entity.User; 

/**
 * @author 陈秀能
 * 2011-6-11 10:54:33 
 */
public class UserDaoImpl extends BaseDaoImpl<User> implements IUserDao {
private static final  Log log=LogFactory.getLog(UserDaoImpl.class);
	/**
	 * @param log
	 * @param cls
	 */
	public UserDaoImpl() {
		super(log, User.class);
		// TODO Auto-generated constructor stub
	}

	/* 
	 * @see com.neuallstar.core.dao.IUserDao#findUser(com.neuallstar.core.entity.User)
	 */
	public User findUser(User user) {
		List<User> users = this.createQuery("from com.neuallstar.core.entity.User where username=:username and password=:password")
		.setString("username", user.getUsername()).setString("password", user.getPassword()).list();
		if(users!=null&&users.size()!=0)return users.get(0);
		return null;
	}

	/* 
	 * @see com.neuallstar.core.dao.IUserDao#listUsersByUsername(java.lang.String)
	 */
	public List<User> listUsersByUsername(String username) {
		String hql="from com.neuallstar.core.entity.User where username='"+username+"'";
		return this.listTBySQL(hql);
	}
}
