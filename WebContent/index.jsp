<%@page import="org.ccunix.eshop.model.MerchandiseModel"%>
<%@page import="org.ccunix.eshop.model.CategoryModel"%>
<%@page import="java.util.Locale.Category"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>欢迎使用电子商城系统</title>
</head>
<body>
	<div class="container">
		<%@include file="menu.jsp"%>
		<div class="center">
			<div class="zuo">
				<div class="zuo1" id="memberInfo">
						<%
							Object obj_username = session.getAttribute("userInfo");
							if (obj_username != null) {
						%>
							<p class="pp"  style="width: 85%; height: 30px; background: url('${path }/img/icon06.gif') no-repeat;">欢迎登陆</p>
								<div id="parent">
									<p style="color: #000;margin-top:10px; text-align:left;">会员名称：${userInfo.memberName }</p>
									<p style="color: #000;margin-top:10px;text-align:left;">会员等级：${userInfo.levelName }</p>
									<p style="color: #000;margin-top:10px;text-align:left;">折        扣：${userInfo.favourable }</p>
									<p style="color: #000;margin-top:10px;text-align:left;"><a href="exitUser.jsp"> 安全退出 </a></p>
								</div>
						<%
							} else {
								Cookie[] cookies = request.getCookies();
								boolean b = false;
								if(cookies != null && cookies.length >0){
									for(Cookie c:cookies){
										if("username".equals(c.getName())){
											 b = true;
										    request.setAttribute("username", c.getValue());
										}
										if("password".equals(c.getName())){
											 request.setAttribute("password", c.getValue());
										}
									}
								}
						%>
						<p class="pp"  style="width: 85%; height: 30px; background-image: url('${path }/img/icon06.gif');">会员登陆</p>
						<div id="parent">
							<div id="child">
								<span class="ppp" style="font-size: 5px;">登陆帐号：</span> 
								<input type="text" class="in1" name="username" value="${username }" id="Username" onblur="isNull(this,'errorUsername')">
								<span id="errorUsername" style="font-size: 1px;"></span><br> 
								<span style="font-size: 5px;">登陆密码：</span> 
								<input type="password" class="in2" id="Password" name="password" value="${password }" onblur="isNull(this,'errorPassword')">
								<span id="errorPassword" style="font-size: 1px;"></span><br> 
								<div style="text-align:center;margin-top:10px;">
								 <%
								    if(b){
								    	%>
								    	<input type="checkbox"  value="1" checked="" id="remember"  name="remember" >
										<span  style="font-size: 1px;"> 记住密码 </span><br>
								    	<%
								    }else{
								    	%>
								    	 <input type="checkbox" id="remember" value="1"  name="remember" >
										 <span  style="font-size: 1px;"> 记住密码 </span><br>
								    	<%
								    }
								 %>
								</div>
								<div id="loginFaile" style="color:red;text-align:center;display:none;">登录失败</div>
								<input type="button" class="bb1" value="注册" onclick="javascript:location.href='register.jsp'"> 
								<input type="button" class="bb11" id="LoginBtn" onclick="userLogin()" value="登陆">
							</div>
						</div>
						<%
							}
						%>
				</div>
				<div class="zuo2">
					<div id="zuo001"
						style="width: 85%; height: 30px; background-image: url('${path }/img/icon01.gif');">
						<p class="pp">商品类别</p>
						<ul>
							<%
								Object obj_categoryList = request.getAttribute("category");
								if (obj_categoryList != null) {
									List<CategoryModel> categoryList1 = (List<CategoryModel>) obj_categoryList;
									if (categoryList1.size() > 0) {
							%>
							<%
								for (CategoryModel cate : categoryList) {
							%>
							<li class="back"><a
								href="selectMerchandise?category=<%=cate.getId()%>" class="aa"><%=cate.getCateName()%></a></li>
							<%
								}
							%>
						</ul>
						<%
							}
							}
						%>
					</div>
				</div>
			</div>
			<div class="you">
				<div class="you1">
					<div class="div4">
						<img src="${path }/img/Icon_TeJia.gif"> <a
							href="moreMerchandise?special=1" class="b3"><img
							src="${path }/img/icon_more.gif"></a>
					</div>
					<div class="div5"></div>
					<jsp:useBean id="merchandiseDAO" class="org.ccunix.eshop.dao.MerchandiseDAO"></jsp:useBean>
					<%
						List<MerchandiseModel> merchandiseList = merchandiseDAO.getMerchandiseListBySpecial("1");
						if (merchandiseList.size() > 0) {
							int specialBook = 3;
							for (MerchandiseModel mer : merchandiseList) {
								if (mer.getSpecial() == 1 && specialBook > 0) {
									specialBook--;
									pageContext.setAttribute("mer", mer);
						%>
						<div class="div6">
							<center>
								<a href="merchandise.jsp?id=<%=mer.getId()%>"><img
									class="bookImg" alt="" src="${path }${mer.picture}"
									style="text-align: center; border: 3px;"></a>
							</center>
							<br>
							<p class="bookNamebox" style="text-align: center; font-size: 6px;">
								<a href="merchandise.jsp?id=${mer.id }"
									class="a1 bookName" style="text-decoration: none; color: blue;"
									title="${mer.merName }">${mer.merName }</a>
							</p>
							<p style="text-align: center; color: black;">
								市场价： ￥${mer.price }</p>
							<p style="text-align: center; color: black;">
								特 价： ￥${mer.sPrice }</p>
							<a href="merchandise.jsp?id=${mer.id }" class="bb2"><img
								alt="" src="${path }/img/icon_car.gif"></a> 
								<a href="javascript:buyMerchandise(${mer.id },${mer.sPrice },${mer.special })" class="bb3"><img alt="" src="${path }/img/icon_buy.gif"></a>
						</div>
					<%
						} else if (specialBook <= 0) {
									break;
								}
							}
						}
					%>

				</div>
				<div class="you2">
					<div class="div4">
						<img src="${path }/img/NewGoods_03.gif"> <a
							href="moreMerchandise?special=0" class="b3"><img
							src="${path }/img/icon_more.gif"></a>
					</div>
					<div class="div5"></div>
					<%
						int newBook = 3;
						merchandiseList = merchandiseDAO.getMerchandiseListBySpecial("0");
						for (MerchandiseModel mer : merchandiseList) {
							if (mer.getSpecial() == 0 && newBook > 0) {
								pageContext.setAttribute("mer", mer);
								newBook--;
					%>
					<div class="div6">
						<center>
							<a href="merchandise.jsp?id=<%=mer.getId()%>"><img
								class="bookImg" alt="" src="${path }${mer.picture}"
								style="text-align: center; border: 3px;"></a>
						</center>
						<br>
						<p class="bookNamebox" style="text-align: center; font-size: 6px;">
							<a href="merchandise.jsp?id=${mer.id }"
								class="a1 bookName" style="text-decoration: none; color: blue;"
								title="${mer.merName }">${mer.merName }</a>
						</p>
						<p style="text-align: center; color: black;">
							市场价： ￥${mer.price }</p>
						<a href="merchandise.jsp?id=${mer.id }" class="bb2"><img
							alt="" src="${path }/img/icon_car.gif"></a> 
							<a href="javascript:buyMerchandise(${mer.id },${mer.price },${mer.special })" class="bb3 cehsj"><img alt="" src="${path }/img/icon_buy.gif"></a>
					</div>
					<%
						} else if (newBook <= 0) {
								break;
							}
						}
					%>

				</div>
			</div>
		</div>
		<div class="footer">
			<p>版权所有：长春优尼克斯软件有限公司 编写者：于洋</p>
		</div>
	</div>
	<script type="text/javascript" src="${path }/js/index.js"></script>
</body>
</html>