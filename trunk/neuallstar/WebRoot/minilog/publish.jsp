<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<div class="issueBox">
	<div class="fbqCount">
		<div class="fLeft">
			<a href="javascript:void()" style="cursor: pointer">@</a>提起某人&nbsp;&nbsp;
			<a href="javascript:void()" style="cursor: pointer">#</a>话题
			<a href="javascript:void()" style="cursor: pointer">#</a>
		</div>
		<style type="text/css">
ul.mycon li {
	width: 65px;
}
</style>
		<ul class="mycon">
			<li>
				还可以输入
			</li>
			<li style="width: auto">
				<span id="wordCheck" style="font-family: Georgia; font-size: 24px;">140</span>
			</li>
			<li style="width: 14px;">
				字
			</li>
		</ul>
	</div>
	<div class="box_1" style="display: block">
		<textarea name="content" id="i_already"
			onkeyup="javascript:checkWord(140,event,&#39;wordCheck&#39;)"></textarea>
		<input name="topic_type" type="hidden" id="topic_type" value="">

		<!--应用 Begin-->
		<input name="item" type="hidden" id="mapp_item" value="">
		<input name="item_id" type="hidden" id="mapp_item_id" value="">
		<!--应用 End-->
	</div>
	<div class="box_3">
		<iframe id="uploadframe" name="uploadframe" width="0" height="0"
			marginwidth="0" frameborder="0" src="about:blank"></iframe>
		<script type="text/javascript">
$(document).ready(function() {
	$(".menu_tqb_c").click(function() {
		$(".menu_tqb").show();
		$(".menu_spb").hide();
		$('#showface').hide();
		$('.menu_htb').hide();
		$('.menu_vsb').hide();
	});
	$('#pubImg').click(function() {
		$("#publisher_file").style.posLeft = event.x - offsetWidth / 2;
		$("#publisher_file").style.posTop = event.y - offsetHeight / 2;
	});
	$(".menu_tqb_c1").click(function() {
		$(".menu_tqb").hide();
	});
	$(".menu_tqb_c2").click(function() {
		$(".menu_tqb").hide();
	});
	$("#publishSubmit").click(function() {
		$(".menu_tqb").hide();
	});

	$(".menu_spb_c").click(function() {
		$(".menu_spb").show();
		$(".menu_tqb").hide();
		$('#showface').hide();
		$('.menu_htb').hide();
		$('.menu_vsb').hide();
	});
	$(".menu_spb_c1").click(function() {
		$(".menu_spb").hide();
	});

	$(".menu_bqb_c").click(function() {
		$("#showface").show();
		$(".menu_tqb").hide();
		$(".menu_spb").hide();
		$('.menu_htb').hide();
		$('.menu_vsb').hide();
	});
	$('#showface').click(function() {
		return false;
	});

	$(".menu_htb_c").click(function() {
		$(".menu_htb").show();
		$(".menu_spb").hide();
		$(".menu_tqb").hide();
		$('#showface').hide();
		$('.menu_vsb').hide();
		$('body').one('click', function() {
			$('.menu_htb').hide();
		});
		return false;
	});
	$('.menu_htb').click(function() {
		return false;
	});

	$(".menu_vsb_c").click(function() {
		getVoteAvtivityFromIndex('vote_publish', 'con_vote_content_1');
		$(".menu_vsb").show();
		$(".menu_tqb").hide();
		$(".menu_spb").hide();
		$('#showface').hide();
		$('.menu_htb').hide();
	});
	$(".menu_vsb_c1").click(function() {
		$(".menu_vsb").hide();
	});

	$("#viewImgDiv img").each(function() {
		if ($(this).width() > $(this).parent().width()) {
			$(this).width("100%");
		}
	});
});

//-----------------------------------
function setTab(name, cursel, n) {
	for (i = 1; i <= n; i++) {
		var menu = document.getElementById(name + i);
		var con = document.getElementById("con_" + name + "_" + i);
		menu.className = i == cursel ? "vhover" : "";
		con.style.display = i == cursel ? "block" : "none";
	}
}
</script>
		<div class="menu">
			<div class="menu_tq">
				<b class="menu_tqb_c">图片</b>
				<div class="menu_tqb">
					<form
						action="fileupload.html"
						method="POST" enctype="multipart/form-data"
						name="publisher_image_form" target="uploadframe"
						id="publisher_image_form" style="display: block;"> 
						<input type="file" id="publisher_file" name="topic" size="1"
							onchange="fileSubmit();"
							style="position: absolute; filter: alpha(opacity =                                     0); opacity: 0; width: 160px; * width: 90px; _width: 110px; margin: 5px 0 0 0; height: 25px;">
					</form>

					<p class="menu_pi" id="insertImgDiv">
						<a id="pubImg" title="从电脑选择图片"><img
								src="templates/default/addatt.gif"> </a>
						<i class="menu_tqb_c1"><img src="templates/default/imgdel.gif"
								title="关闭"> </i>
						<em>可上传JPG、JPEG、GIF、PNG图片（小于2M），或直接在上面发布框粘贴网上图片url地址</em>
						<span id="uploading"></span>
					</p>
				</div>
				<div class="menu_imgshow" id="viewImgDiv" style="display: none">
					<p class="menu_ps" style="">
						<i id="viewImg"></i>
						<a href="javascript:void(0)" onclick="deleteImg();" title="删除已上传"
							class="menu_tqb_c1">删除</a>
						<img id="img_pre" src="templates/default/hotb.gif" style="">
					</p>
				</div>
			</div>
		</div>

<!-- 
		<div class="menu">
			<div class="menu_bq" id="editface">
				<b class="menu_bqb_c"><a href="javascript:void(0);"
					onclick="topic_face(&#39;showface&#39;,&#39;i_already&#39;,&#39;topic_face&#39;);return false;">表情</a>
				</b>
				<div id="showface" class="showface"></div>
			</div>
		</div>
 -->

	</div>
	<div class="box_4">

		<input type="button" class="indexBtn" id="publishSubmit"
			onclick="publishSubmit(&#39;i_already&#39;,0,&#39;myhome&#39;,&#39;topic_type&#39;,&#39;&#39;,&#39;&#39;,&#39;mapp_item&#39;,&#39;mapp_item_id&#39;);return false;">

		<!--这边的判断主要是为了在应用中使用微博发布框-->
	</div>

</div>
<script type="text/javascript">
var ctrlEnter;
function ctrlEnter(event, btnId, onlyEnter) {
	if (isUndefined(onlyEnter))
		onlyEnter = 0;
	if ((event.ctrlKey || onlyEnter) && event.keyCode == 13) {
		(btnId).click();
		return false;
	}
	return true;
}
function checkWord(len, evt, wordCheckNumID) {
	if (evt == null)
		evt = window.event;
	var src = evt.srcElement ? evt.srcElement : evt.target;
	var str = src.value.trim();
	myLen = 0;
	i = 0;
	for (; (i < str.length) && (myLen <= len * 2); i++) {
		if (str.charCodeAt(i) > 0 && str.charCodeAt(i) < 128)
			myLen++;
		else
			myLen += 2;
	}

	if (myLen > len * 2) {
		src.value = str.substring(0, i - 1);
	} else {
		document.getElementById(wordCheckNumID).innerHTML = Math
				.floor((len * 2 - myLen) / 2);
	}
}
String.prototype.trim = function() {
	return this.replace(/(^\s*)|(\s*$)/g, "");
}
document.getElementById("i_already").onfocus = function() {
	var tigBox = document.getElementById("tigBox_2");
	tigBox.style.visibility = "visible";
	var i = 0;
	setTimeout(function() {
		i += 1;
		tigBox.style.visibility = "hidden";
	}, 5000);
}
//$("#i_already").focus();
$("#i_already").bind('keydown', function(event) {
	event = event || window.event;
	if (event.keyCode == 13 && event.ctrlKey) {
		$("#publishSubmit").click();
	}
	;
});
function deleteImg(topicimgId) {
	var topicimgId = 'undefined' == typeof (topicimgId) ? '' : topicimgId;
	if ('' != topicimgId) {
		imgId = topicimgId;
	}
	if (imgId > 0) {
		$.post('image.html', {
			id : imgId
		}, function(d) {
			if ('' != d) {
				//alert(d);
			} else {
				;
			}
		});
		imgId = 0;
	}
	document.getElementById('publisher_image_form').style.display = 'block';
	document.getElementById('insertImgDiv').style.display = 'block';
	document.getElementById('viewImgDiv').style.display = 'none';
}

function fileSubmit() {
	var fn = $('#publisher_file').val();
	if (!/\.(gif|jpg|png|jpeg)$/i.test(fn)) {
		alert("请上传jpg、jpeg、gif、png格式的图片。");
	}
	$('#uploading').show();
	$('#uploading').html("<img src='templates/default/loading.gif'/>&nbsp;上传中");
	$('#publishSubmit').attr('disabled', true);
	$('#publisher_image_form').submit();
	var waitTimeID = window.setTimeout(function() {
		$('#publishSubmit').attr('disabled', false);
		window.clearTimeout(waitTimeID);
	}, 10000);
}
</script>