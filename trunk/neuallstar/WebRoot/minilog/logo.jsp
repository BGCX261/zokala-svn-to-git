<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<div class="logow">
	<div class="logo">
		<a href="index.html" title="全明星微博"></a>
	</div>
	<!-- 消息提示框 开始 -->

	<script type="text/javascript">
function tagBox_close() {
	var obj = document.getElementById("tagBox_1");
	obj.style.visibility = "hidden";
}
</script>
	<div class="tagBox" id="tagBox_1"
		style="display: none; visibility: hidden;">
		<div id="tagBoxContent_1">
			<ul>


			</ul>
		</div>
		<div class="tagBox_del">
			<a href="javascript:tagBox_close();" title="关闭" javascript:void(0)=""><img
					src="templates/default/imgdel.gif"> </a>
		</div>
	</div>
	<!-- 消息提示框 结束 -->

</div>