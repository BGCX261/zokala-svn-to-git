/**
 *com.neuallstar.minilog.entity
 * Setting.java
 */
package com.neuallstar.minilog.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import com.neuallstar.core.entity.User;

/**
 * 用户的微博设置
 * @author 陈秀能
 * 2011-7-8 下午07:40:47 
 */
public class MinilogUser implements Serializable {
	private int muid;
	/**用户**/
	private User user;
	/**在微博中显示的昵称**/
	private String nickname;
	/**自己的介绍**/
	private String introduction;
	/**css模板，默认为default**/
	private String template;
	/**每页显示的微博数量**/
	private int minilogSize;
	/**每页显示的评论数量**/
	private int commentSize;
	/**每页显示的私信数量**/
	private int letterSize;
	/**每页显示的我关注的人数量**/
	private int followingSize;
	/**每页显示的粉丝数量**/
	private int followedSize;
	/**每页显示的收藏的数量**/
	private int collectSize;
	/**每页显示的推荐用户的数量**/
	private int recomendUserSize;
	/**每页显示的推荐用户的数量**/
	private int commentExpandSize;
	/**每页显示的推荐用户的数量**/
	private int topicSize;
	/** 个人主页背景 **/
	private String background;
	/**我关注的人的数量**/
	private int followeds;
	/**关注我的人的数量**/
	private int followings;
	/**我发的微博的熟数量**/
	private int minilogs;
	/**微博开通的时间**/
	private Timestamp time;
	/**微博使用的头像**/
	private String avatar;
	

	
	public MinilogUser(){}
	public MinilogUser(User user) {
		super();
		this.user = user;
		this.collectSize=MinilogConstant.DEFAULT_COLLECT_SIZE;
		this.commentSize=MinilogConstant.DEFAULT_COMMENT_SIZE;
		this.followedSize=MinilogConstant.DEFAULT_FOLLOWED_SIZE;
		this.followingSize=MinilogConstant.DEFAULT_FOLLOWING_SIZE;
		this.letterSize=MinilogConstant.DEFAULT_LETTER_SIZE;
		this.minilogSize=MinilogConstant.DEFAULT_MINILOG_SIZE;
		this.recomendUserSize=MinilogConstant.DEFAULT_RECOMENED_USER_SIZE;
		this.template=MinilogConstant.DEFAULT_TEMPLATE;
		this.commentExpandSize=MinilogConstant.DEFAULT_COMMENT_EXPAND_SIZE;
		this.topicSize=MinilogConstant.DEFAULT_TOPIC_SIZE;
		this.nickname=user.getNickname();
		this.background=MinilogConstant.DEFAULT_BACKGROUND;
		this.time=new Timestamp(System.currentTimeMillis());
		if(user.getAvatar()!=null){
			this.avatar="../"+user.getAvatar();
		}else{
			this.avatar=MinilogConstant.DEFAULT_AVATAR;
		}
		
	}
	
	public int getMuid() {
		return muid;
	}
	public void setMuid(int muid) {
		this.muid = muid;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getIntroduction() {
		return introduction;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	public String getTemplate() {
		return template;
	}
	public void setTemplate(String template) {
		this.template = template;
	}
	public int getMinilogSize() {
		return minilogSize;
	}
	public void setMinilogSize(int minilogSize) {
		this.minilogSize = minilogSize;
	}
	public int getCommentSize() {
		return commentSize;
	}
	public void setCommentSize(int commentSize) {
		this.commentSize = commentSize;
	}
	public int getLetterSize() {
		return letterSize;
	}
	public void setLetterSize(int letterSize) {
		this.letterSize = letterSize;
	}
	public int getFollowingSize() {
		return followingSize;
	}
	public void setFollowingSize(int followingSize) {
		this.followingSize = followingSize;
	}
	public int getFollowedSize() {
		return followedSize;
	}
	public void setFollowedSize(int followedSize) {
		this.followedSize = followedSize;
	}
	public int getCollectSize() {
		return collectSize;
	}
	public void setCollectSize(int collectSize) {
		this.collectSize = collectSize;
	}
	public int getRecomendUserSize() {
		return recomendUserSize;
	}
	public void setRecomendUserSize(int recomendUserSize) {
		this.recomendUserSize = recomendUserSize;
	}
	public boolean equals(Object o){
		if(o instanceof MinilogUser){
			return this.getUser().equals(((MinilogUser)o).getUser());
		}
		return false;
	}
	public int getCommentExpandSize() {
		return commentExpandSize;
	}
	public void setCommentExpandSize(int commentExpandSize) {
		this.commentExpandSize = commentExpandSize;
	}
	public int getTopicSize() {
		return topicSize;
	}
	public void setTopicSize(int topicSize) {
		this.topicSize = topicSize;
	}

	public String getBackground() {
		return background;
	}
	public void setBackground(String background) {
		this.background = background;
	}
	public int getFolloweds() {
		return followeds;
	}
	public void setFolloweds(int followeds) {
		this.followeds = followeds;
	}
	public int getFollowings() {
		return followings;
	}
	public void setFollowings(int followings) {
		this.followings = followings;
	}
	public int getMinilogs() {
		return minilogs;
	}
	public void setMinilogs(int minilogs) {
		this.minilogs = minilogs;
	}
	public Timestamp getTime() {
		return time;
	}
	public void setTime(Timestamp time) {
		this.time = time;
	}
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}	 
	private List<String> tags; 
	public List<String> getTags() {
		return tags;
	}
	public void setTags(List<String> tags) {
		this.tags = tags;
	}
	/**AT别人的数量**/
	private int ats;
	/**发表评论的数量**/
	private int comments;
	/**转发的数量**/
	private int forwards;
	/**收藏的数量**/
	private int collects;
	/**发表话题的数量**/
	private int topics;



	public int getAts() {
		return ats;
	}
	public void setAts(int ats) {
		this.ats = ats;
	}
	public int getComments() {
		return comments;
	}
	public void setComments(int comments) {
		this.comments = comments;
	}
	public int getForwards() {
		return forwards;
	}
	public void setForwards(int forwards) {
		this.forwards = forwards;
	}
	public int getCollects() {
		return collects;
	}
	public void setCollects(int collects) {
		this.collects = collects;
	}
	public int getTopics() {
		return topics;
	}
	public void setTopics(int topics) {
		this.topics = topics;
	}
	
}
