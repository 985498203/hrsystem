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
			<th>招聘人数</th>
			<th>招聘职位</th>
			<th>职位描述</th>
		</tr>
		
		<#list recruitInfo as if>
		<tr>
		    <td>${if.recruitId}</td>
			<td>${if.recruitNumber}</td>
			<td>${if.recruitDept}</td>
			<td>${if.describe}</td>
		</tr>
		</#list>
	</table>
</body>
</html>