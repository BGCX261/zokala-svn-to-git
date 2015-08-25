/**
 *com.neuallstar.minilog.dao
 * MinilogDao.java
 */
package com.neuallstar.minilog.dao;
 
import java.util.List;

import com.neuallstar.minilog.entity.Minilog;
import com.neuallstar.minilog.entity.MinilogUser;

/**
 * 微博数据访问对象接口 
 * @author 陈秀能
 * 2011-7-3 上午08:51:17 
 */
public interface IMinilogDao extends IBaseDao<Minilog> {
	/**
	 * 获得最新微博
	 * @return List<Minilog> 微博列表
	 * @param size 返回的微博条数
	 * **/
	public List<Minilog> listLatestMinilogs(int size);
	/**
	 * 根据内容搜索微博
	 * @return List<Minilog> 微博列表
	 * @param content 关键字
	 * @param page 页码
	 * @param pageSize 页大小
	 * **/
	public List<Minilog> searchMinilogsByContent(String content,int page,int pageSize);
	/**
	 * 列出用户关注的人的微博 
	 * @return List<Minilog> 微博列表
	 * @param 用户
	 * @param page 页码
	 * @param pageSize 页大小
	 * 
	 * **/
	public List<Minilog> listFollowingMinilogs(MinilogUser user,int page,int pageSize);
 
	/**
	 *@param popularForwardsSize
	 *@param string
	 *@return
	 *return List<Minilog>
	 */
	public List<Minilog> listMinilogs(int popularForwardsSize, String string);
}
