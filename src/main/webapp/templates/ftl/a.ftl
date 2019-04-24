<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- <#if!index??> <script type="text/javascript">
		window.location.href = "/list";
	</script> </#if> -->
	<h5>
		<a>网站资源管理</a>
	</h5>
	<table class="table">
		<tr>
			<th>全选<br /> <input type="checkbox" id="all" name="all"
				onclick="qx(1);" /></th>
			<th>资源编号</th>
			<th>资源名称</th>
			<th>资源url</th>
			<th class="th">
				<div class="dropdowns">
					<span>操作</span><b class="caret"></b>
					<div class="dropdown-contents">
						<p>
							<button id="delete" type="submit">删除</button>
						</p>
						<hr>
						<p>
							<button id="update" type="button" onclick="tj()">添加</button>
						</p>
					</div>
				</div>
			</th>
		</tr>
		<!-- <#iflist??> <#list permList as p>
		<tr>
			<td><input type="checkbox" id="one" value="" name="one"
				onclick="" />全选</td>
			<td>${p.permId}</td>
			<td>${p.permName}</td>
			<td>${p.url}</td>
			<td style="text-align: left;">
				<button id="update" value="" type="button" name=""
					style="border: 0px; background-color: #eff3f6; color: green;"
					onclick="">修改</button>
			</td>
		</tr>
		</#list>
		</#if> -->
	</table>
</body>
</html>