/**
 *com.neuallstar.minilog.dao
 * INoticeService.java
 */
package com.neuallstar.minilog.service;

import java.util.List;

import com.neuallstar.minilog.entity.Notice;

/**
 * 通知服务
 * 
 * @author 陈秀能 2011-7-31 下午04:18:05
 */
public interface INoticeService {
	/** 
	 * 列出最近size条通知
	 *  **/
	public List<Notice> listNotice(int size);
	/** 
	 * 列出最近第page页条通知，每页的数量为size 
	 * **/
	public List<Notice> listNotice(int page, int size);
}
