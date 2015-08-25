<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<h3 class="htitle2">
	新人推荐
</h3>
<s:if test="#session.minilogUser!=null">
	<table>
		<s:iterator value="musers" id="muser">
			<tr>
				<td>
					<a target="_blank" href="user.html?muser.muid=${muser.muid }"
						title="${muser.nickname }"> <img height="60" width="60"
							src="${muser.avatar }" alt="${muser.nickname }"> </a>
				</td>
				<td>
					<ul style="padding-left: 10px;">
						<li>
							<a href="user.html?muser.muid=${muser.muid }"
								title="@${muser.nickname }" />${muser.nickname }</a>
						</li>
						<li>
							<a href="javascript:follow(${muser.muid },'follow_${muser.muid}','add')" /> <img alt="关注"
									src="templates/default/add_2.gif"> </a>
						</li>
					</ul>
				</td>
			</tr>
		</s:iterator>
	</table>
</s:if>
