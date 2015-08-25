/**
 *com.neuallstar.utils
 * HTMLTagFilter.java
 */
package com.neuallstar.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author 陈秀能
 * 2011-8-13 上午10:20:20 
 */
public class HTMLTagFilter {
	private List<Tag> tags=null;
	protected List<Tag> initial(){
		if(tags!=null)return tags;
		tags=new ArrayList<Tag>(); 
		Tag t1=new Tag("<","&lt;");
		Tag t2=new Tag(">","&gt;");
		//Tag t3=new Tag("\'","");
		Tag t4=new Tag("\"","&quot;");
		tags.add(t1);
		tags.add(t2);
		//tags.add(t3);
		tags.add(t4);
		return tags;
	}
	public String filter(String txt){
		for(Tag t:initial()){
			txt=txt.replace(t.getHtmlTag(), t.getReplacement());
		}
		return txt;
	}
}
class Tag{
	private String htmlTag;
	private String replacement;

	public Tag(String htmlTag, String replacement) {
		super();
		this.htmlTag = htmlTag;
		this.replacement = replacement;
	}
	public String getHtmlTag() {
		return htmlTag;
	}
	public void setHtmlTag(String htmlTag) {
		this.htmlTag = htmlTag;
	}
	public String getReplacement() {
		return replacement;
	}
	public void setReplacement(String replacement) {
		this.replacement = replacement;
	}
}