$(function(){
	$("#save").click(save);
	//查询病房价格表
	$.ajax({
		url : 'category/categoryQuery.do',
		type : 'post',
		data : {
			"id" : ""
		},
		dataType : 'JSON',
		success : function(result) {
			if (result.state == 0) {
				var list = result.data;
				var $tbody = $("#show");
				$tbody.empty();
				$("#total").val(list.length+"");
				if (list.length > 0) {
					for (var i = 0; i < list.length; i++) {
						var category = list[i];
						var $tr = "<tr>"+
							"<td class='num'>"+(i+1)+"</td>"+
							"<td class='name'>"+category.type+"</td>"+
							"<td class='process'>"+category.name+"</td>"+
							"<td class='node'>"+category.price+"</td>"+
							"<td class='operate'><input type='text' name='updatePrice"+i+"'>"+
							"<input style='display:none;' type='text' name='id"+i+"' value='"+category.id+"'/></td>"+
							"<td class='operate'>"+category.updateTime+"</td>"+
							"</tr>";
						$tbody.append($tr);
					}
				}
			}
		}
	});
});


function save(){
	var categoryData = $("#updatePriceForm").serialize();
	//提交更改
	$.ajax({
		url : 'category/categoryUpdate.do',
		type : 'post',
		data : categoryData,
		dataType : 'JSON',
		success : function(result) {
			alert("调整成功！");
			window.location.reload();
		},
		error:function(result){
			alert("调整失败！");
			window.location.reload();
		}
	});
}
	