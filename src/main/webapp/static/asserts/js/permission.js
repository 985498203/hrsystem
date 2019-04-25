$(function() {
	// 单击 a 链接，加载 a.html
	$("#qxgl").click(function() {
		$.ajax({
			type : 'GET',
			url : 'perm/list.html',
			dataType : 'html',
			success : function(data) {
				console.log("成功");
				$('#qxglpage').html(data);
			}
		});
	});
	// function permqx(obj) {
	// var qx = $("#permtable #permqx");// 获取permtable下的全选框
	// var xz = $("#permtable .permxz");// 获取permtable
	//			
	// var alls = document.getElementsByName("permqx");
	// var all = document.getElementById("all");
	// var ahs = document.getElementsByName("permxz");
	// if (obj == 1) {
	// if (qx.checked == true) {
	// for (var i = 0; i < ahs.length; i++) {
	// ahs[i].checked = true;
	// }
	// } else {
	// for (var i = 0; i < ahs.length; i++) {
	// ahs[i].checked = false;
	// }
	// }
	// } else {
	//				
	// }
	//
	// }
	// 单击 b 链接，加载 b.html
	/*
	 * $("#a2").click(function(){ $('#con').load('./b.html'); });
	 */

});
