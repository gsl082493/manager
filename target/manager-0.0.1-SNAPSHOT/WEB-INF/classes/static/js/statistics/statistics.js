/**
 * 添加表单颜色
 * @param id
 */
function altRows(id){
        if(document.getElementsByTagName){
                var table = document.getElementById(id);
                var rows = table.getElementsByTagName("tr");
                 for(i = 0; i < rows.length; i++){
                         if(i % 2 == 0){
                                rows[i].className = "evenrowcolor";
                            }else{
                               rows[i].className = "oddrowcolor";
                             }
                     }
             }
     }
 window.onload=function(){
         altRows('alternatecolor');
     };


$(function () {
    //搜索框
    layui.use(['form','laydate'], function(){
        var form = layui.form ,layer = layui.layer
            ,laydate = layui.laydate;
        //日期
        laydate.render({
            elem: '#startTime'
        });
        laydate.render({
            elem: '#endTime'
        });
        //TODO 数据校验
        //监听搜索框
        form.on('submit(searchSubmit)', function(){
            return false;
        });
    });
    /**
     * 欢迎界面
     */
    layui.use('layer',function () {
            var layer = layui.layer;
           layer.msg('欢迎来到数据统计界面',{icon:6})
    });

    /**
     * 最大值
     */
    $.ajax({
        url:'/display/levelData1',
        type:'get',
        dataType:'json',
        success:function (data) {
            data = data.filter(function (v , i) {
                return v.length >= 1;
            });
            var dataText = JSON.stringify(data);
            $('#level1').append(dataText);
        },error(data){
            console.log(data);
        }
    });

    $.ajax({
        url:'/display/levelData2',
        type:'get',
        dataType:'json',
        success:function (data) {
            data = data.filter(function (v , i) {
                return v.length >= 1;
            });
            var dataText = JSON.stringify(data);
            $('#level2').append(dataText);
        },error(data){
            console.log(data);
        }
    });
    $.ajax({
        url:'/display/levelData3',
        type:'get',
        dataType:'json',
        success:function (data) {
            data = data.filter(function (v , i) {
                return v.length >= 1;
            });
            var dataText = JSON.stringify(data);
            $('#level3').append(dataText);
        },error(data){
            console.log(data);
        }
    });
    $.ajax({
        url:'/display/levelData4',
        type:'get',
        dataType:'json',
        success:function (data) {
            data = data.filter(function (v , i) {
                return v.length >= 1;
            });
            var dataText = JSON.stringify(data);
            $('#level4').append(dataText);
        },error(data){
            console.log(data);
        }
    });
    $.ajax({
        url:'/display/levelData5',
        type:'get',
        dataType:'json',
        success:function (data) {
            data = data.filter(function (v , i) {
                return v.length >= 1;
            });
            var dataText = JSON.stringify(data);
            $('#level5').append(dataText);
        },error(data){
            console.log(data);
        }
    });

    /**
     * 详情
     */
    $.ajax({
        url:'/display/selectOne',
        type:'get',
        dataType:'json',
        success:function (data) {
            var dataText = JSON.stringify(data);
            $('#particulars1').append(dataText);
        },error(data){
            console.log(data);
        }
    });

    $.ajax({
        url:'/display/selectTwo',
        type:'get',
        dataType:'json',
        success:function (data) {
            var dataText = JSON.stringify(data);
            $('#particulars2').append(dataText);
        },error(data){
            console.log(data);
        }
    });
    $.ajax({
        url:'/display/selectThree',
        type:'get',
        dataType:'json',
        success:function (data) {
            var dataText = JSON.stringify(data);
            $('#particulars3').append(dataText);
        },error(data){
            console.log(data);
        }
    });
    $.ajax({
        url:'/display/selectFour',
        type:'get',
        dataType:'json',
        success:function (data) {
            var dataText = JSON.stringify(data);
            $('#particulars4').append(dataText);
        },error(data){
            console.log(data);
        }
    });
    $.ajax({
        url:'/display/selectFive',
        type:'get',
        dataType:'json',
        success:function (data) {
            var dataText = JSON.stringify(data);
            $('#particulars5').append(dataText);
        },error(data){
            console.log(data);
        }
    })

});


/**
 * 按钮触发弹窗
 */
function selectstatistics1(){
    layer.open({
        type: 1,
        title: '详情',
        fix: false,
        maxmin: true,
        shadeClose: true,
        shade: 0.8,
        area: ['600px', '500px'],
        content:$("#particulars1").html()
    })
}
function selectstatistics2(){
    layer.open({
        type: 1,
        title: '详情',
        fix: false,
        maxmin: true,
        shadeClose: true,
        shade: 0.8,
        area: ['600px', '500px'],
        content:$("#particulars2").html()
    })
}
function selectstatistics3(){
    layer.open({
        type: 1,
        title: '详情',
        fix: false,
        maxmin: true,
        shadeClose: true,
        shade: 0.8,
        area: ['600px', '500px'],
        content:$("#particulars3").html()
    })
}
function selectstatistics4(){
    layer.open({
        type: 1,
        title: '详情',
        fix: false,
        maxmin: true,
        shadeClose: true,
        shade: 0.8,
        area: ['600px', '500px'],
        content:$("#particulars4").html()
    })
}
function selectstatistics5(){
    layer.open({
        type: 1,
        title: '详情',
        fix: false,
        maxmin: true,
        shadeClose: true,
        shade: 0.8,
        area: ['600px', '500px'],
        content:$("#particulars5").html()
    })
}
