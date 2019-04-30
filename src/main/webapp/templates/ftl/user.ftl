<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<#setting number_format="#">
<title>Insert title here</title>
	  <script type="text/javascript" src="static/asserts/js/jquery.min.js"></script>
	  <script type="text/javascript" src="static/asserts/js/jquery-3.2.1.min.js"></script>
	  <script type="text/javascript" src="static/asserts/js/bootstrap.min.js"></script>
   	  <script type="text/javascript" src="static/asserts/js/user.js"></script>
   	  <link rel="stylesheet" type="text/css" href="static/asserts/css/bootstrap.min.css" />
      <link rel="stylesheet" type="text/css" href="static/asserts/css/bootstrap-theme.min.css">
      <link rel="stylesheet" type="text/css" href="static/asserts/css/index.css">
      <link rel="stylesheet" type="text/css" href="static/asserts/css/common.css" />
      <link rel="stylesheet" type="text/css" href="static/asserts/css/slide.css" />
      <link rel="stylesheet" type="text/css" href="static/asserts/css/flat-ui.min.css" />
      <link rel="stylesheet" type="text/css" href="static/asserts/css/jquery.nouislider.css">
	  <style type="text/css">
	  	::-webkit-scrollbar{
	  		display:none;
	  	}
	  </style>
</head>
<body>
	<div id="ygyg">
        <div>
            <form action="deluser.html" method="post">
				<table class="table">
					<tr>
						<th>全选<br/><input type="checkbox" id="alls" name="alls" onclick="qx(1);"/></th>
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
										<button id="delete" type="button" onclick="dels()">删除</button>
									</p>
									<hr>
									<p>
										<button id="update" type="button" onclick="tjs()">添加</button>
									</p>
								</div>
							</div>
						</th>
					</tr>
					<#if list??>
						<#list list as u>
							<tr>
								<td><input type="checkbox" id="on" value="${u.userId}" name="on" onclick="qx(2);"/></td>
								<td>${u.userId}</td>
								<td>${u.name}</td>
								<td>${u.age}</td>
								<td>${u.phone}</td>
								<td>${u.email}</td>
								<td style="text-align:left;">
									<button id="update" value="${u.userId},${u.name},${u.age},${u.phone},${u.email}" type="button" name="update${u.userId}" style="border:0px;background-color:#eff3f6;color:green;" onclick="xs2(${u.userId})">修改</button>
									<button id="tongzhi" value="${u.email},${u.name}" type="button" name="tongzhi${u.userId}" style="border:0px;background-color:#eff3f6;color:green;" onclick="tongzhis(${u.userId})">通知</button>
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
					<li><button value="1" type="button" name="fys1" onclick="fys(1)" style="border:0px;background-color:#eff3f6;color:green;">首页</button></li>
					<li>|</li>
					<li><button id="pagenoss" class="${dno}" value="<#if dno-1 gt 1>${dno-1}<#else>1</#if>" onclick="fys(2)" type="button" name="fys2" style="border:0px;background-color:#eff3f6;color:green;">上一页</button></li>
					<li>|</li>
					<li><button value="<#if dno+1 gt pageNo>${pageNo}<#else>${dno+1}</#if>" onclick="fys(3)" type="button" name="fys3" style="border:0px;background-color:#eff3f6;color:green;">下一页</button></li>
					<li>|</li>
					<li><button value="${pageNo}" type="button" name="fys4" onclick="fys(4)" style="border:0px;background-color:#eff3f6;color:green;">尾页</button></li>
				</ul>
			</div>
		</#if>
	<!-- 修改员工信息弹框 -->
	<div class="branch" id="branch" style="display:none;">
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
					<button class="xiugai" type="button" onclick="uxg()">修改</button>
				</div>
			</div>
		</form>
	</div>
	<!-- 添加员工信息弹框 -->
	<div class="branchs" id="branchs" style="display:none;">
		<form action="adduser.html" method="post">
			<div class="secondary">
				<div class="wordtree">
					<label>员工姓名：</label><br>
					<div class="input">
						<input required="required" autocomplete='off' type="text" name="names" placeholder="请输入姓名"/><br>
					</div>
				</div>
				<div class="wordtree">
					<label>员工年龄：</label><br>
					<div class="input">
						<input required="required" autocomplete='off' type="text" name="ages" placeholder="请输入年龄"/><br>
					</div>
				</div>
				<div class="wordtree">
					<label>员工电话：</label><br>
					<div class="input">
						<input required="required" id="phones" pattern="(\d{11})|^((\d{7,8})|(\d{4}|\d{3})-(\d{7,8})|(\d{4}|\d{3})-(\d{7,8})-(\d{4}|\d{3}|\d{2}|\d{1})|(\d{7,8})-(\d{4}|\d{3}|\d{2}|\d{1}))$" autocomplete='off' type="text" name="phones" placeholder="请输入电话"/><br>
					</div>
				</div>
				<div class="wordtree">
					<label>员工邮箱：</label><br>
					<div class="input">
						<input required="required" id="emails" autocomplete='off' pattern="^[a-zA-Z][0-9a-zA-Z]*@{1}[0-9a-zA-Z]+\.(com|net|cn|com\.cn)$" type="text" name="emails" placeholder="请输入邮箱"/><br>
					</div>
				</div>
				<div class="foot">
					<button class="guanbi" type="button" onclick="tjgb()">关闭</button>
					<button class="xiugai" type="button" onclick="utj()">添加</button>
				</div>
			</div>
		</form>
	</div>
	</div>
</body>
</html>