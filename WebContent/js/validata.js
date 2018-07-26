var memberName = document.getElementById("memberName");
memberName.addEventListener("blur",function(){
	notNull(this,"用户名");
});
/**
 * 验证两次密码是否一直
 */
function passwordVale(){
	var password = document.querySelectorAll("input[type='password']");
	if(password[0].value != password[1].value){
		var errMsg = document.createElement("font");
		   errMsg.innerHTML = "两次密码不一致";
		   errMsg.style.color ="red";
		   password[1].parentNode.appendChild(errMsg);
	}
}

function notNull(input,mesg){
	if(input.value == null || input.value == "" || input.value ===""){
	   var errMsg = document.createElement("font");
	   errMsg.innerHTML = mesg+"不能为空";
	   errMsg.style.color ="red";
	   console.log(input.parentNode)
	   input.parentNode.appendChild(errMsg);
	}
}