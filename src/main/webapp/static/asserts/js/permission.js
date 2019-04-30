$(function() {
	  // 计算页面的实际高度，iframe自适应会用到
	  function calcPageHeight(doc) {
	      var cHeight = Math.max(doc.body.clientHeight, doc.documentElement.clientHeight)
	      var sHeight = Math.max(doc.body.scrollHeight, doc.documentElement.scrollHeight)
	      var height  = Math.max(cHeight, sHeight)
	      return height
	  }
	  
	  
	  
	  //根据ID获取iframe对象
	  var ifr = document.getElementById('qxgliframe')
	  ifr.onload = function() {
	  	  //解决打开高度太高的页面后再打开高度较小页面滚动条不收缩
	  	  ifr.style.height='0px';
	      var iDoc = ifr.contentDocument || ifr.document
	      var height = calcPageHeight(iDoc)
	      if(height < 500){
	      	height = 500;
	      }
	      ifr.style.height = height + 'px';
	  }
	  
	  function wind(){
		  //根据ID获取iframe对象
		  var ifr = document.getElementById('qxgliframe')
		  ifr.onload = function() {
		  	  //解决打开高度太高的页面后再打开高度较小页面滚动条不收缩
		  	  ifr.style.height='0px';
		      var iDoc = ifr.contentDocument || ifr.document
		      var height = calcPageHeight(iDoc)
		      if(height < 850){
		      	height = 850;
		      }
		      ifr.style.height = height + 'px'
		  }
		  
	  }
	  
	  
	  
	  
		$("#jsgl").click(function() {
			$('#qxgliframe').show();
			$('#qxgliframe').attr('src','roles');
		});
		$("#qxgl").click(function() {
			$('#qxgliframe').show();
			$('#qxgliframe').attr('src','perms');
		});
		$("#zpgl").click(function() {
			$('#qxgliframe').show();
			$('#qxgliframe').attr('src','recruitInfo');
		});
		
		
		
	 //切换
	
	 
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
