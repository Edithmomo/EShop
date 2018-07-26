<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@include file="header.jsp" %>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<link type="text/css" rel="stylesheet" href="${path }/css/Demo.css">
<script src="${path }/js/index.js"></script>

</head>
<body>
	<div class="container">
		<%@include file="menu.jsp"%>
         <div class="X_center">
         <div class="X_center01"> <img alt="" src="${path }/img/icon_goods.gif"> </div>
     <table cellspacing="0" cellpadding="0" border="0">
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
			<table cellspacing="1" cellpadding="0" width="94%" border="0" bgcolor="#F7F3F7">
              <tr height="26">
                <td class="blackTitle" align="center">商品名称</td>
                <td class="blackTitle" align="center">市场价</td>
                <td class="blackTitle" align="center">会员价</td>
                <td class="blackTitle" align="center">数量</td>
                <td class="blackTitle" align="center">金额</td>
                <td class="blackTitle" align="center">删除</td>
              </tr>
              <!-- <tr align="center" bgcolor="#FFFFFF">
                <td colspan="6" height="26" class="redText" style="font-size: 10px;color: red">对不起，您目前尚未选购任何商品！</td>
              </tr>	 -->
               <c:forEach items="${cartModel.cartSelectedMers}" var="cs">
                    <tr class="text" align="center" bgcolor="#FFFFFF">
						<td>
							&nbsp;<a href="mer.do?method=showMer&id=${cs.value.merchandise}" target="_blank"> 
							           <span class="blueText">${cs.value.merName}</span>
							     </a>
						</td>
						<td>￥${cs.value.merPrice}</td>
						<td>￥<span id="price81">${cs.value.cartSelectedMerPrice}</span></td>
						<td><input type="text" class="textBox" onChange="modiNum(81,this.value)" value="${cs.value.number }" size="4"/></td>
						<td>￥<span id="money81">${cs.value.cartSelectedMerMoney}</span></td>
						<td><input onClick="delCart(81)" type="image" src="${path }/img/delete_01.gif" border="0"/></td>
				    </tr>
                    
                    
               </c:forEach>
              
				
                <tr>
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
</html>