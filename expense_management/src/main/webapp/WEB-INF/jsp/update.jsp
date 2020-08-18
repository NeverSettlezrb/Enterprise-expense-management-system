<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<form id="updateSalForm">
<h2>最新工资账单</h2>
<table>
	<tr>
		<td>姓名</td>
		<td><input type="text" name="name" class='easyui-textbox' value="${sallist.name }" readonly /></td>
	</tr>	
	<tr>
		<td>用户名</td>
		<td><input type="text" id="username" name="username" required="true" class='easyui-textbox' value="${sallist.username }" readonly/></td>
	</tr>
	<tr>
		<td>雇用日期</td>
		<td><input type="text" id="date2" name="date2" class='easyui-datebox' value="<fmt:formatDate value='${sallist.hire }' pattern='yyyy-MM-dd'/>"/></td>
	</tr>
	<tr>
		<td>工资</td>
		<td><input type="number" name="sal" class='easyui-textbox' value='${sallist.sal }'/></td>
	</tr>
	<tr>
		<td>该笔工资发放日期</td>
		<td><input type="text" id="date1" name="sdate" class='easyui-datebox' value="<fmt:formatDate value='${sallist.sdata }' pattern='yyyy-MM-dd'/>"/></td>
	</tr>
	<tr>
		<td colspan='2'>
			<a href="javascript:void(0)" id="确认修改" class='easyui-linkbutton' data-options="iconCls:'icon-edit'" onclick="updatesal()">确认修改</a>
		</td>
	</tr>
</table>

 
<h2>往期工资账单</h2>
<table>
	<tr>
		<td>工资</td>
		<td><input type="number" id="sall" name="sal1" class='easyui-textbox' value='${presallist.sal }'/></td>
	</tr>
	<tr>
		<td>该笔工资发放日期</td>
		<td><input type="text" id="datess" name="sdate" class='easyui-datebox' value="<fmt:formatDate value='${presallist.sdata }' pattern='yyyy-MM-dd'/>"/></td>
	</tr>
	<tr>
		<td colspan='2'>
			<a href="javascript:void(0)" id="确认修改" class='easyui-linkbutton'data-options="iconCls:'icon-edit'" onclick="preupdatesal()">确认修改</a>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
			<a href="javascript:void(0)" id="取消该工资" class='easyui-linkbutton'data-options="iconCls:'icon-remove'" onclick="preremove()">取消该条工资</a>
		</td>
	</tr>

</table>
<input id="attrs1" type="hidden" value="${sallist.sdata }" />
<!--  <input id="attrs3" type="hidden" value="${presallist.sdata }" />-->
<input id="attrs2" type="hidden" value="${sallist.hire }" />
</form>



<script type="text/javascript">
	//隐藏日期
	$('#date1').datebox({
		disabled:true
	});
	$("#date2").datebox({
		disabled:true
	});
	
	//往期账单根据日期查询工资信息
	$("#datess").datebox({
		onSelect: function(date){
			//var test = $("#updateSalForm").serializeArray();
			//alert(test[3].value);
			var d = new Date(date);
			newdate = d.getFullYear()+'-'+(d.getMonth()+1)+'-'+d.getDate();
			//alert(newdate);
			showUpdateEmpWinDatebox($("#username").val(),newdate);
		}
	});
	
	
	function showUpdateEmpWinDatebox(username,data){
		//动态的设置一个divid属性值updateEmpWin
		var $win = $("#updateEmpWin");
		if($win.length==0){
			//不存在，就新添加到body中
			$win = $("<div id='updateEmpWin'></div>");
			$win.appendTo(document.body);
		}
		//$.ajaxSettings.async = false;
		$win.window({
			title:"修改员工工资",
			maximizable:false,
			minimizable:false,
			collapsible:false,
			width:660,
			height:560,
			modal:true//模式对话框，就时当前对话框不处理，背后的操作不能操作
			,href:"exmg/listsalupdate?username="+username+"&sdata="+data
			,method:"get"
		});
		$win.window("center");//居中显示

	}
	
	
	
	function updatesal(){
		var test = $("#updateSalForm").serializeArray();
		var datas = $("#updateSalForm").serialize();
		
		//alert(datas);
		//alert(test[2].value);
		if(test[2].value==null||test[2].value==""||test[2].value==0){
			$.messager.alert("提示","工资不能为空！")
		}else{
			var url = "exmg/update?sdatas="+$("#date1").val()+"&"+datas+"&presdata=";
			$.post(url,function(data){
				if(data.result){
					//关闭window
					hideUpdateEmpWin();
					//刷新datagrid
					initSetsaldatagrid();	
				}
				$.messager.alert("提示",data.msg);
			});
		}
		
	}
	
	
	function preupdatesal(){
		var test = $("#updateSalForm").serializeArray();
		var datas = $("#updateSalForm").serialize();
		//alert(datas);
		//alert(test[2].value);
		if(test[3].value==null||test[3].value==""||test[3].value==0){
			$.messager.alert("提示","工资不能为空！")
		}else{
			var url = "exmg/preupdate?"+datas+"&presdata=";
			$.post(url,function(data){
				if(data.result){
					//关闭window
					hideUpdateEmpWin();
					//刷新datagrid
					initSetsaldatagrid();	
				}
				$.messager.alert("提示",data.msg)
			});
		}
	}
	
	function preremove(){
		var test = $("#updateSalForm").serializeArray();
		var datas = $("#updateSalForm").serialize();
		//alert(test[4].value);
		//alert(datas);
		var url = "exmg/preremove?"+datas+"&presdata="+test[4].value;
		$.post(url,function(data){
			if(data.result){
				//关闭window
				hideUpdateEmpWin();
				//刷新datagrid
				initSetsaldatagrid();	
			}
			$.messager.alert("提示",data.msg)
		});
	}
	
	
	function isnull(){
		$("#sall").hide();
	}
	
</script>