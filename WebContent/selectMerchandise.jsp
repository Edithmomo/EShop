<%@page import="org.ccunix.eshop.model.MerchandiseModel"%>
<%@page import="org.ccunix.eshop.model.CastPageModel"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="header.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'selectMerchandise.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
  </head>
  <body>
    <div class="con">
		<%@include file="menu.jsp" %>
		<div class="G_center">
				<%
				 Object obj_castPage = request.getAttribute("castPage");
				  if(obj_castPage != null){
					  CastPageModel castPageModel =  (CastPageModel)obj_castPage;
					  pageContext.setAttribute("castPageModel", castPageModel);
					  for (CategoryModel cate : categoryList) {
						  if(cate.getId() == castPageModel.getCategory()){
							  pageContext.setAttribute("selectCateName", cate.getCateName());
							  break;
						  }
					  }
					  %>
					    <div class="G_center01" >
								<font color="green" size="5">"${castPageModel.qkey } ${selectCateName }" </font>的查询结果
						</div>
						<table width="720px" height="600px">
							<tr bgcolor="#F7F3F7" valign="middle" align="center">
								<td height="30" class="blackTitle">商品图片</td>
								<td height="30" class="blackTitle">商品基本信息</td>
								<td height="30" class="blackTitle">商品描述</td>
								<td height="30" class="blackTitle">基本操作</td>
							</tr>
					  <%
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
								target=_blank> <img src="${path }<%=m.getPicture() %>" width="60" height="60"
									border="1">
							</a></td>
							<td width="160" class="text"><a href="merchandise.jsp?id=<%=m.getId() %>" target=_blank><span
									class="blueText"><%=m.getMerName() %></span></a>
									<br> 市场价： ￥<%=m.getPrice() %>
									<%
									  if(m.getSpecial() == 1){
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
								href="javascript:buyMerchandise(<%= m.getId()%> ,<%=merPrice %>,<%=m.getSpecial() %>)""><img alt="" src="${path }/img/icon_buy.gif" border=0></a>
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
						  		<a href="selectMerchandise?qKey=<%=castPageModel.getQkey() %>&category=<%=castPageModel.getCategory() %>&nowPage=<%=castPageModel.getBackPage() %>">上一页</a>  
								 <%
							  }
						 %>
						 <%
							 if(castPageModel.getNowPage() != castPageModel.getTotalPageNum()){
								 %>
						  		<a href="selectMerchandise?qKey=<%=castPageModel.getQkey() %>&category=<%=castPageModel.getCategory() %>&nowPage=<%=castPageModel.getNextPage() %>">下一页</a>
								 <%
							  }
						 %>
						      跳转<img alt="" height="20px" style="position:relative;top:5px; " id="jumpImg" data-qkey="<%=castPageModel.getQkey() %>" data-category="<%=castPageModel.getCategory() %>" data-totalPage="<%=castPageModel.getTotalPageNum() %>" src="${path }/img/got_Next.png">第
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
	<script type="text/javascript" src="js/selectMerchandise.js"></script>
  </body>
</html>
