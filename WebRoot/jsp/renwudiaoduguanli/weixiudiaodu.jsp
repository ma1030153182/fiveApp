<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
	<% String path=request.getContextPath(); String basePath=request.getScheme()+ "://"+request.getServerName()+ ":"+request.getServerPort()+path+ "/"; %>

		<!DOCTYPE HTML>
		<html>

		<head>
			<base href="<%=basePath%>">

			<title>调度管理</title>
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
					<h3 class="panel-title">调度管理</h3>

				</div>
				<div class="panel-body">
					<!--内嵌面板-->

					<div class="panel panel-default">
						<div class="panel-heading">

							<!-- 按钮触发模态框 -->
							<!--<button class="btn btn-default add-cus" data-toggle="modal" data-target="#myModal">
								添加客户
							</button>-->
							<!-- 按钮触发模态框 -->
							<button class="btn btn-default edit-cus " data-toggle="modal" data-target="#myModal2">
								分配维修师
							</button>
							<!--<button class="btn btn-default delete-cus" data-toggle="modal" data-target="#myModal3">
								删除客户
							</button>-->
							<!-- 按钮触发模态框 -->
							<div class="form-inline"  style="float: right;margin-right: 100px;">
								<input type="text" class="form-control s-int" name="" id="" value="" />
								<button type="button" class="btn btn-default cus-search" onclick="doSearch()">搜索</button>
								<!--<button type="button" class="btn btn-default cus-search" name="" id="" value="搜索"onclick="doSearch()" />-->
								<script type="text/javascript">  
								
								
    function doSearch(){ //用户输入用户名,点击搜素,触发此函数  
    	var value=$(".s-int").val();
        $("#dg").datagrid({  
            
            width:1000,  
            pageSize:10,  
            pageList:[5,10,15,20],  
            nowrap:true,  
           
            collapsible:true,  
            
            url:'keFuAction_queryAllCustomBy?search='+value, //触发此action,带上参数searcValue  
            loadMsg:'数据加载中......',  
            
            sortName:'userId',  
            sortOrder:'asc',  
            remoteSort:false,  
            
            pagination : true,  
            rownumbers : true  
        })  
    }  
      
</script>  

							</div>

						</div>
						<!--表格数据-->
						<table class="easyui-datagrid" id="dt" title="调度信息" style="width:1000px;height:400px" pagination="true"
						 data-options="singleSelect:true,rownumbers:true,

				collapsible:true,

				url:'<%=basePath%>diaoDuAction_queryAllReportRepair',

				pageSize:10,
                 
			pageList:[ 5, 10, 15, 20 ],method:'get'">
							<thead>
								<tr>
								<th data-options="field:'customName',width:110 ,align : 'center', ">顾客姓名</th>
									<th data-options="field:'productType',width:110,align : 'center', ">产品类型</th>
									<th data-options="field:'customProperties',width:110,align:'center'">顾客性质</th>
									<th data-options="field:'machineBrand',width:110,align:'center'">设备品牌</th>
									<th data-options="field:'machineVersion',width:120">设备版本号</th>
									<th data-options="field:'machineBugPhenomenon',width:140,align:'center'">故障问题现象</th>
									<th data-options="field:'customSentTime',width:120,align:'center'">送修时间</th>
									<th data-options="field:'kefuName',width:110,align:'center'">接待员</th>
									</tr>
							</thead>
						</table>
					</div>

					

					<!-- 模态框（Modal） edit-->
					<div class="modal fade" id="myModal2" tabindex="-1" role="dialog"  aria-labelledby="myModalLabel" aria-hidden="true">
						<div class="modal-dialog">
							<div class="modal-content" style="width: 850px;">
								<div class="modal-header">
									<button type="button" class="btn btn-default"  style="float: right; margin-right: 10px;" data-dismiss="modal">关闭
									</button>
									<button type="button"style="float: right; margin-right: 10px;" class="btn btn-primary selectit">
										确定分配任务
									</button>
									<h4 class="modal-title" id="myModalLabel" >
               请刷新选择维修师
            </h4>            
								</div>
								<div class="modal-body">

									<table class="easyui-datagrid" id="db" title="维修师信息" style="width:820px;height:220px" pagination="true"
						 data-options="singleSelect:true,rownumbers:true,

				collapsible:true,

				url:'<%=basePath%>WeiXiuAction_tongjiWeixiushiGongzuo',

				pageSize:5,
                 
			pageList:[ 5, 10, 15, 20 ],method:'get'">
							<thead>
								<tr>
								 <th data-options="field:'empName',width:130 ,align : 'center', ">维修师姓名</th>
									<th data-options="field:'goodAt',width:130,align : 'center', ">擅长领域</th>
									<th data-options="field:'workNumber',width:130,align:'center'">正在维修的数量</th>
									<th data-options="field:'empAddrass',width:130,align:'center'">维修师住址</th>
									<th data-options="field:'empMobile',width:130, align:'center'">维修师手机号</th>
									<th data-options="field:'empEmail',width:130 ,align:'center'">email</th>
									</tr>
							</thead>
						</table>

								</div>
								<!--<div class="modal-footer">-->
									
								<!--</div>-->
							</div>
							<!-- /.modal-content -->
						</div>
						<!-- /.modal-dialog -->
					</div>
					<!-- /.modal -->
					<script>
						   
						   $(function(){ 
						   	var rowdt;
						   	$(".edit-cus").click(function(){
						   								   
						   rowdt = $('#dt').datagrid('getSelected');
						  
	   	if(rowdt)
	   	{
//	      	myurl = "<%=basePath%>personAction_updatePerson";
//	   	    $('#dlg').dialog('open').dialog('setTitle', '修改用户');
//	   	    $('#ff').form('load', row);
              $(".edit-cus").attr("data-target","#myModal2");
    			
             	$("#myModal2").show();
   	              $('#db').datagrid('reload');
	   	}else{
	   		alert("请选择一行");
	   	   
	   	   $("#myModal2").hide();
	   	   $(".edit-cus").attr("data-target","none");
	   	   
	   	}
						   		
						   	});
						   	
//						   	结束
							
							$(".selectit").click(
								function(){
									   var rowdb= $('#db').datagrid('getSelected');
						  
	   	if(rowdb)
	   	{

              $.ajax({

             type: "post",
           url: "diaoDuAction_fenpeiWeixiushi",
            dataType: "json",
            data:{
            	"reportRepair.reportRepairId":rowdt.reportRepairId,
            
            	"repair.empRepairmanId":rowdb.empId,
            	"repair.repairManName":rowdb.empName,
            	"repair.reportRepairId":rowdt.reportRepairId
            	
            	
            },

             success: function(data){
             		$('#dt').datagrid('reload');
             	alert(data.info);
             	
				
             	
             	$("#myModal2").hide();
             
             	

             }

             

    });
             	
   	    
	   	}else{
	   		alert("请选择一行");
	   	   
	   	  
	   	   
	   	}
								
    							}
							);
//							结束
						})
					</script>
			
				</div>
			</div>

		</body>

		</html>