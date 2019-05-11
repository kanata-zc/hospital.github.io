/*
 * edit.js
 */
//定义一个数据模型
var model = {
	notebooks:[],
	notes:[],
	updateNotebooks:function(notebooks){
		this.notebooks = notebooks;
		this.updateNotebooksView();
	},
	updateNotebooksView:function(){
		 var view = $('#notebooks_view');
		 view.empty();
		/* <li class="online">
			<a class="checked">
			<i class="fa fa-book" title="online" rel="tooltip-bottom">
			</i> 默认笔记本</a></li>
		 */
		 for(var i=0;i<this.notebooks.length;i++){
			 var book = this.notebooks[i];
			 var li = $('<li class="online"></li>');
			 var a = $('<a></a>');
			 var ico = $('<i class="fa fa-book" title="online" rel="tooltip-bottom"></i>');
			 li.append(a.append(ico).append(book.name));
			 view.append(li);
			 //利用Jquer数据绑定传递数据
			 a.data('index',i);
			 a.click(function(){
				 $('#notebooks_view a').removeClass('checked');
				 $(this).addClass("checked");
				 var index = $(this).data('index');
				 var notebook = model.notebooks[index];
				 //获取当前笔记本
				 model.currentNotebook = notebook
				 listNotesAction();
				 return false;
			 });
		 }
	},
	updateNotes:function(notes){
		this.notes = notes;
		this.updateNotesView();
	},
	updateNotesView:function(){
		var views = $("#note_view");
		console.log(views);
		views.empty();
		for(var i=0;i<this.notes.length;i++){
			var li = $('<li class="online"></li>');
			var a = $('<a></a>');
			var ioc = $('<i class="fa fa-file-text-o" title="online" rel="tooltip-bottom"></i>');
			var medu=$('<button type="button" class="btn btn-default btn-xs btn_position btn_slide_down"><i class="fa fa-chevron-down"></i></button>');
			var menu =$('<div class="note_menu" tabindex="-1">'+
					'<dl>'+
						'<dt><button type="button" class="btn btn-default btn-xs btn_move" title="移动至..."><i class="fa fa-random"></i></button></dt>'+
						'<dt><button type="button" class="btn btn-default btn-xs btn_share" title="分享"><i class="fa fa-sitemap"></i></button></dt>'+
						'<dt><button type="button" class="btn btn-default btn-xs btn_delete" title="删除"><i class="fa fa-times"></i></button></dt>'+
					'</dl>'+
				'</div>');
			a.data('index',i);
			li.append(a.append(ioc).append(this.notes[i].title).append(medu)).append(menu);
			views.append(li);
			//绑定显示笔记详细信息事件
			a.click(function(){
				$('#note_view a').removeClass("checked");
				$(this).addClass("checked");
				//console.log("click");
				var index =$(this).data('index');
				//点击鼠标获取的笔记信息
				var note = model.notes[index];
				model.currentNoteIndex = index;
				showNoteAction();
				//阻止事件冒泡的传播
				return false;
			});
		}
	}
};
function showNoteAction(){
	var index = model.currentNoteIndex;
	var noteId = model.notes[index].id;
	console.log("id:"+noteId);
	var url="note/load.do";
	var data = {noteId:noteId};
	$.getJSON(url,data,function(result){
		if(result.state==0){
			var note = result.data;
			var um = UM.getEditor("myEditor");
			um.setContent(note.body);
		}else{
			alert(result.message);
		}
	})
}
$(function(){
	//var userId = getCookie(USER_ID);
	//console.log(userId);
	listNotebooksAction();
	$('#add_note').click(addNote);
	console.log($('#add_note'));
});
function addNote(){
	console.log("hello word!");
}
function listNotesAction(){
	//console.log("listNotesAction()");
	var url = "note/list.do";
	var data = {notebookId:model.currentNotebook.id};
	$.getJSON(url,data,function(result){
		if(result.state==SUCCESS){
			//console.log(result.data); 		
			model.updateNotes(result.data);
		}else{
			alert(result.message);
		}
	})
}

function listNotebooksAction(){
	var userId = getCookie(USER_ID);
	var url = "notebook/list.do";
	var data = {'userId':userId};
	$.getJSON(url,data,function(result){
		if(result.state==SUCCESS){
			var list = result.data;
			model.updateNotebooks(list);
		}
	});
}