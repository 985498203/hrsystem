<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>角色授权</title>
<link rel="stylesheet" type="text/css" href="static/asserts/css/zTreeStyle.css" />
</head>
<style>
body{
	margin: 0px;
	padding: 0px;
}
#b_title{
	background:#e4e4e4;
	height: 50px;
	line-height:50px;
	width: 100%;
}
</style>

<body>
			<!-- <div class="col-md-12 ">正在给角色：[ ]进行授权</div> -->


	<div class="top">
		<div class="row" id="b_title">
		<div class="col-md-12 ">正在给角色：[3333333 ]进行授权</div>
		</div>
	</div>
	<div class="main">
		<ul id="permTree" class="ztree"></ul>
	</div>
</body>
<script type="text/javascript" src="static/asserts/js/jquery-1.4.4.min.js"></script>
<script type="text/javascript" src="static/asserts/js/jquery.ztree.all-3.5.min.js"></script>
<script type="text/javascript" src="static/asserts/js/jquery.ztree.core-3.5.js"></script>
<script type="text/javascript">
	$(function(){

		var setting = {
			 async: {
		            enable: true,
		            url:"asyncgetperm",
		            autoParam:["id", "pid", "name"],
		        },
		        data:{
		            simpleData:{
		                enable: true,
		                idKey:'id',
		                pIdKey:'pid',
		                rootPId: 0
		            }
		        },
		        view:{
		            dblClickExpand: true,//双击节点时，是否自动展开父节点的标识
		            showLine: true,//是否显示节点之间的连线
		            fontCss:{'color':'black','font-weight':'bold'},//字体样式函数
		            selectedMulti: true //设置是否允许同时选中多个节点
		        },
				check: {  
				    enable: true ,//显示复选框  
				    chkStyle : "checkbox"
				}
		};
		
		$(document).ready(function(){
			initZTree();//初始化树
			console.log("加载");
		});
		
		
		
		
		
		//初始化树
		function initZTree(){
		    $.ajax({
		          url:"permtree",
		          type:"post",
		          dataType: "json",
		          success: function(data){
		              console.log(data);
		              var zTreeObj = $.fn.zTree.init($("#permTree"),setting, data); 
		              //让第一个父节点展开
		              var rootNode_0 = zTreeObj.getNodeByParam('pid',0,null);
		              zTreeObj.expandNode(rootNode_0, true, false, false, false);
		          },
		          error: function(){
		              
		          }
		      });
		}
		
		
		
	});


		<!--
		var setting = {	};

		var zNodes =[
			{ name:"父节点1 - 展开", open:true,
				children: [
					{ name:"父节点11 - 折叠",
						children: [
							{ name:"叶子节点111"},
							{ name:"叶子节点112"},
							{ name:"叶子节点113"},
							{ name:"叶子节点114"}
						]},
					{ name:"父节点12 - 折叠",
						children: [
							{ name:"叶子节点121"},
							{ name:"叶子节点122"},
							{ name:"叶子节点123"},
							{ name:"叶子节点124"}
						]},
					{ name:"父节点13 - 没有子节点", isParent:true}
				]},
			{ name:"父节点2 - 折叠",
				children: [
					{ name:"父节点21 - 展开", open:true,
						children: [
							{ name:"叶子节点211"},
							{ name:"叶子节点212"},
							{ name:"叶子节点213"},
							{ name:"叶子节点214"}
						]},
					{ name:"父节点22 - 折叠",
						children: [
							{ name:"叶子节点221"},
							{ name:"叶子节点222"},
							{ name:"叶子节点223"},
							{ name:"叶子节点224"}
						]},
					{ name:"父节点23 - 折叠",
						children: [
							{ name:"叶子节点231"},
							{ name:"叶子节点232"},
							{ name:"叶子节点233"},
							{ name:"叶子节点234"}
						]}
				]},
			{ name:"父节点3 - 没有子节点", isParent:true}

		];

		$(document).ready(function(){
			$.fn.zTree.init($("#treeDemo"), setting, zNodes);
		});
		-->
</script>



</html>