
function ajaxSubmit(method){//通过method的值判断是注册还是修改
		$.ajax({
			type:"POST",
			url:"/EShop/register?method="+method,  
			data:$("#registerForm").serialize(),
			success:function(data){
				if(data == "200"){
					if(method == "register"){
						alert("注册成功");
					}else{
						alert("修改成功");
					}
					location.href = "/EShop/exitUser.jsp"
				}else{
					if(method == "register"){
						alert("注册失败，请重试");
					}else{
						alert("修改失败，请重试");
					}
				}
			}
		})
	}