/**
 *com.neuallstar.minilog.entity
 * MinilogConstraint.java
 */
package com.neuallstar.minilog.entity;

/**
 * 微博的常量
 * @author 陈秀能
 * 2011-7-3 上午09:11:30 
 */
public class MinilogConstant {
	/**从微博中提取话题用的#**/
	public static final String SHARPE="#";
	/**从微博中提取提到某人用的@以及分隔符**/
	public static final String AT="@";
	/**从微博中提取提到某人用的@时的分隔符**/
	public static final String SPACE=" ";
	/**抽取@时的生成的链接**/	
	public static final String USER_LINK="user.html?muser.muid="; 
	
	
	
	/**默认每页收藏显示数量 40**/
	public static final int DEFAULT_COLLECT_SIZE=40;
	/**默认每页显示评论数量 40**/
	public static final int DEFAULT_COMMENT_SIZE=40;
	/**默认展开评论显示条数 10**/
	public static final int DEFAULT_COMMENT_EXPAND_SIZE=10;
	/**默认每页显示粉丝数量 30**/
	public static final int DEFAULT_FOLLOWED_SIZE=30;
	/**默认每页显示我关注的用户数量 30**/
	public static final int DEFAULT_FOLLOWING_SIZE=30;
	/**默认每页显示私信数量 30**/
	public static final int DEFAULT_LETTER_SIZE=30;
	/**默认每页显示微博数量 40**/
	public static final int DEFAULT_MINILOG_SIZE=40;
	/**默认每页显示话题数量 10**/
	public static final int DEFAULT_TOPIC_SIZE=10;
	/**默认每页显示推荐用户数量 3**/
	public static final int DEFAULT_RECOMENED_USER_SIZE=3; 
	/**默认css模板 default**/
	public static final String DEFAULT_TEMPLATE="default"; 
	/**默认个人主页背景**/
	public static final String DEFAULT_BACKGROUND="#73CFF1";
	/**默认个人头像**/
	public static final String DEFAULT_AVATAR="templates/default/no.gif";
	/**个人主页展示的粉丝数量**/
	public static final int USER_FOLLOWINGS_SIZE=8;
	/**个人主页展示的关注我的数量**/
	public static final int USER_FOLLOWEDS_SIZE=8;
	
	/**广场默认微博条数 10**/
	public static final int SQUARE_MINILOG_SIZE=10;
	/**广场默认推荐用户数 5**/
	public static final int SQUARE_RECOMENED_USER_SIZE=9;
	/**广场默认话题数量 30**/
	public static final int SQUARE_TOPIC_SIZE=30;
	/**广场默认通知数量 5**/
	public static final int SQUARE_NOTICE_SIZE=5;
	
	/**附加资源类型**/
	public static final String ADDITION_TYPE_IMAGE="image";
	
	/**Minilog的Seesion的名字**/
	public static final String MINILOG_SESSION="minilogUser";
	/**资源路径，用户上传视频/图片/歌曲等放到这个路径下面**/
	public static final String RESOURCES_PATH="resources";
	/**图片资源路径，在资源路径下，用来放用户上传的图片**/
	public static final String IMAGE_PATH="images";
	/**
	 * 以下是明星榜的每一条展示的数量
	 * */
	/**关注用户最多的10个用户**/
	public static final int POPULAR_FOLLOWINGS_SIZE=5;
	/**粉丝最多的10个用户**/
	public static final int POPULAR_FOLLOWEDS_SIZE=5;
	/**发表微博最多的10个用户**/
	public static final int POPULAR_PUBLISHERS_SIZE=5;
	/**发表评论最多的10个用户**/
	public static final int POPULAR_COMMENTERS_SIZE=5;
	/**转发微博最多的10个用户**/
	public static final int POPULAR_FORWARDERS_SIZE=5;
	/**收藏微博最多的10个用户**/
	public static final int POPULAR_COLLECTORS_SIZE=5;
	/**AT其他用户最多的10个用户**/
	public static final int POPULAR_ATERS_SIZE=5;
	/**发表话题最多的10个用户**/
	public static final int POPULAR_TOPICERS_SIZE=5;
	/**被转发最多的10条微博**/
	public static final int POPULAR_FORWARDS_SIZE=10;
	/**被收藏最多的10条微博**/
	public static final int POPULAR_COLLECTS_SIZE=10;
	/**被评论最多的10条微博**/
	public static final int POPULAR_COMMENTS_SIZE=10;
	/**
	 * 最热门的话题的数量
	 * **/
	public static final int POPULAR_TOPICS_SIZE = 10;
	
}
