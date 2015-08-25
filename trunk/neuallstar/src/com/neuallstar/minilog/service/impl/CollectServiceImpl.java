/**
 *com.neuallstar.minilog.service.impl
 * CollectService.java
 */
package com.neuallstar.minilog.service.impl;

import java.util.List;

import com.neuallstar.minilog.dao.ICollectDao;
import com.neuallstar.minilog.entity.Collect;
import com.neuallstar.minilog.entity.MinilogUser;
import com.neuallstar.minilog.service.ICollectService;

/**
 * @author 陈秀能 2011-8-12 上午10:53:28
 */
public class CollectServiceImpl implements ICollectService {
	private ICollectDao collectDao;

	public ICollectDao getCollectDao() {
		return collectDao;
	}

	public void setCollectDao(ICollectDao collectDao) {
		this.collectDao = collectDao;
	}

	public boolean saveCollect(Collect collect) {
		if (collectDao.getCollectByUserAndMinilog(collect.getUser(), collect
				.getMinilog()) == null) {
			collectDao.save(collect);
			return true;
		}
		return false;
	}

	public List<Collect> listCollectsByUser(MinilogUser user, int page,
			int collectSize) {
		return collectDao.queryByUser(user, page, collectSize);
	}

}
