/**
 *com.neuallstar.minilog.service.impl
 * MinilogServiceImpl.java
 */
package com.neuallstar.minilog.service.impl;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import com.neuallstar.minilog.dao.IMinilogDao;
import com.neuallstar.minilog.dao.IMinilogUserDao;
import com.neuallstar.minilog.dao.ITipDao;
import com.neuallstar.minilog.dao.ITopicDao;
import com.neuallstar.minilog.entity.Minilog;
import com.neuallstar.minilog.entity.MinilogConstant;
import com.neuallstar.minilog.entity.MinilogUser;
import com.neuallstar.minilog.entity.Tip;
import com.neuallstar.minilog.entity.Topic;
import com.neuallstar.minilog.service.IMinilogService;
import com.neuallstar.utils.HTMLTagFilter;

/**
 * 微博服务实现
 * 
 * @author 陈秀能 2011-7-3 上午09:05:48
 */
public class MinilogServiceImpl implements IMinilogService {
	private IMinilogDao minilogDao;
	private ITopicDao topicDao;
	private ITipDao tipDao;
	private IMinilogUserDao minilogUserDao;
	private HTMLTagFilter htf=new HTMLTagFilter();
	public IMinilogDao getMinilogDao() {
		return minilogDao;
	}

	public void setMinilogDao(IMinilogDao minilogDao) {
		this.minilogDao = minilogDao;
	}

	public ITopicDao getTopicDao() {
		return topicDao;
	}

	public void setTopicDao(ITopicDao topicDao) {
		this.topicDao = topicDao;
	}

	public ITipDao getTipDao() {
		return tipDao;
	}

	public void setTipDao(ITipDao tipDao) {
		this.tipDao = tipDao;
	}

	public IMinilogUserDao getMinilogUserDao() {
		return minilogUserDao;
	}

	public void setMinilogUserDao(IMinilogUserDao minilogUserDao) {
		this.minilogUserDao = minilogUserDao;
	}

	/*
	 * @see
	 * com.neuallstar.minilog.service.IMinilogService#saveMinilog(com.neuallstar
	 * .minilog.entity.Minilog)
	 */
	public Serializable saveMinilog(Minilog minilog) {
		Serializable serializable = minilogDao.save(minilog);
		minilog.setContent(htf.filter(minilog.getContent()));
		minilog.setContent(retrieveAt(minilog.getContent(), minilog
				.getPublisher(), minilog.getMinilogId()));
		minilog.setContent(retrieveTopic(minilog.getContent(), minilog
				.getPublisher()));
		minilogDao.update(minilog);
		return serializable;
	}

	/*
	 * @see
	 * com.neuallstar.minilog.service.IMinilogService#listLatestMinilogs(int)
	 */
	public List<Minilog> listLatestMinilogs(int size) {
		try {
			return minilogDao.listLatestMinilogs(size);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
public List<Minilog> listAtme(MinilogUser user,int page,int size) {
		String content="<a href=\""+MinilogConstant.USER_LINK+user.getMuid()+"\">";
		return minilogDao.searchMinilogsByContent(content, page, size);
	}
	/** 抽取微博中的@ **/
	private String retrieveAt(String msg, MinilogUser user, int minilogId) {
		if (msg.contains(MinilogConstant.AT)
				&& (msg.length() != (msg.indexOf(MinilogConstant.AT) + 1))) {
			StringBuffer buffer = new StringBuffer();
			int possp = msg.length();
			int posat = msg.indexOf(MinilogConstant.AT);
			if (msg.substring(posat + 1).contains(MinilogConstant.SPACE)) {
				possp = posat
				+ msg.substring(posat + 1).indexOf(
						MinilogConstant.SPACE) + 1;
			}
			if (msg.substring(posat + 1).contains(MinilogConstant.SHARPE)) {
				possp = posat
				+ msg.substring(posat + 1).indexOf(
						MinilogConstant.SHARPE) + 1;
			}
			if (msg.substring(posat + 1).contains(MinilogConstant.AT)) {
				possp = posat
				+ (possp < msg.substring(posat + 1).indexOf(
						MinilogConstant.AT) ? possp : msg.substring(
								posat + 1).indexOf("@")) + 1;
			}
			MinilogUser atUser = minilogUserDao.findMinilogUserByNickname(msg
					.substring(posat + 1, possp));
			if (atUser != null) {
				Tip tip = new Tip();
				tip.setFrom(user);
				tip.setTo(atUser);
				tip.setContent(user.getNickname() + "的微博提到你");
				tip.setType(MinilogConstant.AT);
				tip.setLink("minilog.html?minilog.minilogId=" + minilogId);
				tip.setRead(0);
				tipDao.save(tip);
				if (posat == 0) {
					buffer.append("<a href=\"").append(
							MinilogConstant.USER_LINK).append(
									atUser.getUser().getId()).append("\">");
				} else {
					buffer.append(msg.substring(0, posat)).append("<a href=")
					.append(MinilogConstant.USER_LINK).append(
							atUser.getUser().getId()).append("\">");
				}
				buffer.append(msg.substring(posat, possp)).append("</a>");
			} else {
				buffer.append(msg.substring(posat, possp));
			}
			return buffer.append(
					retrieveAt(msg.substring(possp), user, minilogId))
					.toString();
		}
		return msg;
	}

	/** 抽取微博中的话题 **/
	private String retrieveTopic(String msg, MinilogUser user) {
		if (msg.contains(MinilogConstant.SHARPE)
				&& msg.length() != (msg.indexOf(MinilogConstant.SHARPE) + 1)) {
			int posf = msg.indexOf(MinilogConstant.SHARPE);
			int posl = 0;
			if (msg.substring(posf + 1).contains(MinilogConstant.SHARPE)) {
				posl = posf
				+ msg.substring(posf + 1).indexOf(
						MinilogConstant.SHARPE);
		/*		System.out.println(this.getClass()+" topic content="+msg.substring(posf+1,
						posl + 1));*/
				Topic topic = topicDao.getTopicByContent(msg.substring(posf+1,
						posl + 1));
				if (topic == null) {
					topic = new Topic();
					topic.setContent(msg.substring(posf + 1, posl + 1));
					topic.setCreator(user);
					topic.setTime(new Timestamp(System.currentTimeMillis()));
					topicDao.save(topic);
				}
				topic.setCountMinilogs(topic.getCountMinilogs()+1);
				/** 检验话题是否存在，否则生成新话题 **/
				StringBuffer buffer = new StringBuffer();
				if (posf != 0) {
					buffer.append(msg.substring(0, posf));
				}
				return buffer.append("<a href=\"topic.html?topic.topicId=")
				.append(topic.getTopicId()).append("\">").append(
						msg.substring(posf, posl + 2)).append("</a>")
						.append(retrieveTopic(msg.substring(posl + 2), user))
						.toString();
			}
		}
		return msg;
	}

	public List<Minilog> listUserAndFollowedMinilogs(MinilogUser user, int page) {
		try {
			return minilogDao.listFollowingMinilogs(user, page, user
					.getMinilogSize());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public Minilog getMinilogById(int minilogId) {

		return minilogDao.findById(minilogId);
	}

	public Minilog deleteMinilog(int minilogId) {
		minilogDao.findById(minilogId).setContent(null);
		return minilogDao.findById(minilogId);
	}

	public List<Minilog> listUserMinilog(MinilogUser user, int page,
			int minilogSize) {
		return minilogDao.queryByUser(user, page, minilogSize);
	}

	public List<Minilog> listPopularCollects(int popularCollectsSize) {
		return minilogDao.listMinilogs(popularCollectsSize,"collects");
	}

	public List<Minilog> listPopularComments(int popularCommentsSize) { 
		return minilogDao.listMinilogs(popularCommentsSize,"countComments");
	}

	public List<Minilog> listPopularForwards(int popularForwardsSize) {
		
		return minilogDao.listMinilogs( popularForwardsSize,"forwards");
	}

	
}
