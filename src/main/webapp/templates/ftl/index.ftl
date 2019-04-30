<!DOCTYPE html>
<html>
<head>
<#setting number_format="#">
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<meta name="format-detection" content="telephone=no">
<title>人力资源系统</title>
		<script type="text/javascript" src="static/asserts/js/jquery.min.js"></script>
		<script type="text/javascript" src="static/asserts/js/jquery-3.2.1.min.js"></script>
		<script type="text/javascript" src="static/asserts/js/bootstrap.min.js"></script>
		<script type="text/javascript" src="static/asserts/js/index.js"></script>
	<script type="text/javascript" src="static/asserts/js/permission.js"></script>
   		<link rel="stylesheet" type="text/css" href="static/asserts/css/bootstrap.min.css" />
        <link rel="stylesheet" type="text/css" href="static/asserts/css/bootstrap-theme.min.css">
        <link rel="stylesheet" type="text/css" href="static/asserts/css/index.css">
        <link rel="stylesheet" type="text/css" href="static/asserts/css/common.css" />
        <link rel="stylesheet" type="text/css" href="static/asserts/css/slide.css" />
        <link rel="stylesheet" type="text/css" href="static/asserts/css/flat-ui.min.css" />
        <link rel="stylesheet" type="text/css" href="static/asserts/css/jquery.nouislider.css">
</head>
<body>
        <div id="wrap">
            <!-- 左侧菜单栏目块 -->
            <div class="leftMeun" id="leftMeun">
                <div id="logoDiv">
                    <p id="logoP"><img id="logo" alt="人力资源管理" src="static/asserts/img/logo.png"><span>人力资源系统</span></p>
                </div>
                <div id="personInfor">
                    <p id="userName">杨鹏</p>
                    <p>
                        <a>退出登录</a>
                    </p>
                </div>
                <div class="meun-title">信息管理</div>
                <div class="meun-item" onclick="gongdan()" role="tab" data-toggle="tab"><img src="static/asserts/img/icon_source.png">工单</div>
                <div class="meun-item" onclick="ygxx()" role="tab" data-toggle="tab"><img src="static/asserts/img/icon_card_grey.png">员工信息</div>
                <div class="meun-title">人事管理</div>
                <div class="meun-item" id="zpgl"  onclick="zhaoping()" role="tab" data-toggle="tab"><img src="static/asserts/img/icon_house_grey.png">招聘</div>
                <div class="meun-item" onclick="kaoqin()" role="tab" data-toggle="tab"><img src="static/asserts/img/icon_change_grey.png">考勤</div>
            	<div class="meun-title">权限管理</div>
                <div class="meun-item" id="qxgl" onclick="qxgl()" role="tab" data-toggle="tab"><img src="static/asserts/img/icon_chara_grey.png">权限管理</div>
                <div class="meun-item" id="jsgl" onclick="jsgl()" role="tab" data-toggle="tab"><img src="static/asserts/img/icon_card_grey.png">角色管理</div>
            </div>
            <!-- 右侧具体内容栏目 -->
            <div id="rightContent">
            	<!-- 工单模块 -->
            	<div class="gongdan">
            	</div>
            	<!-- 员工信息模块 -->
            	<div class="ygxx">
            	</div>
            	<!-- 招聘模块 -->
            	<div class="zhaoping">
            	</div> 
            	<!-- 考勤模块 -->
				<div class="kaoqin">
					  <h1>考勤</h1>
            	</div>     
            	<!-- 权限管理模块 -->
			<div class="qxgl" id="qxglpage">
            	</div> 
            			<iframe scrolling="no" id="qxgliframe" name="main" frameborder="0"
     						 style="min-height:600px;width:100%;height:100%;"></iframe>
            	<!-- 角色管理模块 -->
				<div id="jsgl" >
					  
            	</div>                     	
			</div>
		</div>
</body>
</html>