<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <!DOCTYPE html>
    <input id="countdept" type="hidden" value="" />
    <input id="check" type="hidden" value="0" />
    <div style="overflow:auto;width: 330px;height: 424px;opacity:0.75;position: absolute;top: 50%;left: 50%;text-align: center;top: 50%;left: 50%;margin-top: -200px;margin-left: -150px;">
  <form id="insertuserz" method="post">
<table>
  	<tr>
 	 	<h1>新加员工</h1>
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
		<td><input type="number" name="age" id="age" class='easyui-textbox' value='' data-options="events:{blur:checkAge}"/></td>
		<td id="messageage"></td>
	</tr>
	<tr>
		<td>手机号</td>
		<td><input type=number id="phone" name="phone" missingMessage="请填写11位手机号"  class='easyui-textbox' data-options="events:{blur:checkPhone}"/></td>
		<td id="messagephone"></td>
	</tr>
	<tr>
		<td>邮箱</td>
		<td><input type=text id="email" name="email"  missingMessage="请填写邮箱"  class='easyui-textbox' data-options="events:{blur:checkemail}"/></td>
		<td id="messageemail"></td>
	</tr>
	<tr>
		<td>部门分配</td>
		<td><input  id="dept" name="dept" class='easyui-combobox' required="true"  data-options="events:{blur:createUserId}" editable="false"/></td>
		<td id="messageid"></td>
	</tr>		
	<tr>
		<td>职位赋权</td>
		<td><input  id="rname" name="rname" class='easyui-combobox' required="true" missingMessage="请选择职位"  editable="false"/></td>
	</tr>
	<tr>
		<td>员工ID</td>
		<td><input type="text" name="userid" id="userid" class='easyui-textbox' required="true" missingMessage="点击部门生成id" readonly /></td>
	</tr>
	<tr>
		<td colspan='3'>
			<a href="javascript:void(0)" id="确认添加" class='easyui-linkbutton'data-options="iconCls:'icon-ok'" onclick="insertUserNew()">确认添加人员</a>
		</td>
	</tr>
</table>
</form>
</div>

<script  type="text/javascript">
	$(function(){
		initrname();
		$("#age").textbox('setValue', 0);
	})	

	//职位下拉
	function initrname(){	
		$('#rname').combobox({
	   		url:'exmg/listrname',
	   		multiple:true,
	    	valueField:'rid',
	    	textField:'rname',
	    	onLoadSuccess:function(){
	    		$('#rname').combobox('select', '4');
	    	}
		});
		$('#dept').combobox({
	   		url:'exmg/listdept',
	    	valueField:'deptno',
	    	textField:'deptname'
		});
	}
	//自动生成id
	function createUserId(){
		 var messageid = document.getElementById("messageid"); 
		 var deptno = $('#dept').combobox('getValue');
		 var deptnotostring="";
		 if(deptno==null||deptno==""){
			 
		 }else{
		 $.ajaxSettings.async = false;
		 $.post("exmg/countdeptno?deptno="+deptno,function(data){
			 var da = data.count+1;
			 //alert(da.toString().length);
			 if(da.toString().length==1){
				$("#countdept").val("00"+(data.count+1).toString());
			 }else if(da.toString().length==2){
				$("#countdept").val("0"+(data.count+1).toString());
			 }else if(da.toString().length==3){
				$("#countdept").val((data.count+1).toString());
			 }
		 });
		 
		 if(deptno.length==1){
			 deptnotostring =  "0"+deptno;
		 }else if(deptno.length==2){
			 deptnotostring =  deptno;
		 }
		 //alert($("#countdept").val());
		 //alert("120"+deptnotostring+$("#countdept").val());
		 var result= "120"+deptnotostring+$("#countdept").val();	 
		 $("#check").val($("#check").val()+1);
		 $('#userid').textbox('setValue',result);
		 }	 
	}
	
	function checkAge(){
		 var messageage = document.getElementById("messageage");
		 var test = $("#insertuserz").serializeArray();
		 $("#age").textbox('setValue', $(this).val()); 
		 var age = $("#age").textbox('getText'); 
		 //alert(age);
		if(age<0){
			messageage.innerHTML = "请填入合法年龄！";
			$("#messageage").css("color","red");
		}else if(age==""||age==null){
			$("#age").textbox('setValue', 0);
		}else{
			messageage.innerHTML = " ";
		}
	}
	function checkemail(){
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
	
	function checkPhone(){
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
	
	//插入人员
	function insertUserNew(){
		var datas = $("#insertuserz").serialize();
		var myDate = new Date();
		var time=myDate.getFullYear()+"-"+myDate.getMonth()+"-"+myDate.getDate();
		var url = "exmg/insertusernew?"+datas+"&hire="+time;
		//alert(url);
		if($('#rname').combobox('getValue')==null||$('#rname').combobox('getValue')==""){
			$.messager.alert("提示","请选择一个职位！");
		}else{
			if($("#check").val()=="01"){
			$.ajaxSettings.async = false;
			$.post(url,function(data){
				 if(data){
					 if(data.result){
						 hideInsertUserWin();	
						 initupdateuserdatagrid();
		 				}
		 				$.messager.alert("提示",data.msg);
			 	}
			});
			}else{
				$.messager.alert("提示","至少需要一个部门信息！");
			}
		}
	}
</script>