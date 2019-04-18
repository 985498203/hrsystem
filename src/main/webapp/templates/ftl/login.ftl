<!-- 获取绝对路径 -->
<#assign base=springMacroRequestContext.contextPath />
<!DOCTYPE html>
<html>
	<head>
		
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
		<meta name="description" content="">
		<meta name="author" content="">
		<title>用户登录</title>
		<!-- Bootstrap core CSS -->
		<link href="static/asserts/css/bootstrap.min.css" rel="stylesheet">
		<!-- Custom styles for this template -->
		<link href="static/asserts/css/signin.css" rel="stylesheet">
	</head>
	<body class="text-center">
		<form class="form-signin" action="/user/login.html">
			<h1 class="h3 mb-3 font-weight-normal">用户登录</h1>
			<label class="sr-only">用户名</label>
			<input type="text" class="form-control" placeholder="用户名" name="username" required="" autofocus="">
			<label class="sr-only">密码</label>
			<input type="password" class="form-control" placeholder="密码" name="password" required="">
			<div class="checkbox mb-3">
				<label>
          <input type="checkbox" value="remember-me">记住密码
        </label>
			</div>
			<button class="btn btn-lg btn-primary btn-block" type="submit">登录</button>
		</form>

	</body>

</html>