/**
 *com.neuallstar.minilog.dao
 * ICollectDao.java
 */
package com.neuallstar.minilog.dao;

import com.neuallstar.minilog.entity.Collect;
import com.neuallstar.minilog.entity.Minilog;
import com.neuallstar.minilog.entity.MinilogUser;

/**
 * @author 陈秀能 2011-8-12 上午10:54:46
 */
public interface ICollectDao extends IBaseDao<Collect> {
	public Collect getCollectByUserAndMinilog(MinilogUser user, Minilog minilog);
}
