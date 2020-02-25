// Call the dataTables jQuery plugin

var Course = {
    // pTableId: 'pTableId',
    // sTableId: 'sTableId',
    // pTable: null,
    // sTable: null
};

$(function(){
    var setting={
        check: {
            enable: true,
            chkStyle: "checkbox"//显示 checkbox 选择框，默认checkbox可选择值radio
        }
    };
    var zTreeNodes=[
        {"name":"北京",
        	"open":true,
        	children:[
                {"name":"东城区"},
                {"name":"朝阳区"}
            ]
        },//open:true表示默认展开
        {"name":"重庆",
        	"open":true,
        	children:[
                {
                	"name":"巴南区",
                    children:[
                        {"name":"南泉"},
                        {"name":"界石"}
                    ]
                },
                {"name":"渝中区"}
            ]
        }
    ];
    var city = $.fn.zTree.init($("#tree"), setting, zTreeNodes);    
    var setting={
        check: {
            enable: true,
            chkStyle: "checkbox"//显示 checkbox 选择框，默认checkbox可选择值radio
        },
        callback:{
            onCheck:zTreeOnCheck
        }
    };
    var city = $.fn.zTree.init($("#tree"), setting, zTreeNodes);
})
function zTreeOnCheck(event, treeId, treeNode) {
     alert(treeNode.name);//弹出城市名字
}

/*$(document).ready(function () {
	var sTable = $('#sTable').DataTable({
		select: {
			style: "single",
		},
		searching: true,
		bLengthChange: true,
		aLengthMenu: [10],
		pagingType: "simple",
		oLanguage: {
			sLengthMenu: "每页显示 _MENU_ 条记录",
			sZeroRecords: "对不起，查询不到任何相关数据",
			sInfo: "当前显示 _START_ 到 _END_ 条，共 _TOTAL_条记录",
			sInfoEmtpy: "找不到相关数据",
			sInfoFiltered: "数据表中共为 _MAX_ 条记录)",
			sProcessing: "正在加载中...",
			sSearch: "搜索",
			oPaginate: {
				sFirst: "第一页",
				sPrevious: " 上一页 ",
				sNext: " 下一页 ",
				sLast: " 最后一页 "
			},
		},
		processing: false,
		ajax: "membersList",
		columns: [
			{
				data: "membername"
			},
			{
				data: "membercardid"
			}
		],
		order: [
			[1, 'asc']
		]
	});

	

   /* $('#sTable tbody').on('click', 'tr', function () {
        var id = sTable.row(this).data().id;
        $("#memberid").val(id);
        var url = "selectByMemberId/" + id;
        calendar.getEventSources().filter(function (event) {
            event.remove();
        })
//	  debugger;
//	  calendar.getEvents().filter(function(event){
//		  event.remove();
//	  })
        calendar.addEventSource(url);
    });
});*/
	
	