<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<#setting number_format="#">
<title>Insert title here</title>
	  <script type="text/javascript" src="static/asserts/js/jquery.min.js"></script>
	  <script type="text/javascript" src="static/asserts/js/jquery-3.2.1.min.js"></script>
	  <script type="text/javascript" src="static/asserts/js/bootstrap.min.js"></script>
   	  <script type="text/javascript" src="static/asserts/js/gongdan.js"></script>
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
	<div id="gdgd">
	<#if worderlist??>
		<div>
			<form action="delworder.html" method="post">
				<table class="table">
					<tr>
						<th>全选<br/><input type="checkbox" id="all" name="all" onclick="qx(1);"/></th>
						<th>工单编号</th>
						<th>工单标题</th>
						<th>工单详情</th>
						<th>工单状态</th>
						<th>员工编号</th>
						<th class="th">
							<div class="dropdowns">
								<span>操作</span><b class="caret"></b>
								<div class="dropdown-contents">
									<p>
										<button id="delete" type="button" onclick="del()">删除</button>
									</p>
								</div>
							</div>
						</th>
					</tr>
					<#if worderlist??>
						<#list worderlist as w>
							<tr>
								<td><input type="checkbox" id="ones" value="${w.worderId}" name="ones" onclick="qx(2);"/></td>
								<td>${w.worderId}</td>
								<td>${w.title}</td>
								<td>${w.detail}</td>
								<td>
									<#if w.state == "0">正在审核<#elseif w.state == "1">主管审核<#elseif w.state == "2">领导审核</#if>
								</td>
								<td>${w.user.userId}</td>
								<td style="text-align:left;">
									<button id="update" value="${w.worderId},${w.title},${w.detail},${w.state}" type="button" name="update${w.worderId}" style="border:0px;background-color:#eff3f6;color:green;" onclick="xs1(${w.worderId})">修改</button>
								</td>
							</tr>
						</#list>
					</#if>
				</table>
			</form>
		</div>
		<#if worderlist??>
			<div id="page">
				<ul class="pagers">
					<li><button value="1" type="button" name="fy1" onclick="fy(1)" style="border:0px;background-color:#eff3f6;color:green;">首页</button></li>
					<li>|</li>
					<li><button id="pagenos" class="${dno}" value="<#if dno-1 gt 1>${dno-1}<#else>1</#if>" onclick="fy(2)" type="button" name="fy2" style="border:0px;background-color:#eff3f6;color:green;">上一页</button></li>
					<li>|</li>
					<li><button value="<#if dno+1 gt worderPageNo>${worderPageNo}<#else>${dno+1}</#if>" onclick="fy(3)" type="button" name="fy3" style="border:0px;background-color:#eff3f6;color:green;">下一页</button></li>
					<li>|</li>
					<li><button value="${worderPageNo}" type="button" name="fy4" onclick="fy(4)" style="border:0px;background-color:#eff3f6;color:green;">尾页</button></li>
				</ul>
			</div>
		</#if>
	</#if>
	<div class="worderbranch" id="worderbranch" style="display:none;">
		<form action="updateworder.html" method="post">
			<div class="secondary">
				<div class="wordtree">
					<label>工单编号：</label><br>
					<div class="input">
						<input id="inputs0" readonly="readonly" class="worderId" autocomplete='off' type="text" name="worderId" placeholder="员工编号"/><br>
					</div>
				</div>
				<div class="wordtree">
					<label>工单标题：</label><br>
					<div class="input">
						<input id="inputs1" class="title" autocomplete='off' type="text" name="title" placeholder="员工姓名"/><br>
					</div>
				</div>
				<div class="wordtree">
					<label>工单详情：</label><br>
					<div class="input">
						<input id="inputs2" class="detail" autocomplete='off' type="text" name="detail" placeholder="员工年龄"/><br>
					</div>
				</div>
				<div class="wordtree" id="state">
					<label>工单状态：</label><br>
					<div class="input">
						<input id="inputs3" class="state" autocomplete='off' type="text" name="state" placeholder="工单状态"/><br>
					</div>
				</div>
				<div class="foot">
					<button class="guanbi" type="button" onclick="gb1()">关闭</button>
					<button class="xiugai" type="button" onclick="wxg()">修改</button>
				</div>
			</div>
		</form>
	</div>
	<div>
</body>
</html>