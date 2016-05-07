<%@ page language="java" import="java.util.*,com.soft.model.Emp" pageEncoding="UTF-8" %>
<% Emp emp=(Emp)session.getAttribute("emp");
String name=emp.getEmpName();

%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
<HEAD id=Head1>
<TITLE>无标题页</TITLE>
<META http-equiv=Content-Type content="text/html; charset=UTF-8">
<STYLE type=text/css> 
*{
	FONT-SIZE: 12px; COLOR: white
}
#logo {
	COLOR: white
}
#logo A {
	COLOR: white
}
FORM {
	MARGIN: 0px
}
</STYLE>
<SCRIPT src="Top.files/Clock.js" type=text/javascript></SCRIPT>
<META content="MSHTML 6.00.2900.5848" name=GENERATOR>
</HEAD>
<BODY 
style="BACKGROUND-IMAGE: url(images/bg.gif); MARGIN: 0px; BACKGROUND-REPEAT: repeat-x">
<form id="form1">
  <DIV id=logo 
style="BACKGROUND-IMAGE: url(images/logo.png); BACKGROUND-REPEAT: no-repeat">
    <DIV 
style="PADDING-RIGHT: 50px; BACKGROUND-POSITION: right 50%; DISPLAY: block; PADDING-LEFT: 0px; BACKGROUND-IMAGE: url(images/bg_banner_menu.gif); PADDING-BOTTOM: 0px; PADDING-TOP: 3px; BACKGROUND-REPEAT: no-repeat; HEIGHT: 30px; TEXT-ALIGN: right"><A 
"><IMG src="Top.files/mail.gif" 
align=absMiddle border=0></A> 您有新消息 <IMG 
src="Top.files/menu_seprator.gif" align=absMiddle>   <A id=HyperLink3 
href="loginAction_loginOut" target="_parent" >退出系统</A> </DIV>
    <DIV style="DISPLAY: block; HEIGHT: 40px;font-size: 30px; margin-left: 330px;">设备维修管理系统</DIV>
    <DIV 
style="BACKGROUND-IMAGE: url(images/bg_nav.gif); BACKGROUND-REPEAT: repeat-x; HEIGHT: 30px">
      <TABLE cellSpacing=0 cellPadding=0 width="100%">
        <TBODY>
          <TR>
            <TD>
              <DIV><IMG src="Top.files/nav_pre.gif" align=absMiddle> 欢迎  <SPAN id=lblDep>设备维修管理部 [</SPAN> <%=name%> ] 光临  </DIV>
            </TD>
            <TD align=right width="70%"><SPAN style="PADDING-RIGHT: 50px"><A 
      href="javascript:history.go(-1);"><IMG src="Top.files/nav_back.gif" 
      align=absMiddle border=0>后退</A> <A href="javascript:history.go(1);"><IMG 
      src="Top.files/nav_forward.gif" align=absMiddle border=0>前进</A>   <A 
      href="" target=mainFrame><IMG 
      src="Top.files/nav_help.gif" align=absMiddle border=0>帮助</A> <IMG 
      src="Top.files/menu_seprator.gif" align=absMiddle> <SPAN 
      id=clock></SPAN></SPAN></TD>
          </TR>
        </TBODY>
      </TABLE>
    </DIV>
  </DIV>
  <SCRIPT type=text/javascript>
    var clock = new Clock();
    clock.display(document.getElementById("clock"));
</SCRIPT>
</form>
</BODY>
</HTML>
