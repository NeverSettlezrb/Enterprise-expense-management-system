<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <!DOCTYPE html>
    <input id="updaterolename" type="hidden" value="${rname}" />
  	<h1 align="center">修改信息</h1>
  	<br/><br/><br/>
  	<h1 align="center">-->${rname}<--</h1>
<div style="overflow:auto;width: 330px;height: 50%;opacity:0.75;position: absolute;top: 50%;left: 50%;text-align: center;top: 50%;left: 50%;margin-top: -50px;margin-left: -140px;">
  <form id="updaterolemenu" method="post">
<table style="table-layout: fixed;">
	<tr>
		<td>权限分配:</td>
		<td><input id='mid' name="mid" class='easyui-combobox' required="true" missingMessage="下拉选择需要分配的菜单名称"  editable="false"/></td>
	</tr>
	<tr>		
		<td colspan='3'>
			&nbsp&nbsp&nbsp;<a href="javascript:void(0)" id="submitrolemenu2" class='easyui-linkbutton'data-options="iconCls:'icon-ok'" onclick="submitRoleMenuupdate()">确认提交</a>
		</td>
	</tr>
</table>
</form>
</div>
    
    
    
<script  type="text/javascript">

	$(function(){
		initrolemeun2();
		initupdaterolemeun();
		
	})	
	
	//初始化选择框
	function initrolemeun2(){
		$('#mid').combotree({
			 url : "exmg/getmenu?&fatherid=",
			 multiple:true,
			 cascadeCheck:false
		});
	}
	
	//初始化数据
	function initupdaterolemeun(){
		//alert(data);
		url = "exmg/listroleupdatemenu?rname="+$("#updaterolename").val(),
		$.post(url,function(data){
			//alert(data.mid);
			 var tmp=data.mid;
			 if(tmp!="404没有数据!"){
				 datas = tmp.split(",");
				 //alert(datas.length);
				$('#mid').combotree('setValues', datas);
			 }
		});
	}
	
	//菜单权限赋予
	function submitRoleMenuupdate(){
		var datas = $("#updaterolemenu").serialize();
		if(datas==null||datas==""){
			datas="mid=404没有数据";
		}
		url= "exmg/updaterole_menu?"+datas+"&rname="+$("#updaterolename").val();
		//alert(url);
		$.post(url,function(data){
			//alert(data.result);
			if(data.result==true){
				$.messager.alert("提示","操作成功！");
				initrolecontroldatagrid();
				hideupdatesauthorityWin();
			}else{
				$.messager.alert("提示","操作失败！")
			}
		});
	}



</script>