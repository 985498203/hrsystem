<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
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
			<td>${wd.worderId}</td>
			<td>${wd.title}</td>
			<td>${wd.detail}</td>
			<td>${wd.state}</td>
			<td>${wd.user.userId}</td>
		</tr>
		</#list>
	</table>
</body>
</html>