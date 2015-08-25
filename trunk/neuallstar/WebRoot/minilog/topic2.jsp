<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<div class="dlblank">
	<h3 class="htitle2">
		最新话题
	</h3>
	<p></p>
	<s:iterator value="topics" id="topic">
		<p style="margin-left: 10px;">
			<a href="topic.html?topic.topicId=${topic.topicId }">${topic.content
				}</a>
		</p>

	</s:iterator>
</div>
