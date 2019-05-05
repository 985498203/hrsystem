<!-- 获取绝对路径 -->
<#assign BASE_PATH=springMacroRequestContext.contextPath />
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<script src="${BASE_PATH}/static/asserts/js/jquery.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="${BASE_PATH}/static/asserts/css/bootstrap.css" />
<script src="${BASE_PATH}/static/asserts/js/bootstrap.js"></script>
<style type="text/css">
body{
	background-image: url("${BASE_PATH}/static/asserts/img/loginbg.jpg");
}
.logo_box {
    width: 400px;
    height: 500px;
    padding: 35px;
    color: #EEE;
    position: absolute;
    left: 50%;
    top: 50%;
    margin-left: -200px;
    margin-top: -250px;
}
h3{
text-align: center;
}
.form-group {
	margin-top: 30px;

}
.popover{

width: 200px;

}
</style>
</head>
<body>
	<div class="logo_box">
		<h3>人事资源管理系统</h3>
		<form >
			<span id="errorInfo"></span>
			<div class="form-group"> 
				<div class="input-group form-group-lg">
					<div class="input-group-addon"><span class="glyphicon glyphicon-user"></span></div>
					<input type="text" class="form-control"  name="username" placeholder="用户名" >
				</div>
			</div>
			  <div class="form-group form-group-lg">
				    <div class="input-group">
						<div class="input-group-addon"><span class="glyphicon glyphicon-lock"></span></div>
						<input type="password" class="form-control"  name="password"  placeholder="密码">
					</div>
			  </div>
			  
			  <div class="form-group form-group-lg">
				    <div class="input-group">
						<input type="text" class="form-control"  name="imgCode"  placeholder="验证码">
						<div class="input-group-addon" style="background-color:#FFF;cursor:pointer;"><img id="imgcode" alt="图片加载中" src="imgcode"></div>
					</div>
			  </div>
			  
			  
			  <div class="checkbox">
			    <label>
			        &nbsp;&nbsp;<input type="checkbox">记住密码
			    </label>
			  </div>
			
			  <button type="button"  class="btn btn-lg btn-success btn-block" id="loginButton"  >登录</button>
		</form>
	</div>


</body>
<script>
$(function () {
	$("#imgcode").click(function(){ //鼠标点击切换图片验证码
		var img_src ="imgcode?t="+Math.random();//重新加载图片
		$(this).attr("src",img_src);
	});
	
	
	
	function chackInput(){
		var username= $("input[name='username']").val().trim();
		var password= $("input[name='password']").val().trim();
		if(username.length==0 || password.length==0){
			$("#errorInfo").html("<b style='color:red;'>用户名或密码不能为空</b>");
			return false;
		}else{
			return true;
		}
	}

	 $("#loginButton").click(function(){
		 
		var flg = chackInput();
		if(flg){
			$.ajax({
				type : 'POST',
				url : 'login.html',
				dataType : 'json',
				data: $("form").serialize(),
				success : function(data) {
					if(data.success){
						window.location.href="index";
					}else{
						
						
						$("#errorInfo").html("<b style='color:red;'>用户名或密码错误</b>");
					}
				}
			});
		}
	}); 
});
</script>
</html>