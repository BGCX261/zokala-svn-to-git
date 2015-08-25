/**
 * 
 */
package com.neuallstar.core.dao;

import java.util.List;

import com.neuallstar.core.entity.User;

/**
 * 用户数据访问对象接口
 * @author show
 * 2011-6-11 10:47:44 
 */
public interface IUserDao extends IBaseDao<User> {
	/**
	 * 根据用户的相关信息查找单个用户
	 * **/
	public User findUser(User user);
	/**
	 * 根据用户名查找用户
	 * **/
	public List<User> listUsersByUsername(String username);
}
