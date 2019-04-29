<!DOCTYPE html>
<html>
<head>
<#setting number_format="#">
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<meta name="format-detection" content="telephone=no">
<title>Insert title here</title>
		<script type="text/javascript" src="static/asserts/js/jquery.min.js"></script>
		<script type="text/javascript" src="static/asserts/js/jquery-3.2.1.min.js"></script>
		<script type="text/javascript" src="static/asserts/js/bootstrap.min.js"></script>
		<script type="text/javascript" src="static/asserts/js/index.js"></script>
		<#if !list??>
			<script type="text/javascript">
	 			window.location.href="finduser.html?pageNo=1";
	 		</script>
		</#if>
   		<link rel="stylesheet" type="text/css" href="static/asserts/css/bootstrap.min.css" />
        <link rel="stylesheet" type="text/css" href="static/asserts/css/bootstrap-theme.min.css">
        <link rel="stylesheet" type="text/css" href="static/asserts/css/index.css">
        <link rel="stylesheet" type="text/css" href="static/asserts/css/common.css" />
        <link rel="stylesheet" type="text/css" href="static/asserts/css/slide.css" />
        <link rel="stylesheet" type="text/css" href="static/asserts/css/flat-ui.min.css" />
        <link rel="stylesheet" type="text/css" href="static/asserts/css/jquery.nouislider.css">
</head>
<body>
	<table>
		<div>
			<tr>
				<th>序号</th>
				<th>工单号</th>
				<th>工单标题</th>
				<th>工单详情</th>
				<th>工单状态</th>
				<th>工单受理人</th>
			</tr>
			
			<#list worder as wd>
			<tr>
				<td></td>
				<td>${wd.count}</td>
				<td>${wd.worderId}</td>
				<td>${wd.title}</td>
				<td>${wd.detail}</td>
				<td>${wd.state}</td>
				<td>${wd.user.userId}</td>
			</tr>
			</#list>
		</div>
		
	</table>
</body>
</html>