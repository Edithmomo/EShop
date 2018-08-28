<%@page import="org.ccunix.eshop.dao.MerchandiseDAOByHibernate"%>
<%@page import="org.ccunix.eshop.dao.MerchandiseDAOIface"%>
<%@page import="org.ccunix.eshop.model.MerchandiseModel"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<link type="text/css" rel="stylesheet" href="css/Demo.css">
</head>
<body>
	<div class="container">
		<%@include file="menu.jsp" %>
         <div class="X_center">
         <div class="X_center01"> <img alt="" src="${path }/img/icon_goods.gif"> </div>
         <%
           String str_id = request.getParameter("id");
            if(str_id == null){
            	response.sendRedirect("logOut.html");
            }else{
            	MerchandiseDAOIface merchandiseDAO = new MerchandiseDAOByHibernate();
            	MerchandiseModel m = merchandiseDAO.getOneMerchandiseById(Integer.parseInt(str_id));
            	double merPrice = 0;
            	/* if(m.getSpecial() == 1){
					  merPrice = m.getsPrice();
				  }else{
					  merPrice = m.getPrice();
				  } */
            	%> 
            	    <div class="X_center02"><img style="margin:0 10px 0 0;" src="/EShop<%=m.getPicture() %>" align="left">
         <font style="font-size: 15px;">商品类别：<%=m.getCateName() %><br>
				商品名称：<%=m.getMerName() %><br>
				商品型号：<%=m.getMerModel() %><br>
				市场价：￥<%=m.getPrice() %><br>
				<%
				   if(m.getSpecial() == 1){
					   %>
					   	特  价：￥<%= m.getsPrice() %><br>
					   <% 
				   }
				%>
				生产厂家：<%=m.getManufacturer() %><br>
				出厂日期：<%=m.getLeaveFactoryDate() %><br>
				<%=m.getMerDesc() %><br></font>
         </div>
         <center class="buyBtn">
				<button onclick="buyMerchandise(<%= m.getId()%> ,<%=merPrice %>,<%=m.getSpecial() %>)" style="background-image: url('${path }/img/icon_buy.gif'); width: 62px; height: 25px;"></button>
			</center>
         </div>
            	<%
            }
         %>
        		
		<div class="footer">
			<p>版权所有：长春优尼克斯软件有限公司 项目经理：于洋</p>
		</div>
	</div>
	<script type="text/javascript" src="./js/index.js"></script>
</body>
</html>