/**
 *com.neuallstar.minilog.service
 * ITipService.java
 */
package com.neuallstar.minilog.service;

import java.util.List;

import com.neuallstar.minilog.entity.MinilogUser;
import com.neuallstar.minilog.entity.Tip;

/**
 * 提示服务
 * @author 陈秀能
 * 2011-7-22 下午09:38:18 
 */
public interface ITipService {
	/**
	 * 根据用户获得用户新鲜事提示
	 * @return List<Tip> 新鲜事提示列表
	 * @param user 微博用户
	 * **/
	public List<Tip> listUserTips(MinilogUser user);
}
