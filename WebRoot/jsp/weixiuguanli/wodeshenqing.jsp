<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
	<% String path=request.getContextPath(); String basePath=request.getScheme()+ "://"+request.getServerName()+ ":"+request.getServerPort()+path+ "/"; %>

		<!DOCTYPE HTML>
		<html>

		<head>
			<base href="<%=basePath%>">

			<title>我的申请</title>
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
					<h3 class="panel-title">我的申请</h3>

				</div>
				<div class="panel-body">
					<!--内嵌面板-->

					<div class="panel panel-default">
						<div class="panel-heading">

							
							<!--<button class="btn btn-default add-cus" data-toggle="modal" data-target="#myModal">
								添加客户
							</button>
							<!-- 按钮触发模态框 -->
							<button class="btn btn-default edit-cus " data-toggle="modal" data-target="#myModal2">
								修改申请
							</button>
							<button class="btn btn-default delete-cus" data-toggle="modal" data-target="#myModal3">
								删除申请
							</button>
							<button class="btn btn-default receive" data-toggle="modal" data-target="#myModal4">
								确定已收到备件
							</button>
							<!-- 按钮触发模态框 -->
							<div class="form-inline"  style="float: right;margin-right: 100px;">
								<input type="text" class="form-control s-int" name="" id="" value="" />
								<button type="button" class="btn btn-default cus-search" onclick="doSearch()">搜索</button>
								<!--<button type="button" class="btn btn-default cus-search" name="" id="" value="搜索"onclick="doSearch()" />-->
								<script type="text/javascript">  
								
								
    function doSearch(){ //用户输入用户名,点击搜素,触发此函数  
    	var value=$(".s-int").val();
        $("#ff").datagrid({  
            
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
						<table class="easyui-datagrid" id="ff" title="我申请的备件" style="width:1000px;height:400px" pagination="true"
						 data-options="singleSelect:true,rownumbers:true,

				collapsible:true,

				url:'<%=basePath%>WeiXiuAction_queryBeijianApply',

				pageSize:10,
                 
			pageList:[ 5, 10, 15, 20 ],method:'get'">
							<thead>
								<tr>
									<th data-options="field:'beijianName',width:120 ,align : 'center', ">备件名字</th>
									<th data-options="field:'beijianNumber',width:120,align : 'center', ">申请数量</th>
									
									
									<th data-options="field:'beijianVersion',width:150,align:'center'">备件版本</th>
									<th data-options="field:'beijianPrice',width:120,align:'center'">备件单价</th>
									
									
									<th data-options="field:'applyTime',width:150,align:'center'">申请时间</th>
									
									<th data-options="field:'applyState',width:120,align:'center'">申请状态</th>
									
								</tr>
							</thead>
						</table>
					</div>

				

						<!-- 模态框（Modal） edit-->
					<div class="modal fade" id="myModal2" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
						<div class="modal-dialog">
							<div class="modal-content">
								<div class="modal-header">
									<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×
									</button>
									<h4 class="modal-title" id="myModalLabel">
               请填写申请备件的数量
            </h4>
								</div>
								<div class="modal-body">

									<table class="table">

										<tr class="table-tr">

											<th>备件名称:</th>
											<td class="beijian-name">
												
											</td>
											<th>备件版本号:</th>
											
												<td class="beijian-version">
												
											
											</td>
										</tr>
										<tr class="table-tr">
											<th>备件单价:</th>
											<td class="beijian-price">
												
											</td>
											<th>申请备件的数量:</th>
											<td>
												<input type="text" class="form-control  beijian-number " name="custom.customEmail" id="cusTel" value="" required="required"/>
											</td>
										</tr>
										

									</table>

								</div>
								<div class="modal-footer">
									<button type="button" class="btn btn-default" data-dismiss="modal">关闭
									</button>
									<button type="button" class="btn btn-primary edit-custom">
										提交更改
									</button>
								</div>
							</div>
							<!-- /.modal-content -->
						</div>
						<!-- /.modal-dialog -->
					</div>
					<!-- /.modal -->
					<script>
						$(function () { $('#myModal').modal({
						      keyboard: true
						   })});
						   
						   
						   
						   $(function(){ 
						   
						   	var row;
						   	$(".edit-cus").click(function(){
						   								   
						    row = $('#ff').datagrid('getSelected');
						   
						  
	   	if(row)
	   	{
//	      	myurl = "<%=basePath%>personAction_updatePerson";
//	   	    $('#dlg').dialog('open').dialog('setTitle', '修改用户');
//	   	    $('#ff').form('load', row);
              $(".edit-cus").attr("data-target","#myModal2");
                $(".beijian-name").text(row.beijianName);
				$(".beijian-version").text(row.beijianVersion);
				$(".beijian-price").text(row.beijianPrice);
				$(".beijian-number").val(row.beijianNumber);
				
				
             	$("#myModal2").show();




	   	    
	   	}else{
	   		alert("请选择一行");
	   	   
	   	   $("#myModal2").hide();
	   	   $(".edit-cus").attr("data-target","none");
	   	   
	   	}
						   		
						   	});
						   	
//						   	结束
							
							$(".edit-custom").click(
								function(){
									var beijianid=row.beijianId;
									var beinumber=$(".beijian-number").val();
									var beijianversion=row.beijianVersion;
									var beijianName=row.beijianName;
									var beijianPrice=row.beijianPrice;
									 var applyId=row.applyId;
									 var beijiannumber=$.trim(beinumber);
//									 console.log(a);
									 $.ajax({

             type: "post",
           url: "WeiXiuAction_editBeiJianApply",
            dataType: "json",
            data:{
            	"beijianApply.applyId":applyId,
            	"beijianApply.beijianId":beijianid,
            	
            	"beijianApply.beijianName":beijianName,
            	"beijianApply.beijianNumber":beijiannumber,
            	"beijianApply.beijianPrice":beijianPrice,
            	"beijianApply.beijianVersion":beijianversion
            	
            },

             success: function(data){
             	alert(data.info);
             	$(".beijian-number").val("");
				
				
             	$("#myModal2").hide();
             	$('#ff').datagrid('reload');
             	

             }

             

    });
    							}
							);
//							结束
						})
					</script>
		
					<!-- 模态框（Modal） -->
					<div class="modal fade" id="myModal3" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
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
									确定要删除客户信息吗？
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
						   	
						   	$(".delete-cus").click(
						   		function(){
						   			var ro=$('#ff').datagrid('getSelected');
						   			if(ro){
						   				
						   				row=ro;
						   				  $(".delete-cus").attr("data-target","#myModal3");
						   			}else{
						   				alert("请选择一行");   	   
	   	                             $("#myModal3").hide();
	   	                                   $(".delete-cus").attr("data-target","none");
						   				
						   			}
						   			
					   		}
						   	);
						   	
						   	
						   	
						   	$(".sure-delete").click(function(){
						   		var beijianid=row.beijianId;
									var beijiannumber=$(".beijian-number").val();
									var beijianversion=row.beijianVersion;
									var beijianName=row.beijianName;
									var beijianPrice=row.beijianPrice;
						   		 var applyId=row.applyId;
						   						 $.ajax({

             type: "post",
           url: "WeiXiuAction_DeleteBeiJianApply",
            dataType: "json",
            data:{
            	"beijianApply.beijianId":beijianid,
            	
            	"beijianApply.beijianName":beijianName,
            	"beijianApply.beijianNumber":beijiannumber,
            	"beijianApply.beijianPrice":beijianPrice,
            	"beijianApply.beijianVersion":beijianversion,
            	"beijianApply.applyId":applyId
            },

             success: function(data){
             	alert(data.info);
             	
				
             	$("#myModal3").hide();
             	$('#ff').datagrid('reload');
             	

             }

             

    });
						   		
						   	});
						   });
						   
//						    $(function(){ 
//						   	var id=a;
//						   	$(".edit-cus").click(function(){
//						   								   
//						   var row = $('#ff').datagrid('getSelected');
					</script>
					
					<!-- 模态框（Modal） -->
					<div class="modal fade" id="myModal4" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
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
									确定已经收到备件吗？
								</div>
								<div class="modal-footer">
									<button type="button" class="btn btn-default" data-dismiss="modal">关闭
									</button>
									<button type="button" class="btn btn-primary sure-receive">
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
						$(function () { $('#myModal').modal({
						      keyboard: true
						   })});
						   
						   $(function(){
						   	var row;
						   	
						   	$(".receive").click(
						   		function(){
						   			var ro=$('#ff').datagrid('getSelected');
						   			if(ro){
						   				
						   				row=ro;
						   				  $(".delete-cus").attr("data-target","#myModal4");
						   			}else{
						   				alert("请选择一行");   	   
	   	                             $("#myModal4").hide();
	   	                                   $(".delete-cus").attr("data-target","none");
						   				
						   			}
						   			
					   		}
						   	);
						   	
						   	
						   	
						   	$(".sure-receive").click(function(){
						   		var beijianid=row.beijianId;
									var beijiannumber=$(".beijian-number").val();
									var beijianversion=row.beijianVersion;
									var beijianName=row.beijianName;
									var beijianPrice=row.beijianPrice;
						   		 var applyId=row.applyId;
						   						 $.ajax({

             type: "post",
           url: "WeiXiuAction_sureBeijianApply",
            dataType: "json",
            data:{
            	"beijianApply.beijianId":beijianid,
            	"beijianApply.applyId":applyId,
            	"beijianApply.beijianName":beijianName,
            	"beijianApply.beijianNumber":beijiannumber,
            	"beijianApply.beijianPrice":beijianPrice,
            	"beijianApply.beijianVersion":beijianversion,
            	"beijianApply.applyState":"已收货"
            },

             success: function(data){
             	alert(data.info);
             	
				
             	$("#myModal4").hide();
             	$('#ff').datagrid('reload');
             	

             }

             

    });
						   		
						   	});
						   });
						   
//						    $(function(){ 
//						   	var id=a;
//						   	$(".edit-cus").click(function(){
//						   								   
//						   var row = $('#ff').datagrid('getSelected');
					</script>
				</div>
			</div>

		</body>

		</html>