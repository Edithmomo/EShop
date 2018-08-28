var xhr ;
function ajax(url, succFun) {
	if(window.XMLHttpRequest){
		xhr = new XMLHttpRequest();
	}else{
		xhr = new ActiveXObject("Microsoft.XMLHTTP");
	}
	xhr.open("get", url, true);
	xhr.setRequestHeader("Content-type", "application/json; charset=utf-8");
	xhr.send();
	xhr.onreadystatechange = succFun;
}
function userLogin() {
	var username = document.getElementById("Username").value;
	var password = document.getElementById("Password").value;
	var loginFaile = document.getElementById("loginFaile");
	loginFaile.style.display = "none";
	var remember = "";
	if (document.getElementById("remember").checked) {
		remember = 1;
	}
	var url = "doLogin?username=" + username + "&password=" + password
			+ "&remember=" + remember;
	ajax(url,function() {
				if (xhr.readyState == 4 && xhr.status == 200) {
					if(xhr.response == ""){
						console.log(xhr.response,"data")
						loginFaile.style.display = "block";
					}else{
						var data = JSON.parse(xhr.response);
						var str = "<p class='pp'  style='width: 85%; height: 30px; background: url("
							+ "img/icon06.gif"
							+ ") no-repeat;'>欢迎登陆</p>"
							+ "<div id='parent'>"
							+ "<p style='color: #000;margin-top:10px; text-align:left;'>会员名称："
							+ data.memberName
							+ "</p><p style='color: #000;margin-top:10px;text-align:left;'>会员等级："
							+ data.memberLevelModel.levelName
							+ "</p><p style='color: #000;margin-top:10px;text-align:left;'>折        扣："
							+ data.memberLevelModel.favourable
							+ "</p><p style='color: #000;margin-top:10px;text-align:left;'><a href='exitUser.jsp'> 安全退出 </a></p></div>";
						document.getElementById("memberInfo").innerHTML = str;
					}
				}
			});
}

function validateUser(){
	var username = document.getElementById("username").value;
	var errUser = document.getElementById("errUser");
	errUser.innerHTML="";
	if(username == null || username == "" || username === ""){
		errUser.innerHTML="<font color='red'> 登录账号不能为空 </font>";
	}else{
		ajax("validateUser?username=" + username, function(){
			if(xhr.readyState == 4 && xhr.status == 200){
				var data = xhr.response;
				if(data == 1){
					errUser.innerHTML="<font color='red'> 登录账号已注册 </font>";
				}else{
					errUser.innerHTML="<font color='green'> 可以使用 </font>";
				}
			}
		});
	}
}

function buyMerchandise(merId,price,special){
	var url = "menu/shopCartManager?method=add&merId="+merId+"&price="+price+"&special="+special;
	ajax(url,function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			console.log(xhr)
			if("fail" != xhr.response){
				alert("购物车添加成功！");
			}else{
				alert("购物车添加失败！请重试");
			}
		}
	})
}
function deleteCart(merId,cartId){
	var url = "shopCartManager?method=delete&fun=1&merId="+merId+"&fun=0&cartId="+cartId;
	ajax(url,function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			console.log(xhr)
			if("fail" != xhr.response){
				alert("商品删除成功！");
				var data = eval("("+xhr.response+")"); //eval()不检查是否符和JSON规范  JSON.parse检查
				var cartSelectedmerMap = data.cartSelectedmerMap
				var arr = Object.keys(cartSelectedmerMap);
				var str = "";
				$(".merSelect").remove();
			    if(arr.length != 0){
			    	for(var i in cartSelectedmerMap){
			    		var cartSelected = cartSelectedmerMap[i];
			    		str += "<tr class='merSelect' class='text' align='center' bgcolor='#FFFFFF'>"+						
			    		         "<td>&nbsp;<a href='mer.do?method=showMer&id="+ cartSelected.merchandise +"' target='_blank'> "+
							          "<span class='blueText'>"+ cartSelected.merchandiseModel.merName +"</span></a>"+
								"</td>"+
								"<td>￥"+ cartSelected.merchandiseModel.price +"</td>"+
								"<td>￥<span id='price81'>"+ cartSelected.cartSelectedMerPrice +"</span></td>"+
								"<td><input type='text' class='textBox' onChange='modiNum(this.value,"+cartSelected.merchandise + "," + cartSelected.cart +")' value="+ cartSelected.number +" size='4'/></td>"+
								"<td>￥<span id='money81'>"+ cartSelected.cartSelectedMerMoney +" </span></td>"+
								"<td><input onClick='deleteCart("+cartSelected.merchandise + "," + cartSelected.cart +")' type='image' src='/EShop/img/delete_01.gif' border='0'/></td>"+
						    "</tr>";
			    	}
			    	 str+=" <tr class='merSelect'>"+
			                   "<td colspan='6' class='Order_Total' align='center'><img hspace='5' src='/EShop/img/me03.gif' align='absmiddle' /> "+
			                   "总金额：￥<span id='totalMoney'>"+data.money+"</span>（不包括配送费用）				</td>"+
			               "</tr>";
			    	 $("#mytable").append(str);
			    }else{
			    	str+="<tr class='merSelect' align='center' bgcolor='#FFFFFF'> "+
			                "<td colspan='6' height='26' class='redText' style='font-size: 10px;color: red'>对不起，您目前尚未选购任何商品！</td>"+
			              "</tr>";	
			    }
			}else{
				alert("商品删除失败！请重试");
			}
		}
	})
}