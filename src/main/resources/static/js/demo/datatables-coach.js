// Call the dataTables jQuery plugin
$(document).ready(function() {
  var table = $('#dataTable').DataTable({
	  select: {
		  style:"single"
	  },
	  "searching" : true,
	  "bLengthChange": true,
	  "aLengthMenu": [5],
	  "oLanguage": {
		"sLengthMenu": "每页显示 _MENU_ 条记录",
		"sZeroRecords": "对不起，查询不到任何相关数据",
		"sInfo": "当前显示 _START_ 到 _END_ 条，共 _TOTAL_条记录",
		"sInfoEmtpy": "找不到相关数据",
		"sInfoFiltered": "数据表中共为 _MAX_ 条记录)",
		"sProcessing": "正在加载中...",
		"sSearch": "搜索",
		"oPaginate": {
		"sFirst": "第一页",
		"sPrevious":" 上一页 ",
		"sNext": " 下一页 ",
		"sLast": " 最后一页 "
		},
	  },
	  "processing": true,
	  "ajax":"coachsList",
	  "columns": [
		{
			"data": "coachname"
		},
		{
			"data": "coachsex"
		},
		{
			"data": "coachcardid"
		},
		{
			"data": "coachidcard"
		},
		{
			"data": "coachphone"
		},
		{
			"data": "coachlevel"
		},
		{
			"data": "coachyear"
		}
	],
	"order": [
		[1, 'asc']
	]
  });

  /*$('#dataTable tbody').on( 'click', 'tr', function () {
      if ( table.row( this, { selected: true }).any() ) {
		  //table.row( this ).deselect();
    	  //console.log( table.row( this ).data() );
	  }
	  else {
		  //table.row( this ).select();
	  }
  } );*/
  $("#membersEdit").click(function(){
	  if ( table.row({ selected: true }).any() ) {
		  $("#editName").val("");
		  $("#editSex").val("");
		  $("#editCardId").val("");
		  $("#editCard").val("");
		  $("#editPhone").val("");
		  $("#editLevel").val("");
		  $("#edityear").val("");
		  console.log(table.row( { selected: true } ).data());
		  var rdata = table.row( { selected: true } ).data();
		  $("#editId").val(rdata.id);
		  $("#editName").val(rdata.coachname);
		  $("#editSex").val(rdata.coachsex);
		  $("#editCardId").val(rdata.coachcardid);
		  $("#editIdCard").val(rdata.coachidcard);
		  $("#editPhone").val(rdata.coachphone);
		  $("#editLevel").val(rdata.coachlevel);
		  $("#edityear").val(rdata.coachyear);
		  $("#editModal").modal('show');
	  }
	  else {
		  $("#tableWarning").text("请先选择数据");
		  $('body').oneTime('3s',function(){
			  $("#tableWarning").text("");
		  });
	  }
  })
  $("#membersDel").click(function(){
	  if ( table.row({ selected: true }).any() ) {
		  $("#delModal").modal('show');
		  
		  $("#del").click(function(){
			  var rdata = table.row( { selected: true } ).data();
				$.ajax({
					url: "coachsDel", 
					dataType: "json", //返回格式为json
					async: false, //请求是否异步，默认为异步，这也是ajax重要特性
					data: {
						"id":rdata.id,
					}, //参数值
					type: "GET", //请求方式
					success: function(result) {
						table.ajax.reload(null, false);
						$("#delModal").modal('hide');
					}
				})
			})
	  }
	  else {
		  $("#tableWarning").text("请先选择数据");
		  $('body').oneTime('3s',function(){
			  $("#tableWarning").text("");
		  });
	  }
  })
  $("#membersAdd").click(function(){
	  $("#addName").val("");
	  $("#addSex").val("");
	  $("#addCardId").val("");
	  $("#addIdCard").val("");
	  $("#addPhone").val("");
	  $("#addLevel").val("");
	  $("#addyear").val("");
  })
  $("#addSave").click(function(){
		$.ajax({
			url: "coachsAdd", 
			dataType: "json", //返回格式为json
			async: false, //请求是否异步，默认为异步，这也是ajax重要特性
			data: {
				"coachname":$("#addName").val(),
				"coachsex":$("#addSex").val(),
				"coachcardid":$("#addCardId").val(),
				"coachidcard":$("#addIdCard").val(),
				"coachphone":$("#addPhone").val(),
				"coachlevel":$("#addLevel").val(),
				"coachyear":$("#addyear").val()
			}, //参数值
			type: "GET", //请求方式
			success: function(result) {
				table.ajax.reload(null, false);
				$("#addModal").modal('hide');
			}
		})
	})
	
	$("#editSave").click(function(){
		$.ajax({
			url: "coachsEdit", 
			dataType: "json", //返回格式为json
			async: false, //请求是否异步，默认为异步，这也是ajax重要特性
			data: {
				"id":$("#editId").val(),
				"coachname":$("#editName").val(),
				"coachsex":$("#editSex").val(),
				"coachcardid":$("#editCardId").val(),
				"coachidcard":$("#editIdCard").val(),
				"coachphone":$("#editPhone").val(),
				"coachlevel":$("#editLevel").val(),
				"coachyear":$("#edityear").val()
			}, //参数值
			type: "GET", //请求方式
			success: function(result) {
				table.ajax.reload(null, false);
				$("#editModal").modal('hide');
			}
		})
	})
});
	
	