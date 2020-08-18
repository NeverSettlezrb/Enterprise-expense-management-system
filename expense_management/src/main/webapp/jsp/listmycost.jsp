<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
  <table id="myreportDatagrid">
  	<div id="myreportDatagrid_toolbar1">
  	</div>
  </table>
<script type="text/javascript">


	$(function(){
		initmyreportDatagrid();
	})	
	
	//初始化emp表格
	function initmyreportDatagrid(){
		
		$("#myreportDatagrid").datagrid({
			columns:[[
				{field:"userid",title:"员工ID",width:80,align : 'center'},
				{field:"name",title:"姓名",width:60,align : 'center'},
				{field:"money",title:"报销金额",width:120,align : 'center'},
				{field:"tips",title:"报销原因",width:300,align : 'center'},
				{field:"redate",title:"报销日期",width:160,align : 'center'},
				 {field:"finallys",title:"状态",width:160,align : 'center',
  	                formatter : function(value,row,index){
	                    if(value=='0'){return '<b style="color:blue">'+'审核中...请耐心等待'+'</b>'}  
	                    else if(value=='1'){
	                    return '<b style="color:green">'+'已通过！'+'</b>';
	                    }else if(value=='2'){
		                    return '<b style="color:red">'+'不通过！'+'</b>'
	                    }
	                  }},
			]]
			,rownumbers:true
			,rowStyler: function(index, row) {
	        	return 'background-color:#D3D3D3';
	    	}
			,emptyMsg:'<h2 style="color:red">没有相关记录！</h2>'
			,url:"exmg/listreport?username="+$("#attrid").val()
			,method:"get"
			,toolbar:"#myreportDatagrid_toolbar1"//添加工具包
			,pagination:true//分页
			,fit:true
			,fitColumns:true//所有列沾满一行
			,singleSelect:true//只能单行选中
			,pageList:[5,10,15]//设置每页记录可选的范围
			,pageSize:5//默认每页记录数
		});
	}
	
	//刷新empDatagrid
	function initMyReportdatagrid(){
		$("#myreportDatagrid").datagrid("reload");
	}
</script>











  