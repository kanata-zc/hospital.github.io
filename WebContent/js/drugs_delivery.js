
$(function(){
	$("#patientId").click(selectPatient);
	$("#drugsId").click(selectDrugs);
	$(".clear").click(reset);
	$(".confirm").click(save);
});

//药品的查询弹窗
function selectDrugs(){
	var ok = $(".drugsDialog").Dialog("open");
}

$('.drugsDialog').Dialog({
	title:'选择药品',
	autoOpen:false,
	width:1000,
	height:400
});

function closeDrugs(){
	$('.drugsDialog').Dialog('close');
}
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
}
function save(){
	var addData = $("#drugs_delivery").serialize();
	$.ajax({
		url:"drugs/grantAdd.do",
		type:"post",
		data:addData,
		dataType:"JSON",
		success:function(result){
			alert("发放成功！");
			 window.location.reload();
		},
		error:function(result){
			alert("发放失败");
			 window.location.reload();
		}
	});
} 

function reset(){
	$("#drugs_delivery :input").val("");
}