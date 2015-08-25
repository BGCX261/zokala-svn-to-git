<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<jsp:include page="baseurl.jsp"></jsp:include>
		<link href="templates/default/t2.css" rel="stylesheet" type="text/css">
			<link href="templates/default/index.css" rel="stylesheet"
				type="text/css">
				<title>全明星微博</title>
				<style type="text/css">
body {
	color: #333333;
	background-color: #73CFF1;
	background-position: center top;
}

a:link {
	color: #2B4A78;
}
</style>
	</head>

	<body>

		<!-- 顶部导航栏 -->
		<jsp:include page="banner.jsp"></jsp:include>
		<!-- 顶部导航栏 -->
		<div id="headWrap">
			<h1 id="logo">
				<a title="全明星微博" href="index.html"></a>
			</h1>
		</div>
		<div id="mainWrapper">
			<div id="topbox">
				<div id="tleft">
					<div id="swfContent"></div>

					<!--热门话题-->
					<div class="talking">
						<jsp:include page="topic.jsp"></jsp:include>
					</div>
					<!--热门话题-->
				</div>
				<!--注册登录-->
				<div class="loginbox">
					<s:if test="#session.minilogUser!=null">
						<!-- 用户已登录 -->
						<jsp:include page="userinfo.jsp"></jsp:include>
						<!-- 用户已登录 -->
					</s:if>
					<s:else>
						<!--注册登录-->
						<jsp:include page="login.jsp"></jsp:include>
						<!--注册登录-->
					</s:else>
				</div>
			</div>
			<div id="midBox">
				<!-- 用户推荐 -->
				<div class="mleft">
					<jsp:include page="recomend_user.jsp"></jsp:include>
				</div>
				<!-- 用户推荐 -->
				<!-- 用户正在的微博 -->
				<div class="mcenter">
					<jsp:include page="plaza_minilog.jsp"></jsp:include>
				</div>
				<!-- 用户正在的微博 -->
				<!-- 通知 -->
				<div class="mright">
					<jsp:include page="notice.jsp"></jsp:include>
				</div>
				<!-- 通知 -->
			</div>
		</div>
		<!-- 版权声明 -->
		<jsp:include page="copyright.jsp"></jsp:include>
		<!-- 版权声明 -->
	</body>
</html>