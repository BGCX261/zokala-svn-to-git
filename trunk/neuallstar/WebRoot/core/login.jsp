<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<form action="login.html" method="post">
	<table cellspacing="10px"  width="100%" class="logintable">
		<tr>
			<td align="right" width="20%">
				<s:text name="login.username"></s:text>
			</td>
			<td align="left">
				<input type="text" class="username_input" name="user.username" />
			</td>
		</tr>
		<tr>
			<td align="right">
				<s:text name="login.password"></s:text>
			</td>
			<td align="left">
				<input type="password" class="password_input" name="user.password" />
			</td>
		</tr>
		<tr>
			<td align="right"></td>
			<td align="left">
				<input type="checkbox" name="rememberlogin" class="remember_checkbox" />
				<span><s:text name="login.rememberlogin"></s:text></span>
			</td>
		</tr>
		<tr>
			<td align="right"></td>
			<td align="left">
				<input type="submit" value="<s:text name="login.submit"></s:text>"  class="login_submit" />
			<span class="reg_link" ><a href="register.html"><s:text name="login.register"></s:text></a></span>
			</td>
		</tr>
	</table>
</form>