/**
 * 数据管理
 */
$(function() {
    layui.use('table', function(){
        var table = layui.table,
            form = layui.form;
            tableIns = table.render({
                elem: '#dataList',
                url: '/data/getBascisDataList',
                method: 'get', //默认：get请求
                cellMinWidth: 80,
                skin: 'line ',//表格风格 line
                even: true ,   //隔行换色
                page: true , //开启分页
                limit: 10 ,//每页默认显示的数量
                request: {
                    pageName: 'pageNum', //页码的参数名称，默认：pageNum
                    limitName: 'pageSize' //每页数据量的参数名，默认：pageSize
                },
                response: {
                    statusName: 'code', //数据状态的字段名称，默认：code
                    statusCode: 200, //成功的状态码，默认：0
                    countName: 'totals', //数据总数的字段名称，默认：count
                    dataName: 'list', //数据列表的字段名称，默认：data
                    dataLen:'bList'//数据库数据长度
                },
                cols: [[
                      {field:'id',title:'ID',align:'center',width:40}
                    , {field: 'key1', title: '数据1', align: 'center',width:90}
                    , {field: 'key2', title: '数据2', align: 'center',width:90}
                    , {field: 'key3', title: '数据3', align: 'center',width:90}
                    , {field: 'key4', title: '数据4', align: 'center',width:90}
                    , {field: 'key5', title: '数据5', align: 'center',width:90}
                    , {field: 'key6', title: '数据6', align: 'center',width:90}
                    , {field: 'key7', title: '数据7', align: 'center',width:90}
                    , {field: 'key8', title: '数据8', align: 'center',width:90}
                    , {field: 'key9', title: '数据9', align: 'center',width:90}
                    , {field: 'key0', title: '数据10', align: 'center',width:90}
                    , {fixed: 'right', title: '操作', align: 'center', toolbar: '#optBar'}
                ]],
                done:function (res, curr, count) {
                    let dataLen;
                    if (res.last) {
                        dataLen = res.data.length;
                        console.log(dataLen);
                    }
                    console.log(res);
                    //得到当前页码
                    console.log(curr);
                    //得到数据总量
                    console.log(count);
                }
            });

        //监听工具条
        table.on('tool(dataTable)', function(obj){
            var data = obj.data;
            if(obj.event === 'del'){
                //删除
                delData(data,data.id);
            } else if(obj.event === 'edit'){
                //编辑
                edit(data);
            }
        });

        //监听提交
        form.on('submit(dataSubmit)', function(data){
            formSubmit(data);
            return false;
        });
    });
});

//提交表单
function formSubmit(obj){
        $.ajax({
            type: "post",
            data: $("#dataForm").serialize(),
            url: "/data/setDatas",
            success: function (data) {
                if (data.code == 1) {
                    layer.alert(data.msg,function(){
                        layer.closeAll();
                        load(obj);
                    });
                } else {
                    layer.alert(data.msg);
                }
            },
            error: function () {
                layer.alert("操作请求错误，请您稍后再试",function(){
                    layer.closeAll();
                    load(obj);
                });
            }
        });
}

//新增
function add() {
    edit(null,"新增");
}
//打开编辑框
function edit(data,title){
    if(data == null){
        $("#id").val("");
    }else{
        //回显数据
        $("#id").val(data.id);
        $("#key1").val(data.key1);
        $("#key2").val(data.key2);
        $("#key3").val(data.key3);
        $("#key4").val(data.key4);
        $("#key5").val(data.key5);
        $("#key6").val(data.key6);
        $("#key7").val(data.key7);
        $("#key8").val(data.key8);
        $("#key9").val(data.key9);
        $("#key0").val(data.key0);
    }
    var pageNum = $(".layui-laypage-skip").find("input").val();
    $("#pageNum").val(pageNum);
    layer.open({
        type:1,
        title: title,
        fixed:false,
        resize :false,
        shadeClose: true,
        area: ['600px','600px'],
        content:$('#setDatas'),
        end:function(){
            cleanData();
        }
    });
}
//重新加载table
function load(obj){
    tableIns.reload({
        page: {
            pageNumber:1
        },
        where: obj.field
    });
}

//删除
function delData(obj,id) {
    if(null!=id){
        layer.confirm('您确定要删除吗？', {
            btn: ['确认','返回'] //按钮
        }, function(){
            $.post("/data/delDatas",{"id":id},function(data){
                if (data.code == 1) {
                    layer.alert(data.msg,function(){
                        layer.closeAll();
                        load(obj);
                    });
                } else {
                    layer.alert(data.msg);
                    load(obj);
                }
            });
        }, function(){
            layer.closeAll();
            load(obj);
        });
    }
}

function cleanData() {
    $("#key1").val("");
    $("#key2").val("");
    $("#key3").val("");
    $("#key4").val("");
    $("#key5").val("");
    $("#key6").val("");
    $("#key7").val("");
    $("#key8").val("");
    $("#key9").val("");
    $("#key0").val("");
}

