$(function () {
	layui.use('table',function () {
		var table = layui.table,
			$ = layui.jquery,
			form = layui.form;
		tableIns = table.render({
			elem: '#demo'
			,url: '/equipment/findEquipment' //数据接口
			,page: true //开启分页
			,limit:5
			,limits:[5,10,15]
			,title:'设备信息列表'
			,cols: [[ //表头
				{field: 'id',"checkbox":true,  sort: true, fixed: 'left',width:'5%',align:'center'},
				{field: 'name', title: '设备名称', width:'15%'},
				{field: 'model_Number', title: '设备型号', width:'15%'},
				{field: 'factory_Number', title: '出厂编号', width:'15%'},
				{field: 'standard_Number', title: '标准编号', width:'15%'},
				{field: 'eq_time', align:'center',title: '采样时间',width:'20%', sort: true,templet:function(data){
						var times=data.eq_time;
						return zhuanTime(times);
					}},
				{field: 'canshu', title: '被核参数', width:'15%'}
				,{field: 'custom_Number', title: '自定义设备编号', width:'15%'}
			]]
		});

		table.on('row(demo)', function(obj){
			var data=obj.data;
			var timen=zhuanTime(data.eq_time);
			commonTime = timen.toLocaleString();
			$("#id").val(data.id);
			$("#name").val(data.name);
			$("#xinghao").val(data.model_Number);
			$("#chuchang").val(data.factory_Number);
			$("#biaozhun").val(data.standard_Number);
			$("#caiTime").val(commonTime);
			$("#canshu").val(data.canshu);
			$("#custom_Number").val(data.custom_Number);
		});
		form.on('submit(formbtn)',function (data) {
			formSubmit(data);
			return false;
		});
	});
	layui.use('laydate',function () {
		var laydate = layui.laydate;
		laydate.render({
			elem: '#eqtime'
			,format: 'yyyy-MM-dd HH:mm:ss' //可任意组合
			,type: 'datetime'
		});
	})

});

/**
 * 提交表单
 * @param obj
 * @returns {boolean}
 */
	function formSubmit(obj){
		$.ajax({
			url:'/equipment/addequip',
			type:'post',
			data:$("#add-form").serialize(),
			success:function (data) {
				if(data==1){
					layer.msg('操作成功', {icon: 1,offset:'150ox'});
					load(obj);
					layer.closeAll();
				}else if(data==0){
					layer.msg('操作失败', {icon: 2,offset:'150ox'});
				}
			}
		});
	}

function add(){
		layer.open({
			title:['设备添加', 'font-size:18px;'],
			type:1,
			resize:false,
			area: ['700px', '350px'],
			content:$("#add-user-form"),
			offset: '50px',
			end:function () {
				cleanShe();
			}
		});
}
	function del(obj){
		var id=$("#id").val();
		if(id != null){
			layer.confirm('确认删除这条记录吗?',{
				icon: 3, title:'提示',offset:'150px'
			},function () {
				$.post('/equipment/del',{id:id},function(data){
					if(data==1){
						layer.msg('删除成功', {icon: 1,offset:'150px'});
						load(obj);
						$("#id").val("");
						$("#name").val("");
						$("#xinghao").val("");
						$("#chuchang").val("");
						$("#biaozhun").val("");
						$("#caiTime").val("");
						$("#canshu").val("");
						$("#custom_Number").val("");
					}else{
						layer.msg('操作失败', {icon: 2,offset:'150px'});
					}
				});
			})
		}else {
			layer.msg('请选中删除信息', {icon: 2,offset:'150px'});
		}
	}

	function zhuanTime(data) {
		  var date = new Date(data);
		  var Y = date.getFullYear() + '-';
		  var M = (date.getMonth() + 1 < 10 ? '0' + (date.getMonth() + 1) : date.getMonth() + 1) + '-';
		  var D = (date.getDate() < 10 ? '0' + date.getDate() : date.getDate()) + ' ';
		  var h = (date.getHours() < 10 ? '0' + date.getHours() : date.getHours()) + ':';
		  var m = (date.getMinutes() < 10 ? '0' + date.getMinutes() : date.getMinutes()) + ':';
		  var s = (date.getSeconds() < 10 ? '0' + date.getSeconds() : date.getSeconds());
		  return Y + M + D + h + m + s
		}
//重新加载table
function load(){
	tableIns.reload({
		page: {
			curr:1
		}
	});
}
function cleanShe() {
	$("#name").val("");
	$("#model_Number").val("");
	$("#factory_Number").val("");
	$("#biaozhun").val("");
	$("#caiTime").val("");
	$("#canshu").val("");
	$("#custom_Number").val("");
}
