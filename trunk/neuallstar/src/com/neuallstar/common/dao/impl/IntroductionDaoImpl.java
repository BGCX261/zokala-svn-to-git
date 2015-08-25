/**
 *com.neuallstar.common.dao.impl
 * IntroductionDaoImpl.java
 */
package com.neuallstar.common.dao.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.neuallstar.common.dao.IIntroductionDao;
import com.neuallstar.common.entity.Introduction;
import com.neuallstar.core.dao.impl.BaseDaoImpl;

/**
 * @author 陈秀能
 * 2011-8-22 上午11:17:33 
 */
public class IntroductionDaoImpl extends BaseDaoImpl<Introduction> implements
		IIntroductionDao {

	private static final Log log = LogFactory.getLog(IntroductionDaoImpl.class);
	/**
	 * @param log
	 * @param cls
	 */
	public IntroductionDaoImpl() {
		super(log, Introduction.class);
	} 
	
	 
}
