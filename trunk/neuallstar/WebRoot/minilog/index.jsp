<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>我的首页 - 全明星微博</title>

		<script type="text/javascript">
var thisSiteURL = '';
var thisTopicLength = '140';
</script>
		<jsp:include page="baseurl.jsp"></jsp:include>

		<script type="text/javascript" src="templates/default/dialog.js"
			id="dialog_js">
</script>
		<link href="templates/default/dialog.css" rel="stylesheet"
			type="text/css">
			<script type="text/javascript" src="templates/default/jquery.ui.js">
</script>

			<link href="templates/default/t4.css" rel="stylesheet"
				type="text/css">
				<style type="text/css">
body {
	color: #333333;
}

body {
	background-color: #D6D6D6;
}

body {
	background-image: url(templates/default/themebg.jpg) );
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
			<div class="mainL">

				<jsp:include page="publish.jsp"></jsp:include>


				<div style="width: 560px; margin: 0 auto 8px; overflow: hidden">
					<script language="Javascript">
function listTopic(s, lh) {
	var s = 'undefined' == typeof (s) ? 0 : s;
	var lh = 'undefined' == typeof (lh) ? 1 : lh;
	if (lh) {
		window.location.hash = "#listTopicArea";
	}
	$("#listTopicMsgArea")
			.html(
					"<div><center><span class='loading'>内容正在加载中，请稍候……</span></center></div>");
	var myAjax = $.post("ajax.php?mod=topic&code=list", {
		uid : "1",
		is_personal : "1",
		code : "myhome",
		start : s
	}, function(d) {
		$("#listTopicMsgArea").html('');
		$("#listTopicArea").html(d);
	});
}
</script>
				</div>


				<div class="listBox">
					<div id="ajax_reminded"></div>

					<div id="listTopicMsgArea"></div>
					<div id="listTopicArea">
						<div class="Listmain">
							<div class="mBlog_linedot"></div> 

							<!-- 微博 -->
							<jsp:include page="user_minilog.jsp"></jsp:include>
 
						</div>
					</div>
				</div>
			</div>

			<div>
				<div class="mainR">
					<!-- 用户信息 -->
					<jsp:include page="userinfo.jsp"></jsp:include>
					<!-- 用户信息 -->
					<!-- <div class="Vimg"></div> -->
					<div class="blackBox"></div>
					<jsp:include page="search.jsp"></jsp:include>
					<br /> 
					<div class="blackBox"></div>
					<!-- 右部导航 -->
					<jsp:include page="rightnav.jsp"></jsp:include>
					<!-- 右部导航 -->
					<div class="blackBox"></div>
					<jsp:include page="recommend_user2.jsp"></jsp:include>
					<div class="blackBox"></div>
					<jsp:include page="topic2.jsp"></jsp:include>
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
								<input type="hidden" name="FORMHASH" value="08457738d2f80491">
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
		<script type="text/javascript" src="templates/default/common.js">
</script>
		<div id="Report">
			<ul class="manBox">
				<li>
					<div class="T">
						<span class="T_1"
							onmousedown="ReportDrag(this.parentNode.parentNode)">举报不良信息</span>
						<span class="T_2" onclick="ReportHidden()" title="关闭"></span>
					</div>
					<div class="content">
						<form
							action="http://zokala.com/weibo/ajax.php?mod=topic&code=doreport"
							method="POST" enctype="multipart/form-data">
							<input type="hidden" name="FORMHASH" value="08457738d2f80491">
								<table>
									<tbody>
										<tr>
											<td colspan="2">
												<input id="report_tid" name="report_tid"
													style="display: none;">
													<textarea name="report_content" id="report_content"
														class="textBox"></textarea>
											</td>
										</tr>
										<tr>
											<td>
												<select name="report_reason" id="report_reason"
													style="width: 200px">

													<option selected="" value="0">
														--请选择不良信息的类型--
													</option>

													<option value="1">
														内容涉及色情或暴力
													</option>

													<option value="2">
														政治反动举报
													</option>

													<option value="3">
														内容可能侵权
													</option>

													<option value="4">
														内容涉及其他违规事项
													</option>

												</select>
											</td>
										</tr>
									</tbody>
								</table>
								<table style="width: 100%">
									<tbody>
										<tr>
											<td>
												<p style="color: #666; font-size: 12px;">
													如果您在微博中发现有色情、暴力或者其它违规的内容,请提交上述表格，我们将尽快处理。您的隐私会得到严格的保护.
												</p>
											</td>
										</tr>
									</tbody>
								</table>
								<input type="hidden" id="report_url" name="report_url" value="">
									<div class="mIput">
										<input type="button" class="shareI" value="确 定"
											onclick="ReportSub(&#39;report_tid&#39;,&#39;report_content&#39;,&#39;report_reason&#39;);return false;">
											<input type="button" class="shareI" value="取 消"
												onclick="ReportHidden()">
									</div>
						</form>
					</div>
				</li>
			</ul>
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
							<input type="hidden" name="FORMHASH" value="08457738d2f80491">
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
		 
		 


		<script>
function circle_topic() {
	ajax_reminded(1);
	setTimeout('circle_topic();', 45000);
}
setTimeout('circle_topic();', 45000);
</script>
		<jsp:include page="../core/copyright.jsp"></jsp:include>

	</body>
</html>