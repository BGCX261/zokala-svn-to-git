/**
 *com.neuallstar.core.entity
 * Position.java
 */
package com.neuallstar.core.entity;

import java.io.Serializable;
import java.util.List;

/**
 * 职位信息
 * @author 陈秀能
 * 2011-6-21 下午07:24:52 
 */
public class Position implements Serializable {
	/**职位唯一编号，主键**/
	private long positionId;
	/**职位名称**/
	private String name;
	/**所属部门**/
	private Department department;
	/**该职位上的用户**/
	private List<User> users;
	public long getPositionId() {
		return positionId;
	}
	public void setPositionId(long positionId) {
		this.positionId = positionId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
	
}
