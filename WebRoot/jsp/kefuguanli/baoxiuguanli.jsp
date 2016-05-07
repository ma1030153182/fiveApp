<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
	<% String path=request.getContextPath(); String basePath=request.getScheme()+ "://"+request.getServerName()+ ":"+request.getServerPort()+path+ "/"; %>

		<!DOCTYPE HTML>
		<html>

		<head>
			<base href="<%=basePath%>">

			<title>报修管理</title>
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
			<div class="panel panel-primary">
				<div class="panel-heading">填写报修单</div>
				<div class="panel-body">
			<!--内层-->
			<div class="panel panel-default">
				<div class="panel-heading">请先检索信息</div>
				<div class="panel-body">
					<div class="form-inline" >
				
								<input type="text" class="form-control col-sm-offset-1 searchidcard-input" id="search-input" placeholder="请输入身份证号">
								<button type="button" id="custom-searchidcard" class="btn btn-default">搜索</button>
				                <button type="button" id="custom-searchreset" class="btn btn-default">重置</button>
				
					</div>
					
				</div>
			</div>
			
			
				<div class="panel panel-default ">
				<div class="panel-heading">用户基本信息</div>
				<table class="table">
					
					<tr class="table-tr">
						<th>姓名：</th><td id="cName"></td>
						<th>身份证号：</th><td id="cIdCard"></td>
						<th>公司：</th><td id="cCompany"></td>
					</tr>
						<tr class="table-tr">
					<th>手机号：</th><td id="cMabile"></td>
						<th>座机号：</th><td id="cTel"></td>
						<th>地址：</th><td id="cAddrass"></td>
					</tr>
						<tr class="table-tr">
						<th>邮编：</th><td id="cPost"></td>
						<th>Email：</th><td id="cEmail"></td>
					</tr>
					
				</table>
		<script type="text/javascript">	
		var cusid;
		var cusName;
						$(function(){
							$(".panel1").hide();
							$(".panel2").hide();
							$(".btn1").hide();
							$(".btn1-reset").hide();
							$(".btn1-edit").hide();
							$("#custom-searchidcard").click(function(){
							var input=$(".searchidcard-input").val();
							console.log(input);
							$.ajax({
								type:"post",
								url:"keFuAction_queryCustomByIdCard",
								async:true,
								dataType: "json",
								data:{"custom.customIdCard":input},
								success: function(data){
									if(data.customId){
										console.log(data.customName);
				$("#cName").text(data.customName);
				$("#cIdCard").text(data.customIdCard);
				$("#cMabile").text(data.customMabile);
				$("#cEmail").text(data.customEmail);
				$("#cPost").text(data.customPost);
				$("#cAddrass").text(data.customAddrass);
									
				$("#cTel").text(data.customTel);
				$("#cCompany").text(data.customCompany);
				cusid=data.customId;
				cusName=data.customName;
							$(".panel1").show();
							$(".panel2").show();	
							$(".btn1").show();	
							$(".btn1-reset").show();	
									}else{
										alert(data.info);
									}
									
							
								}
							});
						});
						
						$("#custom-searchreset").click(function(){
							
							$(".btn1-edit").hide();
							$(".panel1").hide();
							$(".panel2").hide();
							$(".btn1").hide();
							$(".btn1-reset").hide();
							$(".searchidcard-input").val("");
							$("#cName").text("");
				$("#cIdCard").text("");
				$("#cMabile").text("");
				$("#cEmail").text("");
				$("#cPost").text("");
				$("#cAddrass").text("");
									
				$("#cTel").text("");
				$("#cCompany").text("");
							
						})
						
						
						
						
						})
						
						
						</script>
			</div>

		
			<div class="panel panel-default panel1">
				<div class="panel-heading">设备维修信息</div>
				<table class="table">
						<tr class="table-tr">
							<!--<select>
<option value="volvo">Volvo</option>
<option value="saab">Saab</option>
<option value="mercedes">Mercedes</option>
<option value="audi">Audi</option>
</select>-->
						<th>产品类型：</th><td><select class="productType">
                                               <option value="电脑">电脑</option>
                                               <option value="投影仪">投影仪</option>
                                               <option value="其他">其他</option>
                                               
                                               </select></td>
						<th>设备品牌：</th><td><input type="text"class="form-control   machineBrand" name="" id="" value="" required="required" /></td>
						</tr>
					
					<tr class="table-tr">
						<th>问题现象：</th><td><input type="text"class="form-control machineBugPhenomenon  " name="" id="" value="" required="required"/></td>
						<th>开机密码：</th><td><input type="text"class="form-control  machineStartPassword " name="" id="" value="" required="required"/></td>
					</tr>
						<tr class="table-tr">
						<th>设备编号：</th><td><input type="text"class="form-control machineVersion  " name="" id="" value="" required="required"/></td>
						<th>设备内存：</th><td> <div class="input-group">
                                                <input type="text"class="form-control machineRam  " name="" id="" value="" required="required"/>
					
                                                       <span class="input-group-addon">GB</span>
                                               </div>
							
							</td>
							
							</tr>
					
						
				</table>
				
			</div>
			<div class="panel panel-default panel2">
				<div class="panel-heading">其他信息信息
					
				</div>
				<table class="table">
						<tr class="table-tr">
							<th>客户性质：</th><td><select class="customProperties">
                                                     <option value="企业用户">企业用户</option>
                                                         <option value="家庭用户">家庭用户</option>
                                                          <option value="政府部门">政府部门</option>
                                                         
                                                       </select></td>
				
						<th>预估价钱：</th><td>
							<div class="input-group">
                                               				<input type="text"class="form-control forecastPrice  " name="" id="" value="" required="required"/>
			
                                                       <span class="input-group-addon">元</span>
                                               </div>
							
							</td>
					</tr>
						<tr class="table-tr">
						<th>预估完成时间：</th><td><input type="date"class="form-control forecastCompleteTime  " name="" id="" value="" required="required" /></td>
						<th>其它说明：</th><td><input type="text"class="form-control other  " name="" id="" value="" /></td>
						
					</tr>
						
				</table>

			</div>
			<button type="button" class="btn btn-default col-sm-offset-1 btn1 submit-cus">提交报修单</button>
			<button type="buton" name="" class="btn btn-default btn1-reset">重置信息</button>
			<!--<button type="buton" name="" class="btn btn-default btn1-edit">确定修改报修单</button>-->
			<!--<input  type="submit " class="btn btn-default col-sm-offset-1 btn1 submit-cus" value="提交报修单">
			<input type="reset" name="" class="btn btn-default btn1" value="重置信息" />-->
				
				
				<script type="text/javascript">					
						$(function(){
							
							
							$(".submit-cus").click(function(){
							
							$.ajax({
								type:"post",
								url:"keFuAction_addReportRepair",
								async:true,
								dataType: "json",
								data:{
									"reportRepair.customId":cusid,
									
								"reportRepair.customName":cusName,
									"reportRepair.customProperties":$(".customProperties").val(),
									"reportRepair.forecastPrice":$(".forecastPrice").val(),
									"reportRepair.forecastCompleteTime":$(".forecastCompleteTime").val(),
									"reportRepair.reportState":$(".reportState").val(),
									"reportRepair.productType":$(".productType").val(),
									"reportRepair.machineVersion":$(".machineVersion").val(),
									"reportRepair.machineBrand":$(".machineBrand").val(),
									"reportRepair.machineBugPhenomenon":$(".machineBugPhenomenon").val(),
									"reportRepair.machineStartPassword":$(".machineStartPassword").val(),
									"reportRepair.machineImportanceData":$(".machineImportanceData").val(),
									"reportRepair.machineRam":$(".machineRam").val(),
									"reportRepair.machineBattery":$(".machineBattery").val(),
									"reportRepair.other":$(".other").val(),
									"reportRepair.reportState":"未分配"
									
									},
								success: function(data){
									$(".btn1-edit").show();
									alert(data.info);
									
									
								}
							});
						})
							
							$(".btn1-reset").click(function(){
								
								
							$(".customProperties").val("");
								$(".forecastPrice").val("");
									$(".forecastCompleteTime").val("");
							$(".reportState").val(),
									$(".productType").val("");
									$(".machineVersion").val("");
									$(".machineBrand").val("");
									$(".machineBugPhenomenon").val("");
									$(".machineStartPassword").val("");
									$(".machineImportanceData").val("");
									$(".machineRam").val("");
									$(".machineBattery").val("");
									$(".other").val("");
									
								
							})
							
						})
						
						
						</script>
				<!--修改报修单-->
				<script type="text/javascript">					
						$(function(){
							
							
							$(".btn1-edit").click(function(){
							
							$.ajax({
								type:"post",
								url:"keFuAction_editReportRepair",
								async:true,
								dataType: "json",
								data:{
									"reportRepair.customId":cusid,
									
								"reportRepair.customName":cusName,
									"reportRepair.customProperties":$(".customProperties").val(),
									"reportRepair.forecastPrice":$(".forecastPrice").val(),
									"reportRepair.forecastCompleteTime":$(".forecastCompleteTime").val(),
									"reportRepair.reportState":$(".reportState").val(),
									"reportRepair.productType":$(".productType").val(),
									"reportRepair.machineVersion":$(".machineVersion").val(),
									"reportRepair.machineBrand":$(".machineBrand").val(),
									"reportRepair.machineBugPhenomenon":$(".machineBugPhenomenon").val(),
									"reportRepair.machineStartPassword":$(".machineStartPassword").val(),
									"reportRepair.machineImportanceData":$(".machineImportanceData").val(),
									"reportRepair.machineRam":$(".machineRam").val(),
									"reportRepair.machineBattery":$(".machineBattery").val(),
									"reportRepair.other":$(".other").val(),
									"reportRepair.reportState":"未分配"
									
									},
								success: function(data){
									
									alert(data.info);
									
									
								}
							});
						})
							
							
							
						})
						
						
						</script>
				
				
				<!--内层结束-->
				</div>
					
				</div>
			</div>
			
				
		</body>

		</html>