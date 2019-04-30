$(document).ready(function(){
	$(".worderbranch").hide();
	$(".branch").hide();
	$(".branchs").hide();
});

function fys(a){
	var pageNo;
	if(a == 1){
		pageNo = $("button[name='fys1']").val();
	}
	if(a == 2){
		pageNo = $("button[name='fys2']").val();
	}
	if(a == 3){
		pageNo = $("button[name='fys3']").val();
	}
	if(a == 4){
		pageNo = $("button[name='fys4']").val();
	}
	if(a == 5){
		pageNo = document.getElementById("pagenoss").className;
	}
	$.ajax({
		url:"finduser.html",
		data:{"pageNo":pageNo},
		type:'post',
		dataType:"text",
		success:function(msgs){
			$("#ygyg").html(msgs);
		}
	});
};

function dels(){
	obj = document.getElementsByName("on");
	check_val = [];
	for(k in obj){
		if(obj[k].checked)
			check_val.push(obj[k].value);
	}
	$.ajax({
		traditional:true,
		url:'deluser.html',
		data:{"one":check_val},
		type:'post',
		dataType:"JSON",
		success:function(msgs){
			if(msgs.msgs == 1){
				fys(5);
				alert("删除成功！");
			}
			if(msgs.msgs == 2){
				fys(5);
				alert("删除失败！");
			}
		}
	});
};

function qx(obj){
	var alls = document.getElementsByName("alls");
	var all = document.getElementById("alls");
	var ahs = document.getElementsByName("on");
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
};

function xs2(id){
	var user = $("button[name='update"+id+"']").val().split(',');
	for(var i=0;i<user.length;i++){
		$('#input'+i).val(user[i]);
	};
    $(".branch").show();
};

function gb(){
	$(".branch").hide();
};

function tjs(){
	$(".branchs").show();
};

function tjgb(){
	$(".branchs").hide();
};

function tongzhis(obj){
	var emails = $("button[name='tongzhi"+obj+"']").val().split(',');//获取收件人Email和员工姓名
	var email = emails[0];
	var name = emails[1];
	$.ajax({
		url:"tongzhi.html",
		data:{"email":email,"name":name},
		type:'post',
		dataType:"JSON",
		success:function(msg){
			if(msg.msg == 1){
				alert("发送成功！");
			}
			if(msg.msg == 2){
				alert("发送失败!");
			}
		}
	});
};

function uxg(){
	var userId = $("input[name='userId']").val();
	var name = $("input[name='name']").val();
	var age = $("input[name='age']").val();
	var phone = $("input[name='phone']").val();
	var email = $("input[name='email']").val();
	$.ajax({
		url:'updateuser.html',
		data:{"userId":userId,"name":name,"age":age,"phone":phone,"email":email},
		type:'post',
		dataType:"JSON",
		success:function(msgs){
			if(msgs.msgs == 1){
				fys(5);
				alert("修改成功！");
			}
			if(msgs.msgs == 2){
				fys(5);
				alert("修改失败！");
			}
		}
	});
	$(".branch").hide();
};

function utj(){
	var name = $("input[name='names']").val();
	var age = $("input[name='ages']").val();
	var phone = $("input[name='phones']").val();
	var email = $("input[name='emails']").val();
	$.ajax({
		url:'adduser.html',
		type:'post',
		data:{"name":name,"age":age,"phone":phone,"email":email},
		dataType:"JSON",
		success:function(msg){
			if(msg.msgs == 1){
				fys(5);
				alert("添加成功!");
			}
			if(msg.msgs == 2){
				fys(5);
				alert("添加失败!");
			}
		}
	});
	$(".branchs").hide();
};