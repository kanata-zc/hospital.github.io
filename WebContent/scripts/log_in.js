// scripts/log_in.js编码utf-8
// console.log("Hello!");

//网页加载以后执行的方法
$(function(){
	//console.log("呵呵");
	//console.log($("#login"));
	$("#login").click(loginAction);
	//表单检查，如果没有用户名或密码就不再提交了
	$('#count').on('blur',checkName).on('focus',function(){
		$('#count_msg').empty();
	}).focus();
	$('#password').on('blur',checkPassword).on('focus',function(){
		$('#password_msg').empty();
	});
});
 
function checkName(){
	var name = $("#count").val();
	if(name==''){
		$('#count_msg').empty().append("不能为空");
		return false;
	}
	var reg = /^\w{3,10}$/;
	if(reg.test(name)){
		$('#count_msg').empty();
		return true;
	}
	$('#count_msg').empty().append("3~10个字符");
	return false;
}
function checkPassword(){
	var password = $("#password").val();
	if(password==''){
		$('#password_msg').empty().append("不能为空");
		return false;
	}
	var reg = /^\w{3,10}$/;
	if(reg.test(password)){
		$('#password_msg').empty();
		return true;
	}
	$('#password_msg').empty().append("3~10个字符");
	return false;
}
function loginAction(){
	
	//console.log("程翔六点半！");
	var name = $("#count").val();
	var password = $("#password").val();
	
	var namePass = checkName();
	var pwdPass = checkPassword();
	if(!namePass||!pwdPass){
		return false;
	}
	$.ajax({
		url:'account/login.do',
		type:'POST',
		data:{'name':name,'password':password},
		dataType:'JSON',
		success:function(result){
			//result 就是服务器发送回来的JsonResult对象
			//state和data就是JsonResult中输入的
			$(".error").empty();
			if(result.state==SUCCESS){
				console.log(result.data);
				console.log("登录成功！");
				
				//保存UserId到Cookie
				var user = result.data;
				setCookie(USER_ID,user.id);
				
				window.location.href='edit.html';
				return;
			}
			var field = result.state;
			if(field==1){
				//显示用户名错误
				$("#count_msg").append(result.message);
			}
			if(field==2){
				//显示密码错误
				$("#password_msg").append(result.message);
 			}
		}
	});
}
