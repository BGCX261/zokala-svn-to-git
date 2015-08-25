<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<h1 class="htitle">
	新鲜事，新鲜观点
</h1>

<style type="text/css">
.oriTxt {
	margin: 0;
}

.feedCell .from {
	padding: 0;
}

.option {
	width: 10px;
	display: none;
	overflow: hidden;
}
</style>

<div id="Pcontent"
	style="z-index: 100; position: absolute; height: 550px; overflow: hidden; margin: 0;">
	<s:iterator value="minilogs" id="minilog">
		<div class="indexrow" style="display: block;" id="indexrowid">
			<div class="feedCell" style="width: 404px; overflow: hidden">
				<div class="avatar">
					<a href="user.html?muser.muid=${minilog.publisher.muid}"> <s:if
							test="minilog.publisher.avatar!=null"></s:if> <s:else>
							<img src="templates/default/no.gif">
					</a>
					</s:else>
				</div>
				<div class="Contant">
					<div class="oriTxt">
						<p>
							<a title="${minilog.publisher.nickname}"
								href="user.html?muser.muid=${minilog.publisher.muid}">${minilog.publisher.nickname}</a>：
							<span>${minilog.content}</span>
						</p>
					</div>
<!-- 转发开始 -->
					<s:if test="%{#minilog.from!=null}">
						<div class="blogTxt">
							<div class="top"></div>
							<div class="mid">

								<p>
									<span><a
										href="user.html?muser.muid=${minilog.from.publisher.muid }">${minilog.from.publisher.nickname
											}</a> : ${minilog.from.content}</span>
								</p>
								
								<s:if test="minilog.from.additions!=null">
									
								<!-- 循环附加信息 -->
								<ul class="imgList">
									<!-- 图片信息 -->
										<s:iterator value="minilog.from.addtions" id="addition"> 
									<!-- 循环图片 -->
									<li>
									<s:if test="addition.type=\"image\"">
										<a href="${addition.content} "
											class="miniImg artZoom"><img
												src="${addition.content}"> </a>
												</s:if>
									</li>
									 	</s:iterator> 
								</ul> 
								</s:if> 
							</div>
							<div class="bottom"></div>
						</div>
					</s:if>
	<!-- 转发结束 -->
	<!-- 图片，视频等开始 -->
					<s:if test="minilog.additions!=null">
						
					<!-- 循环附加信息 -->
					<ul class="imgList">
						<!-- 图片信息 -->
						<s:iterator value="minilog.additions" id="addition">
						<!-- 循环图片 -->
						<li><s:if test="addition.type=\"image\"">
							<a href="${addition.content} "
											class="miniImg artZoom"><img
												src="${addition.content}"> </a>
							</s:if>
						</li>
						</s:iterator>
					</ul>
					
					</s:if>
						<!-- 图片，视频等结束 -->
					<div class="from">
						<div class="option">
							<ul>ff
							</ul>
						</div>
						<div class="mycome">
							发布于${minilog.time }
						</div>
					</div>
				</div>
			</div>
			<!-- <div class="mBlog_linedot" style="width: 404px; overflow: hidden"></div> -->
		</div>
	</s:iterator>
</div>