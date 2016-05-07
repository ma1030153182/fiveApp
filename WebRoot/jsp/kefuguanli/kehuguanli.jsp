<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
	<% String path=request.getContextPath(); String basePath=request.getScheme()+ "://"+request.getServerName()+ ":"+request.getServerPort()+path+ "/"; %>

		<!DOCTYPE HTML>
		<html>

		<head>
			<base href="<%=basePath%>">

			<title>客户管理</title>
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
					<h3 class="panel-title">客户信息管理</h3>

				</div>
				<div class="panel-body">
					<!--内嵌面板-->

					<div class="panel panel-default">
						<div class="panel-heading">

							<!-- 按钮触发模态框 -->
							<button class="btn btn-default add-cus" data-toggle="modal" data-target="#myModal9">
								添加客户
							</button>
							<!-- 按钮触发模态框 -->
							<button class="btn btn-default edit-cus " data-toggle="modal" data-target="#myModal2">
								修改客户
							</button>
							<button class="btn btn-default delete-cus" data-toggle="modal" data-target="#myModal3">
								删除客户
							</button>
							<!-- 按钮触发模态框 -->
							
							<div class="form-inline"  style="float: right;margin-right: 100px;" name="searchform" method="post" action="" id ="searchform">
								<input type="text" class="form-control s-int" name="customName" id="" value="" placeholder="请输入姓名"/>
								<button type="submit" class="btn btn-default cus-search" id="submit_search" onclick="doSearch()">搜索</button>
								<!--<button type="button" class="btn btn-default cus-search" name="" id="" value="搜索"onclick="doSearch()" />-->
								
                          </div>
<script type="text/javascript">
 function doSearch(){ //用户输入用户名,点击搜素,触发此函数  
    	var value=$(".s-int").val();
    	var se=$.trim(value);
    	if(se!=""){
    		$("#dg").datagrid({  
            
           
            url:'keFuAction_queryAllCustomBy?search='+se //触发此action,带上参数searcValue  
         
        })  
    	}else{
    		$("#dg").datagrid({  
            
           
            url:'keFuAction_queryAllCustom' //触发此action,带上参数searcValue  
         
        }) 
    		
    	}
        
    }  
      

//
//$(function () {
// 
//      $("#submit_search").click(function () {
//      	var search=$(".s-int").val();
//      	var se=$.trim(search);
//      	var ur;
//      	if(se!=""){
//      		 ur="keFuAction_queryAllCustom"+"?customName="+se;
//      		
//      		
//      	}else
//      	{    ur="keFuAction_queryAllCustom";
//      	}
//      	console.log(ur);
//      	$('#dg').datagrid('URL：ur');
//            $('#dg').datagrid('reload');   //点击搜索
//        });
//
//   })
//



//      $(function () {
//   
//        $("#submit_search").click(function () {
//              $('#dg').datagrid({ queryParams: form2Json("searchform") });   //点击搜索
//          });
//
//      })
//
//      //将表单数据转为json
//      function form2Json(id) {
//
//          var arr = $("#" + id).serializeArray()
//          var jsonStr = "";
//
//          jsonStr += '{';
//          for (var i = 0; i < arr.length; i++) {
//              jsonStr += '"' + arr[i].name + '":"' + arr[i].value + '",'
//          }
//          jsonStr = jsonStr.substring(0, (jsonStr.length - 1));
//          jsonStr += '}'
//
//          var json = JSON.parse(jsonStr)
//          return json
//      }

    </script>



							

						</div>
						<!--表格数据-->
						<table class="easyui-datagrid" id="dg" title="客户信息" style="width:1000px;height:400px" pagination="true"
						 data-options="singleSelect:true,rownumbers:true,

				collapsible:true,

				url:'<%=basePath%>keFuAction_queryAllCustom',

				pageSize:10,
                 
			pageList:[ 5, 10, 15, 20 ],method:'get'">
							<thead>
								<tr>
									<th data-options="field:'customName',width:110 ,align : 'center', ">姓名</th>
									<th data-options="field:'customIdCard',width:120,align : 'center', ">身份证号</th>
									<th data-options="field:'customCompany',width:120,align:'center'">所在单位</th>
									<th data-options="field:'customAddrass',width:110,align:'center'">住址</th>
									<th data-options="field:'customEmail',width:110">座机号</th>
									<th data-options="field:'customMabile',width:110,align:'center'">手机号</th>
									<th data-options="field:'customPost',width:110,align:'center'">邮编号</th>
									<th data-options="field:'customTel',width:120,align:'center'">Email</th>
								</tr>
							</thead>
						</table>
					</div>

					<!-- 模态框（Modal） -->
					<div class="modal fade" id="myModal9" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
						<div class="modal-dialog">
							<div class="modal-content">
								<div class="modal-header">
									<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×
									</button>
									<h4 class="modal-title" id="myModalLabel">
               请填写客户信息
            </h4>
								</div>
								<!--		<form action="<%=basePath%>keFuAction_addCustom" method="post">-->

								<div class="modal-body add-success">

									<table class="table">

										<tr class="table-tr">

											<th>姓名:</th>
											<td>
												<input type="text" class="form-control   " name="custom.customName" id="customName" value="" required="required"/>
											</td>
											<th>身份证号:</th>
											<td>
												<input type="text" class="form-control   " name="custom.customIdCard" id="customIdCard" value="" required="required"/>
											</td>
										</tr>
										<tr class="table-tr">
											<th>手机号:</th>
											<td>
												<input type="text" class="form-control   " name="custom.customMabile" id="customMabile" value="" required="required" pattern="r'^(13[0-9]|15[0|3|6|7|8|9]|18[8|9])\d{8}$'"/>
											</td>
											<th>座机号:</th>
											<td>
												<input type="text" class="form-control   " name="custom.customTel" id="customTel" value="" required="required" />
											</td>
										</tr>
										<tr class="table-tr">
											<th>邮编:</th>
											<td>
												<input type="text" class="form-control   " name="custom.customPost" id="customPost" value="" required="required" pattern="[1-9]\d{5}(?!\d)"/>
											</td>
											<th>Email:</th>
											<td>
												<input type="email" class="form-control   " name="custom.customEmail" id="customEmail" value="" required="required"/>
											</td>
										</tr>
										<tr class="table-tr">
											<th>地址:</th>
											<td>
												<input type="text" class="form-control   " name="custom.customAddrass" id="customAddrass" value="" required="required"/>
											</td>
											<th>公司:</th>
											<td>
												<input type="text" class="form-control   " name="custom.customCompany" id="customCompany" value="" required="required"/>
											</td>
										</tr>

									</table>

								</div>

								<div class="modal-footer">
									<button type="button" class="btn btn-default add-close" data-dismiss="modal">关闭
									</button>
									<button type="button" class="btn btn-primary add-custom-add add">
										提交客户信息
									</button>
								</div>

								<!--</form>-->
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
//							$(".add-cus").click(function(){
//								
//								  $("this").ATTR("data-target","#myModal");
//								
//							})
							 $("#myModal9").hide();
	   	                    $(".add-cus").attr("data-target","none");
								$(".add-cus").click(function(){
						   		
              $(".add-cus").attr("data-target","#myModal9");
           	
             	$("#myModal9").show();

	      		
						   	});
							
							$(".add-custom-add").click(
								function(){
									var name=$("#customName").val();
									var idcard=$("#customIdCard").val();
									var mobile=$("#customMabile").val();
									var email=$("#customEmail").val();
									var post=$("#customPost").val();
									var addrass=$("#customAddrass").val();
									
									var tel=$("#customTel").val();
									var company=$("#customCompany").val();
									  var cusName=$.trim(name);
									 console.log(name);
									 $.ajax({

             type: "post",
           url: "keFuAction_addCustom",
            dataType: "json",
            data:{
            	"custom.customName":cusName,
            	"custom.customIdCard":idcard,
            	"custom.customMabile":mobile,
            	"custom.customEmail":email,
            	"custom.customPost":post,
            	"custom.customTel":tel,
            	"custom.customAddrass":addrass,
            	"custom.customCompany":company
            	
            },

             success: function(data){
             	alert(data.info);
             	$("#customName").val("");
				$("#customIdCard").val("");
				$("#customMabile").val("");
				$("#customEmail").val("");
				$("#customPost").val("");
				$("#customAddrass").val("");
									
				$("#customTel").val("");
				$("#customCompany").val("");
				
             	$("#myModal").hide();
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
					<div class="modal fade" id="myModal2" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
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

									<table class="table">

										<tr class="table-tr">

											<th>姓名:</th>
											<td>
												<input type="text" class="form-control   " name="custom.customName" id="cusName" value="" required="required"/>
											</td>
											<th>省份证号:</th>
											<td>
												<input type="text" class="form-control   " name="custom.customIdCard" id="cusIdCard" value="" required="required"/>
											</td>
										</tr>
										<tr class="table-tr">
											<th>手机号:</th>
											<td>
												<input type="text" class="form-control   " name="custom.customMabile" id="cusMabile" value="" required="required" pattern="r'^(13[0-9]|15[0|3|6|7|8|9]|18[8|9])\d{8}$'"/>
											</td>
											<th>座机号:</th>
											<td>
												<input type="text" class="form-control   " name="custom.customEmail" id="cusTel" value="" required="required"/>
											</td>
										</tr>
										<tr class="table-tr">
											<th>邮编:</th>
											<td>
												<input type="text" class="form-control   " name="custom.customPost" id="cusPost" value="" required="required" pattern="[1-9]\d{5}(?!\d)"/>
											</td>
											<th>Email:</th>
											<td>
												<input type="email" class="form-control   " name="custom.customEmail" id="cusEmail" value="" required="required"/>
											</td>
										</tr>
										<tr class="table-tr">
											<th>地址:</th>
											<td>
												<input type="text" class="form-control   " name="custom.customAddrass" id="cusAddrass" value="" required="required"/>
											</td>
											<th>公司:</th>
											<td>
												<input type="text" class="form-control   " name="custom.customCompany" id="cusCompany" value="" required="required"/>
											</td>
										</tr>
										<tr class="table-tr">
											<td></td>
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
						   	var id="a";
						   	$(".edit-cus").click(function(){
						   								   
						   var row = $('#dg').datagrid('getSelected');
						   
						  
	   	if(row)
	   	{
//	      	myurl = "<%=basePath%>personAction_updatePerson";
//	   	    $('#dlg').dialog('open').dialog('setTitle', '修改用户');
//	   	    $('#ff').form('load', row);
              $(".edit-cus").attr("data-target","#myModal2");
                $("#cusName").val(row.customName);
				$("#cusIdCard").val(row.customIdCard);
				$("#cusMabile").val(row.customMabile);
				$("#cusEmail").val(row.customEmail);
				$("#cusPost").val(row.customPost);
				$("#cusAddrass").val(row.customAddrass);
									
				$("#cusTel").val(row.customTel);
				$("#cusCompany").val(row.customCompany);
				
				id=row.customId;
				
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
									var name=$("#cusName").val();
									var idcard=$("#cusIdCard").val();
									var mobile=$("#cusMabile").val();
									var email=$("#cusEmail").val();
									var post=$("#cusPost").val();
									var addrass=$("#cusAddrass").val();
									
									var tel=$("#cusTel").val();
									var company=$("#cusCompany").val();
									  var cusName=$.trim(name);
//									 console.log(a);
									 $.ajax({

             type: "post",
           url: "keFuAction_editCustom",
            dataType: "json",
            data:{
            	"custom.customName":cusName,
            	
            	"custom.customIdCard":idcard,
            	"custom.customMabile":mobile,
            	"custom.customEmail":email,
            	"custom.customPost":post,
            	"custom.customTel":tel,
            	"custom.customAddrass":addrass,
            	"custom.customCompany":company,
            	"custom.customId":id
            	
            },

             success: function(data){
             	alert(data.info);
             	$("#customName").val("");
				$("#customIdCard").val("");
				$("#customMabile").val("");
				$("#customEmail").val("");
				$("#customPost").val("");
				$("#customAddrass").val("");
									
				$("#customTel").val("");
				$("#customCompany").val("");
				
             	$("#myModal2").hide();
             	$('#dg').datagrid('reload');
             	

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
						$(function () { $('#myModal').modal({
						      keyboard: true
						   })});
						   
						   $(function(){
						   	var row;
						   	
						   	$(".delete-cus").click(
						   		function(){
						   			var ro=$('#dg').datagrid('getSelected');
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
						   		
						   						 $.ajax({

             type: "post",
           url: "keFuAction_deleteCustom",
            dataType: "json",
            data:{
            	"custom.customName":row.customName,
            
            	"custom.customIdCard":row.customName,
            	"custom.customMabile":row.customMabile,
            	"custom.customEmail":row.customEmail,
            	"custom.customPost":row.customPost,
            	"custom.customTel":row.customTel,
            	"custom.customAddrass":row.customAddrass,
            	"custom.customCompany":row.customCompany,
            	"custom.customId":row.customId
            	
            },

             success: function(data){
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