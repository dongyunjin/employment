// Call the dataTables jQuery plugin
$(document).ready(function () {
    var table = $('#dateTable').DataTable({
        select: {
            style: "single"
        },
        searching: true,
        bLengthChange: true,
        aLengthMenu: [10],
        pagingType: "simple",
        oLanguage: {
            sLengthMenu: "每页显示 _MENU_ 条记录",
            sZeroRecords: "对不起，查询不到任何相关数据",
            sInfo: "当前显示 _START_ 到 _END_ 条，共 _TOTAL_条记录",
            sInfoEmpty: "找不到相关数据",
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
        processing: true,
        ajax: {
            url: "user_mgmt/list",
            type: "POST"
        },
        columns: [
            {
                className: 'details-control',
                orderAble: false,
                data: null,
                defaultContent: '',
                title: "",
            },
            {
                data: "username", title: "登录名"
            },
            {
                data: "pwd", title: "密码"
            },
            {
                data: "name", title: "姓名"
            },
            {
                data: "age", title: "年龄"
            },
            {
                data: "sex", title: "性别"
            },
            {
                data: "school", title: "学校"
            },
            {
                data: "major", title: "专业"
            },
            {
                data: "place", title: "期望工作地点"
            },
            {
                data: "money", title: "期望薪资"
            }
        ],
        "order": [[1, 'asc']]
    });

    function format(d) {
        // `d` is the original data object for the row
        return '<table cellpadding="5" cellspacing="0" border="0">'
            + '<tr>'
            + '<td style="padding: 8px 10px;">工作经历:</td>'
            + '<td style="padding: 8px 10px;">'
            + null2empty(d.work)
            + '</td>'
            + '</tr>'
            + '<tr>'
            + '<td style="padding: 8px 10px;">项目经验:</td>'
            + '<td style="padding: 8px 10px;">'
            + null2empty(d.project)
            + '</td>'
            + '</tr>'
            + '<tr>'
            + '<td style="padding: 8px 10px;">个人优势:</td>'
            + '<td style="padding: 8px 10px;">'
            + null2empty(d.advantage)
            + '</td>'
            + '</tr>'
            + '</table>';
    }

    function null2empty(val) {
        if (val == null) {
            return "";
        }
        return val;
    }

    /*$('#dataTable tbody').on( 'click', 'tr', function () {
        if ( table.row( this, { selected: true }).any() ) {
            //table.row( this ).deselect();
            //console.log( table.row( this ).data() );
        }
        else {
            //table.row( this ).select();
        }
    } );*/
    $('#dateTable tbody').on(
        'click',
        'td.details-control',
        function () {
            var tr = $(this).closest('tr');
            var row = table.row(tr);

            if (row.child.isShown()) {
                // This row is already open - close it
                row.child.hide();
                tr.removeClass('shown');
            } else {
                // Open this row
                row.child(format(row.data()))
                    .show();
                tr.addClass('shown');
            }
            //阻止冒泡
            return false;
        });
    $("#edit").click(function () {
        if (table.row({selected: true}).any()) {
            $("#editName").val("");
            $("#editSex").val("");
            $("#editCardId").val("");
            $("#editCard").val("");
            $("#editPhone").val("");
            $("#editLevel").val("");
            console.log(table.row({selected: true}).data());
            var rdata = table.row({selected: true}).data();
            $("#editId").val(rdata.id);
            $("#editName").val(rdata.membername);
            $("#editSex").val(rdata.membersex);
            $("#editCardId").val(rdata.membercardid);
            $("#editIdCard").val(rdata.memberidcard);
            $("#editPhone").val(rdata.memberphone);
            $("#editLevel").val(rdata.memberlevel);
            $("#editModal").modal('show');
        } else {
            $("#tableWarning").text("请先选择数据");
            $('body').oneTime('3s', function () {
                $("#tableWarning").text("");
            });
        }
    })
    $("#del").click(function () {
        if (table.row({selected: true}).any()) {
            $("#delModal").modal('show');

            $("#del").click(function () {
                var rdata = table.row({selected: true}).data();
                $.ajax({
                    url: "membersDel",
                    dataType: "json", //返回格式为json
                    async: false, //请求是否异步，默认为异步，这也是ajax重要特性
                    data: {
                        "id": rdata.id,
                    }, //参数值
                    type: "GET", //请求方式
                    success: function (result) {
                        table.ajax.reload(null, false);
                        $("#delModal").modal('hide');
                    }
                })
            })
        } else {
            $("#tableWarning").text("请先选择数据");
            $('body').oneTime('3s', function () {
                $("#tableWarning").text("");
            });
        }
    })
    $("#add").click(function () {
        $("#addName").val("");
        $("#addSex").val("");
        $("#addCardId").val("");
        $("#addIdCard").val("");
        $("#addPhone").val("");
        $("#addLevel").val("");
        $("#addModal").modal('show');
    })
    $("#addSave").click(function () {
        $.ajax({
            url: "membersAdd",
            dataType: "json", //返回格式为json
            async: false, //请求是否异步，默认为异步，这也是ajax重要特性
            data: {
                "membername": $("#addName").val(),
                "membersex": $("#addSex").val(),
                "membercardid": $("#addCardId").val(),
                "memberidcard": $("#addIdCard").val(),
                "memberphone": $("#addPhone").val(),
                "memberlevel": $("#addLevel").val()
            }, //参数值
            type: "GET", //请求方式
            success: function (result) {
                table.ajax.reload(null, false);
                $("#addModal").modal('hide');
            }
        })
    })

    $("#editSave").click(function () {
        $.ajax({
            url: "membersEdit",
            dataType: "json", //返回格式为json
            async: false, //请求是否异步，默认为异步，这也是ajax重要特性
            data: {
                "id": $("#editId").val(),
                "membername": $("#editName").val(),
                "membersex": $("#editSex").val(),
                "membercardid": $("#editCardId").val(),
                "memberidcard": $("#editIdCard").val(),
                "memberphone": $("#editPhone").val(),
                "memberlevel": $("#editLevel").val()
            }, //参数值
            type: "GET", //请求方式
            success: function (result) {
                table.ajax.reload(null, false);
                $("#editModal").modal('hide');
            }
        })
    })
});
	
	