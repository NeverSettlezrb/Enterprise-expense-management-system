<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
  <table id="caiwuallreportDatagrid">
  	<div id="caiwuallreportDatagrid_toolbar1">
  	</div>
  </table>
<script type="text/javascript">


	$(function(){
		initcaiwuallreportDatagrid();
	})	
	
	//初始化emp表格
	function initcaiwuallreportDatagrid(){
		
		$("#caiwuallreportDatagrid").datagrid({
			columns:[[
				{field:"userid",title:"员工ID",width:80,align : 'center'},
				{field:"name",title:"姓名",width:60,align : 'center'},
				{field:"money",title:"报销金额",width:120,align : 'center'},
				{field:"tips",title:"报销原因",width:300,align : 'center'},
				{field:"redate",title:"报销日期",width:160,align : 'center'},
				{field:"caiwu",title:"操作",width:160,align : 'center',
	  	                formatter : function(value,row,index){
	  	                	var reid = row.reid;
		                    return "<a class='shenpi' href='javascript:void(0)' onclick='updatesreportWin(\""+reid+"\"\,\""+1+"\")'>审批</a>&nbsp&nbsp;"+
							"<a class='bohui' href='javascript:void(0)' onclick='updatesreportWin(\""+reid+"\"\,\""+2+"\")'>驳回</a>"       
		                  }},
			]]
			, onLoadSuccess:function (data) {
                $(".shenpi").linkbutton({plain:true, iconCls:'icon-mini-edit' });
                $(".bohui").linkbutton({plain:true, iconCls:'icon-undo' });
        	}
			,rownumbers:true
			,rowStyler: function(index, row) {
	        	return 'background-color:#D3D3D3';
	    	}
			,emptyMsg:'<h2 style="color:red">没有申请待批！</h2>'
			,url:"exmg/listcaireport?username="
			,method:"get"
			,toolbar:"#caiwuallreportDatagrid_toolbar1"//添加工具包
			,pagination:true//分页
			,fit:true
			,fitColumns:true//所有列沾满一行
			,singleSelect:true//只能单行选中
			,pageList:[5,10,15]//设置每页记录可选的范围
			,pageSize:5//默认每页记录数
		});
	}
	
	//刷新empDatagrid
	function initcaiwuAllReportdatagrid(){
		$("#caiwuallreportDatagrid").datagrid("reload");
	}
	
	function updatesreportWin(data,caozuo){
		//alert(data);
		url="exmg/caicheckreport?reid="+data+"&caiwu="+caozuo;
		$.post(url,function(data){
			 if(data){
				 if(data.result){
					 	$.messager.alert("提示",data.msg);
					 	initcaiwuAllReportdatagrid();
	 				}else{	
	 					$.messager.alert("提示",data.msg);
	 				}
		 	}
		});
	}

</script>











  