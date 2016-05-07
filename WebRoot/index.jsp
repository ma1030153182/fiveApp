<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML5>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>登陆设备维修管理系统</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta charset="utf-8">
	
			<link rel="stylesheet" type="text/css" href="javascript/themes/bootstrap/easyui.css" />
			<link rel="stylesheet" type="text/css" href="javascript/themes/icon.css" />
			<link rel="stylesheet" type="text/css" href="javascript/bootstrap/css/bootstrap.css" />
			<link rel="stylesheet" href="css/login.css" />
			<script type="text/javascript" src="javascript/jquery-2.1.3.js"></script>
			<script type="text/javascript" src="javascript/jquery.easyui.min.js"></script>
			<script type="text/javascript" src="javascript/bootstrap/js/bootstrap.js"></script>
			<script type="text/javascript" src="javascript/my.js"></script>

	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body >
  	
  	<!--登陆框-->
  	<div class="login-form">
  		
   <div class="right">
   	<div class="panel-heading" style="font-size: 36px; font-weight: bolder;">
      欢迎登陆设备维修管理系统
      
   </div>
   <div class="">
   	
   
  				<form action="loginAction_login" method="post">
  					
  					
  				<div class="login">
  				 	<span class=" glyphicon glyphicon-user" style="font-size: 22px;margin: 8px;margin-left: 16px;"></span><input type="text" name="emp.empAccount" id="login_input" placeholder="请输入账号" required="required"/>   
  				 </div>
  			     <div class="login">  
  			     	<span class="glyphicon glyphicon-lock" style="font-size: 22px;margin: 8px;margin-left: 16px;"></span><input type="password" name="emp.empPassword" id="login_input" placeholder="请输入密码" required="required"/>  
  			     </div>
  			   <div class="login submit">
  			   	<button  class=" submit btn  " type="submit" >登录</button>  
  			     
  			   </div>
  			     	
  				</form>
  				 </div>
  			</div>
   

  		
  		<!--登陆主体
  		<div class="login-body">
  			<div class="left">
  				
  			</div>
  			<div class="right">
  				<form action="loginAction_login" method="post">
  					
  				<div class="login">
  				 	<span class=" glyphicon glyphicon-user" style="font-size: 22px;margin: 8px;margin-left: 16px;"></span><input type="text" name="emp.empAccount" id="login_input" placeholder="请输入账号"/>   
  				 </div>
  			     <div class="login">  
  			     	<span class="glyphicon glyphicon-lock" style="font-size: 22px;margin: 8px;margin-left: 16px;"></span><input type="password" name="emp.empPassword" id="login_input" placeholder="请输入密码"/>  
  			     </div>
  			   
  			     	<button  class="login submit btn  " type="submit" >登陆</button>  
  			     
  				</form>
  				 
  			</div>
  			
  		</div>-->
  		
  	</div>
  

  </body >
</html>





















































