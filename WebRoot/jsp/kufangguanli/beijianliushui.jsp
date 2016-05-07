<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
	<% String path=request.getContextPath(); String basePath=request.getScheme()+ "://"+request.getServerName()+ ":"+request.getServerPort()+path+ "/"; %>

		<!DOCTYPE HTML>
		<html>

		<head>
			<base href="<%=basePath%>">

			<title>备件流水</title>
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
		</head>

		<body>
			<!--面板-->
			<div class="panel panel-primary out-pane">
				<div class="panel-heading">
					<h3 class="panel-title">备件流水情况</h3>

				</div>
				<div class="panel-body">
					<!--内嵌面板-->

					<!--<div class="panel panel-default">
						<div class="panel-heading">

							

							</div>

						</div>-->
						<!--表格数据-->
						<table class="easyui-datagrid" id="dg"  style="width:1000px;height:400px" pagination="true"
						 data-options="singleSelect:true,rownumbers:true,

				collapsible:true,

				url:'<%=basePath%>kuFangAction_queryApplyComplete',

				pageSize:10,
                 
			pageList:[ 5, 10, 15, 20 ],method:'get'">
							<thead>
								<tr>
									<th data-options="field:'beijianName',width:130 ,align : 'center', ">备件名字</th>
									<th data-options="field:'beijianNumber',width:130,align : 'center', ">流出数量</th>
									<th data-options="field:'applyManName',width:130,align:'center'">申请人</th>
									<th data-options="field:'applyPassManName',width:130,align:'center'">审批人员</th>
									<th data-options="field:'beijianVersion',width:130 ,align : 'center', ">备件版本</th>
									<th data-options="field:'applyPassTime',width:130,align : 'center', ">流出时间</th>
									<th data-options="field:'beijianPrice',width:130,align : 'center', ">单价</th>
									
									
								</tr>
							</thead>
						</table>
					</div>
</div>
					

		</body>

		</html>