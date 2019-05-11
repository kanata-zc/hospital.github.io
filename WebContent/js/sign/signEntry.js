//病人体征数据录入js
$(function(){
	$("#patientId").click(selectPatient);
	$(".clear").click(clear);
	$(".confirm").click(save);
});

//保存按钮
function save(){
	var saveData = $("#signEntry").serialize();
	$.ajax({
		url:"sign/signSave.do",
		data:saveData,
		type:"POST"
	});
	alert("录入成功！");
	window.location.reload();
}

//病人查询
function selectPatient(){
	var ok = $('.patientQuery').Dialog("open");
}
 
$('.patientQuery').Dialog({
	title:'选择病人',
	autoOpen: false,
	width:1000,
	height:400
});

function close(){
	$('.patientQuery').Dialog('close');
}

//重置按钮
function clear(){
	$("#signEntry :input").val("");
}
 