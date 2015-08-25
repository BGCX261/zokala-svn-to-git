/**
 *com.neuallstar.minilog.service
 * ICollectService.java
 */
package com.neuallstar.minilog.service;

import java.util.List;

import com.neuallstar.minilog.entity.Collect;
import com.neuallstar.minilog.entity.MinilogUser;

/**
 * @author 陈秀能
 * 2011-8-12 上午10:48:25 
 */
public interface ICollectService {

	/**
	 *@param collect
	 *return void
	 */
	public boolean saveCollect(Collect collect);

	/**
	 *@param user
	 *@param page
	 *@param collectSize
	 *@return
	 *return List<Collect>
	 */
	public List<Collect> listCollectsByUser(MinilogUser user, int page,
			int collectSize);

}
