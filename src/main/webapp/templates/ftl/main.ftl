<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<meta name="format-detection" content="telephone=no">
<title>人力资源系统</title>
   		<link rel="stylesheet" type="text/css" href="static/asserts/css/bootstrap.min.css" />
   		<link rel="stylesheet" type="text/css" href="static/asserts/css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="static/asserts/css/bootstrap-theme.min.css">
        <link rel="stylesheet" type="text/css" href="static/asserts/css/common.css" />
        <link rel="stylesheet" type="text/css" href="static/asserts/css/slide.css" />
        <link rel="stylesheet" type="text/css" href="static/asserts/css/flat-ui.min.css" />
        <link rel="stylesheet" type="text/css" href="static/asserts/css/jquery.nouislider.css">
		<script type="text/javascript" src="static/asserts/js/jquery.min.js"></script>
		<script type="text/javascript" src="static/asserts/js/jquery-3.2.1.min.js"></script>
		<script type="text/javascript" src="static/asserts/js/bootstrap.min.js"></script>

		<script type="text/javascript" src="static/asserts/js/main.js"></script>
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
					  <table class="table">
					 	<tr>
							<th>全选<br/><input id="all" type="checkbox"/></th>
							<th>员工编号</th>
							<th>员工姓名</th>
							<th>员工年龄</th>
							<th>部门名称</th>
							<th>职位名称</th>
							<th>
								<ul class="nav nav-pills" style="padding-top: 0px;margin-top: 0px;">
								  <li class="dropdown">
								      <a class="dropdown-toggle" data-toggle="dropdown" href="#">操作</a>
								      <ul class="dropdown-menu">
								     	  <li role="presentation"><strong>添加</strong></li>
								      </ul>  
								  </li>
								</ul>
							</th>
						</tr>
							<tr>
								<td><input id="one" type="checkbox"/></td>
								<td>10001</td>
								<td>张三</td>
								<td>39</td>
								<td>财务部</td>
								<td>财务经理</td>
								<td>
									<button id="btn_update" class="btn btn-success btn-xs" data-toggle="modal" data-target="#changeSource" onclick="update()">修改</button>
                                    <button class="btn btn-danger btn-xs" data-toggle="modal" data-target="#deleteSource">删除</button>
								</td>
							</tr>
				  	  </table>
            	</div>
            	<!-- 员工信息模块 -->
            	<div class="ygxx">
            		  <h1>员工信息</h1>
					  <table class="table">
					 	<tr>
							<th>全选<br/><input id="all" type="checkbox"/></th>
							<th>员工编号</th>
							<th>员工姓名</th>
							<th>员工年龄</th>
							<th>部门名称</th>
							<th>职位名称</th>
							<th>
								<ul class="nav nav-pills" style="padding-top: 0px;margin-top: 0px;">
								  <li class="dropdown">
								      <a class="dropdown-toggle" data-toggle="dropdown" href="#">操作</a>
								      <ul class="dropdown-menu">
								     	  <li role="presentation"><strong>添加</strong></li>
								      </ul>  
								  </li>
								</ul>
							</th>
						</tr>
							<tr>
								<td><input id="one" type="checkbox"/></td>
								<td>10001</td>
								<td>张三</td>
								<td>39</td>
								<td>财务部</td>
								<td>财务经理</td>
								<td>
									<button id="btn_update" class="btn btn-success btn-xs" data-toggle="modal" data-target="#changeSource" onclick="update()">修改</button>
                                    <button class="btn btn-danger btn-xs" data-toggle="modal" data-target="#deleteSource">删除</button>
								</td>
							</tr>
				  	  </table>
            	</div>
            	<!-- 招聘模块 -->
            	<div class="zhaoping">
            		  <h1>招聘</h1>
					  <table class="table">
					 	<tr>
							<th>全选<br/><input id="all" type="checkbox"/></th>
							<th>员工编号</th>
							<th>员工姓名</th>
							<th>员工年龄</th>
							<th>部门名称</th>
							<th>职位名称</th>
							 <th>
								<ul class="nav nav-pills" style="padding-top: 0px;margin-top: 0px;">
								  <li class="dropdown">
								      <a class="dropdown-toggle" data-toggle="dropdown" href="#">操作</a>
								      <ul class="dropdown-menu">
								     	  <li role="presentation"><strong>添加</strong></li>
								      </ul>  
								  </li>
								</ul>
							</th>
						</tr>
							<tr>
								<td><input id="one" type="checkbox"/></td>
								<td>10001</td>
								<td>张三</td>
								<td>39</td>
								<td>财务部</td>
								<td>财务经理</td>
								<td>
									<button id="btn_update" class="btn btn-success btn-xs" data-toggle="modal" data-target="#changeSource" onclick="update()">修改</button>
                                    <button class="btn btn-danger btn-xs" data-toggle="modal" data-target="#deleteSource">删除</button>
								</td>
							</tr>
				  	  </table>
            	</div> 
            	<!-- 考勤模块 -->
				<div class="kaoqin">
					  <h1>考勤</h1>
					  <table class="table">
					 	<tr>
							<th>全选<br/><input id="all" type="checkbox"/></th>
							<th>员工编号</th>
							<th>员工姓名</th>
							<th>员工年龄</th>
							<th>部门名称</th>
							<th>职位名称</th>
							 <th>
								<ul class="nav nav-pills" style="padding-top: 0px;margin-top: 0px;">
								  <li class="dropdown">
								      <a class="dropdown-toggle" data-toggle="dropdown" href="#">操作</a>
								      <ul class="dropdown-menu">
								     	  <li role="presentation"><strong>添加</strong></li>
								      </ul>  
								  </li>
								</ul>
							</th>
						</tr>
							<tr>
								<td><input id="one" type="checkbox"/></td>
								<td>10001</td>
								<td>张三</td>
								<td>39</td>
								<td>财务部</td>
								<td>财务经理</td>
								<td>
									<button id="btn_update" class="btn btn-success btn-xs" data-toggle="modal" data-target="#changeSource" onclick="update()">修改</button>
                                    <button class="btn btn-danger btn-xs" data-toggle="modal" data-target="#deleteSource">删除</button>
								</td>
							</tr>
				  	  </table>
            	</div>    
            	<!-- 用户管理模块 -->
				<div class="yhgl">
					  <h1>用户管理</h1>
					  <table class="table">
					 	<tr>
							<th>全选<br/><input id="all" type="checkbox"/></th>
							<th>员工编号</th>
							<th>员工姓名</th>
							<th>员工年龄</th>
							<th>部门名称</th>
							<th>职位名称</th>
							 <th>
								<ul class="nav nav-pills" style="padding-top: 0px;margin-top: 0px;">
								  <li class="dropdown">
								      <a class="dropdown-toggle" data-toggle="dropdown" href="#">操作</a>
								      <ul class="dropdown-menu">
								     	  <li role="presentation"><strong>添加</strong></li>
								      </ul>  
								  </li>
								</ul>
							</th>
						</tr>
							<tr>
								<td><input id="one" type="checkbox"/></td>
								<td>10001</td>
								<td>张三</td>
								<td>39</td>
								<td>财务部</td>
								<td>财务经理</td>
								<td>
									<button id="btn_update" class="btn btn-success btn-xs" data-toggle="modal" data-target="#changeSource" onclick="update()">修改</button>
                                    <button class="btn btn-danger btn-xs" data-toggle="modal" data-target="#deleteSource">删除</button>
								</td>
							</tr>
				  	  </table>
            	</div>   
            	<!-- 权限管理模块 -->
				<div class="qxgl">
					  <h1>权限管理</h1>
					  <table class="table">
					 	<tr>
							<th>全选<br/><input id="all" type="checkbox"/></th>
							<th>员工编号</th>
							<th>员工姓名</th>
							<th>员工年龄</th>
							<th>部门名称</th>
							<th>职位名称</th>
							 <th>
								<ul class="nav nav-pills" style="padding-top: 0px;margin-top: 0px;">
								  <li class="dropdown">
								      <a class="dropdown-toggle" data-toggle="dropdown" href="#">操作</a>
								      <ul class="dropdown-menu">
								     	  <li role="presentation"><strong>添加</strong></li>
								      </ul>  
								  </li>
								</ul>
							</th>
						</tr>
							<tr>
								<td><input id="one" type="checkbox"/></td>
								<td>10001</td>
								<td>张三</td>
								<td>39</td>
								<td>财务部</td>
								<td>财务经理</td>
								<td>
									<button id="btn_update" class="btn btn-success btn-xs" data-toggle="modal" data-target="#changeSource" onclick="update()">修改</button>
                                    <button class="btn btn-danger btn-xs" data-toggle="modal" data-target="#deleteSource">删除</button>
								</td>
							</tr>
				  	  </table>
            	</div> 
            	<!-- 角色管理模块 -->
				<div class="jsgl">
					  <h1>角色管理</h1>
					  <table class="table">
					 	<tr>
							<th>全选<br/><input id="all" type="checkbox"/></th>
							<th>员工编号</th>
							<th>员工姓名</th>
							<th>员工年龄</th>
							<th>部门名称</th>
							<th>职位名称</th>
							 <th>
								<ul class="nav nav-pills" style="padding-top: 0px;margin-top: 0px;">
								  <li class="dropdown">
								      <a class="dropdown-toggle" data-toggle="dropdown" href="#">操作</a>
								      <ul class="dropdown-menu">
								     	  <li role="presentation"><strong>添加</strong></li>
								      </ul>  
								  </li>
								</ul>
							</th>
						</tr>
							<tr>
								<td><input id="one" type="checkbox"/></td>
								<td>10001</td>
								<td>张三</td>
								<td>39</td>
								<td>财务部</td>
								<td>财务经理</td>
								<td>
									<button id="btn_update" class="btn btn-success btn-xs" data-toggle="modal" data-target="#changeSource" onclick="update()">修改</button>
                                    <button class="btn btn-danger btn-xs" data-toggle="modal" data-target="#deleteSource">删除</button>
								</td>
							</tr>
				  	  </table>
            	</div>                     	
			</div>
		</div>
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
        <div class="modal-dialog" role="document">
        <form action="admin.jsp" method="post">
            <div class="modal-content">
                <div class="modal-header">
                    <h4 class="modal-title" id="myModalLabel">修改员工信息</h4>
                	 <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                </div>
                <div class="modal-body">
                    <div class="form-group">
                        <label for="txt_departmentname">员工编号</label>
                        <input type="text" name="txt_departmentname" class="form-control" id="txt_departmentname" placeholder="员工编号">
                    </div>
                    <div class="form-group">
                        <label for="txt_parentdepartment">员工姓名</label>
                        <input type="text" name="txt_parentdepartment" class="form-control" id="txt_parentdepartment" placeholder="员工姓名">
                    </div>
                    <div class="form-group">
                        <label for="txt_departmentlevel">员工年龄</label>
                        <input type="text" name="txt_departmentlevel" class="form-control" id="txt_departmentlevel" placeholder="员工年龄">
                    </div>
                    <div class="form-group">
                        <label for="txt_parentdepartment">部门名称</label>
                        <input type="text" name="txt_parentdepartment" class="form-control" id="txt_parentdepartment" placeholder="部门名称">
                    </div>
                    <div class="form-group">
                        <label for="txt_departmentlevel">职位名称</label>
                        <input type="text" name="txt_departmentlevel" class="form-control" id="txt_departmentlevel" placeholder="职位名称">
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="reset"  style="color: black;">重置</button>
                    <button type="submit" style="color: black;">保存</button>
                </div>
            </div>
            </form>
        </div>
    </div>
</body>
</html>