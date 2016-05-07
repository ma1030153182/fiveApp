<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
	<% String path=request.getContextPath(); String basePath=request.getScheme()+ "://"+request.getServerName()+ ":"+request.getServerPort()+path+ "/"; %>

		<!DOCTYPE HTML>
		<html>

		<head>
			<base href="<%=basePath%>">

			<title>管理申请</title>
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
					<h3 class="panel-title">备件申请信息</h3>

				</div>
				<div class="panel-body">
					<!--内嵌面板-->

					<div class="panel panel-default">
						<div class="panel-heading">

							<!-- 按钮触发模态框 -->
							<!--<button class="btn btn-default add-cus" data-toggle="modal" data-target="#myModal">
								通过申请并出库
							</button>-->
							<!-- 按钮触发模态框 -->
							<button class="btn btn-default pass " data-toggle="modal" data-target="#myModal12">
								 通过申请并出库
							</button>
							<button class="btn btn-default notpass" data-toggle="modal" data-target="#myModal13">
								不通过申请
							</button>
							
							
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
						<table class="easyui-datagrid" id="dgk"  style="width:1000px;height:400px" pagination="true"
						 data-options="singleSelect:true,rownumbers:true,

				collapsible:true,

				url:'<%=basePath%>kuFangAction_queryApplyAll',

				pageSize:10,
                 
			pageList:[ 5, 10, 15, 20 ],method:'get'">
							<thead>
								<tr>
									<th data-options="field:'beijianName',width:130 ,align : 'center', ">备件名字</th>
									<th data-options="field:'beijianNumber',width:130,align : 'center', ">申请数量</th>
									
									<th data-options="field:'applyManName',width:160,align:'center'">申请人</th>
									<th data-options="field:'beijianVersion',width:170,align:'center'">备件版本</th>
									<th data-options="field:'beijianPrice',width:140,align:'center'">备件单价</th>
									
									
									<th data-options="field:'applyTime',width:200,align:'center'">申请时间</th>
									
								</tr>
							</thead>
						</table>
					</div>

					

					<!-- 模态框（Modal） edit-->
					<div class="modal fade" id="myModal12" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
						<div class="modal-dialog">
							<div class="modal-content">
								<div class="modal-header">
									<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×
									</button>
									<h4 class="modal-title" id="myModalLabel">
               请修改客户信息
            </h4>
								</div>
								<div class="modal-body">

									您确定通过并出库吗？

								</div>
								<div class="modal-footer">
									<button type="button" class="btn btn-default" data-dismiss="modal">关闭
									</button>
									<button type="button" class="btn btn-primary surepass">
										我确定
									</button>
								</div>
							</div>
							<!-- /.modal-content -->
						</div>
						<!-- /.modal-dialog -->
					</div>
					<!-- /.modal -->
					<script>
						
						   
						   
						   
						   $(function(){ 
						   	var row;
						   	
						   	$(".pass").click(function(){
						   								   
						    row = $('#dgk').datagrid('getSelected');
						   
						  
	   	if(row)
	   	{

				
             	$("#myModal12").show();




	   	    
	   	}else{
	   		alert("请选择一行");
	   	   
	   	   $("#myModal12").hide();
	   	   $(".pass").attr("data-target","none");
	   	   
	   	}
						   		
						   	});
						   	
//						   	结束
							
							$(".surepass").click(
								function(){
									
									 var numbe=row.beijianNumber;
									 var beijianid=row.beijianId;
									 var applyId=row.applyId;
									 console.log(applyId);
									 console.log(beijianid);
									 $.ajax({

             type: "post",
           url: "kuFangAction_passApply",
            dataType: "json",
            data:{
            	"beijianApply.applyState":"已通过",
            	"beijianApply.applyId":applyId,
            	"beijian.beijianNumber":numbe,
            	"beijian.beijianId":beijianid
            	
            },

             success: function(data){
             	
				alert(data.info);
             	$("#myModal12").hide();
             		$('#dgk').datagrid('reload');
             	

             }

             

    });
    							}
							);
//							结束
						})
					</script>
					<!-- 模态框（Modal） -->
					<div class="modal fade" id="myModal13" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
						<div class="modal-dialog">
							<div class="modal-content">
								<div class="modal-header">
									<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×
									</button>
									<h4 class="modal-title" id="myModalLabel">
               请选择
            </h4>
								</div>
								<div class="modal-body">
									确定不予通过吗？
								</div>
								<div class="modal-footer">
									<button type="button" class="btn btn-default" data-dismiss="modal">关闭
									</button>
									<button type="button" class="btn btn-primary sure-delete">
										我确定
									</button>
								</div>
							</div>
							<!-- /.modal-content -->
						</div>
						<!-- /.modal-dialog -->
					</div>
					<!-- /.modal -->
					<script>
						
						   
						   $(function(){
						   	var row;
						   	
						   	$(".notpass").click(
						   		function(){
						   			var ro=$('#dgk').datagrid('getSelected');
						   			if(ro){
						   				
						   				row=ro;
						   				  $(".notpass").attr("data-target","#myModal13");
						   			}else{
						   				alert("请选择一行");   	   
	   	                             $("#myModal13").hide();
	   	                                   $(".notpass").attr("data-target","none");
						   				
						   			}
						   			
					   		}
						   	);
						   	
						   	
						   	
						   	$(".sure-delete").click(function(){
						   		 var numbe=row.beijianNumber;
									 var beijianid=row.beijianId;
									 var applyId=row.applyId;
						   						 $.ajax({

             type: "post",
           url: "kuFangAction_passApply",
            dataType: "json",
            data:{
            	"beijianApply.applyState":"不通过",
            	"beijianApply.applyId":applyId,
            	"beijian.beijianNumber":numbe,
            	"beijian.beijianId":beijianid
            	
            },

             success: function(data){
             	alert(data.info);
             	
				
             	$("#myModal13").hide();
             	$('#dgk').datagrid('reload');
             	

             }

             

    });
						   		
						   	});
						   });
						   
//						    $(function(){ 
//						   	var id=a;
//						   	$(".edit-cus").click(function(){
//						   								   
//						   var row = $('#dg').datagrid('getSelected');
					</script>
				</div>
			</div>

		</body>

		</html>