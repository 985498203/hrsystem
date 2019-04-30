$(document).ready(function(){
	$(".zhaoping").hide();
	$(".gongdan").hide();
	$(".ygxx").hide();
	$(".yhgl").hide();
	$(".qxgl").hide();
	$(".jsgl").hide();
	$(".kaoqin").hide();
	$(".branch").hide();
	$(".branchs").hide();
});

function gongdan(){
	$(".yhgl").hide();
	$(".qxgl").hide();
	$(".jsgl").hide();
	$(".zhaoping").hide();
	$(".ygxx").hide();
	$(".kaoqin").hide();
	$(".gongdan").show();
	

	//$('#qxgliframe').attr('src','findworder.html?pageNo=1');
	//获得需要隐藏的iframe元素对象。
	var iframe = document.getElementById('qxgliframe') ;
	//设置属性为隐藏。
	iframe.style = "display:none";
	
	
	$.ajax({
		url:"findworder.html",
		data:{"pageNo":1},
		type:'get',
		dataType:"text",
		success:function(msg){
			$(".gongdan").html(msg);
		}
	});
	
	
};
function ygxx(){
	$(".zhaoping").hide();
	$(".gongdan").hide();
	$(".kaoqin").hide();
	$(".yhgl").hide();
	$(".qxgl").hide();
	$(".jsgl").hide();
	$(".ygxx").show();
	//$('#qxgliframe').attr('src','finduser.html?pageNo=1');
	//获得需要隐藏的iframe元素对象。
	var iframe = document.getElementById('qxgliframe') ;
	//设置属性为隐藏。
	iframe.style = "display:none";
	$.ajax({
		url:"finduser.html",
		data:{"pageNo":1},
		type:'get',
		dataType:"text",
		success:function(msgs){
			$(".ygxx").html(msgs);
		}
	});
};
function zhaoping(){
	$(".zhaoping").show();
	$(".gongdan").hide();
	$(".ygxx").hide();
	$(".kaoqin").hide();
	$(".yhgl").hide();
	$(".qxgl").hide();
	$(".jsgl").hide();
}
function kaoqin(){
	$(".zhaoping").hide();
	$(".gongdan").hide();
	$(".ygxx").hide();
	$(".yhgl").hide();
	$(".qxgl").hide();
	$(".jsgl").hide();
	$(".kaoqin").show();
}
function yhgl(){
	$(".zhaoping").hide();
	$(".gongdan").hide();
	$(".ygxx").hide();
	$(".yhgl").show();
	$(".qxgl").hide();
	$(".jsgl").hide();
	$(".kaoqin").hide();
}
function qxgl(){
	$(".zhaoping").hide();
	$(".gongdan").hide();
	$(".ygxx").hide();
	$(".yhgl").hide();
	$(".qxgl").show();
	$(".jsgl").hide();
	$(".kaoqin").hide();
}
function jsgl(){
	$(".zhaoping").hide();
	$(".gongdan").hide();
	$(".ygxx").hide();
	$(".yhgl").hide();
	$(".qxgl").hide();
	$(".jsgl").show();
	$(".kaoqin").hide();
}
