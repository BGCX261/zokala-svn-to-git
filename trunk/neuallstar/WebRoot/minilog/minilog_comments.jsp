<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<div class="comheader">
	<span class="mleft font14px">评论</span>
	<span class="mright">共<font class="fontRed"> 1 </font>条</span>
</div>
<div id="replyListArea">
	<success></success>
	<style type="text/css">
.media_user_list {
	margin: -13px 0 0 -8px; *
	margin: -13px 0 0 -63px;
}
</style>
	<ul class="followList">
		<s:iterator value="comments" id="c">
			<li id="reply_list_${c.commentId}">
				<div style="overflow: hidden;" class="fBox_l">
					<!--微博内容中 @用户 悬浮提示-->
					<div style="display: none;" class="at_style"
						id="at_${c.commentId}_user"></div>
					<!--微博内容中 @用户 悬浮提示-->
					<div class="avatar">
						<img src="${c.commenting.avatar}">
					</div>

					<!--悬浮头像、弹出对话框-->
					<div id="user_${c.commentId}_user"></div>
					<!--悬浮头像、弹出对话框-->

					<!--私信对话框-->
					<div style="width: 430px;" id="Pmsend_to_user_area"></div>
					<!--私信对话框-->


					<div onclick="get_group_choose(${c.commentId});" id="button_1"></div>

					<!--分组对话框-->
					<div style="display: none;" class="alertBox"
						id="global_select_${c.commentId}"></div>
					<!--分组对话框-->

					<!--备注对话框-->
					<div id="get_remark_1"></div>
					<!--备注对话框-->
				</div>
				<div style="" class="Contant">
					<div style="" id="reply_lists_${c.commentId}">
						<div class="oriTxt2">
							<p>
								<span style="width: 480px;" class="mleft"> <a
									href="user.html?muser.muid=${c.commenting.muid}"
									title="${c.commenting.nickname}">${c.commenting.nickname}</a>:
									<s:if test="%{#c.commented!=null}">
								回复&nbsp;<a href="user.html?muser.muid=${c.commented.muid}">${c.commented.nickname}</a>：&nbsp; <em
											id="modify_reply_list_${c.commentId}">${c.content}</em>
										<span class="fontGray"></span>
									</s:if> <s:else>
${c.content}
								</s:else> </span>
							</p>
						</div>



						<div class="from">
							<s:if test="%{#session.minilogUser!=null}">
								<div class="option">
									<ul>
										<li>
											<a style="cursor: pointer;"
												onclick="get_forward_choose(${c.commentId});"
												href="javascript:void(0);">转发 </a>
										</li>
										<li class="o_line_l">
											|
										</li>
										<li>
											<a
												onclick="replyTopic(${c.commentId},'reply_area_${c.commentId}','0');return false;"
												href="javascript:void(0)">回复 </a>
										</li>
										<s:if test="%{#c.commenting.muid==#session.minilogUser.muid}">
											<li class="o_line_l">
												|
											</li>
											<li class="mobox" id="topic_lists_${c.commentId}_a">
												<a class="moreti" href="javascript:void(0)"
													onclick="deleteTopic(${c.commentId},'reply_list_${c.commentId}');return false;"><span
													class="txt">删除</span>
												</a>


											</li>
										</s:if>
									</ul>
								</div>
							</s:if>
							<div class="mycome">
								${c.time}
							</div>
						</div>
					</div>
					<div class="topicView" id="reply_area_${c.commentId}"></div>
					<div id="modify_topic_${c.commentId}"></div>
					<div class="Fbox" id="forward_menu_${c.commentId}"></div>
				</div>
			</li>
		</s:iterator>
	</ul>

	<div id="replyListMsgArea"></div>
</div>
<s:if test="%{#session.minilogUser!=null}">
	<div class="pageStyle">
		<li>
			<div id="page">
				<s:if test="page>0">
					<a href="minilog.html?minilog.minilogId=${minilog.minilogId}">首页</a>
					<a
						href="minilog.html?minilog.minilogId=${minilog.minilogId}&page=${page-1}"
						title="2">上一页</a>
				</s:if>
				<b>${page+1}</b>
				<s:if test="minilogs.size>=#session.minilogUser.minilogSize">
					<a
						href="minilog.html?minilog.minilogId=${minilog.minilogId}&page=${page+1}"
						title="${page+1}">下一页</a>
				</s:if>
			</div>
		</li>
	</div>
</s:if>