/**
 *com.neuallstar.minilog.dao
 * IBaseDao.java
 */
package com.neuallstar.minilog.dao;

import java.util.List;

import com.neuallstar.minilog.entity.MinilogUser;

/**
 * @author 陈秀能
 * 2011-7-6 下午09:11:51 
 */
public interface IBaseDao<T> extends com.neuallstar.core.dao.IBaseDao<T> {
	/**
	 * 根据用户查找对象
	 * @return List<T> 对象列表
	 * @param user 用户
	 * @param page 页码
	 * @param pageSize 页大小
	 * @throws Exception 
	 * **/
	public List<T> queryByUser(MinilogUser user, int page,int pageSize);
}
