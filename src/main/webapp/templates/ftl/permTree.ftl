<!DOCTYPE html>
<!-- 获取绝对路径 -->
<#assign APP_PATH=springMacroRequestContext.contextPath />
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="${APP_PATH}/static/asserts/js/jquery-3.2.1.min.js"></script>
<link rel="stylesheet" href="${APP_PATH}/static/asserts/css/demo.css" type="text/css">
<link rel="stylesheet" href="${APP_PATH}/static/asserts/css/zTreeStyle/zTreeStyle.css" type="text/css">
<script type="text/javascript" src="${APP_PATH}/static/asserts/js/jquery-1.4.4.min.js"></script>
<script type="text/javascript" src="${APP_PATH}/static/asserts/js/jquery.ztree.core.js"></script>
<script type="text/javascript" src="${APP_PATH}/static/asserts/js/jquery.ztree.excheck.js"></script>
</head>
<body>
	
	<div class="zTreeDemoBackground left">
		<ul id="permTree" class="ztree"></ul>
	</div>
	
	
</body>
<script type="text/javascript">
/* ztree的设置 */
 var setting = {
	check:{
		enable:true
	},
	data:{
		simpleData:{
			enacle:true
		}
	}
}
 var zTreeNodes =[
		{ id:1, pId:0, name:"系统管理", open:true},
		{ id:11, pId:1, name:"用户管理", open:true},
		{ id:111, pId:11, name:"添加用户"},
		{ id:112, pId:11, name:"删除用户"},
		{ id:12, pId:1, name:"角色管理", open:true},
		{ id:121, pId:12, name:"添加角色"},
		{ id:122, pId:12, name:"修改角色"},
		{ id:2, pId:0, name:"考勤管理", checked:true, open:true},
		{ id:21, pId:2, name:"查看考勤"},
		{ id:22, pId:2, name:"导入考勤", open:true},
		{ id:221, pId:22, name:"考勤导入", checked:true},
		{ id:222, pId:22, name:"考勤导出"},
		{ id:23, pId:2, name:"删除考勤"}
	];
	
		
	$(function(){
		/* 页面一加载就初始化树 */
		$.fn.zTree.init($("#permTree"),setting,zTreeNodes）
	});
	
	
	
	
	
	

</script>

</html>