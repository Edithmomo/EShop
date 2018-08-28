function modiNum(val,merId,cartId){
	var url = "shopCartManager?method=update&merId="+merId+"&cartId="+cartId+"&number="+val;
	ajax(url,function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			if("fail" != xhr.response){
				var data = eval("("+xhr.response+")"); //eval()不检查是否符和JSON规范  JSON.parse检查
				var cartSelectedmerMap = data.cartSelectedmerMap;
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
			    	 str+="<tr class='merSelect'>"+
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
				alert("商品修改失败！请重试");
			}
		}
	});
}


function clearCart(cartId){
	var url = "shopCartManager?method=delete&fun=0"+"&cartId="+cartId;
	ajax(url,function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			if("fail" != xhr.response){
				alert("商品删除成功！");
				var data = eval("("+xhr.response+")"); //eval()不检查是否符和JSON规范  JSON.parse检查
				var cartSelectedmerMap = data.cartSelectedmerMap;
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
			    	str+="<tr class='merSelect'>"+
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
	});
}