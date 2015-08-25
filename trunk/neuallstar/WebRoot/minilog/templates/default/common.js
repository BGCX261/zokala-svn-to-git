var userAgent = navigator.userAgent.toLowerCase();
var is_opera = userAgent.indexOf('opera') != -1 && opera.version();
var is_moz = (navigator.product == 'Gecko')
		&& userAgent.substr(userAgent.indexOf('firefox') + 8, 3);
var is_ie = (userAgent.indexOf('msie') != -1 && !is_opera)
		&& userAgent.substr(userAgent.indexOf('msie') + 5, 3);
var is_safari = (userAgent.indexOf('webkit') != -1 || userAgent
		.indexOf('safari') != -1);
if (top.location != location) {
	top.location.href = location.href;
}
var maxl = thisTopicLength;
function checkAll(e, itemName) {
	var aa = document.getElementsByName(itemName);
	for ( var i = 0; i < aa.length; i++) {
		aa[i].checked = e.checked;
	}
}
function checkItem(e, allName) {
	var all = document.getElementsByName(allName)[0];
	if (!e.checked)
		all.checked = false;
	else {
		var aa = document.getElementsByName(e.name);
		for ( var i = 0; i < aa.length; i++)
			if (!aa[i].checked)
				return;
		all.checked = true;
	}
}
function copyToClipboard(theField, isalert) {
	var obj = document.getElementById(theField);
	if (obj != null) {
		var clipBoardContent = obj.value;
		obj.select();
		window.clipboardData.setData("Text", clipBoardContent);
		if (isalert != false)
			alert("复制成功！将以上链接发给亲朋好友，他们接受邀请后会成为你的粉丝。");
	} else {
		alert("Error!");
	}
}
function addEvents(eventHandler) {
	var tags = document.getElementsByTagName('input');
	for ( var i = 0; i < tags.length; i++) {
		if (tags[i].getAttribute('url') == 'true') {
			if (tags[i].addEventListener) {
				tags[i].addEventListener('keyup', eventHandler, true);
			} else {
				tags[i].attachEvent('onkeyup', eventHandler);
			}
		}
	}
}
function addInput(e) {
	var obj = e.target ? e.target : e.srcElement;
	var tags = document.getElementsByTagName('input');
	for ( var i = 0; i < tags.length; i++) {
		if (tags[i].getAttribute('url') == 'true' && tags[i] != obj) {
			tags[i].value = obj.value;
		}
	}
}
window.onload = function() {
	addEvents(addInput);
};
extArray = new Array(".gif", ".jpg", ".png");
function LimitAttach(form, file) {
	allowSubmit = false;
	if (!file)
		return;
	while (file.indexOf("\\") != -1)
		file = file.slice(file.indexOf("\\") + 1);
	ext = file.slice(file.indexOf(".")).toLowerCase();
	for ( var i = 0; i < extArray.length; i++) {
		if (extArray[i] == ext) {
			allowSubmit = true;
			break;
		}
	}
	if (allowSubmit)
		form.submit();
	else
		alert("对不起，只能上传以下格式的文件:  " + (extArray.join("  ")) + "\n请重新选择符合条件的文件"
				+ "再上传.");
}
function drop_mouseover(pos) {
	try {
		window.clearTimeout(timer);
	} catch (e) {
	}
}
function drop_mouseout(pos) {
	var posSel = document.getElementById(pos + "Sel").style.display;
	if (posSel == "block") {
		timer = setTimeout("drop_hide('" + pos + "')", 1000);
	}
}
function drop_hide(pos) {
	document.getElementById(pos + "Sel").style.display = "none";
}
function search_show(pos, searchType, href) {
	document.getElementById(pos + "SearchType").value = searchType;
	document.getElementById(pos + "Sel").style.display = "none";
	document.getElementById(pos + "Slected").innerHTML = href.innerHTML;
	document.getElementById(pos + 'q').focus();
	try {
		window.clearTimeout(timer);
	} catch (e) {
	}
	return false;
}

//function deleteTopic(i,eid){if(!confirm("确认删除？"))return false;var i='undefined'==typeof(i)?0:i;var myAjax=$.post("ajax.php?mod=topic&code=delete",{tid:i},function(d){if(''!=d){alert(d);return false;}else{$("#"+eid).remove();}});}

function PmSend(to_user, eid) {
	var eid = 'undefined' == typeof (eid) ? 'Pmsend_to_user_area' : eid;
	var to_user = 'undefined' == typeof (to_user) ? '' : to_user;
	var eidVal = $("#" + eid).html();
	if ('' == eidVal) {
		var myAjax = $.post("ajax.php?mod=pm&code=send", {
			to_user : to_user
		}, function(d) {
			if ('' != d) {
				$("#" + eid).html(d);
			}
		});
	} else {
		$("#" + eid).html('');
	}
}
function Pmdelete(i, eid, act) {
	if (!confirm("确认删除？"))
		return false;
	var i = 'undefined' == typeof (i) ? 0 : i;
	var act = 'undefined' == typeof (act) ? '' : act;
	var myAjax = $.post("ajax.php?mod=pm&code=delete", {
		pmid : i,
		act : act
	}, function(d) {
		if ('' != d) {
			alert(d);
			return false;
		} else {
			$("#" + eid).remove();
		}
	});
}

function pmTopic(i, eid, act) {
	var i = 'undefined' == typeof (i) ? 0 : i;
	var eid = 'undefined' == typeof (eid) ? 'Pmreply_area_' + i : eid;
	var act = 'undefined' == typeof (act) ? '' : act;
	var eidVal = $("#" + eid).html();
	if ('' == eidVal) {
		var myAjax = $.post("ajax.php?mod=pm&code=view_comment", {
			pmid : i,
			cod : act
		}, function(d) {
			if ('' != d) {
				$("#" + eid).html(d);
			}
		});
	} else {
		$("#" + eid).html('');
	}
}

function favoriteTopic(i, act) {
	var i = 'undefined' == typeof (i) ? 0 : i;
	var act = 'undefined' == typeof (act) ? '' : act;
	var eid = 'favorite_' + i;
	var myAjax = $.post("collect.html", {
		minilogId : i,
		act : act
	}, function(d) {
		if ('' != d) {alert(d);
			$("#" + eid).html(d);
		}
	});
}

function reportOpenWin(url) {
	window
			.open(
					url,
					"举报不良信息",
					"height=538px,width=450px,toolbar=no, menubar=no,resizable=no,location=no, status=no");
};
function copyText(_sTxt) {
	if (is_ie) {
		clipboardData.setData('Text', _sTxt);
		alert("网址“" + _sTxt + "”\n已经复制到您的剪贴板中\n您可以使用Ctrl+V快捷键粘贴到需要的地方");
	} else {
		prompt("请使用Ctrl+C快捷键复制下面的内容:", _sTxt);
	}
}
function setMenuPosition(showid, offset) {
	var showobj = $jishigou_Obj(showid);
	var menuobj = $jishigou_Obj(showid + '_menu');
	if (isUndefined(offset))
		offset = 0;
	if (showobj) {
		showobj.pos = fetchOffset(showobj);
		showobj.X = showobj.pos['left'];
		showobj.Y = showobj.pos['top'];
		showobj.w = showobj.offsetWidth;
		showobj.h = showobj.offsetHeight;
		menuobj.w = menuobj.offsetWidth;
		menuobj.h = menuobj.offsetHeight;
		if (offset != -1) {
			menuobj.style.left = (showobj.X + menuobj.w > document.body.clientWidth)
					&& (showobj.X + showobj.w - menuobj.w >= 0) ? showobj.X
					+ showobj.w - menuobj.w + 'px' : showobj.X + 'px';
			menuobj.style.top = offset == 1 ? showobj.Y + 'px'
					: (offset == 2
							|| ((showobj.Y + showobj.h + menuobj.h > document.documentElement.scrollTop
									+ document.documentElement.clientHeight) && (showobj.Y
									- menuobj.h >= 0)) ? (showobj.Y - menuobj.h) + 'px'
							: showobj.Y + showobj.h + 'px');
		} else if (offset == -1) {
			menuobj.style.left = (document.body.clientWidth - menuobj.w) / 2 + 'px';
			var divtop = document.documentElement.scrollTop
					+ (document.documentElement.clientHeight - menuobj.h) / 2;
			if (divtop > 100)
				divtop = divtop - 100;
			menuobj.style.top = divtop + 'px';
		}
		if (menuobj.style.clip && !is_opera) {
			menuobj.style.clip = 'rect(auto, auto, auto, auto)';
		}
	}
}
function fetchOffset(obj) {
	var left_offset = obj.offsetLeft;
	var top_offset = obj.offsetTop;
	while ((obj = obj.offsetParent) != null) {
		left_offset += obj.offsetLeft;
		top_offset += obj.offsetTop;
	}
	return {
		'left' : left_offset,
		'top' : top_offset
	};
}
function $jishigou_Obj(id) {
	return document.getElementById(id);
}
function isUndefined(variable) {
	return typeof variable == 'undefined' ? true : false;
}
function strlen(str) {
	var ie;
	return (ie && str.indexOf('\n') != -1) ? str.replace(/\r?\n/g, '_').length
			: str.length;
}

function insertContent(target, text) {
	var obj = $jishigou_Obj(target);
	selection = document.selection;
	if (!obj.hasfocus) {
		obj.focus();
	}

	if (!isUndefined(obj.selectionStart)) {
		var opn = obj.selectionStart + 0;
		obj.value = obj.value.substr(0, obj.selectionStart) + text
				+ obj.value.substr(obj.selectionEnd);
	} else if (selection && selection.createRange) {
		var sel = selection.createRange();
		sel.text = text;
		sel.moveStart('character', -strlen(text));
	} else {
		obj.value += text;
	}
}

var userAgent = navigator.userAgent.toLowerCase();
var is_opera = userAgent.indexOf('opera') != -1 && opera.version();
var is_moz = (navigator.product == 'Gecko')
		&& userAgent.substr(userAgent.indexOf('firefox') + 8, 3);
var is_ie = (userAgent.indexOf('msie') != -1 && !is_opera)
		&& userAgent.substr(userAgent.indexOf('msie') + 5, 3);
var is_safari = (userAgent.indexOf('webkit') != -1 || userAgent
		.indexOf('safari') != -1);
var note_step = 0;
var note_oldtitle = document.title;
var note_timer;
if (top.location != location) {
	top.location.href = location.href;
}
function $jishigou(id) {
	return document.getElementById(id);
}
function setCopy(_sTxt) {
	if (is_ie) {
		clipboardData.setData('Text', _sTxt);
		alert("网址“" + _sTxt + "”\n已经复制到您的剪贴板中\n您可以使用Ctrl+V快捷键粘贴到需要的地方");
	} else {
		prompt("请复制网站地址:", _sTxt);
	}
}
function trim(str) {
	var re = /\s*(\S[^\0]*\S)\s*/;
	re.exec(str);
	return RegExp.$1;
}
function stopMusic(preID, playerID) {
	var musicFlash = preID.toString() + '_' + playerID.toString();
	if ($jishigou(musicFlash)) {
		$jishigou(musicFlash).SetVariable('closePlayer', 1);
	}
}
function showFlash(host, flashvar, obj, shareid, url) {

	var flashAddr = {
		'youku.com' : 'http://player.youku.com/player.php/sid/FLASHVAR=/v.swf',
		'ku6.com' : 'http://player.ku6.com/refer/FLASHVAR/v.swf',
		'youtube.com' : 'http://www.youtube.com/v/FLASHVAR',
		'5show.com' : 'http://www.5show.com/swf/5show_player.swf?flv_id=FLASHVAR',
		'sina.com.cn' : 'http://vhead.blog.sina.com.cn/player/outer_player.swf?vid=FLASHVAR',
		'sohu.com' : 'http://v.blog.sohu.com/fo/v4/FLASHVAR',
		'mofile.com' : 'http://tv.mofile.com/cn/xplayer.swf?v=FLASHVAR',
		'tudou.com' : 'http://www.tudou.com/v/FLASHVAR',
		'music' : 'FLASHVAR',
		'flash' : 'FLASHVAR'
	};

	var flash = '<object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=7,0,19,0" width="480" height="400">'
			+ '<param name="movie" value="FLASHADDR" />'
			+ '<param name="quality" value="high" />'
			+ '<param name="bgcolor" value="#FFFFFF" />'
			+ '<embed width="440" height="360" menu="false" quality="high" src="FLASHADDR" type="application/x-shockwave-flash" />'
			+ '<span>flashAddr</span>' + '</object>';

	var videoFlash = '<object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" width="440" height="400">'
			+ '<param value="transparent" name="wmode"/>'
			+ '<param value="FLASHADDR" name="movie" />'
			+ '<embed src="FLASHADDR" wmode="transparent" allowfullscreen="true" type="application/x-shockwave-flash" width="480" height="450"></embed>'
			+ '</object>';

	var musicFlash = '<object id="audioplayer_SHAREID" height="24" width="290" data="images/player.swf" type="application/x-shockwave-flash">'
			+ '<param value="images/player.swf" name="movie"/>'
			+ '<param value="autostart=yes&bg=0xCDDFF3&leftbg=0x357DCE&lefticon=0xF2F2F2&rightbg=0xF06A51&rightbghover=0xAF2910&righticon=0xF2F2F2&righticonhover=0xFFFFFF&text=0x357DCE&slider=0x357DCE&track=0xFFFFFF&border=0xFFFFFF&loader=0xAF2910&soundFile=FLASHADDR" name="FlashVars"/>'
			+ '<param value="high" name="quality"/>'
			+ '<param value="false" name="menu"/>'
			+ '<param value="#FFFFFF" name="bgcolor"/>' + '</object>';

	var musicMedia = '<object height="64" width="290" data="FLASHADDR" type="audio/x-ms-wma">'
			+ '<param value="FLASHADDR" name="src"/>'
			+ '<param value="1" name="autostart"/>'
			+ '<param value="true" name="controller"/>' + '</object>';

	var flashHtml = videoFlash;
	var videoMp3 = true;
	if ('' == flashvar) {
		alert('链接地址错误，不能为空');
		return false;
	}
	if ('music' == host) {
		var mp3Reg = new RegExp('.mp3$', 'ig');
		var flashReg = new RegExp('.swf$', 'ig');
		flashHtml = musicMedia;
		videoMp3 = false;
		if (mp3Reg.test(flashvar)) {
			videoMp3 = true;
			flashHtml = musicFlash;
		} else if (flashReg.test(flashvar)) {
			videoMp3 = true;
			flashHtml = flash;
		}
	}
	flashvar = encodeURI(flashvar);
	if (flashAddr[host]) {
		var flash = flashAddr[host].replace('FLASHVAR', flashvar);
		flashHtml = flashHtml.replace(/FLASHADDR/g, flash);
		flashHtml = flashHtml.replace(/SHAREID/g, shareid);
	}
	if (!obj) {
		$jishigou('flash_div_' + shareid).innerHTML = flashHtml;
		return true;
	}
	if ($jishigou('flash_div_' + shareid)) {
		$jishigou('flash_div_' + shareid).style.display = '';
		$jishigou('flash_hide_' + shareid).style.display = '';
		obj.style.display = 'none';
		return true;
	}
	if (flashAddr[host]) {
		var flashObj = document.createElement('div');
		flashObj.id = 'flash_div_' + shareid;
		obj.parentNode.insertBefore(flashObj, obj);
		flashObj.innerHTML = flashHtml;
		obj.style.display = 'none';
		$jishigou('play_' + shareid).style.display = 'none';
		var hideObj = document.createElement('div');
		hideObj.id = 'flash_hide_' + shareid;
		var nodetxt = document.createTextNode("收起");
		hideObj.appendChild(nodetxt);
		obj.parentNode.insertBefore(hideObj, obj);
		hideObj.style.cursor = 'pointer';
		hideObj.onclick = function() {
			if (true == videoMp3) {
				stopMusic('audioplayer', shareid);
				flashObj.parentNode.removeChild(flashObj);
				hideObj.parentNode.removeChild(hideObj);
			} else {
				flashObj.style.display = 'none';
				hideObj.style.display = 'none';
			}
			obj.style.display = '';
			$jishigou('play_' + shareid).style.display = 'block';
		}
	}
}

//-------------------------------------------------------------------------------------

var lastPublishSubmitContent = '';
var imgId = 0;
var videoid = 0;
var __APPITEM__ = '';
var __APPITEM_ID__ = 0;
function publishSubmit(ci) {
	var c = $('#' + ci).val();
	var c = ('undefined' == typeof (c) ? '' : c);
	alert(c);
	if (lastPublishSubmitContent == c) {
		show_message('不要贪心哦，发一次就够啦。');
		return false;
	}
	var myAjax = $.post("publish.html", {
		content : c
	});
	//window.location.href = "index.html";
}/*
function publishSubmit(ci,i,r,topictype,roottid,is_huifu,appitem_wp,appitem_id_wp) {

 var c = $('#'+ci).val();
 var c = ('undefined' == typeof(c) ? '' : c);
 if( '' == c || '#插入自定义话题#' == c )
 {
 show_message('请输入微博内容',1);
 return false;
 }
 if(lastPublishSubmitContent==c)
 {
 show_message('不要贪心哦，发一次就够啦。');
 return false;
 }
 else
 {
 lastPublishSubmitContent=c;
 }
 //存放发布内容
 //	if(is_ie){
 //        clipboardData.setData('Text',c);
 //	}
 //	else{
 //		show_message('仅支持IE，请手动保存发布内容！');
 //	} 

 //转发 类别
 var topictype = $('#'+topictype).val();
 var topictype = ('undefined' == typeof(topictype) ? '' : topictype);

 var i = $('#'+i).val();
 var i = ('undefined' == typeof(i) ? '' : i);

 if (is_huifu) {
 var is_huifu = $('#'+is_huifu).val();
 var is_huifu = ('undefined' == typeof(is_huifu) ? '' : is_huifu);
 }

 var r = ('undefined' == typeof(r) ? '' : r);
 var roottid = ('undefined' == typeof(roottid) ? 0 : roottid);

 //发布前的提示信息
 var loadingTips = "<div><center><span class='loading'>内容正在发布中，请稍候……</span></center></div>";
 if( 'vc'==r )
 {
 $("#topic_view_comment_msg_area_"+roottid).html(loadingTips);
 } 
 else if( -1!=r.indexOf('rl') ) 
 {
 $("#replyListMsgArea").html(loadingTips);
 }
 else if( 'myblog'==r || 'myhome'==r || 'tagview'==r || 'new'==r  || 'qun'==r)		//加入了对微群发微博的处理
 {
 $("#listTopicMsgArea").html(loadingTips);
 }

 var appitem = __APPITEM__;
 //应用from
 var from = appitem;
 var appitem_id = __APPITEM_ID__;

 //微群应用相关
 if ((('undefined' != typeof(appitem_wp))) && (('undefined' != typeof(appitem_id_wp)))) {
 appitem = $('#'+appitem_wp).val();
 appitem = (('undefined' == typeof(appitem) || false == appitem)) ? '' : appitem;
 from = appitem;
 appitem_id = $('#'+appitem_id_wp).val();
 appitem_id = (('undefined' == typeof(appitem_id) || false == appitem_id)) ? 0 : appitem_id;
 }

 //开始发布
 var myAjax = $.post(
 "publish.html",
 {
 totid:i, 
 imgId:imgId,
 videoid:videoid,
 content:c,
 topictype:topictype,
 r:r,
 roottid:roottid,
 is_huifu:is_huifu,
 item:appitem,
 item_id:appitem_id,
 from:from
 },
 function (d) {
 if( ''!=d && ''==r ) {
 $('#'+ci).val(c);
 alert(d);
 $('#'+ci).focus();

 return false;
 } else if('vc'==r) {
 $("#topic_view_comment_area_"+roottid).html(d);

 if( -1 == d.indexOf('<success></success>'))
 {
 $('#'+ci).val(c);
 $('#'+ci).focus();

 return false;
 }                
 } else if(-1!=r.indexOf('rl')) {
 $("#replyListArea").html(d);

 if( -1 == d.indexOf('<success></success>'))
 {
 $('#'+ci).val(c);
 $('#'+ci).focus();

 return false;
 }
 } else if(-1!=r.indexOf('tohome')) {
 window.location.href= thisSiteURL + 'index.php?mod=topic&code=myhome';
 } else {
 if(''!=d) {
 $('#'+ci).val(c);
 alert(d);
 $('#'+ci).focus();
 return false;
 } else {
 //话题发布成功后，清除图片、视频、音乐的ID值
 imgId = 0;
 videoid = 0;
 if( 'myblog'==r || 'myhome'==r || 'tagview'==r || 'new'==r || 'qun'==r) 		//在这边增加了qun by ~ZZ~
 {                        
 listAreaPrependTopic();
 //listTopic(0,0);
 } 
 else if( 'mycomment'==r )
 {
 window.location.href= thisSiteURL + 'index.php?mod=topic&code=myhome';
 }
 }
 }
 }
 );

 $('#'+ci).val('');
 //show_message('提示消息内容','显示几秒后消失','提示标题','样式--默认');
 //show_message('发布成功',1);

 if('' != imgId)
 {
 document.getElementById('publisher_image_form').style.display='block';
 document.getElementById('insertImgDiv').style.display='block';
 document.getElementById('viewImgDiv').style.display='none';
 }
 if('' != videoid)
 {	document.getElementById('add_video').style.display='block';
 document.getElementById('upload_video_list').style.display='none';
 document.getElementById('upload_ajax_video').style.display='none';
 }
 return true;
 }*/
function listAreaPrependTopic() {
	$("#listTopicMsgArea")
			.html(
					"<div><center><span class='loading'>内容正在加载中，请稍候……</span></center></div>");

	var myAjax = $.post("ajax.php?mod=topic", {
		code : 'mylastpublish'
	}, function(d) {
		$("#listTopicMsgArea").html('');
		$('#listTopicArea').prepend(d);
	});
}
function deleteTopic(i, eid, view) {
	if (!confirm("确认删除？"))
		return false;

	var i = 'undefined' == typeof (i) ? 0 : i;
	var view = 'undefined' == typeof (view) ? '' : view;
	//alert(view);return false;

	var myAjax = $.post("ajax.php?mod=topic&code=delete", {
		tid : i
	}, function(d) {
		$("#" + eid).remove();

		$("#ajax_output_area").html(d);

		if ('' != view) {
			window.location.href = thisSiteURL
					+ "index.html";
		}

	});
}

function follow(fid, eid, events) {
	var events = ('undefined' == typeof (events) ? '' : events);

	var myAjax = $.post("follow.html", {
		followingid : fid
	}, function(d) {
		alert(d);
		if ('' != d) {
			$('#' + eid).html(d);

			if (-1 != d.indexOf('<success></success>')) {
				if ('add' == events) {
					//触发选择分组层
			parent.document.getElementById('button_' + fid).onclick();
		} else {
			$("#user_grouplist_" + fid).remove();
		}
	}
}
}	);
}

//举报
function ReportSub(tid, report_content, report_reason, eid) {
	var totid = $('#' + tid).val();
	var content = $('#' + report_content).val();
	var reasons = $('#' + report_reason).val();

	if ('0' == reasons) {
		alert("请选择举报类型");
		return false;
	}

	var myAjax = $.post("ajax.php?mod=topic&code=doreport", {
		totid : totid,
		report_content : content,
		report_reason : reasons
	}, function(d) {
		parent.document.getElementById('Report').style.display = 'none';
		parent.document.getElementById('report_content').value = '';
		parent.document.getElementById('report_reason').value = '0';
		show_message(d, 1);
	});

}

//编辑微博
function modifyTopic(i, eid, types) {
	var i = 'undefined' == typeof (i) ? 0 : i;
	var eid = 'undefined' == typeof (eid) ? 'modify_topic_list_' + i : eid;

	var eidVal = $("#" + eid).html();
	if ('' == eidVal) {
		var myAjax = $.post("ajax.php?mod=topic&code=modifytopic", {
			tid : i,
			types : types
		}, function(d) {
			if ('' != d) {
				$("#" + eid).html(d);
			}
		});
	} else {
		$("#" + eid).html('');
	}
}

function do_modifyTopic(i, imgId, content, types) {

	var i = 'undefined' == typeof (i) ? 0 : i;
	var imgId = $('#' + imgId).val();

	var content = $('#' + content).val();
	var content = 'undefined' == typeof (content) ? '' : content;

	//alert(types); return false;
	var myAjax = $.post("ajax.php?mod=topic&code=do_modifytopic", {
		tid : i,
		imgId : imgId,
		content : content
	}, function(d) {

		if ('topic_list' == types) {
			listTopic(0, 0);
		} else {
			replyList();
		}

		show_message('微博编辑成功', 1);
		//parent.document.getElementById("modify_topic_"+tid).style.display="none";
		});

}

//弹出框定位
function _cumulpos(a) {
	var b = 0, c = 0, a = 0;
	do {
		b += a.offsetTop || 0;
		c += a.offsetLeft || 0;
		a = a.offsetParent;
	} while (a);
	return [ c, b ];
}

//添加分组
function GroupSubmit(ci, i, act, touid) {

	var c = $('#' + ci).val();
	var c = 'undefined' == typeof (c) ? '' : c;

	if ('' == c) {
		show_message("请输入分组名称");
		return false;
	}

	var i = 'undefined' == typeof (i) ? 0 : i;
	var r = 'undefined' == typeof (r) ? '' : r;
	var act = 'undefined' == typeof (act) ? '' : act;
	var touid = 'undefined' == typeof (touid) ? 0 : touid;

	//alert(i); return false;
	var myAjax = $.post("ajax.php?mod=topic&code=do_group", {
		group_name : c,
		gid : i,
		act : act,
		touid : touid
	}, function(d) {
		if ('' != d) {
			if ('modify' != act) {
				$("#add_group_fllow").html($("#add_group_fllow").html() + d);
				$("#add_group_view").html($("#add_group_view").html() + d);
				$("#add_group_menu_" + touid).html(
						$("#add_group_menu_" + touid).html() + d);
			} else {
				$("#up_grouplist_" + i).html(d);
				$("#up_grouplist_view_" + i).html(d);
				parent.document.getElementById('modify_group_' + i).value = c;
			}
		}
	});

	$('#' + ci).val('');

	return true;
}

//删除分组
function del_group(group_id, touid) {
	var group_id = 'undefined' == typeof (group_id) ? 0 : group_id;

	var myAjax = $.post("ajax.php?mod=topic&code=del_group", {
		group_id : group_id
	},

	function(d) {
		if ('' != d) {
			//alert(d);
			$("#del_group_ajax_" + group_id).remove();
			$("#del_group_follow_top_" + group_id).remove();
		}
	});
}

//分组弹出框
function get_group_choose(userid) {

	var eidVal = $("#" + "global_select_" + userid).html();

	if ('' == eidVal) {
		var myAjax = $
				.post("ajax.php?mod=topic&code=group_menu", {
					to_user : userid
				},
						function(d) {
							if ('' != d) {
								document.getElementById("global_select_"
										+ userid).style.display = "block";
								$("#" + "global_select_" + userid).html(d);
							}
						});
	} else {
		$("#" + "global_select_" + userid).html('');
	}

}

function groupState(gid, touid, eid) {

	var myAjax = $
			.post(
					"ajax.php?mod=topic&code=group_fields",
					{
						gid : gid,
						touid : touid
					},
					function(d) {
						if ('' != d) {
							$('#' + eid).html(d);
						}
						if (eid.checked) {
							eid.checked = false;
							//show_message('分组取消成功',1);
						} else {
							eid.checked = true;
							//show_message('分组设置成功',1);
						}
						var myAjax = $
								.post(
										"ajax.php?mod=topic&code=group_list",
										{
											touid : touid
										},
										function(d) {
											$('#' + "group_list2_" + touid)
													.html(d);
											parent.document
													.getElementById('group_list2_' + touid).style.display = 'block';

										});
					});
}

//添加备注 、 操作框
function get_remark(uid) {
	var eidVal = $("#" + "get_remark_" + uid).html();

	if ('' == eidVal) {
		var myAjax = $
				.post(
						"ajax.php?mod=topic&code=remark",
						{
							uid : uid
						},
						function(d) {
							if ('' != d) {
								document.getElementById("get_remark_" + uid).style.display = "block";
								$("#" + "get_remark_" + uid).html(d);
							}
						});
	} else {
		$("#" + "get_remark_" + uid).html('');
	}
}

//添加备注
function publishSubmit_remark(ci, buddyid) {
	var c = $('#' + ci).val();
	var c = 'undefined' == typeof (c) ? '' : c;

	var buddyid = 'undefined' == typeof (buddyid) ? 0 : buddyid;

	show_message('备注设置成功', 1)

	var myAjax = $
			.post(
					"ajax.php?mod=topic&code=add_remark",
					{
						remark : c,
						buddyid : buddyid
					},
					function(d) {
						if (d) {
							$('#' + "remarklist_" + buddyid).html(d);
						} else {
							if (c) {
								$('#' + "remarklist_" + buddyid).html(
										'(' + c + ')');
							} else {
								$('#' + "remarklist_" + buddyid).html('');
							}
						}

						document.getElementById("add_remark_" + buddyid).style.display = "none";

					});

	return true;
}

//添加关注话题
function favoriteTag(i, act) {
	var i = 'undefined' == typeof (i) ? '' : i;

	if (act == 'input_add') {
		var i = $('#' + i).val();
	}

	var act = 'undefined' == typeof (act) ? '' : act;

	var eid = 'favorite_tag_id';

	var myAjax = $.post("ajax.php?mod=topic&code=favor_tag", {
		tag : i,
		act : act
	}, function(d) {
		if ('' != d) {
			if (act != 'input_add') {
				$("#" + eid).html(d);
			} else {
				$("#add_ajax_favorite_tags").html(d);
				parent.document.getElementById('tag_name').value = "";
			}
		}

		if ('delete' == act) {

			$("#favorite_" + i).remove();
		}
	});
}

//转发提交js
function Forward(content, forward_tid, tid, check) {
	var cid = content;

	var content = $('#' + cid).val();
	var check = $('#' + check).val();

	$("#topic_forward_content_area_" + tid).append('<br />内容正在发布中，请稍候……');

	var myAjax = $
			.post(
					"forward.html",
					{
						forward_tid : forward_tid,
						minilogId : tid,
						content : content,
						topictype : check
					},
					function(d) {
						if (d) {
							if (-1 != d.indexOf('<success></success>')) {
								listTopic(0, 0);
								show_message('微博转发成功', 1);

								parent.document.getElementById('forward_list').style.display = 'none';
								parent.document.getElementById("forward_menu_"
										+ tid).style.display = "none";

								return true;
							} else {
								alert(d);
							}
						} else {
							alert('微博转发失败');
						}

						$('#' + cid).val(content);
						$('#' + cid).focus();

						return false;
					});

	$('#' + cid).val('');

	return true;
}

//话题弹出框
function get_tag_choose(uid, tc_type) {
	var uid = 'undefined' == typeof (uid) ? 0 : uid;
	var tc_type = 'undefined' == typeof (tc_type) ? '' : tc_type;
	var _cache_id = tc_type + '_' + uid;

	if (undefined == Cache.get(_cache_id)) {
		var _jsgcid = 'JSGCACHE_get_tag_choose_' + _cache_id;
		if (undefined != Cache.get(_jsgcid)) {
			return false;
		}
		Cache.save(_jsgcid, _jsgcid);

		var myAjax = $.post("ajax.php?mod=topic&code=tag_menu", {
			uid : uid,
			type : tc_type
		}, function(d) {
			if ('' != d) {
				Cache.save(_cache_id, d);
				document.getElementById("tag_" + uid).style.display = "block";
				$("#" + "tag_" + uid).html(Cache.get(_cache_id));
			}
		});
	} else {
		document.getElementById("tag_" + uid).style.display = "block";
		$("#" + "tag_" + uid).html(Cache.get(_cache_id));
	}
}

//评论弹出框
function replyTopic(i, eid, tReplys) {
	var i = ('undefined' == typeof (i) ? 0 : i);
	var tReplys = ('undefined' == typeof (tReplys) ? 0 : tReplys);
	var eid = ('undefined' == typeof (eid) ? 'reply_area_' + i : eid);
	var eidVal = $("#" + eid).html();

	if ('' == eidVal) {
		var tcHTML = topicCommentHTML(i, tReplys);

		$("#" + eid).html(tcHTML);
	} else {
		$("#" + eid).html('');
	}
}
function topicCommentHTML(tid, tReplys) {
	var tcHTML = '<div class="blogTxt" id="1234567"> <div class="top_2"></div> <div class="mid"> <div id="topic_view_comment_area_'
			+ tid
			+ '"><div id="topic_view_comment_msg_area_'
			+ tid
			+ '"></div></div> <div id="to_reply_user_'
			+ tid
			+ '"></div> <p class="comment_p h10px"> <div class="comment_p_t"> <div class="menuf"> <div class="menuf_bq"><b class="reply_ajax_menu_bqb_c"><a href="javascript:viod(0);" onclick="topic_face(\'reply_face_'
			+ tid
			+ '\',\'reply_content_'
			+ tid
			+ '\');return false;">表情</a></b> <div class="forward_f2" style="margin-top:5px;" id="reply_face_'
			+ tid
			+ '" style="border:1px solid #BFBFBF;display:none;"></div> </div></div> <textarea id="reply_content_'
			+ tid
			+ '" name="textarea" class="sp_4 sp_6 operaLay" onkeyup="javas'
			+ 'cript:checkWord('
			+ thisTopicLength
			+ ',event,\'wordCheckNum_'
			+ tid
			+ '\')" ></textarea> <input type="hidden" id="replytid_'
			+ tid
			+ '" name="replytid_'
			+ tid
			+ '" value="'
			+ tid
			+ '"/> <input type="hidden" id="is_huifu_'
			+ tid
			+ '" name="is_huifu_'
			+ tid
			+ '" value=""/> <input id="rcbtn_'
			+ tid
			+ '" onclick="publishSubmit(\'reply_content_'
			+ tid
			+ '\',\'replytid_'
			+ tid
			+ '\',\'vc\',\'topicReplyType_'
			+ tid
			+ '\','
			+ tid
			+ ',\'is_huifu_'
			+ tid
			+ '\');return false;" type="button" class="sBtn_2 sBtn_2t" value="评 论" title="按Ctrl+Enter直接发布"/> </div> <div class="comment_p_b"> <div class="comment_p_t2"> <input name="topicReplyType_'
			+ tid
			+ '" type="checkbox" id="topicReplyType_'
			+ tid
			+ '" value="reply" onclick="select_checked(\'topicReplyType_'
			+ tid
			+ '\');"/> 同时转发给关注我的人 </div> <div class="comment_p_t3"> <span>还可以输入</span> <span><span id="wordCheckNum_'
			+ tid
			+ '" style="color:#FF0000;font-size:12px;">'
			+ thisTopicLength
			+ '</span></span> <span style="width:14px;">字</span> </div> </div> <scr'
			+ 'ipt language="Javasc'
			+ 'ript"> $(document).ready(function(){ $(".reply_ajax_menu_bqb_c").click(function(){$("#reply_face_'
			+ tid
			+ '").show();}); $(".menu_bqb_c1").click(function(){$("#reply_face_'
			+ tid
			+ '").hide();}); $("#reply_content_'
			+ tid
			+ '").bind("keyup keypress",function(e){ if(e.which==13){return false;} var width=$(this).width(); if (!$.browser.msie )$(this).css("letter-spacing","0.05em"); var len=$(this).val().replace(/[^\\x00-\\xff]/g,"aa").length-1; $(this).height(17*(parseInt(len*6.5/width)+1)); }) }); $("#reply_content_'
			+ tid
			+ '").bind("keydown",function(event){ event = event || window.event; if(event.keyCode == 13 && event.ctrlKey) { $("#rcbtn_'
			+ tid
			+ '").click(); } }); var tReplys = '
			+ tReplys
			+ ';if(tReplys > 0){topic_view_comment_list('
			+ tid
			+ ');}</scr'
			+ 'ipt> </p> </div> <div class="bottom"></div> </div>';

	return tcHTML;
}
function topic_view_comment_list(tid) {
	var eid = "topic_view_comment_area_" + tid;

	$("#" + eid)
			.html(
					"<div><center><span class='loading'>内容正在加载中，请稍候……</span></center></div>");

	var myAjax = $.post("ajax.php?mod=topic&code=view_comment", {
		tid : tid
	}, function(d) {
		$("#" + eid).html(d);
	});
}

//转发弹出框
function get_forward_choose(tid) {
	var tid = 'undefined' == typeof (tid) ? 0 : tid;

	var fcHTML = '<iframe id="Forwardframe_'
			+ tid
			+ '" name="Forwardframe_'
			+ tid
			+ '" width="0" height="0" marginwidth="0" frameborder="0" src="about:blank"></iframe> <div id="forward_list"> <ul class="manBox"> <li> <div class="tt1"><span >转发微博给关注我的人</span><div class="mclose" onclick="close_menu(\''
			+ tid
			+ '\',\'forward_menu\');"></div></div> <div class="mWarp"> <form action="ajax.php?mod=topic&code=forward" method="POST" target="Forwardframe_'
			+ tid
			+ '"> <table> <tr> <td colspan="2"><span id="user_new"></span></td> </tr> <tr> <td colspan="2"><span id="topic_forward_content_area_'
			+ tid
			+ '">原文正在加载中……</span></td> </tr> <tr> <td colspan="2">&nbsp;</td> </tr> <tr> <td colspan="2"> <div class="fbqCount" style=" position:absolute; margin:-10px 0 0 270px;*margin:-10px 0 0 -60px;"><style>ul.mycon li{ width:65px;}</style> <ul class="mycon fontGreen" style="width:130px"> <li>还可以输入</li> <li id="wordc"><span id="wordcNum_'
			+ tid
			+ '" style="color:#339900;">'
			+ thisTopicLength
			+ '</span></li> <li style="width:14px;">字</li> </ul> </div> <div class="menuf"> <div class="menuf_bq" >&nbsp;<div class="forward_f" id="forward_'
			+ tid
			+ '"></div> </div></div> <textarea id="forward_content_'
			+ tid
			+ '" name="content" onkeyup="javascript:checkWord('
			+ thisTopicLength
			+ ',event,\'wordcNum_'
			+ tid
			+ '\')" class="Pbox_te" onblur="if(this.value == \'\'){this.value = \'转发微博\'; }" onfocus="if(this.value == \'转发微博\'){this.value =\'\'; }" >转发微博</textarea> </td> </tr> <tr> <td width="150"><input name="topicForwardType_'
			+ tid
			+ '" type="checkbox" id="topicForwardType_'
			+ tid
			+ '" value="forward" onclick="select_checked(\'topicForwardType_'
			+ tid
			+ '\',\'forward\');"/> 同时作为评论发布 </td> <td align="right"> <input id="rcbtna_'
			+ tid
			+ '" onclick="Forward(\'forward_content_'
			+ tid
			+ '\','
			+ tid
			+ ','
			+ tid
			+ ',\'topicForwardType_'
			+ tid
			+ '\');return false;" type="button" value="转 发" class="shareI"/> <input type="button" name="del" value="取 消" onclick="close_menu(\''
			+ tid
			+ '\',\'forward_menu\');" class="shareI"/> <input name="forward_tid" type="hidden" id="forward_tid" value="{$forward_tid}" /> </td> </tr> </table> </form> </div> </li> </ul> </div> <script type="text/javascript"> $(document).ready(function(){ $(".menu_bqb_c").click(function(){$("#forward_'
			+ tid
			+ '").show();}); $(".menu_bqb_c1").click(function(){$("#forward_'
			+ tid
			+ '").hide();}); }); $("#forward_content_'
			+ tid
			+ '").bind("keydown",function(event){ event = event || window.event; if(event.keyCode == 13 && event.ctrlKey) { $("#rcbtna_'
			+ tid
			+ '").click(); } }); $("#topic_forward_content_area_'
			+ tid
			+ '").html("<span class=\'loading\'>'
			//+$.eval('topic_lists_'+tid)
			+'</span>");</script>';
/**var myAjax=$.post("minilog.html",{mid:'
			+ tid + '},function(d){$("#topic_forward_content_area_' + tid
			+ '").html(d);});**/
	$("#" + "forward_menu_" + tid).css('display', 'block');
	$("#" + "forward_menu_" + tid).html(fcHTML);
}

var authort;
//悬浮头像显示用户
function get_user_choose(uid, types, tid) {//alert(uid);return false;
	clear_user_choose();
	var div_id = tid ? tid : uid;
	var _cache_id = uid;

	authort = setTimeout(function() {
		var myAjax = $.post("ajax.php?mod=topic&code=usermenu", {
			uid : uid
		}, function(d) {
			if ('' != d) {
				Cache.save(_cache_id, d);
				if (types == "media") {
					$("#" + "media_" + div_id).html(Cache.get(_cache_id));
				} else {
					$("#" + "user_" + div_id + types)
							.html(Cache.get(_cache_id));
				}
			}
		});
		if (types == "media") {
			$("#" + "media_" + div_id).html(Cache.get(_cache_id));
		} else {
			$("#" + "user_" + div_id + types).html(Cache.get(_cache_id));
		}
	}, 500);
}

//鼠标定位 获取坐标
function mousePosition(ev) {

	if (ev.pageX || ev.pageY) {
		return {
			x : ev.pageX,
			y : ev.pageY
		};
	}
	return {
		x : ev.clientX + document.body.scrollLeft - document.body.clientLeft,
		y : ev.clientY + document.body.scrollTop - document.body.clientTop
	};
}

//微博内容 @用户 提示框
function get_at_user_choose(nickname, types, tid, ev) {
	//鼠标定位 获取坐标
	var mousePos = mousePosition(ev);
	var mouseX = mousePos.x;
	var mouseY = mousePos.y;

	clear_user_choose();
	var div_id = tid;
	var _cache_id = tid;
	authort = setTimeout(
			function() {
				var myAjax = $
						.post(
								"ajax.php?mod=topic&code=usermenu",
								{
									nickname : nickname
								},
								function(d) {
									if ('' != d) {
										Cache.save(_cache_id, d);

										document.getElementById("at_" + div_id
												+ types).style.scrollTop = mouseY + 'px';
										document.getElementById("at_" + div_id
												+ types).style.left = mouseX + 'px';

										document.getElementById("at_" + div_id
												+ types).style.display = "block";

										$("#" + "at_" + div_id + types).html(
												Cache.get(_cache_id));
									}
								});
				$("#" + "at_" + div_id + types).html(Cache.get(_cache_id));

			}, 500);
}

//删除已上传的视频
function DelVideo(videoid, types) {

	var videoid = $('#' + videoid).val();
	var videoid = 'undefined' == typeof (videoid) ? 0 : videoid;
	//alert(videoid);return false;
	if (videoid > 0) {
		$
				.post('ajax.php?mod=topic&code=delete_video',
						{
							id : videoid
						},
						function(d) {
							if ('' != d) {
								;
							} else {
								//通过ajax上传视频后 删除视频清除输入框内的内容和缩略图
						if (types == 'video_ajax') {
							parent.document.getElementById('upload_video_list').style.display = 'none';
							parent.document.getElementById('add_video').style.display = 'block';
							parent.document.getElementById('i_already').value = '';
						}
					}
				});
		videoid = 0;
	}
	listTopic(0, 0);
}

function clear_user_choose() {
	clearTimeout(authort);
}

/**
 * 通过JS消息提示，在显示设定时间后隐藏
 * @param show_message 提示的消息内容 如 “发布成功”；默认为空
 * @param show_time 消息显示的时间，单位为秒；默认显示 “3” 秒
 * @param show_title 提示的消息标题，默认为“提示”
 * @param tigBoxClass 消息提示层所使用的样式，默认为“tigBox_6”
 */
function show_message(show_message, show_time, show_title, tigBoxClass) {
	var show_message = (undefined == show_message ? '' : show_message);

	if (show_message) {
		var show_time = (undefined == show_time ? 1 : show_time);
		var show_title = (undefined == show_title ? '提示' : show_title);
		var tigBoxClass = (undefined == tigBoxClass ? 'tigBox_6' : tigBoxClass);

		var smaHTML = '<div id="tigBox" class="' + tigBoxClass
				+ '"><ul class="warnBox"><li><div class="tt1">' + show_title
				+ '</div><div class="wWarp"><div class="wwsp">' + show_message
				+ '</div></div></li></ul></div>';
		$('#show_message_area').html(smaHTML);

		var tigBoxObj = document.getElementById("tigBox");

		tigBoxObj.style.visibility = "visible";

		var i = 0;

		setTimeout(function() {
			i += 1;
			tigBoxObj.style.visibility = "hidden";
		}, (show_time * 1000));
	}
}

//对话、拉黑弹出操作框
function follower_choose(uid, nickname, types, template) {
	var uid = 'undefined' == typeof (uid) ? 0 : uid;
	var template = 'undefined' == typeof (template) ? '' : template;
	var eidVal = $("#" + "alert_follower_menu_" + uid).html();

	var myAjax = $
			.post("ajax.php?mod=topic&code=follower_choose", {
				uid : uid,
				nickname : nickname,
				types : types,
				template : template
			},
					function(d) {
						if ('' != d) {
							document.getElementById("alert_follower_menu_"
									+ uid).style.display = "block";
							$("#" + "alert_follower_menu_" + uid).html(d);
							if ('user_face' == template) {
								document.getElementById("topic_user_menu_"
										+ uid).style.display = "none";
							}
						}

					}

			);

}

//取消、加入黑名单
function do_blacklist(uid, touid, types, template) { //alert(template); return false;
	var uid = 'undefined' == typeof (uid) ? 0 : uid;
	var touid = 'undefined' == typeof (touid) ? 0 : touid;
	var types = 'undefined' == typeof (types) ? '' : types;

	var myAjax = $
			.post("ajax.php?mod=topic&code=doblacklist", {
				uid : uid,
				touid : touid,
				types : types,
				template : template
			},
					function(d) {
						if ('' != d) {
							document.getElementById("alert_follower_menu_"
									+ touid).style.display = "none";
							if ('add' == types) {
								$('#div_black_' + touid).html(d);
							} else {
								$('#div_black_' + touid).html(d);
							}

							$("#follow_user_" + touid).remove();
							//listTopic(0,0);
				}
			});
}

//设置个性标签
function user_tag(tagid, tag_name, types) {

	var tagid = 'undefined' == typeof (tagid) ? 0 : tagid;

	if ('add' == types) {
		var tag_name = $('#' + tag_name).val();
		var tag_name = 'undefined' == typeof (tag_name) ? '' : tag_name;
	}

	var myAjax = $.post("ajax.php?mod=topic&code=user_tag", {
		tagid : tagid,
		tag_name : tag_name,
		types : types
	}, function(d) {
		if ('' != d) {
			//show_message('标签设置成功',1);
			document.getElementById("tags_name").value = "";
			$("#user_tag_list").html($("#user_tag_list").html() + d);
		}
		$("#del_tag_" + tagid).remove();
	});
}
//删除个性标签
function del_tag(tag_id) {
	var tag_id = 'undefined' == typeof (tag_id) ? 0 : tag_id;

	var myAjax = $.post("ajax.php?mod=topic&code=del_tag", {
		tag_id : tag_id
	}, function(d) {
		if ('' != d) {
			$("#del_id_" + tag_id).remove();
		}
	});
}

function get_tag_insert(tag_name) {
	var tag_value;
	tag_value = document.getElementById('i_already').value;
	tag_value = tag_value + '#' + tag_name + '#';
	document.getElementById('i_already').focus();
	document.getElementById('i_already').value = tag_value;
}
function tag_insert(tagName) {
	var tag_value;
	tag_value = document.getElementById('i_already').value;
	tag_value = tag_value + '#' + tagName + '#';
	document.getElementById('i_already').focus();
	document.getElementById('i_already').value = tag_value;
}
function nickname_insert(at_nickname) {
	var tag_value;
	tag_value = document.getElementById('i_already').value;
	tag_value = tag_value + '@' + at_nickname + ' ';
	document.getElementById('i_already').focus();
	document.getElementById('i_already').value = tag_value;
}
//插入自定义话题
function thread_insert(tagname) {

	var document_id = document.getElementById('i_already');

	var con = tagname ? tagname : "插入自定义话题";

	//转载文字
	document_id.value += "#" + con + "#";
	var l = document_id.value.length;
	//创建选择区域	
	if (document_id.createTextRange) {//IE浏览器
		var range = document_id.createTextRange();
		range.moveEnd("character", -l)
		//range.moveStart("character",-l)              
		range.moveEnd("character", l - 1);
		range.moveStart("character", l - 1 - con.length);
		range.select();
	} else {
		document_id.setSelectionRange(l - 1 - con.length, l - 1);
		document_id.focus();
	}

}

//判断同时微博 同时评论 选择状态
function select_checked(topicTypeId, topicTypeVal) {
	var topicTypeId = ('undefined' == typeof (topicTypeId) ? 'topictype'
			: topicTypeId);

	if ($("#" + topicTypeId).attr("checked") == true) {
		document.getElementById(topicTypeId).value = 'both';
	} else {
		var topicTypeVal = ('undefined' == typeof (topicTypeVal) ? 'reply'
				: topicTypeVal);
		if ('reply' != topicTypeVal) {
			topicTypeVal = 'forward';
		}

		document.getElementById(topicTypeId).value = topicTypeVal;
	}
}

//关闭用户弹出框
function close_media_menu(uid) {
	document.getElementById("media_user_list_" + uid).style.display = "none";
	document.getElementById("media_" + uid).style.display = "none";
}

//关闭弹出框
function close_menu(div_id, close_div) {
	$("#" + close_div + "_" + div_id).html("");
	document.getElementById(close_div + "_" + div_id).style.display = "none";
}

//定时刷新
function ajax_reminded(r_uid, is_uptime) {
	var ajax_remindedHTML = $("#ajax_reminded").html();
	ajax_remindedHTML = ('undefined' == typeof (ajax_remindedHTML) ? ''
			: ajax_remindedHTML);

	/*
	 已经存在了提醒内容时就不再请求？可以提高性能，防止空刷新；
	 */
	if ('' != ajax_remindedHTML) {
		//        return false;
	}

	var r_uid = 'undefined' == typeof (r_uid) ? 0 : r_uid;
	var is_uptime = 'undefined' == typeof (is_uptime) ? 0 : is_uptime;

	var myAjax = $.post("ajax.php?mod=reminded&code=show", {
		uid : r_uid,
		is_uptime : is_uptime
	}, function(d) {
		if ('' != d && -1 != d.indexOf('<success></success>')) {
			//alert(d);
			$("#ajax_reminded").html(d);
		}
	});
}

//发送站内消息
function PmSend(touid, to_user, eid) {
	var eid = 'undefined' == typeof (eid) ? 'Pmsend_to_user_area' : eid;
	var to_user = 'undefined' == typeof (to_user) ? '' : to_user;
	var eidVal = $("#" + eid).html();
	if ('' == eidVal) {
		var myAjax = $.post("ajax.php?mod=pm&code=send", {
			to_user : to_user
		}, function(d) {
			if ('' != d) {
				$("#" + eid).html(d);
				//document.getElementById("topic_user_menu_"+touid).style.display="none";
			}
		});
	} else {
		$("#" + eid).html('');
	}
}

function PmSubmit(i, eid, to_user, topmid) {
	var i = 'undefined' == typeof (i) ? 0 : i;

	var message = document.getElementById("message").value;

	if ('' == message) {
		show_message('请输入私信内容', 1);
		return false;
	}

	$("#" + eid).remove();
	var myAjax = $.post("ajax.php?mod=pm&code=do_add", {
		pmid : i,
		message : message,
		to_user : to_user,
		topmid : topmid
	},

	function(d) {
		if ('' != d) {
			alert(d);
			return false;
		} else {
			show_message('私信发送成功', 1);
		}
	});
}

//返回一个UNIX时间戳，和PHP一样的
function time() {
	var _dateObj = new Date();
	var _time = _dateObj.getTime().toString();
	return parseInt(_time.substring(0, _time.length - 3));
}
//JS缓存类，用于缓存AJAX返回结果非常有用
function CacheHandler() {
	this.data = {};
	this.lifeTime = 3600;//默认缓存一小时
	this.setLifeTime = function(lifeTime) {
		this.lifeTime = lifeTime;
	};
	this.save = function(name, value, lifeTime) {
		this.data[name] = {
			expire : time() + (parseInt(lifeTime) || this.lifeTime),
			value : value
		};
		return this.data[name]['value'];
	};
	this.get = function(name) {
		if (this.data[name] == undefined || this.data[name]['expire'] < time())
			return undefined;
		return this.data[name]['value'];
	};
	this.getOrSave = function(name, value, lifeTime) {
		return this.get(name) == undefined && this.save(name, value, lifeTime);
	};
	this.clear = function(name) {
		name ? delete this.data[name] : this.data = {};
	};
}
var Cache = new CacheHandler();//实例化个全局缓存对象

//
function headDoSearch() {
	var searchValue = $('#headq').val();
	var searchType = $('#headSearchType').val();
	var redirectURL = '';
	if ('' == searchValue || 'undefined' == searchValue
			|| '请输入关键字' == searchValue) {
		alert("请输入关键字");
	} else {
		if ('userSearch' == searchType) {
			redirectURL = 'index.php?mod=search&code=user&nickname=' + searchValue;
		} else if ('tagSearch' == searchType) {
			redirectURL = 'index.php?mod=search&code=tag&tag=' + searchValue;
		} else if ('topicSearch' == searchType) {
			redirectURL = 'index.php?mod=search&code=topic&topic=' + searchValue;
		} else if ('voteSearch' == searchType) {
			//加入对投票的search	By ~ZZ~ 2010-04-22
			redirectURL = 'index.php?mod=search&code=vote&q=' + searchValue;
		} else {
			alert("未定义的操作");
		}

		if ('' != redirectURL) {
			window.location.href = thisSiteURL + redirectURL;
		}
	}
	return false;
}

function ProfileSearch() {
	var searchValue = $('#keywarod').val();
	var searchType = $('#ProfileSearchType').val();
	var searchGetType = $('#type').val();

	var redirectURL = '';
	if ('' == searchValue || 'undefined' == searchValue
			|| '请输入关键字' == searchValue) {
		alert("请输入关键字");
	} else {
		if ('user' == searchType) {
			redirectURL = 'index.php?mod=search&code=user&nickname=' + searchValue;
		} else if ('usertag' == searchType) {
			redirectURL = 'index.php?mod=search&code=usertag&usertag=' + searchValue;
		} else if ('topic' == searchType) {
			redirectURL = 'index.php?mod=search&code=topic&topic=' + searchValue;
		} else if ('tag' == searchType) {
			redirectURL = 'index.php?mod=search&code=tag&tag=' + searchValue;
		} else if ('vote' == searchType) {
			//加入对投票的search	By ~ZZ~ 2010-04-22
			redirectURL = 'index.php?mod=search&code=vote&q=' + searchValue;
		} else {
			alert("未定义的操作");
		}

		if ('' != redirectURL) {
			window.location.href = thisSiteURL + redirectURL;
		}
	}
	return false;
}

//表情
function face_insert(facename, insert) {
	//alert(facename);return false;
	var values;
	values = document.getElementById(insert).value;
	values = values + '[' + facename + ']';
	document.getElementById(insert).value = values;
}

function topic_face(eid, insert, getname) {
	//insert = 将表情插入的发布框ID    getname = 引用的表情文件

	var getname = 'undefined' == typeof (getname) ? 'topic_face' : getname;

	var eidVal = $("#" + eid).html();

	if (getname == 'tusiji_face') {
		$("#" + eid).addClass("tusiji_face");
		if ($("#" + eid).hasClass("topic_face")) {
			$("#" + eid).removeClass("topic_face");
		} else {
			$("#" + eid).addClass("tusiji_face");
		}
	} else if (getname == 'topic_face') {

		if ($("#" + eid).hasClass("tusiji_face")) {
			$("#" + eid).removeClass("tusiji_face");
		} else {
			$("#" + eid).addClass("topic_face");
		}
	}
	$("#" + eid).html('<span class="loading"> </span>');

	var myAjax = $.post("ajax.php?mod=face&code=show", {
		eid : eid,
		insert : insert,
		getname : getname
	}, function(d) {
		if ('' != d) {
			$("#" + eid).html(d);
		}
	});

}

//短信 聊天记录
function pmListChat(msgfromid) {
	var i = 'undefined' == typeof (msgfromid) ? 0 : msgfromid;
	var eid = 'undefined' == typeof (eid) ? 'Pmreply_area_' + i : eid;

	var eidVal = $("#" + eid).html();

	if ('' == eidVal) {
		var myAjax = $.post("ajax.php?mod=pm&code=listchat", {
			msgfromid : i
		}, function(d) {
			if ('' != d) {
				$("#chat_list_" + i).html(d);
			}
		});
	} else {
		$("#chat_list_" + i).html('');
	}
}

//勋章首页显示
function open_medal_index(medalid) {

	var medalid = 'undefined' == typeof (medalid) ? 0 : medalid;

	var myAjax = $.post("ajax.php?mod=topic&code=open_mdeal", {
		medalid : medalid
	}, function(d) {
		if ('' != d) {
			//$("#medal_"+medalid).remove();
			show_message('设置成功', 1);
		}
	});
}

String.prototype.trim = function() {
	return this.replace(/(^\s*)|(\s*$)/g, "");
}

/**
 * 检查发布框字符串
 */
function checkPublishText(len, txt_id, tips_id) {
	var src = null;
	src = $('#' + txt_id);
	var str = src.val().trim();
	var myLen = 0;
	var i = 0;
	for (; (i < str.length) && (myLen <= len * 2); i++) {
		if (str.charCodeAt(i) > 0 && str.charCodeAt(i) < 128) {
			myLen++;
		} else {
			myLen += 2;
		}
	}

	if (myLen > len * 2) {
		src.val(str.substring(0, i - 1));
	} else if (!isUndefined(tips_id)) {
		$('#' + tips_id).html(Math.floor((len * 2 - myLen) / 2));
	}
}

/**
 * 检查字符串是否是json代码
 */
function is_json(data) {
	var reg = new RegExp(/^{.*}$/igm);
	if (data.search(reg) != -1) {
		return true;
	}
	return false;
}

/**
 * 对话框
 * @param handle_key		对话框的唯一标识，确保它的唯一性
 * @param module			对话框的模式。
 *	module='ajax'		:需要设定options={url:'xxxx'}
 *	module='local'		:需要设定options={html:'xxxx'},对话框内直接显示options.html的值或者使用option.id对话框内会直接显示id中html内容
 *	module='message'	:需要设定options中的type，
 *	告警对话框type='warning'	:需要设定options={type:'warning',button_name:'确定',text:'你没有权限进行当前操作',onclick:''}
 *	确认对话框type='confirm'	:需要设定options={type:'warning',yes_button_name:'确定',no_button_name:'取消',
 *								 text:'你确定要进行这项操作吗?'，onclick:''}
 *	module='loading'	:需要设定options={text:'正在加载'}
 * @param width				对话框宽。
 */
var __DialogHtml__ = new Array();
function showDialog(handle_key, module, title, options, width)
{
	if (!width) {
        width = 400;
    }
    var handle = DialogManager.create(handle_key);
    handle.setTitle(title);
	if (module == 'local') {
		var html = '';
		if (isUndefined(__DialogHtml__[handle_key])) {
			if (options.html) {
				html = options.html;
			} else if (options.id) {
				html = $('#'+ options.id).html();
				$('#'+ options.id).html('');
			} else {
				html = '';
			}
			__DialogHtml__[handle_key] = html;
		} else {
			html = __DialogHtml__[handle_key];
		}
		handle.setContents(html);
	} else if (module == 'ajax') {
		//暂时这样写，可以以后会else里面不一样的
		//加上默认的错误处理
		if (!options.checkerror) {
			options.checkerror = function (data) {
				if (is_json(data)) {
					var json = eval('('+data.toString()+')');
					closeDialog(handle_key);
					MessageBox('warning', json.msg);
					return false;
				}
				return true;
			};
		}
		handle.setContents(module, options);
	} else {
		handle.setContents(module, options);
	}
    handle.setWidth(width);
    handle.show('center');
    return handle;
}

/**
 * 关闭对话框
 */
function closeDialog(handle_key)
{
	DialogManager.close(handle_key);
}

/**
 * 设置对话框关闭事件的侦听
 */
function setDialogOnCloseListener(handle_key, func, options)
{
	__DIALOG_WRAPPER__[handle_key].onClose = function() {
		if (options) {
			func(options);
		} else {
			func();
		}
		Dialog.prototype.onClose = function() {return true};
		return true;
	}
}

/**
 * 消息提示框
 */
function MessageBox(type, msg, title, options)
{
	if (isUndefined(options)) {
		options = {};
	}
	
	if (type == 'notice') {
		handle_key = 'notice_dialog';
		clickEvent = null;
		close_first = false;
		if (options.onclick) {
			clickEvent = options.onclick;
		}
		if (options.close_first) {
			close_first = options.close_first;
		}
		param = {type:'notice',button_name:'确定',text:msg, onclick:clickEvent, close_first:close_first};
	} else if (type == 'warning') {
		handle_key = 'warning_dialog';
		clickEvent = null;
		close_first = false;
		if (options.onclick) {
			clickEvent = options.onclick;
		}
		if (options.close_first) {
			close_first = options.close_first;
		}
		param = {type:'warning',button_name:'确定',text:msg, onclick:clickEvent, close_first:close_first};
	} else if (type == 'confirm') {
		handle_key = 'confirm_dialog';
		var onClickYes = null;
		var onClickNo = null;
		if (options.onClickYes) {
			onClickYes = options.onClickYes;
		}
		if (options.onClickNo) {
			onClickNo = options.onClickNo;
		}		
		param = {type:'confirm',yes_button_name:'确定',no_button_name:'取消',text:msg,onClickYes:onClickYes,onClickNo:onClickNo};
	}
	if (!title || title == '') {
		title = '提示'
	}
	showDialog(handle_key, 'message', title, param, 300);
}

/**
 * 应用中的微博发布
 */
function publishSimpleTopic(content, appitem, appitem_id, options)
{
	if (!options) {
		options = {};
	}
	
	if (isUndefined(content) || content == '') {
		MessageBox('warning', '请输入微博');
		return false;
	}
	
	if (lastPublishSubmitContent == content) {
        MessageBox('warning', '不要贪心哦，发一次就够啦。');
        return false;
    } else {
		lastPublishSubmitContent = content;
    }
	
	var topictype = '';
	if (options.topic_type) {
		topictype = options.topic_type;
	} else {
		topictype = 'first';
	}
	
	var from = "web";
	if (options.from) {
		from = options.from;
	} else {
		from = appitem;
	}
	
    //开始发布(当前之支持发布文字，其他的以后用到的时候加入)
	var myAjax = $.post(
		"ajax.php?mod=topic&code=do_add&act=reply",
		{
			topictype:topictype,
			from:from,
			content:content,
			item:appitem,
			item_id:appitem_id
		},
		function (d) {
			if (options.response) {
				options.response.call();
			} else {
				location.reload();
			}
		}
	);
	return true;
}

/**
 * 微博类型选择(应用)
 */
function selectAppTopicType(id, options)
{
    id = (isUndefined(id) ? 'topictype' : id);
	if (!options) {
		options = {};
	}
	
	var input = $("#" + id);
	if (options.toid) {
		out = $('#'+options.toid);
	} else {
		out = input;
	}
	
	//默认的微博客类型
	var defTopicType = 'reply';
	if (options.defTopicType) {
		defTopicType = options.defTopicType;
	}
	
	if (input.attr("checked") == true) {
		out.val('first');
	} else {
		out.val(defTopicType);
	}
}

/**
 * 获取应用活动
 */
var __AppActivityHandleKey__ = new Array();
function getAppActivity(appMod, appCode, appWpId, options)
{
	if (isUndefined(options)) {
		options = {};
	}
	if (!isUndefined(__AppActivityHandleKey__[appCode])) {
		return ;
	}
	__AppActivityHandleKey__[appCode] = true;
	var arf = '';	//apprequestfrom
	if (options.arf) {
		arf = '&arf='+options.arf;
	}
	appUrl = 'ajax.php?mod='+appMod+'&code='+appCode+arf;
	var retType = 'html';
	if (options.retType) {
		reType = options.retType;
	}
	$.get(
		appUrl,
		{},
		function(r) {
			if (options.response) {
				options.response.call();
			} else if (appWpId) {
				if (is_json(r)) {
					var json = eval('('+r+')');
					$('#'+appWpId).html(json.msg);
				} else {
					$('#'+appWpId).html(r);
				}
			}
		},
		retType
	);
}

/**
 * 从首页获取投票应用
 */
function getVoteAvtivityFromIndex(appCode, appWpId)
{
	var options = {
		arf:'index'
	};
	getAppActivity('vote', appCode, appWpId, options);
}


/**
 * 获取我的投票列表
 */
function getMyVoteList(page, options)
{
	if (isUndefined(options)) {
		options = {};
	}
	var dataUrl = 'ajax.php?mod=vote&code=my_vote&page='+page;
	$.get(
		dataUrl,
		{},
		function(r) {
			if (options.response) {
				options.response.call();
			} else{
				if (is_json(r)) {
					var json = eval('('+r+')');
					$('#con_vote_content_2').html(json.msg);
				} else {
					$('#con_vote_content_2').html("<h3>下面是你发起的投票，可以选择某个投票添加到微博：</h3>"+r);
				}
			}
		}
	);
}

/**
 * 从数组中删除一个指定值元素(一维数组)
 */
function remove_ele(ary, val)
{
	var ary2 = Array();
	for (var i in ary) {
		if (ary[i] != val) {
			ary2[i] = ary[i];
		}
	}
	return ary2;
}

/**
 * 指定值是否存在数组中
 */
function in_array(needle, haystack)
{
	if(typeof needle == 'string' || typeof needle == 'number') {
		for(var i in haystack) {
			if(haystack[i] == needle) {
					return true;
			}
		}
	}
	return false;
}


