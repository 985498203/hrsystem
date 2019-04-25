<!-- 获取绝对路径 -->
<#assign base=springMacroRequestContext.contextPath />
<!DOCTYPE html>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>权限管理</title>
<!-- Bootstrap core CSS -->
<script src="http://how2j.cn/study/js/jquery/2.0.0/jquery.min.js"></script>
<link href="http://how2j.cn/study/css/bootstrap/3.3.6/bootstrap.min.css"
	rel="stylesheet">
<script src="http://how2j.cn/study/js/bootstrap/3.3.6/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-12 ">
				<h3>资源列表</h3>
			</div>
		</div>
		<div class="row">
			<div class="col-md-4 col-md-offset-8">
				<button type="button" class="btn btn-primary btn-sm ">新增</button>
				<button type="button" class="btn btn-danger btn-sm">删除</button>
			</div>
		</div>
		<div class="row">
			<div class="col-md-12">
				<table class="table table-condensed table-hover" id="permtable">
					<thead>
						<th><input type="checkbox" id="permqx" onclick="permqx(0)">全选</th>
						<th>资源编号</th>
						<th>资源名称</th>
						<th>资源URL</th>
					</thead>
					<tbody>
						<#list prmlist as p>
						<tr>
							<td><input type="checkbox" class="permxz"
								onclick="permqx(1)" value="${p.permId}">
							</th>
							</td>
							<td>${p.permName}</td>
							<td>${p.url}</td>
							<td>
								<button class="btn btn-primary btn-sm ">
									<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
									编辑
								</button>
								<button class="btn btn-danger btn-sm">
									<span class="glyphicon glyphicon-trash"></span> 删除
								</button>
							</td>
						</tr>
						</#list>
					</tbody>
				</table>
			</div>
		</div>
		<!-- 显示分页信息 -->
		<div class="row">
			<!-- 分页文字信息 -->
			<div class="col-md-6">当前记录数</div>
			<!-- 分页条信息 -->
			<div class="col-md-6">
				<nav aria-label="Page navigation">

					<ul class="pagination">
						<li><a href="#">首页</a></li>
						<li><a href="#" aria-label="Previous"> <span
								aria-hidden="true">&laquo;</span>
						</a></li>
						<li><a href="#">1</a></li>
						<li><a href="#">2</a></li>
						<li><a href="#">3</a></li>
						<li><a href="#">4</a></li>
						<li><a href="#">5</a></li>
						<li><a href="#" aria-label="Next"> <span
								aria-hidden="true">&raquo;</span>
						</a></li>
						<li><a href="#">末页</a></li>
					</ul>
				</nav>
			</div>
		</div>



	</div>

</body>

</html>