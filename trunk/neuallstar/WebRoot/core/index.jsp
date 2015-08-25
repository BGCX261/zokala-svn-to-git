<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<jsp:include page="baseurl.jsp"></jsp:include>
		<title>首页|东北大学全明星社团</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<script type="text/javascript" charset="utf-8">
// <![CDATA[
$(document).ready(function() {
	$("#slider").easySlider( {
		controlsBefore : '<p id="controls">',
		controlsAfter : '</p>',
		auto : true,
		continuous : true
	});
});
// ]]>
</script>
		<style type="text/css">
#slider {
	margin: 0 auto;
	padding: 0;
	list-style: none;
	width: 920px;
}

#slider ul,#slider li {
	margin: 0;
	padding: 0;
	list-style: none;
}

/* 
    define width and height of list item (slide)
    entire slider area will adjust according to the parameters provided here
*/
#slider li {
	width: 920px;
	overflow: hidden;
	padding: 0;
	margin: 0 auto;
}

p#controls {
	margin: 0;
	position: relative;
}

#prevBtn,#nextBtn {
	display: block;
	margin: 0;
	overflow: hidden;
	width: 15px;
	height: 30px;
	position: absolute;
	left: 5px;
	top: -135px;
}

#nextBtn {
	left: 952px;
}

#prevBtn a {
	display: block;
	width: 15px;
	height: 30px;
	background: url(core/templates/default/images/l_arrow.gif) no-repeat 0 0
		;
}

#nextBtn a {
	display: block;
	width: 15px;
	height: 30px;
	background: url(core/templates/default/images/r_arrow.gif) no-repeat 0 0
		;
}
</style>
	</head>
	<body>
		<div class="main">
			<div class="header">
				<div class="block_header">
					<div class="search">

					</div>

					<div class="clr"></div>
					<!-- 导航 -->
					<jsp:include page="nav.jsp"></jsp:include>
					<!-- 导航 -->
					<div class="slider">
						<div class="slice1">
							<div class="slice2" id="slider">
								<ul>
									<li>
										<div style="height: inherit;">
											<p class="img">
												<img src="core/templates/default/images/6.png"
													alt="screen 1" width="404" height="271" />
											</p>
											<h2>
												全明星社团
											</h2>
											<p>
												全明星社团即为全明星大家庭在东北大学的学生组织，是全明星大家庭的核心。在材料与冶金学院团委直接领导下开展各项工作，同时全明星社团接受全明星校友会和全明星导师团的关心和指导。全明星社团以《星际》为总章程，为保证团队安全运营，组建了FTO核心管理团队。现在全明星社团是由英语平台、共赢平台、赛扶平台、公益平台、基础学院分部等五大业务平台以及人力资源体系、财务体系、市场公关体系三大职能支持体系构成，社团在职人员已经超过100人。
											</p>
											<p>
												&nbsp;
											</p>
											<p><!-- 
												<a href="google.com"><img
														src="core/templates/default/images/View_serv.gif"
														width="142" height="30" border="0" alt="view" /> </a>
												<a href="google.com"><img
														src="core/templates/default/images/What_we_do.gif"
														width="142" height="30" border="0" alt="view" /> </a>
										 -->	</p>
										</div>
									</li>
									<li>
										<div>
											<p class="img">
												<img src="core/templates/default/images/4.png"
													alt="screen 1" width="404" height="271" />
											</p>
											<h2>
												全明星校友会
											</h2>
											<p>
												全明星校友会，致力于搭建在校会员和毕业校友之间的联系
											</p>
											<p>
												&nbsp;
											</p>
											<p><!-- 
												<a href="google.com"><img
														src="core/templates/default/images/View_serv.gif"
														width="142" height="30" border="0" alt="view" /> </a>
												<a href="google.com"><img
														src="core/templates/default/images/What_we_do.gif"
														width="142" height="30" border="0" alt="view" /> </a>
										 -->	</p>

										</div>
									</li>
									<li>
										<div>
											<p class="img">
												<img src="core/templates/default/images/5.png"
													alt="screen 1" width="404" height="271" />
											</p>
											<h2>
												学习小组平台
											</h2>
											<p>
												Lorem Ipsum as their default model text, and a search for
												'lorem ipsum' will uncover many web sites still in their
												infancy. Contrary to popular belief, Lorem Ipsum is not
												simply random text. It has roots in a piece of classical
												Latin literature from 45 BC, making it over 2000 years old.
											</p>
											<p>
												&nbsp;
											</p>
											<p>
												<a href="google.com"><img
														src="core/templates/default/images/View_serv.gif"
														width="142" height="30" border="0" alt="view" /> </a>
												<a href="google.com"><img
														src="core/templates/default/images/What_we_do.gif"
														width="142" height="30" border="0" alt="view" /> </a>
											</p>
										</div>
									</li>
									<li>
										<div>
											<p class="img">
												<img src="core/templates/default/images/5.png"
													alt="screen 1" width="404" height="271" />
											</p>
											<h2>
												学习小组平台2
											</h2>
											<p>
												Lorem Ipsum as their default model text, and a search for
												'lorem ipsum' will uncover many web sites still in their
												infancy. Contrary to popular belief, Lorem Ipsum is not
												simply random text. It has roots in a piece of classical
												Latin literature from 45 BC, making it over 2000 years old.
											</p>
											<p>
												&nbsp;
											</p>
											<p>
												<a href="google.com"><img
														src="core/templates/default/images/View_serv.gif"
														width="142" height="30" border="0" alt="view" /> </a>
												<a href="google.com"><img
														src="core/templates/default/images/What_we_do.gif"
														width="142" height="30" border="0" alt="view" /> </a>
											</p>
										</div>
									</li>
								</ul>
							</div>
						</div>
					</div>
					<div class="clr"></div>

				</div>
			</div>
			<div class="body">
				<div class="body_resize">
					<div class="left">
						<h2>
							东北大学全明星社团欢迎您!
						</h2>

						<p>
							全明星社团即为全明星大家庭在东北大学的学生组织，是全明星大家庭的核心。在材料与冶金学院团委直接领导下开展各项工作，同时全明星社团接受全明星校友会和全明星导师团的关心和指导。全明星社团以《星际》为总章程，为保证团队安全运营，组建了FTO核心管理团队。现在全明星社团是由英语平台、共赢平台、赛扶平台、公益平台、基础学院分部等五大业务平台以及人力资源体系、财务体系、市场公关体系三大职能支持体系构成，社团在职人员已经超过100人。
							<!-- <a href="introduce.html" class="green" style="float: right;">more...</a> -->
						</p>
						<p>
							&nbsp;
						</p>
						<h2>
							近期活动通知
						</h2>

						<p>
							新学期开始，各大社团的活动纷至沓来，同学们擦亮眼睛哦，怎么样才能真正的提高自己呢？让我们期待全明星近期活动！
						</p>

						<p>
							<strong>全明星秋季季度大会</strong>
							<br />
							每个季度的季度大会都是全明星的大型活动，期间将会对全明星社团有一个整体全面的介绍，同时也会发布一下一季度的规划，以及吸纳新的会员，想要加入全明星的童鞋们，抓住机会哦！
						</p>
						<p>
							<a href="#" class="green"></a>
						</p>
						<div class="bg"></div>

						<p>
							<strong>英语晨读</strong>
							<br />
							全明星英语晨读是全明星的常规活动，每天早上6：20至7：20在综合楼北广场进行，无论风雨寒暑都不间断。
						</p>
						<p>
							<a href="#" class="green"></a>
						</p>
					</div>
					<div class="right">
						<h2>
							登录
						</h2>
						<form method="post" action="login.html">
							<p class="green">
								用户名
								<input name="user.username">
							</p>

							<p class="green">
								密 &nbsp;&nbsp; 码
								<input type="password" name="user.password">
							</p>
							<p class="green" style="margin-left: 40px;">
								<input type="checkbox" name="savelogin">
									记住密码 
							</p>
							<p class="green" style="margin-left: 40px;">
								<input type="submit" value="登录">
									<a href="register.html"
										style="float: right; margin-right: 100px;">注册全明星帐号</a>
							</p>

							<p>
								&nbsp;
							</p>
						</form>
						<h2>
							相关信息
						</h2>
						<p>
							以下信息有助于你更全面的了解东大全明星。
						</p>
						<p class="grey">
							<strong>百度百科:</strong><a
								href="http://baike.baidu.com/view/2549504.htm" target="_blank">http://baike.baidu.com/view/2549504.htm</a>
							<br />
							<strong>人人:</strong><a
								href="http://page.renren.com/670000095/index" target="_blank">http://page.renren.com/670000095/index</a>
<br />
							<strong>微群:</strong><a href="http://q.weibo.com/605140"
								target="_blank">http://q.weibo.com/605140</a>
							<br />
						</p>
						<p class="grey">
							&nbsp;
						</p><!-- 
						<img src="core/templates/default/images/twitter.jpg" width="82"
							height="49" alt="img" />
						<p>
							Vestibulum posu eros vitae nunc
						</p>
						<p class="blye">
							twitter.com/yourusername
						</p> -->
					</div>
					<div class="clr"></div>
					<div class="clr"></div>
				</div>
				<div class="clr"></div>
			</div>
			<jsp:include page="copyright.jsp"></jsp:include>
		</div>
	</body>
</html>