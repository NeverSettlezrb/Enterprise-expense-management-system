<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
  <table id="mysalDatagrid">
  	<div id="empDatagrid_toolbar1">
  	</div>
  </table>
<script type="text/javascript">


	$(function(){
		initempDatagrid();
	})	
	
	//初始化emp表格
	function initempDatagrid(){
		
		$("#mysalDatagrid").datagrid({
			columns:[[
				{field:"sdata",title:"薪水发放日期",width:160,sortable:true},
				{field:"name",title:"姓名",width:150},
				{field:"sal",title:"工资",width:120,sortable:true},
				{field:"hire",title:"雇用日期",width:160},
			]]
			,rownumbers:true
			,rowStyler: function(index, row) {
	        	return 'background-color:#D3D3D3';
	    	}
			,emptyMsg:'<h2 style="color:red">没有相关记录！</h2>'
			,url:"exmg/listsal?name="+$("#attrs").val()
			,method:"get"
			,toolbar:"#empDatagrid_toolbar1"//添加工具包
			,pagination:true//分页
			,fit:true
			,fitColumns:true//所有列沾满一行
			,singleSelect:true//只能单行选中
			,pageList:[5,10,15]//设置每页记录可选的范围
			,pageSize:5//默认每页记录数
		});
	}
	
	//刷新empDatagrid
	function initEmpdatagrid(){
		$("#mysalDatagrid").datagrid("reload");
	}
</script>











  