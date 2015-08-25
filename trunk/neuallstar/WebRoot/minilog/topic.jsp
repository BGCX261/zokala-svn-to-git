<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<strong>新鲜话题：</strong>
<div id="Tacticle" class="acticle">
	<div id="indemo">
	<s:iterator value="topics" id="topic">
		<div id="Tacticle_s"><a href="topic.html?topic.topicId=${topic.topicId}">
		${topic.content}</a>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		</div>
		
		<div id="demo2">
		</div>
		</s:iterator>
	</div>
	<script type="text/javascript">
/*
 两秒后再执行
 */
setTimeout(function() {
	var speed = 40;
	var tab = document.getElementById("Tacticle");
	var tab1 = document.getElementById("Tacticle_s");
	var tab2 = document.getElementById("demo2");
	tab2.innerHTML = tab1.innerHTML;
	function Marquee() {
		if (tab2.offsetWidth - tab.scrollLeft <= 0)
			tab.scrollLeft -= tab1.offsetWidth
		else {
			tab.scrollLeft++;
		}
	}
	var MyMar = setInterval(Marquee, speed);
	tab.onmouseover = function() {
		clearInterval(MyMar)
	};
	tab.onmouseout = function() {
		MyMar = setInterval(Marquee, speed)
	};
}, 2000);
</script>
</div> 