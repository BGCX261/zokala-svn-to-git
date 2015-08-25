<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<div class="member_list_top">
	<div class="left_user_info">
		<div class="avatar_left">
			<a title="" href="user.html?muser.muid=${muser.muid}"><img
					height="128" width="128" title="${muser.nickname}"
					src="${muser.avatar}"> </a>
		</div>
		<div class="avatar2_info">
			<p class="left_t_nick_name">
				<strong title="${muser.nickname}">${muser.nickname}</strong>
				<!--备注-->
				<span id="remarklist_1"></span>
				<!--备注-->
 
			</p>

			<p class="left_t2">
				<a href="user.html?muser.muid=${muser.muid}">user.html?muser.muid=${muser.muid}</a>
			</p>


			<p class="left_t2">
				自我介绍：${muser.introduction}
			</p>
			<s:if test="%{muser.muid!=#session.minilogUser.muid}">
				<p class="left_t2">
					<s:if test="%{#isFollowing==true}">
						<a href="javascript:follow(${muser.muid},'follow_${muser.muid}','')" /> <img alt="取消关注"
								src="templates/default/accept_2.gif"> </a>
					</s:if>
					<s:else>
						<a href="javascript:follow(${muser.muid},'follow_${muser.muid}','add')" /> <img alt="关注"
								src="templates/default/add_2.gif"> </a>
					</s:else>
				</p>
				<p class="left_t2">
					私信
				</p>
			</s:if>

		</div>
	</div>
</div>