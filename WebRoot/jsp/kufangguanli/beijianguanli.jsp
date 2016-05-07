<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML>
<html>

<head>
<base href="<%=basePath%>">

<title>备件管理</title>
<meta charset="utf-8">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" type="text/css"
	href="../../javascript/themes/bootstrap/easyui.css" />

<link rel="stylesheet" type="text/css"
	href="../../javascript/themes/icon.css" />
<link rel="stylesheet" type="text/css"
	href="../../javascript/bootstrap/css/bootstrap.css" />

<link rel="stylesheet" href="../../css/main.css" />
<link rel="stylesheet" href="../../css/kefu.css" />
<script type="text/javascript" src="../../javascript/jquery-2.1.3.js"></script>
<script type="text/javascript"
	src="../../javascript/jquery.easyui.min.js"></script>
<script type="text/javascript"
	src="../../javascript/bootstrap/js/bootstrap.js"></script>
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

					<!-- 鎸夐挳瑙﹀彂妯℃�妗�-->
					<button class="btn btn-default add-cus" data-toggle="modal"
						data-target="#myModal99">添加备件</button>
					<!-- 鎸夐挳瑙﹀彂妯℃�妗�-->
					<button class="btn btn-default edit-cus " data-toggle="modal"
						data-target="#myModal2">修改备件</button>
					<button class="btn btn-default delete-cus" data-toggle="modal"
						data-target="#myModal3">删除备件</button>
					<!-- 鎸夐挳瑙﹀彂妯℃�妗�-->
					<div class="form-inline" style="float: right;margin-right: 100px;"
						name="searchform" method="post" action="" id="searchform">
						<input type="text" class="form-control s-int" name="beijianName"
							id="" value="" placeholder="请输入备件的名称" />
						<button type="submit" class="btn btn-default cus-search"
							id="submit_search" onclick="doSearch()">搜索</button>
						<!--<button type="button" class="btn btn-default cus-search" name="" id="" value="搜索"onclick="doSearch()" />-->

					</div>
					<!--<button type="button" class="btn btn-default cus-search" name="" id="" value="鎼滅储"onclick="doSearch()" />-->
					<script type="text/javascript">  
								
								function doSearch(){ //用户输入用户名,点击搜素,触发此函数  
    	var value=$(".s-int").val();
    	var se=$.trim(value);
    	if(se!=""){
    		$("#dg").datagrid({  
            
           
            url:'kuFangAction_queryBeijianBy?search='+se //触发此action,带上参数searcValue  
         
        })  
    	}else{
    		$("#dg").datagrid({  
            
           
            url:'kuFangAction_queryBeijianAll' //触发此action,带上参数searcValue  
         
        }) 
    		
    	}
        
    }  
								    



//  function doSearch(){ //鐢ㄦ埛杈撳叆鐢ㄦ埛鍚�鐐瑰嚮鎼滅礌,瑙﹀彂姝ゅ嚱鏁� 
//  	var value=$(".s-int").val();
//  	alert(value);
//      $("#dg").datagrid({  
//           url:'queryBeijianBy?search='+value, //瑙﹀彂姝ction,甯︿笂鍙傛暟searcValue  
//          width:1000,  
//          pageSize:10,  
//          pageList:[5,10,15,20],  
//          nowrap:true,  
//         
//          collapsible:true,  
//          
//          
//          loadMsg:'加载中.....',  
//          
//          sortName:'userId',  
//          sortOrder:'asc',  
//          remoteSort:false,  
//          
//          pagination : true,  
//          rownumbers : true  
//      })  
//  }  
      
</script>



				</div>
				<!--表格数据-->
				<table class="easyui-datagrid" id="dg" title="备件信息"
					style="width:900px;height:400px" pagination="true"
					data-options="singleSelect:true,rownumbers:true,

				collapsible:true,

				url:'<%=basePath%>kuFangAction_queryBeijianAll',

				pageSize:10,
                 
			pageList:[ 5, 10, 15, 20 ],method:'get'">
					<thead>
						<tr>
							<th data-options="field:'beijianName',width:160 ,align:'center'">备件名称</th>
							<th
								data-options="field:'beijianVersion',width:160,align:'center'">备件型号</th>
							<th data-options="field:'beijianPrice',width:160,align:'center'">备件价格</th>
							<th data-options="field:'beijianNumber',width:160,align:'center'">备件数量</th>

							<th data-options="field:'beijianState',width:160,align:'center'">备件状态</th>
						</tr>
					</thead>
				</table>
			</div>

			<!-- 模态框（Modal） -->
			<div class="modal fade" id="myModal99" tabindex="-1" role="dialog"
				aria-labelledby="myModalLabel" aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal"
								aria-hidden="true">×</button>
							<h4 class="modal-title" id="myModalLabel">请填写备件信息</h4>
						</div>
						<!--		<form action="<%=basePath%>keFuAction_addCustom" method="post">-->

						<div class="modal-body add-success">

							<table class="table">

								<tr class="table-tr">

									<th>备件名称:</th>
									<td><input type="text" class="form-control   "
										name="beijian.beijianName" id="beijianName" value=""
										required="required" /></td>
									<th>备件型号:</th>
									<td><input type="text" class="form-control   "
										name="beijian.beijianVersion" id="beijianVersion" value=""
										required="required" /></td>

								</tr>
								<tr class="table-tr">
									<th>备件价格:</th>
									<td>
										<div class="input-group">
											<input type="text" class="form-control   "
												name="beijian.beijianPrice" id="beijianPrice" value=""
												required="required" /> <span class="input-group-addon">元</span>
										</div>
									</td>
									<th>备件数量:</th>
									<td><input type="text" class="form-control   "
										name="beijian.beijianNumber'" id="beijianNumber" value=""
										required="required" /></td>
								</tr>
								<tr class="table-tr">
									<th>预警数量:</th>
									<td><input type="text" class="form-control   "
										name="beijian.warnNumber" id="warnNumber" value=""
										required="required" /></td>
							</table>

						</div>

						<div class="modal-footer">
							<button type="button" class="btn btn-default add-close"
								data-dismiss="modal">关闭</button>
							<button type="button" class="btn btn-primary add-custom-add add">
								提交备件信息</button>
						</div>

						<!--</form>-->
					</div>
					<!-- /.modal-content -->
				</div>
				<!-- /.modal-dialog -->
			</div>
			<!-- /.modal -->
			<script>
						
						$(function(){
//							$(".add-cus").click(function(){
//								
//								  $("this").ATTR("data-target","#myModal");
//								
//							})
 
						   	  $("#myModal99").hide();
	   	                 $(".add-cus").attr("data-target","none");
						   	$(".add-cus").click(function(){
						   								   
			    $(".add-cus").attr("data-target","#myModal99");
           	
             	$("#myModal99").show();

	   			   		
						   	});
							
							
							$(".add-custom-add").click(
								function(){
									var beijName=$("#beijianName").val();
									var beijianVersion=$("#beijianVersion").val();
									var beiPrice=$("#beijianPrice").val();
									var beiNumber=$("#beijianNumber").val();
									var warnNumber=$("#warnNumber").val();
									
									
									var beijianNumber=$.trim(beiNumber);
									var warnNumber=$.trim(warnNumber);
									 var beijianPrice=$.trim(beiPrice);
									 var beijianName=$.trim(beijName);
//									var beijianState=$("#beijianState").val();
									
							 console.log(name);
									 $.ajax({

             type: "post",
           url: "kuFangAction_addBeijian",
            dataType: "json",
            data:{
            	"beijian.beijianName":beijianName,
            	"beijian.beijianVersion":beijianVersion,
            	"beijian.beijianPrice":beijianPrice,
            	"beijian.beijianNumber":beijianNumber,
            	"beijian.warnNumber":warnNumber,
//          	"beijian.beijianState":beijianState,
            	
            	
            },

             success: function(data){
             	alert(data.info);
             	$("#beijianName").val("");
				$("#beijianVersion").val("");
				$("#beijianPrice").val("");
				$("#beijianNumber").val("");
				$("#warnNumber").val("");
//				$("#beijianState").val(" ");
									
				
             	$("#myModal99").hide();
             	$('#dg').datagrid('reload');
             	
//           	$(".add-success").empty()
//           	.html("<h6>"+data.info+"</h6>");
//           	$(".add-custom-add").hide();
             }

             

    });
    
    
    
    
    
    
								}
							);
						})
					</script>

			<!-- 模态框（Modal） edit-->
			<div class="modal fade" id="myModal2" tabindex="-1" role="dialog"
				aria-labelledby="myModalLabel" aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal"
								aria-hidden="true">×</button>
							<h4 class="modal-title" id="myModalLabel">请修改客户信息</h4>
						</div>
						<div class="modal-body">

							<table class="table">

								<tr class="table-tr">

									<th>备件名称:</th>
									<td><input type="text" class="form-control   "
										name="beijian.beijianName" id="bName" value=""
										required="required" /></td>
									<th>备件型号:</th>
									<td><input type="text" class="form-control   "
										name="beijian.beijianVersion" id="bVersion" value=""
										required="required" /></td>

								</tr>
								<tr class="table-tr">
									<th>备件价格:</th>
									<td>
										<div class="input-group">
											<input type="text" class="form-control   "
												name="beijian.beijianPrice" id="bPrice" value=""
												required="required" /> <span class="input-group-addon">元</span>
										</div>
									</td>
									<th>备件数量:</th>
									<td><input type="text" class="form-control   "
										name="beijian.beijianNumber'" id="bNumber" value=""
										required="required" /></td>
								</tr>
								<tr class="table-tr">
									<th>预警数量:</th>
									<td><input type="text" class="form-control   "
										name="beijian.warnNumber" id="wNumber" value=""
										required="required" /></td>

								</tr>

							</table>

						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-default"
								data-dismiss="modal">关闭</button>
							<button type="button" class="btn btn-primary edit-custom">
								提交修改信息</button>
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
						   	$(".edit-cus").click(function(){
						   								   
						   var rowbeijian = $('#dg').datagrid('getSelected');
						   
						  
	   	if(rowbeijian)
	   	{
//	      	myurl = "<%=basePath%>
				personAction_updatePerson";
							//	   	    $('#dlg').dialog('open').dialog('setTitle', '淇敼鐢ㄦ埛');
							//	   	    $('#ff').form('load', row);
							$(".edit-cus").attr("data-target", "#myModal2");
							$("#bName").val(rowbeijian.beijianName);
							$("#bVersion").val(rowbeijian.beijianVersion);
							$("#bPrice").val(rowbeijian.beijianPrice);
							$("#bNumber").val(rowbeijian.beijianNumber);
							$("#wNumber").val(rowbeijian.warnNumber);

							id = rowbeijian.beijianId;

							$("#myModal2").show();

						} else {
							alert("请选择一行");

							$("#myModal2").hide();
							$(".edit-cus").attr("data-target", "none");

						}

					});

					//						   	缁撴潫

					$(".edit-custom").click(function() {
						var beijName = $("#bName").val();
						var beijianVersion = $("#bVersion").val();
						var beiPrice = $("#bPrice").val();
						var beiNumber = $("#bNumber").val();
						var warnNumber = $("#wNumber").val();

						var beijianNumber = $.trim(beiNumber);
						var warnNumber = $.trim(warnNumber);
						var beijianPrice = $.trim(beiPrice);
						var beijianName = $.trim(beijName);
						//									 console.log(a);
						$.ajax({

							type : "post",
							url : "kuFangAction_editBeijian",
							dataType : "json",
							data : {
								"beijian.beijianId" : id,
								"beijian.beijianName" : beijianName,
								"beijian.beijianVersion" : beijianVersion,
								"beijian.beijianPrice" : beijianPrice,
								"beijian.beijianNumber" : beijianNumber,
								"beijian.warnNumber" : warnNumber,

							},

							success : function(data) {
								alert(data.info);
								$("#beijianName").val("");
								$("#beijianVersion").val("");
								$("#beijianPrice").val("");
								$("#beijianNumber").val("");
								$("#warnNumber").val("");

								$("#myModal2").hide();
								$('#dg').datagrid('reload');

							}

						});
					});
					//							缁撴潫
				})
			</script>
			<!-- 妯℃�妗嗭紙Modal锛�-->
			<div class="modal fade" id="myModal3" tabindex="-1" role="dialog"
				aria-labelledby="myModalLabel" aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal"
								aria-hidden="true">×</button>
							<h4 class="modal-title" id="myModalLabel">确定信息</h4>
						</div>
						<div class="modal-body">您确定要删除吗？</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-default"
								data-dismiss="modal">取消</button>
							<button type="button" class="btn btn-primary sure-delete">
								删除</button>
						</div>
					</div>
					<!-- /.modal-content -->
				</div>
				<!-- /.modal-dialog -->
			</div>
			<!-- /.modal -->
			<script>
				$(function() {
					$('#myModal').modal({
						keyboard : true
					})
				});

				$(function() {
					var row;

					$(".delete-cus").click(function() {
						var ro = $('#dg').datagrid('getSelected');
						if (ro) {

							row = ro;
							$(".delete-cus").attr("data-target", "#myModal3");
						} else {
							alert("删除成功，请继续");
							$("#myModal3").hide();
							$(".delete-cus").attr("data-target", "none");

						}

					});

					$(".sure-delete").click(function() {

						$.ajax({

							type : "post",
							url : "kuFangAction_deleteBeijian",
							dataType : "json",
							data : {
								"beijian.beijianId" : row.beijianId,
								"beijian.beijianName" : row.beijianName,
								"beijian.beijianVersion" : row.beijianVersion,
								"beijian.beijianPrice" : row.beijianPrice,
								"beijian.beijianNumber" : row.beijianNumber,
								"beijian.warnNumber" : row.warnNumber,
								"beijian.beijianState" : row.beijianState,

							},

							success : function(data) {
								alert(data.info);

								$("#myModal3").hide();
								$('#dg').datagrid('reload');

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