/**
 *com.neuallstar.minilog.dao
 * ILetterDao.java
 */
package com.neuallstar.minilog.dao;

import java.util.List;

import com.neuallstar.minilog.entity.Letter;
import com.neuallstar.minilog.entity.MinilogUser;

/**
 * 私信数据访问接口 
 * @author 陈秀能
 * 2011-7-6 下午08:44:13 
 */
public interface ILetterDao extends IBaseDao<Letter> { 
	/**
	 * 根据发送人查找私信
	 * @return List<Letter> 私信列表
	 * @param user 私信发送者
	 * @param page 页码
	 * @param pageSize 页大小
	 * **/
	public List<Letter> queryLettersBySender(MinilogUser user,int page,int pageSize);
	/**
	 * 根据接收人查找私信
	 * @return List<Letter> 私信列表
	 * @param user 私信接收者
	 * @param page 页码
	 * @param pageSize 页大小
	 * **/
	public List<Letter> queryLettersByreciever(MinilogUser user,int page,int pageSize);
}
