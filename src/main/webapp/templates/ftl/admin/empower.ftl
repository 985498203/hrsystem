<!DOCTYPE html>
<!-- 获取绝对路径 -->
<#assign APP_PATH=springMacroRequestContext.contextPath />
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<link rel="stylesheet" href="${APP_PATH}/static/asserts/css/zTreeStyle.css" type="text/css">
	<script type="text/javascript" src="${APP_PATH}/static/asserts/js/jquery-1.4.4.min.js"></script>
	<script type="text/javascript" src="${APP_PATH}/static/asserts/js/jquery.ztree.core-3.5.js"></script>
	<script type="text/javascript" src="${APP_PATH}/static/asserts/js/jquery.ztree.excheck-3.5.js"></script>
    <link rel="stylesheet" href="${APP_PATH}/static/asserts/css/metroStyle/metroStyle.css" type="text/css">
    <script type="text/javascript" src="${APP_PATH}/static/asserts/js/jquery.ztree.exedit-3.5.js"></script>
   		<!-- Bootstrap core CSS -->
	<link rel="stylesheet" type="text/css"
		href="${APP_PATH}/static/asserts/css/bootstrap.css" />
	<script src="${APP_PATH}/static/asserts/js/bootstrap.js"></script>	 
    
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
	          url:"${APP_PATH}/permtrees",
	          type:"get",
	          dataType: "json",
	          success: function(data){
	        	  $.fn.zTree.init($("#permTree"), setting, data);//初始化数据
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
	<form id="addPermForm">
			<div class="main">
				<ul id="permTree" class="ztree"></ul>
			</div>
			<button type="submit" class="btn btn-primary btn-sm" >保存</button>
	</form>
</body>
<script type="text/javascript">
$("#addPermForm").submit(function(){
	//alert("dsdsds");
	//alert($(this).serialize());
	var zTreeOjb = $.fn.zTree.getZTreeObj("permTree");

	//获取复选框选中的节点：
	var checkedNodes = zTreeOjb.getCheckedNodes();
/* 	alert(checkedNodes);
	 v="";
     for(var i=0;i<checkedNodes.length;i++){
    	 console.log(checkedNodes[i].permId); */
    /*  v+=checkedNodes[i].name + ",";
     console.log("节点id:"+checkedNodes[i].id+"节点名称"+v); //获取选中节点的值 */
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
	        	  alert("请求成功");
	        	  alert(josnData.ret);
	        	  
	        	  
	        	  
	          },
	          error: function(){
	          }
	      });
     }
});


</script>
</html>