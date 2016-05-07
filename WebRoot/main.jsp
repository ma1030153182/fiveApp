<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>设备维修管理系统</title>
<link rel="stylesheet" type="text/css"
	href="javascript/themes/bootstrap/easyui.css" />

<link rel="stylesheet" type="text/css" href="javascript/themes/icon.css" />
<link rel="stylesheet" type="text/css"
	href="javascript/bootstrap/css/bootstrap.css" />

<link rel="stylesheet" href="css/main.css" />
<script type="text/javascript" src="javascript/jquery-2.1.3.js"></script>
<script type="text/javascript" src="javascript/jquery.easyui.min.js"></script>
<script type="text/javascript"
	src="javascript/bootstrap/js/bootstrap.js"></script>
<script type="text/javascript" src="javascript/my.js"></script>
<script type="text/javascript" src="javascript/mytreemenu.js"></script>
</head>
<body class="easyui-layout">
	<div data-options="region:'north',border:false"
		style="height:111px;padding: 0px;">
		<!--<%@include file="jsp/top/Top.jsp"%>-->

		<iframe runat="server" src="jsp/top/Top.jsp" width="100%" height="105"
			frameborder="no" border="0" marginwidth="0" marginheight="0"
			scrolling="no" allowtransparency="yes"></iframe>
	</div>
	<div data-options="region:'west',split:true,title:'菜单'"
		style="width:250px;padding:10px;">
		<!--此处为菜单树-->
		<ul id="tree"></ul>
	</div>
	<div
		data-options="region:'east',split:true,collapsed:true,title:'East'"
		style="width:100px;padding:10px;">east region</div>

	<div data-options="region:'center'" style="margin: -16px;">

		<!--此处为右边显示区-->

		<div class="easyui-tabs" style="width:900px;height:400px;"
			, fit="true" border="false" id="tabs"></div>






	</div>
</body>
</htm