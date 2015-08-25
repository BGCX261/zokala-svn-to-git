/**
 *com.neuallstar.core.entity
 * Link.java
 */
package com.neuallstar.core.entity;

import java.io.Serializable;

/**
 * 链接
 * @author 陈秀能
 * 2011-7-2 上午08:48:03 
 */
public class Link implements Serializable {
	private long linkId;
	private String href;
	private String name;
	private int priority;
	private String page;
	private String position; 
}
