var sTime;
var eTime;
var name;
var model_Number;
$(function () {
    //搜索框
    layui.use(['form','laydate'], function(){
        var form = layui.form ,layer = layui.layer
            ,laydate = layui.laydate;
        //日期
        laydate.render({
            elem: '#startTime',
            done:function (value,date) {
               /*alert("开始时间日期是："+value+"\n获得的对象是："+JSON.stringify(date));*/
                sTime = value;
            }
        });
        laydate.render({
            elem: '#endTime',
            done:function (value,date) {
                /*alert("结束时间日期是："+value+"\n获得的对象是："+JSON.stringify(date));*/
                eTime = value;
            }
        });
        //TODO 数据校验
        //监听搜索框
        form.on('submit(searchSubmit)', function(){
            getData();
            getModel();
            return false;
        });

        /**
         * 查询设备名称
         */
        $.ajax({
            url:"/equipment/findName",
            type:"post",
            dataType:"json",
            success:function (data) {
                var arr = data.nameList;
                var str ;
                for(var i= 0; i<arr.length; i++){
                    str +="<option value='"+arr[i].name+"'>"+arr[i].name+"</option>";
                }
                $("#modelNames").html(str);
                form.render("select");
            }
        });

        form.on('select(modelNames)',function (data) {
           name = data.value;//拿到选择的设备名
            $.ajax({
                url:"/equipment/findModelNumber",
                type:"post",
                dataType:"json",
                data:{
                    name:name
                },
                success:function (data) {
                    var modelNumberList = data.modelNumberList;
                    var str;
                        for(var i = 0 ; i<modelNumberList.length; i++){
                            str +="<option value='"+modelNumberList[i].model_Number+"'>"+modelNumberList[i].model_Number+"</option>";
                    };
                    $("#modelNumbers").html(str);
                    form.render("select");
                }
            });
        });
        form.on('select(modelNumbers)',function (data) {
            model_Number = data.value;
        })
    });
});
function getData(){
        var myChart = echarts.init(document.getElementById('main'));
        myChart.showLoading();
        var data1 = [];
        var data2 = [];
        var data3 = [];
        var times = [];
        var time = [];
        var i;
        $.ajax({
            url:"/display/getExcel",
            type:"get",
            data : {},
            dataType:"json",
            contentType :"application/x-www-form-urlencoded",
            async : false,
            success:function (data) {
                var arr = data.list;
                for(i = 0; i<arr.length; i++){
                    data1.push(arr[i].key1);
                    data2.push(arr[i].key2);
                    data3.push(arr[i].key3);
                    times.push(i);
                }
            }
        });
        $.ajax({
            url:"/display/getTime",
            type:"get",
            data : {},
            dataType:"json",
            contentType :"application/x-www-form-urlencoded",
            async : false,
            success:function (data) {
                var arr =data.list;
                for(var i = 0; i<arr.length; i++){
                    time.push(arr[i].create_time);
                }
                if(sTime < time[0] && eTime > time[time.length-1]){
                    alert("您输入的时间不在范围内,请重新输入");
                    window.location.reload();
                }
            }
        });

        myChart.hideLoading();    //隐藏加载动画
        myChart.setOption({
            backgroundColor: '#FBFBFB',
            title: {
                text: '数据表'
            },
            tooltip: {
                trigger: 'axis'
            },
            legend: {
                data: ['X','Y','Z']
            },
            toolbox: {
                show: true,
                feature: {
                    mark: {show: true},
                    dataView: {show: true, readOnly: false},
                    magicType: {show: true, type: ['line', 'bar']},
                    restore: {show: true},
                    saveAsImage: {show: true}
                }
            },
            calculable: true,
            dataZoom : {
                show : true,
                realtime : true
                /*startValue: time[0], 	//拖拽条开始时间
                endValue: time[time.length-1],			//拖拽条结束时间*/
            },
            xAxis: [{
                axisLabel: {
                    rotate: 20,
                    interval: 0
                },
                axisLine: {
                    lineStyle: {
                        color: '#CECECE'
                    }
                },
                type: 'category',
                boundaryGap: false,
                data: times
            }],
            yAxis: [{
                axisLine: {
                    lineStyle: {
                        color: '#CECECE'
                    }
                },
                type: 'value',
                axisLabel: {
                    formatter: '{value}'
                }
            }],
            series: [
                {
                    name: 'X',
                    type: 'line',
                    data: data1,
                    markPoint: {
                        data: [
                            {type: 'max', name: '最大值'},
                            {type: 'min', name: '最小值'}
                        ]
                    },
                    markLine: {
                        data: [
                            {type: 'average', name: '平均值'}
                        ]
                    }
                },
                {
                    name: 'Y',
                    type: 'line',
                    data: data2,
                    markPoint: {
                        data: [
                            {type: 'max', name: '最大值'},
                            {type: 'min', name: '最小值'}
                        ]
                    },
                    markLine: {
                        data: [
                            {type: 'average', name: '平均值'}
                        ]
                    }
                },
                {
                    name: 'Z',
                    type: 'line',
                    data: data3,
                    markPoint: {
                        data: [
                            {type: 'max', name: '最大值'},
                            {type: 'min', name: '最小值'}
                        ]
                    },
                    markLine: {
                        data: [
                            {type: 'average', name: '平均值'}
                        ]
                    }
                }
            ]
        });
    }
function getModel() {
    var myChart = echarts.init(document.getElementById('demo'));
    myChart.showLoading();
    var pressure = [];//压力
    var force_value = []; //力值
    var length = []; //长度
    var degree_centigrade= [];//摄氏度
    var speed = [];//速度
    var time = [];
    $.ajax({
        url:"/equipment/selectModelNameAndNumber",
        type:"post",
        dataType:"json",
        data:{
            name:name,
            model_Number:model_Number
        },
        contentType :"application/x-www-form-urlencoded",
        async : false,
        success:function (data) {
            var arr = data.modelNameAndNumberList;
            if(arr[0] == null){
                alert("数据为空！！")
            } else {
                for(var i=0; i<arr.length; i++){
                    pressure.push(arr[i].key4);
                    force_value.push(arr[i].key5);
                    length.push(arr[i].key6);
                    degree_centigrade.push(arr[i].key7);
                    speed.push(arr[i].key8);
                    time.push(i);
                }
            }
        }
    });
    myChart.hideLoading();    //隐藏加载动画
    myChart.setOption({
        backgroundColor: '#FBFBFB',
        title: {
            text: '数据表'
        },
        tooltip: {
            trigger: 'axis'
        },
        legend: {
            data: ['压力','力值','长度','摄氏度','速度']
        },
        toolbox: {
            show: true,
            feature: {
                mark: {show: true},
                dataView: {show: true, readOnly: false},
                magicType: {show: true, type: ['line', 'bar']},
                restore: {show: true},
                saveAsImage: {show: true}
            }
        },
        calculable: true,
        dataZoom : {
            show : true,
            realtime : true
        },
        xAxis: [{
            axisLabel: {
                rotate: 20,
                interval: 0
            },
            axisLine: {
                lineStyle: {
                    color: '#CECECE'
                }
            },
            type: 'category',
            boundaryGap: false,
            data: time
        }],
        yAxis: [{
            axisLine: {
                lineStyle: {
                    color: '#CECECE'
                }
            },
            type: 'value',
            axisLabel: {
                formatter: '{value}'
            }
        }],
        series: [
            {
                name: '压力',
                type: 'line',
                data: pressure,
                markPoint: {
                    data: [
                        {type: 'max', name: '最大值'},
                        {type: 'min', name: '最小值'}
                    ]
                },
                markLine: {
                    data: [
                        {type: 'average', name: '平均值'}
                    ]
                }
            },
            {
                name: '力值',
                type: 'line',
                data: force_value,
                markPoint: {
                    data: [
                        {type: 'max', name: '最大值'},
                        {type: 'min', name: '最小值'}
                    ]
                },
                markLine: {
                    data: [
                        {type: 'average', name: '平均值'}
                    ]
                }
            },
            {
                name: '长度',
                type: 'line',
                data: length,
                markPoint: {
                    data: [
                        {type: 'max', name: '最大值'},
                        {type: 'min', name: '最小值'}
                    ]
                },
                markLine: {
                    data: [
                        {type: 'average', name: '平均值'}
                    ]
                }
            },
            {
                name: '摄氏度',
                type: 'line',
                data: degree_centigrade,
                markPoint: {
                    data: [
                        {type: 'max', name: '最大值'},
                        {type: 'min', name: '最小值'}
                    ]
                },
                markLine: {
                    data: [
                        {type: 'average', name: '平均值'}
                    ]
                }
            },
            {
                name: '速度',
                type: 'line',
                data: speed,
                markPoint: {
                    data: [
                        {type: 'max', name: '最大值'},
                        {type: 'min', name: '最小值'}
                    ]
                },
                markLine: {
                    data: [
                        {type: 'average', name: '平均值'}
                    ]
                }
            }
        ]
    });
}