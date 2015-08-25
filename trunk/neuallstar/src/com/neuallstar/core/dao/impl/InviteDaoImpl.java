/**
 *com.neuallstar.core.dao.impl
 * InviteDaoImpl.java
 */
package com.neuallstar.core.dao.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.neuallstar.core.dao.IInviteDao;
import com.neuallstar.core.entity.Invite;

/**
 * @author 陈秀能
 * 2011-9-12 下午12:27:31 
 */
public class InviteDaoImpl extends BaseDaoImpl<Invite> implements IInviteDao {
	private static final  Log log=LogFactory.getLog(InviteDaoImpl.class);

	/**
	 * @param log
	 * @param cls
	 */
	public InviteDaoImpl() {
		super(log, Invite.class);
	}

	
}
