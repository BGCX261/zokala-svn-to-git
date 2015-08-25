<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%><!-- 
<div class="mBlog_linedot"></div> -->
<s:iterator value="minilogs" id="m">
	<div id="topic_list_${m.minilogId}">
		<div class="feedCell" id="topic_list_${m.minilogId}">
			<!--微博内容中 @用户 悬浮提示-->
			<div id="at_25_user" class="at_style" style="display: none;"></div>
			<!--微博内容中 @用户 悬浮提示-->
			<div class="avatar">
				<img src="${m.publisher.avatar}">
			</div>

			<!--悬浮头像、弹出对话框-->
			<div id="user_${m.minilogId}_user"></div>
			<!--悬浮头像、弹出对话框-->

			<!--私信对话框-->
			<div id="Pmsend_to_user_area" style="width: 430px;"></div>
			<!--私信对话框-->

			<!--AT、拉黑对话框-->
			<div id="alert_follower_menu_1"></div>
			<!--AT、拉黑对话框-->

			<div id="button_1" onclick="get_group_choose(1);"></div>

			<!--分组对话框-->
			<div id="global_select_1" class="alertBox" style="display: none"></div>
			<!--分组对话框-->

			<!--备注对话框-->
			<div id="get_remark_1"></div>
			<!--备注对话框-->
			<div class="Contant">

				<div id="topic_lists_${m.minilogId}" style="_overflow: hidden">
					<div class="oriTxt">
						<p>
							<span><a
								title="${m.publisher.nickname}(@${m.publisher.nickname})"
								href="user.html?user.muid=${m.publisher.muid}">${m.publisher.nickname}</a>：
								${m.content} </span>
						</p>
					</div>

					<s:if test="%{#m.from!=null}">
						<div class="blogTxt">
							<div class="top"></div>
							<div class="mid">
								<p>
									<span><a
										href="user.html?user.muid=${m.from.publisher.muid }">${m.from.publisher.nickname
											}</a> : ${m.from.content}</span>
								</p>
								<s:if test="minilog.from.additions!=null">
									<!-- 循环附加信息 -->
									<ul class="imgList">
										<!-- 图片信息 -->
										<s:iterator value="minilog.from.addtions" id="addition">
											<!-- 循环图片 -->
											<li>
												<s:if
													test="addition.type==com.neuallstar.minilog.entity.ADDITION_TYPE_IMAGE">
													<a href="${addition.content} " class="miniImg artZoom"><img
															src="${addition.content}"> </a>
												</s:if>
											</li>
										</s:iterator>
									</ul>
								</s:if>
								<s:if test="%{#session.minilogUser!=null}">
									<a target="_blank"
										href="minilog.html?minilog.minilogId=${m.from.minilogId}">原文评论(${m.from.countComments})</a>
							&nbsp;&nbsp;<a href="javascript:void(0);"
										onclick="get_forward_choose(${m.from.minilogId});">原文转发(${m.from.forwards})</a>
								</s:if>
							</div>
							<div class="bottom"></div>
						</div>
					</s:if>
					<s:if test="m.additions!=null">
						<ul class="imgList">
							<s:iterator value="m.additions" id="addition">
								<li>
									<s:if
										test="addition.type=com.neuallstar.minilog.entity.ADDITION_TYPE_IMAGE">
										<a href="${addition.content}" class="miniImg artZoom"><img
												src="${addition.content}"> </a>
									</s:if>
								</li>
							</s:iterator>
						</ul>
					</s:if>

					<script type="text/javascript">
$(document).ready(function() {
	var objStr1 = "#topic_lists_"+${m.minilogId}+"_a";
	var objStr2 = "#topic_lists_"+${m.minilogId}+"_b";
	$(objStr1).mouseover(function() {
		$(objStr2).show();
	});
	$(objStr1).mouseout(function() {
		$(objStr2).hide();
	});
});
</script>
					<div class="from">
						<s:if test="%{#session.minilogUser!=null}">
							<div class="option">
								<ul>
									<s:if test="%{#m.publisher.muid==#session.minilogUser.muid}">
										<li>
											<a href="javascript:void(0);"
												onclick="get_forward_choose(${m.minilogId});"
												style="cursor: pointer;">删除</a>
										</li>

										<li class="o_line_l">
											|
										</li>
										<li>
											<a href="javascript:void(0);"
												onclick="get_forward_choose(${m.minilogId});"
												style="cursor: pointer;">编辑</a>
										</li>

										<li class="o_line_l">
											|
										</li>
									</s:if>
									<s:else>
										<li>
											<a href="javascript:void(0);"
												onclick="get_forward_choose(${m.minilogId});"
												style="cursor: pointer;">转发 (${m.forwards})</a>
										</li>

										<li class="o_line_l">
											|
										</li>
										<li id="topic_lists_${m.minilogId}_a" class="mobox">
											<a href="javascript:void(0)"
												onclick="favoriteTopic(${m.minilogId});return false;"
												class="moreti"><span class="txt">收藏(${m.collects})</span>
											</a>

										</li>
										<li class="o_line_l">
											|
										</li>
									</s:else>
									<li>
										<a href="javascript:void(0)"
											onclick="replyTopic(${m.minilogId},&#39;reply_area_${m.minilogId}&#39;,&#39;0&#39;);return false;">
											评论(${m.countComments}) </a>
									</li>
								</ul>
							</div>
						</s:if>
						<div class="mycome">
							<!-- 		<s:date name="minilog.time" format="YYYY年MM月dd日 HH:mm:ss"/>
					 -->
							${m.time}
						</div>
					</div>
				</div>
				<div id="reply_area_${m.minilogId}"></div>
				<div id="modify_topic_${m.minilogId}"></div>
				<div id="forward_menu_${m.minilogId}" class="Fbox"></div>

			</div>
		</div>
		<div class="mBlog_linedot"></div>
	</div>
</s:iterator>
<div class="pageStyle">
	<li>
		<div id="page">
			<s:if test="page>0">
				<a href="home.html">首页</a>
				<a href="home.html?page=${page-1}" title="${page}">上一页</a>
			</s:if>
			<b>${page+1}</b>
			<s:if test="minilogs.size>=#session.minilogUser.minilogSize">
				<a href="home.html?page=${page+1}" title="${page+1}">下一页</a>
			</s:if>
		</div>
	</li>
</div>


<!-- 微博 -->