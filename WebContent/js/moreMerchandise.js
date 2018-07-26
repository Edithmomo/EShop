function jumpPage(){
	var totalPageNum = this.dataset.totalpage;
	var special = this.dataset.special;
	var jumpInput = document.getElementById("jumpInput");
	var jumpValue = jumpInput.value;
    if(isNaN(jumpValue) || jumpValue == "" || jumpValue === ""){
    	alert("输入的不是数字，请重新输入");
    	jumpInput.value="";
    }else{
    	if(parseInt(totalPageNum)<parseInt(jumpValue)){
    		alert("输入的页数打于总页数，请重新输入");
    		jumpInput.value="";
    	}else{
    		location.href="?special="+ special +"&nowPage=" + jumpValue;
    	}
    }
	
}
var jumpImg = document.getElementById("jumpImg");
jumpImg.addEventListener("click", jumpPage);