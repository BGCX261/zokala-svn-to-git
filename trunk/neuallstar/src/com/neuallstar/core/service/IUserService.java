/**
 * 
 */
package com.neuallstar.core.service;

import com.neuallstar.core.entity.User;

/**
 * @author 陈秀能
 * 2011-6-11  10:45:26 
 */
public interface IUserService {
public User findUser(User user);
public boolean validateUserByUsername(String username);
public User findUser(String username,String necryptedPassword);
public boolean saveUser(User user);
public boolean saveUser(User user,String inviteId);
public boolean updateUser(User user);
//public 
}
