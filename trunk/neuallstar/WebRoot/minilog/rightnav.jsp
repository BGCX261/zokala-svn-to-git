<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%> 
<s:if test="%{#session.minilogUser!=null}">
	<ul class="boxRNav2">


		<li class="index current">

			<a href="index.html" hidefocus="true" title="我的首页">我的首页</a>
		</li> 
		<li class="mypub">

			<a href="user.html" title="我的微博">我的微博</a>
		</li>
		<script type="text/javascript">
$(document).ready(function() {
	var objSt = ".myfav";
	$(objSt).mouseover(function() {
		$(objSt + " i").show();
	});
	$(objSt).mouseout(function() {
		$(objSt + " i").hide();
	});
});
</script>

		<li class="myfav">

			<a href="mycollect.html" hidefocus="true" title="我的收藏">我的收藏</a>

		</li>
		<script type="text/javascript">
$(document).ready(function() {
	var objSt = ".letter";
	$(objSt).mouseover(function() {
		$(objSt + " i").show();
	});
	$(objSt).mouseout(function() {
		$(objSt + " i").hide();
	});
});
</script>

		<li class="letter">

			<a href="mycomment.html" hidefocus="true" title="我的评论">我的评论</a>

		</li>


		<li class="about">

			<a href="atme.html" hidefocus="true" title="提到我的">提到我的</a>
		</li>
		<li class="letter">

			<a href="letter.html" hidefocus="true" title="我的私信">我的私信</a>
		</li>

	</ul>
</s:if>