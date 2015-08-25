package com.zokala.framework.ioc.bean;

import java.util.List;
/**
 * definite Bean with field <b>id</b> <b>cls</b> <b> props</b>
 * @author ³ÂÐãÄÜ
 * **/
public class Bean {
	private String id;
	private String cls;
	private List<Prop> props;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCls() {
		return cls;
	}
	public void setCls(String cls) {
		this.cls = cls;
	}
	public List<Prop> getProps() {
		return props;
	}
	public void setProps(List<Prop> props) {
		this.props = props;
	}
	
}
