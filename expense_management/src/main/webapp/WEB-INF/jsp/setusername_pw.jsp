<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <!DOCTYPE html>
    <input id="attrids" type="hidden" value="" />
    <input id="setusername" type="hidden" value="1" />
    <input id="passwordcount" type="hidden" value="" />
    <input id="passwordcount2" type="hidden" value="" />
    <input id="updateuserspassword" type="hidden" value="${sessionScope.userid }" />
    <div style="overflow:auto;width: 330px;height: 424px;opacity:0.75;position: absolute;top: 50%;left: 50%;text-align: center;top: 50%;left: 50%;margin-top: -200px;margin-left: -150px;">
  <form id="userpassdata" method="post">
<table>
  	<tr>
 	 	<h1>账户与密码设置</h1>
  	</tr>
	<tr>
		<td>员工ID</td>
		<td><input type="text" name="userid" class='easyui-textbox' required="true" readonly/></td>
	</tr>
	<tr>
		<td>用户名</td>
		<td><input type="text" id="username" name="username" required="true" class='easyui-textbox' value="${sessionScope.userid }" missingMessage="账户名至少需要6位！"  data-options="events:{blur:checkPassword3}"/></td>
		<td id="message4"></td>
	</tr>
	<tr>
		<td>新密码</td>
		<td><input type="password" id="password1" name="password" required="true" missingMessage="请填写密码"  class='easyui-textbox'  data-options="events:{blur:checkPassword2}" /></td>
		<td id="message3"></td>
	</tr>
	<tr>
		<td>再次输入密码</td>
		<td><input type="password" id="password2" name="password" required="true" class='easyui-textbox' missingMessage="再次输入密码"  data-options="events:{blur:checkPassword}" /></td>
		<td id="message2"></td>
	</tr>
	<tr>
		<td>邮箱</td>
		<td><input class="easyui-textbox" type="text" name="email" data-options="validType:'email'" readonly/>
		</td>
		<td>
        	<button id="btnGetVcode" style="cursor:pointer;width: 83px;font-size: 1px;" onclick="getvcode()">获取验证码</button>
        </td>
	</tr>
	<tr>
		<td >验证码</td>
        <td>
        	<input type="text" name="vcode" id="vcode" required="true" class='easyui-textbox'  
        	placeholder="输入验证码"   missingMessage="请查询邮件是否收到，并且填写验证码" data-options="events:{blur:checkVerify}"/>
        </td>
        <td id="message"></td>
	</tr>
	<tr>
		<td colspan='2'>
			<a href="javascript:void(0)" id="修改个人信息" class='easyui-linkbutton' data-options="iconCls:'icon-edit'"  onclick="updateUser_Pw()">确认修改</a>
		</td>
	</tr>
</table>
</form>
</div>

<script  type="text/javascript">

	$(function(){
		inituserDatagrid($("#attrid").val());
		window.onload = numberInputPlaceholder();
	})	

	//初始化
	function inituserDatagrid(data){
		var url = "exmg/listuserdate?username="+data;
		//alert(url);
		$('#userpassdata').form("load",url); 
	}
	
	//显示提示条
	function numberInputPlaceholder(){
		$("#vcode").each(function(i){
			var span = $(this).siblings("span")[0];
			var targetInput = $(span).find("input:first");
			//alert(targetInput.val(s));
		if(targetInput){
			$(targetInput).attr("placeholder", $(this).attr("placeholder"));
		}

		});
	}
	
	//获取验证码
	//var time0 = 60;
	//var time = time0;  
	var t;  
	// 用于验证按钮的60s计时
	//$(document).ready(function() {
		// 获取验证码按钮
		//$("#btnGetVcode").click(function() {
			function getvcode(){
			var btnGet = document.getElementById("btnGetVcode");
			btnGet.disabled = true;  // 为了防止多次点击
			$.ajax({
				url: 'EmailServlet?method=getVCode',
				type: 'post',
				data: {email: $("input[name='email']").val()},
				dataType: 'text',
				success: function(msg) {
					if(msg == -1){
						window.alert("请输入正确的邮箱！");
						btnGet.disabled = false;
					}
					else{
						useChangeBTN();  // 控制下一次重新获取验证码
					}
				},
				error:function(msg){
				}
			});
		}
	//})
	
	
	//控制验证码重新获取
	function changeBTN(){
		if($("#time").val() > 0){
			var btnGet = document.getElementById("btnGetVcode");
			btnGet.disabled = true;
			$("#btnGetVcode").text("（"+$("#time").val()+"s）"+"重新获取");
			$("#time").val($("#time").val()-1);
		}
		else{
			var btnGet = document.getElementById("btnGetVcode");
			btnGet.disabled = false;
			$("#btnGetVcode").text("获取验证码");
			clearInterval(t);
			$("#time").val($("#time0").val());
		}
	}
	//重新获取验证码
	function useChangeBTN(){
		$("#btnGetVcode").text("("+$("#time").val()+"s)"+"重新获取");
		$("#time").val($("#time").val()-1);
		t = setInterval("changeBTN()", 1000);  // 1s调用一次
	}
	
		// 验证验证码
		function checkVerify(){
				$("#vcode").textbox('setValue', $(this).val()); 
				var vcodes = $("#vcode").textbox('getText'); 
				var message = document.getElementById("message");  // 显示提示信息
				if(vcodes==null||vcodes==""){
					
				}else{
				$.ajax({
					url: 'EmailServlet?method=verify',
					type: 'post',
					data: {vcode: vcodes},
					dataType: 'text',
					success: function(msg) {
						if(msg == 1){
							message.innerHTML = "验证码正确！";
							//countconcat();
							$("#message").css("color","green");
							$("#attrids").val(1);
						}
						else{
							message.innerHTML = "验证码错误！";
							$("#message").css("color","red");
							$("#attrids").val(0);
						}
					},
					error:function(msg){
					}
				});
				}
			}
	
	
	
	
	
	//var passwordcount =0;
	//验证密码账户名
	function checkPassword(){
		//给文本框赋值
		$("#password2").textbox('setValue', $(this).val()); 
		var password2 = $("#password2").textbox('getText'); 
		var password1= $("#password1").val();
		//alert(password2);
		if(password1==null||password1==""){
			
		}else if(password2!=password1){
			message2.innerHTML = "两次密码输入不一致！";
			$("#message2").css("color","red");
			$("#passwordcount2").val(0);
		}else{
			message2.innerHTML = "密码一致！";
			$("#message2").css("color","green");
			$("#passwordcount2").val(1);
			$("#passwordcount").val(1);
		}
	}
	function checkPassword2(){
		//给文本框赋值
		$("#password1").textbox('setValue', $(this).val()); 
		var password1 = $("#password1").textbox('getText'); 
		
		var password2= $("#password2").val();
		//alert(password2);
		if(password1==null||password1==""){
			
		}if(password1.length<6){
			message3.innerHTML = "密码太短咯，至少6位！";
			$("#message3").css("color","red");
		}else if(password2!=password1){
			message2.innerHTML = "两次密码输入不一致！";
			$("#message2").css("color","red");
			$("#passwordcount").val(0);
		}else{
			message3.innerHTML = "密码一致！";
			$("#message3").css("color","green");
			$("#passwordcount").val(1);
		}
		if(password1.length>=6){
			if(password2==password1){
				message2.innerHTML = "密码一致！";
				$("#message2").css("color","green");
				$("#passwordcount").val(1);
			}
			message3.innerHTML = "密码可用！";
			$("#message3").css("color","green");
		}
	}
	function checkPassword3(){
		//给文本框赋值
		$("#username").textbox('setValue', $(this).val()); 
		var username = $("#username").textbox('getText'); 
		//alert(username);
		if(username==null||username==""){
			message4.innerHTML = "请输入用户名！";
			$("#message4").css("color","red");
		}if(username.length<6){
			message4.innerHTML = "用户名太短，至少6位！";
			$("#message4").css("color","red");
		}else if(username.length>=6){
			var url = "exmg/finduserdate?username="+username;
			//alert(url);
			$.get(url,function(data){
				//alert($("#username").val());
				if(data.usernameresult==0){
					message4.innerHTML = "用户名可用！";
					$("#message4").css("color","green");
					$("#setusername").val(1);
				}else if(data.username==$("#attrid").val()){
					message4.innerHTML = "用户名可用！";
					$("#message4").css("color","green");
					$("#setusername").val(1);
				}else{
					message4.innerHTML = "用户重复，请换一个！";
					$("#message4").css("color","red");
					$("#setusername").val(0);
				}
		});
			
		
		
	}
	}

	
	//信息修改
	function updateUser_Pw(){
		var test = $("#userpassdata").serializeArray()
		var datas = $("#userpassdata").serialize();
		var url = "exmg/updateuserdate?"+datas;
		
		if($("#setusername").val()==0){
			$.messager.alert("提示","用户名重复！");
		}else if(test[0].value==""||test[0].value==null ){
			$.messager.alert("提示","用户名为空！");
		}else if(test[3].value==""||test[3].value==null || test[2].value==""||test[2].value==null){
			$.messager.alert("提示","请输入密码！");
		}else if($("#passwordcount").val()==0||$("#passwordcount2").val()==0){
			$.messager.alert("提示","两次输入密码不一致！");
		}else if(test[0].value.length<6){
			$.messager.alert("提示","用户名太短，至少6位!");
		}else if(test[3].value.length<6){
			$.messager.alert("提示","密码太短咯，再改改哦~");
		}else if($("#attrids").val()==0){
			$.messager.alert("提示","请输入正确的验证码！");
		}else{
			//alert("信息正确！");
			var url= "exmg/updateuser_pw?username="+test[1].value+"&password="+test[3].value+"&userid="+test[0].value;
			$("#updateuserspassword").val(test[1].value);
			$.get(url,function(data){
 				if(data.result){
 					$("#attrid").val($("#updateuserspassword").val());
 					hideUserSetWin();	
 				}
 				$.messager.alert("提示",data.msg);
 			});
		}
		
	}	
	
</script>