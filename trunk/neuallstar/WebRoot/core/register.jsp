<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<jsp:include page="baseurl.jsp"></jsp:include>
		<title>注册|东北大学全明星</title>
		<script type="text/javascript" src="templates/default/js/jquery.js">
</script>

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
					<div class="slider2">
						<h2>
							用户注册
						</h2>
					</div>
					<div class="clr"></div>

				</div>
			</div>
			<div class="body">
				<div class="body_resize">
					<div class="left">
						<h2>
							请认真填写以下信息，*为必填项
						</h2>
						<script type="text/javascript" language="javascript">
function check() {
	alert("请填写正确的邀请码");
	return false;
}
</script>
						<form action="register.html" method="post" id="contactform">
							<ol>
								<li>
									<label for="regcode">
										邀请码 *
									</label>
									<span>(邀请码为一个20字母长度的字符串，用户注册成功后能够获得2个邀请码)</span>
									<input id="inviteCode" name="inviteCode" class="text" />
								</li>
								<li>
									<label for="name">
										登录名 *
									</label>
									<input id="name" name="user.username" class="text" />
								</li>
								<li>
									<label for="email">
										密码
										<span class="red">*</span>
									</label>
									<input id="password" type="password" name="user.password"
										class="text" />
								</li>
								<li>
									<label for="email">
										确认密码
										<span class="red">*</span>
									</label>
									<input id="confirm" type="password"
										onblur="passwordconfirm(this, document.getElementById('password'))"
										class="text" />
								</li>
								<script language="javascript" type="text/javascript">
function passwordconfirm(a, b) {
	if (a.value != b.value) {
		alert("密码和确认密码不一致，请重新输入");
		a.value = "";
		b.value = "";
	}
}
</script>

								<li>
									<label for="nickname">
										昵称 *
									</label>
									<input id="nickname" name="user.nickname" class="text" />
								</li>
								<li>
									<label for="gender">
										性别
									</label>
									<input id="genderman" type="radio" name="user.gender" value="男" />
									男

									<input id="genderwoman" type="radio" name="user.gender"
										value="女" />
									女
								</li>
								<li style="clear: left">
									<label for="hometown">
										籍贯
									</label>
									<input id="hometown" name="user.hometown" class="text" />
								</li>
								<li>
									<label for="birthday">
										生日
									</label>
									<input id="birthday" name="user.birthday" class="text" />
								</li>
								<li>
									<label for="avatar">
										头像
									</label>
									<input id="avatar" name="avatar" type="file" />
								</li>
								<li>
									<label for="schoole">
										学校
									</label>
									<input id="school" name="user.school" class="text" />
								</li>
								<li>
									<label for="college">
										学院
									</label>
									<input id="college" name="user.college" class="text" />
								</li>
								<li>
									<label for="major">
										专业
									</label>
									<input id="major" name="user.major" class="text" />
								</li>
								<li>
									<label for="studentId">
										学号
									</label>
									<input id="studentId" name="user.studentId" class="text" />
								</li>
								<li>
									<label for="industry">
										所属行业
									</label>
									<input id="industry" name="user.industry" class="text" />
								</li>
								<li>
									<label for="company">
										公司
									</label>
									<input id="company" name="user.company" class="text" />
								</li>
								<li>
									<label for="position">
										职位
									</label>
									<input id="position" name="user.position" class="text" />
								</li>
								<li>
									<label for="district">
										所在片区
									</label>
									<input id="district" name="user.district" class="text" />
								</li>

								<li>
									<label for="location">
										现在地址
									</label>
									<input id="location" name="user.location" class="text" />
								</li>
								<li>
									<label for="zip">
										邮政编码
									</label>
									<input id="zip" name="user.zip" class="text" />
								</li>
								<li>
									<label for="email">
										E-Mail
									</label>
									<input id="email" name="user.email" class="text" />
								</li>
								<li>
									<label for="msn">
										MSN
									</label>
									<input id="msn" name="user.msn" class="text" />
								</li>
								<li>
									<label for="qq">
										Q Q
									</label>
									<input id="qq" name="user.qq" class="text" />
								</li>
								<li>
									<label for="phone">
										电话号码
									</label>
									<input id="phone" name="user.phone" class="text" />
								</li>
								<li>
									<!-- 
									<input type="submit" /> -->
									<input type="submit" name="imageField" id="imageField"
										src="core/templates/default/images/send.gif" />
								</li>
							</ol>
						</form>
						<br />
						<br />
					</div>
					<div class="right">
						<h2>
							注册说明
						</h2>

						<p class="grey">
	<!-- 						<strong>Tel:</strong> +123456789
							<br />
							<strong>Fax:</strong> +123456789
							<br />
							<strong>Email:</strong> company@domainname.com -->
							全明星网站注册用户现在仅限于有邀请码的用户注册。所有注册用户务必遵守以下条例：
						</p>
						<p>
							1. 遵守全明星相关的条例规范。
						</p>
						<p>
							2. 至少参加过全明星的活动一次。
						</p>
						<p>
							3. 能够在全明星发展过程中提出好的建议，看法。
						</p>
						<p class="grey">
							&nbsp;
						</p>
						<!-- 	<img src="images/twitter.jpg" width="82" height="49" alt="img" />
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
			<!-- 版权声明-->
			<jsp:include page="copyright.jsp"></jsp:include>
			<!-- 版权声明-->
		</div>
	</body>
</html>