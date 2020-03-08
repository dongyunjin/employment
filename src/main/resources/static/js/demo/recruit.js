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
            url: "recruitList",
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
                data: "company", title: "名称"
            },
            {
                data: "job", title: "岗位"
            },
            {
                data: "salary", title: "薪资"
            },
            {
                data: "position", title: "位置"
            },
            {
                data: "year", title: "工作年限"
            },
            {
                data: "education", title: "学历"
            }
        ],
        "order": [[1, 'asc']]
    });

    function format(d) {
        // `d` is the original data object for the row
        return '<table cellpadding="5" cellspacing="0" border="0">'
            + '<tr>'
            + '<td style="padding: 8px 10px;">职位详情:</td>'
            + '<td style="padding: 8px 10px;">'
            + d.detail
            + '</td>'
            + '</tr>'
            + '</table>';
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

    //组合树
    var data = "";
    $.ajax({
        url: "trainTreeList",
        dataType: "json", //返回格式为json
        async: true, //请求是否异步，默认为异步，这也是ajax重要特性
        data: {}, //参数值
        type: "GET", //请求方式
        success: function (result) {
            var reg = new RegExp("\"name\"", "g");//g,表示全部替换。
            data = JSON.parse(JSON.stringify(result.data).replace(reg, "\"text\""));
            //新增
            $('#addPid').combotree({
                data: [data],
                required: false,
            });
            $('#addPid').next().css('width', '100%');
            $('#addPid').next().find('input').css('width', '100%');

            //编辑
            $('#editPid').combotree({
                data: [data],
                required: false,
            });
            $('#editPid').next().css('width', '100%');
            $('#editPid').next().find('input').css('width', '100%');
        }
    });

    function getValue() {
        var val = $('#addPid').combotree('getValue');
        alert(val);
    }

    function setValue() {
        $('#cc').combotree('setValue', '122');
    }

    $("#edit").click(function () {
        if (table.row({selected: true}).any()) {
            $("#editCompany").val("");
            $("#editJob").val("");
            $("#editSalary").val("");
            $("#editPosition").val("");
            $("#editYear").val("");
            $("#editDetail").val("");
            var rdata = table.row({selected: true}).data();
            $("#editId").val(rdata.id);
            $("#editCompany").val(rdata.company);
            $("#editJob").val(rdata.job);
            $("#editSalary").val(rdata.salary);
            $("#editPosition").val(rdata.position);
            $("#editYear").val(rdata.year);
            $("#editEducation").val(rdata.education);
            $("#editDetail").val(rdata.detail);
            $('#editPid').combotree('setValue', rdata.pid);
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

            $("#delSave").click(function () {
                var rdata = table.row({selected: true}).data();
                $.ajax({
                    url: "recruit/del",
                    dataType: "json", //返回格式为json
                    async: false, //请求是否异步，默认为异步，这也是ajax重要特性
                    data: {
                        "id": rdata.id,
                    }, //参数值
                    type: "POST", //请求方式
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
        $("#addCompany").val("");
        $("#addJob").val("");
        $("#addSalary").val("");
        $("#addPosition").val("");
        $("#addYear").val("");
        $("#addEducation").find("option").eq(0).prop("selected", true)
        $("#addDetail").val("");
        $("#addModal").modal('show');
    })
    $("#addSave").click(function () {
        $.ajax({
            url: "recruit/add",
            dataType: "json", //返回格式为json
            async: true, //请求是否异步，默认为异步，这也是ajax重要特性
            data: {
                company: $("#addCompany").val(),
                job: $("#addJob").val(),
                salary: $("#addSalary").val(),
                position: $("#addPosition").val(),
                year: $("#addYear").val(),
                education: $("#addEducation").find("option:selected").text(),
                detail: $("#addDetail").val(),
                pid: $('#addPid').combotree('getValue')
            }, //参数值
            type: "POST", //请求方式
            success: function (result) {
                table.ajax.reload(null, false);
                $("#addModal").modal('hide');
            }
        })
    })

    $("#editSave").click(function () {
        $.ajax({
            url: "recruit/edit",
            dataType: "json", //返回格式为json
            async: true, //请求是否异步，默认为异步，这也是ajax重要特性
            data: {
                id: $("#editId").val(),
                company: $("#editCompany").val(),
                job: $("#editJob").val(),
                salary: $("#editSalary").val(),
                position: $("#editPosition").val(),
                year: $("#editYear").val(),
                education: $("#editEducation").find("option:selected").text(),
                detail: $("#editDetail").val(),
                pid: $('#editPid').combotree('getValue')
            }, //参数值
            type: "POST", //请求方式
            success: function (result) {
                table.ajax.reload(null, false);
                $("#editModal").modal('hide');
            }
        })
    })
});

