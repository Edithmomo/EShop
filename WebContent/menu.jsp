<%@page import="org.ccunix.eshop.model.CategoryModel"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'menu.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link type="text/css" rel="stylesheet" href="${path }/css/Demo.css">
  </head>
  <script type="text/javascript">
	function isNull(field, id) {
		var value = field.value;
		if (value == null || value == "") {
			document.getElementById(id).innerHTML = "空值";
			document.getElementById(id).style.color = "red";
			return false;
		} else {
			document.getElementById(id).innerHTML = "";
			return true;
		}
	}
	function validate_form(thisform) {
		if (isNull(document.getElementById("Username"), 'errorUsername') == false
				| isNull(document.getElementById("Password"), 'errorPassword') == false) {
			return false;
		}
	}
</script>
  <body>
   <jsp:useBean id="categoryDAO" class="org.ccunix.eshop.dao.CategoryDAOByHibernateImpl"></jsp:useBean>
  <%
		List<CategoryModel> categoryList = categoryDAO.getCategoryList();
		 if (categoryList.size() > 0) {
	%>
		<div class="head">
			<img alt="" src="${path }/img/s.png">
			<div class="div1">
			 <form action="selectMerchandise" method="GET">
				<table>
					<tr>
					    <td><input id="qKey" name="qKey" placeholder="商品关键字"></td>
						<td><select id="category" name="category">
								<option value="0">所有商品</option>
								<%
									for (CategoryModel cate : categoryList) {
								%>
								<option value="<%=cate.getId()%>"><%=cate.getCateName()%></option>
								<%
									}
								%>
						   </select>
						</td>
						<td><button type="submit" class="bu1"></button></td>
					 </tr>
				</table>
				</form>
			</div>
		</div>
		<div class="menu">
			<img alt="" src="${path }/img/icon02.gif" class="img1">
			<div class="test">
				<ol>
					<li class="nav"><a href="${path }" class="nn">商城首页</a></li>
					<li class="nav"><a href="${path }/menu/shopCartManager?method=query" class="nn">购物车管理</a></li>
					<li class="nav"><a href="#" class="nn">订单管理</a></li>
					<li class="nav"><a href="${path }/message.html" class="nn">顾客留言</a></li>
					<li class="nav"><a href="${path }/menu/updateUser" class="nn">修改注册资料</a></li>
				</ol>
			</div>
			<img alt="" src="${path }/img/icon07.gif" class="img2">
		</div>
  <%
							}
						%>
   </body>
</html>
