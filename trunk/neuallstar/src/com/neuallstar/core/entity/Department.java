/**
 * 
 */
package com.neuallstar.core.entity;

import java.io.Serializable;
import java.util.List;

/**
 * 部门信息
 * @author 陈秀能
 * 2011-6-2 06:09:54 
 */
public class Department implements Serializable {
	/**部门唯一编号，**/
	private long departmentId;
	/**部门名称**/
	private String name;
	/**平台，即上级部门**/
	private Department platform;//super department
	/**下级部门**/
	private List<Department> subDepartment;
	/**该部门下的职位**/
	private List<Position> postions;
	
	public long getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(long departmentId) {
		this.departmentId = departmentId;
	}
	public List<Position> getPostions() {
		return postions;
	}
	public void setPostions(List<Position> postions) {
		this.postions = postions;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Department getPlatform() {
		return platform;
	}
	public void setPlatform(Department platform) {
		this.platform = platform;
	}
	public List<Department> getSubDepartment() {
		return subDepartment;
	}
	public void setSubDepartment(List<Department> subDepartment) {
		this.subDepartment = subDepartment;
	}

}
