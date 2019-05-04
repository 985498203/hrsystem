<!DOCTYPE html>
<!-- 获取绝对路径 -->
<#assign APP_PATH=springMacroRequestContext.contextPath />
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<link rel="stylesheet" href="${APP_PATH}/static/asserts/css/zTreeStyle.css" type="text/css">
	<script type="text/javascript" src="${APP_PATH}/static/asserts/js/jquery-3.2.1.min.js"></script>
	<script type="text/javascript" src="${APP_PATH}/static/asserts/js/jquery.ztree.core-3.5.js"></script>
	<script type="text/javascript" src="${APP_PATH}/static/asserts/js/jquery.ztree.excheck-3.5.js"></script>
    <link rel="stylesheet" href="${APP_PATH}/static/asserts/css/metroStyle/metroStyle.css" type="text/css">
    <script type="text/javascript" src="${APP_PATH}/static/asserts/js/jquery.ztree.exedit-3.5.js"></script>
   		<!-- Bootstrap core CSS -->
	<link rel="stylesheet" type="text/css"
		href="${APP_PATH}/static/asserts/css/bootstrap.css" />
	<script src="${APP_PATH}/static/asserts/js/bootstrap.min.js"></script>	 
    
<style>
.top{
	background: #e4e4e4;
	height: 30px;
	line-height: 30px;

}

</style>
</head>
<script type="text/javascript">
/* ztree的设置 */
	var setting = {
		check: {
			enable: true
		},
		data: {
			simpleData: {
				idKey : "permId",
				pIdKey : "parentId",
				enable: true
			},
			key:{
				name: "permName",
				url: "false"
			}
		}
		
	};
	$(function(){
		/* 页面一加载就初始化树 */
		initZTree();
	});
	
	
	//初始化树
	function initZTree(){
	    $.ajax({
	          url:"${APP_PATH}/loadassigndata/"+${role.roleId},
	          type:"get",
	          dataType: "json",
	          success: function(JsonData){
	        	  $.fn.zTree.init($("#permTree"), setting, JsonData.data);//初始化数据
	          },
	          error: function(){
	          }
	      });
	}
</script>
<body>
				<!-- <div class="col-md-12 ">正在给角色：[ ]进行授权</div> -->
	<div class="top">
		<div class="row" id="b_title">
		<div class="col-md-12 ">正在给角色：[ ${role.remarks}]进行授权</div>
		</div>
	</div>
	<div class="main">
		<button type="button" class="btn btn-primary  btn-sm goroles" >返回角色列表</button>
		<button type="button" class="btn btn-primary  btn-sm assignPermButton" >授予权限</button>
		<ul id="permTree" class="ztree"></ul>
	</div>
</body>
<script type="text/javascript">
$(".assignPermButton").click(function(){
	var zTreeOjb = $.fn.zTree.getZTreeObj("permTree");
	//获取复选框选中的节点：
	var checkedNodes = zTreeOjb.getCheckedNodes();
    if(checkedNodes.length==0){//未选中任何节点
   	 alert("请选择权限");
    }else{
		var data = "roleId=${role.roleId}";
	 	$.each(checkedNodes,function(i,node){
	 	 	data+="&permIds="+node.permId;    	 
	 	});
	  	$.ajax({
	         url:"${APP_PATH}/assignperm/"+${role.roleId},
	         type:"post",
	         dataType: "json",
	         data:data,
	         success: function(josnData){
	        	 if(josnData.ret){
	        		 alert("授权成功");
	        		 window.location.href = "${APP_PATH}/roles";//成功后跳转至角色列表
	        	 }else{
	        		 alert("授权失败,请稍后重试");
	        	 }
	         },
	         error: function(){
	        	 alert("授权失败,请检查网络");
	         }
	     });
   }
});

$(".goroles").click(function(){//返回按钮点击事件
	 window.location.href = "${APP_PATH}/roles";//跳转至角色列表
});
/* function loadAssignData(){
	$.ajax({
         url:"${APP_PATH}/loadassigndata/"+${role.roleId},
         type:"get",
         dataType: "json",
         success: function(josnData){
        	 if(josnData.ret){
        		 alert("成功");
        	 }else{
        		 alert("加载数据失败");
        	 }
         },
         error: function(){
        	 alert("加载数据失败,请检查网络");
         }
     });
} */


</script>
</html>