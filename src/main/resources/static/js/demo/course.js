// Call the dataTables jQuery plugin

var params = {
    // pTableId: 'pTableId',
    // sTableId: 'sTableId',
    // pTable: null,
    // sTable: null
    selectedId: null
};


$(document).ready(function () {
    var pTable = $('#pTable').DataTable({
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
        ajax: {
            url: "course/pList",
            type: "POST"
        },
        columns: [
            {
                data: "name", title: "课程名称"
            },
            {
                data: "desc", title: "课程描述"
            }
        ],
        order: [
            [0, 'asc']
        ]
    });


    var sTable = $('#sTable').DataTable({
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
        ajax: {
            "url": "course/sList",
            "type": "POST"
        },
        columns: [
            {
                data: "name", title: "课程名称"
            },
            {
                data: "desc", title: "课程描述"
            },
            {
                data: "type", title: "课程类型"
            },
            {
                data: "url", title: "文件地址"
            }
        ],
        order: [
            [0, 'asc']
        ]
    });

    $('#pTable tbody').on('click', 'tr', function () {
            var id = pTable.row(this).data().id;
            if (params.selectedId == null) {
                $("#memberid").val(id);
                var url = "course/sList/" + id;
                sTable.ajax.url(url).load();
                params.selectedId = id;
            } else if (id != params.selectedId) {
                $("#memberid").val(id);
                var url = "course/sList/" + id;
                sTable.ajax.url(url).load();
            }
        }
    );

    $("#pEdit").click(function () {
        if (pTable.row({selected: true}).any()) {
            $("#pEditName").val("");
            $("#pEditDesc").val("");
            var rdata = pTable.row({selected: true}).data();
            $("#pEditId").val(rdata.id);
            $("#pEditName").val(rdata.name);
            $("#pEditDesc").val(rdata.desc);
            $("#pEditModal").modal('show');
        } else {
            $("#pTableWarning").text("请先选择数据");
            $('body').oneTime('3s', function () {
                $("#pTableWarning").text("");
            });
        }
    })
    $("#pDel").click(function () {
        if (pTable.row({selected: true}).any()) {
            $("#pDelModal").modal('show');

            $("#pDel").click(function () {
                var rdata = pTable.row({selected: true}).data();
                $.ajax({
                    url: "membersDel",
                    dataType: "json", //返回格式为json
                    async: false, //请求是否异步，默认为异步，这也是ajax重要特性
                    data: {
                        "id": rdata.id,
                    }, //参数值
                    type: "GET", //请求方式
                    success: function (result) {
                        pTable.ajax.reload(null, false);
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
    $("#pAdd").click(function () {
        $("#pAddName").val("");
        $("#pAddDesc").val("");
    })
    $("#pAddSave").click(function () {
        $.ajax({
            url: "membersAdd",
            dataType: "json", //返回格式为json
            async: false, //请求是否异步，默认为异步，这也是ajax重要特性
            data: {
                name : $("#pAddName").val(),
                desc : $("#pAddDesc").val()
            }, //参数值
            type: "GET", //请求方式
            success: function (result) {
                pTable.ajax.reload(null, false);
                $("#pAddModal").modal('hide');
            }
        })
    })

    $("#pEditSave").click(function () {
        $.ajax({
            url: "membersEdit",
            dataType: "json", //返回格式为json
            async: false, //请求是否异步，默认为异步，这也是ajax重要特性
            data: {
                id : $("#pEditId").val(),
                name : $("#pAddName").val(),
                desc : $("#pAddDesc").val()
            }, //参数值
            type: "GET", //请求方式
            success: function (result) {
                pTable.ajax.reload(null, false);
                $("#pEditModal").modal('hide');
            }
        })
    })

    ///////////////////////////////////////////////////////////////////////////////

    $('#sTable tbody').on('click', 'tr', function () {
        var id = sTable.row(this).data().id;
        $("#memberid").val(id);
    });

    $("#sEdit").click(function () {
        if (sTable.row({selected: true}).any()) {
            $("#sEditName").val("");
            $("#sEditDesc").val("");
            var rdata = sTable.row({selected: true}).data();
            $("#sEditId").val(rdata.id);
            $("#sEditName").val(rdata.name);
            $("#sEditDesc").val(rdata.desc);
            $("#pEditModal").modal('show');
        } else {
            $("#pTableWarning").text("请先选择数据");
            $('body').oneTime('3s', function () {
                $("#pTableWarning").text("");
            });
        }
    })
    $("#sDel").click(function () {
        if (sTable.row({selected: true}).any()) {
            $("#pDelModal").modal('show');

            $("#pDel").click(function () {
                var rdata = sTable.row({selected: true}).data();
                $.ajax({
                    url: "membersDel",
                    dataType: "json", //返回格式为json
                    async: false, //请求是否异步，默认为异步，这也是ajax重要特性
                    data: {
                        "id": rdata.id,
                    }, //参数值
                    type: "GET", //请求方式
                    success: function (result) {
                        sTable.ajax.reload(null, false);
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
    $("#sAdd").click(function () {
        $("#sAddName").val("");
        $("#sAddDesc").val("");
    })
    $("#sAddSave").click(function () {
        $.ajax({
            url: "membersAdd",
            dataType: "json", //返回格式为json
            async: false, //请求是否异步，默认为异步，这也是ajax重要特性
            data: {
                name : $("#sAddName").val(),
                desc : $("#sAddDesc").val()
            }, //参数值
            type: "GET", //请求方式
            success: function (result) {
                sTable.ajax.reload(null, false);
                $("#pAddModal").modal('hide');
            }
        })
    })

    $("#sEditSave").click(function () {
        $.ajax({
            url: "membersEdit",
            dataType: "json", //返回格式为json
            async: false, //请求是否异步，默认为异步，这也是ajax重要特性
            data: {
                id : $("#sEditId").val(),
                name : $("#sEditName").val(),
                desc : $("#sEditDesc").val()
            }, //参数值
            type: "GET", //请求方式
            success: function (result) {
                sTable.ajax.reload(null, false);
                $("#pEditModal").modal('hide');
            }
        })
    })
});

