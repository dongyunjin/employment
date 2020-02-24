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
                var url = "course/sList/" + id;
                sTable.ajax.url(url).load();
                params.selectedId = id;
            } else if (id != params.selectedId) {
                var url = "course/sList/" + id;
                sTable.ajax.url(url).load();
            } else {
                params.selectedId = null;
            }
        }
    );
    // $("#pAdd").click(function () {
    //
    // })
    $("#pAddSave").click(function () {
        $.ajax({
            url: "course/pAdd",
            dataType: "json", //返回格式为json
            async: false, //请求是否异步，默认为异步，这也是ajax重要特性
            data: {
                name: $("#pAddName").val(),
                desc: $("#pAddDesc").val()
            }, //参数值
            type: "POST", //请求方式
            success: function (result) {
                pTable.ajax.reload(null, false);
                $("#pAddModal").modal('hide');
                $("#pAddName").val("");
                $("#pAddDesc").val("");
            }
        })
    })
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
    });
    $("#pEditSave").click(function () {
        $.ajax({
            url: "course/pEdit",
            dataType: "json", //返回格式为json
            async: false, //请求是否异步，默认为异步，这也是ajax重要特性
            data: {
                id: $("#pEditId").val(),
                name: $("#pAddName").val(),
                desc: $("#pAddDesc").val()
            }, //参数值
            type: "GET", //请求方式
            success: function (result) {
                pTable.ajax.reload(null, false);
                $("#pEditModal").modal('hide');
            }
        })
    });
    $("#pDel").click(function () {
        if (pTable.row({selected: true}).any()) {
            $("#pDelModal").modal('show');

            $("#pDelSave").click(function () {
                var rdata = pTable.row({selected: true}).data();
                $.ajax({
                    url: "course/pDel",
                    dataType: "json", //返回格式为json
                    async: false, //请求是否异步，默认为异步，这也是ajax重要特性
                    data: {
                        "id": rdata.id
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
    });

    ///////////////////////////////////////////////////////////////////////////////

    // $('#sTable tbody').on('click', 'tr', function () {
    //     var id = sTable.row(this).data().id;
    // });

    $("#sAdd").click(function () {
        $("#sAddFile").fileinput({
            theme: 'fas',
            showUpload: false,
            fileType: "any",
            maxFileCount: 1,
            maxFilePreviewSize: 102400, //100M
            uploadUrl: 'upload',
            uploadAsync: false,
            initialPreviewShowDelete: false,
            fileActionSettings: {
                showDrag: false
            },
            uploadExtraData: function () {
                //上传额外的参数
                var data = {
                    name: $("#sAddName").val(),
                    desc: $("#sAddDesc").val()
                };
                return data;
            },
            initialPreview: [],
            initialPreviewAsData: true, // 默认标记
            initialPreviewConfig: []
        }).on('filebatchuploadsuccess', function (event, data) {
            var out = '';
            $.each(data.files, function (key, file) {
                var fname = file.name;
                out = out + '<li>' + '上传文件 # ' + (key + 1) + ' - ' + fname + ' 成功。' + '</li>';
            });
            $("#sAddModal").modal('hide');
            $("#sAddName").val("");
            $("#sAddDesc").val("");
            $("#sAddFile").fileinput("clear");
        });
    });

    $("#sAddSave").click(function () {
        $("#sAddFile").fileinput("upload");
    });

    $("#sEdit").click(function () {
        if (sTable.row({selected: true}).any()) {
            $("#sEditName").val("");
            $("#sEditDesc").val("");
            var rdata = sTable.row({selected: true}).data();
            $("#sEditId").val(rdata.id);
            $("#sEditName").val(rdata.name);
            $("#sEditDesc").val(rdata.desc);

            $("#sEditFile").fileinput({
                theme: 'fas',
                showUpload: false,
                fileType: "any",
                maxFileCount: 1,
                maxFilePreviewSize: 102400, //100M
                uploadUrl: 'course/sEdit',
                uploadAsync: false,
                initialPreviewShowDelete: false,
                fileActionSettings: {
                    showDrag: false
                },
                uploadExtraData: function () {
                    //上传额外的参数
                    var data = {
                        name: $("#sAddName").val(),
                        desc: $("#sAddDesc").val()
                    };
                    return data;
                },
                initialPreview: ['1.mp4'],
                initialPreviewAsData: true, // 默认标记
                initialPreviewConfig: [{type: "video", filetype: "video/mp4"}]
            }).on('filebatchuploadsuccess', function (event, data) {
                var out = '';
                $.each(data.files, function (key, file) {
                    var fname = file.name;
                    out = out + '<li>' + '上传文件 # ' + (key + 1) + ' - ' + fname + ' 成功。' + '</li>';
                });
                $("#sAddModal").modal('hide');
            });
            $("#sEditModal").modal('show');
        } else {
            $("#sTableWarning").text("请先选择数据");
            $('body').oneTime('3s', function () {
                $("#sTableWarning").text("");
            });
        }
    });

    $("#sEditSave").click(function () {
        $("#sEditFile").fileinput("upload");
        $('#sEditFile').fileinput('destroy');
    });
    $("#sDel").click(function () {
        if (sTable.row({selected: true}).any()) {
            $("#sDelModal").modal('show');

            $("#sDelSave").click(function () {
                var rdata = sTable.row({selected: true}).data();
                $.ajax({
                    url: "course/sDel",
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
            $("#sTableWarning").text("请先选择数据");
            $('body').oneTime('3s', function () {
                $("#sTableWarning").text("");
            });
        }
    })
});

