<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<jsp:include page="baseurl.jsp"></jsp:include>
		<title>明星榜| 全明星微博</title>
		<script type="text/javascript">
var thisSiteURL = '';
var thisTopicLength = '140';
</script>


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
	background-color: #e0e0e0;
}

body {
	background-image: url(http :// zokala.com/ weibo/
		url(templates/default/images/theme/t4/themebg.jpg) ?
		                  
		             201108161525);
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

			<jsp:include page="banner.jsp"></jsp:include>

		</div>
		<jsp:include page="logo.jsp"></jsp:include>
		<script>

function show_divv(spanid) {

	var spanObjs = document.getElementsByTagName('span');
	for ( var i = 0; i < spanObjs.length; i++) {
		if (spanObjs[i].getAttribute('name') == spanid) {
			spanObjs[i].style.display = "";
			document.getElementById(spanid).style.display = 'block';
		}
	}
}

function hidden_divv(spanid) {
	var spanObjs = document.getElementsByTagName('span');
	for ( var i = 0; i < spanObjs.length; i++) {
		if (spanObjs[i].getAttribute('name') == spanid) {
			spanObjs[i].style.display = "none";
			document.getElementById(spanid).style.display = 'none';
		}
	}
}

function formcheckalll(form, prefix, checkall) {
	var checkall = checkall ? checkall : 'chkall';
	for ( var i = 0; i < form.elements.length; i++) {
		var e = form.elements[i];
		if (e.name != checkall && (!prefix || (prefix && e.name.match(prefix)))) {
			e.checked = form.elements[checkall].checked;
		}
	}
}
</script>

		<div class="main3">
			<a name="top_t" id="top_t"></a>
			<div class="H_quare_head">
				<ul>
					<li>
						<a title="查看和关注微博达人" href="javascript:daren()">达人榜</a>
					</li>
					<li>
						<a title="寻找和关注话题" href="star.html#minilogRank">微博榜</a>
					</li>
					<li>
						<a title="寻找和关注话题" href="star.html#topicRank">话题榜</a>
					</li>
				</ul>
			</div>
			<font size="2px" style="margin-left: 20px;"> <a
				href="star.html">总排行榜</a>| <a href="star.html?time=today">今日排行榜</a>|
				<a href="star.html?time=week">本周排行榜</a>| <a
				href="star.html?time=month">本月排行榜</a>| <a
				href="star.html?time=season">本季排行榜</a>| <a
				href="star.html?time=year">年度排行榜</a> </font>
			<div class="main3Box_m">
				<div class="topL">
					<div class="Tnav">
						<div class="Pname">
							1、粉丝排行榜
						</div>
					</div>
					<ul class="toplu">
						<s:iterator value="followeds" id="fd">
							<li>
								<div class="daren">
									<div class="daren2">
										<img src="${fd.avatar}">
									</div>

									<div class="daren3">
										<a target="_blank" href="user.html?muser.muid=${fd.muid}">${fd.nickname}</a>
										<br>
											${fd.followeds}个粉丝 
									</div>
								</div>
							</li>
						</s:iterator>
					</ul>
				</div>
				<div class="topL">
					<div class="Tnav">
						<div class="Pname">
							2、关注达人榜
						</div>
					</div>
					<ul class="toplu">
						<s:iterator value="followings" id="fi">
							<li>
								<div class="daren">
									<div class="daren2">
										<img src="${fi.avatar}">
									</div>

									<div class="daren3">
										<a target="_blank" href="user.html?muser.muid=${fi.muid}">${fi.nickname}</a>
										<br>
											关注${fi.followings}人 
									</div>
								</div>
							</li>
						</s:iterator>
					</ul>
				</div>
				<div class="topL">
					<div class="Tnav">
						<div class="Pname">
							3、微博达人榜
						</div>
					</div>
					<ul class="toplu">
						<s:iterator value="publishers" id="p">
							<li>
								<div class="daren">
									<div class="daren2">
										<img src="${p.avatar}">
									</div>

									<div class="daren3">
										<a target="_blank" href="user.html?muser.muid=${p.muid}">${p.nickname}</a>
										<br>
											共${p.minilogs}条微博 
									</div>
								</div>
							</li>
						</s:iterator>
					</ul>
				</div>
				<div class="topL">
					<div class="Tnav">
						<div class="Pname">
							4、评论达人榜
						</div>
					</div>
					<ul class="toplu">
						<s:iterator value="commenters" id="p">
							<li>
								<div class="daren">
									<div class="daren2">
										<img src="${p.avatar}">
									</div>

									<div class="daren3">
										<a target="_blank" href="user.html?muser.muid=${p.muid}">${p.nickname}</a>
										<br>
											共${p.comments}条评论 
									</div>
								</div>
							</li>
						</s:iterator>
					</ul>
				</div>
				<div class="topL">
					<div class="Tnav">
						<div class="Pname">
							5、转发达人榜
						</div>
					</div>
					<ul class="toplu">
						<s:iterator value="forwarders" id="p">
							<li>
								<div class="daren">
									<div class="daren2">
										<img src="${p.avatar}">
									</div>
									<div class="daren3">
										<a target="_blank" href="user.html?muser.muid=${p.muid}">${p.nickname}</a>
										<br>
											共${p.forwards}条转发 
									</div>
								</div>
							</li>
						</s:iterator>
					</ul>
				</div>
				<div class="topL">
					<div class="Tnav">
						<div class="Pname">
							6、收藏达人榜
						</div>
					</div>
					<ul class="toplu">
						<s:iterator value="collectors" id="p">
							<li>
								<div class="daren">
									<div class="daren2">
										<img src="${p.avatar}">
									</div>
									<div class="daren3">
										<a target="_blank" href="user.html?muser.muid=${p.muid}">${p.nickname}</a>
										<br>
											共${p.collects}条收藏 
									</div>
								</div>
							</li>
						</s:iterator>
					</ul>
				</div>

				<div class="topL">
					<div class="Tnav">
						<div class="Pname">
							7、话题达人榜
						</div>
					</div>
					<ul class="toplu">
						<s:iterator value="topicers" id="p">
							<li>
								<div class="daren">
									<div class="daren2">
										<img src="${p.avatar}">
									</div>
									<div class="daren3">
										<a target="_blank" href="user.html?muser.muid=${p.muid}">${p.nickname}</a>
										<br>
											共${p.topics}个话题 
									</div>
								</div>
							</li>
						</s:iterator>
					</ul>
				</div>

				<div class="topL">
					<div class="Tnav">
						<div class="Pname">
							8、@ 达人榜
						</div>
					</div>
					<ul class="toplu">
						<s:iterator value="aters" id="p">
							<li>
								<div class="daren">
									<div class="daren2">
										<img src="${p.avatar}">
									</div>
									<div class="daren3">
										<a target="_blank" href="user.html?muser.muid=${p.muid}">${p.nickname}</a>
										<br>
											共 @ ${p.ats}人次 
									</div>
								</div>
							</li>
						</s:iterator>
					</ul>
				</div>


				<div class="tagW" id="tagWWW">

					 <form method="post" name="HotTagForm" id="HotTagForm">

						<div class="tagv1">
							<div class="tagspan">
								<span>最热门评论</span>
							</div>
							<ul class="tagv1lu">
								<s:iterator value="comments" id="t">
									<li>
										<span name="guanzu_tag" style="display: none;"> </span>
										<span class="tagvL"> ${t.content} </span>
										<span class="tagvR"><a
											href="minilog.html?minilog.minilogId=${t.minilogId}"
											target="_blank">评论(${t.countComments })</a> </span>

									</li>
								</s:iterator>
							</ul>


						</div>
					</form>



					<form method="post" name="guanzuForm" id="guanzuForm">
						<div class="tagv1 tagv2">
							<div class="tagspan">
								<span>最热门转发</span>
							</div>
							<ul class="tagv1lu">
								<s:iterator value="forwards" id="f">
									<li>
										<span name="guanzu_tag" style="display: none;"> </span>
										<span class="tagvL"> ${f.content} </span>
										<span class="tagvR"><a
											href="minilog.html?minilog.minilogId=${f.minilogId}"
											target="_blank">转发(${f.forwards})</a> </span>

									</li>
								</s:iterator>
							</ul>
						</div>
					</form>




					<form method="post" name="HotTagForm" id="HotTagForm">

						<div class="tagv1">
							<div class="tagspan">
								<span>最热门话题</span>
							</div>
							<ul class="tagv1lu">
								<s:iterator value="topics" id="t">
									<li>
										<span name="guanzu_tag" style="display: none;"> </span>
										<span class="tagvL"> <a
											href="topic.html?topic.content=${t.content}"
											title="${t.content}" target="_blank">${t.content} </a> </span>
										<span class="tagvR">${t.countMinilogs }条相关微博</span>

									</li>
								</s:iterator>
							</ul>
						</div>
					</form>

					<iframe id="guanzu_tag_frame" name="guanzu_tag_frame" width="0"
						height="0" marginwidth="0" frameborder="0" src="about:blank"></iframe>
					<form method="post"
						action="http://zokala.com/weibo/index?mod=other&code=add_favor_tag"
						enctype="multipart/form-data" name="guanzuForm"
						target="guanzu_tag_frame" id="guanzuForm">
						<div class="tagv1 tagv2">
							<div class="tagspan">
								<span>最热门收藏</span>
							</div>
							<ul class="tagv1lu">
								<s:iterator value="collects" id="f">
									<li>
										<span name="guanzu_tag" style="display: none;"> </span>
										<span class="tagvL"> ${f.content} </span>
										<span class="tagvR"><a
											href="minilog.html?minilog.minilogId=${f.minilogId}"
											target="_blank">收藏(${f.collects})</a> </span>

									</li>
								</s:iterator>
							</ul>



						</div>
					</form>


				</div>
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
							<input type="hidden" name="FORMHASH" value="6796d1d6681b5d6e">
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

		<script type="text/javascript">
$(document).ready(function() {
	$('.goTop').click(function(e) {
		e.stopPropagation();
		$('html, body').animate( {
			scrollTop : 0
		}, 300);
		backTop();
		return false;
	});
});
</script>
		<div id="backtop" class="backTop" style="display: none;">
			<a href="http://zokala.com/#" class="goTop"></a>
		</div>
		<script type="text/javascript">
window.onscroll = backTop;
function backTop() {
	var scrollTop = document.documentElement.scrollTop
			|| document.body.scrollTop;
	if (scrollTop == 0) {
		document.getElementById('backtop').style.display = "none";
	} else {
		document.getElementById('backtop').style.display = "block";
	}
}
backTop();
</script>


		<jsp:include page="copyright.jsp"></jsp:include>
	</body>
</html>