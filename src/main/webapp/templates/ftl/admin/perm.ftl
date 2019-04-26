<!-- 获取绝对路径 -->
<#assign base=springMacroRequestContext.contextPath />
<!DOCTYPE html>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>权限管理</title>
<!-- Bootstrap core CSS -->
<script src="http://how2j.cn/study/js/jquery/2.0.0/jquery.min.js"></script>
<link href="http://how2j.cn/study/css/bootstrap/3.3.6/bootstrap.min.css" rel="stylesheet">
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
				<button type="button" class="btn btn-primary btn-sm"
					id="addPermModal">新增</button>
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
							<td><input type="checkbox"  id="input_one"
								onclick="permqx(1)" value="${p.permId}">
							</th>
							</td>
							<td>${p.permName}</td>
							<td>${p.url}</td>
							<td width="600px">
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
			<div class="col-md-5">第${pageInfo.currentPage}页,共${pageInfo.totalPages}页,总记录数:${pageInfo.count}</div>
			<!-- 分页条信息 -->
			<div class="col-md-7">
				<nav aria-label="Page navigation">
					<ul class="pagination">

						<#if pageInfo.currentPage==1>
						<li class="disabled"><a>首页</a></li>
					<#else>
						<li><a href="perms.html?pn=1" >首页</a>
						</li>
						<li><a href="perms.html?pn=${pageInfo.currentPage-1}" aria-label="shangyiye">
							<span aria-hidden="true">&laquo;</span>
							</a>
						</li>
					</#if>
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
				<form action="/prem">
					<div class="modal-content">
						<div class="modal-header">
							<button data-dismiss="modal" class="close" type="button">
								<span aria-hidden="true">×</span><span class="sr-only">Close</span>
							</button>
							<h4 class="modal-title">新增权限资源</h4>
						</div>
						<div class="modal-body">
							<p>权限名称</p>
							<input type="text" class="form-control" name="permName">
						</div>
						<div class="modal-body">
							<p>资源URl</p>
							<input type="text" class="form-control" name="url">
						</div>
						<div class="modal-footer">
							<button data-dismiss="modal" class="btn btn-default"
								type="button">关闭</button>
							<button class="btn btn-primary" id="perm_save_btn"
								type="button">提交</button>
						</div>
					</div>
					<!-- /.modal-content -->

				</form>
				<!-- 添加权限资源表单结束 -->
			</div>
			<!-- /.modal-dialog -->

		</div>

	</div>

</body>
<script type="text/javascript">
/* 全选反选事件 */
function permqx(obj){
	var all = document.getElementById("input_all");
	var noe = document.getElementsByName("input_one");
	if(obj == 1){

		if(all.checked == true){
			alert("true");
			for(var i=0 ;i<noe.length;i++){
				noe[i].checked = true;
			}
		}else{
			for(var i=0 ;i<noe.length;i++){
				noe[i].checked = false;
			}
		}
		}else{
	}
}
	$(function() {
		
		
		
		
		
		
		
		
		
		
			$("#addPermModal").click(function() {//新增权限资源
				$('#permaddModal').modal({//弹出新增权限资源模态框
					backdrop : 'static'
				});
			});
			$("#perm_save_btn").click(function(){
				var permname = $.trim( $('#permaddModal form input[name="permName"]').val());
				var url= $.trim($('#permaddModal form input[name="url"]').val());
				if(permname == "" || permname == null || permname == "" || permname == null  ){
					alert("权限名称或不能为空");
				}else{
					$.ajax({
						type : 'POST',
						url : 'perm',
						data : $('#permaddModal form').serialize(),//表单数据
						dataType : 'html',
						success : function(JsonData){
							var  obj=JSON.parse(JsonData);
							if(obj.ret){
								 alert("添加成功");
								 $('#permaddModal').modal('hide');//关闭模态框
							}else{
								alert("添加失败");
							}
						},
						 error:function(data){
					          alert("添加失败");
					      }
					});
				}
			});
	});

</script>
</html>