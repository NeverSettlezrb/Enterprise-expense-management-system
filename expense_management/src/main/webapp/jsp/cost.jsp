<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <!DOCTYPE html>
    <div style="overflow:auto;width: 299px;height: 424px;opacity:0.75;position: absolute;top: 50%;left: 50%;text-align: center;top: 50%;left: 50%;margin-top: -200px;margin-left: -150px;">
  <form id="baoxiao" method="post">
<table>
  	<tr>
 	 	<h1>报销单</h1>
  	</tr>

	<tr>
		<td>报销金额</td>
		<td><input type="number" id="money" name="money" class='easyui-textbox' value='' /></td>
		<td id="messagemoney"></td>
	</tr>
	
	<tr>
		<td>报销原因</td>
		<td><input class="easyui-textbox" id="tips" name="tips" data-options="multiline:true" style="height:100px"></td>
		<td id="messageetips"></td>
	</tr>
	<tr>
		<td colspan='2'>
			<a href="javascript:void(0)" id="修改个人信息" class='easyui-linkbutton' data-options="iconCls:'icon-ok'" style="margin-left: 40px;" onclick="submitapply()">确定申请</a>
		</td>
	</tr>
</table>
</form>
</div>

<script  type="text/javascript">
	function submitapply(){
		var datas = $("#baoxiao").serialize();
		var myDate = new Date();
		var time=myDate.getFullYear()+"-"+myDate.getMonth()+"-"+myDate.getDate();
		var url = "exmg/applyreport?"+datas+"&redate="+time+"&username="+$("#attrid").val();
		//alert(url);
		if($('#money').textbox('getValue')==null||$('#money').textbox('getValue')==""){
			$.messager.alert("提示","请填写报销金额哦！");
		}else if($('#money').textbox('getValue')==null||$('#tips').textbox('getValue')==""){
			$.messager.alert("提示","请填写报销原因哦！");
		}else{
			$.post(url,function(data){
				 if(data){
					 if(data.result){
						 $.messager.alert("提示",data.msg);
		 				}else{	
		 				$.messager.alert("提示",data.msg);
		 				}
			 	}
			});
		}
	}


</script>