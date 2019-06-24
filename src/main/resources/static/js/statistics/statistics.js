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
            var datas = [];
            var arr = data.list2;
            for(var i = 0; i<arr.length; i++){
                datas.push(arr[i])
            }
            $('#level1').append(datas);
        },error(data){
            console.log(data);
        }
    });

    $.ajax({
        url:'/display/levelData2',
        type:'get',
        dataType:'json',
        success:function (data) {
            var datas = [];
            var arr = data.list2;
            for(var i = 0; i<arr.length; i++){
                datas.push(arr[i])
            }
            $('#level2').append(datas);
        },error(data){
            console.log(data);
        }
    });
    $.ajax({
        url:'/display/levelData3',
        type:'get',
        dataType:'json',
        success:function (data) {
            var datas = [];
            var arr = data.list2;
            for(var i = 0; i<arr.length; i++){
                datas.push(arr[i])
            }
            $('#level3').append(datas);
        },error(data){
            console.log(data);
        }
    });
    $.ajax({
        url:'/display/levelData4',
        type:'get',
        dataType:'json',
        success:function (data) {
            var datas = [];
            var arr = data.list2;
            for(var i = 0; i<arr.length; i++){
                datas.push(arr[i])
            }
            $('#level4').append(datas);
        },error(data){
            console.log(data);
        }
    });
    $.ajax({
        url:'/display/levelData5',
        type:'get',
        dataType:'json',
        success:function (data) {
            var datas = [];
            var arr = data.list2;
            for(var i = 0; i<arr.length; i++){
                datas.push(arr[i])
            }
            $('#level5').append(datas);
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
            var k1 = [];
            var k2 = [];
            var k3 = [];
            var time = [];
            var arr = data.list;
            var tr = "<tr><td>X</td><td>Y</td><td>Z</td><td>上传时间</td></tr>";
            var str1;
            for(var i = 0; i<arr.length; i++){
                k1.push(arr[i].X);
                k2.push(arr[i].Y);
                k3.push(arr[i].Z);
                time.push(arr[i].上传时间);
            };
            for(var x= 0, y = 0, z = 0 , t = 0; x<k1.length,y<k2.length,z<k3.length,t<time.length; x++,y++,z++,t++){
                str1 += "<tr>" +
                    "<td>"+k1[x]+"</td>" +
                    "<td>"+k2[y]+"</td>" +
                    "<td>"+k3[z]+"</td>" +
                    "<td>"+time[t]+"</td>" +
                    "</tr>";
            }
            $("#table1").html(tr);
            $("#table1").append(str1);
        },error(data){
            console.log(data);
        }
    });

    $.ajax({
        url:'/display/selectTwo',
        type:'get',
        dataType:'json',
        success:function (data) {
            var k1 = [];
            var k2 = [];
            var k3 = [];
            var time = [];
            var arr = data.list;
            var tr = "<tr><td>X</td><td>Y</td><td>Z</td><td>上传时间</td></tr>";
            var str2;
            for(var i = 0; i<arr.length; i++){
                k1.push(arr[i].X);
                k2.push(arr[i].Y);
                k3.push(arr[i].Z);
                time.push(arr[i].上传时间);
            };
            for(var x= 0, y = 0, z = 0 , t = 0; x<k1.length,y<k2.length,z<k3.length,t<time.length; x++,y++,z++,t++){
                str2 += "<tr>" +
                    "<td>"+k1[x]+"</td>" +
                    "<td>"+k2[y]+"</td>" +
                    "<td>"+k3[z]+"</td>" +
                    "<td>"+time[t]+"</td>" +
                    "</tr>";
            }
            $("#table2").html(tr);
            $("#table2").append(str2);
        },error(data){
            console.log(data);
        }
    });

    $.ajax({
        url:'/display/selectThree',
        type:'get',
        dataType:'json',
        success:function (data) {
            var k1 = [];
            var k2 = [];
            var k3 = [];
            var time = [];
            var arr = data.list;
            var tr = "<tr><td>X</td><td>Y</td><td>Z</td><td>上传时间</td></tr>";
            var str3;
            for(var i = 0; i<arr.length; i++){
                k1.push(arr[i].X);
                k2.push(arr[i].Y);
                k3.push(arr[i].Z);
                time.push(arr[i].上传时间);
            };
            for(var x= 0, y = 0, z = 0 , t = 0; x<k1.length,y<k2.length,z<k3.length,t<time.length; x++,y++,z++,t++){
                str3 += "<tr>" +
                    "<td>"+k1[x]+"</td>" +
                    "<td>"+k2[y]+"</td>" +
                    "<td>"+k3[z]+"</td>" +
                    "<td>"+time[t]+"</td>" +
                    "</tr>";
            }
            $("#table3").html(tr);
            $("#table3").append(str3);
        },error(data){
            console.log(data);
        }
    });

    $.ajax({
        url:'/display/selectFour',
        type:'get',
        dataType:'json',
        success:function (data) {
            var k1 = [];
            var k2 = [];
            var k3 = [];
            var time = [];
            var arr = data.list;
            var tr = "<tr><td>X</td><td>Y</td><td>Z</td><td>上传时间</td></tr>";
            var str4;
            for(var i = 0; i<arr.length; i++){
                k1.push(arr[i].X);
                k2.push(arr[i].Y);
                k3.push(arr[i].Z);
                time.push(arr[i].上传时间);
            };
            for(var x= 0, y = 0, z = 0 , t = 0; x<k1.length,y<k2.length,z<k3.length,t<time.length; x++,y++,z++,t++){
                str4 += "<tr>" +
                    "<td>"+k1[x]+"</td>" +
                    "<td>"+k2[y]+"</td>" +
                    "<td>"+k3[z]+"</td>" +
                    "<td>"+time[t]+"</td>" +
                    "</tr>";
            }
            $("#table4").html(tr);
            $("#table4").append(str4);
        },error(data){
            console.log(data);
        }
    });

    $.ajax({
        url:'/display/selectFive',
        type:'get',
        dataType:'json',
        success:function (data) {
            var k1 = [];
            var k2 = [];
            var k3 = [];
            var time = [];
            var arr = data.list;
            var tr = "<tr><td>X</td><td>Y</td><td>Z</td><td>上传时间</td></tr>";
            var str5;
            for(var i = 0; i<arr.length; i++){
                k1.push(arr[i].X);
                k2.push(arr[i].Y);
                k3.push(arr[i].Z);
                time.push(arr[i].上传时间);
            };
            for(var x= 0, y = 0, z = 0 , t = 0; x<k1.length,y<k2.length,z<k3.length,t<time.length; x++,y++,z++,t++){
                str5 += "<tr>" +
                    "<td>"+k1[x]+"</td>" +
                    "<td>"+k2[y]+"</td>" +
                    "<td>"+k3[z]+"</td>" +
                    "<td>"+time[t]+"</td>" +
                    "</tr>";
            }
            $("#table5").html(tr);
            $("#table5").append(str5);
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

/**
 * 导出到Excel
 * @constructor
 */

function base64(content) {
    return window.btoa(unescape(encodeURIComponent(content)));
}
function tableToExcel(tableID, fileName) {
    var excelContent = $("#" + tableID).html();
    var excelFile = "<html xmlns:o='urn:schemas-microsoft-com:office:office' xmlns:x='urn:schemas-microsoft-com:office:excel' xmlns='http://www.w3.org/TR/REC-html40'>";
    excelFile += "<head><xml><x:ExcelWorkbook><x:ExcelWorksheets><x:ExcelWorksheet><x:Name>{worksheet}</x:Name><x:WorksheetOptions><x:DisplayGridlines/></x:WorksheetOptions></x:ExcelWorksheet></x:ExcelWorksheets></x:ExcelWorkbook></xml></head>";
    excelFile += "<body><table width='50%'  border='1'>";
    excelFile += excelContent;
    excelFile += "</table></body>";
    excelFile += "</html>";
    var link = "data:application/vnd.ms-excel;base64," + base64(excelFile);
    var a = document.createElement("a");
    a.download = fileName + ".xlsx";
    a.href = link;
    a.click();
}
