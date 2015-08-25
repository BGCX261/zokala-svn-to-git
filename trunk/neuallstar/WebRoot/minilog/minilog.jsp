<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!-- saved from url=(0051)http://zokala.com/weibo/index.php?mod=topic&code=23 -->
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<jsp:include page="baseurl.jsp"></jsp:include>
		<title>${minilog.content}</title>

		<script type="text/javascript" src="templates/default/dialog.js"
			id="dialog_js">
</script>
		<link href="templates/default/dialog.css" rel="stylesheet"
			type="text/css">
			<script type="text/javascript" src="templates/default/jquery.ui.js">
</script>
		<link href="templates/default/t4.css" rel="stylesheet" type="text/css">
			<style type="text/css">
body {
	color: #333333;
}

body {
	background-color: #e0e0e0;
}

body {
	background-image: url(http :// zokala.com/ weibo/
		url(templates/default/images/theme/t4/themebg.jpg) ?     201108142120)
		;
}

body {
	background-repeat: no-repeat;
}

body {
	background-attachment: scroll;
}

body {
	color: #333333;
}

a:link {
	color: #2965B1;
}

a.artZoom {
	cursor: url(templates/default/magnifier_b.cur), pointer;
}

.artZoomBox a.maxImgLink {
	cursor: url(templates/default/magnifier_s.cur), pointer;
}
</style>
	</head>
	<body>
		<div class="header"> 
				<!-- 顶部导航栏 -->
				<jsp:include page="banner.jsp"></jsp:include>
				<!-- 顶部导航栏 --> 
		</div>
<jsp:include page="logo.jsp"></jsp:include>
		<div class="main">
			<div class="mainL" style="padding-bottom: 160px;">
				<jsp:include page="minilog_log.jsp"></jsp:include>
				<div id="modify_topic_23"></div>

				<div class="blackBox"></div>

					<jsp:include page="minilog_comments.jsp"></jsp:include>
					
				<script language="Javascript">
function replyTopicHtml(tid, eid) {
	var rthtml = $('#' + eid).html();
	if ('' == rthtml) {
		rthtml = '<div class="blogTxt" style="float:right"><div class="top_2"></div><div class="mid"><p class="comment_p2 h10px"><textarea id="reply_area_content_'
				+ tid
				+ '" cols="65" rows="2" class="sp_3"></textarea><input id="rcbtn_'
				+ tid
				+ '" onclick="publishSubmit(\'reply_area_content_'
				+ tid
				+ '\','
				+ tid
				+ ',\'rl_23\');return false;" type="button"  class="sBtn_2" value="确 定"/></p></div><div class="bottom"></div></div><scr'
				+ 'ipt>$("#reply_area_content_'
				+ tid
				+ '").bind("keydown",function(event){event = event || window.event;if(event.keyCode==13 && event.ctrlKey) { $("#rcbtn_'
				+ tid + '").click(); } });</scr' + 'ipt>';
	} else {
		rthtml = '';
	}
	$('#' + eid).html(rthtml);
}
function replyList(pg) {
	window.location.hash = "#replyListArea";

	var pg = 'undefined' == typeof (pg) ? 0 : pg;
	var myAjax = $.post('ajax.php?mod=topic&code=list_reply', {
		tid : 23,
		p : pg
	}, function(d) {
		$('#replyListArea').html(d);
	});
}
</script>
				<div class="blackBox"></div>
				<a name="replyTopic" id="replyTopic"></a>
				<div class="one_comment">
					<li>
						<div class="viewfb">
							<script type="text/javascript">
$(document).ready(function() {
	$(".reply_menu_bqb_c").click(function() {
		$("#reply_face").show();
	});
});
</script>
							<div class="menuf">
								<div class="menuf_bq">
									<b class="reply_menu_bqb_c"><a href="javascript:void(0);"
										onclick="topic_face(&#39;reply_face&#39;,&#39;i_already&#39;);return false;">表情</a>
									</b>
									<!--表情显示层-->
									<div id="reply_face" class="reply_face"></div>
									<!--表情显示层-->
								</div>
							</div>
						</div>
						<textarea name="content" id="i_already"
							onkeyup="javascript:checkWord(140,event)" rows="3"
							class="sp sp_3 view_review"></textarea>
						<input name="replytid" type="hidden" id="replytid" value="23">
					</li>
					<li class="view_r">
						<div class="view_r1">
							<input name="topictype" type="checkbox" id="topictype"
								value="reply" onclick="select_checked();">
								同时转发给关注我的人 
						</div>
						<div class="view_r2">
							<style type="text/css">
ul.mycon li {
	width: 65px;
}
</style>
							<ul class="mycon">
								<li>
									还可以输入
								</li>
								<li id="wordCheck">
									<span style="color: #FF0000;">140</span>
								</li>
								<li style="width: 14px;">
									字
								</li>
							</ul>
						</div>
						<div class="view_r3">
							<input id="publishSubmit"
								onclick="publishSubmit(&#39;i_already&#39;,&#39;replytid&#39;,&#39;rl&#39;,&#39;topictype&#39;);return false;"
								type="button" value="发评论" class="sBtn_2" title="按Ctrl+Enter直接发布">
						</div>
					</li>
				</div>
			</div>
			<script language="Javascript">
//字数统计 STR
function checkWord(len, evt) {
	if (evt == null)
		evt = window.event;
	var src = evt.srcElement ? evt.srcElement : evt.target;
	var str = src.value.trim();//
	myLen = 0;
	i = 0;
	for (; (i < str.length) && (myLen <= len * 2); i++) {
		if (str.charCodeAt(i) > 0 && str.charCodeAt(i) < 128)
			myLen++;
		else
			myLen += 2;
	}
	var mydiv = document.getElementById("wordCheck");
	if (myLen > len * 2) {
		src.value = str.substring(0, i - 1);
	} else {
		document.getElementById("wordCheck").innerHTML = "<span style='color:#FF0000;'>"
				+ Math.floor((len * 2 - myLen) / 2) + "</span>";
	}
}
String.prototype.trim = function() {
	return this.replace(/(^\s*)|(\s*$)/g, "");
}
//字数统计 END
$("#i_already").bind('keydown', function(event) {
	event = event || window.event;
	if (event.keyCode == 13 && event.ctrlKey) {
		$("#publishSubmit").click();
	}
});
</script>
			<div>
				<div class="mainR">
					<jsp:include page="userinfo3.jsp"></jsp:include>
					<div class="blackBox"></div>
					<jsp:include page="search.jsp"></jsp:include>

					<div class="blackBox"></div>
					<jsp:include page="rightnav.jsp"></jsp:include>
					<div class="blackBox"></div>

				</div>
			</div>
			<div id="add_remark_1" class="alertBox" style="display: none">
				<ul class="manBox">
					<li>
						<div class="tt1">
							<span>设置备注名</span>
							<div class="mclose"
								onclick="getElementById(&#39;add_remark_1&#39;).style.display=(getElementById(&#39;add_remark_1&#39;).style.display==&#39;none&#39;)?&#39;&#39;:&#39;none&#39;"></div>
						</div>
						<div class="mWarp">
							<form
								action="http://zokala.com/weibo/ajax.php?mod=topic&code=add_remark"
								method="POST" name="remarkform"
								onsubmit="publishSubmit_remark(&#39;remark_1&#39;,1);return false;">
								<input type="hidden" name="FORMHASH" value="e9a5a06b5345c13a">
									给朋友加个备注名，方便认出他是谁（0~6个字符）
									<table>
										<tbody>
											<tr>
												<td>
													<input name="remark_1" type="text" id="remark_1"
														class="text-area2" value="" size="6" maxlength="6">
												</td>
												<td align="left">
													<input type="button" class="shareI" value="保 存"
														onclick="publishSubmit_remark(&#39;remark_1&#39;,1);return false;">
												</td>
											</tr>
										</tbody>
									</table>
							</form>
						</div>
					</li>
				</ul>
			</div>

		</div>



		<!--添加分组对话框-->
		<div id="add_group" class="alertBox alertBox_2" style="display: none">
			<ul class="manBox">
				<li>
					<div class="tt1">
						<span>请输入分组名</span>
						<div class="mclose"
							onclick="document.getElementById(&#39;add_group&#39;).style.display=&#39;none&#39;"></div>
					</div>
					<div class="mWarp">
						<iframe id="groupframe" name="groupframe" width="0" height="0"
							marginwidth="0" frameborder="0" src="about:blank"></iframe>
						<form
							action="http://zokala.com/weibo/ajax.php?mod=topic&code=do_group"
							method="POST" name="publisher_group_form" target="groupframe"
							id="publisher_group_form"
							onsubmit="publishSubmit_group(&#39;publisher_group&#39;,0,&#39;add&#39;);return false;">
							<input type="hidden" name="FORMHASH" value="e9a5a06b5345c13a">
								<table border="0" cellspacing="0" cellpadding="0" width="100%">
									<tbody>
										<tr>
											<td>
												<input name="groupName" type="text" id="groupName"
													class="Ainp">
											</td>
											<td align="center">
												<input id="groupSubmit" type="button" class="shareI"
													value="创 建"
													onclick="GroupSubmit(&#39;groupName&#39;,0,&#39;add&#39;);return false;"
													title="按Ctrl+Enter直接创建">
											</td>
										</tr>
									</tbody>
								</table>
						</form>
					</div>
				</li>
			</ul>
		</div>

		<script language="Javascript">
$("#groupName").bind('keydown', function(event) {
	event = event || window.event;
	if (event.keyCode == 13 && event.ctrlKey) {
		$("#groupSubmit").click();
	}
});
</script>

		<script type="text/javascript">
function ReportBox(tid) {
	//alert(tid);
	document.getElementById("report_tid").value = tid;
	document.getElementById("Report").style.display = "inline";

}
function ReportHidden() {
	if (document.getElementById("Report")) {
		document.getElementById("Report").style.display = "none";
		document.getElementById('report_content').value = '';
		document.getElementById('report_reason').value = '0';
	}
}
function ReportDrag(str) {
	var e = window.event || arguments.callee.caller.arguments[0];
	var deltaX = e.clientX - parseInt(str.offsetLeft);
	var deltaY = e.clientY - parseInt(str.offsetTop);
	var deltaH = document.body.clientHeight;
	var deltaW = document.body.clientWidth;
	var drag = true;
	str.onmousemove = function(ev) {
		ev = ev ? ev : window.event;
		if (drag) {
			var Y = ev.clientY - deltaY;
			var X = ev.clientX - deltaX;
			var H = deltaH - str.offsetHeight;
			var W = deltaW - str.offsetWidth;
			if (Y > 0 || X > 0) {
				if (Y >= H) {
					str.style.top = H + "px";
				} else {
					str.style.top = Y + "px";
				}
				if (X >= W) {
					str.style.left = W + "px";
				} else {
					str.style.left = X + "px";
				}
			}
			if (Y <= 0) {
				str.style.top = 0;
			}
			if (X <= 0) {
				str.style.left = 0;
			}
			//str.setCapture();
		}
	}
	str.onmouseup = function() {
		drag = false;
		//str.releaseCapture();
	}
}
</script>

		<!-- JS消息提示层 show_message('发布成功') -->
		<div id="show_message_area"></div>
		<!-- Ajax端内容返回 -->
		<div id="ajax_output_area"></div>


		<jsp:include page="copyright.jsp"></jsp:include>
	</body>
</html>