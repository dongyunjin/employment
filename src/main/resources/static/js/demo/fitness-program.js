// Call the dataTables jQuery plugin
$(document).ready(function() {
      table = $('#dataTable').DataTable({
	  select: {
		  style:"single"
	  },
	  "searching" : true,
	  "bLengthChange": true,
	  "aLengthMenu": [10],
	  "pagingType": "simple",
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
	  "processing": false,
	  "ajax":"membersList",
	  "columns": [
		{
			"data": "membername"
		},
		{
			"data": "membercardid"
		}
	],
	"order": [
		[1, 'asc']
	]
  });

  $('#dataTable tbody').on( 'click', 'tr', function () {
	  var id = table.row(this).data().id;
	  $("#memberid").val(id);
	  var url = "selectByMemberId/" + id;
	  calendar.getEventSources().filter(function(event){
		  event.remove();
	  })
//	  debugger;
//	  calendar.getEvents().filter(function(event){
//		  event.remove();
//	  })
	  calendar.addEventSource(url);
  } );
});
	
	