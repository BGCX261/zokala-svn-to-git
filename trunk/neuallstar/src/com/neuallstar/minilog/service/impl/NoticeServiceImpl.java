/**
 *com.neuallstar.minilog.service.impl
 * NoticeServiceImpl.java
 */
package com.neuallstar.minilog.service.impl;

import java.util.List;

import com.neuallstar.minilog.dao.INoticeDao;
import com.neuallstar.minilog.entity.Notice;
import com.neuallstar.minilog.service.INoticeService;

/**
 * @author 陈秀能 2011-7-31 下午04:37:26
 */
public class NoticeServiceImpl implements INoticeService {
	private INoticeDao noticeDao;

	public INoticeDao getNoticeDao() {
		return noticeDao;
	}

	public void setNoticeDao(INoticeDao noticeDao) {
		this.noticeDao = noticeDao;
	}
	

	public List<Notice> listNotice(int size) {

		return noticeDao.listNotice(0, size);
	}

	public List<Notice> listNotice(int page, int size) {

		return noticeDao.listNotice(page, size);
	}

	

}
