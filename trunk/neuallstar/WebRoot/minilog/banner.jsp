<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<div class="headerNav">
	<ul class="hleft">
		<li>
			<a href="default.html" title="查看最新发布的微博">微博广场</a> |
		</li>
		<li>
			<a href="star.html" title="寻找微博最活跃的用户">明星榜</a>
		</li>

	</ul>
	<s:if test="%{#session.minilogUser!=null}">
		<ul class="hright">
			<li>
				<a
					title="<s:property
						value="#session.minilogUser.nickname" />"
					href="index.html">我的首页</a> |
			</li>
			<li>
				<a
					title="<s:property
						value="#session.minilogUser.nickname" />"
					href="user.html"><s:property
						value="#session.minilogUser.nickname" /> </a> |
			</li>
			<li>
				<a href="letter.html" title="私信">私信</a> |
			</li>
			<li>
				<a href="setting.html" title="设置用户昵称、头像等">设置</a>
			</li>
		</ul>
	</s:if>
</div>
<div class="headerBg"></div>