/**
 *com.neuallstar.minilog.dao
 * INoticeDao.java
 */
package com.neuallstar.minilog.dao;

import java.util.List;

import com.neuallstar.core.dao.IBaseDao;
import com.neuallstar.minilog.entity.Notice;

/**
 * 通知数据访问对象接口
 * @author 陈秀能 2011-7-31 下午04:21:27
 */
public interface INoticeDao extends IBaseDao<Notice> {
	/**
	 * 列出最近的通知
	 * **/
	public List<Notice> listNotice(int page, int pageSize);
}
