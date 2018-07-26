<%@page import="org.ccunix.eshop.model.CastPageModel"%>
<%@page import="org.ccunix.eshop.model.MerchandiseModel"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<link type="text/css" rel="stylesheet" href="${path }/css/Demo.css">
</head>
<body>
	<div class="con">
		<%@include file="menu.jsp" %>
		<div class="G_center">
		<%
		   String special = (String)request.getParameter("special");
		   if(special.equals("1")){
			  %> 
				  <div class="G_center01">
					<img alt="" src="${path }/img/NewGoods_05.gif">
				  </div>
			<%
		   }else{
			   %>
			     <div class="G_center01">
					<img alt="" src="${path }/img/NewGoods_04.gif">
				</div>
			   
			   <% 
		   }
		%>
			
			<table width="720px" height="600px">
				<tr bgcolor="#F7F3F7" valign="middle" align="center">
					<td height="30" class="blackTitle">商品图片</td>
					<td height="30" class="blackTitle">商品基本信息</td>
					<td height="30" class="blackTitle">商品描述</td>
					<td height="30" class="blackTitle">基本操作</td>
				</tr>
				<%
				 MerchandiseModel merchandiseModel = new MerchandiseModel();
				 Object obj_castPage = request.getAttribute("castPage");
				  if(obj_castPage != null){
					  CastPageModel castPageModel =  (CastPageModel)obj_castPage;
					  List<MerchandiseModel> merchandiseModels = castPageModel.getCurrentList();
					  if(merchandiseModels.size()>0){
						  for(int i = 0; i < merchandiseModels.size(); i++ ){
							  MerchandiseModel m = merchandiseModels.get(i);
							  double merPrice = 0;
							  if(m.getSpecial()==1){
								  merPrice = m.getsPrice();
							  }else{
								  merPrice = m.getPrice();
							  }
						  %>
						  <tr valign="middle" bgcolor="#FFFFFF">
							<td width="100" align="center"><a href="merchandise.jsp?id=<%=m.getId() %>"
								target=_blank> <img src="/EShop<%=m.getPicture() %>" width="60" height="60"
									border="1">
							</a></td>
							<td width="160" class="text"><a href="merchandise.jsp?id=<%=m.getId() %>" target=_blank><span
									class="blueText"><%=m.getMerName() %></span></a>
									<br> 市场价： ￥<%=m.getPrice() %>
									<%
									  if(special.equals("1")){
										 %>
										 <br> 特 价：￥<%=m.getsPrice() %>
										 <% 
									  }
									%>
									
									<br> 生产厂家：<%=m.getManufacturer() %><br>
									</td>
							<td class="text"><%=m.getMerDesc() %></td>
							<td width="100"><a href="merchandise.jsp?id=<%=m.getId() %>"><img
									src="${path }/img/icon_car.gif" border=0></a><br> <a
								href="javascript:buyMerchandise(<%= m.getId()%> ,<%=merPrice %>,<%=m.getSpecial() %>)"><img alt="" src="${path }/img/icon_buy.gif" border=0></a>
							</td>
						</tr>
						<tr>
							<td colspan="4" height="2" bgcolor="#F7F3F7"></td>
						</tr>
						  <%
						  }
					  }
					  %>
					  <tr>
						<td colspan="4" align="center" >
						 共<%=castPageModel.getTotalNum() %>条  
						  每页<%=castPageModel.getEveryPageNum() %>条  
						  共<%=castPageModel.getTotalPageNum() %>页   
						  当前为第<%=castPageModel.getNowPage() %>页  
						 <%
							 if(castPageModel.getNowPage() != 1){
								 %>
						  		<a href="moreMerchandise?special=<%=special %>&nowPage=<%=castPageModel.getBackPage() %>">上一页</a>  
								 <%
							  }
						 %>
						 <%
							 if(castPageModel.getNowPage() != castPageModel.getTotalPageNum()){
								 %>
						  		<a href="moreMerchandise?special=<%=special %>&nowPage=<%=castPageModel.getNextPage() %>">下一页    </a>
								 <%
							  }
						 %>
						      跳转<img alt="" height="20px" style="position:relative;top:5px; " id="jumpImg" data-special="<%=special %>" data-totalPage="<%=castPageModel.getTotalPageNum() %>" src="${path }/img/got_Next.png">第
						      <input type="text" id="jumpInput"  size="1" />页
						 
						</td>
					</tr>
					<tr>
						<td colspan="4" height="2" bgcolor="#F7F3F7"></td>
					</tr>
					<%
				  } 
				
				%>
				
			</table>
		</div>
		<div class="f">
			<p>版权所有：长春优尼克斯软件有限公司 项目经理：于洋</p>
		</div>
	</div>
	<script type="text/javascript" src="${path }/js/index.js"></script>
	<script type="text/javascript" src="${path }/js/moreMerchandise.js"></script>
</body>
</html>