/**
 *com.neuallstar.minilog.service.impl
 * SettingServiceImpl.java
 */
package com.neuallstar.minilog.service.impl;

import java.io.Serializable;
import java.util.List;

import com.neuallstar.core.entity.User;
import com.neuallstar.minilog.dao.IMinilogUserDao;
import com.neuallstar.minilog.entity.MinilogUser;
import com.neuallstar.minilog.service.IMinilogUserService;

/**
 * 微博中用户设置服务实现
 * @author 陈秀能
 * 2011-7-9 上午09:56:25 
 */
public class MinilogUserServiceImpl implements IMinilogUserService {
	private IMinilogUserDao minilogUserDao;


	public IMinilogUserDao getMinilogUserDao() {
		return minilogUserDao;
	}

	public void setMinilogUserDao(IMinilogUserDao minilogUserDao) {
		this.minilogUserDao = minilogUserDao;
	}

	/* 
	 * @see com.neuallstar.minilog.service.ISettingService#getSettingByUser(com.neuallstar.core.entity.User)
	 */
	public MinilogUser getMinilogUserByUser(User user) {
		try {
			List<MinilogUser> users=minilogUserDao.queryByUser(user);
			return (users!=null&&users.size()>0)?users.get(0):null;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/* 
	 * @see com.neuallstar.minilog.service.IMinilogUserService#saveMinilogUser(com.neuallstar.minilog.entity.MinilogUser)
	 */
	public Serializable saveMinilogUser(MinilogUser user) {
		return minilogUserDao.save(user);
	}

	/* 
	 * @see com.neuallstar.minilog.service.IMinilogUserService#listLatestMinilogUsers(int)
	 */
	public List<MinilogUser> listLatestMinilogUsers(int size,MinilogUser user) {

		return minilogUserDao.listLatestUsers(size,user);
	}

	/* 
	 * @see com.neuallstar.minilog.service.IMinilogUserService#listLatestMinilogUsers(int)
	 */
	public List<MinilogUser> listLatestMinilogUsers(int size) {
		return minilogUserDao.listLatestUsers(size);
	}

	public MinilogUser getMinilogUserByMuid(int muid) {
		return minilogUserDao.findById(muid);
	}

	public List<MinilogUser> listPopularAters(int popularAtersSize) {
		
		return minilogUserDao.listUsers(popularAtersSize,"ats");
	}

	public List<MinilogUser> listPopularCollectors(int popularCollectorsSize) {
		
		return minilogUserDao.listUsers(popularCollectorsSize,"collects");
	}

	public List<MinilogUser> listPopularCommentings(int popularCommentersSize) {
		
		return minilogUserDao.listUsers(popularCommentersSize,"comments");
	}

	public List<MinilogUser> listPopularForwarders(int popularForwardersSize) {
		
		return minilogUserDao.listUsers(popularForwardersSize,"forwards");
	}

	public List<MinilogUser> listPopularPublshers(int popularPublishersSize) {
		
		return minilogUserDao.listUsers(popularPublishersSize,"minilogs");
	}

	public List<MinilogUser> listPopularTopicers(int popularTopicersSize) {
		
		return minilogUserDao.listUsers(popularTopicersSize,"topics");
	}

	public List<MinilogUser> listPopuplarFolloweds(int popularFollowedsSize) {
		
		return minilogUserDao.listUsers(popularFollowedsSize,"followeds");
	}

	public List<MinilogUser> listPopuplarFollowings(int popularFollowingsSize) {
		
		return minilogUserDao.listUsers(popularFollowingsSize,"followings");
	}

}
