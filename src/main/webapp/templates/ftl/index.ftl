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
		<#if !list??>
			<script type="text/javascript">
	 			window.location.href="finduser.html?pageNo=1";
	 		</script>
		</#if>
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
                <div class="meun-item" onclick="zhaoping()" role="tab" data-toggle="tab"><img src="static/asserts/img/icon_house_grey.png">招聘</div>
                <div class="meun-item" onclick="kaoqin()" role="tab" data-toggle="tab"><img src="static/asserts/img/icon_change_grey.png">考勤</div>
            	<div class="meun-title">权限管理</div>
                <div class="meun-item" onclick="yhgl()" role="tab" data-toggle="tab"><img src="static/asserts/img/icon_user_grey.png">用户管理</div>
                <div class="meun-item" onclick="qxgl()" role="tab" data-toggle="tab"><img src="static/asserts/img/icon_chara_grey.png">权限管理</div>
                <div class="meun-item" onclick="jsgl()" role="tab" data-toggle="tab"><img src="static/asserts/img/icon_card_grey.png">角色管理</div>
            </div>
            <!-- 右侧具体内容栏目 -->
            <div id="rightContent">
            	<!-- 工单模块 -->
            	<div class="gongdan">
            		<h1>工单模块</h1>
            	</div>
            	<!-- 员工信息模块 -->
            	<div class="ygxx">
            		<div>
            		  <form action="deluser.html" method="post">
					  <table class="table">
					 	<tr>
							<th>全选<br/><input type="checkbox" id="all" name="all" onclick="qx(1);"/></th>
							<th>员工编号</th>
							<th>员工姓名</th>
							<th>员工年龄</th>
							<th>员工电话</th>
							<th>员工邮箱</th>
							<th class="th">
								<div class="dropdowns">
									<span>操作</span><b class="caret"></b>
									<div class="dropdown-contents">
										<p>
											<button id="delete" type="submit">删除</button>
										</p>
										<hr>
										<p>
											<button id="update" type="button" onclick="tj()">添加</button>
										</p>
									</div>
								</div>
							</th>
						</tr>
						<#if list??>
							<#list list as u>
								<tr>
									<td><input type="checkbox" id="one" value="${u.userId}" name="one" onclick="qx(2);"/></td>
									<td>${u.userId}</td>
									<td>${u.name}</td>
									<td>${u.age}</td>
									<td>${u.phone}</td>
									<td>${u.email}</td>
									<td style="text-align:left;">
										<button id="update" value="${u.userId},${u.name},${u.age},${u.phone},${u.email}" type="button" name="update${u.userId}" style="border:0px;background-color:#eff3f6;color:green;" onclick="xs(${u.userId})">修改</button>
									</td>
								</tr>
							</#list>
						</#if>
				  	  </table>
				  </form>
				  </div>
				  <#if list??>
				  <div id="page">
				  	<ul class="pagers">
					    <li><a href="finduser.html?pageNo=1">首页</a></li>
					    <li>|</li>
					    <li><a href="finduser.html?pageNo=<#if dno-1 gt 1>${dno-1}<#else>1</#if>">上一页</a></li>
					    <li>|</li>
					    <li><a href="finduser.html?pageNo=<#if dno+1 gt pageNo>${pageNo}<#else>${dno+1}</#if>">下一页</a></li>
					    <li>|</li>
					    <li><a href="finduser.html?pageNo=${pageNo}">尾页</a></li>
				  	</ul>
				  </div>
				  </#if>
            	</div>
            	<!-- 招聘模块 -->
            	<div class="zhaoping">
            		  <h1>招聘</h1>
            	</div> 
            	<!-- 考勤模块 -->
				<div class="kaoqin">
					  <h1>考勤</h1>
            	</div>    
            	<!-- 用户管理模块 -->
				<div class="yhgl">
					  <h1>用户管理</h1>
            	</div>   
            	<!-- 权限管理模块 -->
				<div class="qxgl">
					  <h1>权限管理</h1>
            	</div> 
            	<!-- 角色管理模块 -->
				<div class="jsgl">
					  <h1>角色管理</h1>
            	</div>                     	
			</div>
			<!-- 修改员工信息弹框 -->
			<div class="branch" id="branch">
				<form action="updateuser.html" method="post">
					<div class="secondary">
						<div class="wordtree">
							<label>员工编号：</label><br>
							<div class="input">
								<input id="input0" readonly="readonly" class="userid" autocomplete='off' type="text" name="userId" placeholder="员工编号"/><br>
							</div>
						</div>
						<div class="wordtree">
							<label>员工姓名：</label><br>
							<div class="input">
								<input id="input1" class="name" autocomplete='off' type="text" name="name" placeholder="员工姓名"/><br>
							</div>
						</div>
						<div class="wordtree">
							<label>员工年龄：</label><br>
							<div class="input">
								<input id="input2" class="age" autocomplete='off' type="text" name="age" placeholder="员工年龄"/><br>
							</div>
						</div>
						<div class="wordtree">
							<label>员工电话：</label><br>
							<div class="input">
								<input id="input3" class="phone" autocomplete='off' type="text" name="phone" placeholder="员工电话"/><br>
							</div>
						</div>
						<div class="wordtree">
							<label>员工邮箱：</label><br>
							<div class="input">
								<input id="input4" class="email" autocomplete='off' type="text" name="email" placeholder="员工邮箱"/><br>
							</div>
						</div>
						<div class="foot">
							<button class="guanbi" type="button" onclick="gb()">关闭</button>
							<button class="xiugai" type="submit">修改</button>
						</div>
					</div>
				</form>
			</div>
			<!-- 添加员工信息弹框 -->
			<div class="branchs" id="branchs">
				<form action="adduser.html" method="post">
					<div class="secondary">
						<div class="wordtree">
							<label>员工姓名：</label><br>
							<div class="input">
								<input autocomplete='off' type="text" name="name" placeholder="员工姓名"/><br>
							</div>
						</div>
						<div class="wordtree">
							<label>员工年龄：</label><br>
							<div class="input">
								<input autocomplete='off' type="text" name="age" placeholder="员工年龄"/><br>
							</div>
						</div>
						<div class="wordtree">
							<label>员工电话：</label><br>
							<div class="input">
								<input autocomplete='off' type="text" name="phone" placeholder="员工电话"/><br>
							</div>
						</div>
						<div class="wordtree">
							<label>员工邮箱：</label><br>
							<div class="input">
								<input autocomplete='off' type="text" name="email" placeholder="员工邮箱"/><br>
							</div>
						</div>
						<div class="foot">
							<button class="guanbi" type="button" onclick="tjgb()">关闭</button>
							<button class="xiugai" type="submit">添加</button>
						</div>
					</div>
				</form>
			</div>
		</div>
</body>
</html>