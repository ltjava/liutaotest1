<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="layui/css/layui.css">
</head>
<body>
	<script type="text/html" id="barDemo">
  <a class="layui-btn layui-btn-warm" lay-event="edit">编辑</a>
  <a class="layui-btn layui-btn-warm" lay-event="remove">删除</a>
</script>
	<script src="layui/layui.js"></script>
	<!-- 添加对话框 -->
	<script type="text/javascript" id="add-dialog">
		<form class="layui-form" action="" lay-filter="add-form">
		<div class="layui-form-item">
		<label class="layui-form-label">学生姓名</label>
		<div class="layui-input-block">
		<input type="text" name="name" required lay-verify="required" placeholder="请输入学生姓名" class="layui-input">
		</div>
		</div>
		<div class="layui-form-item">
		<label class="layui-form-label">学生年龄</label>
		<div class="layui-input-block">
		<input type="text" name="age" required lay-verify="required" placeholder="请输入学生年龄" class="layui-input">
		</div>
		</div>
		<div class="layui-form-item">
		<div class="layui-input-block">
		<button class="layui-btn" lay-submit lay-filter="but-add-submit">保存</button>
		<button type="reset" class="layui-btn layui-btn-primary" >重置</button>
		</div>
		</div>
		</form>
	</script>
	
	<!-- 修改对话框-->
	<script type="text/javascript" id="edit-dialog">
		<form class="layui-form" action="" lay-filter="edit-form">
		<div class="layui-form-item">
		<label class="layui-form-label">学生姓名</label>
		<div class="layui-input-block">
		<input type="hidden" name="id" class="layui-input" >
		<input type="text" name="name" required lay-verify="required" placeholder="请输入学生姓名" class="layui-input">
		
		</div>
		</div>
		<div class="layui-form-item">
		<label class="layui-form-label">学生年龄</label>
		<div class="layui-input-block">
		<input type="text" name="age" required lay-verify="required" placeholder="请输入学生年龄" class="layui-input">
		</div>
		</div>
		
		<div class="layui-form-item">
		<div class="layui-input-block">
		<button class="layui-btn" lay-submit lay-filter="but-edit-submit">保存</button>
		<button type="reset" class="layui-btn layui-btn-primary" >重置</button>
		</div>
		</div>
		</form>
	</script>

	<script type="text/javascript">
		layui.use([ 'layer', 'form', 'table','jquery' ], function() {
			var table = layui.table
			var layer = layui.layer
			var form = layui.form
			var $ = layui.jquery
			
			//批量删除
			$("#but-removeBatch").click(function(){
				var array= table.checkStatus('demo').data;
				if(array.length == 0){
					layer.msg('请选择要删除的记录');
				}else{
					var ids=[];
					for(var i in array){
						ids.push(array[i].id);
					}
					$.post('student/removeBatch',{
						"ids[]": ids
					},function(flag){
						if(flag){
							layer.msg('操作成功', {
								icon : 6
							});
							table.reload('demo', {});
						}else{
							layer.msg('操作失败', {
								icon : 5
							});
						}
					})
				}
			})
			
			//添加学生
			$("#but-add").click(function(){
				layer.open({ //定义一个对话框
					type : 1,
					title : '添加学生信息',
					content : $("#add-dialog").html(),
					area : [ '500px' ]
				})
				form.on('submit(but-add-submit)', function(data) {
						$.post('student/save', data.field, function(flag) {
							if (flag) {
								layer.msg('操作成功', {
									icon : 6
								});
								layer.closeAll();
								table.reload('demo', {});
							} else {
								layer.msg('操作失败', {
									icon : 5
								});
							}
						})
						return false;
					})
			})
			
			//条件查询
			$("#but-search").click(function(){
				table.reload('demo',{
					where: {
						name: $("#name").val()
					}
				})
			})
			
			table.render({
				elem : '#demo',
				url : 'student/listPage',
				page : true,
				title : '学生表',
				cols : [ [ {
					field : 'id',
					title : 'ID',
					checkbox : true 
				}, {
					field : 'name',
					title : '姓名'
				}, {
					field : 'age',
					title : '年龄'
				}, {
					toolbar : '#barDemo',
					title : '操作'
				} ] ]
			});
			
			//编辑
			table.on('tool(test)', function(obj) {
				if (obj.event == 'edit') {
					layer.open({ //定义一个对话框
						type : 1,
						title : '修改学生信息',
						content : $("#edit-dialog").html(),
						area : [ '500px' ]
					})
					//填充表单
					form.val('edit-form', {
						name : obj.data.name,
						age : obj.data.age,
						id : obj.data.id
					})
						
					form.on('submit(but-edit-submit)', function(data) {
						$.post('student/update', data.field, function(flag) {
							
							if (flag) {
								layer.msg('操作成功', {
									icon : 6
								});
								layer.closeAll();
								table.reload('demo', {});
							} else {
								layer.msg('操作失败', {
									icon : 5
								});
							}
						})
						return false;
					})
					//删除一条
				} else if (obj.event == 'remove') {
					layer.confirm('你确定删除吗，删除后数据不能恢复', {
						icon : 3,
						title : '信息'
					}, function(index) {
						$.post('student/remove', {
							id : obj.data.id
						}, function(flag) {
							if (flag) {
								table.reload('demo', {});
								layer.msg('操作成功', {
									icon : 6
								});
							} else {
								layer.msg('操作失败', {
									icon : 5
								});
							}
						})
					});
				}
			})

		})
	</script>
	<div class="demoTable">
		学生名字
		<div class="layui-inline">
			<input class="layui-input" id="name" />
		</div>
		<button class="layui-btn" id="but-search">
			<i class="layui-icon">&#xe615;</i>搜索
		</button>
		<button class="layui-btn layui-btn-normal" id="but-add">
			<i class="layui-icon">&#xe654;</i>添加
		</button>
		<button class="layui-btn layui-btn-danger" id="but-removeBatch">
			<i class="layui-icon">&#xe640;</i>批量删除
		</button>
	</div>
	<table id="demo" lay-filter="test"></table>
</body>
</html>