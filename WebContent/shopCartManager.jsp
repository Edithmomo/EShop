<%@page import="org.ccunix.eshop.model.CartModel"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="header.jsp" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'shopCartManager.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
  </head>
  <body>
  <div class="container">
		<%@include file="menu.jsp"%>
         <div class="X_center">
         <div class="X_center01"> <img alt="" src="${path }/img/icon_goods.gif"> </div>
     <table cellspacing="0"  cellpadding="0" border="0">
            <tr valign="center">
              <td><img hspace="5" src="${path }/img/Car_07.gif" /></td>
              <td class="C_Carbg_Current">查看购物车物品</td>
              <td><img height="39" src="${path }/img/Car_15.gif" width="1" /></td>
              <td align="middle"><img hspace="5" src="${path }/img/Car_09.gif" /></td>
              <td class="C_Carbg_Default">确认订单信息</td>
              <td><img height="39" src="${path }/img/Car_15.gif" width="1" /></td>
              <td align="middle"><img hspace="5" src="${path }/img/Car_11.gif" /></td>
              <td class="C_Carbg_Default">订单提交成功</td>
              <td><img height="39" src="${path }/img/Car_15.gif" width="1" /></td>
            </tr>
        </table>
			<table cellspacing="1" id="mytable" cellpadding="0" width="94%" border="0" bgcolor="#F7F3F7">
              <tr id="showMenu" height="26">
                <td class="blackTitle" align="center">商品名称</td>
                <td class="blackTitle" align="center">市场价</td>
                <td class="blackTitle" align="center">会员价</td>
                <td class="blackTitle" align="center">数量</td>
                <td class="blackTitle" align="center">金额</td>
                <td class="blackTitle" align="center">删除</td>
              </tr>
             <% 
                Object obj_Cartm = session.getAttribute("cartModel");
               if(obj_Cartm!=null){
            	    CartModel cartm = (CartModel) obj_Cartm;
            	   if(cartm.getCartSelectedmerMap().isEmpty()){
            		   %>
            		    <tr class='merSelect' align="center" bgcolor="#FFFFFF">
			                <td colspan="6" height="26" class="redText" style="font-size: 10px;color: red">对不起，您目前尚未选购任何商品！</td>
			            </tr>
            		   <% 
            	   }else{
            		   %>
           		          <c:forEach items="${cartModel.cartSelectedmerMap}" var="cs">
		                    <tr class="merSelect" class="text" align="center" bgcolor="#FFFFFF">
								<td>
									&nbsp;<a href="mer.do?method=showMer&id=${cs.value.merchandise}" target="_blank"> 
									          <span class="blueText">${cs.value.merName}</span>
									     </a>
								</td>
								<td>￥${cs.value.merPrice}</td>
								<td>￥<span id="price81">${cs.value.cartSelectedMerPrice}</span></td>
								<td><input type="text" class="textBox" onChange="modiNum(this.value,${cs.value.id },${cs.value.cart })" value="${cs.value.number }" size="4"/></td>
								<td>￥<span id="money81">${cs.value.cartSelectedMerMoney}</span></td>
								<td><input onClick="deleteCart(${cs.value.id },${cs.value.cart })" type="image" src="${path }/img/delete_01.gif" border="0"/></td>
						    </tr>
		               </c:forEach>
           		      <% 
            	   }
               }
             	 %>
                <tr class="merSelect">
                   <td colspan="6" class="Order_Total" align="center"><img hspace="5" src="${path }/img/me03.gif" align="absmiddle" /> 
				       总金额：￥<span id="totalMoney">${cartModel.money}</span>（不包括配送费用）				</td>
               </tr>	
        </table>
        <div style="margin-left: 300px;">
        <input type="image" src="${path }/img/Car_icon_01.gif" style="BORDER: 0px;WIDTH: 126px; HEIGHT: 39px;" onClick="clearCart()">
			<img style="CURSOR: hand" onClick="continueBuy()" src="${path }/img/Car_icon_02.gif" />
			<img src="${path }/img/Car_icon_03.gif" onClick="JavaScript:location.href='ConfirmOrder.jsp'" border="0" style="CURSOR: hand"/>
			</div>
         </div>		
		<div class="footer">
			<p>版权所有：长春优尼克斯软件有限公司  编写者：于洋</p>
		</div>
	</div>
  </body>
  <script src="${path }/js/jquery-3.2.1.min.js"></script>
  <script src="${path }/js/index.js"></script>
  <script src="${path }/js/shopCartManager.js"></script>
</html>
