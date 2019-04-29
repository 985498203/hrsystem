<!-- 获取绝对路径 -->
<#assign base=springMacroRequestContext.contextPath />
<!DOCTYPE html>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>权限管理</title>
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
				<h3>资源列表</h3>
			</div>
		</div>
		<div class="row">
			<div class="col-md-4 col-md-offset-8">
				<button type="button" class="btn btn-primary btn-sm"
					id="addPermButton">新增</button>
				<button type="button" class="btn btn-danger btn-sm">删除</button>
			</div>
		</div>
		<div class="row">
			<div class="col-md-12">
				<table class="table table-condensed table-hover" id="permtable">
					<thead>
						<th><input type="checkbox" id="input_all" onclick="permqx(0)">全选</th>
						<th>资源名称</th>
						<th>资源URL</th>
					</thead>
					<tbody>
						<#list pageInfo.pageList as p>
						<tr>
							<td width="80px"><input type="checkbox" id="input_one"
								onclick="permqx(1)" value="${p.permId}">
							</th>
							</td>
							<td>${p.permName}</td>
							<td>${p.url}</td>
							<td>
								<button class="btn btn-primary btn-sm editPermButton" >
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
			<div class="col-md-5">第${pageInfo.currentPage}页,共${pageInfo.totalPages}页,总记录数:${pageInfo.count}</div>
			<!-- 分页条信息 -->
			<div class="col-md-7">
				<nav aria-label="Page navigation">
					<ul class="pagination">

						<#if pageInfo.currentPage==1>
						<li class="disabled"><a>首页</a></li>
						<#else>
						<li><a href="perms.html?pn=1">首页</a></li>
						<li><a href="perms.html?pn=${pageInfo.currentPage-1}"
							aria-label="shangyiye"> <span aria-hidden="true">&laquo;</span>
						</a></li></#if>
						<#list pageInfo.navigatepageNums as n> <!-- 遍历页数 --> <#if
							pageInfo.currentPage== n>
						<li class="active"><a href="perms.html?pn=${n}">${n}</a></li>
						<#else>
						<li><a href="perms.html?pn=${n}">${n}</a></li></#if> </#list>

						<#if pageInfo.currentPage== pageInfo.totalPages> <!-- 如果当前的页数为末页设为禁用 -->
						<li class="disabled"><a>末页</a></li>
						<#else> <!-- 如果当前的页数不是末页 ,正常显示 -->
						<li><a href="perms.html?pn=${pageInfo.currentPage+1}"
							aria-label="Next"> <span aria-hidden="true">&raquo;</span>
						</a></li>
						<li><a href="perms.html?pn=${pageInfo.totalPages}">末页</a></li></#if>

					</ul>
				</nav>
			</div>
		</div>

		<!-- 添加权限资源弹窗开始 -->
		<div class="modal fade" id="permaddModal" data-backdrop="static"
			tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
			<div class="modal-dialog">
				<!-- 添加权限资源表单开始 -->
				<form id="addpermform" action="/prem">
					<div class="modal-content">
						<div class="modal-header">
							<button data-dismiss="modal" class="close" type="button">
								<span aria-hidden="true">×</span><span class="sr-only">Close</span>
							</button>
							<h4 class="modal-title">新增权限资源</h4>
						</div>
						<div class="modal-body">
							<p>权限名称</p>
							<input type="text" class="form-control" id="permName_add_input"
								name="permName"> <span class="help-block"></span>
						</div>
						<div class="modal-body">
							<p>资源URl</p>
							<input type="text" class="form-control" id="url_add_input"
								name="url"> <span class="help-block"></span>
						</div>
						<div class="modal-body">
							<p>上级权限</p>
							<div class="row">
								<div class="col-md-4 ">
									<select class="form-control" name="parentId">

									</select>
								</div>
							</div>
						</div>


						<div class="modal-footer">
							<button data-dismiss="modal" class="btn btn-default"
								type="button">关闭</button>
							<button class="btn btn-primary" id="perm_save_btn" type="button">提交</button>
						</div>
					</div>
					<!-- /.modal-content -->

				</form>
				<!-- 添加权限资源表单结束 -->
			</div>
			<!-- /.modal-dialog -->
		</div>
		
		
		
		<!-- 修改权限资源弹窗开始 -->
		<div class="modal fade" id="permUpdateModal" data-backdrop="static"
			tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
			<div class="modal-dialog">
				<!-- 修改权限资源表单开始 -->
				<form id="updatePermFrom" action="/prem">
					<div class="modal-content">
						<div class="modal-header">
							<button data-dismiss="modal" class="close" type="button">
								<span aria-hidden="true">×</span><span class="sr-only">Close</span>
							</button>
							<h4 class="modal-title">修改权限资源</h4>
						</div>
						<div class="modal-body">
							<p>权限名称</p>
							<input type="text" class="form-control" id="permName_update_input"
								name="permName"> <span class="help-block"></span>
						</div>
						<div class="modal-body">
							<p>资源URl</p>
							<input type="text" class="form-control" id="url_update_input"
								name="url"> <span class="help-block"></span>
						</div>
						<div class="modal-body">
							<p>上级权限</p>
							<div class="row">
								<div class="col-md-4 ">
									<select class="form-control" name="parentId">

									</select>
								</div>
							</div>
						</div>


						<div class="modal-footer">
							<button data-dismiss="modal" class="btn btn-default"
								type="button">关闭</button>
							<button class="btn btn-primary" id="perm_update_btn" type="button">更新</button>
						</div>
					</div>
					<!-- /.modal-content -->
				</form>
				<!-- 修改权限资源表单结束 -->
			</div>
		</div>
		<!-- 修改权限资源弹窗结束-->
		
		
		
		
		
		
		
		
		
	</div>
</body>
<script type="text/javascript">
	/* 全选反选事件 */
	function permqx(obj) {
		var all = document.getElementById("input_all");
		var noe = document.getElementsByName("input_one");
		if (obj == 1) {

			if (all.checked == true) {
				alert("true");
				for (var i = 0; i < noe.length; i++) {
					alert("遍历");
					noe[i].checked = true;
				}
			} else {
				for (var i = 0; i < noe.length; i++) {
					noe[i].checked = false;
				}
			}
		} else {
		}
	}
	$(function() {

		function reset_from(ele) {
			$(ele)[0].reset();//jq对象转DOM对象调用reset方法
			$(ele).find('*').removeClass('has-error has-success');//清空表单样式
			$(ele).find('.help-block').text('');//清除提示信息
			$('#permaddModal select').html('');
			var optionEle = $('<option></option>').append('不选则设为顶级权限').attr(
					'value', 0);
			optionEle.appendTo("#permaddModal select");//添加至下拉列表中
		}
		$("#addPermButton").click(function() {//点击新增按钮弹出新增权限资源模态框，新增权限资源
			// 重置表单数据 
			reset_from("#addpermform");
			//1.发送ajax，先查出所有的顶级权限，显示在下拉列表中
			getSuperPerm();
			$('#permaddModal').modal({
				backdrop : 'static'
			});
		});

		//表单提交事件
		$("#perm_save_btn").click(function() {
			if (!validata_add_form()) {//校验表单数据
				return false;
			}
			if ($(this).attr("ajax-va") == "error") {//判断之前ajax检查权限名和URl是可用
				return false;
			}
			$.ajax({
				type : 'POST',
				url : 'perm',
				data : $('#permaddModal form').serialize(),//表单数据
				dataType : 'html',
				success : function(JsonData) {
					var obj = JSON.parse(JsonData);
					if (obj.ret) {
						alert("添加成功");
						$('#permaddModal').modal('hide');//关闭模态框
						lastPage(obj.data);
					} else {
						alert("添加失败，请检查表单");
						if(undefined != obj.extend.errorInfo.permName){//如果有权限名的错误信息，就显示错误信息
							show_validata_info(
									'#permaddModal form input[name="permName"]',
									'error', obj.extend.errorInfo.permName);
						}
						if(undefined != obj.extend.errorInfo.url){//如果有URL的错误信息，就显示错误信息
							show_validata_info(
									'#permaddModal form input[name="url"]',
									'error', obj.extend.errorInfo.url);
						}	
					}
				},
				error : function(data) {
					alert("连接失败，请检查网络");
				}
			});
		});
	});

	//添加后显示最后一页；
	function lastPage(page) {//得到最后一页
		window.location.href = 'perms?pn=' + page;
	}
	//得到顶级权限
	function getSuperPerm() {
		$.ajax({
			type : 'GET',
			url : 'superperm',
			dataType : 'json',
			success : function(JsonData) {
				if (JsonData.ret) {
					$.each(JsonData.data, function() {//解析数据
						var optionEle = $('<option></option>').append(
								this.permName).attr('value', this.permId);
						optionEle.appendTo("#permaddModal select");//添加至下拉列表中
					});
				}
			},
		});
	}
	//提交表单时校验数据
	function validata_add_form() {
		var permName = $.trim($('#permaddModal form input[name="permName"]')
				.val());
		var url = $.trim($('#permaddModal form input[name="url"]').val());
		var ZzpermName = /(^[a-zA-Z0-9_-]{2,50}$)|(^[\u2E80-\u9FFF]{2,20}$)/;//字母(2~50个)或汉字(2~20个)
		//var  Zzurl = /[\u4E00-\u9FA5\uF900-\uFA2D]/;//不能有汉字
		var Zzurl = /[\u4E00-\u9FA5]/g;

		if (!ZzpermName.test(permName)) {//校验权限名
			//alert("权限名必须为2~20汉字或者2~50数字字母的组合");
			show_validata_info('#permaddModal form input[name="permName"]',
					'error', '权限名必须为2~20汉字或者2~50数字字母的组合');
			return false;
		} else {
			show_validata_info('#permaddModal form input[name="permName"]',
					'success', '');
		}
		if (Zzurl.test(url) || url.length < 2) {
			show_validata_info('#permaddModal form input[name="url"]', 'error',
					'URL不能包含汉字且长度必须大于1');
			return false;
		} else {
			show_validata_info('#permaddModal form input[name="url"]',
					'success', '');
		}
		return true;
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
	$('#permaddModal form input[name="permName"]')
			.focusout(
					function() {//鼠标离开输入框时校验权限名是否存在
						var permName = this.value;
						$.ajax({
							type : 'GET',
							url : 'checkpermname',
							data : 'permName=' + permName,
							dataType : 'json',
							success : function(JsonData) {
								if (JsonData.ret) {
									show_validata_info(
											'#permaddModal form input[name="permName"]',
											'success', JsonData.msg);
									$('#perm_save_btn').attr('ajax-va',
											'success');
								} else {
									show_validata_info(
											'#permaddModal form input[name="permName"]',
											'error', JsonData.msg);
									$('#perm_save_btn').attr('ajax-va',
											'error');
								}
							},
						});
					});
	$('#permaddModal form input[name="url"]').focusout(
			function() {//鼠标离开输入框时校验权限URL是否存在
				var url = this.value;
				$.ajax({
					type : 'GET',
					url : 'checkpermurl',
					data : 'url=' + url,
					dataType : 'json',
					success : function(JsonData) {
						if (JsonData.ret) {
							show_validata_info(
									'#permaddModal form input[name="url"]',
									'success', JsonData.msg);
							$('#perm_save_btn').attr('ajax-va', 'success');
						} else {
							show_validata_info(
									'#permaddModal form input[name="url"]',
									'error', JsonData.msg);
							$('#perm_save_btn').attr('ajax-va', 'error');
						}
					},
				});

			});
	
	
	
	
	$(".editPermButton").click(function() {//点击修改按钮弹出新增权限资源模态框，修改权限资源
		
		$('#permUpdateModal').modal({//弹出新增权限资源模态框
			backdrop : 'static' //弹出模态框时点击空白区域
		});
	
	
	});
	
	
	
	
	
	
	
	
	
	
</script>
</html>