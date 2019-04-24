$(document).ready(function(){
	$(".zhaoping").hide();
	$(".gongdan").hide();
	$(".ygxx").show();
	$(".yhgl").hide();
	$(".qxgl").hide();
	$(".jsgl").hide();
	$(".kaoqin").hide();
	$(".branch").hide();
	$(".branchs").hide();
});
function xs(id){
	var user = $("button[name='update"+id+"']").val().split(',');
	for(var i=0;i<user.length;i++){
		$('#input'+i).val(user[i]);
	};
    $(".branch").show();
};
function gb(){
	$(".branch").hide();
};
function tj(){
	$(".branchs").show();
};
function tjgb(){
	$(".branchs").hide();
};
function gongdan(){
	$(".yhgl").hide();
	$(".qxgl").hide();
	$(".jsgl").hide();
	$(".zhaoping").hide();
	$(".ygxx").hide();
	$(".kaoqin").hide();
	$(".gongdan").show();
};
function ygxx(){
	$(".zhaoping").hide();
	$(".gongdan").hide();
	$(".kaoqin").hide();
	$(".yhgl").hide();
	$(".qxgl").hide();
	$(".jsgl").hide();
	$(".ygxx").show();
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
function qx(obj){
	var alls = document.getElementsByName("all");
	var all = document.getElementById("all");
	var ahs = document.getElementsByName("one");
	if(obj == 1){
		if(all.checked == true){
			for(var i=0 ;i<ahs.length;i++){
				ahs[i].checked = true;
			}
		}else{
			for(var i=0 ;i<ahs.length;i++){
				ahs[i].checked = false;
			}
		}
		}else{
	}
}