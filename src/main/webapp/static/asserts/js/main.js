$(document).ready(function(){
	$(".zhaoping").hide();
	$(".gongdan").show();
	$(".ygxx").hide();
	$(".yhgl").hide();
	$(".qxgl").hide();
	$(".jsgl").hide();
	$(".kaoqin").hide();
});
function update(){
    $("#myModal").modal();
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
