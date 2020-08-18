<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <!DOCTYPE html>
    <input id="usernameid" type="hidden" value="${username}" />
     <input id="countdeptupdate" type="hidden" value="" />
    <div style="overflow:auto;width: 330px;height: 424px;opacity:0.75;position: absolute;top: 50%;left: 50%;text-align: center;top: 50%;left: 50%;margin-top: -200px;margin-left: -150px;">
  <form id="updatesuser" method="post">
<table>
  	<tr>
 	 	<h1>修改信息</h1>
  	</tr>
	<tr>
		<td>员工ID</td>
		<td><input type="text" name="userid" id="userid" class='easyui-textbox' required="true" missingMessage="点击生成id" readonly /></td>
	</tr>
	<tr>
		<td>用户名</td>
		<td><input type="text" id="username" name="username" class='easyui-textbox'  missingMessage="请输入用户名"  /></td>
		<td id="message4"></td>
	</tr>
	<tr>
		<td>姓名</td>
		<td><input type="text" id="name" name="name" class='easyui-textbox'  missingMessage="请输入真实姓名"  /></td>
		<td id="message4"></td>
	</tr>
	<tr>
		<td>性别</td>
		<td><select id="gender" class="easyui-combobox" name="gender" style="width:178px;" editable="false" >
		<option>男</option>
    	<option>女</option>
    	</select>
		</td>
	</tr>
	<tr>
		<td>年龄</td>
		<td><input type="number" name="age" id="age" class='easyui-textbox' value='' data-options="events:{blur:updatecheckAge}"/></td>
		<td id="messageages"></td>
	</tr>
	<tr>
		<td>手机号</td>
		<td><input type=number id="phone" name="phone" missingMessage="请填写11位手机号"  class='easyui-textbox' data-options="events:{blur:updatecheckPhone}"/></td>
		<td id="messagephone"></td>
	</tr>
	<tr>
		<td>邮箱</td>
		<td><input type=text id="email" name="email"  missingMessage="请填写邮箱"  class='easyui-textbox' data-options="events:{blur:updatecheckemail}"/></td>
		<td id="messageemail"></td>
	</tr>
	<tr>
		<td>部门分配</td>
		<td><input id="deptno" name="deptno" class='easyui-combobox' required="true"  editable="false"/></td>
		<td id="messageid"></td>
	</tr>		
	<tr>
		<td>职位赋权</td>
		<td><input id="rid" name="rid" class='easyui-combobox' required="true"  editable="false"/></td>
	</tr>
	<tr>
		<td colspan='3'>
			<a href="javascript:void(0)" id="密码重置" class='easyui-linkbutton'data-options="iconCls:'icon-reload'" onclick="updatepassword()">密码重置</a>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp;
			<a href="javascript:void(0)" id="确认添加" class='easyui-linkbutton'data-options="iconCls:'icon-ok'" onclick="updateuser()">确认修改人员</a>
		</td>
	</tr>
</table>
</form>
</div>

<script  type="text/javascript">
	$(function(){
		updatername();
		initupdateuserDatagrid($("#usernameid").val());
	})	
	
	//初始化
	function initupdateuserDatagrid(data){
		//alert(data);
		var url = "exmg/updatesusers?username="+data;
		$('#updatesuser').form("load",url); 
	}
	
	
	//职位下拉
	function updatername(){	
		$('#rid').combobox({
	   		url:'exmg/listrname',
	   		multiple:true,
	    	valueField:'rid',
	    	textField:'rname',
		});
		$('#deptno').combobox({
	   		url:'exmg/listdept',
	    	valueField:'deptno',
	    	textField:'deptname'
		});
	}
	
	//输入验证
	function updatecheckAge(){
		 var messageages = document.getElementById("messageages");
		 var test = $("#insertuserz").serializeArray();
		 $("#age").textbox('setValue', $(this).val()); 
		 var age = $("#age").textbox('getText'); 
		 //alert(age);
		if(age<0){
			messageages.innerHTML = "请填入合法年龄！";
			$("#messageages").css("color","red");
		}else if(age==""||age==null){
			$("#age").textbox('setValue', 0);
		}else{
			messageages.innerHTML = " ";
		}
	}
	function updatecheckemail(){
		$("#email").textbox('setValue', $(this).val()); 
		 var x = $("#email").textbox('getText'); 
		if(x.charAt(x.length-4) == "." && x.indexOf(".") == x.length-4 && x.lastIndexOf(".") == x.length-4){
			if(x.indexOf("@") == x.length-7 || x.indexOf("@") == x.length-8 && x.lastIndexOf("@") == x.length-7 ||  x.lastIndexOf("@") == x.length-8){
				messageemail.innerHTML = "可用！";
				$("#messageemail").css("color","green");
			}else{
				messageemail.innerHTML = "请填入合法的邮箱！";
				$("#messageemail").css("color","red");
				 $("#check").val($("#check").val()+1);
			}
		}else if(x==null||x==""){
			messageemail.innerHTML = " ";
		}else{
			messageemail.innerHTML = "请填入合法的邮箱！";
			$("#messageemail").css("color","red");
			 $("#check").val($("#check").val()+1);
		}
	}
	function updatecheckPhone(){
		 var messageage = document.getElementById("messagephone");
		 var test = $("#insertuserz").serializeArray();
		 $("#phone").textbox('setValue', $(this).val()); 
		 var phone = $("#phone").textbox('getText'); 
		 if(phone.length!=11){
			 	messagephone.innerHTML = "请填入合法正确的手机号！";
				$("#messagephone").css("color","red");
			}else{
			 	messagephone.innerHTML = " ";
			}
	}



	//提交修改
	function updateuser(){
		var datas = $("#updatesuser").serialize();
		//var questionType = $("#rnames").combobox("getValues");
		//alert(datas);
		var url = "exmg/updateusersmsg?"+datas+"&updatepassword=0";
		//alert(url);
		if($('#rid').combobox('getValue')==null||$('#rid').combobox('getValue')==""){
			$.messager.alert("提示","请选择一个职位,再修改！");
		}else{
			$.post(url,function(data){
				if(data.result==1){
					$.messager.alert("提示","修改成功");
					//刷新
					hideupdatesUserWin();
					initupdateuserdatagrid();
				}else{
					$.messager.alert("提示","修改失败");
				}
			});
		}
	}
	
	//密码重置
	function updatepassword(){
		var datas = $("#updatesuser").serialize();
		var url = "exmg/updateusersmsgpassw?"+datas;
			$.post(url,function(data){
				if(data){
					$.messager.alert("提示","该用户密码已重置！");
					//刷新
					hideupdatesUserWin();
					initupdateuserdatagrid();
				}else{
				$.messager.alert("提示","操作失败！");
			}
			});
	}
</script>