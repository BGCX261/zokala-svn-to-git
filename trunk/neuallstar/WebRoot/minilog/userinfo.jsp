<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<s:if test="%{#session.minilogUser!=null}">
	<div class="sideBox">
		<div class="avatar2">

			<img src="<s:property value="#session.minilogUser.avatar" />"
				alt="<s:property value="#session.minilogUser.nickname" />">
			</a>

		</div>
		<div class="avatar2_info">
			<span><a
				href="user.html?user.muid=<s:property value="#session.minilogUser.muid" />"
				title="@<s:property value="#session.minilogUser.nickname" />"><s:property
						value="#session.minilogUser.nickname" /> </a> </span>
			<br>

			<br>
		</div>
	</div>


	<div class="sideBox">
		<div class="person_atten_l">
			<p>
				<span class="num"><a href="following.html"
					title="<s:property value="#session.minilogUser.nickname" />关注的"><s:property
							value="#session.minilogUser.followeds" /> </a> </span>
			</p>
			<p>
				<a href="following.html"
					title="<s:property value="#session.minilogUser.nickname" />关注的">关注</a>
			</p>
		</div>
		<div class="person_atten_l">
			<p>
				<span class="num"><a href="followed.html"
					title="关注<s:property value="#session.minilogUser.nickname" />的"><s:property
							value="#session.minilogUser.followings" /> </a> </span>
			</p>
			<p>
				<a href="followed.html"
					title="关注<s:property value="#session.minilogUser.nickname" />的">粉丝</a>
			</p>
		</div>
		<div class="person_atten_r">
			<p>
				<span class="num"><a href="user.html?user.muid=<s:property value="#session.minilogUser.muid" />"
					title="<s:property value="#session.minilogUser.nickname" />的微博"><s:property
							value="#session.minilogUser.minilogs" /> </a> </span>
			</p>
			<p>
				<a
					href="user.html?muser.muid=<s:property value="#session.minilogUser.muid" />"
					title="<s:property value="#session.minilogUser.nickname" />的微博">微博</a>
			</p>
		</div>
	</div>
</s:if>
