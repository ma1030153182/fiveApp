<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
	<% String path=request.getContextPath(); String basePath=request.getScheme()+ "://"+request.getServerName()+ ":"+request.getServerPort()+path+ "/"; %>

		<!DOCTYPE HTML>
		<html>

		<head>
			<base href="<%=basePath%>">

			<title>申请备件</title>
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
					<h3 class="panel-title">备件申请</h3>

				</div>
				<div class="panel-body">
					<!--内嵌面板-->

					<div class="panel panel-default">
						<div class="panel-heading">

							<!-- 按钮触发模态框 -->
							<!--<button class="btn btn-default add-cus" data-toggle="modal" data-target="#myModal">
								添加备件申请
							</button>
							 <!--按钮触发模态框--> 
							<button class="btn btn-default edit-cus " data-toggle="modal" data-target="#myModal2">
								申请此备件
							</button>
							<!--<button class="btn btn-default delete-cus" data-toggle="modal" data-target="#myModal3">
								删除客户
							</button>
							 按钮触发模态框 -->
							<div class="form-inline"  style="float: right;margin-right: 200px;">
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
						<table class="easyui-datagrid" id="dg" title="备件信息" style="width:800px;height:400px" pagination="true"
						 data-options="singleSelect:true,rownumbers:true,

				collapsible:true,

				url:'<%=basePath%>kuFangAction_queryBeijianAll',

				pageSize:10,
                 
			pageList:[ 5, 10, 15, 20 ],method:'get'">
							<thead>
								<tr>
							<th data-options="field:'beijianName',width:180 ,align:'center'" >备件名称</th>
							<th data-options="field:'beijianVersion',width:180,align:'center'">备件型号</th>
							<th data-options="field:'beijianPrice',width:180,align:'center'">备件价格</th>
							<th data-options="field:'beijianNumber',width:180,align:'center'">备件剩余数量</th>
							<!--<th data-options="field:'warnNumber',width:140,align:'center'">预警数量</th>
							<th data-options="field:'beijianState',width:140,align:'center'">备件状态</th>
									</tr>-->
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
												<input type="text" class="form-control  beijian-number " name="custom.customEmail" id="cusTel" value="" />
											</td>
										</tr>
										

									</table>

								</div>
								<div class="modal-footer">
									<button type="button" class="btn btn-default" data-dismiss="modal">关闭
									</button>
									<button type="button" class="btn btn-primary edit-custom">
										提交申请
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
						   								   
						    row = $('#dg').datagrid('getSelected');
						   
						  
	   	if(row)
	   	{
//	      	myurl = "<%=basePath%>personAction_updatePerson";
//	   	    $('#dlg').dialog('open').dialog('setTitle', '修改用户');
//	   	    $('#ff').form('load', row);
              $(".edit-cus").attr("data-target","#myModal2");
                $(".beijian-name").text(row.beijianName);
				$(".beijian-version").text(row.beijianVersion);
				$(".beijian-price").text(row.beijianPrice);
				
				
				
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
									 var beijiannumber=$.trim(beinumber);
									
//									 console.log(a);
									 $.ajax({

             type: "post",
           url: "WeiXiuAction_addBeijianApply",
            dataType: "json",
            data:{
            	"beijianApply.beijianId":beijianid,
            	
            	"beijianApply.beijianName":beijianName,
            	"beijianApply.beijianNumber":beijiannumber,
            	"beijianApply.beijianPrice":beijianPrice,
            	"beijianApply.beijianVersion":beijianversion
            	
            },

             success: function(data){
             	alert(data.info);
             	$(".beijian-number").val("");
				 $(".beijian-name").text("");
				$(".beijian-version").text("");
				$(".beijian-price").text("");
				
				
             	$("#myModal2").hide();
             	
             	

             }

             

    });
    							}
							);
//							结束
						})
					</script>
		
				</div>
			</div>

		</body>

		</html>