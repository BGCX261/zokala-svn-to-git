<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<h1 class="htitle2">
	新人推荐
</h1>

<ul class="userlist">
	<s:iterator value="musers" id="muser">
		<li>
			<a target="_blank" href="user.html?muser.muid=${muser.muid }"> <img
					title="${muser.nickname }" src="${muser.avatar }">${muser.nickname
				} </a>
		</li>
	</s:iterator>
</ul>
