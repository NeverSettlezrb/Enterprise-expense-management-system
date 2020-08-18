<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html style="height: 100%;">
<head>
<meta charset="utf-8">
<base href="${pageContext.request.contextPath }/"/>
<title>企业费用管理信息系统</title>
<link rel="stylesheet" type="text/css" href="../css/style.css" /> 
<script type="text/javascript" src="../jquery.min.js"></script>
<link rel="stylesheet" type="text/css" href="../themes/default/easyui.css"/>
<link rel="stylesheet" type="text/css" href="../themes/icon.css"/>
<link rel="stylesheet" type="text/css" href="../themes/bootstrap/easyui.css">
<link rel="stylesheet" type="text/css" href="../themes/default/easyui.css"/>
<script type="text/javascript" src="../jquery.easyui.min.js"></script>
<script type="text/javascript" src="../locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript">

function loginCheck() {
	var username = $("#username").val();
	var password = $("#password").val();
	var test = false;
	if(username==""||password==""){
        alert('用户名或者密码不能为空!');
        return false;
    }
	$.post($("#pageContext").val()+"/exmg/verify?username="+username+"&password="+password,function(data){
		var test = false;
		if(data.verify!=true){
			alert("用户名或密码错误");
		}else{
			window.location.href=$("#pageContext").val()+"/exmg/homepage?usersname="+data.name+"&userid="+data.username+"&userID="+data.userid;
		}
	})
	return test;
}


//关闭修改的window
function hidepasswordWin(){	
	var $win = $("#updatepasswordWin");
	$win.window("close");
	$win.remove();

}
//显示修改的window
function showpasswordWin(empno){
	var $win = $("#updatepasswordWin");
	if($win.length==0){
		$win = $("<div id='updatepasswordWin'></div>");
		$win.appendTo(document.body);
	}
	$win.window({
		title:"修改密码",
		maximizable:false,
		minimizable:false,
		collapsible:false,
		width:660,
		height:560,
		modal:true
		,href:"exmg/setuserpw"
		,method:"post"
	});
	$win.window("center");//居中显示
}
</script>
</head>
<body style="background:#DCDCDC;height: 100%">

<div style="background:#DCDCDC;height: 100%;background:url('../img/背景.jpg') ;opacity:0.90;background-size:100% 100%;">
<br>
<input id="pageContext" type="hidden" value="${pageContext.request.contextPath}" />
<div class="form-div" style="margin:8% auto;background-color:#A9A9A9" >
		<h1 style="color:white;margin:80px auto;padding-left: 100px;">企业费用管理信息系统</h1>
    <!--  <form id="login" action="${pageContext.request.contextPath }/exmg/verify" method="post" onsubmit="return loginCheck(this);"> -->
        <form id="login"  method="post" onsubmit="return loginCheck(this);">
        <table>
            <tr>
                <td>用户名</td>
                <td><input name="username" type="text" id="username" easyform="length:4-16;char-normal;real-time;" message="用户名必须为4—16位的英文字母或数字" easytip="disappear:lost-focus;theme:blue;" ajax-message="用户名已存在!"></td>
            </tr>
            <tr>
                <td>密码</td>
                <td><input name="password" type="password" id="password" easyform="length:6-16;" message="密码必须为6—16位" easytip="disappear:lost-focus;theme:blue;"></td>
            </tr>
        </table>
        
        <div class="buttons">
            
			 <input value="忘记密码" type="button" style="margin-right:45px; margin-top:20px;background-color:#BEBEBE" onclick="showpasswordWin()"/>
			<input value="登录" type="submit" style="margin-right:45px; margin-top:20px;background-color:#BEBEBE" onsubmit="return loginCheck();"/>
        </div>
        <br class="clear">
    </form>
</div>
</div>
</body>
</html>