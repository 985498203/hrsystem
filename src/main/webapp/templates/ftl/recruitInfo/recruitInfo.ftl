<!-- 获取绝对路径 -->
<#assign base=springMacroRequestContext.contextPath />
<!DOCTYPE html>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>招聘信息管理</title>
<!-- Bootstrap core CSS -->
<script src="static/asserts/js/jquery.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="static/asserts/css/bootstrap.css" />
<script src="static/asserts/js/bootstrap.js"></script>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-12 ">
				<h3>招聘信息管理</h3>
			</div>
		</div>
		<div class="row">
			<div class="col-md-4 col-md-offset-8">
				<button type="button" class="btn btn-primary btn-sm"
					id="addRecruitButton">新增</button>
				<button type="button" class="btn btn-danger btn-sm">删除</button>
			</div>
		</div>
		<div class="row">
			<div class="col-md-12">
				<table class="table table-condensed table-hover" id="permtable">
					<thead>
						<th><input type="checkbox" id="input_all" onclick="permqx(0)">全选</th>
						<th>招聘人数</th>
						<th>招聘职位</th>
						<th>职位描述</th>
					</thead>
					<tbody>
					
					<#if recruitInfo??>
						<#list recruitInfo as r>
						<tr>
							<td width="80px"><input type="checkbox" id="input_one"
								onclick="permqx(1)" value="${r.recruitId}">
							</td>
							<td>${r.recruitNumber}</td>
							<td>${r.recruitDept}</td>
							<td>${r.describe}</td>
							<td>
								<button class="btn btn-primary btn-sm editRecruitButton" value="${r.recruitId}" >
									<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
									编辑
								</button>
								<button class="btn btn-danger btn-sm deleteRecruitButton" value="${r.recruitId}">
									<span class="glyphicon glyphicon-trash"></span> 删除
								</button>
							</td>
						</tr>
						</#list>
					</#if>
						
					</tbody>
				</table>
			</div>
		</div>
		
		<!-- 添加弹窗开始 -->
		<div class="modal fade" id="recruitAddModal" data-backdrop="static"
			tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
			<div class="modal-dialog">
				<!-- 添加招聘信息表单开始 -->
				<form id="addrecruitform" action="/prem">
					<div class="modal-content">
						<div class="modal-header">
							<button data-dismiss="modal" class="close" type="button">
								<span aria-hidden="true">×</span><span class="sr-only">Close</span>
							</button>
							<h4 class="modal-title">新增招聘信息</h4>
						</div>
						<div class="modal-body">
							<p>招聘人数</p>
							<input type="text" class="form-control" id="recruitNumber_add_input"
								name="recruitNumber"> <span class="help-block"></span>
						</div>
						<div class="modal-body">
							<p>招聘职位</p>
							<input type="text" class="form-control" id="recruitDept_add_input"
								name="recruitDept"> <span class="help-block"></span>
						</div>
						<div class="modal-body">
							<p>职位描述</p>
							<input type="text" class="form-control" id="describe_add_input"
								name="describe"> <span class="help-block"></span>
						</div>
						<div class="modal-footer">
							<button data-dismiss="modal" class="btn btn-default"
								type="button">关闭</button>
							<button class="btn btn-primary" id="recruit_save_btn" type="button">提交</button>
						</div>
					</div>
					<!-- /.modal-content -->

				</form>
				<!-- 添加招聘信息表单结束 -->
			</div>
			<!-- /.modal-dialog -->
		</div>
	
	</div>
</body>
<script type="text/javascript">
	$(function() {
		$("#addRecruitButton").click(function() {//点击新增按钮弹出新增模态框，
			$('#recruitAddModal').modal({
				backdrop : 'static'
			});
		});
		//表单提交事件
		$("#recruit_save_btn").click(function() {
			$.ajax({
				type : 'POST',
				url : 'recruitInfo',
				data : $('#recruitAddModal form').serialize(),//表单数据
				dataType : 'html',
				success : function(JsonData) {
					var obj = JSON.parse(JsonData);
					if (obj.ret) {
						alert("添加成功");
						$('#recruitAddModal').modal('hide');//关闭模态框
						window.location.href = 'recruitInfo';
					} else {
						alert("添加失败");
					}
				},
				error : function(data) {
					alert("连接失败，请检查网络");
				}
			});
		});
	});

	$(".deleteRecruitButton").click(function() {//删除事件
		//弹出确认删除对话框
		var recruitNumber =  $(this).parents("tr").find("td:eq(1)").text();
		var recruitId =  $(this).parents("tr").find("input").val();
		if(confirm("确认删除：【"+recruitNumber+"】吗？")){
				//删除
			$.ajax({
				type : 'POST',
				url : 'recruitinfo/'+recruitId,
				data: '_method=DELETE',//表单数据
				dataType : 'json',
				success : function(JsonData) {
					if(JsonData.ret){
						alert("删除成功");
						window.location.href = 'recruitInfo';
					}else{
						alert("删除失败");
					}
				}
			});
		}
	});
	
</script>
</html>