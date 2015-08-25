/**
 *com.neuallstar.minilog.dao.impl
 * NoticeDaoImpl.java
 */
package com.neuallstar.minilog.dao.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.neuallstar.core.dao.impl.BaseDaoImpl;
import com.neuallstar.minilog.dao.INoticeDao;
import com.neuallstar.minilog.entity.Notice;

/**
 * @author 陈秀能
 * 2011-7-31 下午04:31:19 
 */
public class NoticeDaoImpl extends BaseDaoImpl<Notice> implements INoticeDao {
	private static final Log log = LogFactory.getLog(NoticeDaoImpl.class);
	/**
	 * @param log
	 * @param cls
	 */
	public NoticeDaoImpl() {
		super(log, Notice.class);
	}

	public List<Notice> listNotice(int page, int pageSize) {
		log.debug("query " + Notice.class + " instance");
		try {
			return this
					.createQuery(
							"from com.neuallstar.minilog.entity.Notice order by time desc")
					.setFirstResult(
							page * pageSize).setMaxResults(pageSize).list();
		} catch (RuntimeException re) {
			log.error("listNotice failed", re);
		}
		return null;
	}
 
	  
}
