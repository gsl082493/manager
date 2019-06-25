var len;
$(function () {
    layui.use('table',function () {
        var table = layui.table,
            form = layui.form,
            $ = layui.jquery;
        tableIns = table.render({
            elem:"#demo",
            url:"/data/selectBaseData",
            page:true,
            limit:10,
            limits:[10,20,30,40,50,60,70,80,90],
            title:"数据信息列表",
            cols:[[
                  {type:'numbers'}
                , {field: 'key1', title: 'X', sort: true, align: 'center',width:90}
                , {field: 'key2', title: 'Y', sort: true, align: 'center',width:90}
                , {field: 'key3', title: 'Z', sort: true, align: 'center',width:90}
                , {field: 'key4', title: '压力', sort: true, align: 'center',width:90}
                , {field: 'key5', title: '力值', sort: true, align: 'center',width:90}
                , {field: 'key6', title: '长度', sort: true, align: 'center',width:90}
                , {field: 'key7', title: '摄氏度', sort: true, align: 'center',width:90}
                , {field: 'key8', title: '速度', sort: true, align: 'center',width:90}
                , {field: 'key9', title: '数据9', sort: true, align: 'center',width:90}
                , {field: 'key0', title: '数据10', sort: true, align: 'center',width:90}
                , {fixed: 'right', title: '操作', align: 'center', toolbar: '#optBar'}
            ]],
            done:function (res,curr,count) {
                setInterval(function () {
                $.ajax({
                    url:"/data/getCount",
                    type:"get",
                    data : {},
                    dataType:"json",
                    contentType :"application/x-www-form-urlencoded",
                    async : false,
                    success:function (data) {
                        len = data.result;//数据库总数
                        var len2 = count;//页面总数
                        if(len != len2){
                            window.location.reload();
                        }
                    }
                });
            },3000);
            }
        });
        //监听工具条
        table.on('tool(demo)', function(obj){
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
    })
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
            curr:1
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
