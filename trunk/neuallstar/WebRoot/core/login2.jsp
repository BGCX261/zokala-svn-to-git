<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<form action="login.html" method="post">
	<SPAN><s:text name="login.username"></s:text> <input type="text"
			class="username_input" name="user.username" /> </SPAN>
	<SPAN><s:text name="login.password"></s:text> <input
			type="password" class="password_input" name="user.password" /> </SPAN>
	<span><input type="checkbox" name="rememberlogin"
			class="remember_checkbox" /> <s:text name="login.rememberlogin"></s:text>
	</span>
	<span> <input type="submit"
			value="<s:text name="login.submit"></s:text>" class="login_submit" />
		<a href="register.html"><s:text name="login.register"></s:text> </a> </span>
</form>