<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<div class="dlblank">
	<h1 class="htitle3">
		公告
	</h1>
	<p></p>
	<s:iterator value="notices" id="notice">
	<p>
		<a href="notice.html?notice.noticeId=${notice.noticeId }">${notice.content}</a>
	</p>
	
</s:iterator> 
</div>
<div class="visBox"> 
<p></p>
	<h1 class="htitle3">
		新功能
	</h1> 
	<p>
		<a href="../waimai/index.jsp">全明星外卖区</a>
	</p>
 
</div>