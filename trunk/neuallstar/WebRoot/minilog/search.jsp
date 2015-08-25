<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<div class="searchTool">
	<form method="get" action="#"
		name="headSearchForm" id="headSearchForm"
		onsubmit="return headDoSearch();">
		<input id="headSearchType" name="searchType" type="hidden"
			value="userSearch">
		<div class="selSearch">
			<div class="nowSearch" id="headSlected"
				onclick="if(document.getElementById(&#39;headSel&#39;).style.display==&#39;none&#39;){document.getElementById(&#39;headSel&#39;).style.display=&#39;block&#39;;}else {document.getElementById(&#39;headSel&#39;).style.display=&#39;none&#39;;};return false;"
				onmouseout="drop_mouseout(&#39;head&#39;);">
				用户
			</div>
			<div class="btnSel">
				<a href="http://zokala.com/weibo/#"
					onclick="if(document.getElementById(&#39;headSel&#39;).style.display==&#39;none&#39;){document.getElementById(&#39;headSel&#39;).style.display=&#39;block&#39;;}else {document.getElementById(&#39;headSel&#39;).style.display=&#39;none&#39;;};return false;"
					onmouseout="drop_mouseout(&#39;head&#39;);"></a>
			</div>
			<div class="clear"></div>
			<ul class="selOption" id="headSel" style="display: none;">
				<li>
					<a href="http://zokala.com/weibo/#"
						onclick="return search_show(&#39;head&#39;,&#39;userSearch&#39;,this)"
						onmouseover="drop_mouseover(&#39;head&#39;);"
						onmouseout="drop_mouseout(&#39;head&#39;);">用户</a>
				</li>
				<li>
					<a href="http://zokala.com/weibo/#"
						onclick="return search_show(&#39;head&#39;,&#39;tagSearch&#39;,this)"
						onmouseover="drop_mouseover(&#39;head&#39;);"
						onmouseout="drop_mouseout(&#39;head&#39;);">话题</a>
				</li>
				<li>
					<a href="http://zokala.com/weibo/#"
						onclick="return search_show(&#39;head&#39;,&#39;topicSearch&#39;,this)"
						onmouseover="drop_mouseover(&#39;head&#39;);"
						onmouseout="drop_mouseout(&#39;head&#39;);">微博</a>
				</li>
				
			</ul>
		</div>
		<input class="txtSearch" id="headq" name="headSearchValue" type="text"
			value="输入关键字" onfocus="this.value=&#39;&#39;">
		<div class="btnSearch">
			<a href="#"
				onclick="javascript:return headDoSearch();"><span class="lbl">搜
					索</span> </a>
		</div>
	</form>
</div>
