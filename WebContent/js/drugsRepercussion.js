$(function(){
	$(".confirm").click(save);
	$(".clear").click(reset);
	$("#patientId").click(selectPatient);
});

//病人的查询弹窗
function selectPatient(){
	var ok = $('.exitDialog').Dialog("open");
}

$('.exitDialog').Dialog({
	title:'选择病人',
	autoOpen: false,
	width:1000,
	height:400
});

function close(){
	$('.exitDialog').Dialog('close');
	//关闭弹窗后增加下拉列表的数据
	var patientId = $("#patientId").val();
	$.ajax({
		url:"drugs/grantQuery.do",
		type:"post",
		data:{"patientId":patientId},
		dataType:"JSON",
		success:function(result){
			if(result.state==0){
				var list = result.data;
				console.log("list:"+list);
				var $datalist = $("#drugsList");
				$datalist.empty();
				if(list.length>0){
					for(var i=0;i<list.length;i++){
						var stock = list[i];
						var $li = "<option value='"+stock.drugsId+"'>"+stock.drugsName+"</option>";
						$datalist.append($li);
					}
				}
			}
		},
		error:function(result){
			alert("no");
		}
	});
}

//保存退药信息
function save(){
	var patientId = $("#patientId").val();
	var patientName = $("#patientName").val();
	var drugsId = $("#durgsName").val(); 
	var count = $("#count").val();
	var reason = $("#repercussion").val();
	
	$.ajax({
		url:"drugs/DrugWithdrawal.do",
		type:"POST",
		data:{"patientId":patientId,"patientName":patientName,"drugsId":drugsId,"count":count,"reason":reason},
		success:function(){
			alert("退药成功！");
			window.location.reload();
		},
		error:function(){
			alert("退药失败！");
		}
	}); 
	 
}

function reset(){
	$("#drugsRepercussion :input").val("");
}
