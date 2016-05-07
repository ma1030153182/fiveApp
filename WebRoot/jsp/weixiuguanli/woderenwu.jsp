<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
	<% String path=request.getContextPath(); String basePath=request.getScheme()+ "://"+request.getServerName()+ ":"+request.getServerPort()+path+ "/"; %>

		<!DOCTYPE HTML>
		<html>
	

		<head>
			<base href="<%=basePath%>">

			<title>我的任务</title>
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
					<h3 class="panel-title">我的任务</h3>

				</div>
				<div class="panel-body">
					<!--内嵌面板-->

					<div class="panel panel-default">
						<div class="panel-heading">

							<!-- 按钮触发模态框 -->
							<button class="btn btn-default start " data-toggle="modal" data-target="#myModal21">
								开始任务
							</button>
							<!-- 按钮触发模态框 -->
							<button class="btn btn-default fill " data-toggle="modal" data-target="#myModal3">
								填写维修报告
							</button>
							<button class="btn btn-default task-detail " data-toggle="modal" data-target="#myModal4">
								任务详情
							</button>
							<!-- 按钮触发模态框 -->
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
						<table class="easyui-datagrid" id="mm" title="待执行任务" style="width:900px;height:400px" pagination="true"
						 data-options="singleSelect:true,rownumbers:true,

				collapsible:true,

				url:'<%=basePath%>WeiXiuAction_queryAllWeixiu',

				pageSize:10,
                 
			pageListart:[ 5, 10, 15, 20 ],method:'get'">
							<thead>
								<tr>
									
									<th data-options="field:'schduleManName',width:200,align : 'center' ">分配人姓名</th>
									<th data-options="field:'repairSchdulTime',width:200,align:'center'">分配时间</th>
									<th data-options="field:'repairState',width:200,align:'center'">任务状态</th>
									
								</tr>
							</thead>
						</table>
					</div>

				

					<!-- 模态框（Modal） edit-->
					<div class="modal fade" id="myModal21" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
						<div class="modal-dialog">
							<div class="modal-content">
								<div class="modal-header">
									<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×
									</button>
									<h4 class="modal-title" id="myModalLabel">
               确定开始维修 
            </h4>
								</div>
								<div class="modal-body">

									确定现在开始此项任务吗？

								</div>
								<div class="modal-footer">
									<button type="button" class="btn btn-default" data-dismiss="modal">关闭
									</button>
									<button type="button" class="btn btn-primary starttom">
										确定
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
						   	var id="a";
						   	var row;
						   	$(".start").click(function(){
						   								   
						    row = $('#mm').datagrid('getSelected');
						   
						  
	   	if(row)
	   	{
//	      	myurl = "<%=basePath%>personAction_updatePerson";
//	   	    $('#dlg').dialog('open').dialog('setTitle', '修改用户');
//	   	    $('#ff').form('load', row);
              $(".start").attr("data-target","#myModal21");
               
				
             	$("#myModal21").show();




	   	    
	   	}else{
	   		alert("请选择一行");
	   	   
	   	   $("#myModal21").hide();
	   	   $(".start").attr("data-target","none");
	   	   
	   	}
						   		
						   	});
						   	
//						   	结束
							
							$(".starttom").click(
								function(){
									
									 
//									 console.log(a);
									 $.ajax({

             type: "post",
           url: "WeiXiuAction_startWeixiu",
            dataType: "json",
            data:{
            	"repair.repairId":row.repairId,
            	"repair.repairState":"维修中"
            	
           	
            },

             success: function(data){
             	alert(data.info);
             
				
             	$("#myModal21").hide();
             	$('#mm').datagrid('reload');
             	

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
							<div class="modal-content " style="width: 800px; height: 400px;">
								<div class="modal-header">
									<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×
									</button>
									<h4 class="modal-title" id="myModalLabel">
               请填写维修报告
            </h4>
								</div>
								<div class="modal-body">
									<table class="table">

										<tr class="table-tr">

											<th>检测情况:</th>
											<td>
												<input type="text" class="form-control   " name="custartom.custartomName" id="check-en" value="" required="required"/>
											</td>
											<th>检测时间:</th>
											<td>
												<input type="date" class="form-control   " name="custartom.custartomIdCard" id="checck-time" value="" required="required"/>
											</td>
										</tr>
										<tr class="table-tr">
											<th>维修说明:</th>
											<td>
												<input type="text" class="form-control   " name="custartom.custartomMabile" id="repair-say" value="" required="required"/>
											</td>
											<th>承诺:</th>
											<td>
												<input type="text" class="form-control   " name="custartom.custartomTel" id="promice" value="" required="required"/>
											</td>
										</tr>
										<tr class="table-tr">
											<th>工作时间:</th>
											<td>
												<div class="input-group">
                                               				<input type="text" class="form-control   " name="custartom.custartomPostart" id="work_time" value="" required="required"/>
										
                                                       <span class="input-group-addon">小时</span>
                                               </div>
							
												</td>
											<th>注意事项:</th>
											<td>
												<input type="text" class="form-control   " name="custartom.custartomEmail" id="attation" value="" required="required"/>
											</td>
										</tr>
										<tr class="table-tr">
											<th>人工成本:</th>
											<td>
												<div class="input-group">
                                              	<input type="text" class="form-control   " name="custartom.custartomAddrass" id="lobar_price" value="" required="required"/>
										
                                                       <span class="input-group-addon">元</span>
                                               </div>
							
												</td>
											<th>材料成本:</th>
											<td>
												<div class="input-group">
                                               			<input type="text" class="form-control   " name="custartom.custartomCompany" id="materia_price" value="" required="required"/>
											
                                                       <span class="input-group-addon">元</span>
                                               </div>
							
											</td>
										</tr>

									</table>
								</div>
								<div class="modal-footer">
									<button type="button" class="btn btn-default" data-dismiss="modal">关闭
									</button>
									<button type="button" class="btn btn-primary sure-delete">
										提交
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
						   	
						   	$(".fill").click(
						   		function(){
						   			var ro=$('#mm').datagrid('getSelected');
						   			if(ro){
						   				
						   				row=ro;
						   				  $(".fill").attr("data-target","#myModal3");
						   			}else{
						   				alert("请选择一行");   	   
	   	                             $("#myModal3").hide();
	   	                                   $(".fill").attr("data-target","none");
						   				
						   			}
						   			
					   		}
						   	);
						   	
						   	
						   	
						   	$(".sure-delete").click(function(){
						   		var machineCheckRecord=$("#check-en").val();
									var machineCheckTime=$("#checck-time").val();
									var attentionMatter=$("#attation").val();
									var repairRecord=$("#repair-say").val();
									var repairWorkTime=$("#work_time").val();
									
									var LabourPrice=$("#lobar_price").val();
									
									var mPrice=$("#materia_price").val();
									var repairPromise=$("#promice").val();
									 var repairLabourPrice=$.trim(LabourPrice);
									
									var materialPrice=$.trim(mPrice);
									
						   		
						   						 $.ajax({

             type: "post",
           url: "WeiXiuAction_fillWriteReport",
            dataType: "json",
            data:{
            	"repair.repairId":row.repairId,
            
            	"repair.machineCheckRecord":machineCheckRecord,
            	"repair.machineCheckTime":machineCheckTime,
            	"repair.repairRecord":repairRecord,
            	"repair.repairWorkTime":repairWorkTime,
            	"repair.repairLabourPrice":repairLabourPrice,
            	"repair.materialPrice":materialPrice,
            	"repair.repairPromise":repairPromise,
            	"repair.attentionMatter":attentionMatter,
            	"repair.repairState":"完成"
            	
            },

             success: function(data){
             	alert(data.info);
             	var machineCheckRecord=$("#check-en").val("");
									$("#checck-time").val("");
									$("#attation").val("");
									$("#repair-say").val("");
									$("#work_time").val("");
									$("#lobar_price").val("");
									
									$("#materia_price").val("");
									$("#promice").val("");
             	
				
             	$("#myModal3").hide();
             	$('#mm').datagrid('reload');
             	

             }

             

    });
						   		
						   	});
						   });
						   
//						    $(function(){ 
//						   	var id=a;
//						   	$(".start").click(function(){
//						   								   
//						   var row = $('#mm').datagrid('getSelected');
					</script>
					<!-- 模态框（Modal） -->
					<div class="modal fade" id="myModal4" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
						<div class="modal-dialog">
							<div class="modal-content" style="width: 800px;">
								<div class="modal-header">
									<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×
									</button>
									<h4 class="modal-title" id="myModalLabel">
               任务详情
            </h4>
								</div>
								<div class="modal-body">
									<table class="table">
					
					<tr class="table-tr">
						<th>姓名：</th><td id="cName"></td>
						<th>座机号：</th><td id="cTel"></td>
						
						<th>设备编号：</th><td id="machineVersion"></td>
						
					</tr>
						<tr class="table-tr">
							<th>地址：</th><td id="cAddrass"></td>
					
						<th>预估价钱：</th><td id="forecastartPrice"></td>
						<th>送修时间：</th><td id="custartomSentTime"></td>
						
					</tr>
						
					<tr class="table-tr">
						<th>邮编：</th><td id="cPostart"></td>
						<th>设备品牌：</th><td id="machineBrand"></td>
						<th>产品类型：</th><td id="productType"></td>
						
						</tr>
					
					<tr class="table-tr">
						<th>公司：</th><td id="cCompany"></td>
						
						<th>设备内存：</th><td id="machineRam"></td>
						<th>设备问题现象：</th><td id="machineBugPhenomenon"></td>
					</tr>
						
						<tr class="table-tr">
							<th>Email：</th><td id="cEmail"></td>
							
						
						<th>客户性质：</th><td id="custartomProperties"></td>
						<th>设备开机密码：</th><td id="machinefillPassword"></td>
					</tr>
						<tr class="table-tr">
						<th>手机号：</th><td id="cMabile"></td>
						<th>其它说明：</th><td id="other"></td>
						
						<th>预估完成时间：</th ><td id="forecastartCompleteTime"></td>
					</tr>
						
				</table>
								</div>
								<div class="modal-footer">
									<button type="button" class="btn btn-default" data-dismiss="modal">关闭
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
							
							
							var rowre;
							$(".task-detail").click(function(){
								
								 rowre=$('#mm').datagrid('getSelected');
								if(rowre){
									 $(".task-detail").attr("data-target","#myModal4");
						   				$.ajax({

             type: "post",
           url: "WeiXiuAction_seeReportRepair",
            dataType: "json",
            data:{
            	"reportRepair.reportRepairId":rowre.reportRepairId,
           
            
            	
            	
            },

             success: function(data){
             	
             	$("#cName").text(data.customName);
             	
             	$("#cCompany").text(data.customCompany);
             	$("#cMabile").text(data.customMabile);
             	$("#cTel").text(data.customTel);
             	$("#cAddrass").text(data.customAddrass);
             	
             	$("#cPostart").text(data.customPost);
             	$("#productType").text(data.productType);
             	$("#machineBrand").text(data.machineBrand);
             	$("#cEmail").text(data.customEmail);
             	
             	$("#machineBugPhenomenon").text(data.machineBugPhenomenon);
             	$("#machinefillPassword").text(data.machineStartPassword);
             	
             	$("#machineVersion").text(data.machineVersion);
             	$("#machineRam").text(data.machineRam);
             	$("#custartomSentTime").text(data.sendtime);
             	$("#custartomProperties").text(data.customProperties);
             	$("#forecastartCompleteTime").text(data.forecastCompleteTime);
             	$("#other").text(data.other);
			 	$("#forecastartPrice").text(data.forecastPrice);
             	
			
			
             }

             

    }); 
								}else{
									
									alert("请选择一行");   	   
	   	                             $("#myModal4").hide();
	   	                                   $(".task-detail").attr("data-target","none");
						   				
									
								}
								
								
							})
							
						})
					</script>
					
	
				</div>
			</div>

		</body>

		</html>