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

    var myChart = echarts.init(document.getElementById('main'));
   $.ajax({
       url:"display/getExcel",
       type:"get",
       success:function (data) {
           var myData=[];
           var myTemp;
           for(var i=0; i<myData.length; i++){
               myTemp={value:data[i]};
               myData.push(myTemp);
           }
           myChart.setOption({
               series: [{
                   data:myData
               }]
           })
       }
   });
    var option = {
        backgroundColor: '#FBFBFB',
        title: {
            text: '数据表'
        },
        tooltip: {
            trigger: 'axis'
        },
        legend: {
            data: ['数据']
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
        xAxis: [{
            axisLabel: {
                rotate: 30,
                interval: 0
            },
            axisLine: {
                lineStyle: {
                    color: '#CECECE'
                }
            },
                type: 'category',
                boundaryGap: false,
                data: ['0', '1', '2']
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
                name: '数据',
                type: 'line',
                data: [],
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
    };
    // 初次加载图表(无数据)
    myChart.setOption(option);
})
