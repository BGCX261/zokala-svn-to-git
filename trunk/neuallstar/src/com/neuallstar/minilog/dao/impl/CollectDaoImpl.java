/**
 *com.neuallstar.minilog.dao.impl
 * ICollectDaoImpl.java
 */
package com.neuallstar.minilog.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;

import com.neuallstar.core.dao.impl.BaseDaoImpl;
import com.neuallstar.minilog.dao.ICollectDao;
import com.neuallstar.minilog.entity.Collect;
import com.neuallstar.minilog.entity.Minilog;
import com.neuallstar.minilog.entity.MinilogUser;

/**
 * @author 陈秀能 2011-8-12 上午10:58:22
 */
public class CollectDaoImpl extends BaseDaoImpl<Collect> implements ICollectDao {

	private static final Log log = LogFactory.getLog(CommentDaoImpl.class);

	/**
	 * @param log
	 * @param cls
	 */
	public CollectDaoImpl() {
		super(log, Collect.class);
	}

	public Collect getCollectByUserAndMinilog(MinilogUser user, Minilog minilog) {
		List<Collect> collects = this
				.getSession()
				.createQuery(
						"from com.neuallstar.minilog.entity.Collect where user=:user and minilog=:minilog")
				.setEntity("user", user).setEntity("minilog", minilog).list();
		return collects!=null&&collects.size()>0?collects.get(0):null;
	}

	public List<Collect> queryByUser(MinilogUser user, int page, int pageSize) {

		return this.getSession().createQuery(
				"from com.neuallstar.minilog.entity.Collect where user=:user order by time desc")
				.setEntity("user", user).setFirstResult(page * pageSize)
				.setMaxResults(pageSize).list();
	}

}
