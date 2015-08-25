package com.zokala.framework.ioc.reader;

import java.util.Map;
/**
 * interface of ResourceReader
 * @author ³ÂÐãÄÜ
 * **/
public interface ResourceReader {
	/**
	 * use to read resource,resource can be document or inputstream of content of document
	 * if resource  is null, the default path of resource is "src/config.xml"
	 * **/
	public Map<String,com.zokala.framework.ioc.bean.Bean> read(String resource);
}
