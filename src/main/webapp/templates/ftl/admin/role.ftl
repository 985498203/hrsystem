<!-- 获取绝对路径 -->
<#assign base=springMacroRequestContext.contextPath />
<!DOCTYPE html>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>角色管理</title>
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
				<h3>角色列表</h3>
			</div>
		</div>
		<div class="row">
			<div class="col-md-4 col-md-offset-8">
				<button type="button" class="btn btn-primary btn-sm"
					id="addRoleButton">新增</button>
				<button type="button" class="btn btn-danger btn-sm">删除</button>
			</div>
		</div>
		<div class="row">
			<div class="col-md-12">
				<table class="table table-condensed table-hover" id="roletable">
					<thead>
						<th><input type="checkbox" id="input_all" onclick="roleqx(0)">全选</th>
						<th>角色名称</th>
						<th>角色描述</th>
					</thead>
					<tbody>
						<#list pageInfo.pageList as p>
						<tr>
							<td width="80px"><input type="checkbox" id="input_one"
								onclick="roleqx(1)" value="${p.roleId}">
							</td>
							<td>${p.roleName}</td>
							<td>${p.remarks}</td>
							<td>
								<button class="btn btn-primary btn-sm editRoleButton" value="${p.roleId}" >
									<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
									编辑
								</button>
								<button class="btn btn-danger btn-sm deleteRoleButton" value="${p.roleId}">
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
			<div class="col-md-5">第${pageInfo.currentPage}页,共${pageInfo.totalPages}页,总记录数:${pageInfo.count}</div>
			<!-- 分页条信息 -->
			<div class="col-md-7">
				<nav aria-label="Page navigation">
					<ul class="pagination">

						<#if pageInfo.currentPage==1>
						<li class="disabled"><a>首页</a></li>
						<#else>
						<li><a href="roles.html?pn=1">首页</a></li>
						<li><a href="roles.html?pn=${pageInfo.currentPage-1}"
							aria-label="shangyiye"> <span aria-hidden="true">&laquo;</span>
						</a></li></#if>
						<#list pageInfo.navigatepageNums as n> <!-- 遍历页数 --> <#if
							pageInfo.currentPage== n>
						<li class="active"><a href="roles.html?pn=${n}">${n}</a></li>
						<#else>
						<li><a href="roles.html?pn=${n}">${n}</a></li></#if> </#list>

						<#if pageInfo.currentPage== pageInfo.totalPages> <!-- 如果当前的页数为末页设为禁用 -->
						<li class="disabled"><a>末页</a></li>
						<#else> <!-- 如果当前的页数不是末页 ,正常显示 -->
						<li><a href="roles.html?pn=${pageInfo.currentPage+1}"
							aria-label="Next"> <span aria-hidden="true">&raquo;</span>
						</a></li>
						<li><a href="roles.html?pn=${pageInfo.totalPages}">末页</a></li></#if>
					</ul>
				</nav>
			</div>
		</div>

		<!-- 添加角色弹窗开始 -->
		<div class="modal fade" id="roleAddModal" data-backdrop="static"
			tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
			<div class="modal-dialog">
				<!-- 添加角色表单开始 -->
				<form id="addRoleform" action="/role">
					<div class="modal-content">
						<div class="modal-header">
							<button data-dismiss="modal" class="close" type="button">
								<span aria-hidden="true">×</span><span class="sr-only">Close</span>
							</button>
							<h4 class="modal-title">新增角色</h4>
						</div>
						<div class="modal-body">
							<p>角色名称</p>
							<input type="text" class="form-control" id="roleName_add_input"
								name="roleName"> <span class="help-block"></span>
						</div>
						<div class="modal-body">
							<p>角色描述</p>
							<input type="text" class="form-control" id="remarks_add_input"
								name="remarks"> <span class="help-block"></span>
						</div>
						<div class="modal-footer">
							<button data-dismiss="modal" class="btn btn-default"
								type="button">关闭</button>
							<button class="btn btn-primary" id="role_save_btn" type="button">提交</button>
						</div>
					</div>
					<!-- /.modal-content -->
				</form>
				<!-- 添加角色表单结束 -->
			</div>
			<!-- /.modal-dialog -->
		</div>
		<!-- 修改角色弹窗开始 -->
		<div class="modal fade" id="roleUpdateModal" data-backdrop="static"
			tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
			<div class="modal-dialog">
				<!-- 修改角色表单开始 -->
				<form id="updateRoleFrom" action="/role">
					<div class="modal-content">
						<div class="modal-header">
							<button data-dismiss="modal" class="close" type="button">
								<span aria-hidden="true">×</span><span class="sr-only">Close</span>
							</button>
							<h4 class="modal-title">修改角色</h4>
						</div>
						<!-- 隐藏表单：id -->
						<input type="hidden" name="roleId" id="roleId_update_input" value=""/>
						
						<div class="modal-body">
							<p>角色名称</p>
							<input type="text" class="form-control" id="roleName_update_input"
								name="roleName"> <span class="help-block"></span>
						</div>
						<div class="modal-body">
							<p>角色描述</p>
							<input type="text" class="form-control" id="remarks_update_input"
								name="remarks"> <span class="help-block"></span>
						</div>
						<div class="modal-footer">
							<button data-dismiss="modal" class="btn btn-default"
								type="button">关闭</button>
							<button class="btn btn-primary" id="role_update_btn" type="button">更新</button>
						</div>
					</div>
					<!-- /.modal-content -->
				</form>
				<!-- 修改角色表单结束 -->
			</div>
		</div>
		<!-- 修改角色弹窗结束-->
	</div>
</body>
<script type="text/javascript">
	$(function() {

		function reset_from(ele) {
			$(ele)[0].reset();//jq对象转DOM对象调用reset方法
			$(ele).find('*').removeClass('has-error has-success');//清空表单样式
			$(ele).find('.help-block').text('');//清除提示信息
			$('#roleAddModal select').html('');
		}
		
		$("#addRoleButton").click(function() {//点击新增按钮弹出新增角色模态框，新增角色
			// 重置表单数据 
			reset_from("#addRoleform");
			$('#roleAddModal').modal({
				backdrop : 'static'
			});
		});

		//表单提交事件
		$("#role_save_btn").click(function() {
			$.ajax({
				type : 'POST',
				url : 'role',
				data : $('#roleAddModal form').serialize(),//表单数据
				dataType : 'html',
				success : function(JsonData) {
					var obj = JSON.parse(JsonData);
					if (obj.ret) {
						alert("添加成功");
						$('#roleAddModal').modal('hide');//关闭模态框
						window.location.href = 'roles?pn=1';
					} else {
						alert("添加失败，请检查表单");
						if(undefined != obj.extend.errorInfo.roleName){//如果有权限名的错误信息，就显示错误信息
							show_validata_info(
									'#roleAddModal form input[name="roleName"]',
									'error', obj.extend.errorInfo.roleName);
						}
						if(undefined != obj.extend.errorInfo.remarks){//如果有URL的错误信息，就显示错误信息
							show_validata_info(
									'#roleAddModal form input[name="remarks"]',
									'error', obj.extend.errorInfo.remarks);
						}	
					}
				},
				error : function(data) {
					alert("连接失败，请检查网络");
				}
			});
		});
	});

	function show_validata_info(ele, status, msg) {//显示校验信息
		//清除当前的校验状态
		$(ele).parent().removeClass('has-success has-error');
		$(ele).next('span').text('');
		if ("success" == status) {
			$(ele).parent().addClass('has-success');
			$(ele).next('span').text(msg);
		} else {
			$(ele).parent().addClass('has-error');
			$(ele).next('span').text(msg);
		}
	}
	
	$('#roleAddModal form input[name="roleName"]')
			.focusout(
					function() {//鼠标离开输入框时校验角色名是否存在
						var roleName = this.value;
						$.ajax({
							type : 'GET',
							url : 'checkrolename',
							data : 'roleName=' + roleName,
							dataType : 'json',
							success : function(JsonData) {
								if (JsonData.ret) {
									show_validata_info(
											'#roleAddModal form input[name="roleName"]',
											'success', JsonData.msg);
									$('#role_save_btn').attr('ajax-va',
											'success');
								} else {
									show_validata_info(
											'#roleAddModal form input[name="roleName"]',
											'error', JsonData.msg);
									$('#role_save_btn').attr('ajax-va',
											'error');
								}
							},
						});
					});
	$(".editRoleButton").click(function() {//点击修改按钮弹出新增角色模态框，修改角色
		$('#roleUpdateModal').modal({//弹出新增角色模态框
			backdrop : 'static' //弹出模态框时点击空白区域
		});
		//查询数据库，回显数据
		var roleId= $(this).val();
		$.ajax({
			type : 'GET',
			url : 'role/'+roleId,
			dataType : 'json',
			success : function(JsonData) {
				if(JsonData.ret){
					$("#roleId_update_input").val(JsonData.data.roleId);
					$("#roleName_update_input").val(JsonData.data.roleName);
				}
			}
		});
	});
	
	
	$("#role_update_btn").click(function(){//修改按钮提交事件
		//获取表单数据
		var roleId = $("#roleId_update_input").val();
		var roleName = $("#roleName_update_input").val();
		var remarks = $("#remarks_update_input").val();
		if(null==roleId || null==roleName || null==remarks){
			alert("输入框不能为空");
		}else{
			$.ajax({
				type : 'POST',
				url : 'role/'+roleId,
				data: $('#updateRoleFrom').serialize()+'&_method=PUT',//表单数据
				dataType : 'json',
				success : function(JsonData) {
					if(JsonData.ret){
						alert("修改成功");
						$('#roleUpdateModal').modal('hide');//关闭模态框
						window.location.href = 'roles?pn=1';//跳转到第一页
					}else{
						alert("修改失败,请检查表单数据");
					}
				}
			});
		}
	});
	$(".editRoleButton").click(function() {//点击修改按钮弹出新增权限资源模态框，修改权限资源
		$('#roleUpdateModal').modal({//弹出新增权限资源模态框
			backdrop : 'static' //弹出模态框时点击空白区域
		});
		//查询数据库，回显数据
		var roleId= $(this).val();
		$.ajax({
			type : 'GET',
			url : 'role/'+roleId,
			dataType : 'json',
			success : function(JsonData) {
				if(JsonData.ret){
					$("#roleId_update_input").val(JsonData.data.roleId);
					$("#roleName_update_input").val(JsonData.data.roleName);
					$("#remarks_update_input").val(JsonData.data.remarks);
				}
			}
		});
		//
	});
	
	$(".deleteRoleButton").click(function() {//删除事件
		//弹出确认删除对话框
		var roleName =  $(this).parents("tr").find("td:eq(1)").text();
		var roleId =  $(this).parents("tr").find("input").val();
		if(confirm("确认删除：【"+roleName+"】吗？")){
				//删除
			$.ajax({
				type : 'POST',
				url : 'role/'+roleId,
				data: 'id='+roleId+'&_method=DELETE',//表单数据
				dataType : 'json',
				success : function(JsonData) {
					if(JsonData.ret){
						alert("删除成功");
						window.location.href = 'roles?pn=1';//跳转到第一页
					}else{
						alert("删除失败");
					}
				}
			});
		}
		
	});
	
</script>
</html>