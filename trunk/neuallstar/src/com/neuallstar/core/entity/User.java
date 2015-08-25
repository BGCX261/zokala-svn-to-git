/**
 * 
 */
package com.neuallstar.core.entity;

import java.io.Serializable;
import java.sql.Date;

/**
 * 用户信息，包括登录信息，个人基本信息，社团工作信息，学习信息，工作信息，联系方式等
 * @author 陈秀能
 * 2011-6-2 下午05:58:17 
 */
public class User implements Serializable {
	/**
	 * 登录信息
	 * */
	/**用户唯一编号，用作主键**/
	private int id;
	/**用户登录等使用名称**/
	private String username;
	/**用户密码，用户登录，修改信息，授权时使用**/
	private String password;
	/**
	 * 基本信息，头像路径为头像文件夹下面的以用户id为名称的图片文件
	 * */
	/**昵称，用作显示**/
	private String nickname;
	/**性别**/
	private String gender;
	/**家乡**/
	private String hometown;
	/**生日**/
	private Date birthday; 
	/**头像路径**/
	private String avatar;
	/**
	 *学习信息
	 * */
	
	/**学校**/
	private String school;
	/**学院**/
	private String college;
	/**专业**/
	private String major;
	/**学号**/
	private int studentId; 
	
	/**
	 * 在公司的工作信息
	 * */
	/**所属行业**/
	private String industry;
	/**公司**/
	private String company;
	/**在公司的职位**/
	private String position;
	/**所在片区**/
	private String district;
	/**现在位置**/
	private String location;
	/**邮政编码**/
	private String zip; 
	
	/**
	 * 通信信息
	 * */
	/**邮件地址**/
	private String email;
	/**MSN**/
	private String msn;
	/**QQ**/
	private String qq;
	/**电话号码**/
	private String phone; 
	
	

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getHometown() {
		return hometown;
	}
	public void setHometown(String hometown) {
		this.hometown = hometown;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	} 
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	public String getCollege() {
		return college;
	}
	public void setCollege(String college) {
		this.college = college;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	} 
	public String getIndustry() {
		return industry;
	}
	public void setIndustry(String industry) {
		this.industry = industry;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	} 
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMsn() {
		return msn;
	}
	public void setMsn(String msn) {
		this.msn = msn;
	}
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	} 
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	public boolean equals(Object o){
		if(o instanceof User){
			return this.id==((User)o).getId();
		}
		return false;
	}
}
