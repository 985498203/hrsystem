$(document).ready(function(){
	$(".worderbranch").hide();
});
function fy(a){
	var pageNo;
	if(a == 1){
		pageNo = $("button[name='fy1']").val();
	}
	if(a == 2){
		pageNo = $("button[name='fy2']").val();
	}
	if(a == 3){
		pageNo = $("button[name='fy3']").val();
	}
	if(a == 4){
		pageNo = $("button[name='fy4']").val();
	}
	if(a == 5){
		pageNo = document.getElementById("pagenos").className;
	}
	$.ajax({
		url:"findworder.html",
		data:{"pageNo":pageNo},
		type:'post',
		dataType:"text",
		success:function(msg){
			$("#gdgd").html(msg);
		}
	});
};
function qx(obj){
	var alls = document.getElementsByName("all");
	var all = document.getElementById("all");
	var ahs = document.getElementsByName("ones");
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
function xs1(id){
	var worder = $("button[name='update"+id+"']").val().split(',');
	for(var i=0;i<worder.length;i++){
		$('#inputs'+i).val(worder[i]);
	}
	$(".worderbranch").show();
	$("#state").hide();
}

function gb1(){
	$(".worderbranch").hide();
}

function wxg(){
	var worderId = $("input[name='worderId']").val();
	var title = $("input[name='title']").val();
	var detail = $("input[name='detail']").val();
	var state = $("input[name='state']").val();
	$.ajax({
		url:'updateworder.html',
		data:{"worderId":worderId,"title":title,"detail":detail,"state":state},
		type:'post',
		dataType:"JSON",
		success:function(msg){
			if(msg.msg == 1){
				fy(5);
				alert("修改成功！");
			}
			if(msg.msg == 2){
				fy(5);
				alert("修改失败！");
			}
		}
	});
	$(".worderbranch").hide();
}
function del(){
	obj = document.getElementsByName("ones");
	check_val = [];
	for(k in obj){
		if(obj[k].checked)
			check_val.push(obj[k].value);
	}
	$.ajax({
		traditional:true,
		url:'delworder.html',
		data:{"one":check_val},
		type:'post',
		dataType:"JSON",
		success:function(msg){
			if(msg.msg == 1){
				fy(5);
				alert("删除成功！");
			}
			if(msg.msg == 2){
				fy(5);
				alert("删除失败！");
			}
		}
	});
}