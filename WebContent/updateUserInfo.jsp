<%@page import="org.ccunix.eshop.model.MemberModel"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<link type="text/css" rel="stylesheet" href="${path}/css/Demo.css">
<script src="${path}/js/index.js"></script>
</head>
<body>
	<div class="con3">
		<%@include file="menu.jsp"%>
		<div class="X_center">
			<div class="X_center01">
				<img alt="" src="${path }/img/EditUser_01.gif">
			</div>
			<form action="" id="registerForm" style="margin: 0px;" method="post" >
				<table width="100%" border="0" cellpadding="0" cellspacing="1"
					bgcolor="#FFFFFF">
					<tr>
						<td height="30" colspan="2">&nbsp;</td>
					</tr>
					<tr bgcolor="#F7F3F7">
						<td width="260" height="26" class="text" align="right">会员级别 ：</td>
						<td height="26" class="text">${sessionScope.userInfo.levelName}</td>
					</tr>
					<tr bgcolor="#F7F3F7">
						<td width="260" height="26" class="text" id="memberName" align="right">真实姓名 ：</td>
						<td height="26"><input type="text" name="memberName"
							size="30" class="textBox" value="${sessionScope.userInfo.memberName}"
							require="true" dataType="Require" msg="真实姓名不能为空!" /></td>
					</tr>
					<tr bgcolor="#F7F3F7">
						<td width="260" height="26" class="text" align="right">登录帐号 ：</td>
						<td height="26"><input type="text" name="username" size="30"
							class="textBox" value="${sessionScope.userInfo.loginName}" require="true"
							dataType="Require" msg="登录名不能为空!" /></td>
					</tr>
					<tr bgcolor="#F7F3F7">
						<td width="260" height="26" class="text" align="right">登录密码 ：</td>
						<td height="26"><input type="password" name="password"
							size="30" class="textBox" /></td>
					</tr>
					<tr bgcolor="#F7F3F7">
						<td width="260" height="26" class="text" align="right">核对密码 ：</td>
						<td height="26"><input name="twopassword" type="password"
							class="textBox" id="reLoginPwd" onBlur="passwordVale()" size="30" /></td>
					</tr>
					<tr bgcolor="#F7F3F7">
						<td width="260" height="26" class="text" align="right">联系电话 ：</td>
						<td height="26"><input type="text" name="phone" size="30"
							class="textBox" value="${sessionScope.userInfo.phone}" require="true"
							dataType="Phone" msg="联系电话不正确!" /></td>
					</tr>
					<tr bgcolor="#F7F3F7">
						<td width="260" height="26" class="text" align="right">联系地址 ：</td>
						<td height="26"><input type="text" name="address" size="30"
							class="textBox" value="${sessionScope.userInfo.address}" require="true"
							dataType="Require" msg="联系地址不能为空!" /></td>
					</tr>
					<tr bgcolor="#F7F3F7">
						<td width="260" height="26" class="text" align="right">邮政编码 ：</td>
						<td height="26"><input type="text" name="zip" size="30"
							class="textBox" value="${sessionScope.userInfo.zip}" require="true"
							dataType="Zip" msg="邮政编码不正确!" /></td>
					</tr>
					<tr bgcolor="#F7F3F7">
						<td width="260" height="26" class="text" align="right">电子邮箱 ：</td>
						<td height="26"><input type="text" name="email" size="30"
							class="textBox" value="${sessionScope.userInfo.email}" require="false"
							dataType="Email" msg="电子邮箱不正确!" /></td>
					</tr>
					<tr>
						<td height="40" colspan="2" align="center"><input
							class="C_Input" type="button" onclick="ajaxSubmit('update')" value="保存" /></td>
					</tr>
					
				</table>
			</form>
		</div>
	<div class="footer" style="border: 1px solid white; height: 30px;">
			<p>版权所有：长春优尼克斯软件有限公司  项目经理：于洋</p>
		</div>
	</div>
<script type="text/javascript" src="${path }/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="${path }/js/validata.js"></script>
<script type="text/javascript" src="${path }/js/register.js"></script>
</body>
</html>