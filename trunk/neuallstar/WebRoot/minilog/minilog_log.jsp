<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<div class="one_comment">
	<li class="font14px">
		<div class="feedCell feedP">
			${minilog.content}
			<br>
		</div>
	</li>

	<li>
		<span class="spanLeft fontGray"> ${minilog.time} </span>
		<br>
		<span class="spanRight"> <span> <a
				href="javascript:void(0)"
				onclick="deleteTopic(23,&#39;topic_list}_23&#39;,&#39;view&#39;);return false;">删除</a>
				|&nbsp; </span> <span id="favorite_23"><a href="javascript:void(0)"
				onclick="favoriteTopic(23);return false;">收藏</a> </span>
		</span>
	</li>
</div>



