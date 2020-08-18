<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <!DOCTYPE html>
    <input id="rolename" type="hidden" value="${rname}" />
    <h2>你已经成功添加&nbsp&nbsp;---|${rname}|---&nbsp&nbsp;这一角色</h2>
     <br />
    <h2>第二步:请为该角色赋予菜单权限！</h2>
<div style="overflow:auto;width: 330px;height: 50%;opacity:0.75;position: absolute;top: 50%;left: 50%;text-align: center;top: 50%;left: 50%;margin-top: -50px;margin-left: -160px;">
  <form id="rolemenu" method="post">
<table>
	<tr>
		<td>权限分配:</td>
		<td><input id='rolemenuselect' name="rolemenuselect"  required="true" missingMessage="下拉选择需要分配的菜单名称"  editable="false"/></td>
	</tr>
	<tr>		
		<td colspan='3'>
			&nbsp&nbsp&nbsp;<a href="javascript:void(0)" id="submitrolemenu" class='easyui-linkbutton'data-options="iconCls:'icon-ok'" onclick="submitRoleMenu()">确认提交</a>
		</td>
	</tr>
</table>
</form>
</div>
    
    
    
<script  type="text/javascript">

	$(function(){
		initrolemeun();
	})	
	
	//初始化选择框
	function initrolemeun(){
		$('#rolemenuselect').combotree({
			 url : "exmg/getmenu?&fatherid=",
			 multiple:true,
			 cascadeCheck:false
		});
	}
	
	//菜单权限赋予
	function submitRoleMenu(){
		var datas = $("#rolemenu").serialize();
		url= "exmg/insertrole_menu?"+datas+"&rname="+$("#rolename").val();
		//alert(url);
		if(datas==""||datas==null){
			$.messager.alert("提示","还没有分配菜单权限哦，无法提交！")
		}else{
		$.post(url,function(data){
			if(data.result==true){
				$.messager.alert("提示","操作成功！");
				initrolecontroldatagrid();
				hideinsertroleWin();
			}else{
				$.messager.alert("提示","操作失败！")
			}
		});
		}
	}



</script>