<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>


<div class="login_area">
	<form method="POST"
		action="../login.html">
		<input type="hidden" name="next" value="minilog/index.html">
		<div class="item">
			<label for="username" class="labelTag">
				用户名：
			</label>
			<span class="enterInput"> <input type="text" name="user.username"
					class="inputtextTag"> </span>
		</div>
		<div class="item">
			<label for="password" class="labelTag">
				密&nbsp;&nbsp;&nbsp;码：
			</label>
			<span class="enterInput"> <input type="password"
					name="user.password" class="inputtextTag"> </span>
		</div>
		<div class="item pos_rel">
			<label class="labelTag">
				&nbsp;
			</label>
			<span class="enterInput"> <label id="savelogin">
					<input type="checkbox" name="savelogin" class="inputcheckTag"
						checked="" title="请不要在公共电脑上使用自动登录功能">
					下次自动登录
				</label> <a
				onclick="window.location.href=&#39;http://zokala.com/weibo/index.php?mod=get_password&#39;;return false;"
				href="javascript:void(0)" class="forgetPass" title="点此可通过2种方式重设密码">忘记密码？</a>
			</span>
			<div class="login-tiparea autologin-tiparea" id="autologin_tiparea">
				<div class="login-tiparea-top"></div>
			</div>
		</div>
		<div class="clearfix">
			<label class="labelTag">
				&nbsp;
			</label>
			<span class="enterInput"> <input type="submit"
					class="btn_login" value=""> </span>


		</div>
	</form>
</div>
