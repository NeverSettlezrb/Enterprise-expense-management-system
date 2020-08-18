<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <!DOCTYPE html>
    <div style="overflow:auto;width: 299px;height: 424px;opacity:0.75;position: absolute;top: 50%;left: 50%;text-align: center;top: 50%;left: 50%;margin-top: -200px;margin-left: -150px;">
  <form id="icountdata" method="post">
<table>
  	<tr>
 	 	<h1>个人信息</h1>
  	</tr>
	<tr>
		<td>用户名</td>
		<td><input type="text" id="username" name="username" required="true" class='easyui-textbox' readonly /></td>
	</tr>
	<tr>
		<td>员工ID</td>
		<td><input type="text" id="userid" name="userid" required="true" class='easyui-textbox' readonly /></td>
	</tr>
	<tr>
		<td>姓名</td>
		<td><input type="text" id="name" name="name" class='easyui-textbox' required="true" readonly/></td>
		<td id="messagename"></td>
	</tr>
	<tr>
		<td>年龄</td>
		<td><input type="number" id="age" name="age" class='easyui-textbox' value='' data-options="events:{blur:icheckAge}"/></td>
		<td id="imessageage"></td>
	</tr>
	<tr>
		<td>职位</td>
		<td><input type="check" name="rname" class='easyui-textbox' required="true" readonly /></td>
	</tr>	
	<tr>
		<td>电话</td>
		<td><input type="number" id="phone" name="phone" class='easyui-textbox' value=""  data-options="events:{blur:icheckPhone}"/></td>
		<td id="imessagephone"></td>
	</tr>
	<tr>
		<td>雇用日期</td>
		<td><input type="text" id="hire" name="hire" class='easyui-datebox' readonly/></td>
	</tr>
	<tr>
		<td>性别</td>
		<td><select id="gender" class="easyui-combobox" name="gender" style="width:178px;" editable="false">
		<option>男</option>
    	<option>女</option>
    	</select>
		</td>
	</tr>
	<tr>
		<td>邮箱</td>
		<td><input class="easyui-textbox" type="text" id="email" name="email" data-options="events:{blur:icheckemail}"/></td>
		<td id="imessageemail"></td>
	</tr>
	<tr>
		<td colspan='2'>
			<a href="javascript:void(0)" id="修改个人信息" class='easyui-linkbutton' data-options="iconCls:'icon-edit'" onclick="updateuser()">修改</a>
		</td>
	</tr>
</table>
</form>
</div>

<script  type="text/javascript">

	$(function(){
		inituserDatagrid($("#attrid").val());
	})	
	
	//初始化
	function inituserDatagrid(data){
		//alert(data);
		var url = "exmg/listuserdate?username="+data;
		$('#icountdata').form("load",url); 
	}
	
	//输入验证
	function icheckAge(){
		 var imessageage = document.getElementById("imessageage");
		 var test = $("#insertuserz").serializeArray();
		 $("#age").textbox('setValue', $(this).val()); 
		 var age = $("#age").textbox('getText'); 
		 //alert(age);
		if(age<0){
			imessageage.innerHTML = "请填入合法年龄！";
			$("#imessageage").css("color","red");
		}else if(age==""||age==null){
			$("#age").textbox('setValue', 0);
		}else{
			imessageage.innerHTML = " ";
		}
	}
	function icheckemail(){
		$("#email").textbox('setValue', $(this).val()); 
		 var x = $("#email").textbox('getText'); 
		if(x.charAt(x.length-4) == "." && x.indexOf(".") == x.length-4 && x.lastIndexOf(".") == x.length-4){
			if(x.indexOf("@") == x.length-7 || x.indexOf("@") == x.length-8 && x.lastIndexOf("@") == x.length-7 ||  x.lastIndexOf("@") == x.length-8){
				imessageemail.innerHTML = "可用！";
				$("#imessageemail").css("color","green");
			}else{
				imessageemail.innerHTML = "请填入合法的邮箱！";
				$("#imessageemail").css("color","red");
				// $("#check").val($("#check").val()+1);
			}
		}else if(x==null||x==""){
			imessageemail.innerHTML = " ";
		}else{
			imessageemail.innerHTML = "请填入合法的邮箱！";
			$("#imessageemail").css("color","red");
			 //$("#check").val($("#check").val()+1);
		}
	}
	function icheckPhone(){
		 var imessageage = document.getElementById("imessagephone");
		 //var test = $("#insertuserz").serializeArray();
		 $("#phone").textbox('setValue', $(this).val()); 
		 var phone = $("#phone").textbox('getText'); 
		 if(phone.length!=11){
			 	imessagephone.innerHTML = "请填入合法正确的手机号！";
				$("#imessagephone").css("color","red");
			}else{
			 	imessagephone.innerHTML = " ";
			}
	}
	
	
	//信息修改
	function updateuser(){
		var test = $("#icountdata").serializeArray();
		var datas = $("#icountdata").serialize();
		var url = "exmg/updateuserdate?"+datas;
		//alert(test[3].value);
		if(test[3].value<0){
			$.messager.alert("提示","年龄不能为负哦");
		}else if(test[5].value==null ||test[5].value==""){
			$.messager.alert("提示","请保证有预留电话信息，方便与您联系！");
		}else if(test[8].value==null ||test[8].value==""){
			$.messager.alert("提示","还请预留相关邮箱，方便与您联系！");
		}else if(test[5].value.length<11){
			$.messager.alert("提示","请输入正确的手机号");
		}else if(test[3].value==null ||test[3].value==""){
			$.messager.alert("提示","若需修改信息，请输入年龄！");
		}
		else{
		$.post(url,function(data){
			if(data.result==1){
				$.messager.alert("提示","修改成功");
				//刷新
				inituserDatagrid($("#attrid").val());
			}else{
				$.messager.alert("提示","修改失败");
			}
		});
		}
	}

</script>