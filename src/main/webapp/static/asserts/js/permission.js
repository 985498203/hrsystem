$(function() {

	// 单击 a 链接，加载 a.html
	$("#qxgl").click(function() {
		//$('#qxglpage').load('a.html');
		// 单击 a 链接，加载 a.html
		$.ajax({
			type : 'GET',
			url : 'permission/list.html',
			dataType: 'html',
			success : function(data) {
				console.log("成功");
			}
		});

	});
	// 单击 b 链接，加载 b.html
	/*
	 * $("#a2").click(function(){ $('#con').load('./b.html'); });
	 */

});
