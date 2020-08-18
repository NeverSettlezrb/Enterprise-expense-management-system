<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <!DOCTYPE html>
    <input id="times0" type="hidden" value="60" />
<input id="times" type="hidden" value="" />
    <input id="logincount" type="hidden" value="" />
    <div style="overflow:auto;width: 330px;height: 424px;opacity:0.75;position: absolute;top: 50%;left: 50%;text-align: center;top: 50%;left: 50%;margin-top: -200px;margin-left: -150px;">
  <form id="loginemail" method="post" style="margin-top: 100px;">
<table>
  	<tr>
 	 	<h1>忘记密码，邮箱一键登录</h1>
 	</tr>
 	<tr>
		<td>用户名</td>
		<td><input type="text" id="username" name="username" required="true" class='easyui-textbox' value="${sessionScope.userid }" missingMessage="账户名至少需要6位！"/></td>
		<td id="message4"></td>
	</tr>
	<tr>
		<td>邮箱</td>
		<td><input class="easyui-textbox" type="text" id="email" name="email" data-options="validType:'email'"/>
		</td>
		<td>
        	<button id="btnGetVcode" style="cursor:pointer;width: 83px;font-size: 1px;" onclick="getvcode()">获取验证码</button>
        </td>
	</tr>
	<tr>
		<td >验证码</td>
        <td>
        	<input type="text" name="vcodes" id="vcodes" class='easyui-textbox'  
        	placeholder="输入验证码"   missingMessage="请查询邮件是否收到，并且填写验证码" data-options="events:{blur:logincheckVerify}"/>
        </td>
        <td id="loginmessage"></td>
	</tr>
	<tr>
		<td colspan='2'>
			<a href="javascript:void(0)" id="修改个人信息" class='easyui-linkbutton' data-options="iconCls:'icon-ok'"  onclick="loginUser_Pw()">登录</a>
		</td>
	</tr>
	</table>
</form>
</div>

<script  type="text/javascript">

	$(function(){
		window.onload = numberInputPlaceholder2();
	})	

	
	//显示提示条
	function numberInputPlaceholder2(){
		$("#vcodes").each(function(i){
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
	var m;  

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
						useChangeBTN2();  // 控制下一次重新获取验证码
					}
				},
				error:function(msg){
				}
			});
		}
	//})
	
	
	//控制验证码重新获取
	function changeBTN2(){
		if($("#times").val() > 0){
			var btnGet = document.getElementById("btnGetVcode");
			btnGet.disabled = true;
			$("#btnGetVcode").text("（"+$("#times").val()+"s）"+"重新获取");
			$("#times").val($("#times").val()-1);
		}
		else{
			var btnGet = document.getElementById("btnGetVcode");
			btnGet.disabled = false;
			$("#btnGetVcode").text("获取验证码");
			clearInterval(m);
			$("#times").val($("#times0").val());
		}
	}
	//重新获取验证码
	function useChangeBTN2(){
		$("#btnGetVcode").text("("+$("#time").val()+"s)"+"重新获取");
		$("#times").val($("#times").val()-1);
		m = setInterval("changeBTN2()", 1000);  // 1s调用一次
	}
	
		// 验证验证码
		function logincheckVerify(){
				$("#vcodes").textbox('setValue', $(this).val()); 
				var vcodes = $("#vcodes").textbox('getText'); 
				var message = document.getElementById("loginmessage");  // 显示提示信息
				if(vcodes==null||vcodes==""){
					
				}else{
				$.ajax({
					url: 'EmailServlet?method=verify',
					type: 'post',
					data: {vcode: vcodes},
					dataType: 'text',
					success: function(msg) {
						if(msg == 1){
							loginmessage.innerHTML = "验证码正确！";
							//countconcat();
							$("#loginmessage").css("color","green");
							$("#logincount").val(1);
						}
						else{
							loginmessage.innerHTML = "验证码错误！";
							$("#loginmessage").css("color","red");
							$("#logincount").val(0);
						}
					},
					error:function(msg){
					}
				});
				}
			}
	
	
	//信息修改
	function loginUser_Pw(){
		var test = $("#loginemail").serializeArray()
		var datas = $("#loginemail").serialize();
		var url = "exmg/updateuserdate?"+datas;
		//alert(test[1].value);
		if(test[0].value==0){
			$.messager.alert("提示","请输入用户名");
		}else if(test[2].value==0){
			$.messager.alert("提示","请输入验证码");
		}else if($("#logincount").val()==0){
			$.messager.alert("提示","验证码错误");
		}else{
			//alert("信息正确！");
			var url= "exmg/login_email?"+datas;
			//alert(url);
			$.post(url,function(data){
				var test = false;
				if(data.verify!=true){
					alert("用户名或邮箱错误");
				}else{
					window.location.href=$("#pageContext").val()+"/exmg/homepage?usersname="+data.name+"&userid="+data.username+"&userID="+data.userid;
				}
 			});
		}
		
	}	
	
</script>