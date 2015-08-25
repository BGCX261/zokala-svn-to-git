/**
 *com.neuallstar.minilog.service.impl
 * TipService.java
 */
package com.neuallstar.minilog.service.impl;

import java.util.List;

import com.neuallstar.minilog.dao.ITipDao;
import com.neuallstar.minilog.entity.MinilogUser;
import com.neuallstar.minilog.entity.Tip;
import com.neuallstar.minilog.service.ITipService;

/**
 * @author 陈秀能
 * 2011-7-22 下午09:39:52 
 */
public class TipServiceImpl implements ITipService {
	private ITipDao tipDao;

	public ITipDao getTipDao() {
		return tipDao;
	}

	public void setTipDao(ITipDao tipDao) {
		this.tipDao = tipDao;
	}

	/* 
	 * @see com.neuallstar.minilog.service.ITipService#listUserTips(com.neuallstar.minilog.entity.MinilogUser)
	 */
	public List<Tip> listUserTips(MinilogUser user) {
		try {
			return tipDao.queryByUser(user, 0, Integer.MAX_VALUE);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
