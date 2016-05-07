<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
	<% String path=request.getContextPath(); String basePath=request.getScheme()+ "://"+request.getServerName()+ ":"+request.getServerPort()+path+ "/"; %>

		<!DOCTYPE HTML>
		<html>

		<head>
			<base href="<%=basePath%>">

			<title>结算管理</title>
			<meta charset="utf-8">
			<meta http-equiv="pragma" content="no-cache">
			<meta http-equiv="cache-control" content="no-cache">
			<meta http-equiv="expires" content="0">
			<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
			<meta http-equiv="description" content="This is my page">
		<link rel="stylesheet" type="text/css" href="../../javascript/themes/bootstrap/easyui.css" />

			<link rel="stylesheet" type="text/css" href="../../javascript/themes/icon.css" />
			<link rel="stylesheet" type="text/css" href="../../javascript/bootstrap/css/bootstrap.css" />

			<link rel="stylesheet" href="../../css/main.css" />
			<link rel="stylesheet" href="../../css/kefu.css" />
			<script type="text/javascript" src="../../javascript/jquery-2.1.3.js"></script>
			<script type="text/javascript" src="../../javascript/jquery.easyui.min.js"></script>
			<script type="text/javascript" src="../../javascript/bootstrap/js/bootstrap.js"></script>
			<script type="text/javascript" src="../../javascript/my.js"></script>
		

		<body>
			<!--面板-->
			<div class="panel panel-primary">
				<div class="panel-heading">
					<h3 class="panel-title">已完成订单信息</h3>
					
				</div>
				<div class="panel-body">
					<!--内嵌面板-->
	
<div class="panel panel-default">
   <div class="panel-heading">
   	
   	
   		
   		<!-- 按钮触发模态框 -->
<button class="btn btn-default " data-toggle="modal" data-target="#myModal">
 去结算
</button>

<!-- 按钮触发模态框 -->
<form  class="form-inline"  action="" method="post" style="float: right;margin-right: 100px;">
<input type="text"class="form-control" name="" id="" value="" />
<input type="submit"class="btn btn-default" name="" id="" value="搜索" />

   	</form>





   </div>
<!--表格数据-->
   <table class="easyui-datagrid" id="dg" title="客户信息" style="width:900px;height:400px" pagination="true" data-options="singleSelect:true,rownumbers:true,

				collapsible:true,

				url:'<%=basePath%>keFuAction_queryAllCustom',

				pageSize:5,
                 
			pageList:[ 5, 10, 15, 20 ],method:'get'">
							<thead>
								<tr>
									<th data-options="field:'custom.customName',width:100">姓名</th>
									<th data-options="field:'custom.customIdCard',width:110">身份证号</th>
									<th data-options="field:'custom.customCompany',width:110,align:'right'">所在单位</th>
									<th data-options="field:'custom.customAddrass',width:100,align:'right'">住址</th>
									<th data-options="field:'custom.customEmail',width:110">座机号</th>
									<th data-options="field:'custom.customMabile',width:110,align:'center'">手机号</th>
									<th data-options="field:'custom.customPost',width:110,align:'center'">邮编号</th>
									<th data-options="field:'custom.customTel',width:100,align:'center'">Email</th>
								</tr>
							</thead>
						</table>
</div>



<!-- 模态框（Modal） -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" 
   aria-labelledby="myModalLabel" aria-hidden="true">
   <div class="modal-dialog">
      <div class="modal-content">
         <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" 
               aria-hidden="true">×
            </button>
            <h4 class="modal-title" id="myModalLabel">
               请填写客户信息
            </h4>
         </div>
         <div class="modal-body">
            <div class="modal-body">
							<form action="keFuAction_addCustom" method="post">
								<table class="table">

									<tr class="table-tr">

										<th>姓名:</th>
										<td>
											<input type="text" class="form-control   " name="custom.customName" id="" value="" />
										</td>
										<th>省份证号:</th>
										<td>
											<input type="text" class="form-control   " name="custom.customIdCard" id="" value="" />
										</td>
									</tr>
									<tr class="table-tr">
										<th>手机号:</th>
										<td>
											<input type="text" class="form-control   " name="custom.customMabile" id="" value="" />
										</td>
										<th>座机号:</th>
										<td>
											<input type="text" class="form-control   " name="custom.customEmail" id="" value="" />
										</td>
									</tr>
									<tr class="table-tr">
										<th>邮编:</th>
										<td>
											<input type="text" class="form-control   " name="custom.customPost" id="" value="" />
										</td>
										<th>Email:</th>
										<td>
											<input type="text" class="form-control   " name="custom.customEmail" id="" value="" />
										</td>
									</tr>
									<tr class="table-tr">
										<th>地址:</th>
										<td>
											<input type="text" class="form-control   " name="custom.customAddrass" id="" value="" />
										</td>
										<th>公司:</th>
										<td>
											<input type="text" class="form-control   " name="custom.customCompany" id="" value="" />
										</td>
									</tr>

								</table>
								
								</form>
						</div>
         </div>
         <div class="modal-footer">
            <button type="button" class="btn btn-default" 
               data-dismiss="modal">关闭
            </button>
            <button type="button" class="btn btn-primary">
               提交更改
            </button>
         </div>
      </div><!-- /.modal-content -->
   </div><!-- /.modal-dialog -->
</div><!-- /.modal -->
<script>
   $(function () { $('#myModal').modal({
      keyboard: true
   })});
</script>
<!-- 模态框（Modal） edit-->
<div class="modal fade" id="myModal2" tabindex="-1" role="dialog" 
   aria-labelledby="myModalLabel" aria-hidden="true">
   <div class="modal-dialog">
      <div class="modal-content">
         <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" 
               aria-hidden="true">×
            </button>
            <h4 class="modal-title" id="myModalLabel">
               请修改客户信息
            </h4>
         </div>
         <div class="modal-body">
								<form action="" method="post">
									<table class="table">

									<tr class="table-tr">

										<th>姓名:</th>
										<td>
											<input type="text" class="form-control   " name="custom.customName" id="" value="" />
										</td>
										<th>省份证号:</th>
										<td>
											<input type="text" class="form-control   " name="custom.customIdCard" id="" value="" />
										</td>
									</tr>
									<tr class="table-tr">
										<th>手机号:</th>
										<td>
											<input type="text" class="form-control   " name="custom.customMabile" id="" value="" />
										</td>
										<th>座机号:</th>
										<td>
											<input type="text" class="form-control   " name="custom.customEmail" id="" value="" />
										</td>
									</tr>
									<tr class="table-tr">
										<th>邮编:</th>
										<td>
											<input type="text" class="form-control   " name="custom.customPost" id="" value="" />
										</td>
										<th>Email:</th>
										<td>
											<input type="text" class="form-control   " name="custom.customEmail" id="" value="" />
										</td>
									</tr>
									<tr class="table-tr">
										<th>地址:</th>
										<td>
											<input type="text" class="form-control   " name="custom.customAddrass" id="" value="" />
										</td>
										<th>公司:</th>
										<td>
											<input type="text" class="form-control   " name="custom.customCompany" id="" value="" />
										</td>
									</tr>

								</table>

									
								</form>

							</div>
         <div class="modal-footer">
            <button type="button" class="btn btn-default" 
               data-dismiss="modal">关闭
            </button>
            <button type="button" class="btn btn-primary">
               提交更改
            </button>
         </div>
      </div><!-- /.modal-content -->
   </div><!-- /.modal-dialog -->
</div><!-- /.modal -->
<script>
   $(function () { $('#myModal').modal({
      keyboard: true
   })});
</script>
<!-- 模态框（Modal） -->
<div class="modal fade" id="myModal3" tabindex="-1" role="dialog" 
   aria-labelledby="myModalLabel" aria-hidden="true">
   <div class="modal-dialog">
      <div class="modal-content">
         <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" 
               aria-hidden="true">×
            </button>
            <h4 class="modal-title" id="myModalLabel">
               请选择
            </h4>
         </div>
         <div class="modal-body">
       确定要删除客户信息吗？
         </div>
         <div class="modal-footer">
            <button type="button" class="btn btn-default" 
               data-dismiss="modal">关闭
            </button>
            <button type="button" class="btn btn-primary">
               我确定
            </button>
         </div>
      </div><!-- /.modal-content -->
   </div><!-- /.modal-dialog -->
</div><!-- /.modal -->
<script>
   $(function () { $('#myModal').modal({
      keyboard: true
   })});
</script>
				</div>
				</div>
				
				
				
		</body>

		</html>