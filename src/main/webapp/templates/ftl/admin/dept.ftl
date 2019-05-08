<!-- 获取绝对路径 -->
<#assign base=springMacroRequestContext.contextPath />
<!DOCTYPE html>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>部门管理</title>
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
				<h3>部门列表</h3>
			</div>
		</div>
		<div class="row">
			<div class="col-md-4 col-md-offset-8">
				<button type="button" class="btn btn-primary btn-sm"
					id="addDeptButton">新增</button>
				<button type="button" class="btn btn-danger btn-sm">删除</button>
			</div>
		</div>
		<div class="row">
			<div class="col-md-12">
				<table class="table table-condensed table-hover" id="depttable">
					<thead>
						<th><input type="checkbox" id="input_all" onclick="deptqx(0)">全选</th>
						<th>部门名称</th>
						<th>上级部门名称</th>
						<th>部门描述</th>
					</thead>
					<tbody>
						<#list pageInfo.pageList as p>
						<tr>
							<td width="80px"><input type="checkbox" id="input_one"
								onclick="deptqx(1)" value="${p.deptId}"></td>
							<td>${p.deptName}</td>
							<td>${(p.parent.deptName) ! "无"}</td>
							
							<td>${p.description}</td>
							<td>
								<button class="btn btn-primary btn-sm editDeptButton"
									value="${p.deptId}">
									<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
									编辑
								</button>
								<button class="btn btn-danger btn-sm deleteDeptButton"
									value="${p.deptId}">
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
						<li><a href="depts.html?pn=1">首页</a></li>
						<li><a href="depts.html?pn=${pageInfo.currentPage-1}"
							aria-label="shangyiye"> <span aria-hidden="true">&laquo;</span>
						</a></li></#if>
						<#list pageInfo.navigatepageNums as n> <!-- 遍历页数 --> <#if
							pageInfo.currentPage== n>
						<li class="active"><a href="depts.html?pn=${n}">${n}</a></li>
						<#else>
						<li><a href="depts.html?pn=${n}">${n}</a></li></#if> </#list>

						<#if pageInfo.currentPage== pageInfo.totalPages> <!-- 如果当前的页数为末页设为禁用 -->
						<li class="disabled"><a>末页</a></li>
						<#else> <!-- 如果当前的页数不是末页 ,正常显示 -->
						<li><a href="depts.html?pn=${pageInfo.currentPage+1}"
							aria-label="Next"> <span aria-hidden="true">&raquo;</span>
						</a></li>
						<li><a href="depts.html?pn=${pageInfo.totalPages}">末页</a></li></#if>
					</ul>
				</nav>
			</div>
		</div>

		<!-- 添加部门弹窗开始 -->
		<div class="modal fade" id="deptAddModal" data-backdrop="static"
			tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
			<div class="modal-dialog">
				<!-- 添加部门表单开始 -->
				<form id="addDeptForm" action="/prem">
					<div class="modal-content">
						<div class="modal-header">
							<button data-dismiss="modal" class="close" type="button">
								<span aria-hidden="true">×</span><span class="sr-only">Close</span>
							</button>
							<h4 class="modal-title">新增部门</h4>
						</div>
						<div class="modal-body">
							<p>部门名称</p>
							<input type="text" class="form-control" id="deptName_add_input" 
								name="deptName"> <span class="help-block"></span>
						</div>
						<div class="modal-body">
							<p>上级部门</p>
							<div class="row">
								<div class="col-md-4 ">
									<select class="form-control" name="parentId">

									</select>
								</div>
							</div>
						</div>
						<div class="modal-body">
							<p>职能描述</p>
							<input type="text" class="form-control" id="description_add_input"
								name="description"> <span class="help-block"></span>
						</div>
						
						
						
						<div class="modal-footer">
							<button data-dismiss="modal" class="btn btn-default"
								type="button">关闭</button>
							<button class="btn btn-primary" id="dept_save_btn" type="button">提交</button>
						</div>
					</div>
					<!-- /.modal-content -->

				</form>
				<!-- 添加部门表单结束 -->
			</div>
			<!-- /.modal-dialog -->
		</div>
		<!-- 修改部门弹窗开始 -->
		<div class="modal fade" id="deptUpdateModal" data-backdrop="static"
			tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
			<div class="modal-dialog">
				<!-- 修改部门表单开始 -->
				<form id="updateDeptFrom" action="/dept">
					<div class="modal-content">
						<div class="modal-header">
							<button data-dismiss="modal" class="close" type="button">
								<span aria-hidden="true">×</span><span class="sr-only">Close</span>
							</button>
							<h4 class="modal-title">修改部门信息</h4>
						</div>
						<!-- 隐藏表单：id -->
						<input type="hidden" name="deptId" id="deptId_update_input"
							value="" />

						<div class="modal-body">
							<p>部门名称</p>
							<input type="text" class="form-control"
								id="deptName_update_input" name="deptName"> <span
								class="help-block"></span>
						</div>
						<div class="modal-body">
							<p>上级部门</p>
							<div class="row">
								<div class="col-md-4 ">
									<select class="form-control" id="parentId_update_select" name="parentId">
										
									</select>
								</div>
							</div>
						</div>
						
						<div class="modal-body">
							<p>职能描述</p>
							<input type="text" class="form-control" id="description_update_input"
								name="description"> <span class="help-block"></span>
						</div>
						<div class="modal-footer">
							<button data-dismiss="modal" class="btn btn-default"
								type="button">关闭</button>
							<button class="btn btn-primary" id="dept_update_btn"
								type="button">更新</button>
						</div>
					</div>
					<!-- /.modal-content -->
				</form>
				<!-- 修改部门表单结束 -->
			</div>
		</div>
		<!-- 修改部门弹窗结束-->
	</div>
</body>
<script type="text/javascript">
	$(function() {

		function reset_from(ele) {
			$(ele)[0].reset();//jq对象转DOM对象调用reset方法
			$(ele).find('*').removeClass('has-error has-success');//清空表单样式
			$(ele).find('.help-block').text('');//清除提示信息
			$('#deptAddModal select').html('');
			var optionEle = $('<option></option>').append('==请选择部门==').attr(
					'value', 0);
			optionEle.appendTo("#deptAddModal select");//添加至下拉列表中
			
		}
		
		
		//点击新增按钮弹出新增部门模态框
		$("#addDeptButton").click(function() {
			// 重置表单数据
			reset_from("#addDeptForm");
			//回显部门列表
			getDeptAll("#deptAddModal select");
			
			
			$('#deptAddModal').modal({//设置点击空白区域模态框不消失
				backdrop : 'static' 
			});
		});
		
		//查出所有的部门列表
		function getDeptAll(ele){
			$.ajax({
				type : 'GET',
				url: 'depts/json',
				dataType : 'json',
				success : function(JsonData) {
					console.log(JsonData);
					if (JsonData.ret) {
						$.each(JsonData.data, function() {//解析数据
							if(undefined!=this.deptName){
								var optionEle = $('<option></option>').append(
										this.deptName).attr('value', this.deptId);
								optionEle.appendTo(ele);//添加至下拉列表中
							}
						});
					}
				},
				error : function(data) {
					alert("获取部门列表失败，请检查网络");
				}
				
			});
		}
		
		//表单提交事件
		$("#dept_save_btn").click(function() {
			var deptName=$("#deptName_add_input").val().trim();
			var description=$("#description_add_input").val().trim();
			if(deptName.length == 0){
				show_validata_info('#deptName_add_input',error,'部门名不能为空');
				return false;
			}
			if ($(this).attr("ajax-va") == "error") {//判断之前ajax检查部门名是否通过
				return false;
			}
			$.ajax({
				type : 'POST',
				url : 'dept',
				data : $('#deptAddModal form').serialize(),//表单数据
				dataType : 'html',
				success : function(JsonData) {
					var obj = JSON.parse(JsonData);
					if (obj.ret) {
						$('#deptAddModal').modal('hide');//关闭模态框
						alert("添加成功");
						lastPage(obj.data);
					} else {
						alert("添加失败，请检查表单");
						if(undefined != obj.extend.errorInfo.deptName){//如果有权限名的错误信息，就显示错误信息
							show_validata_info(
									'#deptAddModal form input[name="deptName"]',
									'error', obj.extend.errorInfo.deptName);
						}
					}
				},
				error : function(data) {
					alert("连接失败，请检查网络");
				}
			});
		});


	//添加后显示最后一页；
	function lastPage(page) {//得到最后一页
		window.location.href = 'depts?pn=' + page;
	}
	
	
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
	
	$('#deptAddModal form input[name="deptName"]').focusout(function() {//鼠标离开输入框时校验部门名是否存在
		var deptName= $(this).val().trim();
		if(deptName.length==0){
			show_validata_info(
					'#deptAddModal form input[name="deptName"]',
					'error', "部门名不能为空");
			$('#dept_save_btn').attr('ajax-va',
					'error');
		}else{
			$.ajax({
				type : 'GET',
				url : 'checkdeptname',
				data : 'deptName=' + deptName,
				dataType : 'json',
				success : function(JsonData) {
					if (JsonData.ret) {
						show_validata_info(
								'#deptAddModal form input[name="deptName"]',
								'success', JsonData.msg);
						$('#dept_save_btn').attr('ajax-va',
								'success');
					} else {
						show_validata_info(
								'#deptAddModal form input[name="deptName"]',
								'error', JsonData.msg);
						$('#dept_save_btn').attr('ajax-va',
								'error');
					}
				},
			});
		}
	});
	
	
	$(".editDeptButton").click(function() {//点击修改按钮弹出新增权限资源模态框，修改权限资源
		
		$('#deptUpdateModal select').html('');
		var optionEle = $('<option></option>').append('==请选择部门==').attr(
				'value', 0);
		optionEle.appendTo("#deptUpdateModal select");//添加至下拉列表中
		
		getDeptAll("#deptUpdateModal select");
		
		$('#deptUpdateModal').modal({//弹出新增权限资源模态框
			backdrop : 'static' //弹出模态框时点击空白区域
		});
		
		//查询数据库，回显数据
		var deptId= $(this).val();
		$.ajax({
			type : 'GET',
			url : 'dept/'+deptId,
			dataType : 'json',
			success : function(JsonData) {
				if(JsonData.ret){
					$("#deptId_update_input").val(JsonData.data.deptId);
					$("#deptName_update_input").val(JsonData.data.deptName);
					$("#description_update_input").val(JsonData.data.description);
					var parentId= JsonData.extend.parentId;
					
					if(undefined==parentId){
						selected(0);
					}else{
						selected(parentId);
						
						//$("#deptUpdateModal select").attr("value",parentId);
					}
				}
			}
		});
	});
	
	//设置select选择状态
	function selected(value){
		alert(value);
		$("#deptUpdateModal select option[value='"+value+"']").attr("selected","selected");
	}
	
	
	
	
	
	
	$("#dept_update_btn").click(function(){//修改按钮提交事件
		//获取表单数据
		var deptId = $("#deptId_update_input").val();
		var deptName = $("#deptName_update_input").val();
		var url = $("#url_update_input").val();
		if(null==deptId || null==deptName){
			alert("输入框不能为空");
		}else{
			$.ajax({
				type : 'POST',
				url : 'dept/'+deptId,
				data: $('#updateDeptFrom').serialize()+'&_method=PUT',//表单数据
				dataType : 'json',
				success : function(JsonData) {
					if(JsonData.ret){
						alert("修改成功");
						$('#deptUpdateModal').modal('hide');//关闭模态框
						window.location.href = 'depts?pn=1';//跳转到第一页
					}else{
						alert("修改失败,请检查表单数据");
					}
				}
			});
		}
	});
	

	$(".deleteDeptButton").click(function() {//删除事件
		//弹出确认删除对话框
		var deptName =  $(this).parents("tr").find("td:eq(1)").text();
		var deptId =  $(this).parents("tr").find("input").val();
		if(confirm("确认删除：【"+deptName+"】吗？")){
				//删除
			$.ajax({
				type : 'POST',
				url : 'dept/'+deptId,
				data: 'id='+deptId+'&_method=DELETE',//表单数据
				dataType : 'json',
				success : function(JsonData) {
					if(JsonData.ret){
						alert("删除成功");
						window.location.href = 'depts?pn=1';//跳转到第一页
					}else{
						alert("删除失败,该权限有子权限");
					}
				}
			});
		}
		
	});
});

	
</script>
</html>